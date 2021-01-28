<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean06" class="beans.Bean06EmpleadosDepartamentoLista" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Empleados departamento</h1>
        <ul>
            <%=bean06.getEmpleadosDepartamentos()%>
        </ul>
            <%
            String dato = request.getParameter("deptno");
            if(dato != null){
            int codigo = Integer.parseInt(dato);            
            %>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Apellido</th>
                        <th>Oficio</th>
                        <th>Salario</th>
                    </tr>
                </thead>
                <tbody>
            <%=bean06.getVerEmpleados(codigo)%>
                </tbody>
            </table>
            <%
            }            
            %>            
    </body>
</html>
