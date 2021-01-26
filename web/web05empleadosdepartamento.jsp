<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beanempleadosdept" class="beans.Bean05EmpleadosDepartamento" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Empleados departamento</h1>
        <form method="post">
            <select name="selectdept">
            <%=beanempleadosdept.getEmpleadosDepartamentos()%>
            </select>
            <button type="submit">Ver empleados</button>            
        </form>
            <%
            String dato = request.getParameter("selectdept");
            if(dato != null){
            int codigo = Integer.parseInt(dato);            
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th>Apellido</th>
                        <th>Oficio</th>
                        <th>Salario</th>
                    </tr>
                </thead>
                <tbody>
            <%=beanempleadosdept.getVerEmpleados(codigo)%>
                </tbody>
            </table>
            <%
            }            
            %>            
    </body>
</html>
