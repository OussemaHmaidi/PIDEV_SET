/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Avis;
import esprit.pidev.models.DessinAnime;
import esprit.pidev.util.Connexion;
import java.sql.Date;
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
public class AvisService implements esprit.pidev.service.interfaces.IAvis {
Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Avis save(Avis t) {

         String req="insert into avis (txt,rating) values ('"+t.getText()+"', '"+t.getRating()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;

    }

    @Override
    public List<Avis> getAll() {
         String req="select * from avis";
        List<Avis> l=new ArrayList<>();
        
        
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Avis p=new Avis();
            p.setId(res.getInt("id"));
            p.setText(res.getString("text"));
            p.setRating(res.getFloat("rating"));
           
                       
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;

    }

    @Override
    public Avis getOne(int id) {
        String req="select * from avis where id="+id;  
         Avis p=new Avis();
        
        
             Statement st;
        try {
            st = Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
             while(res.next()){
             
            p.setId(res.getInt("id"));
            p.setText(res.getString("nom"));
            p.setRating(res.getFloat("chaine"));
            
             }            
        } catch (SQLException ex) {
            Logger.getLogger(ParcService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return p;


    }

    @Override
    public Avis set(Avis t) {
         String sql = "UPDATE avis SET text=?, rating=? where id="+t.getId();
        try {
            PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, t.getText());    
            statement.setFloat(2, t.getRating());
           
            
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
           String sql = "DELETE FROM avis WHERE id=?";
          
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
