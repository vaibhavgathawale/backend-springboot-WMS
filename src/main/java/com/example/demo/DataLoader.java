package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final EmployeeRepository repo;

    public DataLoader(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            repo.save(new Employee("Alice", "alice@example.com", "Developer", 90000.0, LocalDate.of(2022,1,10)));
            repo.save(new Employee("Bob", "bob@example.com", "QA Engineer", 70000.0, LocalDate.of(2023,5,1)));
            repo.save(new Employee("Vaibhav", "Vaibhav@example.com", "Developer", 15000.5, LocalDate.of(2025,8,8)));
            repo.save(new Employee("Ram", "Ram@example.com", "QA Engineer", 45000.0, LocalDate.of(2025,3,8)));
        }
    }
}
