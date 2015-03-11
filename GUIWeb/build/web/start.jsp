<!DOCTYPE html>


<link rel="stylesheet" href="indexcss.css">
    <html lang="en" xmlns="http://www.w3.org/1999/xhtml">
        <head> 
            <script type="text/javascript" src="syniverse.js"></script>
            <script language="java" type="text/java" src="syniverseQuery.java"></script>
            <script src= "http://maps.google.com/maps/api/js?sensor=false"> </script>
            <script language="javascript" type="text/javascript" src="jquery-1.11.1.min.js"></script>
            <meta http-equiv="Content-Type" content="text/html;" >
            <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
                <title>Node Location</title>    
        </head>
        <body onload="init();">
            
            
             <form method="post" action="SyniverseFormHandlerServlet">
                 <h1>Syniverse-USF BEST</h1>
                <br />
                <h2>Please enter the following information below</h2>
            <table >
                <thead>
                    <tr>
                        <th>Please enter the following information below</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Carrier:</td>
                        <td><select id="Select1" name="carrier">
                    <option>Please Select</option>
                    <option value="AT&T"</option>AT&T
                    <option value ="TMobile"</option>TMobile
                    <option value="VodaFone"</option>VodaFone   
                </select></td>
                    </tr>
                    <tr>
                        <td> Node ID:</td>
                        <td><input id="Select2" type="text" name="enteredValue" /> </td>
                    </tr>
                    <tr>
                        <td><input type="submit" id="Select1" value="Submit"</td>
                    </tr>
                </tbody>
            </table>
            </form>

  
        </body>
    </html>