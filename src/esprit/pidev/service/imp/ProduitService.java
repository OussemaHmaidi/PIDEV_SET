/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.service.interfaces.IProduitService;
import esprit.pidev.models.Produit;
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
 * @author ousse
 */
public class ProduitService implements IProduitService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Produit save(Produit t) {
        String req="insert into produit (nom,description,categorie) values ('"+t.getNom()+"', '"+t.getDescription()+"', '"+t.getCategorie()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public List<Produit> getAll() {
        String req="select * from produit";
        List<Produit> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Produit p=new Produit();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setDescription(res.getString("description"));
            p.setCategorie(res.getString("categorie"));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Produit getOne(int id) {
        String req="select * from produit where id="+id;  
        Produit p=new Produit();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setDescription(res.getString("description"));
            p.setCategorie(res.getString("categorie"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Produit set(Produit t) {
        String req="update produit set nom='"+t.getNom()+"', description='"+t.getDescription()+"', categorie='"+t.getCategorie()+"' where id="+t.getId();  
        Produit p=new Produit();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM produit WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
 
 
        
    }
    
}
