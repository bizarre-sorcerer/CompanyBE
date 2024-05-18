package com.example.TestSpring;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component
public class FlywayRepair implements CommandLineRunner {

    private final DataSource dataSource;

    @Autowired
    public FlywayRepair(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) {
        Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration") // Specify your migration location
                .load()
                .repair();
    }
}