import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class CustomObjectFilterFunctional {

    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("C Programming", 5));
        courses.add(new Course("C++ Programming", 4));
        courses.add(new Course("C# Programming", 5));
        courses.add(new Course("Java Programming", 4));
        courses.add(new Course("Spring", 4));
        courses.add(new Course("Spring", 5));
        courses.add(new Course("Spring Boot", 5));

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

        // reverse order
        courses.stream()
                .sorted(Comparator.comparing(Course::name).reversed())
                .forEach(System.out::println);

        // custom order: based on the length of the name of the course
        courses.stream()
                .sorted(Comparator.comparing(c -> c.name().length()))
                .forEach(System.out::println);

        Predicate<Course> greaterThan4Ratings = course -> course.ratings() > 4;

        // allMatch
        System.out.println("All ratings greater than 4 " + courses.stream()
                .allMatch(greaterThan4Ratings));

        // anyMatch
        System.out.println("Any course with rating greater than 4 " + courses.stream().anyMatch(greaterThan4Ratings));

        // noneMatch
        System.out.println("No course with rating greater than 4 " + courses.stream().noneMatch(greaterThan4Ratings));

        // sorted on multiple fields
        courses.stream()
                .sorted(Comparator.comparing(Course::ratings).reversed().thenComparing(Course::name))
                .forEach(System.out::println);

        // comparing using primitive values
        courses.stream().
                sorted(Comparator.comparing(Course::name).thenComparingInt(Course::ratings).reversed())
                .forEach(System.out::println);

        // limit
        System.out.println("--limit--");
        courses.stream()
                .sorted(Comparator.comparing(Course::ratings).reversed())
                .limit(3) // top three
                .forEach(System.out::println);

        // skip
        System.out.println("--skip--");
        courses.stream()
                .sorted(Comparator.comparing(Course::ratings).reversed())
                .skip(1) // skip first; second onwards
                .forEach(System.out::println);

        System.out.println("--skip-limit--");
        courses.stream()
                .sorted(Comparator.comparing(Course::ratings).reversed())
                .skip(1)
                .limit(1) // second highest
                .forEach(System.out::println);

        // takeWhile
        System.out.println("--takeWhile--");
        courses.stream()
                // take the elements as long as the condition is true, discard the rest
                .takeWhile(course -> course.name().startsWith("C"))
                .forEach(System.out::println);

        // dropWhile
        System.out.println("--dropWhile--");
        courses.stream()
                // ignore the elements as long as the condition is true, take the remaining ones
                .dropWhile(course -> course.name().startsWith("C"))
                .forEach(System.out::println);
    }


}


record Course(String name, int ratings) {

    @Override
    public String toString() {
        return name + " " + ratings;
    }
}