package com.vogame.repository;

import com.vogame.entity.WordPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordPackageRepository extends JpaRepository<WordPackage, Long> {
}
