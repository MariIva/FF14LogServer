package ru.arizara.ff14LogServ.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //get, set, toString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stats")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private int id;

    @Column(name = "cost")
    private int cost;

    @Column(name = "attack")
    private int attack;

    @Column(name = "defense")
    private int defense;

    @Column(name = "hp")
    private int hp;

    @Column(name = "speed")
    private int speed;

    @Column(name = "area_attack")
    private boolean areaAttack;

    @Column(name = "eye")
    private boolean eye;

    @Column(name = "gate")
    private boolean gate;

    @Column(name = "shield")
    private boolean shield;

    public Statistics(int cost, int attack, int defense, int hp, int speed, boolean areaAttack,
                      boolean eye, boolean gate, boolean shield) {
        this.cost = cost;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.speed = speed;
        this.areaAttack = areaAttack;
        this.eye = eye;
        this.gate = gate;
        this.shield = shield;
    }
}
