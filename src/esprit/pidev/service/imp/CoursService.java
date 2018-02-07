/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Cours;
import esprit.pidev.service.interfaces.ICoursService;
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
public class CoursService implements ICoursService{
Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Cours save(Cours t) {
 String req="insert into cours (titre,classe,categorie,pdf) values ('"+t.getTitre()+"', '"+t.getClasse()+"', '"+t.getCategorie()+"', '"+t.getPdf()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;    }

    @Override
    public List<Cours> getAll() {
  String req="select * from cours";
        List<Cours> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Cours p=new Cours();
            p.setId(res.getInt("id"));
            p.setTitre(res.getString("titre"));
            p.setClasse(res.getString("classe"));
             p.setCategorie(res.getString("categorie"));
              p.setPdf(res.getString("pdf"));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;    }

    @Override
    public Cours getOne(int id) {
          String req="select * from cours where id="+id;  
        Cours p=new Cours();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
          p.setId(res.getInt("id"));
            p.setTitre(res.getString("titre"));
            p.setClasse(res.getString("classe"));
             p.setCategorie(res.getString("categorie"));
              p.setPdf(res.getString("pdf"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Cours set(Cours t) {
String req="update cours set titre='"+t.getTitre()+"', classe='"+t.getClasse()+"', classe='"+t.getCategorie()+"', classe='"+t.getPdf()+"' where id="+t.getId();  
        Cours p=new Cours();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;    }

    @Override
    public void delete(int id) {
          String sql = "DELETE FROM cours WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoursService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
}