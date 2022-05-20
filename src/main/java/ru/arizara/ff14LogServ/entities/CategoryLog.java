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
@Table(name = "category_Log")
public class CategoryLog {

    @Id
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "icon")
    private String icon;

    public CategoryLog(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
