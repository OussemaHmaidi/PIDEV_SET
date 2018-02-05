/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ousse
 */
public class Connexion {
 static String url="jdbc:mysql://127.0.0.1:3306/all4kids";
    static String login="root";
    static String passwd="root";
 static Connection cnx;
 static Connexion instance;
    
    private Connexion() {
   
             try {
            // TODO code application logic here
            cnx=DriverManager.getConnection(url,login, passwd);            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
    }
   
    public Connection getConnection(){
  
        return cnx;

    }
    
    public static Connexion getInstance(){
    if(instance==null)
        return instance =new Connexion();
    return instance;
    
    }

}
