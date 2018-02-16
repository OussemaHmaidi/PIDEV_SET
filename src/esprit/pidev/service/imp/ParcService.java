/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Parc;
import esprit.pidev.util.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdennadher Mohamed
 */
public class ParcService implements esprit.pidev.service.interfaces.IParcService{

    Statement st;
    PreparedStatement pst;
    ResultSet res;
    
    @Override
    public Parc save(Parc t) {
        String req="insert into parc (nom,decription,adresse) values ('"+t.getNom()+"', '"+t.getDecription()+"','"+t.getAdresse()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ParcService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
        


    }

    @Override
    public List<Parc> getAll() {
       String req="select * from parc";
        List<Parc> l=new ArrayList<>();
        
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Parc p=new Parc();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setDecription(res.getString("decription"));
            p.setAdresse(res.getString("adresse"));
            
            
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(ParcService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Parc getOne(int id) {
        
        String req="select * from parc where id="+id;  
         Parc p=new Parc();
             Statement st;
        try {
            st = Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
             while(res.next()){
             
              p.setId(res.getInt("id"));
              p.setNom(res.getString("nom"));
              p.setDecription(res.getString("decription"));
              p.setAdresse(res.getString("adresse"));
             }            
        } catch (SQLException ex) {
            Logger.getLogger(ParcService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return p;
      }

    @Override
    public Parc set(Parc t) {
      String sql = "UPDATE parc SET nom=?, decription=?, adresse=? where id="+t.getId();
        try {
            PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, t.getNom());    
            statement.setString(2, t.getDecription());
            statement.setString(3, t.getAdresse());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
}
            
        } catch (SQLException ex) {
            Logger.getLogger(ParcService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM parc WHERE id=?";
          
        try {
            PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
             statement.setInt(1, id);
             int rowsDeleted = statement.executeUpdate();
             if (rowsDeleted > 0) {
              System.out.println("A user was deleted successfully!");
         }
        } catch (SQLException ex) {
            Logger.getLogger(ParcService.class.getName()).log(Level.SEVERE, null, ex);
        }
       


    }
    
}
