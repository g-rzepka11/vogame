package com.vogame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(schema = "vogame", name = "word_package")
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
}
