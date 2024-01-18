package com.example.labxpert.Dtos;

import com.example.labxpert.Model.Analyse;
import com.example.labxpert.Model.Echontillon;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Echontillon}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EchontillonDto implements Serializable {

    Long id;

    String codeEchontillon;

    @NotNull
    @JsonIgnoreProperties(value = "echontillons")
    PatientDto patient;

    @FutureOrPresent
    LocalDate date_p;

    @JsonIgnore
    @Builder.Default
    Boolean deleted = false;

    List<Analyse> analyses;
}