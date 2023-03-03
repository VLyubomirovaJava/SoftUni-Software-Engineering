package DefiningClasses_Exercise.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parents;
    private List<Person> kids;

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parents = new ArrayList<>();
        this.kids = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void addToParentList(Person person) {
        if (isNew(person, parents)) {
            this.parents.add(person);
        }

    }

    private boolean isNew(Person person, List<Person> personList) {
        for (Person p : personList) {
            if (p.equals(person)) {
                return false;
            }
        }
        return true;
    }

    public void addToChildrenList(Person person) {
        if (isNew(person, kids)) {
            this.kids.add(person);

        }
    }

    public String getOutputForList(List<Person> list) {
        StringBuilder sb = new StringBuilder();
        if (!list.isEmpty()) {
            for (Person p : list) {
                sb.append(String.format("%s %s%n", p.getName(), p.getBirthday()));
            }
        }
        return sb.toString();

    }

    @Override
    public String toString() {

        return String.format("%s %s%nParents:%n%sChildren:%n%s", name, String.join("/", birthday), getOutputForList(parents), getOutputForList(kids));

    }
}
