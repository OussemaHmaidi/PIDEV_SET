/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.service.interfaces.IVilleService;
import esprit.pidev.models.Ville;
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
public class VilleService implements IVilleService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Ville save(Ville t) {
        String req="insert into ville (nom,code_postal) values ('"+t.getNom()+"', '"+t.getCodePostal()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public List<Ville> getAll() {
        String req="select * from ville";
        List<Ville> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Ville p=new Ville();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setCodePostal(res.getString("code_postal"));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Ville getOne(int id) {
        String req="select * from ville where id="+id;  
        Ville p=new Ville();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setCodePostal(res.getString("code_postal"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Ville set(Ville t) {
        String req="update ville set nom='"+t.getNom()+"', code_postal='"+t.getCodePostal()+"' where id="+t.getId();  
        Ville p=new Ville();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM ville WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VilleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
 
 
        
    }
    
}
