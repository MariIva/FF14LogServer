package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.arizara.ff14LogServ.entities.Orchestrion;

import java.util.List;

public interface OrchestrionDAO  extends JpaRepository<Orchestrion, Integer> {
   @Query(value =
           "SELECT * " +
           "FROM orchestrion JOIN CATEGORY_LOG ON ORCHESTRION.CATEGORY  = CATEGORY_LOG.ID " +
           "WHERE orchestrion.patch LIKE ?1",
          nativeQuery = true)
   List<Orchestrion> findByPatch(@Param("patch") String patch);

}
