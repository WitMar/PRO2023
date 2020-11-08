package streams;

import java.util.stream.IntStream;

public class LocalVariables {

    private int i = 5;

    public void method() {
        //int i = 0;
        IntStream.range(1, 10).forEach(number -> {
            if (number > i) {
                System.out.println(i + " smaller than " + number);
                i += 2;
            }
        });

        //Parallel execution of stream

        IntStream stream = IntStream.range(1, 100);
        stream.parallel().forEach(number -> {
            if (number > i) {
                System.out.println(i + " smaller than " + number);
                i += 2;
            }
        });
    }


}


