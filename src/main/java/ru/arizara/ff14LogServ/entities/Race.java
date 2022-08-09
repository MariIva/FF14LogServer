package ru.arizara.ff14LogServ.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data //get, set, toString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "race")
public class Race {
    @Id
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "icon")
    private String icon;

    public Race(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
