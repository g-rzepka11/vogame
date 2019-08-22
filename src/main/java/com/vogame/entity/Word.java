package com.vogame.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "vogame", name = "word")
@Data
public class Word {

    @Id
    @Column
    private Long id;

    @Column
    private String text;

    @Column
    private Long wordPackageId;
}
