package com.henrriky.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.henrriky.dslist.dto.GameListDTO;
import com.henrriky.dslist.entities.GameList;
import com.henrriky.dslist.projections.GameMinProjection;
import com.henrriky.dslist.repositories.GameListRepository;
import com.henrriky.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(gameList -> new GameListDTO(gameList)).toList();
		return dto;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> gamesOfList = gameRepository.searchByPlataformList(listId);
		
		GameMinProjection obj = gamesOfList.remove(sourceIndex); //Obj recebe o elemento removido
		gamesOfList.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int position = min; position <= max; position++) {
			gameListRepository.updateBelongingPosition(listId, gamesOfList.get(position).getId(), position);
		}
	}
	
}
