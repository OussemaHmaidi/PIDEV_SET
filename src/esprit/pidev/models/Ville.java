/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.util.Collection;
public class Ville extends ObjetPersistant{

    private String nom;
    private String codePostal;
    private Collection<Adresse> adresseCollection;

    public Ville() {
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Collection<Adresse> getAdresseCollection() {
        return adresseCollection;
    }

    public void setAdresseCollection(Collection<Adresse> adresseCollection) {
        this.adresseCollection = adresseCollection;
    }

    @Override
    public String toString() {
        return "Ville{" + "nom=" + nom + ", codePostal=" + codePostal + ", adresseCollection=" + adresseCollection + '}';
    }

    
}
