<%-- 
    Document   : updateVaccine
    Created on : Dec 2, 2021, 4:06:15 PM
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
        <h1>UPDATE VACCINE</h1><br>
        <form name="typeVaccine" action="updarw.jsp" method="POST">
            ID : <input type="text" name="id" value="" size="20" />
            <br>
            DOSE : <input type="text" name="id" value="" size="20" />
            <br>
            <select name="type">
                <option>SV</option>
                <option>SP</option>
                <option>AZ</option>
                <option>PZ</option>
                <option>MD</option>
                <option>others</option>
            </select>
            <br>
            <input type="submit" value="send" name="submit" />
        </form>
        <br>
        <a href="index.html">RETURN TITLE</a>    </body>
</html>
