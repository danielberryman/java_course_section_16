package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> bingoNums = Arrays.asList(
                "N40", "N36", "B12", "B6", "G53", "G60", "g51", "I26", "I17", "I29"
        );

//        String[] strArr = bingoNums.get(0).split("");
//        for (String str : strArr) {
//            System.out.println(str);
//        }

        List<String> gNumbers = new ArrayList<>();

//        bingoNums.forEach(bingoNum -> {
////            if (bingoNum.matches("G(.*)")) {
////                System.out.println(bingoNum);
////            }
////          OR
//            if (bingoNum.toUpperCase().startsWith("G")) {
//                gNumbers.add(bingoNum.toUpperCase());
////                System.out.println(bingoNum);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        bingoNums
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<Integer> intStream = Stream.of(1,2,3,4);
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("----------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());
//        long concatStreamItemCount = concatStream
//                .distinct()
//                .count();
//        System.out.println(concatStreamItemCount);

        Employee john = new Employee("John doe", 22);
        Employee dan = new Employee("Dan doe", 29);
        Employee grace = new Employee("Grace doe", 29);
        Employee snow = new Employee("Snow doe", 35);

        Dept hr = new Dept("Human Resources");

        hr.addEmployee(john);
        hr.addEmployee(dan);
        hr.addEmployee(grace);

        Dept acct = new Dept("Accounting");

        acct.addEmployee(snow);

        List<Dept> depts = new ArrayList<>();
        depts.add(hr);
        depts.add(acct);

        depts.stream()
                .flatMap(dept -> dept.getEmployees().stream())
                .forEach(System.out::println);
        System.out.println("___-----------_____");
//        List<String> sortedGNumbers = bingoNums
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());
        List<String> sortedGNumbers = bingoNums
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        Supplier, BiConsumerAccumulator, BiConsumerCombiner
//        new - this is the Supplier (which creates new objects)
//          this passes the constructor

        depts.stream()
                .flatMap(dept -> dept.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

    }
}
