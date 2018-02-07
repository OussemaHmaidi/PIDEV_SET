/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.service.interfaces.IPharmacieService;
import esprit.pidev.models.Pharmacie;
import esprit.pidev.util.Connexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
/**
 *
 * @author LACRIM
 */
public class PharmacieService implements IPharmacieService{

      static Connexion conn = Connexion.getInstance();
     
   
    @Override
    public Pharmacie save(Pharmacie t) {
        String sql = "INSERT INTO pharmacie (nom,type,adresse) VALUES (?,?,?)";
 
PreparedStatement statement = null;
         try {
             statement = conn.getConnection().prepareStatement(sql);
            statement.setString(1,t.getNom());
statement.setString(2,t.getType());
statement.setInt(3,t.getAdresse().getId());
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
    System.out.println("A new Pharmacie was inserted successfully!");
} 
    return t;}

    @Override
    public List<Pharmacie> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pharmacie getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pharmacie set(Pharmacie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
