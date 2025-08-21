package com.lpdev.dslist.dto;

import com.lpdev.dslist.entities.GameList;

public record GameListResponseDTO(Long id, String name) {

    public GameListResponseDTO(GameList entity){
        this(entity.getId(), entity.getName());
    }
}
