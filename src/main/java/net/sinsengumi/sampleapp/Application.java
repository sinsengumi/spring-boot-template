package net.sinsengumi.sampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import net.sinsengumi.sampleapp.infrastructure.FQCNBeanNameGenerator;

@SpringBootApplication
@ComponentScan(nameGenerator = FQCNBeanNameGenerator.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
