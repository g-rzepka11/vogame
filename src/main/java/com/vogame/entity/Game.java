package com.vogame.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "vogame", name = "game")
@Data
public class Game {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Long owner;

    @Column
    private String status;

    @Column
    private Long currentUser;

    @Column
    private Long wordPackageId;

    @Column
    private Long nextWord;
}
