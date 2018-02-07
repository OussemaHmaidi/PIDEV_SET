/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.service.interfaces.IAnnonceService;
import esprit.pidev.models.Annonce;
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
public class AnnonceService implements IAnnonceService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Annonce save(Annonce t) {
        String req="insert into annonce (nom,description,prix,produit,bon_plan) values ('"+t.getNom()+"', '"+t.getDescription()+"', '"+t.getPrix()+"', '"+t.getProduit()+"', '"+t.getBonPlan()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public List<Annonce> getAll() {
        ProduitService ps=new ProduitService();
        BonPlanService bs=new BonPlanService();
        
        String req="select * from annonce";
        List<Annonce> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Annonce p=new Annonce();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setDescription(res.getString("description"));
            p.setPrix(res.getFloat("prix"));
            p.setProduit(ps.getOne(res.getInt("produit")));
            p.setBonPlan(bs.getOne(res.getInt("bon_plan")));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Annonce getOne(int id) {
        ProduitService ps=new ProduitService();
        BonPlanService bs=new BonPlanService();
        String req="select * from annonce where id="+id;  
        Annonce p=new Annonce();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setDescription(res.getString("description"));
            p.setPrix(res.getFloat("prix"));
            p.setProduit(ps.getOne(res.getInt("produit")));
            p.setBonPlan(bs.getOne(res.getInt("bon_plan")));
        }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Annonce set(Annonce t) {
        String req="update annonce set 'nom="+t.getNom()+"', 'description"+t.getDescription()+"', 'prix="+t.getPrix()+"', 'parent="+t.getProduit()+"', 'bon_plan"+t.getBonPlan()+"' where id="+t.getId();  
        Annonce p=new Annonce();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM annonce WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
 
 
        
    }
    
}
