package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.UserDto;
import com.example.labxpert.Model.Enum.Role;
import com.example.labxpert.Model.Enum.Sexe;
import com.example.labxpert.Model.User;
import com.example.labxpert.Repository.IUserRepository;
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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    @DisplayName("Instantiation object iUserRepository par .mock & modelMapper & UserService")
    public void setup()
    {
        iUserRepository = Mockito.mock(IUserRepository.class);
        ModelMapper modelMapper = new ModelMapper();
        userService = new UserServiceImpl(iUserRepository, modelMapper);
    }

    @Test
    @DisplayName("userService_saveUser_ReturnOneUser")
    public void userService_saveUser_ReturnOneUser()
    {
        User user = new User();
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

        UserDto userDto = new UserDto();
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

        when(iUserRepository.save(Mockito.any(User.class))).thenReturn(user);

        UserDto userSaved = userService.add(userDto);
        System.out.println(userSaved);
        System.out.println(user.getNom());
        Assertions.assertThat(userSaved.getId()).isEqualTo(user.getId());
        Assertions.assertThat(userSaved).isNotNull();
    }

    @Test
    @DisplayName("userService_getUserByIdUser_ReturnOneUser")
    public void userService_getUserByIdUser_ReturnOneUser()
    {
        User user = new User();
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

        UserDto userDto = new UserDto();
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

        when(iUserRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(user));

        UserDto userDtoSaved = userService.getById(1L);
        Assertions.assertThat(userDtoSaved).isNotNull();
        Assertions.assertThat(userDtoSaved.getId()).isEqualTo(user.getId());
    }

    @Test
    @DisplayName("userRepository_updateUser_ReturnOneUserUpdated")
    public void userRepository_updateUser_ReturnOneUserUpdated()
    {
        User user = new User();
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

        UserDto userDto = new UserDto();
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

        when(iUserRepository.save(Mockito.any(User.class))).thenReturn(user);
        when(iUserRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(user));


        UserDto userDtoUpdated = userService.update(1L, userDto);
        System.out.println(userDtoUpdated);
        System.out.println(user.getNom() + " " + user.getAddress() + " " +  user.getPrenom());
        Assertions.assertThat(userDtoUpdated).isNotNull();
        Assertions.assertThat(userDtoUpdated.getAddress()).isEqualTo(user.getAddress());
    }

    @Test
    @DisplayName("userService_deleteByIdUser_Return0User")
    public void userService_deleteByIdUser_Return0User()
    {
        User user = new User();
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


        when(iUserRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(user));

        assertAll(() -> userService.delete(1L));
    }

    @Test
    @DisplayName("patientService_getAllPatient_ReturnMoreThanOnePatient")
    public void patientService_getAllPatient_ReturnMoreThanOnePatient()
    {
        User user1 = new User();
        user1.setId(1L);
        user1.setNom("marouane");
        user1.setPrenom("mouslih");
        user1.setTel("0630011246");
        user1.setSexe(Sexe.MALE);
        user1.setAddress("address 1");
        user1.setDateNaissance(LocalDate.of(2001,8,19));
        user1.setVille("casablanca");
        user1.setDeleted(false);
        user1.setRole(Role.Technicien);
        user1.setEmail("marouane@gmail.com");
        user1.setPassword("123456");

        User user2 = new User();
        user2.setId(1L);
        user2.setNom("marouane");
        user2.setPrenom("mouslih");
        user2.setTel("0630011246");
        user2.setSexe(Sexe.MALE);
        user2.setAddress("address 1");
        user2.setDateNaissance(LocalDate.of(2001,8,19));
        user2.setVille("casablanca");
        user2.setDeleted(false);
        user2.setRole(Role.Technicien);
        user2.setEmail("marouane@gmail.com");
        user2.setPassword("123456");

        User user3 = new User();
        user3.setId(1L);
        user3.setNom("marouane");
        user3.setPrenom("mouslih");
        user3.setTel("0630011246");
        user3.setSexe(Sexe.MALE);
        user3.setAddress("address 1");
        user3.setDateNaissance(LocalDate.of(2001,8,19));
        user3.setVille("casablanca");
        user3.setDeleted(false);
        user3.setRole(Role.Technicien);
        user3.setEmail("marouane@gmail.com");
        user3.setPassword("123456");

        UserDto userDto = new UserDto();
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

        when(iUserRepository.findByDeletedFalse()).thenReturn(Arrays.asList(user1, user2, user3));

        List<UserDto> userAll = userService.getAll();
        System.out.println(userAll);
        Assertions.assertThat(userAll).isNotEmpty();
        Assertions.assertThat(userAll).hasSize(3);
    }
}