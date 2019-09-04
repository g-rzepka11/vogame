package com.vogame.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "vogame", name = "word")
@Data
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private Long wordPackageId;

    @OneToMany(mappedBy = "wordId", cascade = CascadeType.ALL, orphanRemoval = true)
    @Lazy
    private Set<Translation> translations;
}
