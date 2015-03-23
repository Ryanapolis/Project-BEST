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
 * the db based only off of Carrier and MCC. Must create list of 
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
 
    /*I used this function to collect carrier names, it is not currently 
     being displayed*/
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
            while(rs.next()){
                CarrierList.add(rs.getString("OPERATOR_NAME"));
            }  
            return CarrierList;                
        }
            catch(SQLException err){
                System.out.println(err.getMessage());
            }
         return CarrierList;

    }  
    
    public String dbTest(String carrier, String mcc) throws ClassNotFoundException{
       
     
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
            String sql = "Select lat, lon, RECORDING_ENTITY_ID from public.Node_Average_test where RECORDING_ENTITY_ID = 12085979061";
            rs = stmt.executeQuery(sql);
            rs.next();
            String lat = rs.getString("lat");
            String lon = rs.getString("lon");
            String node = rs.getString("RECORDING_ENTITY_ID");
            String coordinate = lat + "," + lon + "," + node;
           
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
    
    /*
     This function establishes a connection with the db,
     performs a query for nodeID, range, lat, and lon from user input of 
     (mcc, mnc). This function creates a NodeLocation object for each
     row result found and returns a list of these objects to the
     SyniverseFormHandlerServlet.java
     */
     public List<NodeLocation> getLocations(String mnc, String mcc) throws ClassNotFoundException{
        //Create new List of NodeLocation objects
        List <NodeLocation> nodeLocationList = new ArrayList();
        //Attempt to connect to the database
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
            String sql = "Select lat, lon, Coverage_Range, NODE_ID from public.Node_Average_with_Ranges where MCC= " + mcc + "and MNC= "+ mnc;
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                NodeLocation nl = new NodeLocation(rs.getString("NODE_ID"),rs.getString("Coverage_Range"), rs.getString("lat"), rs.getString("lon") );
                nodeLocationList.add(nl);                
            }
            return nodeLocationList;
        }
        catch(SQLException err){
            System.out.println(err.getMessage());  
            return nodeLocationList;
        }    
    }
}






  

