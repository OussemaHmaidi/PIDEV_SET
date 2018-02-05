/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
public class Parent implements Serializable {

    private Integer id;
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

    public Parent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parent)) {
            return false;
        }
        Parent other = (Parent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit.pidev.models.Parent[ id=" + id + " ]";
    }
    
}
