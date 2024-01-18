package com.example.labxpert.Repository;

import com.example.labxpert.Model.Result;
import com.example.labxpert.Model.SousAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISousAnalyseRepository extends JpaRepository<SousAnalyse,Long> {
    List<SousAnalyse> findByDeletedFalse();
    Optional<SousAnalyse> findByIdAndDeletedFalse(Long id);
}
