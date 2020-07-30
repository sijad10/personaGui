package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {

    private final String usuario = "root";
    private final String pass = "";
    Connection co = null;

    public Connection getConeccion() {
        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/persona?serverTimezone=UTC", usuario, pass);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return co;
    }
}
