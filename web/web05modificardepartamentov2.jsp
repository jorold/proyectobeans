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
        <%
        String dato = request.getParameter("cajanumero");
        if (dato != null){
            int deptno = Integer.parseInt(dato);
            String nombre = request.getParameter("cajanombre");
            String localidad = request.getParameter("cajalocalidad");
            controllerdept.modificarDepartamento(deptno, nombre, localidad);
        }
        %>
        <h1>Modificar Departamentos</h1>
        <h3>Versión 2.0</h3>
        <form method="post">
            <label>Seleccione Departamento</label>
            <select class="margin" name="selectdepartamento">
                <%=controllerdept.getSelectDepartamentos()%>
            </select>
            <button class="margin" type="submit">Detalles</button>
        </form>
            <%
            String datodept = request.getParameter("selectdepartamento");
            if (datodept != null){
                int deptno = Integer.parseInt(datodept);
                %>
                <form method="post">
                  <%=controllerdept.getFormularioDepartamento(deptno)%>
                  <button class="margin" type="submit">Modificar</button>
                </form>                
                <%
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
