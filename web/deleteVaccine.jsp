<%-- 
    Document   : deleteVaccine
    Created on : Dec 2, 2021, 4:13:21 PM
    Author     : poramet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>DELETE VACCINE</h1><br>
        <form name="deleteStudent" action="delete" method="POST">
            ID : <input type="text" name="id" value="" size="20" />
            <br>
            <input type="submit" value="send" name="submit" />
        </form>
        <br>
        <a href="index.html">RETURN TITLE</a>       </body>
</html>
