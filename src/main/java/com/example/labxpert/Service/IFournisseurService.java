package com.example.labxpert.Service;


import com.example.labxpert.Model.Fournisseur;

import java.util.List;

public interface IFournisseurService {
    Fournisseur add(Fournisseur fournisseur);
    Fournisseur update(Fournisseur fournisseur);
    void delete(Long id);
    List<Fournisseur> getAll();
    Fournisseur getById(Long id);
}
