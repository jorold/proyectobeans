package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Hospital;
import oracle.jdbc.OracleDriver;

public class RepositoryHospital {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public ArrayList<Hospital> getHospitales() throws SQLException {
        ArrayList<Hospital> lista = new ArrayList<>();
        Connection cn = this.getConnection();
        String sql = "select * from hospital order by hospital_cod";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Hospital hosp = new Hospital();
            int codigo = rs.getInt("HOSPITAL_COD");
            String nombre = rs.getString("NOMBRE");
            String direccion = rs.getString("DIRECCION");
            String telefono = rs.getString("TELEFONO");
            int camas = rs.getInt("NUM_CAMA");
            hosp.setCodigo(codigo);
            hosp.setNombre(nombre);
            hosp.setDireccion(direccion);
            hosp.setTelefono(telefono);
            hosp.setCamas(camas);
            lista.add(hosp);
        }
        rs.close();
        cn.close();
        return lista;
    }

    public void insertarHospital(String nombre, String direccion,
            String telefono, int camas) throws SQLException {
        Connection cn = this.getConnection();
        String sqlcod = "select max(hospital_cod) from hospital";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sqlcod);
        rs.next();
        String hospi = rs.getString("MAX(HOSPITAL_COD)");
        int codigo = Integer.parseInt(hospi);
        codigo += 1;
        rs.close();
        String sql = "insert into hospital values (?,?,?,?,?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.setString(2, nombre);
        pst.setString(3, direccion);
        pst.setString(4, telefono);
        pst.setInt(5, camas);
        pst.executeUpdate();
        cn.close();
    }
}
