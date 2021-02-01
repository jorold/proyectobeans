<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdept" 
             class="controllers.Controller01Departamentos" 
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/margin.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Departamentos</h1>
        <h3>Versión 1.0</h3>
        <form method="post">
            <label>Introduzca número: </label>
            <input class="margin" type="number" name="cajanumero" required/><br/>
            <label>Introduzca nuevo nombre: </label>
            <input class="margin" type="text" name="cajanombre" required/><br/>
            <label>Introduzca nueva localidad: </label>
            <input class="margin" type="text" name="cajaloc" required/><br/>
            <button class="margin" type="submit">Modificar</button>
        </form>
        <%
        String dato = request.getParameter("cajanumero");        
        if(dato != null){
            int deptno = Integer.parseInt(dato);
            String nombre = request.getParameter("cajanombre");
            String localidad = request.getParameter("cajaloc");
            controllerdept.modificarDepartamento(deptno, nombre, localidad);
        }
        %>
        <table border="1">
            <thead>
            <th>Número</th>
            <th>Nombre</th>
            <th>Localidad</th>
            <tbody>
                <%=controllerdept.getTablaDepartamentos()%>
            </tbody>
            </thead>
        </table>
    </body>
</html>
