package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.arizara.ff14LogServ.entities.Orchestration;

import java.util.List;

public interface OrchestrionDAO  extends JpaRepository<Orchestration, Integer> {
   @Query(value =
           "SELECT * " +
           "FROM orchestrion JOIN CATEGORY_LOG ON ORCHESTRION.CATEGORY  = CATEGORY_LOG.ID " +
           "WHERE orchestrion.patch LIKE ?1",
          nativeQuery = true)
   List<Orchestration> findByPatch(@Param("patch") String patch);

}
