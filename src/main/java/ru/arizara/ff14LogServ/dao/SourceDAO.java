package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.List;

public interface SourceDAO extends JpaRepository<Source, Integer> {
    @Query(value =
            "SELECT * " +
            "FROM source " +
            "WHERE source.type LIKE ?1 AND source.text LIKE ?2  ",
            nativeQuery = true)
    List<Source> findByTypeAndText(@Param("type") String type, @Param("text") String text);
}
