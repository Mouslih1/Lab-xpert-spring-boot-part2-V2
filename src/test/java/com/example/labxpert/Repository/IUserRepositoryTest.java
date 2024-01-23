package com.example.labxpert.Repository;

import com.example.labxpert.Model.Enum.Role;
import com.example.labxpert.Model.Enum.Sexe;
import com.example.labxpert.Model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;


@DataJpaTest
class IUserRepositoryTest {

    @Autowired
    private IUserRepository iUserRepository;
    @Test
    void userRepository_saveOne_ReturnOneUser()
    {
        User user = new User();
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

        User u = iUserRepository.save(user);
        Assertions.assertThat(u).isNotNull();
        Assertions.assertThat(u.getId()).isGreaterThan(0);
    }

    @Test
    void userRepository_deleteOneUser_ReturnForDeleteIsEmpty()
    {
        User user = new User();
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

        User u = iUserRepository.save(user);
        u.setDeleted(true);
        User u2 = iUserRepository.save(u);
        User u3 = iUserRepository.findByIdAndDeletedFalse(u2.getId()).orElse(null);
        Assertions.assertThat(u3).isNull();
    }

    @Test
    void userRepository_updateOne_ReturnOneUser()
    {
        User user = new User();
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

        User u1 = iUserRepository.save(user);
        u1.setNom("CBI");
        User u2 = iUserRepository.save(u1);
        Assertions.assertThat(u2.getNom()).isEqualTo("CBI");
    }

    @Test
    void userRepository_getAll_ReturnMoreThanOneUser()
    {
        User user1 = new User();
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
        user2.setNom("marouane");
        user2.setPrenom("mouslih");
        user2.setTel("0630011246");
        user2.setSexe(Sexe.MALE);
        user2.setAddress("address 1");
        user2.setDateNaissance(LocalDate.of(2001,8,19));
        user2.setVille("casablanca");
        user2.setDeleted(false);
        user2.setRole(Role.Technicien);
        user2.setEmail("marou@gmail.com");
        user2.setPassword("123456");

        User user3 = new User();
        user3.setNom("marouane");
        user3.setPrenom("mouslih");
        user3.setTel("0630011246");
        user3.setSexe(Sexe.MALE);
        user3.setAddress("address 1");
        user3.setDateNaissance(LocalDate.of(2001,8,19));
        user3.setVille("casablanca");
        user3.setDeleted(false);
        user3.setRole(Role.Technicien);
        user3.setEmail("maroua@gmail.com");
        user3.setPassword("123456");

        Stream.of(user1,user2,user3).forEach(user -> {
            User userSaved = iUserRepository.save(user);
            Assertions.assertThat(userSaved).isNotNull();
        });

        List<User> users = iUserRepository.findByDeletedFalse();
        Assertions.assertThat(users).isNotEmpty();
    }

    @Test
    void userRepository_getUserById_ReturnOneUserWithId()
    {
        User user = new User();
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

        User userSaved = iUserRepository.save(user);
        User userGet = iUserRepository.findByIdAndDeletedFalse(userSaved.getId()).orElse(null);
        Assertions.assertThat(userGet).isNotNull();
    }

    @Test
    void userRepository_getUserByName_ReturnUserWithName()
    {
        User user = new User();
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

        User userSaved = iUserRepository.save(user);
        User userGetName = iUserRepository.findByNomAndDeletedFalse(userSaved.getNom()).orElse(null);
        Assertions.assertThat(userGetName).isNotNull();
        Assertions.assertThat(userSaved.getNom()).isEqualTo(userGetName.getNom());
    }

}