package com.example.labxpert.Repository;

import com.example.labxpert.Model.Reactif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReactifRepository extends JpaRepository<Reactif,Long> {
}
