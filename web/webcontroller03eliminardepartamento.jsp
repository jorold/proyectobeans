<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdelete" 
             class="controllers.Controller01Departamentos" 
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            form{
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <h1>Eliminar departamento</h1>
        <form method="post">
            <label>Introduzca número</label>
            <input type="number" name="cajanumero" required/>
            <button type="submit">Eliminar</button>
        </form>
        <%
        String dato = request.getParameter("cajanumero");
        if(dato != null){
            int deptno = Integer.parseInt(dato);
            controllerdelete.eliminarDepartamento(deptno);
        }
        %>
        <table border="1">
            <thead>
            <th>Número</th>
            <th>Nombre</th>
            <th>Localidad</th>
            <tbody>
                <%=controllerdelete.getTablaDepartamentos()%>
            </tbody>
            </thead>
        </table>
    </body>
</html>
