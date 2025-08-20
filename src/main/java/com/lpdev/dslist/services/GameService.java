package com.lpdev.dslist.services;

import com.lpdev.dslist.dto.GameResponseDTO;
import com.lpdev.dslist.entities.Game;
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
    public List<GameResponseDTO> findAll() {

        List<Game> games = gameRepository.findAll();

        return games.stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }


}
