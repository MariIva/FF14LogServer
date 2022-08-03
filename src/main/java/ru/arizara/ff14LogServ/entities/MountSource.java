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
@Table(name = "mount_source")
public class MountSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Mount.class)
    @JoinColumn(name = "idMount")
    private int idMount;

    @ManyToOne(targetEntity = Source.class)
    @JoinColumn(name = "idSource")
    @Column(name = "idSource")
    private int idSource;
}
