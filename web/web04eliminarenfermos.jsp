<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beantablaenfermo" class="beans.Bean04EliminarEnfermo" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar Enfermos</h1>
        <form method="post">
            <label>Eliminar enfermo</label>
            <input type="number" name="cajanumero" required placeholder="Introducir Inscripción"/>
            <button type="submit">Pulsar para eliminar</button>
        </form>
        <%
        String dato = request.getParameter("cajanumero");
        if(dato != null){
            int eliminar = Integer.parseInt(dato);
            beantablaenfermo.eliminarEnfermo(eliminar);
        }
        %>
        <%=beantablaenfermo.getTablaEnfermo()%>
    </body>
</html>
