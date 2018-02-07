/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Garderie;
import esprit.pidev.models.Ville;
import esprit.pidev.service.interfaces.IGarderieService;
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
 * @author PC-ASUS
 */
public class GarderieService implements IGarderieService{
 Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Garderie save(Garderie t) {
String req="insert into garderie (nom,description,adresse) values ('"+t.getNom()+"', '"+t.getDescription()+"', '"+t.getAdresse().getId()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;    }

    @Override
    public List<Garderie> getAll() {
 String req="select * from Garderie";
        List<Garderie> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Garderie g=new Garderie();
            g.setId(res.getInt("id"));
            g.setNom(res.getString("nom"));
            g.setDescription(res.getString("description"));
           //  g.setAdresse(res.getString("adresse"));
          
            l.add(g);
        }
        } catch (SQLException ex) {
            Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;    }

    @Override
    public Garderie getOne(int id) {
         String req="select * from garderie where id="+id;  
        Garderie p=new Garderie();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setDescription(res.getString("description"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Garderie set(Garderie t) {
String req="update garderie set nom='"+t.getNom()+"', description='"+t.getDescription()+"', adresse='"+t.getAdresse().getId()+"' where id="+t.getId();  
        Garderie p=new Garderie();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;    }

    @Override
    public void delete(int id) {
         String sql = "DELETE FROM garderie WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
    }
    

    }
}