package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

public class Bean07EmpleadosDepartamentoUpdate {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection cn = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public void IncrementarSalarios(int deptno, int incremento) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "update emp set salario = salario + ? "
                + "where dept_no = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, incremento);
        pst.setInt(2, deptno);
        pst.executeUpdate();
        cn.close();
    }
}
