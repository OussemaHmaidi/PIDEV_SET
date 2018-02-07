/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.DessinAnime;
import esprit.pidev.models.Jeu;
import esprit.pidev.service.interfaces.IJeuService;
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
public class JeuxService implements IJeuService{
Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Jeu save(Jeu t) {
         String req="insert into jeu (nom,url,type,description) values ('"+t.getNom()+"', '"+t.getUrl()+"','"+t.getType()+"','"+t.getDescription()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;


    }

    @Override
    public List<Jeu> getAll() {
         String req="select * from jeu";
        List<Jeu> l=new ArrayList<>();
        
        
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Jeu p=new Jeu();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setUrl(res.getString("url"));
            p.setType(res.getString("type"));
            p.setDescription(res.getString("description"));
                       
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;



    }

    @Override
    public Jeu getOne(int id) {



 String req="select * from jeu where id="+id;  
         Jeu p=new Jeu();
        
        
             Statement st;
        try {
            st = Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
             while(res.next()){
             
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setUrl(res.getString("url"));
            p.setType(res.getString("type"));
            p.setDescription(res.getString("description"));
             }            
        } catch (SQLException ex) {
            Logger.getLogger(ParcService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return p;

    }

    @Override
    public Jeu set(Jeu t) {
          String sql = "UPDATE jeu SET nom=?, url=?, type=? ,description=? where id="+t.getId();
        try {
            PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, t.getNom());    
            statement.setString(2, t.getUrl());
            statement.setString(3, t.getType());
            statement.setString(4, t.getDescription());
            
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
        String sql = "DELETE FROM Jeu WHERE id=?";
          
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
