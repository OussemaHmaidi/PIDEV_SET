/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Enfant;
import esprit.pidev.models.Parent;
import esprit.pidev.service.interfaces.IEnfantService;
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
 * @author ousse
 */
public class EnfantService implements IEnfantService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;
    ParentService ps=new ParentService();
    @Override
    public Enfant save(Enfant t) {
        String req="insert into enfant(nom,prenom,date_naissance,sexe,classe,parent) values (?,?,?,?,?,?)";
        try {
            pst=Connexion.getInstance().getConnection().prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setDate(3, (Date) t.getDateNaissance());
            pst.setString(4, t.getSexe());
            pst.setString(5, t.getClasse());
            pst.setInt(6, t.getParent().getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;

    }

    @Override
    public List<Enfant> getAll() {
        String req="select * from enfant";
        List<Enfant> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        res=st.executeQuery(req);
        while(res.next()){
            Enfant p=new Enfant();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setPrenom(res.getString("prenom"));
            p.setSexe(res.getString("sexe"));
            p.setClasse(res.getString("classe"));
            p.setDateNaissance(res.getDate("date_naissance"));
            p.setParent(ps.getOne(res.getInt("parent")));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Enfant getOne(int id) {
        String req="select * from enfant where id="+id;  
        Enfant p=new Enfant();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setPrenom(res.getString("prenom"));
            p.setSexe(res.getString("sexe"));
            p.setClasse(res.getString("classe"));
            p.setDateNaissance(res.getDate("date_naissance"));
            p.setParent(ps.getOne(res.getInt("parent")));
        }
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Enfant set(Enfant t) {
        String req="update enfant set nom=?, prenom=?, date_naissance=?, sexe=?, classe=?, parent=? where id=?";  
        Enfant p=new Enfant();
        try {
            pst=Connexion.getInstance().getConnection().prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setDate(3, (Date) t.getDateNaissance());
            pst.setString(4, t.getSexe());
            pst.setString(5, t.getClasse());
            pst.setInt(6, t.getParent().getId());
            pst.setInt(7, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM enfant WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
