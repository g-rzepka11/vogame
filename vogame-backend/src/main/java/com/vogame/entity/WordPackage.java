package com.vogame.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "vogame", name = "word_package")
@Data
public class WordPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String wordPackageName;

    @Column
    private Boolean isPrivate;

    @Column(updatable = false)
    private Long userId;

    @Column(updatable = false)
    private Date createdAt;

    @Column
    private String status;

    @OneToMany(mappedBy = "wordPackageId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC")
    @Lazy
    private List<Word> words;
}
