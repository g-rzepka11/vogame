package com.vogame.repository;

import com.vogame.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT g FROM Game g " +
            "INNER JOIN GameUser gu ON g.id = gu.game.id " +
            "WHERE gu.user.id = :userId")
    List<Game> findByUserId(Long userId);
}
