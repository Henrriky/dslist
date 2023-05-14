package com.henrriky.dslist.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.henrriky.dslist.entities.Game;
import com.henrriky.dslist.projections.GameMinProjection;

public class GameMinDTO {
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer position;
	
	public GameMinDTO() {
		
	}

	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		year = projection.getGameYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
		position = projection.getPosition();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public Integer getPosition() {
		return position;
	}

	
	
	
	
	
	
}
