package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class Bean04EliminarEnfermo {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public String getTablaEnfermo() throws SQLException {
        Connection cn = this.getConnection();
        Statement st = cn.createStatement();
        String sql = "select * from enfermo";
        ResultSet rs = st.executeQuery(sql);
        String html = "<table border='1'>";
        html += "<thead>";
        html += "<tr>";
        html += "<th>Inscripción</th>";
        html += "<th>Apellido</th>";
        html += "<th>Sexo</th>";
        html += "</tr>";
        html += "</thead>";
        while (rs.next()) {
            html += "<tbody>";
            html += "<tr>";
            html += "<td>" + rs.getString("INSCRIPCION") + "</td>";
            html += "<td>" + rs.getString("APELLIDO") + "</td>";
            html += "<td>" + rs.getString("SEXO") + "</td>";
            html += "</tr>";
            html += "</tbody>";
        }
        html += "</table>";
        rs.close();
        cn.close();
        return html;
    }

    public void eliminarEnfermo(int eliminar) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "delete from enfermo where inscripcion = ? ";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, eliminar);
        pst.executeUpdate();
        cn.close();
    }
}
