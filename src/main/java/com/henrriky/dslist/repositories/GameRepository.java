package com.henrriky.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrriky.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
