package com.example.labxpert.Controller;

import com.example.labxpert.Dtos.FournisseurDto;
import com.example.labxpert.Model.Fournisseur;
import com.example.labxpert.Service.Impl.FournisseurServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(controllers = FournisseurController.class)
@ExtendWith(MockitoExtension.class)
class FournisseurControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FournisseurServiceImpl fournisseurService;

    @Autowired
    private ObjectMapper objectMapper;

    private Fournisseur fournisseur;
    private FournisseurDto fournisseurDto;

    @BeforeEach
    public void init()
    {
        fournisseur = new Fournisseur();
        fournisseur.setNom("marouane mouslih");
        fournisseur.setSocieteName("TIMAR");
        fournisseur.setDeleted(false);

        fournisseurDto = new FournisseurDto();
        fournisseurDto.setNom("marouane mouslih");
        fournisseurDto.setSocieteName("TIMAR");
        fournisseurDto.setDeleted(false);
    }

    @Test
    public void founisseurController_addFournisseur_ReturnFournisseur() throws Exception {
        given(fournisseurService.add(ArgumentMatchers.any(FournisseurDto.class)))
                .willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/v1/fournisseurs/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fournisseurDto)));

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void fournisseurController_getAllFournisseur_ReturnMoreThanFournisseur() throws Exception
    {
        when(fournisseurService.getAll()).thenReturn(Collections.singletonList(fournisseurDto));

        ResultActions response = mockMvc.perform(get("/api/v1/fournisseurs")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void fournisseurController_getByIDFournisseur_ReturnFournisseur() throws Exception {
        when(fournisseurService.getById(1L)).thenReturn(fournisseurDto);

        ResultActions response = mockMvc.perform(get("/api/v1/fournisseurs/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void fournisseursController_deleteFournisseurs_ReturnNothing() throws Exception {
        doNothing().when(fournisseurService).delete(1L);

        ResultActions response = mockMvc.perform(delete("/api/v1/fournisseurs/1/delete")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void fournisseursController_updateFournisseurs_ReturnFournisseurs() throws Exception {
        when(fournisseurService.update(1L, fournisseurDto)).thenReturn(fournisseurDto);

        ResultActions response = mockMvc.perform(put("/api/v1/fournisseurs/1/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fournisseurDto)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}