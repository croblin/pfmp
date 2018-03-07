package fr.laerce.gestionstages.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column
    private String raison;

    @OneToMany(mappedBy = "entreprise")
    private List<Professionnel> professionnels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public List<Professionnel> getProfessionnels() {
        return professionnels;
    }

    public void setProfessionnels(List<Professionnel> professionnels) {
        this.professionnels = professionnels;
    }
}
