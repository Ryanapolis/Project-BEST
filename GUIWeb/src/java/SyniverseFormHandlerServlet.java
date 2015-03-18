/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
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

   /* @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        int[] day = new int[] {1,2,3,4,5};
        request.setAttribute("Data", day);
        request.getRequestDispatcher("/start.jsp").forward(request, response);

    }*/
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {   
        //gets all selected options from the client browser
         
        String selectedCarrier = request.getParameter("carrier");
        String mccValue = request.getParameter("countryValue");
        //function call and pass enteredValue and selectedCarrier
        syniverseQuery sQuery = new syniverseQuery();
        //List<String> results = sQuery.dbConnect();
         
        List <String> test = sQuery.dbConnect();
        String coordinate = "init";
        
       
        try {
            coordinate = sQuery.dbTest(selectedCarrier, mccValue);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SyniverseFormHandlerServlet.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
       
        //JSP
        //Set Coordinate Attributes
        request.setAttribute("coordinate", coordinate);
        //Set Carrier List Attributes
        request.setAttribute("Data", test);
        
        //Pass Node ID
        request.setAttribute("userNodeID", mccValue);
        request.getRequestDispatcher("results.jsp").forward(request, response);
        
        //gets the enteredValue in fields value 
       
        response.setContentType("text/html");
      
      
       
    }
}
