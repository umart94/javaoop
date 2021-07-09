package com.umartariq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Main.java created by umartariq on 29/10/2020
 * 5:43 PM inside the package - com.umartariq
 * in the java project Streams using IDE IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {

        /*
        sequence of computations is called stream
        computation steps chained together.


         */

        /*
        In the United States, Bingo is a game of chance in which each player matches numbers printed in different arrangements on cards with the numbers the game host (caller) draws at random, marking the selected numbers with tiles. When a player finds the selected numbers are arranged on their card in a row, they call out "Bingo!" to alert all participants to a winning card, which prompts the game host (or an associate assisting the host) to examine the card for verification of the win. Players compete against one another to be the first to have a winning arrangement for the prize or jackpot. After a winner is declared, the players clear their number cards of the tiles and the game host begins a new round of play.
        */
        List<String> bingoCodesList = Arrays.asList("B40","B36","B12","B6","O53","O49","O60","O50","N12","N34","N56",
                "N26","N48","G23","G34","G56","G56","I12","I35","I45","I67","I05","I23","I12","B10","G45","O58");

        List<String> bingoCodesSingleLetter = new ArrayList<>(); //effectively final , variable does not change,
        // since we did not
        // modify it.

        //SUPPOSE WE want to print only the numbers starting with A
        bingoCodesList.forEach(number -> {
            if(number.toUpperCase().startsWith("O")){
                bingoCodesSingleLetter.add(number);
               // System.out.println(number);
            }
        });

        //now we want to print the bingo codes in sorted order
        bingoCodesSingleLetter.sort((String s1,String s2) -> s1.compareToIgnoreCase(s2));

        /*
        Ok, so compareTo will check the case, and sort the numbers according to the case of the starting letter.
        if we want the codes in such a way, that the lower case letter and upper case letter and the number
        afterwards is sorted, then use compareToIgnoreCase Method.

        (IN this game, we use letters from B,I,N,G,O or if in some cases we use lowercase, b,i,n,g,o

         */

        //WITHOUT STREAMS
        bingoCodesSingleLetter.forEach((String bingoCodestartingWithSingleLetter) -> {
      //      System.out.println(bingoCodestartingWithSingleLetter);
        });

        //WITH STREAMS - 1 SINGLE LINE OF CODE.
        //bingoCodesList.stream().map(String::toUpperCase).filter(s->s.startsWith("N")).sorted().forEach(System
        // .out::println);

        //OR
//bingoCodesList.stream().map(s->s.toUpperCase()).filter(s->s.startsWith("N")).sorted().forEach(System.out::println);

        /*
        JAVA STREAM :

ompact1, compact2, compact3
java.util.stream
Interface Stream<T>
Type Parameters:
T - the type of the stream elements
All Superinterfaces:
AutoCloseable, BaseStream<T,Stream<T>>

public interface Stream<T>
extends BaseStream<T,Stream<T>>
A sequence of elements supporting sequential and parallel aggregate operations. The following example illustrates an aggregate operation using Stream and IntStream:

     int sum = widgets.stream()
                      .filter(w -> w.getColor() == RED)
                      .mapToInt(w -> w.getWeight())
                      .sum();

In this example, widgets is a Collection<Widget>. We create a stream of Widget objects via Collection.stream(), filter it to produce a stream containing only the red widgets, and then transform it into a stream of int values representing the weight of each red widget. Then this stream is summed to produce a total weight.
In addition to Stream, which is a stream of object references, there are primitive specializations for IntStream, LongStream, and DoubleStream, all of which are referred to as "streams" and conform to the characteristics and restrictions described here.

To perform a computation, stream operations are composed into a stream pipeline. A stream pipeline consists of a source (which might be an array, a collection, a generator function, an I/O channel, etc), zero or more intermediate operations (which transform a stream into another stream, such as filter(Predicate)), and a terminal operation (which produces a result or side-effect, such as count() or forEach(Consumer)). Streams are lazy; computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed.

Collections and streams, while bearing some superficial similarities, have different goals. Collections are primarily concerned with the efficient management of, and access to, their elements. By contrast, streams do not provide a means to directly access or manipulate their elements, and are instead concerned with declaratively describing their source and the computational operations which will be performed in aggregate on that source. However, if the provided stream operations do not offer the desired functionality, the BaseStream.iterator() and BaseStream.spliterator() operations can be used to perform a controlled traversal.

A stream pipeline, like the "widgets" example above, can be viewed as a query on the stream source. Unless the source was explicitly designed for concurrent modification (such as a ConcurrentHashMap), unpredictable or erroneous behavior may result from modifying the stream source while it is being queried.

Most stream operations accept parameters that describe user-specified behavior, such as the lambda expression w -> w.getWeight() passed to mapToInt in the example above. To preserve correct behavior, these behavioral parameters:

must be non-interfering (they do not modify the stream source); and
in most cases must be stateless (their result should not depend on any state that might change during execution of the stream pipeline).
Such parameters are always instances of a functional interface such as Function, and are often lambda expressions or method references. Unless otherwise specified these parameters must be non-null.

A stream should be operated on (invoking an intermediate or terminal stream operation) only once. This rules out, for example, "forked" streams, where the same source feeds two or more pipelines, or multiple traversals of the same stream. A stream implementation may throw IllegalStateException if it detects that the stream is being reused. However, since some stream operations may return their receiver rather than a new stream object, it may not be possible to detect reuse in all cases.

Streams have a BaseStream.close() method and implement AutoCloseable, but nearly all stream instances do not actually need to be closed after use. Generally, only streams whose source is an IO channel (such as those returned by Files.lines(Path, Charset)) will require closing. Most streams are backed by collections, arrays, or generating functions, which require no special resource management. (If a stream does require closing, it can be declared as a resource in a try-with-resources statement.)

Stream pipelines may execute either sequentially or in parallel. This execution mode is a property of the stream. Streams are created with an initial choice of sequential or parallel execution. (For example, Collection.stream() creates a sequential stream, and Collection.parallelStream() creates a parallel one.) This choice of execution mode may be modified by the BaseStream.sequential() or BaseStream.parallel() methods, and may be queried with the BaseStream.isParallel() method.

Since:
1.8
See Also:
IntStream, LongStream, DoubleStream, java.util.stream
Nested Class Summary
Nested Classes
Modifier and Type	Interface and Description
static interface 	Stream.Builder<T>
A mutable builder for a Stream.



         */


        /*
        stream is a set of object references
        stream method which is added to collections class in java 8
        creates a stream from a collection
        each object referenced in a stream corresponds to an object in the collection
        and the ordering of the object reference matches order of the collection.

        when we want to use stream that uses collection object as a source.
        the stream method will always be the first call we make.
         */


        /*
        Any Stream Operations we make have to meet 2 requirements :

        1. non interfering - dont change stream source collection in any way

        2. stateless - the result of the operation cant depend on any  state outside the operation.
        it cant depend on variable values in previous step.

        each operation seen as an independent step.

         */

        /*
        :: - when we reference something using the :: method
        its called a method reference operator
        we can use when all lambda expression does is call the method.

        in this case, there is not a string variable passed.

        but the String class is passed, i.e String::toUpperCase

        this means that it is the String object that we are using to invoke the method, ( and not some argument
        passed to uppercase )

        so this is mapped to argument of the function
        and the value returned is the String value returned from toUpperCase

         */

//        String myString = "abcd";
//        String upperString = myString.toUpperCase();
//        //String x= toUpperCase(myString); we cannot do this, when using strings
//        //when using streams, since we use the String object reference, it can be mapped to map function as a method
//        // reference.

        /*
        we will not be able to use map method, with a method argument that accepts two arguments.
        because such a method will not be able to be mapped to a function

        map method wants a function
        not a bifunction

        map method returns a stream
        stream will return all uppercased bingo numbers.

        results of calling to Uppercase method on input stream
        mapping input stream to the result returned by the function argument.

        we want to use predicate interfaces now

         */
        Stream<String> onlyIandONumberStream = Stream.of("I12","I34","I56","I78","O98","O76","O54",
                "O32");// 8 numbers

        //we cannot have a Stream of mixed types .. for e.g int and string, thats why we use numbers with string this
        // way in a stream.
        //Stream<String> onlyIAndNNumberStream = Stream.of("N12","N34","N56","N78","I22","I33","I44","I55");//8 numbers


        //put 4 duplicate codes in i. so distinct count then should return 16-4 = 12 as count.
        Stream<String> onlyIAndNNumberStream = Stream.of("N12","N34","N56","N78","I12","I34","I78","I56");//8 numbers

        //CONCATENATe the streams together

        Stream<String> concatStream = Stream.concat(onlyIandONumberStream,onlyIAndNNumberStream);
        //System.out.println("I AND O NUMBERS ==\t"+onlyIandONumberStream.count());//8
        //System.out.println("I AND N NUMBER ==\t"+onlyIAndNNumberStream.count());//8
        //System.out.println("I O AND N NUMBERS ==\t"+concatStream.count());//16 numbers
        //System.out.println("I O AND N NUMBERS ==\t"+concatStream.distinct().count());//16 (if all are distinct
        // numbers)
        System.out.println("-------------------------------------");
        //System.out.println("I O AND N NUMBERS ==\t"+concatStream.distinct().count());//12 (if you enter 4 duplicate
        // numbers)
        System.out.println("I O AND N NUMBERS ==\t"+concatStream.
                distinct().
                peek(System.out::println).count());//12 (if you enter 4 duplicate
        // numbers)



        /*
        use peek method, that accepts a consumer argument
        adds items to a new stream which it will return
        this is intermediate operation example
         */









        /*
        Whenever a terminal operation is called on a Stream object, the instance gets consumed and closed.

Therefore, we're only allowed to perform a single operation that consumes a Stream, otherwise, we'll get an exception that states that the Stream has already been operated upon or closed.

the solution consists of creating a new Stream each time we need one.

We can, of course, do that manually, but that's where the Supplier functional interface becomes really handy:
         */















    }
}
