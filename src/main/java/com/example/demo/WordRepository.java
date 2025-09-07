package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    // Custom query to find words starting with input
    List<Word> findByWordStartingWithIgnoreCase(String prefix);
}