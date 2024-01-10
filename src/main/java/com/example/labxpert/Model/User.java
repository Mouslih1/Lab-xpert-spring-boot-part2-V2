package com.example.labxpert.Model;

import com.example.labxpert.Model.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
public class User extends Person {

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Analyse> analyses;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Planification> planifications;
}
