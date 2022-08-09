package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.Race;
import ru.arizara.ff14LogServ.entities.Skill;

import javax.persistence.Column;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO {

    private int id;
    private String name;
    private String description;
    private int angle;
    private int cost;
    private String type;

    public static SkillDTO toDTO(Skill skill){
        return new SkillDTO(
                skill.getId(),
                skill.getName(),
                skill.getDescription(),
                skill.getAngle(),
                skill.getCost(),
                skill.getType()
        );
    }

    public static Skill toObject(SkillDTO skillDTO){
        return new Skill(
                skillDTO.getId(),
                skillDTO.getName(),
                skillDTO.getDescription(),
                skillDTO.getAngle(),
                skillDTO.getCost(),
                skillDTO.getType()
        );
    }
}
