package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.Skill;
import ru.arizara.ff14LogServ.entities.Statistics;

import javax.persistence.Column;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDTO {

    private int id;
    private int cost;
    private int attack;
    private int defense;
    private int hp;
    private int speed;
    private boolean areaAttack;
    private boolean eye;
    private boolean gate;
    private boolean shield;

    public static StatisticsDTO toDTO(Statistics statistics){
        return new StatisticsDTO(
                statistics.getId(),
                statistics.getCost(),
                statistics.getAttack(),
                statistics.getDefense(),
                statistics.getHp(),
                statistics.getSpeed(),
                statistics.isAreaAttack(),
                statistics.isEye(),
                statistics.isGate(),
                statistics.isShield()
        );
    }

    public static Statistics toObject(StatisticsDTO statisticsDTO){
        return new Statistics(
                statisticsDTO.getId(),
                statisticsDTO.getCost(),
                statisticsDTO.getAttack(),
                statisticsDTO.getDefense(),
                statisticsDTO.getHp(),
                statisticsDTO.getSpeed(),
                statisticsDTO.isAreaAttack(),
                statisticsDTO.isEye(),
                statisticsDTO.isGate(),
                statisticsDTO.isShield()
        );
    }
}
