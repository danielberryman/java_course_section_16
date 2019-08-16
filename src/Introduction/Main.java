package Introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Lambdas were introduced with Java 8
//        Provide an easier way to interact with interfaces that only implement 1 method
        new Thread(()-> {
            System.out.println("Printing from the runnable...");
            System.out.println("This is line 2");
            System.out.println("This is line 3");
        }).start();

        Employee john = new Employee("John doe", 22);
        Employee dan = new Employee("Dan doe", 29);
        Employee grace = new Employee("Grace doe", 29);
        Employee snow = new Employee("Snow doe", 35);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(dan);
        employees.add(grace);
        employees.add(snow);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });

//        LAMBDA version
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());

        String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(),
                employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

//class CodeToRun implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Running code...");
//    }
//}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}