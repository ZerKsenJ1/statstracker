package com.bogdan.statstracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_nickname", nullable = false)
    private String name;

    protected Player() {}

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {this.name = name;}

    public Long getId() {return id;}

    public String getName() {return name;}
}
