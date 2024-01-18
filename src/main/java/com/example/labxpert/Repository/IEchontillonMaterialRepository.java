package com.example.labxpert.Repository;

import com.example.labxpert.Model.EchontillonMaterial;
import com.example.labxpert.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEchontillonMaterialRepository extends JpaRepository<EchontillonMaterial,Long> {
    List<EchontillonMaterial> findByDeletedFalse();
    Optional<EchontillonMaterial> findByIdAndDeletedFalse(Long id);
}
