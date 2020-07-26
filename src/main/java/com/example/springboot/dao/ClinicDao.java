/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.dao;

import com.example.springboot.dao.enity.Clinic;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dan
 */
@Repository
public interface ClinicDao extends CrudRepository<Clinic, Integer> {

    List<Clinic> findByAddressOrPhone(String Phone, String Address);

}
