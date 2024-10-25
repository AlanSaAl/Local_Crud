package org.example.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
* Para manejar las conexiones a BD
* */
public class DbConnection {
    private static final String URL = "jdbc:sqlite:C:/Users/Alan/Documents/Java projects/Base de datos/testDB.db";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public Connection conectar() {
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión ok");
        }catch (SQLException e) {
            System.out.println("Error en la conexión"); // utilizar log
        }
        return conexion;
    }
}
