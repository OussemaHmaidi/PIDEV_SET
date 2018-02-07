/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.util.Collection;
import java.util.Date;
public class Enfant extends ObjetPersistant{

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String classe;
    private Parent parent;
    private Collection<EnfantVaccin> enfantVaccinCollection;

    public Enfant() {
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Collection<EnfantVaccin> getEnfantVaccinCollection() {
        return enfantVaccinCollection;
    }

    public void setEnfantVaccinCollection(Collection<EnfantVaccin> enfantVaccinCollection) {
        this.enfantVaccinCollection = enfantVaccinCollection;
    }

    @Override
    public String toString() {
        return "Enfant{" + "nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", classe=" + classe + ", parent=" + parent + ", enfantVaccinCollection=" + enfantVaccinCollection + '}';
    }
    
}
