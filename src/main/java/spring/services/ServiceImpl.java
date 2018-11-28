package spring.services;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements spring.services.Service {

    @Override
    public String print() {
        System.out.println("OK");
        return "OK";
    }
}