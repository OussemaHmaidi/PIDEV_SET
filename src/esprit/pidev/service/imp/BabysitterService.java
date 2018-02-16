/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Babysitter;
import esprit.pidev.service.interfaces.IBabysitterService;
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
public class BabysitterService implements IBabysitterService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;

    @Override
    public Babysitter save(Babysitter t) {
        String req="insert into babysitter (nom,prenom,date_naissance,login,mp,cin,tel,salaire,adresse) values (?,?,?,?,?,?,?,?,?)";
        try {
            pst=Connexion.getInstance().getConnection().prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setDate(3, (Date) t.getDateNaissance());
            pst.setString(4, t.getLogin());
            pst.setString(5, t.getMp());
            pst.setString(6, t.getCin());
            pst.setString(7, t.getTel());
            pst.setFloat(8, t.getSalaire());
            pst.setString(9, t.getAdresse());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public List<Babysitter> getAll() {  
        String req="select * from babysitter";
        List<Babysitter> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        res=st.executeQuery(req);
        while(res.next()){
            Babysitter p=new Babysitter();
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setPrenom(res.getString("prenom"));
            p.setLogin(res.getString("login"));
            p.setMp(res.getString("mp"));
            p.setCin(res.getString("cin"));
            p.setTel(res.getString("tel"));
            p.setAdresse(res.getString("adresse"));
            p.setSalaire(res.getFloat("salaire"));
            p.setDateNaissance(res.getDate("date_naissance"));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Babysitter getOne(int id) {
        String req="select * from babysitter where id="+id;  
        Babysitter p=new Babysitter();
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
            p.setAdresse(res.getString("adresse"));
            p.setSalaire(res.getFloat("salaire"));
            p.setDateNaissance(res.getDate("date_naissance"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

    @Override
    public Babysitter set(Babysitter t) {
        String req="update babysitter set nom=?, prenom=?, date_naissance=?, login=?, mp=?, cin=?, tel=?, salaire=? , adresse=? where id=?";  
        Babysitter p=new Babysitter();
        try {
            pst=Connexion.getInstance().getConnection().prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setDate(3, (Date) t.getDateNaissance());
            pst.setString(4, t.getLogin());
            pst.setString(5, t.getMp());
            pst.setString(6, t.getCin());
            pst.setString(7, t.getTel());
            pst.setFloat(8, t.getSalaire());
            pst.setString(9, t.getAdresse());
            pst.setInt(10, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM babysitter WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BabysitterService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
