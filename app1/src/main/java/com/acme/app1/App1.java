package com.acme.app1;

import com.acme.app1.entity.Street;
import com.acme.app1.repository.StreetRepository;
import com.acme.app2.entity.Home;
import com.acme.app2.repository.HomeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.UUID;

@SpringBootApplication
@EntityScan(basePackages={"com.acme.app1.entity","com.acme.app2.entity"})
@EnableJpaRepositories(basePackages={"com.acme.app1.repository","com.acme.app2.repository"})
public class App1 implements CommandLineRunner {
    private final HomeRepository homeRepository;
    private final StreetRepository streetRepository;

    public App1(HomeRepository homeRepository, StreetRepository streetRepository) {
        this.homeRepository = homeRepository;
        this.streetRepository = streetRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        streetRepository.save(new Street("id1","Long Street"));
        System.out.println(streetRepository.findById("id1").get());
        UUID uuid = UUID.randomUUID();
        homeRepository.save(new Home(uuid, "Large Home"));
        System.out.println(homeRepository.findById(uuid).get());

    }
}