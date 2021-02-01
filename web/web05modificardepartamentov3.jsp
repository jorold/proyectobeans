<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdept" 
             class="controllers.Controller01Departamentos" 
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1>Modificar departamento</h1>
        <h3>Versión 3.0</h3>
        <table border="1">
            <thead>
            <th>Número</th>
            <th>Nombre</th>
            <th>Localidad</th>
            <tbody>
                <%=controllerdept.getTablaEdicionDepartamentos()%>
            </tbody>
            </thead>
        </table>
            <form method="post" style="display:none" id="formeditar">
                <label>Número: </label>
                <input type="text" name="cajanumero" id="cajanumero" readonly/><br/>
                <label>Nombre: </label>
                <input type="text" name="cajanombre" id="cajanombre"/><br/>
                <label>Localidad: </label>
                <input type="text" name="cajalocalidad" id="cajalocalidad"/><br/>
                <button type="submit">Modificar departamento</button>
                <button type="button" id="botoncancelar">Cancelar</button>
            </form>
            <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
            <script>
                $(document).ready(function(){
                  $("button[name=botonedicion]").click(function(){
                      $("#formeditar").show();
                      var numero = $(this).val();
                      $("#cajanumero").val(numero);
                      var nombre = $(this).data("nombre");
                      var loc = $(this).data("localidad");
                      $("#cajanombre").val(nombre);
                      $("#cajalocalidad").val(loc);
                  });
                  $("#botoncancelar").click(function(){
                      $("#formeditar").hide();
                  });
                });
            </script>
    </body>
</html>
