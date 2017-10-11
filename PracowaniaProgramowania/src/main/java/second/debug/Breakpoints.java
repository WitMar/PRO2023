package second.debug;

import second.debug.hidden.MakeThings;

public class Breakpoints {

    public static void main(final String... args) {
        //create objects
        Object o = MakeThings.makeAThing();
        System.out.println("Going inside print");
        printThis(o);
    }



    private static void printThis(final Object o) {
        System.out.println("I will print you something very soon");
        System.out.println(o.toString());
    }
}
