package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/name")
@CrossOrigin(origins = "http://localhost:4200") // allow Angular
public class NameController {

    private final NameRepository repository;

    public NameController(NameRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/search")
    public List<Name> searchMatches(@RequestParam("query") String query) {
        return repository.findByTeam1ContainingIgnoreCaseOrTeam2ContainingIgnoreCase(query, query);
    }
}
