package com.example.labxpert.Model;

import com.example.labxpert.Model.Enum.StatusEchontillon;
import com.example.labxpert.Model.Enum.TypeAnalyse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "echontillons")
public class Echontillon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private TypeAnalyse typeAnalyse;

    private LocalDate date_p;

    @Enumerated(EnumType.STRING)
    private StatusEchontillon statusEchontillon;

    @OneToMany(mappedBy = "echontillons", fetch = FetchType.EAGER)
    private List<Analyse> analyses;
}
