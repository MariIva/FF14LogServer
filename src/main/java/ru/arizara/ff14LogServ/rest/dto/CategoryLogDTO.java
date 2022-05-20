package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.CategoryLog;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryLogDTO {

    private int id;
    private String name;
    private String icon;

    public static CategoryLogDTO toDTO(CategoryLog  categoryLog){
        return new CategoryLogDTO(
                categoryLog.getId(),
                categoryLog.getName(),
                categoryLog.getIcon()
        );
    }

    public static CategoryLog toObject(CategoryLogDTO categoryLogDTO){
        return new CategoryLog(
                categoryLogDTO.getId(),
                categoryLogDTO.getName(),
                categoryLogDTO.getIcon()
        );
    }
}
