package ru.arizara.ff14LogServ.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.arizara.ff14LogServ.entities.Source;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SourceDTO {
    private int id;
    private String type;
    private String text;
    private String icon;
    //private int idMount;
    public static SourceDTO toDTO(Source source){
        return new SourceDTO(
                source.getId(),
                source.getType(),
                source.getType(),
                source.getIcon()/*,
                source.getIdMount()*/
        );
    }

    public static Source toObject(SourceDTO sourceDTO){
        return new Source(
                sourceDTO.getId(),
                sourceDTO.getType(),
                sourceDTO.getText(),
                sourceDTO.getIcon()/*,
                sourceDTO.getIdMount()*/
        );
    }
}
