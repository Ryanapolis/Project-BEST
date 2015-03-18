<!DOCTYPE html>

<link rel="stylesheet" href="indexcss.css">
    <html lang="en" xmlns="http://www.w3.org/1999/xhtml">
        <head> 
            <script type="text/javascript" src="syniverse.js"></script>
            <script language="java" type="text/java" src="syniverseQuery.java"></script>
            <script src= "http://maps.google.com/maps/api/js?sensor=false"></script>
            <script language="javascript" type="text/javascript" src="jquery-1.11.1.min.js"></script>
            <meta http-equiv="Content-Type" content="text/html;">
            <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
            <title>Node Location</title>    
        </head>
        <body onload="init();">            
            <form method="post" action="SyniverseFormHandlerServlet">
                <div id="main_conatiner">
                    <div id="query_container">
                        <h1>Syniverse-USF BEST</h1>
                        <br />
                        <table id="tbl_query">
                            <tr>
                                <td>Carrier:</td>
                                <td>
                                    <select id="ddl_carrier" name="carrier">
                                        <option>Please Select</option>
                                        <option value="AT&T"</option>AT&T
                                        <option value ="TMobile"</option>TMobile
                                        <option value="VodaFone"</option>VodaFone   
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td> Node ID:</td>
                                <td>
                                    <input id="tb_node_id" type="text" name="countryValue" /> 
                                </td>
                            </tr>
                            <tr>
                                <td>MCC:</td>
                                <td>
                                    <select name="ddl_mcc">
                                        <option value="310">USA</option>
                                        <option></option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="submit" id="Select1" value="Submit"/>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div id="map_container">WHOA!</div>
                    
                </div>
            </form>
        </body>
    </html>