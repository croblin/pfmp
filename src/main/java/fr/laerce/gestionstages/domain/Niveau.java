package fr.laerce.gestionstages.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(length = 8, nullable = false, name="code", unique = true)
    private String code;
    @Column(length = 15)
    private String libelleCourt;
    @Column(length = 50)
    private String libelleLong;
    @OneToMany(mappedBy = "niveau")
    private Set<Division> divisions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelleCourt() {
        return libelleCourt;
    }

    public void setLibelleCourt(String libelleCourt) {
        this.libelleCourt = libelleCourt;
    }

    public String getLibelleLong() {
        return libelleLong;
    }

    public void setLibelleLong(String libelleLong) {
        this.libelleLong = libelleLong;
    }

    public Set<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(Set<Division> divisions) {
        this.divisions = divisions;
    }

    public void addDivision(Division division){
        divisions.add(division);
    }

    public void removeDivision(Division division){
        divisions.remove(division);
    }



    @Override
    public String toString() {
        return "Niveau{" +
                "code='" + code + '\'' +
                ", libelleCourt='" + libelleCourt + '\'' +
                ", libelleLong='" + libelleLong + '\'' +
                '}';
    }
}
