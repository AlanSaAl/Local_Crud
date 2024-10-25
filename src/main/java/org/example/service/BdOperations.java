package org.example.service;

import org.example.dbConnection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BdOperations {

    DbConnection conexion;

    public BdOperations() {
        this.conexion = new DbConnection();
    }

    public void insert(int id, String nombre) {
        try (Connection con = conexion.conectar();
             PreparedStatement pst = con.prepareStatement("INSERT INTO users(id, name) VALUES(?,?)")) { // try-with-resources
            pst.setInt(1, id);
            pst.setString(2, nombre);

            int n = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String obtenerRegistro(int id) {
        List<String> registros = new ArrayList<>();

        try (Connection conn = conexion.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id = " + id)) {

            System.out.println(rs);
            registros.add(rs.getString("id"));
            registros.add(rs.getString("name"));
            System.out.println(registros);

            return registros.toString();
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }

    public void update(int id, String nombre) {
        try (Connection conn = conexion.conectar();
             PreparedStatement pst = conn.prepareStatement(String.format("UPDATE users SET name = '%s' WHERE id = %d", nombre, id))) {
            int n = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void eliminarRegistro(int id) {
        try (Connection conn = conexion.conectar();
             PreparedStatement pst = conn.prepareStatement("DELETE FROM users WHERE id = " + id)) {
            int n = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
