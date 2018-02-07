/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.Adresse;
import static esprit.pidev.service.imp.PharmacieService.conn;
import esprit.pidev.service.interfaces.IAdresseService;
import esprit.pidev.util.Connexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AdresseService implements esprit.pidev.service.interfaces.IAdresseService{
    static Connexion conn = Connexion.getInstance();
     
    @Override
    public Adresse save(Adresse t) {
         String sql = "INSERT INTO Adresse (rue,num,ville,x,y) VALUES (?,?,?,?,?)";
 
PreparedStatement statement = null;
         try {
             statement = conn.getConnection().prepareStatement(sql);
            statement.setString(1,t.getRue());
statement.setInt(2,t.getNum());
statement.setInt(3,t.getVille().getId());
statement.setString(4,t.getX());
statement.setString(5,t.getY());
         
         } catch (SQLException ex) {
             Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
         }

int rowsInserted = 0;
         try {
             rowsInserted = statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
         }
if (rowsInserted > 0) {
    System.out.println("A new Adresse was inserted successfully!");
} 
    return t;  }

    @Override
    public List<Adresse> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Adresse getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Adresse set(Adresse t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
