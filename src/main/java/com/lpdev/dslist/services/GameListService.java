package com.lpdev.dslist.services;

import com.lpdev.dslist.dto.GameListResponseDTO;
import com.lpdev.dslist.entities.GameList;
import com.lpdev.dslist.repositories.GameListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListResponseDTO> findAll() {

        List<GameList> entities = gameListRepository.findAll();

        return entities.stream().map(GameListResponseDTO::new).collect(Collectors.toList());
    }
}
