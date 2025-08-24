package com.lpdev.dslist.controller;

import com.lpdev.dslist.dto.GameListResponseDTO;
import com.lpdev.dslist.dto.GameSummaryDTO;
import com.lpdev.dslist.dto.ReplacementDTO;
import com.lpdev.dslist.services.GameListService;
import com.lpdev.dslist.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
@RequiredArgsConstructor
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListResponseDTO>> findAll(){

        List<GameListResponseDTO> games = gameListService.findAll();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping(value = "/{id}/games")
    public ResponseEntity<List<GameSummaryDTO>> findAllByListId(@PathVariable Long id) {

        List<GameSummaryDTO> games = gameService.findByList(id);
        return ResponseEntity.ok().body(games);
    }

    @PostMapping(value = "/{id}/replacement")
    public void move(@PathVariable Long id, @RequestBody ReplacementDTO body) {

        gameListService.move(id, body.sourceIndex(), body.targetIndex());
    }


}
