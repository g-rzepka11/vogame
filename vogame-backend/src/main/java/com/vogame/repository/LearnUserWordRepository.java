package com.vogame.repository;

import com.vogame.entity.LearnUserWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearnUserWordRepository extends JpaRepository<LearnUserWord, Long> {

    List<LearnUserWord> findByUserId(Long userId);
}
