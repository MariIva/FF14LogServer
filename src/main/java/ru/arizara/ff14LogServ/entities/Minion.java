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
@Table(name = "minion")
public class Minion {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "enhanced_description")
    private String enhancedDescription;

    @Column(name = "tradeable")
    private boolean tradeable;

    @Column(name = "behavior")
    private String behavior;

    @Column(name = "patch")
    private String patch;

    @ManyToOne(targetEntity = Race.class)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(targetEntity = Skill.class)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne(targetEntity = Statistics.class)
    @JoinColumn(name = "stats_id")
    private Statistics stats;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "minion_source",
            joinColumns = @JoinColumn(name = "minion_id"),
            inverseJoinColumns = @JoinColumn(name = "source_id")
    )
    private List<Source> sources = new ArrayList<>();

    public Minion(int id, String name, String description, String enhancedDescription, boolean tradeable,
                  String behavior, String patch, Race race, Skill skill, Statistics stats) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.enhancedDescription = enhancedDescription;
        this.tradeable = tradeable;
        this.behavior = behavior;
        this.patch = patch;
        this.race = race;
        this.skill = skill;
        this.stats = stats;
    }
}
