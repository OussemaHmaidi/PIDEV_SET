/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.util.Collection;
public class Adresse extends ObjetPersistant {

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
        super();
    }

    public Adresse(String rue, Integer num, String x, String y, Ville ville) {
        this.rue = rue;
        this.num = num;
        this.x = x;
        this.y = y;
        this.ville = ville;
    }
 public Adresse(int id ,String rue, Integer num, String x, String y, Ville ville) {
     super.setId(id);
     this.rue = rue;
        this.num = num;
        this.x = x;
        this.y = y;
        this.ville = ville;
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
    public String toString() {
        return super.toString()+"Adresse{" + "rue=" + rue + ", num=" + num + ", x=" + x + ", y=" + y + ", parcCollection=" + parcCollection + ", ville=" + ville + ", garderieCollection=" + garderieCollection + ", evenementCollection=" + evenementCollection + ", pharmacieCollection=" + pharmacieCollection + '}';
    }
    
}
