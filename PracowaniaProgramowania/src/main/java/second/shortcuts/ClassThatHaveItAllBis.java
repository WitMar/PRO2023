package second.shortcuts;

public class ClassThatHaveItAllBis implements InterfaceOne {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ClassThatHaveItAllBis.class);

    String name;
    Integer number;

    public void printMe(String info) {
        logger.info(info);
    }

    public void spam() {
        long i = 0;
        i = 10;
        i = 110;
        i = 1110;
        i = 11110;
        i = 111110;
        i = 1111110;
        i = 11111110;
        i = 111111110;
        i = 1111111110;
        printMe(String.valueOf(i));
    }

    public void usageOfPrint() {
        printMe("Hi");
    }
}
