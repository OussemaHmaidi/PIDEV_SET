/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.util.Collection;
public class Produit extends ObjetPersistant{

    private String nom;
    private String description;
    private String categorie;

    public Produit() {
    }

    public Produit(String nom, String description, String categorie) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "nom=" + nom + ", description=" + description + ", categorie=" + categorie + '}';
    }
    
}
