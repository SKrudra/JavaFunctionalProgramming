import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BinaryUnaryAndSupplierFunctions {

    public static void main(String[] args) {
        // takes two input and return single value, all of same type
        BinaryOperator<Integer> addBinaryOperator = (a, b) -> a + b;
        System.out.println(addBinaryOperator.apply(10, 20));

        BinaryOperator<Integer> subtractBinaryOperator = (a, b) -> a - b;
        System.out.println(subtractBinaryOperator.apply(10, 20));

        BinaryOperator<Integer> multiplyBinaryOperator = (a, b) -> a * b;
        System.out.println(multiplyBinaryOperator.apply(10, 20));

        // takes no arguments supply the output
        Supplier<Integer> supplier = () -> 10;
        System.out.println(supplier.get());

        Supplier<Integer> randomInteger = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println(randomInteger.get());


        // takes one argument and return a value of same type
        UnaryOperator<Integer> addUnaryOperator = (a) -> a + 10;
        System.out.println(addUnaryOperator.apply(10));

        UnaryOperator<Integer> doubleUnaryOperator = (a) -> a + a;
        System.out.println(doubleUnaryOperator.apply(10));
    }
}
