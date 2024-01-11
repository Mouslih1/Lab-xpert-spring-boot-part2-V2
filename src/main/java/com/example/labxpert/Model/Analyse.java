package com.example.labxpert.Model;

import com.example.labxpert.Model.Enum.StatusResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "analyses")
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User technicienResponsable;

    @ManyToOne
    private Echontillon echontillon;

    @Enumerated(EnumType.STRING)
    private StatusResult statusResult;

    private LocalDate date_debut;
    private LocalDate date_fin;
    private String commantaires;

    @OneToMany(mappedBy = "analyse", fetch = FetchType.LAZY)
    private List<SousAnalyse> sousAnalyses;
}
