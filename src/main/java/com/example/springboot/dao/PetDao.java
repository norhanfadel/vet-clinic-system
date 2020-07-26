/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.dao;

import com.example.springboot.dao.enity.Pet;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dan
 */
@Repository
public interface PetDao extends CrudRepository<Pet, Integer> {

    @Query(value = "from Pet p where p.owner.id=:owner")
    List<Pet> findOwnerPetsById(@Param(value = "owner") int id);

}
