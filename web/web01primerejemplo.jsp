<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean01" class="beans.Bean01PrimerEjemplo" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Primer Java Beans</h1>
        <%=bean01.getSaludo()%>
        <form method="post">
            <label>Introduzca su nombre: </label>
            <input type="text" name="cajanombre"/>
            <button type="submit">Mostrar Saludo</button>
        </form>
        <%
        String nombre = request.getParameter("cajanombre");
            if (nombre != null) {
                //llamamos al bean y pintamos lo que devuelve
                %>
                <%=bean01.getSaludoPersonal(nombre)%>
                <%
            }
        %>
    </body>
</html>
