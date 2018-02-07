/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Admin;
import esprit.pidev.service.interfaces.IAdminService;
import esprit.pidev.util.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ousse
 */
public class AdminService implements IAdminService{
   Statement st;
    PreparedStatement pst;
    ResultSet res;
 
    @Override
    public Admin save(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Admin> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin getOne(int id) {
       String req="select * from admin where id="+id;  
        Admin p=new Admin();
        try {
            st=Connexion.getInstance().getConnection().createStatement();
            res=st.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setNom(res.getString("nom"));
            p.setPrenom(res.getString("prenom"));
            p.setLogin(res.getString("login"));
            p.setMp(res.getString("mp"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
     }

    @Override
    public Admin set(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
