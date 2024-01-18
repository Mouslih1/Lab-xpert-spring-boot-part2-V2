package com.example.labxpert.Dtos;

import com.example.labxpert.Dtos.EchontillonDto;
import com.example.labxpert.Dtos.MaterialDto;
import com.example.labxpert.Model.EchontillonMaterial;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * DTO for {@link EchontillonMaterial}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EchontillonMaterialDto implements Serializable {

    Long id;

    @NotNull
    EchontillonDto echontillon;

    @NonNull
    MaterialDto material;

    @Min(0)
    @Positive
    int quantity;

    @Min(0)
    @Positive
    double price_total;

    @Builder.Default
    Boolean deleted = false;
}