package fluentAPI;

import java.util.function.Function;

public class Functions {

    public static void main(String[] args) {

        //APPLY
        Function<Integer, Double> half = a -> a / 2.0;
        // apply the function to get the result
        System.out.println(half.apply(10));

        //andTHEN
        Function<Integer, Double> half_2 = a -> a / 2.0;
        // Now treble the output of half function
        half_2 = half_2.andThen(a -> 3 * a);
        // apply the function to get the result
        System.out.println(half_2.apply(10));

        //IDENTITY
        Function<Integer, Double> half_3 = a -> a / 2.0;
        // Now treble the output of halffunction
        half_3 = half_3.andThen(Function.identity());
        // apply the function to get the result
        System.out.println(half_3.apply(10));

    }

}
