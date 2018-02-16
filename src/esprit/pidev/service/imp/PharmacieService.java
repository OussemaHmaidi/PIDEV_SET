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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
statement.setString(3,t.getAdresse());
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
          List<Pharmacie> listpharmacie = new ArrayList<>();
       String sql = "SELECT * FROM pharmacie";
 
Statement statement = null;
        try {
            statement = conn.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
ResultSet result = null;
        try {
            result = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
int count = 0;
 
        try {
            while (result.next()){
                int id = result.getInt("id");
                String nom = result.getString("nom");
                String type = result.getString("type");
            Pharmacie p = new Pharmacie(id,nom,type,result.getString("adresse"));
            listpharmacie.add(p);
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return listpharmacie;
     }

    @Override
    public Pharmacie getOne(int id) {
     Pharmacie phr =null ;
       
    String req="select * from pharmacie where id="+id;  
        
        try {
            Statement st=Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
            while(res.next()){
                phr =new Pharmacie(res.getInt("id"),
                        res.getString("nom"),
                        res.getString("type"),
                        res.getString("adresse")
                        );
    
        }
        } catch (SQLException ex) {
            Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return phr ;   
    }

    @Override
    public Pharmacie set(Pharmacie t) {
       String sql = "UPDATE pharmacie SET nom=?,type=? ,adresse = ? WHERE id=?";
   int rowsUpdated = 0;
 
PreparedStatement statement = null;
          try {
              statement = conn.getConnection().prepareStatement(sql);
 statement.setInt(4,t.getId());
statement.setString(1,t.getNom());
statement.setString(2,t.getType());

statement.setString(3,t.getAdresse()); 
 rowsUpdated = statement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
          }
        

if (rowsUpdated > 0) {
    System.out.println("An existing pharmacie was updated successfully!");
}
    return t;
    }

    @Override
    public void delete(int id) {
    String sql = "DELETE FROM  pharmacie WHERE id=?";
 
PreparedStatement statement = null;
        try {
            statement = conn.getConnection().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.setInt(1,id);
        } catch (SQLException ex) {
            Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
int rowsDeleted = 0;
        try {
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
        }
if (rowsDeleted > 0) {
    System.out.println("Pharmacie was deleted successfully!");
}
        
    }   
    
    
}
