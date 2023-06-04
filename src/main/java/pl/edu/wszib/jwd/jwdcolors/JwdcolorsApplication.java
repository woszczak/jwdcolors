package pl.edu.wszib.jwd.jwdcolors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:db.properties") //wskazuje gdzie jest plik z ustawieniami
@SpringBootApplication
public class JwdcolorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwdcolorsApplication.class, args);
    }

}
