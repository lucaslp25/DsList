package com.lpdev.dslist.services;

import com.lpdev.dslist.dto.GameResponseDTO;
import com.lpdev.dslist.dto.GameSummaryDTO;
import com.lpdev.dslist.entities.Game;
import com.lpdev.dslist.projections.GameMinProjection;
import com.lpdev.dslist.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameSummaryDTO> findAll() {

        List<Game> games = gameRepository.findAll();

        return games.stream().map(GameSummaryDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameResponseDTO findById(Long id) {

        Game game = gameRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found game with id: " + id));
        return new GameResponseDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameSummaryDTO> findByList(Long id) {

        List<GameMinProjection> games = gameRepository.searchByList(id);
        return games.stream().map(GameSummaryDTO::new).collect(Collectors.toList());
    }


}
