package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Printer {

    @Autowired
    private HelloWorld helloWorld;

    public Printer() {

    }

    public void sendMessage() {
        helloWorld.getMessage();
    }
}