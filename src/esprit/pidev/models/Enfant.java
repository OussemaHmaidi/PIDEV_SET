/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
public class Enfant implements Serializable {

    private Integer id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String classe;
    private Parent parent;
    private Collection<EnfantVaccin> enfantVaccinCollection;

    public Enfant() {
    }

    public Enfant(Integer id) {
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Collection<EnfantVaccin> getEnfantVaccinCollection() {
        return enfantVaccinCollection;
    }

    public void setEnfantVaccinCollection(Collection<EnfantVaccin> enfantVaccinCollection) {
        this.enfantVaccinCollection = enfantVaccinCollection;
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
        if (!(object instanceof Enfant)) {
            return false;
        }
        Enfant other = (Enfant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esprit.pidev.models.Enfant[ id=" + id + " ]";
    }
    
}
