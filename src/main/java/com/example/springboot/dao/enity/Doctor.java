package com.example.springboot.dao.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "doctor",
        catalog = "test",
        uniqueConstraints = @UniqueConstraint(columnNames = "phone")
)
public class Doctor implements java.io.Serializable {

    private Integer iddoctor;
    private Clinic clinic;
    private String name;
    private byte[] photo;
    private String phone;
    private String bio;
    private Set<Visit> visits = new HashSet<Visit>(0);

    public Doctor() {
    }

    public Doctor(Clinic clinic, String name, String phone) {
        this.clinic = clinic;
        this.name = name;
        this.phone = phone;
    }

    public Doctor(Clinic clinic, String name, byte[] photo, String phone, String bio, Set<Visit> visits) {
        this.clinic = clinic;
        this.name = name;
        this.photo = photo;
        this.phone = phone;
        this.bio = bio;
        this.visits = visits;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "iddoctor", unique = true, nullable = false)
    public Integer getIddoctor() {
        return this.iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_idclinic", nullable = false)
    public Clinic getClinic() {
        return this.clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "photo")
    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "phone", unique = true, nullable = false, length = 45)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "bio", length = 45)
    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    public Set<Visit> getVisits() {
        return this.visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

}
