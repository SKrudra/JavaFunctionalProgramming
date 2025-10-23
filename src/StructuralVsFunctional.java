import java.util.Arrays;
import java.util.List;

public class StructuralVsFunctional {
    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        printStructural(numbers);
        printFunctional(numbers);

        printEvenNumbersStructural(numbers);
        printEvenNumbersFunctional(numbers);
    }

    private static void printEvenNumbersFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0) // lambda expression
                .forEach(System.out::println); // method reference
    }

    private static void printEvenNumbersStructural(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }

    private static void printFunctional(List<Integer> numbers) {
        numbers.forEach(System.out::println); // method reference
    }

    private static void printStructural(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}