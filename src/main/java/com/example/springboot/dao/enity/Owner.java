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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "owner",
        catalog = "test",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "email"),
            @UniqueConstraint(columnNames = "phone")}
)
public class Owner implements java.io.Serializable {

    private Integer idOwner;
    private String name;
    private String email;
    private String phone;
    private Character gender;
    private String address;
    private Set<Pet> pets = new HashSet<Pet>(0);

    public Owner() {
    }

    public Owner(String name) {
        this.name = name;
    }

    public Owner(String name, String email, String phone, Character gender, String address, Set<Pet> pets) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.pets = pets;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id_owner", unique = true, nullable = false)
    public Integer getIdOwner() {
        return this.idOwner;
    }

    public void setIdOwner(Integer idOwner) {
        this.idOwner = idOwner;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", unique = true, length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone", unique = true, length = 45)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "gender", length = 1)
    public Character getGender() {
        return this.gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Column(name = "address", length = 45)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    public Set<Pet> getPets() {
        return this.pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

}
