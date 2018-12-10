package hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //NameListRunner nlc = new NameListRunner();
        //nlc.printName("Harris", "Mieka", nlc.getNameTemp());
        //nlc.printNameToFile("Harris", "Annie", nlc.getNameTemp());
    }
}