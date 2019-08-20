package Challenges;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

//        CHALLENGE #1
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split htis up into an arr.";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnable1 = () -> {
            String myString = "Let's split htis up into an arr.";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

//        CHALLENGE #2
        Function<String, String> func = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if(i%2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

//        CHALLENGE #3
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if(i%2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

//        System.out.println(lambdaFunction.apply("1234567890"));
        String str = "1234567890";
        System.out.println(everySecondCharacter(str, lambdaFunction));

//        CHALLENGE #6
        Supplier<String> iLoveJava = () -> {
            return "I love Java!";
        };
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

//        CHALLENGE #9
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "jack",
                "Charlie"
        );

        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .peek(System.out::println)
                .count();

        System.out.println("Names beginning with A: " + namesBeginningWithA);

//        CHALLENGE #12


    }

    public static String everySecondCharacter(String str, Function<String, String> lambda) {
        return lambda.apply(str);
    }
}
