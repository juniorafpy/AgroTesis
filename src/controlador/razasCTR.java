package controlador;

import Modelo.razasDAO;
import agro.Conexion;
import agro.Razas;
import static agro.Razas.cbocategoria;
import static agro.Razas.txtDescripcion;
import static agro.Razas.txtSiglas;
import static agro.Razas.txtid;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class razasCTR {

    razasDAO raza = new razasDAO();
    Conexion conn = new Conexion();
    String cn;
    Statement st;
    ResultSet rs;

    public void InsertaDato(String Descripcion, String Siglas) {
        String categoria;
        categoria = cbocategoria.getItemAt(cbocategoria.getSelectedIndex()).getId();
        String sql = "Insert into razas (Descripcion, Siglas, categoriaid)"
                + " VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.conexion.prepareStatement(sql);
            ps.setString(1, txtDescripcion.getText());
            ps.setString(2, txtSiglas.getText());
            ps.setString(3, categoria);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, e);

        }

        System.out.println(sql);
    }

    public void ModificaDato() {

        String sql = "update razas set Descripcion=?, Siglas=?"
                + "where id= ?";
        try {
            PreparedStatement ps = conn.conexion.prepareStatement(sql);
            ps.setString(1, txtDescripcion.getText());
            ps.setString(2, txtSiglas.getText());
            ps.setString(3, txtid.getText());

            ps.execute();
        } catch (SQLException e) {
            Logger.getLogger(Razas.class.getName()).log(Level.SEVERE, null, e);
        }

        System.out.println(sql);

    }

}
