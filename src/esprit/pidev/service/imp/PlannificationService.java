/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Plannification;
import esprit.pidev.service.interfaces.IPlannificationService;
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
public class PlannificationService implements IPlannificationService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;
        BabysitterService bs=new BabysitterService();
        ParentService ps=new ParentService();

    @Override
    public Plannification save(Plannification t) {
                String req="insert into plannification (date,babysitter,parent) values (?,?,?)";
        try {
            pst=Connexion.getInstance().getConnection().prepareStatement(req);
            pst.setDate(1, (Date) t.getDate());
            pst.setInt(2, t.getBabysitter().getId());
            pst.setInt(3, t.getParent().getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public List<Plannification> getAll() {
                String req="select * from plannification";
        List<Plannification> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        res=st.executeQuery(req);
        while(res.next()){
            Plannification p=new Plannification();
            p.setId(res.getInt("id"));
            p.setDate(res.getDate("date"));
            p.setBabysitter(bs.getOne(res.getInt("babysitter")));
            p.setParent(ps.getOne(res.getInt("parent")));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Plannification getOne(int id) {
        String req="select * from plannification where id="+id;  
        Plannification p=new Plannification();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setDate(res.getDate("date"));
            p.setBabysitter(bs.getOne(res.getInt("babysitter")));
            p.setParent(ps.getOne(res.getInt("parent")));
        }
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Plannification set(Plannification t) {
        String req="update plannification set date=?, babysitter=?, parent=? where id=?";  
        Plannification p=new Plannification();
        try {
            pst=Connexion.getInstance().getConnection().prepareStatement(req);
            pst.setDate(1, (Date) t.getDate());
            pst.setInt(2, t.getBabysitter().getId());
            pst.setInt(3, t.getParent().getId());
            pst.setInt(4, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void delete(int id) {
                String sql = "DELETE FROM plannification WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
