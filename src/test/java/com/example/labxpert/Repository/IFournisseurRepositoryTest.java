package com.example.labxpert.Repository;

import com.example.labxpert.Model.Enum.Sexe;
import com.example.labxpert.Model.Fournisseur;
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
class IFournisseurRepositoryTest {

    @Autowired
    private IFournisseurRepository iFournisseurRepository;

    @Test
    void patientRepository_saveOne_ReturnOnePatient()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        Fournisseur f = iFournisseurRepository.save(fournisseur);
        Assertions.assertThat(f).isNotNull();
        Assertions.assertThat(f.getId()).isGreaterThan(0);
    }

    @Test
    void patientRepository_deleteOnePatient_ReturnForDeleteIsEmpty()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        Fournisseur f = iFournisseurRepository.save(fournisseur);
        f.setDeleted(true);
        Fournisseur f2 = iFournisseurRepository.save(f);
        Fournisseur f3 = iFournisseurRepository.findByIdAndDeletedFalse(f2.getId()).orElse(null);
        Assertions.assertThat(f3).isNull();
    }

    @Test
    void patientRepository_updateOne_ReturnOnePatient()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        Fournisseur f1 = iFournisseurRepository.save(fournisseur);
        f1.setSocieteName("CBI");
        Fournisseur f2 = iFournisseurRepository.save(f1);
        Assertions.assertThat(f2.getSocieteName()).isEqualTo("CBI");
    }

    @Test
    void patientRepository_getAll_ReturnMoreThanOnePatient()
    {
        Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setNom("marouane mouslih");
        fournisseur1.setSocieteName("TIMAR");
        fournisseur1.setDeleted(false);

        Fournisseur fournisseur2 = new Fournisseur();
        fournisseur2.setNom("marouane mouslih");
        fournisseur2.setSocieteName("TIMAR");
        fournisseur2.setDeleted(false);

        Fournisseur fournisseur3 = new Fournisseur();
        fournisseur3.setNom("marouane mouslih");
        fournisseur3.setSocieteName("TIMAR");
        fournisseur3.setDeleted(false);

        Stream.of(fournisseur1,fournisseur2,fournisseur3).forEach(fournisseur -> {
            Fournisseur fournisseurSaved = iFournisseurRepository.save(fournisseur);
            Assertions.assertThat(fournisseurSaved).isNotNull();
        });

        List<Fournisseur> fournisseurs = iFournisseurRepository.findByDeletedFalse();
        Assertions.assertThat(fournisseurs).isNotEmpty();
    }

    @Test
    void patientRepository_getPatientById_ReturnOnePatientWithId()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        Fournisseur fournisseurSaved = iFournisseurRepository.save(fournisseur);
        Fournisseur fournisseurGet = iFournisseurRepository.findByIdAndDeletedFalse(fournisseurSaved.getId()).orElse(null);
        Assertions.assertThat(fournisseurGet).isNotNull();
    }

    @Test
    void fournisseurRepository_getFournisseurByName_ReturnFournisseurWithName()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        Fournisseur fournisseurSaved = iFournisseurRepository.save(fournisseur);
        Fournisseur fournisseurGetName = iFournisseurRepository.findByNomAndDeletedFalse(fournisseurSaved.getNom()).orElse(null);
        Assertions.assertThat(fournisseurGetName).isNotNull();
        Assertions.assertThat(fournisseurSaved.getNom()).isEqualTo(fournisseurGetName.getNom());
    }
}