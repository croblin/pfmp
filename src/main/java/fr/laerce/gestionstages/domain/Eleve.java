package fr.laerce.gestionstages.domain;

import javax.persistence.*;

@Entity
public class Eleve extends Individu {

    @ManyToOne
    private Division division;

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
