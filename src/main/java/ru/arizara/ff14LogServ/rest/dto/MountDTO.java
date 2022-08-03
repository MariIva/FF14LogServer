package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MountDTO {
    private int id;
    private String name;
    private String description;
    private String enhanced_description;
    private String tooltip;
    private int seats;
    private String movement;
    private String patch;
    private String bgm;
   //private List<Source> sources;

    public static MountDTO toDTO(Mount mount){
        return new MountDTO(
                mount.getId(),
                mount.getName(),
                mount.getDescription(),
                mount.getEnhanced_description(),
                mount.getTooltip(),
                mount.getSeats(),
                mount.getMovement(),
                mount.getPatch(),
                mount.getBgm()
                //mount.getSources()
        );
    }

    public static Mount toObject(MountDTO mountDTO){
        return new Mount(
                mountDTO.getId(),
                mountDTO.getName(),
                mountDTO.getDescription(),
                mountDTO.getEnhanced_description(),
                mountDTO.getTooltip(),
                mountDTO.getSeats(),
                mountDTO.getMovement(),
                mountDTO.getPatch(),
                mountDTO.getBgm(),
                null
                //mountDTO.getSources()
        );
    }
}
