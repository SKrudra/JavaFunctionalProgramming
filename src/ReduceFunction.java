import java.util.Arrays;
import java.util.List;

public class ReduceFunction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b); // lambda function
        System.out.println(sum);
        sum = numbers.stream().reduce(0, Integer::sum); // method reference
        System.out.println(sum);

        int greatest = numbers.stream().max(Integer::compareTo).get();
        System.out.println(greatest);
        greatest = numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
        System.out.println(greatest);

        int min = numbers.stream().min(Integer::compareTo).get();
        System.out.println(min);
        min = numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        System.out.println(min);

        // sum of odd values
        sum = numbers.stream()
                .filter(x -> x % 2 == 1)
                .reduce(0, Integer::sum);
        System.out.println("Sum of odd values: " + sum);

        // sum of even numbers
        sum = numbers.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("Sum of even values: " + sum);

        // sum of squares
        sum = numbers.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        System.out.println("Sum of squares: " + sum);

        // distinct
        numbers.stream().distinct().forEach(System.out::println);

        // sorted
        numbers.stream().sorted().forEach(System.out::println);

    }
}
