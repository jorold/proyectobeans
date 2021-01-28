package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Departamento;
import repositories.Repository01Departamentos;

public class Controller01Departamentos {

    Repository01Departamentos repo;

    public Controller01Departamentos() {
        this.repo = new Repository01Departamentos();
    }

    public String getTablaDepartamentos() throws SQLException {
        ArrayList<Departamento> lista = repo.getDepartamentos();
        String html = "";
        for (Departamento d : lista) {
            html += "<tr>";
            html += "<td>" + d.getNumero() + "</td>";
            html += "<td>" + d.getNombre() + "</td>";
            html += "<td>" + d.getLocalidad() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getSelectDepartamentos() throws SQLException {
        ArrayList<Departamento> lista = repo.getDepartamentos();
        String html = "";
        for (Departamento d : lista) {
            html += "<option value='" + d.getNumero() + "'>"
                    + d.getNombre() + "</option>";

        }
        return html;
    }

    public String getDetallesDepartamento(int deptno) throws SQLException {
        Departamento dept = repo.buscarDepartamento(deptno);
        String html = "<h1>" + dept.getNumero() + "</h1>";
        html += "<h1>" + dept.getNombre() + "</h1>";
        html += "<h1>" + dept.getLocalidad() + "</h1>";
        return html;
    }

    public void eliminarDepartamento(int deptno) throws SQLException {
        this.repo.eliminarDepartamento(deptno);
    }

    public void insertarDepartamento(int deptno,
            String nombre, String localidad) throws SQLException {
        this.repo.insertarDepartamento(deptno, nombre, localidad);
    }
}
