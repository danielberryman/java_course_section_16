package Introduction;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Lambdas were introduced with Java 8
//        Provide an easier way to interact with interfaces that only implement 1 method
//        new Thread(()-> {
//            System.out.println("Printing from the runnable...");
//            System.out.println("This is line 2");
//            System.out.println("This is line 3");
//        }).start();
//
        Employee john = new Employee("John doe", 22);
        Employee dan = new Employee("Dan doe", 29);
        Employee grace = new Employee("Grace doe", 29);
        Employee snow = new Employee("Snow doe", 35);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(dan);
        employees.add(grace);
        employees.add(snow);
        john.setAge(49);

//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
////            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

//        LAMBDA ITERABLE
        employees.forEach(employee -> {
            employee.setAge(49);
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        john.setAge(51);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee e1, Employee e2) {
//                return e1.getName().compareTo(e2.getName());
//            }
//        });
//
////        LAMBDA version
//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
//
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//
////        String sillyString = doStringStuff(new UpperConcat() {
////            @Override
////            public String upperAndConcat(String s1, String s2) {
////                return s1.toUpperCase() + s2.toUpperCase();
////            }
////        }, employees.get(0).getName(), employees.get(1).getName());
//
//        String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(),
//                employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

//        AnotherClass anotherClass = new AnotherClass();
//        String s = anotherClass.doSomething();
//        System.out.println(s);
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

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
//        System.out.println("The AnotherClass's name is " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The Anonymous's class name is " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");

//        LAMBDA Version
        int count = 0;

        int j = 0;

        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff((s1, s2) -> {
            System.out.println("The lambdas's class name is: " + getClass().getSimpleName());
            System.out.println("count in the lambda expressions = " + count);
            System.out.println("j in the lambda expressions = " + j);
            return s1.toUpperCase() + s2.toUpperCase();
        }, "String1", "String2");

//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    System.out.println(count);
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };

//            count++;
//            System.out.println("count = " + count);

//            return Main.doStringStuff(uc, "String1", "String2");


    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}