package com.vogame.repositories;

import com.vogame.entities.WordEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends MongoRepository<WordEntity, String> {
}
