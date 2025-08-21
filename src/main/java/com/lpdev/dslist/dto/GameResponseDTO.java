package com.lpdev.dslist.dto;

import com.lpdev.dslist.entities.Game;

public record GameResponseDTO(

        Long id,
        String title,
        Integer year,
        String genre,
        String platforms,
        Double score,
        String imgUrl,
        String shortDescription,
        String longDescription
) {
    public GameResponseDTO(Game entity){
       this(entity.getId(), entity.getTitle(), entity.getYear(), entity.getGenre(), entity.getPlatforms(), entity.getScore(), entity.getImgUrl(), entity.getShortDescription(), entity.getLongDescription());
    }
}