package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.List;

public interface SourceDAO extends JpaRepository<Source, Integer> {
    /*@Query(value =
            "SELECT * " +
            "FROM source" +
            "WHERE source.text LIKE ?1",
            nativeQuery = true)
    Mount findByText(@Param("text") String text);*/
}
