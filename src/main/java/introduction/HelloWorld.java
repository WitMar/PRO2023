package introduction;

import org.apache.log4j.Logger;

public class HelloWorld {

    static Logger log = Logger.getLogger("abc");

    public static void main(String [ ] args) {

        log.info("wg");
        System.out.println("Hello! Witaj!");
    }

}
