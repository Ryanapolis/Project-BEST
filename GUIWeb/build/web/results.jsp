<%-- 
    Document   : results
    Created on : Mar 10, 2015, 8:50:56 PM
    Author     : Ashley
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="indexcss.css">
<html>
    <head>
        <script type="text/javascript" src="syniverse.js"></script>
            <script language="java" type="text/java" src="syniverseQuery.java"></script>
            <script src= "http://maps.google.com/maps/api/js?sensor=false"> </script>
            <script language="javascript" type="text/javascript" src="jquery-1.11.1.min.js"></script>
            <meta http-equiv="Content-Type" content="text/html;" >
            <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results Page</title>
    </head>
    <body onload="init();">
        <h1>Below are your results!</h1>
        <table id="resultstable" >
                <thead>
                    <tr>
                        <th>Network Range Summary:</th>
                        <th><c:if test="${not empty enteredValue}">${userNodeID}
                                <script>test(${userNodeID})</script>
                            </c:if></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Carrier List:</td>
                        <td><select name="Carrier List">
                            <option>Carriers</option>
                            <c:forEach var="d" items="${Data}">
                                <option value="${d}">${d}</option>
                            </c:forEach>
                        </select></td>
                        
                    </tr>
                    <tr>
                        <td>Submit New Form?</td>
                        <td>   <form method="post" action="SyniverseFormHandlerServlet">
                                <!--This will represent the coordinate string -->
                                Here
                                <c:if test="${not empty coordinate}">
                                ${coordinate}
                                </c:if>
                                <br />      
                                <br />
                                <input type="submit" value="Yes" /><br />
                                <br />    
                        </form></td>
                        
                    </tr>
                </tbody>
            </table>
                   
   <div id="mymap"></div>
   <div id="Message"></div>
   <div id="Location">
       hellow
   </div>
    </body>
</html>
