package ru.arizara.ff14LogServ.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data //get, set, toString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "source")
public class Source implements Comparable<Source>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type")
    private String type;
    @Column(name = "text")
    private String text;

    @ManyToMany( mappedBy = "sources")
    private List<Mount> mounts = new ArrayList<>();

    public Source(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public Source(int id, String type, String text) {
        this.id = id;
        this.type = type;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return type.equals(source.type) && text.equals(source.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, text);
    }

    @Override
    public int compareTo(Source o) {
        if (!type.equals(o.type))
            return type.compareTo(o.type);
        else
            return text.compareTo(o.text);
    }
}
