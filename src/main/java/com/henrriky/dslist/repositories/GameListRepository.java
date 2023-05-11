package com.henrriky.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrriky.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
