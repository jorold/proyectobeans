<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beantablaempleados" class="beans.Bean03TablaEmpleados" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bean empleados</h1>
        <form method="post">
            <label>Incremento salarial: </label>
            <input type="number" name="cajaincremento" required/>
            <button type="submit">Pulsar</button>
        </form>
        <%
        String dato = request.getParameter("cajaincremento");
        if (dato != null){
            int incremento = Integer.parseInt(dato);
            beantablaempleados.incrementarSalarios(incremento);
        }
        %>
        <%=beantablaempleados.getTablaEmpleados()%>
    </body>
</html>
