package ru.arizara.ff14LogServ.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data //get, set, toString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "angle")
    private int angle;

    @Column(name = "cost")
    private int cost;

    @Column(name = "type")
    private String type;

    public Skill(String skill, String skillDescription, int skillAngle, int skillCost, String skillType) {
        this.name = skill;
        this.description = skillDescription;
        this.angle = skillAngle;
        this.cost = skillCost;
        this.type = skillType;
    }
}
