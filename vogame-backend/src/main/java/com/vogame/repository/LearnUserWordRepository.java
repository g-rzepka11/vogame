package com.vogame.repository;

import com.vogame.entity.LearnUserWord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LearnUserWordRepository extends JpaRepository<LearnUserWord, Long> {

    List<LearnUserWord> findByLearnUser_User_Id(Long userId);

    Page<LearnUserWord> findByLearnUser_User_Id(Long userId, Pageable pageable);

    List<LearnUserWord> findByLearnUser_User_IdAndStatusOrderByCreateDateAsc(Long userId, Integer status, Pageable ten);

    List<LearnUserWord> findByCheckWordDateAndLearnUser_User_IdAndStatus(Date date, Long userId, Integer status);

    Integer countByCheckWordDateAndLearnUser_User_IdAndStatus(Date date, Long userId, Integer status);

    Integer countByLearnUser_User_IdAndStatus(Long userId, Integer status);

    Integer countByLearnUser_User_Id(Long userId);
}
