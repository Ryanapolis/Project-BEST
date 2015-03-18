/*
 * This class is used to query the database and store variable in approriate
 * objects, It also transforms the query results to JSON format
 */

/*
 *
 * @author Ashley
 */

/*
 * I will get multiple lat,longs and ranges when I query
 * the db based only off of Country code and MCC. Must create list of 
 * objects that holds all of these values. For easy passing to JSP and JS
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class syniverseQuery  {
     Connection conn;
     Statement stmt;
     ResultSet rs;
     String aResult;
 
    
    public List <String> dbConnect(){
         List <String> CarrierList = new ArrayList<String>();
        try {
            Class.forName("com.vertica.jdbc.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        System.out.println("inside dbConnect");
        try {
            String host = "jdbc:vertica://Vertsyn.duckdns.org:5433/USF_Syniverse_Student";
            String uName = "dbadmin";
            String uPass = "Syn1v3rs3";
            conn = DriverManager.getConnection(host,uName,uPass);
            stmt = conn.createStatement();
            String sql = "Select OPERATOR_NAME from SyniverseData.T_VPA_REF_OPERATOR order by OPERATOR_NAME";
            rs = stmt.executeQuery(sql);
            System.out.println("After connection");
            //CarrierList.add(rs.getString("OPERATOR_NAME"));
            while(rs.next()){
               // NodeLocation myCarrier = new NodeLocation(rs.getString("OPERATOR_NAME"),"dummy", 1);
                //CarrierList.add(myCarrier.getCarrier());
                CarrierList.add(rs.getString("OPERATOR_NAME"));
            }  
            return CarrierList;                
        }
            catch(SQLException err){
                System.out.println(err.getMessage());
            }
         return CarrierList;

    }  
    
    public String dbTest(String carrier, String node) throws ClassNotFoundException{
       
     
        try {
            Class.forName("com.vertica.jdbc.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        
        try{
            String host = "jdbc:vertica://Vertsyn.duckdns.org:5433/USF_Syniverse_Student";
            String uName = "dbadmin";
            String uPass = "Syn1v3rs3";
            conn = DriverManager.getConnection(host,uName,uPass); 
            stmt = conn.createStatement();
            String sql = "Select lat, lon from public.Node_Average_test where RECORDING_ENTITY_ID = 12085978063";
            rs = stmt.executeQuery(sql);
            rs.next();
            String lat = rs.getString("lat");
            System.out.println(lat);
            String lon = rs.getString("lon");
            String coordinate = lat + "," + lon;
           // rs.next();
            return coordinate;
        }

        catch (SQLException err){
            System.out.println(err.getMessage());  
            return err.getMessage();
        }    
    }
   
    /* Possible dropdownlist getter for onload
      public List <Integer> getMCCs() throws SQLException
    {
        List mccList = new ArrayList();
         try {
            Class.forName("com.vertica.jdbc.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
         try{
            String host = "jdbc:vertica://Vertsyn.duckdns.org:5433/USF_Syniverse_Student";
            String uName = "dbadmin";
            String uPass = "Syn1v3rs3";
            conn = DriverManager.getConnection(host,uName,uPass); //fails here
            stmt = conn.createStatement();
            String sql = "Select mcc from openbmap.mcc";
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                //get row data
                mccList.add(rs.getString("mcc"));
            }
             

            return mccList;
        }
          catch(SQLException err){
            System.out.println(err.getMessage());  
            return mccList;
        } 
        //obtain list of titles
        
    }*/
    
   
}






  

