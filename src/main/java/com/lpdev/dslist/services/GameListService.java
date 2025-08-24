package com.lpdev.dslist.services;

import com.lpdev.dslist.dto.GameListResponseDTO;
import com.lpdev.dslist.entities.GameList;
import com.lpdev.dslist.projections.GameMinProjection;
import com.lpdev.dslist.repositories.GameListRepository;
import com.lpdev.dslist.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListResponseDTO> findAll() {

        List<GameList> entities = gameListRepository.findAll();
        return entities.stream().map(GameListResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public void move(long listId, int index, int target) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(index);
        list.add(target, obj);

        //otimiza o for
        int min = index < target ? index : target;
        int max = index < target ? target : index;

        for (int i = min; i <= max; i++) {
            gameListRepository.updatePosition(listId, list.get(i).getId(), i);
        }

    }
}
