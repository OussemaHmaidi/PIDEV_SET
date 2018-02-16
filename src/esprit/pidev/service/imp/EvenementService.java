/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.BonPlan;
import esprit.pidev.models.DessinAnime;
import esprit.pidev.models.Evenement;
import esprit.pidev.models.Jeu;
import esprit.pidev.service.interfaces.IEvenementService;
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
public class EvenementService implements IEvenementService{
 Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Evenement save(Evenement t) {
         String req="insert into evenement (nom,date,description,prix,adresse) values ('"+t.getNom()+"', '"+t.getDate()+"','"+t.getDescription()+"','"+t.getPrix()+"','"+t.getAdresse()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;

    }

    @Override
    public List<Evenement> getAll() {
 String req="select * from evenement";
        List<Evenement> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Evenement p=new Evenement();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setDate(res.getDate("date"));
            p.setDescription(res.getString("description"));
            p.setPrix(res.getFloat("prix"));
            p.setAdresse(res.getString("adresse"));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;


    }

    @Override
    public Evenement getOne(int id) {


 String req="select * from evenement where id="+id;  
         Evenement p=new Evenement();
        
             Statement st;
        try {
            st = Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
             while(res.next()){
             
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setDate(res.getDate("date"));
            p.setDescription(res.getString("description"));
            p.setPrix(res.getFloat("prix"));
            p.setAdresse(res.getString("adresse"));
             }            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return p;

    }

    @Override
    public Evenement set(Evenement t) {
String sql = "UPDATE evenement SET nom=?, date=?, description=?, prix=?, adresse=? where id="+t.getId();
        try {
            PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, t.getNom());    
            statement.setDate(2, (Date) t.getDate());
            statement.setString(3, t.getDescription());
            statement.setFloat(4, t.getPrix());
            statement.setString(5, t.getAdresse());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
}
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
         String sql = "DELETE FROM evenement WHERE id=?";
          
        try {
            PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
             statement.setInt(1, id);
             int rowsDeleted = statement.executeUpdate();
             if (rowsDeleted > 0) {
              System.out.println("A user was deleted successfully!");
         }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
}
