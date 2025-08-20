package com.lpdev.dslist.controller;

import com.lpdev.dslist.dto.GameResponseDTO;
import com.lpdev.dslist.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameResponseDTO>> findAll(){

        List<GameResponseDTO> games = gameService.findAll();

        return ResponseEntity.ok().body(games);
    }

}
