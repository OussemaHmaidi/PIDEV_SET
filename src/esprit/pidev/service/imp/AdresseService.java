/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Adresse;
import esprit.pidev.models.Ville;
import static esprit.pidev.service.imp.PharmacieService.conn;
import esprit.pidev.service.interfaces.IAdresseService;
import esprit.pidev.util.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AdresseService implements esprit.pidev.service.interfaces.IAdresseService{
    static Connexion conn = Connexion.getInstance();
     
    @Override
    public Adresse save(Adresse t) {
         String sql = "INSERT INTO Adresse (rue,num,ville,x,y) VALUES (?,?,?,?,?)";
 
PreparedStatement statement = null;
         try {
             statement = conn.getConnection().prepareStatement(sql);
            statement.setString(1,t.getRue());
statement.setInt(2,t.getNum());
statement.setInt(3,t.getVille().getId());
statement.setString(4,t.getX());
statement.setString(5,t.getY());
         
         } catch (SQLException ex) {
             Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
         }

int rowsInserted = 0;
         try {
             rowsInserted = statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
         }
if (rowsInserted > 0) {
    System.out.println("A new Adresse was inserted successfully!");
} 
    return t;  }

    @Override
    public List<Adresse> getAll() {
     Adresse adrs =null ;
        VilleService vs = new VilleService();
      List<Adresse> ls = new ArrayList();
    String req="select * from adresse ";  
        
        try {
            Statement st=Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
            while(res.next()){
      adrs = new Adresse(res.getInt("id"),res.getString("rue"),
             res.getInt("num"),res.getString("x"),res.getString("y"),vs.getOne(res.getInt("ville")));      
       ls.add(adrs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return ls ;   
    }

    @Override
    public Adresse getOne(int id) {
     Adresse adr =null ;
        VilleService vs = new VilleService();
       Ville v = vs.getOne(id);
    String req="select * from adresse where id="+id;  
        
        try {
            Statement st=Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
            while(res.next()){
      adr = new Adresse(res.getInt("id"),res.getString("rue"),
             res.getInt("num"),res.getString("x"),res.getString("y"),v);      
        }
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return adr ;
    }

    @Override
    public Adresse set(Adresse t) {
      String sql = "UPDATE adresse SET rue=?,num=? ,ville = ?, x=? , y=? WHERE id=?";
   int rowsUpdated = 0;
 
PreparedStatement statement = null;
          try {
              statement = conn.getConnection().prepareStatement(sql);
 statement.setInt(6,t.getId());
statement.setString(1,t.getRue());
statement.setInt(2,t.getNum());

statement.setInt(3,t.getVille().getId());
statement.setString(4,t.getX());
statement.setString(5,t.getY());

 rowsUpdated = statement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
          }
        

if (rowsUpdated > 0) {
    System.out.println("An existing Adresse was updated successfully!");
}
    return t;   
    }

    @Override
    public void delete(int id) {
    String sql = "DELETE FROM adresse WHERE id=?";
 
PreparedStatement statement = null;
        try {
            statement = conn.getConnection().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AdresseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.setInt(1,id);
        } catch (SQLException ex) {
            Logger.getLogger(AdresseService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
int rowsDeleted = 0;
        try {
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdresseService.class.getName()).log(Level.SEVERE, null, ex);
        }
if (rowsDeleted > 0) {
    System.out.println("Adresse was deleted successfully!");
}
        
    }
}
