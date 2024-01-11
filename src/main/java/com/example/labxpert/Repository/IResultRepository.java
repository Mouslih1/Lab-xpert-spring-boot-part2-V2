package com.example.labxpert.Repository;

import com.example.labxpert.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepository extends JpaRepository<Result,Long> {
}
