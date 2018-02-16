/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.DessinAnime;
import esprit.pidev.models.Parc;
import esprit.pidev.service.interfaces.IDessinAnimeService;
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
public class DessinAnimeService implements IDessinAnimeService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public DessinAnime save(DessinAnime t) {
        
         String req="insert into dessin_anime (nom,chaine,url,date) values ('"+t.getNom()+"', '"+t.getChaine()+"','"+t.getUrl()+"','"+t.getDate()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DessinAnimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;

    }

    @Override
    public List<DessinAnime> getAll() {
        String req="select * from dessin_anime";
        List<DessinAnime> l=new ArrayList<>();
        
        
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            DessinAnime p=new DessinAnime();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setChaine(res.getString("chaine"));
            p.setUrl(res.getString("url"));
            p.setDate(res.getDate("date"));
                       
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DessinAnimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;


    }

    @Override
    public DessinAnime getOne(int id) {
         String req="select * from dessin_anime where id="+id;  
         DessinAnime p=new DessinAnime();
        
        
             Statement st;
        try {
            st = Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
             while(res.next()){
             
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setChaine(res.getString("chaine"));
            p.setUrl(res.getString("url"));
            p.setDate(res.getDate("date"));
             }            
        } catch (SQLException ex) {
            Logger.getLogger(DessinAnimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return p;

    }

    @Override
    public DessinAnime set(DessinAnime t) {
        String sql = "UPDATE dessin_anime SET nom=?, chaine=?, url=? ,date=? where id="+t.getId();
        try {
            PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, t.getNom());    
            statement.setString(2, t.getChaine());
            statement.setString(3, t.getUrl());
            statement.setDate(4, (Date) t.getDate());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
}
            
        } catch (SQLException ex) {
            Logger.getLogger(DessinAnimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;


    }

    @Override
    public void delete(int id) {
         String sql = "DELETE FROM dessin_anime WHERE id=?";
          
        try {
            PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
             statement.setInt(1, id);
             int rowsDeleted = statement.executeUpdate();
             if (rowsDeleted > 0) {
              System.out.println("A user was deleted successfully!");
         }
        } catch (SQLException ex) {
            Logger.getLogger(DessinAnimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        


    }
    
}
