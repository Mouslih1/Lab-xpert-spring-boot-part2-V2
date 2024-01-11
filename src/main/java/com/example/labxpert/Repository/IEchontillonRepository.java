package com.example.labxpert.Repository;

import com.example.labxpert.Model.Echontillon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEchontillonRepository extends JpaRepository<Echontillon, Long> {
}
