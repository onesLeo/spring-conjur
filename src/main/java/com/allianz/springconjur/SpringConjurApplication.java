package com.allianz.springconjur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringConjurApplication {

//    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(SpringConjurApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);

//        System.out.println("trying to fetch the secret key for you...");

//        ConjurController conjurController = new ConjurController();
//        System.out.println("Spring Conjur Secret key >> "+conjurController.retrieveSecret());

//        System.out.println("done fetching your secret key..");
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringConjurApplication.class, args);
    }

//    @Override
//    public void run(String... args) {
//        ConjurController conjurController = new ConjurController();
//        System.out.println("Spring Conjur Application Secret >>"+conjurController.retrieveSecret());
//    }
}
