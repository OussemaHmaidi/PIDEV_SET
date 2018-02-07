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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ville getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ville set(Ville t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
