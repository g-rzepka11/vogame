package com.vogame.entity;

import lombok.Data;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word")
    private Word word;
}
