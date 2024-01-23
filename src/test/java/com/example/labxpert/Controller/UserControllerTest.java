package com.example.labxpert.Controller;

import com.example.labxpert.Dtos.UserDto;
import com.example.labxpert.Model.Enum.Role;
import com.example.labxpert.Model.Enum.Sexe;
import com.example.labxpert.Model.User;
import com.example.labxpert.Service.Impl.UserServiceImpl;
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

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;
    private UserDto userDto;

    @BeforeEach
    public void init()
    {
        user = new User();
        user.setId(1L);
        user.setNom("marouane");
        user.setPrenom("mouslih");
        user.setTel("0630011246");
        user.setSexe(Sexe.MALE);
        user.setAddress("address 1");
        user.setDateNaissance(LocalDate.of(2001,8,19));
        user.setVille("casablanca");
        user.setDeleted(false);
        user.setRole(Role.Technicien);
        user.setEmail("marouane@gmail.com");
        user.setPassword("123456");


        userDto = new UserDto();
        userDto.setId(1L);
        userDto.setNom("marouane");
        userDto.setPrenom("mouslih");
        userDto.setTel("0630011246");
        userDto.setSexe(Sexe.MALE);
        userDto.setAddress("address 1");
        userDto.setDateNaissance(LocalDate.of(2001,8,19));
        userDto.setVille("casablanca");
        userDto.setDeleted(false);
        userDto.setRole(Role.Technicien);
        userDto.setEmail("marouane@gmail.com");
        userDto.setPassword("123456");
    }

    @Test
    public void userController_addUser_ReturnUser() throws Exception {
        given(userService.add(ArgumentMatchers.any(UserDto.class)))
                .willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/v1/users/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)));

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void userController_getAllUser_ReturnMoreThanUser() throws Exception
    {
        when(userService.getAll()).thenReturn(Collections.singletonList(userDto));

        ResultActions response = mockMvc.perform(get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void userController_getByIDUser_ReturnUser() throws Exception {
        when(userService.getById(1L)).thenReturn(userDto);

        ResultActions response = mockMvc.perform(get("/api/v1/users/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void userController_deleteUser_ReturnNothing() throws Exception {
        doNothing().when(userService).delete(1L);

        ResultActions response = mockMvc.perform(delete("/api/v1/users/1/delete")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void userController_updateUser_ReturnUser() throws Exception {
        when(userService.update(1L, userDto)).thenReturn(userDto);

        ResultActions response = mockMvc.perform(put("/api/v1/users/1/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}