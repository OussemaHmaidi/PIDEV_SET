/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import esprit.pidev.util.Connexion;

/**
 *
 * @author ousse
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Connexion d2=Connexion.getInstance();
      System.out.println(d2.hashCode());

    }
    
}
