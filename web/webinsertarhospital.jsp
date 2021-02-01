<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerhospital" class="controllers.ControllerHospital" 
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String nombre = request.getParameter("cajanombre");
        if (nombre != null){           
            String direccion = request.getParameter("cajadireccion");
            String telefono = request.getParameter("cajatelefono");
            String cam = request.getParameter("cajacamas");
            int camas = Integer.parseInt(cam);
            controllerhospital.insertarHospital(nombre, direccion, telefono, camas);
            %>
            <jsp:forward page="webhospitales.jsp"/>
            <%
        }
        %>
        <h1>Insertar Hospital</h1>
        <form method="post">            
            <label>Nombre: </label>
            <input type="text" class="form-control" name="cajanombre"/>
            <label>Dirección: </label>
            <input type="text" class="form-control" name="cajadireccion"/>
            <label>Teléfono: </label>
            <input type="text" class="form-control" name="cajatelefono"/>
            <label>Camas: </label>
            <input type="text" class="form-control" name="cajacamas"/>
            <button type="submit" class="btn btn-outline-info">Insertar</button>
        </form>
    </body>
</html>
