package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.CategoryLog;
import ru.arizara.ff14LogServ.entities.Race;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RaceDTO {

    private int id;
    private String name;
    private String icon;

    public static RaceDTO toDTO(Race  race){
        return new RaceDTO(
                race.getId(),
                race.getName(),
                race.getIcon()
        );
    }

    public static Race toObject(RaceDTO raceDTO){
        return new Race(
                raceDTO.getId(),
                raceDTO.getName(),
                raceDTO.getIcon()
        );
    }
}
