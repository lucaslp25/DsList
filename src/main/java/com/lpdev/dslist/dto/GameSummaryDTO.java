package com.lpdev.dslist.dto;

import com.lpdev.dslist.entities.Game;
import com.lpdev.dslist.projections.GameMinProjection;

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
    public GameSummaryDTO(GameMinProjection projection){
        this(
                projection.getId(),
                projection.getTitle(),
                projection.getYear(),
                projection.getImgUrl(),
                projection.getShortDescription()
        );
    }
}
