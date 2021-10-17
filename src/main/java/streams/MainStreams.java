package streams;

import streams.LocalVariables;
import streams.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreams {

    public static void main(String[] args) {
        LocalVariables example = new LocalVariables();
        example.method();

        //Old Java
        List<Student> students = new ArrayList<>();
        students.add(new Student("Arnold", 1L, 2L));
        students.add(new Student("John", 1L, 3L));
        students.add(new Student("Barrack", 2L, 1L));
        List<String> names = new ArrayList<>();
        for (Student student: students) {
            if (student.getName ().startsWith("A")) {
                names.add (student.getName ());
            }
        }

        //Java 8, and above
        List <String> namesNewJava = students.stream()
                .map(student -> student.getName())
                .filter (name-> name.startsWith("A"))
                .collect (Collectors.toList());


        //stream
        Stream.of("This", "is", "Java8", "Stream").forEach(System.out::println);

        String[] stringArray = new String[]{"Streams", "can", "be", "created", "from", "arrays"};

        Arrays.stream(stringArray).forEach(System.out::println);
    }

}
