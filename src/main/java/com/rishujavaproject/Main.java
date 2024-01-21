package com.rishujavaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    @SpringBootApplication ~
    @configuration :  used to create beans called AppConfig, if you want to have a bean dependent on another bean you define in the configuration class.
    @EnableAutoConfiguration : Figures out what all libraries you use and pre-configure the components (does this based on the JAR files on the classpath).
    @ComponentScan - tells Spring where to scan for components, by default will search within the package main class is located.

    Part of Spring Web MVC (Model-View-Controller) framework:
    @RestController ~
    @Controller @ResponseBody

    @GetMapping~
    @RequestMapping - CRUD (read)

 */
@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //REST endpoint for clients to call.
    @GetMapping("/greet")
    public Greetings greet(){
        Greetings response = new Greetings("Hello World!",
                List.of("Cooking","Painting","Coding"),
                new Person("Harry"));
        return response;
    }
    record Greetings(String greet,
                     List<String> hobbies,
                     Person person){}
    record Person (String name){}
}
