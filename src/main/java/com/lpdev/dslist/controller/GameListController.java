package com.lpdev.dslist.controller;

import com.lpdev.dslist.dto.GameListResponseDTO;
import com.lpdev.dslist.services.GameListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
@RequiredArgsConstructor
public class GameListController {

    private final GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListResponseDTO>> findAll(){

        List<GameListResponseDTO> games = gameListService.findAll();
        return ResponseEntity.ok().body(games);
    }


}
