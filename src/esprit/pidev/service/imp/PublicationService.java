/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.service.interfaces.IPublicationService;
import esprit.pidev.models.Publication;
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
public class PublicationService implements IPublicationService{
    Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
    public Publication save(Publication t) {
        String req="insert into publication (titre,date,contenu,parent) values ('"+t.getTitre()+"', '"+t.getDate()+"', '"+t.getContenu()+"''"+t.getParent()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public List<Publication> getAll() {
        ParentService prs=new ParentService();
        
        String req="select * from publication";
        List<Publication> l=new ArrayList<>();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Publication p=new Publication();
            p.setId(res.getInt("id"));
            p.setTitre(res.getString("titre"));
            p.setDate(res.getDate("date"));
            p.setContenu(res.getString("contenu"));
            p.setParent(prs.getOne(res.getInt("parent")));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public Publication getOne(int id) {
        ParentService prs=new ParentService();
        
        String req="select * from publication where id="+id;  
        Publication p=new Publication();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setTitre(res.getString("titre"));
            p.setDate(res.getDate("date"));
            p.setContenu(res.getString("contenu"));
            p.setParent(prs.getOne(res.getInt("parent")));
        }
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Publication set(Publication t) {
        String req="update publication set titre='"+t.getTitre()+"', date='"+t.getDate()+"', contenu='"+t.getContenu()+"',  parent='"+t.getParent()+" where id="+t.getId();  
        Publication p=new Publication();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM publication WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
 
 
        
    }
    
}
