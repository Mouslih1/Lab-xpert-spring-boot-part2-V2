package com.example.labxpert.Model;

import com.example.labxpert.Model.Enum.PeriodeRapport;
import com.example.labxpert.Model.Enum.TypeRapport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rapport_statistiques")
public class RapportStatistique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeRapport typeRapport;

    @Enumerated(EnumType.STRING)
    private PeriodeRapport periodeRapport;

    private String donnee_statistique;

    private String graphic;
}
