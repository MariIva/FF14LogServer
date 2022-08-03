package ru.arizara.ff14LogServ.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data //get, set, toString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mount")
public class Mount {

    @Id
    private int id; //todo почему не приватная???

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

    @Transient
    private List<Source> sources;
}
