package spring.eduardo.projectspringbooteduardo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SpringAppParser {

    private static void extracted(ConfigurableApplicationContext context) throws IOException {

        StudentController studentController = context.getBean(StudentController.class);
        System.out.println(" students " + studentController.readData());
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAppParser.class, args);
        extracted(context);

    }
}