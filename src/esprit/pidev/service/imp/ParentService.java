/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Babysitter;
import esprit.pidev.models.Parent;
import esprit.pidev.service.interfaces.IParentService;
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
public class ParentService implements IParentService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;

    @Override
    public Parent save(Parent t) {
        String req="insert into parent (nom,prenom,login,mp,email,date_naissance,cin,tel) values (?,?,?,?,?,?,?,?)";
        try {
            pst=Connexion.getInstance().getConnection().prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getLogin());
            pst.setString(4, t.getMp());
            pst.setString(5, t.getEmail());
            pst.setDate(6, (Date) t.getDateNaissance());
            pst.setString(7, t.getCin());
            pst.setString(8, t.getTel());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;

    }

    @Override
    public List<Parent> getAll() {
        String req="select * from parent";
        List<Parent> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        res=st.executeQuery(req);
        while(res.next()){
            Parent p=new Parent();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setPrenom(res.getString("prenom"));
            p.setLogin(res.getString("login"));
            p.setMp(res.getString("mp"));
            p.setCin(res.getString("cin"));
            p.setTel(res.getString("tel"));
            p.setEmail(res.getString("email"));
            p.setDateNaissance(res.getDate("date_naissance"));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Parent getOne(int id) {
        String req="select * from parent where id="+id;  
        Parent p=new Parent();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setPrenom(res.getString("prenom"));
            p.setLogin(res.getString("login"));
            p.setMp(res.getString("mp"));
            p.setCin(res.getString("cin"));
            p.setTel(res.getString("tel"));
            p.setEmail(res.getString("email"));
            p.setDateNaissance(res.getDate("date_naissance"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Parent set(Parent t) {
        String req="update parent set nom=?, prenom=?, date_naissance=?, login=?, mp=?, cin=?, tel=?, email=? where id=?";  
        try {
            pst=Connexion.getInstance().getConnection().prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setDate(3, (Date) t.getDateNaissance());
            pst.setString(4, t.getLogin());
            pst.setString(5, t.getMp());
            pst.setString(6, t.getCin());
            pst.setString(7, t.getTel());
            pst.setString(8, t.getEmail());
            pst.setInt(9, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM parent WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
