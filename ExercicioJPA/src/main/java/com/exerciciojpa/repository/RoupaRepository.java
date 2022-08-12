package com.exerciciojpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exerciciojpa.entidades.Roupa;

@Repository
public interface RoupaRepository extends CrudRepository<Roupa, Integer>{

}
