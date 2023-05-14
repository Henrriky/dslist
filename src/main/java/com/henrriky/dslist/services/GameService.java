package com.henrriky.dslist.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.henrriky.dslist.dto.GameDTO;
import com.henrriky.dslist.dto.GameMinDTO;
import com.henrriky.dslist.entities.Game;
import com.henrriky.dslist.projections.GameMinProjection;
import com.henrriky.dslist.repositories.GameRepository;



@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository; //Indejação de dependência (Instanciamento automático)
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long gameId) {
		Game result = gameRepository.findById(gameId).get();
		GameDTO dto = new GameDTO(result);
		return dto;	
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		//Retorna um lista de objetos
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true) 
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByPlataformList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
		
}
