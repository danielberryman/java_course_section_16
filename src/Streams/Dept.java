package Streams;

import java.util.ArrayList;
import java.util.List;

public class Dept {
    private String name;
    private List<Employee> employees;

    public Dept(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
