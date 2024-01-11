package com.example.labxpert.Repository;

import com.example.labxpert.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
