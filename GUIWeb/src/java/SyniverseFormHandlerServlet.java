/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Ashley
 */
@WebServlet(name = "FormHandlerServlet", urlPatterns = {"/FormHandlerServlet"})
public class SyniverseFormHandlerServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {   
        //gets all selected options from the client browser
        String selectedCarrier = request.getParameter("carrier");
        String mccValue = request.getParameter("ddlMcc");
        /*Create new syniverseQuery object to access functions and
         * create list of objects to return to the JSP page
         */
        syniverseQuery sQuery = new syniverseQuery();
        List <NodeLocation> locationList = new ArrayList();
        //function call to query, pass selectedCarrier (MNC) and the MCC Value
        try {
            locationList = sQuery.getLocations(selectedCarrier, mccValue);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SyniverseFormHandlerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JSP Configuration
        //Set Coordinate Attributes..TESTING DEMO
        String coordinate= "120,-30";
        request.setAttribute("coordinate", coordinate);
        /*
         *This will set the NodeLocation object we created from our query 
         * to the string name "nodeLocation" that is used in the JSP file
         */
        request.setAttribute("nodeLocation", locationList);
        
        //Pass Node ID..MORE TEST
        request.setAttribute("userNodeID", mccValue);
        
        /*Once all attributes are set for the page, we can forward
         *our request to results.jsp
        */
        request.getRequestDispatcher("results.jsp").forward(request, response); 
        response.setContentType("text/html");
    }
}
