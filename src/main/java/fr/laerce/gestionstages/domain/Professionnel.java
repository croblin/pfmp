package fr.laerce.gestionstages.domain;

import javax.persistence.*;

@Entity
public class Professionnel extends Individu {

    @ManyToOne
    private Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
