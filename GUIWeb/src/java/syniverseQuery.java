/*
 * This class is used to query the database and store variable in approriate
 * objects, It also transforms the query results to JSON format
 */

/**
 *
 * @author Ashley
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JApplet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class syniverseQuery extends JApplet {
     Connection conn;
     Statement stmt;
     ResultSet rs;
     String aResult;
     List <String> CarrierList;
     JSONObject responseDetailsJson = new JSONObject();
     JSONArray jsonArray = new JSONArray();
     
    public List <String> dbConnect(){
        try {
            String host = "jdbc:vertica://Vertsyn.duckdns.org:5433/USF_Syniverse_Student";
            String uName = "dbadmin";
            String uPass = "Syn1v3rs3";
            conn = DriverManager.getConnection(host,uName,uPass);
            stmt = conn.createStatement();
            String sql = "Select OPERATOR_NAME from T_VPA_REF_OPERATOR order by OPERATOR_NAME";
            rs = stmt.executeQuery(sql);

            rs.next();
            while(rs.next()){
                NodeLocation myCarrier = new NodeLocation(rs.getString("OPERATOR_NAME"),"dummy", 1);
                CarrierList.add(myCarrier.getCarrier());
            }
            //List is full of Carriers store in JSON file for display purposes
            for (String carrier : CarrierList){

                JSONObject carrierDetails = new JSONObject();
                try {
                    carrierDetails.put("Carrier",carrier);
                    jsonArray.put(carrierDetails);
                } catch (JSONException ex) {
                    Logger.getLogger(syniverseQuery.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                 responseDetailsJson.put("Carriers", jsonArray);
            } 
            catch (JSONException ex) {
                Logger.getLogger(syniverseQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            return CarrierList;                
        }
            catch(SQLException err){
                System.out.println(err.getMessage());
            }
         return null;

    }  
    
    public String dbTest(){
        try{
            String host = "jdbc:vertica://Vertsyn.duckdns.org:5433/USF_Syniverse_Student";
            String uName = "dbadmin";
            String uPass = "Syn1v3rs3";
            conn = DriverManager.getConnection(host,uName,uPass);
            stmt = conn.createStatement();
            String sql = "Select OPERATOR_NAME from T_VPA_REF_OPERATOR order by OPERATOR_NAME";
            rs = stmt.executeQuery(sql);

            rs.next();

            while(rs.next()){
                NodeLocation myCarrier = new NodeLocation(rs.getString("OPERATOR_NAME"),"dummy", 1);
                CarrierList.add(myCarrier.getCarrier());
            }

            return sql;
        }

        catch(SQLException err){
            System.out.println(err.getMessage());  
            return err.getMessage();
        }    
    }
}






  

