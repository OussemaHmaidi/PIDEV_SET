/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.util.Collection;
import java.util.Date;
public class Vaccin extends ObjetPersistant{

    private String nom;
    private String description;
    private Date date;
    private Collection<EnfantVaccin> enfantVaccinCollection;

    public Vaccin() {
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<EnfantVaccin> getEnfantVaccinCollection() {
        return enfantVaccinCollection;
    }

    public void setEnfantVaccinCollection(Collection<EnfantVaccin> enfantVaccinCollection) {
        this.enfantVaccinCollection = enfantVaccinCollection;
    }

    @Override
    public String toString() {
        return "Vaccin{" + "nom=" + nom + ", description=" + description + ", date=" + date + ", enfantVaccinCollection=" + enfantVaccinCollection + '}';
    }
    
}
