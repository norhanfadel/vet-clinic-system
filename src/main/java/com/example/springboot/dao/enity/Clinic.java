package com.example.springboot.dao.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "clinic",
        catalog = "test",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "email"),
            @UniqueConstraint(columnNames = "phone")}
)
public class Clinic implements java.io.Serializable {

    private int idclinic;
    private String name;
    private String address;
    private String phone;
    private String workingDays;
    private String email;
    private String url;
    private Set<Doctor> doctors = new HashSet<Doctor>(0);
    private Set<Visit> visits = new HashSet<Visit>(0);

    public Clinic() {
    }

    public Clinic(int idclinic, String name, String phone) {
        this.idclinic = idclinic;
        this.name = name;
        this.phone = phone;
    }

    public Clinic(int idclinic, String name, String address, String phone, String workingDays, String email, String url, Set<Doctor> doctors, Set<Visit> visits) {
        this.idclinic = idclinic;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.workingDays = workingDays;
        this.email = email;
        this.url = url;
        this.doctors = doctors;
        this.visits = visits;
    }

    @Id

    @Column(name = "idclinic", unique = true, nullable = false)
    public int getIdclinic() {
        return this.idclinic;
    }

    public void setIdclinic(int idclinic) {
        this.idclinic = idclinic;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", length = 45)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phone", unique = true, nullable = false, length = 45)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "working_days", length = 45)
    public String getWorkingDays() {
        return this.workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    @Column(name = "email", unique = true, length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "url", length = 2083)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
    public Set<Doctor> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
    public Set<Visit> getVisits() {
        return this.visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

}
