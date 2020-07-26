package com.example.springboot.dao.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pet",
        catalog = "test"
)
public class Pet implements java.io.Serializable {

    private Integer idPet;
    private Owner owner;
    private String name;
    private char gender;
    private Date birthDate;
    private String kind;
    private byte[] photo;
    private int weigth;
    private Set<Visit> visits = new HashSet<Visit>(0);

    public Pet() {
    }

    public Pet(Owner owner, String name, char gender, int weigth) {
        this.owner = owner;
        this.name = name;
        this.gender = gender;
        this.weigth = weigth;
    }

    public Pet(Owner owner, String name, char gender, Date birthDate, String kind, byte[] photo, int weigth, Set<Visit> visits) {
        this.owner = owner;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.kind = kind;
        this.photo = photo;
        this.weigth = weigth;
        this.visits = visits;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idPet", unique = true, nullable = false)
    public Integer getIdPet() {
        return this.idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id_owner", nullable = false)
    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "gender", nullable = false, length = 1)
    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthDate", length = 19)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "kind", length = 45)
    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Column(name = "Photo")
    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "weigth", nullable = false)
    public int getWeigth() {
        return this.weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
    public Set<Visit> getVisits() {
        return this.visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

}
