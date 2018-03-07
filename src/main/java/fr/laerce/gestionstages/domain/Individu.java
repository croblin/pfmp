package fr.laerce.gestionstages.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Individu implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    String civilite;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String codeSynchro;
    @Column
    private String telephoneMobile;
    @Column
    private String telephoneFixe;
    @Column
    private String email;
    @Column(unique = true)
    private String login;
    @Column
    private String mdp;
    @Column
    private String mdpOrigine;
    @Column
    private String role = "NOT_USER";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCodeSynchro() {
        return codeSynchro;
    }

    public void setCodeSynchro(String codeSynchro) {
        this.codeSynchro = codeSynchro;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public String getTelephoneFixe() {
        return telephoneFixe;
    }

    public void setTelephoneFixe(String telephoneFixe) {
        this.telephoneFixe = telephoneFixe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdpOrigine() {
        return mdpOrigine;
    }

    public void setMdpOrigine(String mdpOrigine) {
        this.mdpOrigine = mdpOrigine;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individu that = (Individu) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getNom(), that.getNom()) &&
                Objects.equals(getPrenom(), that.getPrenom()) &&

                Objects.equals(getCodeSynchro(), that.getCodeSynchro()) &&
                Objects.equals(getTelephoneMobile(), that.getTelephoneMobile()) &&
                Objects.equals(getTelephoneFixe(), that.getTelephoneFixe()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getMdp(), that.getMdp()) &&
                Objects.equals(getMdpOrigine(), that.getMdpOrigine()) &&
                Objects.equals(getRole(), that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getPrenom(),  getCodeSynchro(), getTelephoneMobile(), getTelephoneFixe(), getEmail(), getLogin(), getMdp(), getMdpOrigine(), getRole());
    }

    @Override
    public String toString() {
        return "Individu{" +
                "id=" + id +
                ", civilite='" + civilite + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", codeSynchro='" + codeSynchro + '\'' +
                ", telephoneMobile='" + telephoneMobile + '\'' +
                ", telephoneFixe='" + telephoneFixe + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", mdpOrigine='" + mdpOrigine + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
