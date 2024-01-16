package com.example.labxpert.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resultats")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valeur_result;
    private String unite_mesure;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @OneToOne
    private SousAnalyse sousAnalyse;
}
