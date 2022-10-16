package second.junit;

public class Main {

    public static void main(final String... args) {
        ProcessQuery processQuery = new ProcessQuery(new HttpQueryClass());
        System.out.println(processQuery.process());
    }

}
