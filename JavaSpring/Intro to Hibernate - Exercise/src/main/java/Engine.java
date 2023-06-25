import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Select exercise number:");
        int exerciseNumber;
        try {
            exerciseNumber = Integer.parseInt(bufferedReader.readLine());
switch (exerciseNumber){
    case 2: exerciseTwoChangeCasing();
    case 3: exerciseThreeContainsEmployee();
    case 4: exerciseFourSalaryOver50K();
    case 5: exerciseFiveEmployeesFromDepartment();
    case 6: exerciseSixNewAddressAndEmployeeUpdate();
    case 7: exerciseSevenAddressWithEmployeeCount();
    case 8: exerciseEightEmployeeWithProject();
    case 9: exerciseNineLatestProjects();
    case 10: exerciseTenSalaryIncrease();
    case 11: exerciseElevenFindEmployeesByName();
    case 12: exerciseTwelveEmployeesMaxSalaries();
    case 13: exerciseThirteenRemoveTowns();
}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exerciseThirteenRemoveTowns() throws IOException {
        System.out.println("Please enter town name:");
        String townName = bufferedReader.readLine();
        Town town = entityManager.createQuery("SELECT t FROM Town t where t.name = :t_name " , Town.class)
                .setParameter("t_name",townName)
                .getSingleResult();

        int affectedEntities= removeAddressesByTownID(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();
        System.out.printf("%d address in %s is deleted",affectedEntities,townName);
    }

    private int removeAddressesByTownID(Integer id) {
      List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a " +
                "WHERE a.town.id = :p_id", Address.class)
                        .setParameter("p_id",id)
                                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();
        return addresses.size();
    }


    @SuppressWarnings("unchecked")
    private void exerciseTwelveEmployeesMaxSalaries() {
        List<Object[]> rows = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary ) AS `m_salary` FROM departments d " +
                "join employees e on d.department_id = e.department_id\n" +
                "GROUP BY d.name\n" +
                "HAVING `m_salary` NOT BETWEEN  30000 AND 70000;")
                .getResultList();
        rows.forEach(row -> System.out.println(row[0] + " " + row[1]));
    }

    private void exerciseElevenFindEmployeesByName() throws IOException {
        System.out.println("Please enter pattern: ");
        String pattern = bufferedReader.readLine();
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :patternIn",Employee.class)
                .setParameter("patternIn",pattern.concat("%")).getResultList();

        employees.forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                employee.getSalary()));
    }

    private void exerciseTenSalaryIncrease() {
        entityManager.getTransaction().begin();
       int affectedEntities = entityManager.createQuery("UPDATE  Employee e " +
                "SET e.salary = e.salary * 1.12 " +
                "WHERE e.department.id IN : ids ")
                .setParameter("ids", Arrays.asList(1, 2, 4,11)).executeUpdate();
        entityManager.getTransaction().commit();

        List<Employee> employees = entityManager.createQuery("SELECT e from Employee  e where e.department.id IN:ids ", Employee.class)
                        .setParameter("ids", Arrays.asList(1,2,4,11)).getResultList();
        employees.forEach(employee -> System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary()));
        System.out.println(affectedEntities);

    }

    private void exerciseNineLatestProjects() {
        List<Project> projects = entityManager.createQuery("SELECT p from Project  p ORDER by p.startDate desc ", Project.class)
                .setMaxResults(10)
                .getResultList();
        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> {
                    System.out.printf("Project name: %s%n", project.getName());
                    System.out.printf("Project description: %s%n", project.getDescription());
                    System.out.printf("Project Start Date: %s%n", project.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss.S")));
                    System.out.printf("Project End Date: %s%n",project.getEndDate() ==null ? "null" : project.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss.S")));
                });
    }

    private void exerciseEightEmployeeWithProject() throws IOException {
        System.out.println("Please enter Employee ID:");
        int id = Integer.parseInt(bufferedReader.readLine());
        Employee employee = entityManager.find(Employee.class,id);

        System.out.printf("%s %s - %s%n",
        employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());
        employee.getProjects().stream()
                .map(Project::getName)
                .sorted(String::compareTo)
                .forEach(p -> System.out.printf("\t%s%n",p));

    }

    private void exerciseSevenAddressWithEmployeeCount() {
        List<Address> addressList = entityManager
                .createQuery("Select a from Address a" +
                " ORDER BY a.employees.size DESC ", Address.class)
                .setMaxResults(10)
                .getResultList();

        addressList.forEach(address -> {
            System.out.printf("%s , %s - %d employees%n",address.getText(),
                    address.getTown()== null
                            ? "Unknown" : address.getTown().getName()
                    ,address.getEmployees().size());
        });
    }

    private void exerciseSixNewAddressAndEmployeeUpdate() throws IOException {
        System.out.println("Please enter Employee's last name:");
        String lastName = bufferedReader.readLine();
        Employee employee = entityManager.createQuery("select e from Employee  e " +
                "where e.lastName = : l_name ", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();
        Address address = createAddress("Vitoshka 15");
        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {
        Address address =new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();;
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private void exerciseFiveEmployeesFromDepartment() {
        entityManager
                .createQuery("select e from Employee e "+
                        "Where e.department.name = :d_name " +
                        "order by e.salary , e.id" , Employee.class)
                .setParameter("d_name","Research and Development")
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from %s - $%.2f%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getDepartment().getName(),
                            employee.getSalary());
                });
    }

    private void exerciseFourSalaryOver50K() {
      entityManager
                .createQuery("select e from Employee e "+
                        "where e.salary> :min_salary" , Employee.class)
            .setParameter("min_salary", BigDecimal.valueOf(50000L))
            .getResultStream()
              .map(Employee::getFirstName)
              .forEach(System.out::println);

    }

    private void exerciseThreeContainsEmployee() throws IOException {
        System.out.println("Please enter employee's first and last name, separated by one space:");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

    Long singleResult=  entityManager.createQuery("select count (e) from Employee e " +
                       "where e.firstName = :f_name and e.lastName = : l_name",Long.class)
             .setParameter("f_name",firstName)
             .setParameter("l_name",lastName)
               .getSingleResult();
        System.out.println(singleResult ==0 ? "No" : "Yes");
    }

    private void exerciseTwoChangeCasing() {
        entityManager.getTransaction().begin();
       Query query =  entityManager.createQuery("update Town t " +
                "set t.name = UPPER(t.name) "
                + "WHERE LENGTH(t.name)<=5 ");
        System.out.println("Affected entities: " + query.executeUpdate());
        entityManager.getTransaction().commit();
    }
}