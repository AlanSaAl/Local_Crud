package org.example;

import org.example.service.BdOperations;
import org.example.ui.MainFrame;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*try {
            // se instancia un objeto de la clase de conexiones para poder llamar a sus métodos
            DbConnection dbConnection = new DbConnection();
            // llamado al método de conexión
            Connection connection = dbConnection.conectar();


            // Crear una tabla de ejemplo y agregar algunos datos
            Statement statement = connection.createStatement(); // para que sirve?
            statement.execute("CREATE TABLE IF NOT EXISTS users(id INT PRIMARY KEY, name VARCHAR(50))");
            statement.execute("INSERT INTO users(id, name) VALUES(3, 'Ejemplo dos')");

            // Consultar la tabla
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String userName = resultSet.getString("name");
                System.out.println("ID: " + userId + ", Nombre: " + userName);
            }

            // Cerrar conexiones
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame.createAndShowGUI();
            }
        });
        BdOperations obj = new BdOperations();
        //obj.insertar(11, "xyzw");
        //obj.obtenerRegistro(1);
        //obj.eliminarRegistro(11);
        //obj.actualizarRegistro(2, "Alan");
    } // fin main
}