/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.test;

import esprit.pidev.models.Ville;
import esprit.pidev.service.VilleService;
import esprit.pidev.util.Connexion;

/**
 *
 * @author Abdennadher Mohamed
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        
        
           Connexion d2=Connexion.getInstance();
      System.out.println(d2.hashCode());
        Ville v=new Ville();
        v.setNom("aaaa");
        v.setCodePostal("1111");
        VilleService vs=new VilleService();
        System.out.println(vs.save(v));
    }
    
}
