package tour.model.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// EIF411 - Diseño y programación de plataformas móviles 
// I Ciclo 2021
//
// Autores:
//    - 117660980     María Fernanda González Arias
//    - 116980485     Scarleth Villarreal Jiménez
public class ConnectionBD {

    protected Connection connectionAux = null;
    
    private static ConnectionBD mInstance;

    public ConnectionBD() {

    }

    public static ConnectionBD getInstance() {
        if (mInstance == null) {
            mInstance = new ConnectionBD();

        }
        return mInstance;
    }

    protected void connect() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");   //Cual base de datos van a usar 
        connectionAux = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
    }

    protected void disconnect() throws SQLException {
        if (!connectionAux.isClosed()) {
            connectionAux.close();
        }
    }

}