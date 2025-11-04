import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomObjectFilterFunctional {

    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Java Programming"));
        courses.add(new Course("C Programming"));
        courses.add(new Course("C++ Programming"));
        courses.add(new Course("C# Programming"));
        courses.add(new Course("Spring"));
        courses.add(new Course("Spring Boot"));

        // print all the courses
        courses.forEach(System.out::println);

        // print the courses that starts with C
        courses.stream()
                .filter(course -> course.name().startsWith("C"))
                .forEach(System.out::println);

        // print the courses that has Spring in their name
        courses.stream()
                .filter(course -> course.name().contains("Spring"))
                .forEach(System.out::println);

        // print length of the course names
        courses.stream()
                .map(course -> course.name().length())
                .forEach(System.out::println);

        // sorted
        courses.stream()
                .sorted(Comparator.comparing(Course::name))
                .forEach(System.out::println);
    }
}


record Course(String name) {

    @Override
    public String toString() {
        return name;
    }
}