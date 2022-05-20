package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.CategoryLog;
import ru.arizara.ff14LogServ.entities.Orchestration;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrchestrionDTO {

    private int id;
    private String name;
    private String description;
    private String patch;
    private CategoryLog category;
    private String icon;

    public static OrchestrionDTO toDTO(Orchestration orchestrion){
        return new OrchestrionDTO(
                orchestrion.getId(),
                orchestrion.getName(),
                orchestrion.getDescription(),
                orchestrion.getPatch(),
                orchestrion.getCategory(),
                orchestrion.getIcon()
        );
    }

    public static Orchestration toObject(OrchestrionDTO orchestrionDTO){
        return new Orchestration(
                orchestrionDTO.getId(),
                orchestrionDTO.getName(),
                orchestrionDTO.getDescription(),
                orchestrionDTO.getPatch(),
                orchestrionDTO.getCategory(),
                orchestrionDTO.getIcon()
        );
    }
}
