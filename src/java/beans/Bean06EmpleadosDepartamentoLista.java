package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class Bean06EmpleadosDepartamentoLista {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public String getEmpleadosDepartamentos() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from dept";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String html = "";
        while (rs.next()) {
            String numero = rs.getString("dept_no");
            String nombre = rs.getString("dnombre");
            html += "<li>";
            html += "<a href='web06empleadosdepartamentolista.jsp?deptno=" + numero + "'>"
                    + "" + nombre + "</a>";
            html += "</li>";
        }
        rs.close();
        cn.close();
        return html;
    }

    public String getVerEmpleados(int codigo) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from emp where dept_no = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        String html = "";
        while (rs.next()) {
            html += "<tr>";
            html += "<td>" + rs.getString("apellido") + "</td>";
            html += "<td>" + rs.getString("oficio") + "</td>";
            html += "<td>" + rs.getString("salario") + "</td>";
            html += "</tr>";
        }
        rs.close();
        cn.close();
        return html;
    }
}
