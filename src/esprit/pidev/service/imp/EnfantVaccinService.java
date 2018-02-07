/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.service.imp;

import esprit.pidev.models.EnfantVaccin;
import esprit.pidev.service.interfaces.IEnfantVaccinService;
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
 * @author LACRIM
 */
public class EnfantVaccinService implements IEnfantVaccinService{
  static Connexion conn = Connexion.getInstance();
    @Override
    public EnfantVaccin save(EnfantVaccin t) {
     String sql = "INSERT INTO enfant_vaccin(enfant,vaccin,statut)VALUES (?,?,?)";
	 
	PreparedStatement statement = null;
			 try {
				 statement = conn.getConnection().prepareStatement(sql);
				statement.setInt(1,t.getEnfant().getId());
	statement.setInt(2,t.getVaccin().getId());
	statement.setInt(3,t.getStatut());
			 } catch (SQLException ex) {
				 Logger.getLogger(EnfantVaccin.class.getName()).log(Level.SEVERE, null, ex);
         }

int rowsInserted = 0;
         try {
             rowsInserted = statement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(PharmacieService.class.getName()).log(Level.SEVERE, null, ex);
         }
if (rowsInserted > 0) {
    System.out.println("A new vaccin was inserted successfully!");
}   
    return t ;    
    }

    @Override
    public List<EnfantVaccin> getAll() {
       String req="select * from enfant_vaccin";
       
       EnfantService es = new EnfantService();
       VaccinService vs = new VaccinService();
        Statement st ;
        ResultSet res ;
        List<EnfantVaccin> l=new ArrayList<>();
        try {
              st=Connexion.getInstance().getConnection().createStatement();
        res=st.executeQuery(req);
        while(res.next()){
            EnfantVaccin p=new EnfantVaccin();
            p.setId(res.getInt("id"));
            p.setEnfant(es.getOne(res.getInt("enfant")));
            p.setVaccin(vs.getOne(res.getInt("vaccin")));
            p.setStatut(res.getInt("statut"));
            l.add(p);
        }
        } catch (SQLException ex) {
            Logger.getLogger(EnfantVaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    return l;  
    }

    @Override
    public EnfantVaccin getOne(int id) {
    EnfantVaccin ev =null ;
    EnfantService es = new EnfantService();
    VaccinService vs = new VaccinService();
       
    String req="select * from enfant_vaccin where id="+id;  
        
        try {
            Statement st=Connexion.getInstance().getConnection().createStatement();
             ResultSet res=st.executeQuery(req);
            while(res.next()){
              ev.setId(res.getInt("id"));
              ev.setEnfant(es.getOne(res.getInt("enfant")));
      ev.setVaccin(vs.getOne(res.getInt("vaccin")));
      ev.setStatut(res.getInt("satut"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(EnfantVaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return ev ;      
    
    
    
    }

    @Override
    public EnfantVaccin set(EnfantVaccin t) {
        String sql = "UPDATE vaccin SET enfant=?,vaccin=? ,statut= ? WHERE id=?";
   int rowsUpdated = 0;
 
PreparedStatement statement = null;
          try {
              statement = conn.getConnection().prepareStatement(sql);
 statement.setInt(4,t.getId());
statement.setInt(1,t.getEnfant().getId());
statement.setInt(2,t.getVaccin().getId());

statement.setInt(3,t.getStatut());
 rowsUpdated = statement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(EnfantVaccinService.class.getName()).log(Level.SEVERE, null, ex);
          }
        

if (rowsUpdated > 0) {
    System.out.println("An existing EnfantVaccin was updated successfully!");
}
    return t;      }

    @Override
    public void delete(int id) {
      String sql = "DELETE FROM enfant_vaccin WHERE id=?";
 
PreparedStatement statement = null;
        try {
            statement = conn.getConnection().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.setInt(1,id);
        } catch (SQLException ex) {
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
int rowsDeleted = 0;
        try {
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
if (rowsDeleted > 0) {
    System.out.println("enfant_Vaccin was deleted successfully!");
}  }
    
    }

  

