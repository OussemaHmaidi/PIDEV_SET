/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.test;

import esprit.pidev.util.Connexion;
import javafx.scene.control.Button;

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
    }
    
}
