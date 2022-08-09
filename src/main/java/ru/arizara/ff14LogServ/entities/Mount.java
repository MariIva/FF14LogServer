package ru.arizara.ff14LogServ.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data //get, set, toString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mount")
public class Mount {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    @Column(name = "enhanced_description")
    private String enhanced_description;
    @Column(name = "tooltip")
    private String tooltip;

    @Column(name = "seats")
    private int seats;
    @Column(name = "movement")
    private String movement;

    @Column(name = "patch")
    private String patch;

    @Column(name = "bgm")
    private String bgm;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "mount_source",
            joinColumns = @JoinColumn(name = "mount_id"),
            inverseJoinColumns = @JoinColumn(name = "source_id")
    )
    private List<Source> sources = new ArrayList<>();

    public Mount(int id, String name, String description, String enhanced_description, String tooltip, int seats, String movement, String patch, String bgm) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.enhanced_description = enhanced_description;
        this.tooltip = tooltip;
        this.seats = seats;
        this.movement = movement;
        this.patch = patch;
        this.bgm = bgm;
    }
}
