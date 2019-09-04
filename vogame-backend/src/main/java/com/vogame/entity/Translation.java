package com.vogame.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "vogame", name = "translation")
@Data
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private String partOfSpeech;

    @Column
    private Long wordId;
}
