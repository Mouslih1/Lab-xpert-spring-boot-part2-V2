package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.MaterialDto;
import com.example.labxpert.Model.Material;
import com.example.labxpert.Repository.IMaterialRepository;
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
class MaterialServiceImplTest {

    @Mock
    private IMaterialRepository iMaterialRepository;

    @InjectMocks
    private  MaterialServiceImpl materialService;


    @BeforeEach
    @DisplayName("Instantiation object iMaterialRepository par .mock & modelMapper & MaterialService")
    public void setup()
    {
        iMaterialRepository = Mockito.mock(IMaterialRepository.class);
        ModelMapper modelMapper = new ModelMapper();
        materialService = new MaterialServiceImpl(iMaterialRepository, modelMapper);
    }

    @Test
    @DisplayName("materialService_saveMaterial_ReturnOneFournisseur")
    public void materialService_saveMaterial_ReturnOneFournisseur()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        MaterialDto materialDto = new MaterialDto();
        materialDto.setLibelle("libelle1");
        materialDto.setAvailableQuantity(30);
        materialDto.setPrice(2100);
        materialDto.setDeleted(false);

        when(iMaterialRepository.save(Mockito.any(Material.class))).thenReturn(material);

        MaterialDto materialDtoSaved = materialService.add(materialDto);
        System.out.println(materialDtoSaved);
        System.out.println(material.getLibelle());
        Assertions.assertThat(materialDtoSaved.getId()).isEqualTo(material.getId());
        Assertions.assertThat(materialDtoSaved).isNotNull();
    }

    @Test
    @DisplayName("materialService_getMaterialByIdMaterial_ReturnOneMaterial")
    public void materialService_getMaterialByIdMaterial_ReturnOneMaterial()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        MaterialDto materialDto = new MaterialDto();
        materialDto.setLibelle("libelle1");
        materialDto.setAvailableQuantity(30);
        materialDto.setPrice(2100);
        materialDto.setDeleted(false);

        when(iMaterialRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(material));

        MaterialDto materialDtoSaved = materialService.getById(1L);
        Assertions.assertThat(materialDtoSaved).isNotNull();
        Assertions.assertThat(materialDtoSaved.getId()).isEqualTo(material.getId());
    }

    @Test
    @DisplayName("materialRepository_updateMaterial_ReturnOneMaterialUpdated")
    public void materialRepository_updateMaterial_ReturnOneMaterialUpdated()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);

        MaterialDto materialDto = new MaterialDto();
        materialDto.setLibelle("libelle1");
        materialDto.setAvailableQuantity(30);
        materialDto.setPrice(2100);
        materialDto.setDeleted(false);

        when(iMaterialRepository.save(Mockito.any(Material.class))).thenReturn(material);
        when(iMaterialRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(material));


        MaterialDto materialDtoUpdated = materialService.update(1L, materialDto);
        System.out.println(materialDtoUpdated);
        System.out.println(material.getLibelle());
        Assertions.assertThat(materialDtoUpdated).isNotNull();
        Assertions.assertThat(materialDtoUpdated.getLibelle()).isEqualTo(material.getLibelle());
    }

    @Test
    @DisplayName("materialService_deleteByIdMaterial_Return0Material")
    public void materialService_deleteByIdMaterial_Return0Material()
    {
        Material material = new Material();
        material.setLibelle("libelle1");
        material.setAvailableQuantity(30);
        material.setPrice(2100);
        material.setDeleted(false);


        when(iMaterialRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(material));

        assertAll(() -> materialService.delete(1L));
    }

    @Test
    @DisplayName("materialService_getAllMaterial_ReturnMoreThanOneMaterial")
    public void materialService_getAllMaterial_ReturnMoreThanOneMaterial()
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

        MaterialDto materialDto = new MaterialDto();
        materialDto.setLibelle("libelle1");
        materialDto.setAvailableQuantity(30);
        materialDto.setPrice(2100);
        materialDto.setDeleted(false);

        when(iMaterialRepository.findByDeletedFalse()).thenReturn(Arrays.asList(material1, material2, material3));

        List<MaterialDto> materialAll = materialService.getAll();
        System.out.println(materialAll);
        Assertions.assertThat(materialAll).isNotEmpty();
        Assertions.assertThat(materialAll).hasSize(3);
    }
}