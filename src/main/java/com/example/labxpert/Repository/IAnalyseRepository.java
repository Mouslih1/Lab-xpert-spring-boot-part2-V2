package com.example.labxpert.Repository;

import com.example.labxpert.Model.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnalyseRepository extends JpaRepository<Analyse,Long> {
}
