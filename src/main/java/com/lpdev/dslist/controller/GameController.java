package com.lpdev.dslist.controller;

import com.lpdev.dslist.dto.GameResponseDTO;
import com.lpdev.dslist.dto.GameSummaryDTO;
import com.lpdev.dslist.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameSummaryDTO>> findAll(){

        List<GameSummaryDTO> games = gameService.findAll();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameResponseDTO> findById(@PathVariable Long id) {

        GameResponseDTO dto = gameService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
