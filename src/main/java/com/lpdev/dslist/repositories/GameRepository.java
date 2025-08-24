package com.lpdev.dslist.repositories;

import com.lpdev.dslist.entities.Game;
import com.lpdev.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


    //native query deve retornar uma interface

	//USO DE CAST POR CONTA DE UM ERRO MUITO ESPECIFICO DE CONVERSÃO DE CLOB DA LINGUAGEM SQL PARA O JAVA...

    @Query(nativeQuery = true, value = """
		
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		CAST(tb_game.short_description AS VARCHAR) AS shortDescription, tb_belonging.position 
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId      
		ORDER BY tb_belonging.position
				
			""")
    List<GameMinProjection> searchByList(@Param("listId") Long listId);
}
