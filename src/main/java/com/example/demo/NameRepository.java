package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NameRepository extends JpaRepository<Name, Long> {

    List<Name> findByTeam1ContainingIgnoreCaseOrTeam2ContainingIgnoreCase(String team1, String team2);

}
