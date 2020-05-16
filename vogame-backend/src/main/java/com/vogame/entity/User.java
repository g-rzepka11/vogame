package com.vogame.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "vogame", name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;
}
