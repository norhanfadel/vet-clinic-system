package com.example.springboot.dao.enity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "visit",
        catalog = "test"
)
public class Visit implements java.io.Serializable {

    private int vistid;
    private Clinic clinic;
    private Doctor doctor;
    private Pet pet;
    private Date date;

    public Visit() {
    }

    public Visit(int vistid, Clinic clinic, Doctor doctor, Pet pet, Date date) {
        this.vistid = vistid;
        this.clinic = clinic;
        this.doctor = doctor;
        this.pet = pet;
        this.date = date;
    }

    @Id

    @Column(name = "vistid", unique = true, nullable = false)
    public int getVistid() {
        return this.vistid;
    }

    public void setVistid(int vistid) {
        this.vistid = vistid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_idclinic", nullable = false)
    public Clinic getClinic() {
        return this.clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_iddoctor", nullable = false)
    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_idPet", nullable = false)
    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, length = 19)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
