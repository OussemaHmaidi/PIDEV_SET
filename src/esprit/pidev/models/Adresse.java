/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.io.Serializable;
import java.util.Collection;
public class Adresse implements Serializable {

    private Integer id;
    private String rue;
    private Integer num;
    private String x;
    private String y;
    private Collection<Parc> parcCollection;
    private Ville ville;
    private Collection<Garderie> garderieCollection;
    private Collection<Evenement> evenementCollection;
    private Collection<Pharmacie> pharmacieCollection;

    public Adresse() {
    }

    public Adresse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Collection<Parc> getParcCollection() {
        return parcCollection;
    }

    public void setParcCollection(Collection<Parc> parcCollection) {
        this.parcCollection = parcCollection;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Collection<Garderie> getGarderieCollection() {
        return garderieCollection;
    }

    public void setGarderieCollection(Collection<Garderie> garderieCollection) {
        this.garderieCollection = garderieCollection;
    }

    public Collection<Evenement> getEvenementCollection() {
        return evenementCollection;
    }

    public void setEvenementCollection(Collection<Evenement> evenementCollection) {
        this.evenementCollection = evenementCollection;
    }

    public Collection<Pharmacie> getPharmacieCollection() {
        return pharmacieCollection;
    }

    public void setPharmacieCollection(Collection<Pharmacie> pharmacieCollection) {
        this.pharmacieCollection = pharmacieCollection;
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
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit.pidev.models.Adresse[ id=" + id + " ]";
    }
    
}
