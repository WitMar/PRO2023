package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainLazy {
    public static void main(String[] args) {

        System.out.println("Intermediate Operation won't execute");
        Arrays.stream(new int[]{0, 1}).map(i -> {
            System.out.println(i);
            return i;
            // No terminal operation so it won't execute
        });

        System.out.println("Terminal operation starts here");
        Arrays.stream(new int[]{0, 1}).map(i -> {
            System.out.println(i);
            return i;
            // This is followed by terminal operation sum()
        }).sum();

        // lazy evaluation - does not matter where you put the limit
        IntStream.range(1, 100)
                .map(a -> {
                    if (a > 10) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    return a;
                }).limit(5)
                .forEach(a -> System.out.println(a));

        Stream.of("Sun", "Set", "Run", "Stream").filter(word -> {
            System.out.println(word);
            return word.startsWith("S");
        }).limit(2).forEach(System.out::println);
    }
}
