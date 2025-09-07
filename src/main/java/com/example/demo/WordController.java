package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
@CrossOrigin(origins = "http://localhost:4200") // allow Angular app
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/search")
    public List<String> searchWords(@RequestParam("q") String query) {
        return wordService.searchWords(query);
    }
}
