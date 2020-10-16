package com.tehnomobil.Putni.NaloziAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.tehnomobil.Putni.NaloziAPI.moduls")
@EntityScan("com.tehnomobil.Putni.NaloziAPI.moduls")

public class PutniNaloziApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PutniNaloziApiApplication.class, args);
    }

}
