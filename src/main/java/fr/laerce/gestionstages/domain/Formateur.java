package fr.laerce.gestionstages.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Formateur extends Individu {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Discipline> disciplines;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Division> divisions;

    public Formateur() {
        super();
        this.divisions = new HashSet<>();
        this.disciplines = new HashSet<>();
    }

    public Set<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(Set<Division> divisions) {
        this.divisions = divisions;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public void addDiscipline(Discipline discipline) {
        this.disciplines.add(discipline);
        // gestion du lien inverse
        discipline.addFormateur(this);
    }

    public void addDivision(Division division) {
        this.divisions.add(division);
        // gestion du lien inverse
        division.addFormateur(this);
    }
}
