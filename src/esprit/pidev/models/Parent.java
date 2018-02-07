/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.util.Collection;
import java.util.Date;
public class Parent extends ObjetPersistant{

    private String nom;
    private String prenom;
    private String login;
    private String mp;
    private String email;
    private Date dateNaissance;
    private String cin;
    private String tel;
    private Collection<Publication> publicationCollection;
    private Collection<Enfant> enfantCollection;
    private Collection<Plannification> plannificationCollection;

    public Parent() {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Collection<Publication> getPublicationCollection() {
        return publicationCollection;
    }

    public void setPublicationCollection(Collection<Publication> publicationCollection) {
        this.publicationCollection = publicationCollection;
    }

    public Collection<Enfant> getEnfantCollection() {
        return enfantCollection;
    }

    public void setEnfantCollection(Collection<Enfant> enfantCollection) {
        this.enfantCollection = enfantCollection;
    }

    public Collection<Plannification> getPlannificationCollection() {
        return plannificationCollection;
    }

    public void setPlannificationCollection(Collection<Plannification> plannificationCollection) {
        this.plannificationCollection = plannificationCollection;
    }

    @Override
    public String toString() {
        return "Parent{" + "nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mp=" + mp + ", email=" + email + ", dateNaissance=" + dateNaissance + ", cin=" + cin + ", tel=" + tel + ", publicationCollection=" + publicationCollection + ", enfantCollection=" + enfantCollection + ", plannificationCollection=" + plannificationCollection + '}';
    }
    
}
