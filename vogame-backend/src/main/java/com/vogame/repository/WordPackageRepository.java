package com.vogame.repository;

import com.vogame.entity.WordPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordPackageRepository extends JpaRepository<WordPackage, Long> {

    List<WordPackage> findByUserId(Long userId);

    Boolean existsByWordPackageName(String wordPackageName);

    WordPackage findFirstByWordPackageName(String wordPackageName);
}
