package com.exercicioapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exercicioapi.entidade.Roupa;

@Repository
public interface RoupaRepository extends CrudRepository<Roupa, Long> {

}
