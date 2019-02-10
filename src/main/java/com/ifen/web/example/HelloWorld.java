package com.ifen.web.example;

import org.springframework.stereotype.Service;

@Service("helloWorld")
public class HelloWorld {
    public String sayHello(){
        return "Hello World!";
    }
}
