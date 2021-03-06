package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class Bean03TablaEmpleados {
//los métodos internos serán private
//los métodos para la página serán public

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public String getTablaEmpleados() throws SQLException {
        Connection cn = this.getConnection();
        Statement st = cn.createStatement();
        String sql = "select * from emp";
        ResultSet rs = st.executeQuery(sql);
        String html = "<table border ='1'>";
        while (rs.next()) {
            html += "<tr>";
            html += "<td>" + rs.getString("APELLIDO") + "</td>";
            html += "<td>" + rs.getString("OFICIO") + "</td>";
            html += "<td>" + rs.getString("SALARIO") + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        rs.close();
        cn.close();
        return html;
    }

    public void incrementarSalarios(int incremento) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "update emp set salario = salario + ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, incremento);
        pst.executeUpdate();
        cn.close();
    }
}
