package com.example.labxpert.Repository;

import com.example.labxpert.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person,Long> {
}
