package streams;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);
//      IntStream.of(1,2,3,4,5);  ,this is also a method to create direct stream of array of primitive type

        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));  //range(1,5) -> [1,2,3,4]
        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));  //rangeClosed --> [1,2,3,4,5]
//      boxed --> it does Primitive → Object conversion  -->> IntStream → Stream<Integer>
//        without boxed -->> IntStream.range(1,5).toList();  // ❌ compile error


//        if you want to print IntStream ,primitive type without using boxed
        IntStream.range(1,5)
                .forEach(System.out::println);

//        Alternative (No boxing, still collect)
        int[] arr = IntStream.range(1,5).toArray();
        System.out.println(Arrays.toString(arr));  //main reason--> Arrays.toString --> it convert it into readable format


        IntStream.of(1, 2, 3);

        DoubleStream doubles = new Random().doubles(5);
//        System.out.println(doubles.sum());
//        System.out.println(doubles.min());
//        System.out.println(doubles.max());
//        System.out.println(doubles.average());
//        doubles.summaryStatistics();
//        doubles.mapToInt(x -> (int) (x + 1));
        System.out.println(doubles.boxed().toList());

        IntStream intStream = new Random().ints(5);
        System.out.println(intStream.boxed().toList());
    }
}