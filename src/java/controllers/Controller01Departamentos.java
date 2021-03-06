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

    public void modificarDepartamento(int deptno,
            String nombre, String localidad) throws SQLException {
        this.repo.modificarDepartamento(deptno, nombre, localidad);
    }

    public String getFormularioDepartamento(int deptno) throws SQLException {
        Departamento dept = this.repo.buscarDepartamento(deptno);
        String html = "<label>Número: </label>"
                + "<input type='number' name='cajanumero' value='" + dept.getNumero() + "' readonly/><br/>";
        html += "<label>Nombre: </label>"
                + "<input type='text' name='cajanombre' value='" + dept.getNombre() + "' required/><br/>";
        html += "<label>Localidad: </label>"
                + "<input type='text' name='cajalocalidad' value='" + dept.getLocalidad() + "' required/><br/>";
        return html;
    }

    public String getTablaEdicionDepartamentos() throws SQLException {
        ArrayList<Departamento> departamentos = this.repo.getDepartamentos();
        String html = "";
        for (Departamento dept : departamentos) {
            html += "<tr>";
            html += "<td>" + dept.getNumero() + "</td>";
            html += "<td>" + dept.getNombre() + "</td>";
            html += "<td>" + dept.getLocalidad() + "</td>";
            html += "<td>";
            html += "<button type='button' name='botonedicion' ";
            html += "value='" + dept.getNumero() + "' ";
            html += "data-nombre='" + dept.getNombre() + "' ";
            html += "data-localidad='" + dept.getLocalidad() + "' ";
            html += ">Editar</button>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getTablaEliminarDepartamento() throws SQLException {
        ArrayList<Departamento> departamentos = this.repo.getDepartamentos();
        String html = "";
        for (Departamento dept : departamentos) {
            html += "<tr>";
            html += "<td>" + dept.getNumero() + "</td>";
            html += "<td>" + dept.getNombre() + "</td>";
            html += "<td>" + dept.getLocalidad() + "</td>";
            html += "<td>";
            html += "<button type='submit'name='eliminar' "
                    + "value='" + dept.getNumero() + "'>Eliminar</button>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }
}
