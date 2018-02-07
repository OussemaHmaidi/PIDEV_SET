/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Article;
import esprit.pidev.service.interfaces.IArticleService;
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
public class ArticleService implements IArticleService{

 Statement st;
    PreparedStatement pst;
    ResultSet res;
    @Override
   public Article save(Article t){
String req="insert into article (titre,categorie,contenu,admin) values ('"+t.getTitre()+"', '"+t.getCategorie()+"', '"+t.getContenu()+"', '"+t.getAdmin().getId()+"')";
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;       }

    @Override
    public List<Article> getAll() {
String req="select * from article";
        List<Article> l=new ArrayList<>();
       AdminService ad= new AdminService();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
        
        res=st.executeQuery(req);
        while(res.next()){
            Article g=new Article();
            g.setId(res.getInt("id"));
            g.setTitre(res.getString("titre"));
            g.setCategorie(res.getString("categorie"));
             g.setContenu(res.getString("contenu"));
           g.setAdmin(ad.getOne(res.getInt("admin")));
          
            l.add(g);
        }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;     }

    @Override
    public Article getOne(int id) {
   String req="select * from article where id="+id;  
        Article p=new Article();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setTitre(res.getString("titre"));
            p.setCategorie(res.getString("categorie"));
               p.setContenu(res.getString("contenu"));
          // p.setAdmin(ad.getOne(res.getInt("admin")));
          
              
        }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;    }

    @Override
    public Article set(Article t) {
String req="update article set titre='"+t.getTitre()+"', categorie='"+t.getCategorie()+"', contenu='"+t.getContenu()+"', admin='"+t.getAdmin().getId()+"' where id="+t.getId();  
        Article p=new Article();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;    }
    

     @Override
    public void delete(int id) {
          String sql = "DELETE FROM article WHERE id=?";
        try {
        pst = Connexion.getInstance().getConnection().prepareStatement(sql);
        pst.setInt(1,id);
        pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
}