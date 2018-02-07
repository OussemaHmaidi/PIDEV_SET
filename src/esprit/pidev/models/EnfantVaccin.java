/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.models;

public class EnfantVaccin extends ObjetPersistant{

    private Integer statut;
    private Vaccin vaccin;
    private Enfant enfant;

    public EnfantVaccin() {
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public Vaccin getVaccin() {
        return vaccin;
    }

    public void setVaccin(Vaccin vaccin) {
        this.vaccin = vaccin;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    @Override
    public String toString() {
        return "EnfantVaccin{" + "statut=" + statut + ", vaccin=" + vaccin + ", enfant=" + enfant + '}';
    }

    
}
