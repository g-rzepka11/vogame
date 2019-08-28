package com.vogame.repository;

import com.vogame.entity.GameWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameWordRepository extends JpaRepository<GameWord, Long> {
}
