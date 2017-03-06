package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by thomaz on 03/03/17.
 */
@SpringBootApplication
public class Boot {
    public Boot() {
    }
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
