import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FilesAndFunctions {

    public static void main(String[] args) throws IOException {
        // read all the file content
        try (Stream<String> s = Files.lines(Paths.get("file.txt"))) {
            s.forEach(System.out::println);
        }
        // read distinct words from the file
        try (Stream<String> s = Files.lines(Paths.get("file.txt"))) {
            s.map(str -> str.split(" "))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);
        }

        // list all the files
        try (Stream<Path> p = Files.list(Paths.get("."))) {
            p.filter(Files::isDirectory)
                    .forEach(System.out::println);
        }
    }
}
