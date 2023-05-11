package com.henrriky.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrriky.dslist.dto.GameDTO;
import com.henrriky.dslist.dto.GameMinDTO;
import com.henrriky.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService; //Indejação de dependência (Instanciamento automático)
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}") //id dinâmico, route params
	public GameDTO findById(@PathVariable Long id) {	
		GameDTO result = gameService.findById(id);
		return result;
	}
	
}
