package DefiningClasses_Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departmentList = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Employee currentEmployee = new Employee();

            if (input.length == 6) {
                /* Peter 120.00 Dev Development peter@abv.bg 28 */
                currentEmployee = new Employee(
         /*
             this.name = name;
                    this.position = position;
                    this.department = department;
                    this.salary = salary;
                    this.email = "n/a";
                    this.age = age;
            */
                        input[0],
                        Double.parseDouble(input[1]),
                        input[2],
                        input[3],
                        input[4],
                        Integer.parseInt(input[5]));

            } else if (input.length == 5) {
                //Tina 333.33 Manager Marketing 33
                if (isInteger(input[input.length - 1])) {
                    currentEmployee = new Employee(
                            input[0],
                            Double.parseDouble(input[1]),
                            input[2],
                            input[3],
                            Integer.parseInt(input[4]));
                } else {
                    /* Sam 840.20 ProjectLeader Development sam@sam.com */
                    currentEmployee = new Employee(
                            input[0],
                            Double.parseDouble(input[1]),
                            input[2],
                            input[3],
                            input[4]);
                }
            } else if (input.length == 4) {
                currentEmployee = new Employee(
                        input[0],
                        Double.parseDouble(input[1]),
                        input[2],
                        input[3]);
            }

            Department department = new Department(input[3], currentEmployee);
            if (!isExistingDepartment(departmentList, input[3])) {
                departmentList.add(department);
            } else {
                for (Department dept : departmentList) {
                    if (dept.getName().equals(input[3])) {
                        dept.setEmployeeToList(currentEmployee);
                        break;
                    }
                }
            }
        }
        double maxAverageSalary = Double.MIN_VALUE;
        String departmentName = "";
        for (Department dp : departmentList) {
            double averageSalary = dp.getAverageSalary(dp);

            if (averageSalary > maxAverageSalary) {
                maxAverageSalary = averageSalary;
                departmentName = dp.getName();
            }
        }
        /* - sorted by salary in descending order */
        System.out.println("Highest Average Salary: " + departmentName);
        for (Department dp : departmentList) {
            if (dp.getName().equals(departmentName)) {
                dp.printSortedDescendingBySalaries();
            }
        }
    }

    private static boolean isExistingDepartment(List<Department> departmentList, String name) {
        for (Department dept : departmentList) {
            if (dept.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInteger(String s) {
        Pattern pattern = Pattern.compile("\\d*");
        return pattern.matcher(s).matches();
    }
}