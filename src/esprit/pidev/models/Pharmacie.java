/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

public class Pharmacie extends ObjetPersistant{

    private String nom;
    private String type;
    private String adresse;

    public Pharmacie() {
    }

    public Pharmacie(String nom, String type, String adresse) {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
    }

    public Pharmacie(int id ,String nom, String type, String adresse) {
        super.setId(id);
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
    } 


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Pharmacie{" + "nom=" + nom + ", type=" + type + ", adresse=" + adresse + '}';
    }
    
}
