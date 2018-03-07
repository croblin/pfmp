package fr.laerce.gestionstages.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(unique = true)
    private String code;
    @Column
    private String libelle;
    @ManyToOne
    private Niveau niveau;
    @OneToMany(mappedBy = "division")
    private List<Eleve> eleves;
    @ManyToMany(mappedBy = "divisions")
    private Set<Formateur> formateurs = new HashSet<>();


    public Set<Formateur> getFormateurs() {
        return formateurs;
    }

    public void setFormateurs(Set<Formateur> formateurs) {
        this.formateurs = formateurs;
    }

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals(getId(), division.getId()) &&
                Objects.equals(getCode(), division.getCode()) &&
                Objects.equals(getLibelle(), division.getLibelle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getLibelle());
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public void addFormateur(Formateur formateur) {
        this.getFormateurs().add(formateur);
    }

    public void removeFormateur(Formateur formateur) {
        this.getFormateurs().remove(formateur);
    }

}
