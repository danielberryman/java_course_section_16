package Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John doe", 22);
        Employee dan = new Employee("Dan doe", 29);
        Employee grace = new Employee("Grace doe", 29);
        Employee snow = new Employee("Snow doe", 35);
        Employee joe = new Employee("Joe doe", 19);
        Employee red = new Employee("Red doe", 8);
        Employee sterling = new Employee("Sterling doe", 80);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(dan);
        employees.add(grace);
        employees.add(snow);
        employees.add(joe);
        employees.add(red);
        employees.add(sterling);
        john.setAge(49);

//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
////            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

//        LAMBDA ITERABLE
//        employees.forEach(employee -> {
//            employee.setAge(49);
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });

//        System.out.println("Employees over 30:");
//        System.out.println("******************");
//        employees.forEach(employee -> {
//            if(employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees 30 and under", employee -> employee.getAge() <= 30);
        printEmployeesByAge(employees, "Employees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate intp1 = i -> i > 15;
        IntPredicate intp2 = i -> i < 100;
        int a = 5;
        System.out.println(intp1.test(a+20));
        System.out.println(intp1.or(intp2).test(-1));
        System.out.println(intp1.and(intp2).test(-1));

//
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0; i<10; i++) {
            System.out.println(randomSupplier.get());
        }
    }

    //    PREDICATE INTERFACE
    //    Accepts a predicate and returns a boolean

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("******************");
        for (Employee employee : employees) {
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
