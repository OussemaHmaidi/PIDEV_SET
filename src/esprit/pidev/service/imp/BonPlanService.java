/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.service.interfaces.IBonPlanService;
import esprit.pidev.models.BonPlan;
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
public class BonPlanService implements IBonPlanService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public BonPlan save(BonPlan t) {
        String req="insert into bon_plan (type,description,proprietaire,adresse,date_debut,date_fin) values ('"+t.getType()+"', '"+t.getDescription()+"', '"+t.getProprietaire()+"', '"+t.getAdresse()+"', '"+t.getDate_debut()+"', '"+t.getDate_fin()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(BonPlanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public List<BonPlan> getAll() {
        
        
        String req="select * from bon_plan";
        List<BonPlan> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            BonPlan p=new BonPlan();
            p.setId(res.getInt("id"));
            p.setType(res.getString("type"));
            p.setDescription(res.getString("description"));
            p.setProprietaire(res.getString("proprietaire"));
            p.setAdresse(res.getString("adresse"));
            p.setDate_debut(res.getDate("date_debut"));
            p.setDate_fin(res.getDate("date_fin"));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(BonPlanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public BonPlan getOne(int id) {
      
        String req="select * from bon_plan where id="+id;  
        BonPlan p=new BonPlan();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setType(res.getString("type"));
            p.setDescription(res.getString("description"));
            p.setProprietaire(res.getString("proprietaire"));
            p.setAdresse(res.getString("adresse"));
            p.setDate_debut(res.getDate("date_debut"));
            p.setDate_fin(res.getDate("date_fin"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(BonPlanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public BonPlan set(BonPlan t) {
        String req="update bon_plan set 'type="+t.getType()+"', 'description"+t.getDescription()+"', 'propritaire="+t.getProprietaire()+"', 'adresse="+t.getAdresse()+"', 'date_debut"+t.getDate_debut()+"', 'date_fin"+t.getDate_fin()+"' where id="+t.getId();  
        BonPlan p=new BonPlan();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(BonPlanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM bon_plan WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BonPlanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
 
 
        
    }
    
}
