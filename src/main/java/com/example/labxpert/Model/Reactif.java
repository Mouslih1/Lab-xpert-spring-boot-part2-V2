package com.example.labxpert.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reactifs")
public class Reactif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private int quantity_stock;
    private LocalDate date_exp;

    private Boolean is_delete;

    @ToString.Exclude
    @ManyToOne
    private Fournisseur fournisseur;
}
