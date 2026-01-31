package streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        // 1. collect: different type of collects exists learns later
//        basically it helps to collect all element in different data structure in diff fashion
//        both will give same o/p
        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

        // 2. forEach:iterate through each element and do some operation
        list.stream().forEach(x -> System.out.println(x));

        // 3. reduce(accumulator) : Combines elements to produce a single result
//        Optional<Integer> optionalInteger = list.stream().reduce((a,b) -> a+b);
        Optional<Integer> optionalInteger = list.stream().reduce( Integer::sum);


        System.out.println(optionalInteger.get());

        // 4. count

        // 5. anyMatch, allMatch, noneMatch

//        if anyMatch -->gives true
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);
//        if allMatch --> gives true
        boolean b1 = list.stream().allMatch(x -> x > 0);
        System.out.println(b1);
//        if noneMatch --> gives true
        boolean b2 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b2);

        // 6. findFirst, findAny
        System.out.println(list.stream().findFirst().get()); //return first element
//        findAny() ka main use-case hi parallel streams hai.Data multiple threads me split hota hai,  //Jo thread pehle element find kar leta hai, wahi return ho jata hai
        System.out.println(list.stream().findAny().get());  //return any random number

        // 7. toArray()

        Object[] array = Stream.of(1, 2, 3).toArray();

        // 8. min / max
//        without using get answer in this form (max: Optional[2]) but after get() --> (max: 69)
        System.out.println("max: " + Stream.of(2, 44, 69).max((o1, o2) -> o1 - o2).get());  //asc me sort kr diya h abb max --> 69 hoga
        System.out.println("max: " + Stream.of(2, 44, 69).max((o1, o2) -> o2 - o1));  //desc me sort kr diya h abb max --> 2 hoga
        System.out.println("min: " + Stream.of(2, 44, 69).min(Comparator.naturalOrder()));  //natural order me sorted h --> asc -> min:- 2

        // 9. forEachOrdered:it works in parallel stream and maintain the original order of list
//        forEach: it will not maintain the order ,gives random number in parallel stream but faster than forEachOrder
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream:");
        numbers0.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream:");
        numbers0.parallelStream().forEachOrdered(System.out::println);



        // Example: Filtering and Collecting Names
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        // Example: Squaring and Sorting Numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers.stream().map(x -> x * x).sorted().toList());

        // Example: Summing Values
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream().reduce(Integer::sum).get());

        // Example:  Counting Occurrences of a Character
        String sentence = "Hello world";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // Example
        // Streams cannot be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
//        List<String> list1 = stream.map(String::toUpperCase).toList(); // exception

        // stateful & stateless



    }
}