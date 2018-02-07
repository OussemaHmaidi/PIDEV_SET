/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

public class Annonce extends ObjetPersistant {

    private String nom;
    private String description;
    private Float prix;
    private BonPlan bonPlan;
    private Produit produit;

    public Annonce() {
        super();
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

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public BonPlan getBonPlan() {
        return bonPlan;
    }

    public void setBonPlan(BonPlan bonPlan) {
        this.bonPlan = bonPlan;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Annonce{" + "nom=" + nom + ", description=" + description + ", prix=" + prix + ", bonPlan=" + bonPlan + ", produit=" + produit + '}';
    }
    
}
