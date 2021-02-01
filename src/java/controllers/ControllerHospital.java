package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import repositories.RepositoryHospital;
import models.Hospital;

public class ControllerHospital {

    RepositoryHospital repo;

    public ControllerHospital() {
        this.repo = new RepositoryHospital();
    }

    public String getTablaHospitales() throws SQLException {
        ArrayList<Hospital> lista = repo.getHospitales();
        String html = "";
        for (Hospital h : lista) {
            html += "<tr>";
            html += "<td>" + h.getCodigo() + "</td>";
            html += "<td>" + h.getNombre() + "</td>";
            html += "<td>" + h.getDireccion() + "</td>";
            html += "<td>" + h.getTelefono() + "</td>";
            html += "<td>" + h.getCamas() + "</td>";
            html += "<td>";
            html += "<button type='submit' class='btn btn-outline-info' "
                    + "name='modificar' value='" + h.getCodigo() + "'>Modificar</button>";
            html += "</td>";
            html += "<td>";
            html += "<button type='submit' class='btn btn-outline-danger' "
                    + "name='eliminar' value='" + h.getCodigo() + "'>Eliminar</button>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    public void insertarHospital(String nombre, String direccion,
            String telefono, int camas) throws SQLException {
        this.repo.insertarHospital(nombre, direccion, telefono, camas);
    }
}
