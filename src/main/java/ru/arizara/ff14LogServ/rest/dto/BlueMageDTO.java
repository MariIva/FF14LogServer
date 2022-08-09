package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.BlueMage;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlueMageDTO {

    private int id;
    private String name;
    private String description;
    private int rank;
    private String type;
    private String aspect;
    private String patch;

    public static BlueMageDTO toDTO(BlueMage blueMage){
        return new BlueMageDTO(
                blueMage.getId(),
                blueMage.getName(),
                blueMage.getDescription(),
                blueMage.getRank(),
                blueMage.getType(),
                blueMage.getAspect(),
                blueMage.getPatch()
        );
    }

    public static BlueMage toObject(BlueMageDTO blueMageDTO){
        return new BlueMage(
                blueMageDTO.getId(),
                blueMageDTO.getName(),
                blueMageDTO.getDescription(),
                blueMageDTO.getRank(),
                blueMageDTO.getType(),
                blueMageDTO.getAspect(),
                blueMageDTO.getPatch()
        );
    }
}
