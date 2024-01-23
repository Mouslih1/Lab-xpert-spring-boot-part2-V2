package com.example.labxpert.Repository;

import com.example.labxpert.Model.Enum.Sexe;
import com.example.labxpert.Model.Material;
import com.example.labxpert.Model.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IMaterialRepositoryTest {

    @Autowired
    private IMaterialRepository iMaterialRepository;


    @Test
    void materialRepository_saveOne_ReturnOneMaterial()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        Material m = iMaterialRepository.save(material);
        Assertions.assertThat(m).isNotNull();
        Assertions.assertThat(m.getId()).isGreaterThan(0);
    }

    @Test
    void materialRepository_deleteOneMaterial_ReturnForDeleteIsEmpty()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        Material m = iMaterialRepository.save(material);
        m.setDeleted(true);
        Material m2 = iMaterialRepository.save(m);
        Material m3 = iMaterialRepository.findByIdAndDeletedFalse(m2.getId()).orElse(null);
        Assertions.assertThat(m3).isNull();
    }

    @Test
    void materialRepository_updateOne_ReturnOneMaterial()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        Material m1 = iMaterialRepository.save(material);
        m1.setLibelle("libelle2");
        Material m2 = iMaterialRepository.save(m1);
        Assertions.assertThat(m2.getLibelle()).isEqualTo("libelle2");
    }

    @Test
    void materialRepository_getAll_ReturnMoreThanOneMaterial()
    {
        Material material1 = new Material();
        material1.setLibelle("libelle1");
        material1.setAvailableQuantity(30);
        material1.setPrice(2100);
        material1.setDeleted(false);

        Material material2 = new Material();
        material2.setLibelle("libelle1");
        material2.setAvailableQuantity(30);
        material2.setPrice(2100);
        material2.setDeleted(false);

        Material material3 = new Material();
        material3.setLibelle("libelle1");
        material3.setAvailableQuantity(30);
        material3.setPrice(2100);
        material3.setDeleted(false);

        Stream.of(material1,material2,material3).forEach(material -> {
            Material materialSaved = iMaterialRepository.save(material);
            Assertions.assertThat(materialSaved).isNotNull();
        });

        List<Material> materials = iMaterialRepository.findByDeletedFalse();
        Assertions.assertThat(materials).isNotEmpty();
    }

    @Test
    void patientRepository_getPatientById_ReturnOnePatientWithId()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        Material materialSaved = iMaterialRepository.save(material);
        Material materialGet = iMaterialRepository.findByIdAndDeletedFalse(materialSaved.getId()).orElse(null);
        Assertions.assertThat(materialGet).isNotNull();
    }

    @Test
    void patientRepository_getPatientByLibelle_ReturnOnePatientWithId()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        Material materialSaved = iMaterialRepository.save(material);
        Material materialGet = iMaterialRepository.findByLibelleAndDeletedFalse(materialSaved.getLibelle()).orElse(null);
        Assertions.assertThat(materialGet).isNotNull();
    }

    @Test
    void patientRepository_getPatientByPrice_ReturnOnePatientWithId()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        Material materialSaved = iMaterialRepository.save(material);
        List<Material> materialGet = iMaterialRepository.findByPriceBeforeAndDeletedFalse(materialSaved.getPrice());
        Assertions.assertThat(materialGet).isNotNull();
    }
}