import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorFunction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // list of odd numbers
        List<Integer> oddNumbers = numbers.stream().filter(x -> x % 2 == 1).toList();
        oddNumbers.forEach(System.out::println);

        // list of even numbers
        List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).toList();
        evenNumbers.forEach(System.out::println);

        // list of squares of numbers
        List<Integer> squaredNumbers = numbers.stream().map(x -> x * x ).toList();
        squaredNumbers.forEach(System.out::println);
    }
}
