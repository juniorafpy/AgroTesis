/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dahiana Sánchez
 */
public class Conexion {
    public String user = "root";
    public String pass = "";
    public String bd = "feria";
    public final String host = "jdbc:mysql://localhost:3306/";
    
    public Connection conexion = null;
    public Statement sentencia;
    public ResultSet resultado;
    
    public Conexion(){
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            conexion = DriverManager.getConnection(host+bd,user,pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void traeDatos(String sql){
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
public void actualizaTabla(String sql){
        try {
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     
}
public void actualizaDatos(String sql){
        try {
            sentencia = conexion.prepareStatement(sql);
            sentencia.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

   public static void main(String[] args) {
 Menu reproducir = new Menu();
reproducir.setVisible(true);
    }
  }