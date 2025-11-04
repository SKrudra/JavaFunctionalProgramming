import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class BehaviorParameterization {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isOdd = x -> x % 2 == 1;

        filterAndPrint(numbers, isEven);
        filterAndPrint(numbers, isOdd);

        List<Integer> squares = mapAndCreateNewList(numbers, x -> x * x);
        squares.forEach(System.out::println);

        List<Integer> cubes = mapAndCreateNewList(numbers, x -> x * x * x);
        cubes.forEach(System.out::println);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream()
                .map(function)
                .toList();
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }


}
