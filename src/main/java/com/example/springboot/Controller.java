package com.example.springboot;

import com.example.springboot.dao.ClinicDao;
import com.example.springboot.dao.DoctorDao;
import com.example.springboot.dao.OwnerDao;
import com.example.springboot.dao.PetDao;
import com.example.springboot.dao.enity.Clinic;
import com.example.springboot.dao.enity.Doctor;
import com.example.springboot.dao.enity.Owner;
import com.example.springboot.dao.enity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class Controller {

    @Autowired
    DoctorDao doctorDao;
    @Autowired
    OwnerDao ownerDao;
    @Autowired
    PetDao petDao;
    @Autowired
    ClinicDao clinicDao;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/getDoctors")
    public Iterable<Doctor> getDoctors() {

        return doctorDao.findAll();
    }

    @GetMapping("/getDoctorById/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable int id) throws InvalidParameterException {
        if (!doctorDao.findById(id).isPresent()) {
            throw new InvalidParameterException("not valid parameter");
        } else {
            return doctorDao.findById(id);
        }
    }

    @GetMapping("/getClinicById/{id}")
    public Optional<Clinic> getClinicById(@PathVariable int id) throws InvalidParameterException {
        if (!clinicDao.findById(id).isPresent()) {
            throw new InvalidParameterException("not valid parameter");
        } else {
            return clinicDao.findById(id);
        }
    }

    @GetMapping("/getPetsById/{id}")
    public Optional<Pet> findPetsById(@PathVariable int id) throws InvalidParameterException {
        if (!petDao.findById(id).isPresent()) {
            throw new InvalidParameterException("not valid parameter");
        } else {
            return petDao.findById(id);
        }
    }

    @GetMapping("/getOwnerById/{id}")
    public Optional<Owner> findOwnerById(@PathVariable int id) throws InvalidParameterException {
        if (!ownerDao.findById(id).isPresent()) {
            throw new InvalidParameterException("not valid parameter");
        } else {
            return ownerDao.findById(id);
        }
    }

    @GetMapping("/getOwnerPetsById/{id}")
    public List<Pet> findOwnerPetsById(@PathVariable int id) throws InvalidParameterException {
        if (petDao.findOwnerPetsById(id).isEmpty()) {
            throw new InvalidParameterException("not valid parameter");
        } else {
            return petDao.findOwnerPetsById(id);
        }
    }

    @GetMapping("/getDoctorByClinicId/{id}")
    public List<Doctor> findDoctorByClinicId(@PathVariable int id) throws InvalidParameterException {
        if (doctorDao.findDoctorByClinicId(id).isEmpty()) {
            throw new InvalidParameterException("not valid parameter");
        } else {
            return doctorDao.findDoctorByClinicId(id);
        }
    }

    @GetMapping("/getByPhoneOrAddress/{PhoneOrAddress}")
    public List<Clinic> findByPhoneOrAddress(@PathVariable String PhoneOrAddress) throws InvalidParameterException {
        if (clinicDao.findByAddressOrPhone(PhoneOrAddress, PhoneOrAddress).isEmpty()) {
            throw new InvalidParameterException("not valid parameter");
        } else {
            return clinicDao.findByAddressOrPhone(PhoneOrAddress, PhoneOrAddress);
        }
    }

    @PutMapping("update/{id}/{idclinic}")
    public String updateClinic(@PathVariable("id") int id, @PathVariable("idclinic") int idclinic
    ) {

        if (!doctorDao.findById(id).isPresent() || !clinicDao.findById(idclinic).isPresent()) {
            return "Doctor Id is False Or Clinic Id is False";
        } else {
            doctorDao.updateClinic(id, idclinic);
            return "updated done";
        }
    }

}
