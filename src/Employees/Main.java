package Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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

        System.out.println("Employees over 30:");
        System.out.println("******************");
        employees.forEach(employee -> {
            if(employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });

//        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
//        printEmployeesByAge(employees, "Employees 30 and under", employee -> employee.getAge() <= 30);
//        printEmployeesByAge(employees, "Employees younger than 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
//
//        IntPredicate intp1 = i -> i > 15;
//        IntPredicate intp2 = i -> i < 100;
//        int a = 5;
//        System.out.println(intp1.test(a+20));
//        System.out.println(intp1.or(intp2).test(-1));
//        System.out.println(intp1.and(intp2).test(-1));
//
//        Random random = new Random();
//        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
//        for(int i=0; i<10; i++) {
//            System.out.println(randomSupplier.get());
//        }

//        FUNCTION INTERFACE
//        Function<Employee, String> getLastName = (Employee employee) -> {
//            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
//        };
//
//        String lastName = getLastName.apply(employees.get(1));
//        System.out.println(lastName);
//
//        Function<Employee, String> getFirstName = (Employee employee) -> {
//            return employee.getName().substring(0, employee.getName().indexOf(" "));
//        };
//
//        Random random = new Random();
//        for (Employee employee : employees) {
//            if(random.nextBoolean()) {
//                System.out.println(getName(getFirstName, employee));
//            } else {
//                System.out.println(getName(getLastName, employee));
//            }
//        }
//
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> concat = name -> name.substring(0, name.indexOf(" "));
        Function chainedFunction = upperCase.andThen(concat);
        System.out.println(chainedFunction.apply(employees.get(0)));
////        FUNCTION interface only takes 1 argument
////        BIFUNCTION interface can take 2
//        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
//            return name.concat(" " + employee.getAge());
//        };
//
//        String upperName = upperCase.apply(employees.get(0));
//        System.out.println(concatAge.apply(upperName, employees.get(1)));
//    }
//
//    //    Method that takes FUNCTION
//    private static String getName(Function<Employee, String> getName, Employee employee) {
//        return getName.apply(employee);
//    }
//
//    //    PREDICATE INTERFACE
//    //    Accepts a predicate and returns a boolean
//
//    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
//        System.out.println(ageText);
//        System.out.println("******************");
//        for (Employee employee : employees) {
//            if(ageCondition.test(employee)) {
//                System.out.println(employee.getName());
//            }
//        }
    }
}
