package com.vogame.repository;

import com.vogame.entity.LearnUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnUserRepository extends JpaRepository<LearnUser, Long> {

    LearnUser findFirstByUser_Id(Long userId);

}
