/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.util.Date;
public class Evenement extends ObjetPersistant{

    private String nom;
    private Date date;
    private String description;
    private Float prix;
    private Adresse adresse;
    private BonPlan bonPlan;

    public Evenement() {
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public BonPlan getBonPlan() {
        return bonPlan;
    }

    public void setBonPlan(BonPlan bonPlan) {
        this.bonPlan = bonPlan;
    }

    @Override
    public String toString() {
        return "Evenement{" + "nom=" + nom + ", date=" + date + ", description=" + description + ", prix=" + prix + ", adresse=" + adresse + ", bonPlan=" + bonPlan + '}';
    }
    
}
