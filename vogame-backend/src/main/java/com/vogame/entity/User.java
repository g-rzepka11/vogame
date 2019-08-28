package com.vogame.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "vogame", name = "user")
@Data
public class User {

    @Id
    @Column
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
