package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    private final WordRepository repository;

    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    public List<String> searchWords(String query) {
        return repository.findByWordStartingWithIgnoreCase(query)
                .stream()
                .map(Word::getWord)
                .toList();
    }
}
