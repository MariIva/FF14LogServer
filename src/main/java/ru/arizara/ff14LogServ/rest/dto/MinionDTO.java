package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MinionDTO {
    private int id;
    private String name;
    private String description;
    private String enhancedDescription;
    private boolean tradeable;
    private String behavior;
    private String patch;
    private Race race;
    private Skill skill;
    private Statistics stats;

    public static MinionDTO toDTO(Minion minion){
        return new MinionDTO(
                minion.getId(),
                minion.getName(),
                minion.getDescription(),
                minion.getEnhancedDescription(),
                minion.isTradeable(),
                minion.getBehavior(),
                minion.getPatch(),
                minion.getRace(),
                minion.getSkill(),
                minion.getStats()
        );
    }

    public static Minion toObject(MinionDTO minionDTO){
        return new Minion(
                minionDTO.getId(),
                minionDTO.getName(),
                minionDTO.getDescription(),
                minionDTO.getEnhancedDescription(),
                minionDTO.isTradeable(),
                minionDTO.getBehavior(),
                minionDTO.getPatch(),
                minionDTO.getRace(),
                minionDTO.getSkill(),
                minionDTO.getStats()
        );
    }
}
