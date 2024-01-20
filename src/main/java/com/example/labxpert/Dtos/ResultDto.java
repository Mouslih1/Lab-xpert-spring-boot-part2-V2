package com.example.labxpert.Dtos;

import com.example.labxpert.Model.Result;
import com.example.labxpert.Model.SousAnalyse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Result}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDto implements Serializable {
    Long id;
    double valeur_result;
    String unite_mesure;
    SousAnalyse sousAnalyse;

    @JsonIgnore
    @Builder.Default
    Boolean deleted = false;
}