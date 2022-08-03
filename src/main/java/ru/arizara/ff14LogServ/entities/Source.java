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
@Table(name = "source")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "text")
    private String text;

    @Column(name = "icon")
    private String icon;

    //@ManyToOne(targetEntity = Mount.class)
    //@JoinColumn(name = "mount_id")
    /*@Column(name = "id_mount_")
    private int idMount;*/

   /* public Source(String type, String text) {
        this.type = type;
        this.text = text;
    }*/

    public Source(String type, String text/*, int idMount*/) {
        this.type = type;
        this.text = text;
        //this.idMount = idMount;
    }
}
