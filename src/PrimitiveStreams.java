import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 10); // upper bound excluded
        intStream.forEach(System.out::println);

        intStream = IntStream.rangeClosed(1, 10);
        intStream.forEach(System.out::println);

        // System.out.println(intStream.sum()); // stream has already been operated upon or closed

        Supplier<IntStream> intStreamSupplier = () -> IntStream.rangeClosed(1, 10); // reusable stream

        System.out.println(intStreamSupplier.get().count());
        System.out.println(intStreamSupplier.get().min());
        System.out.println(intStreamSupplier.get().max());
        System.out.println(intStreamSupplier.get().sum());
        System.out.println(intStreamSupplier.get().average());

        // custom streams
        IntStream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);

        int sum = IntStream.iterate(1, i -> i + 2).limit(10).peek(System.out::println).sum();
        System.out.println("sum: " + sum);

        int evenSum = IntStream.iterate(2, i -> i + 2).limit(10).peek(System.out::println).sum();
        System.out.println("evenSum: " + evenSum);

        List<Integer> integerList = IntStream.iterate(1, i -> i + 1).limit(10).boxed().toList();
        integerList.forEach(System.out::println);
    }
}
