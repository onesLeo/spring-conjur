package com.allianz.springconjur;

import com.allianz.springconjur.conjur.ConjurController;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringConjurApplication  {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringConjurApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        ConjurController conjurController = new ConjurController();
        System.out.println("Spring Conjur Application Secret >>"+conjurController.retrieveSecret());
    }

//    @Override
//    public void run(String... args) {
//        ConjurController conjurController = new ConjurController();
//        System.out.println("Spring Conjur Application Secret >>"+conjurController.retrieveSecret());
//    }
}
