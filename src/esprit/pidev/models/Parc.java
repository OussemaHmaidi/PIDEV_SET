/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

public class Parc extends ObjetPersistant{

    private String nom;
    private String decription;
    private String adresse;

    public Parc() {
    }

    public Parc(String nom, String decription, String adresse) {
        this.nom = nom;
        this.decription = decription;
        this.adresse = adresse;
    }

  

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Parc{" + "nom=" + nom + ", decription=" + decription + ", adresse=" + adresse + '}';
    }
    
}
