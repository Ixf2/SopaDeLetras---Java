package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModeloSopa {

    private final String servidor = "jdbc:mariadb://localhost:3306/";
    private final String bd = "sopa_letras";
    private final String usuario = "root";
    private final String password = "";

    public Connection conectar() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(servidor + bd, usuario, password);
            System.out.println("Conexión con éxito");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }

        return con;
    }

    public void crearBaseDatosYTabla() {
        try {
            Connection conexionServidor = DriverManager.getConnection(servidor, usuario, password);
            Statement st = conexionServidor.createStatement();

            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + bd);
            st.executeUpdate("USE " + bd);

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS palabras (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "palabra VARCHAR(50) NOT NULL UNIQUE" +
                ")"
            );

            st.close();
            conexionServidor.close();

            System.out.println("Base de datos y tabla preparadas");

        } catch (SQLException e) {
            System.out.println("Error al crear BD o tabla: " + e.getMessage());
        }
    }
    
     public boolean insertarPalabra(String palabra) {
        String sql = "INSERT INTO palabras (palabra) VALUES (?)";

        try {
            Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, palabra.toUpperCase());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar palabra: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPalabra(String palabra) {
        String sql = "DELETE FROM palabras WHERE palabra = ?";

        try {
            Connection con = conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, palabra.toUpperCase());

            int filas = ps.executeUpdate();

            ps.close();
            con.close();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar palabra: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<String> consultarPalabras() {
    ArrayList<String> lista = new ArrayList<>();

    String sql = "SELECT palabra FROM palabras";

    try {
        Connection con = conectar();

        if (con == null) {
            System.out.println("ERROR: No hay conexión con la base de datos.");
            return lista;
        }

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            lista.add(rs.getString("palabra"));
        }

        rs.close();
        st.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error al consultar palabras: " + e.getMessage());
    }

    return lista;
}

    public String consultarPalabrasTexto() {
        ArrayList<String> lista = consultarPalabras();

        String texto = "";

        for (String palabra : lista) {
            texto += palabra + "\n";
        }

        return texto;
    }
    
    
    
    
}