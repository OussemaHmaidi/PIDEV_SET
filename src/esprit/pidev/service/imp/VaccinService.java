package esprit.pidev.service.imp;

import esprit.pidev.models.Vaccin;
import esprit.pidev.util.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LACRIM
 */
public class VaccinService implements esprit.pidev.service.interfaces.IVaccinService{
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    static Connexion conn = Connexion.getInstance();
     
   
    @Override
    public Vaccin save(Vaccin t) {
		 String sql = "INSERT INTO vaccin (nom,description,date) VALUES (?,?,?)";
	 
	PreparedStatement statement = null;
			 try {
				 statement = conn.getConnection().prepareStatement(sql);
				statement.setString(1,t.getNom());
	statement.setString(2,t.getNom());
	statement.setDate(3,     (java.sql.Date) t.getDate());
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
    System.out.println("A new vaccin was inserted successfully!");
}   
    return t ;}

    @Override
    public List<Vaccin> getAll() {
        
        List<Vaccin> listVaccin = new ArrayList<>();
       String sql = "SELECT * FROM vaccin";
 
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
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
int count = 0;
 
        try {
            while (result.next()){
                int id = result.getInt("id");
                String nom = result.getString("nom");
                String desc = result.getString("description");
                Date date = result.getDate("date");
             Vaccin v = new Vaccin(id, nom, desc, date);
            listVaccin.add(v);
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return listVaccin;
    }

    @Override
    public Vaccin getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vaccin set(Vaccin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}


