package com.vogame.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(schema = "vogame", name = "word_package")
@Data
public class WordPackage {

    @Id
    @Column
    private Long id;

    @Column
    private String wordPackageName;

    @Column
    private Boolean isPrivate;

    @Column
    private Long userId;

    @Column
    private Date createdAt;

    @Column
    private String status;

    @OneToMany(mappedBy = "wordPackageId", cascade = CascadeType.ALL)
    @Lazy
    private Set<Word> words;
}
