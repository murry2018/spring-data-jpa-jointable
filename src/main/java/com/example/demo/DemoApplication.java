package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner onStart(
            UserRepository userRepo, PhoneRepository phoneRepo) {

        return (String... args) -> {
            phoneRepo.save(new Phone("Samsung", "Galaxy S9"));
            phoneRepo.save(new Phone("Samsung", "Galaxy Note 10"));
            phoneRepo.save(new Phone("Samsung", "Z flip"));
            phoneRepo.save(new Phone("Apple", "iPhone 11"));
            phoneRepo.save(new Phone("Apple", "iPhone 12 Pro Max"));
            phoneRepo.save(new Phone("BlackBerry", "BlackBerry Z30"));

            User appdung = new User();
            List<Phone> appdungi = phoneRepo.findByVendor("Apple");
            appdung.setCellphones(appdungi);
            appdung.setName("appdung");
            userRepo.save(appdung);

            User samyup = new User();
            List<Phone> samyupchung = phoneRepo.findByVendor("Samsung");
            samyup.setCellphones(samyupchung);
            samyup.setName("samyup");
            userRepo.save(samyup);
            
            User rich = new User();
            List<Phone> richphones = new ArrayList<>();
            phoneRepo.findAll().forEach((phone) -> {
                richphones.add(phone);
            });
            rich.setCellphones(richphones);
            rich.setName("rich");
            userRepo.save(rich);

            User poor = new User();
            poor.setName("poor");
            userRepo.save(poor);
            
        };
    }
}
