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
        <h1>Web Hospitales</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Hospital num</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Camas</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=controllerhospital.getTablaHospitales()%>
            </tbody>
        </table>
    </body>
</html>
