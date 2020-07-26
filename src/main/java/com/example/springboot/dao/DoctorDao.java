/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.dao;

import com.example.springboot.dao.enity.Doctor;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dan
 */
@Repository
public interface DoctorDao extends CrudRepository<Doctor, Integer> {

    @Query(value = "from Doctor d where d.id=:id")
    List<Doctor> findAccountById(@Param(value = "id") int id);

    @Query(value = "from Doctor d where d.clinic.idclinic=:id")
    List<Doctor> findDoctorByClinicId(@Param(value = "id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE Doctor d SET d.clinic.idclinic=:idclinic WHERE d.id = :id")
    void updateClinic(@Param("id") int id, @Param("idclinic") int idclinic);
}
