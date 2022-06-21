package pro.sky.java.course2.streamapi.book;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int dept;
    private final int salary;


    public Employee(String firstName, String lastName, int dept, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDept() {
        return dept;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Сотрудник:\n " +
                "Имя - " + firstName + '\'' +
                "Фамилия - " + lastName;

    }
}
