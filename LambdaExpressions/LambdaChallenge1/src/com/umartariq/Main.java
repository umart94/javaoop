package com.umartariq;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Main.java created by umartariq on 30/10/2020
 * 4:35 PM inside the package - com.umartariq
 * in the java project LambdaChallenge1 using IDE IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {
        /*
        Challenge # 1 :
        Code an anonymous class, as a lambda expression.

            Runnable runnable = new Runnable() {
            @Override
            public void run(){
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part : parts){
            System.out.println(part);
            }
            }
            };
*/

        /*************Challenge # 1****************/
    Runnable runnable = () -> {
        String myString = "Let's split this up into an array";
        String[] parts = myString.split(" ");
        for(String part : parts){
   //         System.out.println(part);
        }
    };

    runnable.run();
/*************Challenge # 1****************/




/*************Challenge # 2 and 3****************/
    /*
    Challenge 2 : Write a Function (Method) as a Lambda Expression.
    challenge 3 : apply and print value returned from function
     */

        Function<String,String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0; i < s.length() ; i++){
                if(i % 2 ==1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
String stringIntoCharacters = lambdaFunction.apply("Split String Into Seperate Characters, Print Every Other " +
                "Character Of String ( 1 char after char next to it.  test)");
        //System.out.println(stringIntoCharacters);
    //    System.out.println(lambdaFunction.apply("Split String Into Seperate Characters, Print Every Other " +
      //          "Character Of String ( 1 char after char next to it.  test)"));
/*************Challenge # 2 and 3****************/






        /*************Challenge # 4****************/

        /*

        Challenge # 4
        code a method called everySecondCharacter that accepts this function as a parameter and execute it with
        a test argument.

        it should return result of function
        don't hardcode argument string.
         */
/*************Challenge # 4****************/







/*************Challenge # 5****************/
    /*

        Challenge # 5 :
        call method with lambdafunction we created earlier and print result returned from the method.

         */
   //     System.out.println(everySecondCharacter(lambdaFunction,"1234567890"));
       String result = everySecondCharacter(lambdaFunction,"1234567890");
   //     System.out.println(result);

/*************Challenge # 5****************/





/*************Challenge # 6 and 7****************/
        /*

        Challenge # 6 :
        write lambda expression that maps to the java.util.Supplier interface, this lambda should return the string

        i love java... assign it to a variable called iLoveJava.


         */

        Supplier<String> iLoveJava = () -> " I Love Java !";
        Supplier<String> iLoveJavareturn = () -> { return " I Love Java !"; };

        String supplierResult1 = iLoveJava.get();
        String supplierResult2 = iLoveJavareturn.get();

  //      System.out.println(iLoveJava.get());
  //      System.out.println(iLoveJavareturn.get());
 //       System.out.println(supplierResult1);
 //       System.out.println(supplierResult2);


/*************Challenge # 6 and 7****************/





/*************Challenge # 8****************/
        /*

        Challenge # 8 :
        use Lambda Expression, instead of creating an interface and a class instance that will use that interface.

        we must use only lambda expressions .
         */

        /*
        Solution to challenge 8  :
        interface has to be a functional interface , it can only have a single method that must be implemented.

        a functional interface can contain more than one method, but all the methods but one must have default
        implementations.

        can we use lambda expression to represent java.util.concurrent.callable interface ?
        since it has only 1 method, call method, so we can use a lambda expression for it.

        can we use java.util.Comparator.

        despite containing 10 methods
        only 1 method has to be implemented
        so its functional interface

        so we can use lambdas with comparator and callable interface.
         */
/*************Challenge # 8****************/






/*************Challenge # 9****************/
        /*
        Challenge # 9 :

        print items in list in sorted order, and first letter in each name as UpperCase.
         */

        List<String> listOfNames = Arrays.asList(
                "amna",
                "bilal",
                "danish",
                "faizan",
                "ghazala",
                "Hafsa",
                "iqra",
                "Javeria",
                "khadija",
                "Lubna",
                "muhammad",
                "Noman",
                "owais",
                "quratulain",
                "sana",
                "sidra",
                "tahir",
                "umar",
                "usman",
                "umair",
                "uzair",
                "vardah",
                "zainab"
        );

        List<String> firstUppercaseList = new ArrayList<>();
        listOfNames.forEach(name ->
            firstUppercaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
          //  firstUppercaseList.sort( (s1,s2) -> s1.compareTo(s2));
          //  firstUppercaseList.forEach( s -> System.out.println(s));

           // firstUppercaseList.sort(String::compareTo);
     //   System.out.println("Printing Names , with First letter as capital - using Lambda Expression");
           // firstUppercaseList.forEach(System.out::println);

/*************Challenge # 9****************/






/*************Challenge # 11****************/
/*
Challenge  # 11

use a stream and chain of stream operations to do this :
 */



     //   System.out.println("Printing Names , with First letter as capital - using Streams and lambda expressions");

     //   listOfNames.stream().map(name -> name.substring(0,1).toUpperCase() + name.substring(1)).sorted
        //   (String::compareTo)
     //   .forEach(System.out::println);


/*************Challenge # 11****************/


/*************Challenge # 12****************/
/*
Challenge  # 11

use a stream and chain of stream operations to do this :

print how many names start with letter U

modify stream chain
add another statement to print the items..
 */

//        long countOfnamesBeginningWithU =
//                listOfNames.stream().map(
//                        name ->
//                                name.substring(0,1).toUpperCase() + name.substring(1))
//                        .filter(name -> name.startsWith("U")).count();
//        ;
//        System.out.println("There are : "+countOfnamesBeginningWithU+ "  name that begin with U in this list. ");

//        System.out.println("Sorted Names beginning with U : "+countOfnamesBeginningWithU);
//        listOfNames.stream().map(
//                name ->
//                        name.substring(0,1).toUpperCase() + name.substring(1))
//                .filter(name -> name.startsWith("U")).sorted(String::compareTo).forEach(System.out::println);

/*************Challenge # 12****************/

/*************Challenge # 14****************/

//add terminal operation to the chain so that peek will execute.

//                listOfNames.stream().map(
//                        name ->
//                                name.substring(0,1).toUpperCase() + name.substring(1)).peek(System.out::println)
//                        .sorted(String::compareTo).count();


//        System.out.println(listOfNames.stream().map(
//                name ->
//                        name.substring(0,1).toUpperCase() + name.substring(1))
//                .sorted(String::compareTo).collect(Collectors.toList()).toString());


       List<String> UpperCaseFirstLetterAndSorted = listOfNames.stream().map(
                name ->
                        name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo).collect(Collectors.toList());

       for(String StringName : UpperCaseFirstLetterAndSorted) {
           System.out.println(StringName);
       }
/*************Challenge # 14****************/



    }
    public static String everySecondCharacter(Function<String,String> func,String sourceStringInput){
        return func.apply(sourceStringInput);

    }

}
