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
@Table(name = "blm")
public class BlueMage {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "rank")
    private int rank;

    @Column(name = "type")
    private String type;

    @Column(name = "aspect")
    private String aspect;

    @Column(name = "patch")
    private String patch;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "blm_source",
            joinColumns = @JoinColumn(name = "blm_id"),
            inverseJoinColumns = @JoinColumn(name = "source_id")
    )
    private List<Source> sources = new ArrayList<>();

    public BlueMage(int id, String name, String description, int rank,
                    String type, String aspect, String patch) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rank = rank;
        this.type = type;
        this.aspect = aspect;
        this.patch = patch;
    }
}
