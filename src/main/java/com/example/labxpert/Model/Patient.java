package com.example.labxpert.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "patients")
public class Patient extends Person{

    private double age;

    private Boolean is_delete;

    @ToString.Exclude
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Echontillon> echontillons = new ArrayList<>();
}
