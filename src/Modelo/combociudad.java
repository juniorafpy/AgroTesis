package Modelo;

import agro.Conexion;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class combociudad {

    String descripcionciudad;
    String idciudad;
    Conexion conn = new Conexion();

    public combociudad(String idciudad, String descripcionciudad) {
        this.idciudad = idciudad;
        this.descripcionciudad = descripcionciudad;
    }

    public String getDescripcionciudad() {
        return descripcionciudad;
    }

    public void setDescripcionciudad(String descripcionciudad) {
        this.descripcionciudad = descripcionciudad;
    }

    public String getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(String idciudad) {
        this.idciudad = idciudad;
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }
    
   public void llenarcombo(JComboBox<combociudad> cbociudad){
       try {
             String sql= "SELECT id, Descripcion from ciudad";
           conn.sentencia = conn.conexion.createStatement();
            conn.resultado = conn.sentencia.executeQuery(sql);
            cbociudad.removeAllItems();
                
            
       } catch (SQLException e) {
       
   }
   }  
}
