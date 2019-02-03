package com.jon.legoweb.demo;


import org.testng.annotations.Test;

import java.util.ArrayList;

public class EmployeeTest {

    @Test
    public void test() {
        Manager boss = new Manager("jon", 100, 500);
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("kai", 100);
        employees[1] = new Employee("qi", 200);
        employees[2] = boss;
        ((Manager) employees[2]).say();
        for (Employee employee : employees) {
            System.out.println(employee.getName() + "," + employee.getSalary());
            System.out.println(employees[2].getSalary());
        }

        Employee e = new Employee("员工", 100);
        if (e instanceof Manager) {
            Manager m = (Manager) e;
        }

        ArrayList arrayList = new ArrayList();
    }

}

class Employee implements Comparable {
    private String name;
    private int salary;


    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Object o) {
        Employee other = (Employee) o;
        if (other.getSalary() > salary) {
            return -1;
        } else if (other.getSalary() < salary) {
            return 1;
        }
        return 0;
    }
}

class Manager extends Employee {
    int bonus;

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public int getSalary() {
        return super.getSalary() + this.bonus;
    }

    public void say() {
        System.out.println("hello");
    }
}
