package com.lpdev.dslist.dto;

import com.lpdev.dslist.entities.Game;

public record GameSummaryDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {
    public GameSummaryDTO(Game entity){
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getYear(),
                entity.getImgUrl(),
                entity.getShortDescription()
        );
    }
}
