package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.FournisseurDto;
import com.example.labxpert.Model.Fournisseur;
import com.example.labxpert.Repository.IFournisseurRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IFournisseurServiceTest {

    @Mock
    private IFournisseurRepository iFournisseurRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @BeforeEach
    @DisplayName("Instantiation object iFournisseurRepository par .mock & modelMapper & FournisseurService")
    public void setup()
    {
        iFournisseurRepository = Mockito.mock(IFournisseurRepository.class);
        ModelMapper modelMapper = new ModelMapper();
        fournisseurService = new FournisseurServiceImpl(iFournisseurRepository, modelMapper);
    }

    @Test
    @DisplayName("fournisseurService_saveFournisseur_ReturnOneFournisseur")
    public void fournisseurService_saveFournisseur_ReturnOneFournisseur()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        FournisseurDto fournisseurDto = new FournisseurDto();
        fournisseurDto.setNom("marouane mouslih");
        fournisseurDto.setSocieteName("TIMAR");
        fournisseurDto.setDeleted(false);

        when(iFournisseurRepository.save(Mockito.any(Fournisseur.class))).thenReturn(fournisseur);

        FournisseurDto fournisseurDtoSaved = fournisseurService.add(fournisseurDto);
        System.out.println(fournisseurDtoSaved);
        System.out.println(fournisseur.getNom());
        Assertions.assertThat(fournisseurDtoSaved.getId()).isEqualTo(fournisseur.getId());
        Assertions.assertThat(fournisseurDtoSaved).isNotNull();
    }

    @Test
    @DisplayName("founisseurService_getFournisseurByIdFournisseur_ReturnOneFournisseur")
    public void founisseurService_getFournisseurByIdFournisseur_ReturnOneFournisseur()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        FournisseurDto fournisseurDto = new FournisseurDto();
        fournisseurDto.setNom("marouane mouslih");
        fournisseurDto.setSocieteName("TIMAR");
        fournisseurDto.setDeleted(false);

        when(iFournisseurRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(fournisseur));

        FournisseurDto fournisseurDtoSaved = fournisseurService.getById(1L);
        Assertions.assertThat(fournisseurDtoSaved).isNotNull();
        Assertions.assertThat(fournisseurDtoSaved.getId()).isEqualTo(fournisseur.getId());
    }

    @Test
    @DisplayName("founisseurRepository_updateFournisseur_ReturnOneFournisseurUpdated")
    public void founisseurRepository_updateFournisseur_ReturnOneFournisseurUpdated()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        FournisseurDto fournisseurDto = new FournisseurDto();
        fournisseurDto.setNom("marouane mouslih");
        fournisseurDto.setSocieteName("TIMAR");
        fournisseurDto.setDeleted(false);

        when(iFournisseurRepository.save(Mockito.any(Fournisseur.class))).thenReturn(fournisseur);
        when(iFournisseurRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(fournisseur));


        FournisseurDto fournisseurDtoUpdated = fournisseurService.update(1L, fournisseurDto);
        System.out.println(fournisseurDtoUpdated);
        System.out.println(fournisseur.getNom());
        Assertions.assertThat(fournisseurDtoUpdated).isNotNull();
        Assertions.assertThat(fournisseurDtoUpdated.getNom()).isEqualTo(fournisseur.getNom());
    }

    @Test
    @DisplayName("fournisseurService_deleteByIdFournisseur_Return0Fournisseur")
    public void fournisseurService_deleteByIdFournisseur_Return0Fournisseur()
    {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);


        when(iFournisseurRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(fournisseur));

        assertAll(() -> fournisseurService.delete(1L));
    }

    @Test
    @DisplayName("fournisseurService_getAllFournisseur_ReturnMoreThanOneFournisseur")
    public void fournisseurService_getAllFournisseur_ReturnMoreThanOneFournisseur()
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

        FournisseurDto fournisseurDto = new FournisseurDto();
        fournisseurDto.setNom("marouane mouslih");
        fournisseurDto.setSocieteName("TIMAR");
        fournisseurDto.setDeleted(false);

        when(iFournisseurRepository.findByDeletedFalse()).thenReturn(Arrays.asList(fournisseur1, fournisseur2, fournisseur3));

        List<FournisseurDto> fournisseurAll = fournisseurService.getAll();
        System.out.println(fournisseurAll);
        Assertions.assertThat(fournisseurAll).isNotEmpty();
        Assertions.assertThat(fournisseurAll).hasSize(3);
    }
}