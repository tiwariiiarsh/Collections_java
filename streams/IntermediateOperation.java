package streams;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperation {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invoked.,
        // they only just created  another stream with intermediate operation and only runs or executed when terminal operation is executed on that

        // 1. filter:helps to filter out some element based on predicate output
        List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ghanshyam", "Akshit");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
        // no filtering at this point
        long res = list.stream().filter(x -> x.startsWith("A")).count(); //now here count is terminal operation applied to filter out and give answer
        System.out.println(res);

        // 2.map: it applies function on each and every element of list
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        // 3. sorted: it helps to sort elements in the list
        Stream<String> sortedStream = list.stream().sorted(); //default sorting
        Stream<String> sortedStreamUsingComparator = list.stream().sorted((a, b) -> a.length() - b.length()); //custom sorting using comparator inside sorted function

        // 4. distinct: it helps to  remove duplicates from the list
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        // 5. limit:  iterate applies infinite loop but:-- limit helps to make it finite with limit,(  where seed:- initial point, function which implies on each element during iteration)
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

        // 6. skip: it tells us skip starting 10 from seed point (i.e.  in this example: skip 1-10 ) and iterate from 11-110
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());

        // 7. peek:  in this example it print number from 11-110 ,basically terminal operation se phle hi chal kr run kr deta h
        // Performs an action on each element as it is consumed.
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

        // 8. flatMap
        // Handle streams of collections, lists, or arrays where each element is itself a collection
        // Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        // Transform and flatten elements at the same time.
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        System.out.println(listOfLists.get(1).get(1));
        System.out.println(listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList());


    }
}