package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import spring.HelloWorld;

public class Printer {

    @Autowired
    private HelloWorld helloWorld;

    public Printer() {

    }

    public void sendMessage() {
        helloWorld.getMessage();
    }
}