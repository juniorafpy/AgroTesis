package controlador;

import Modelo.PersonalDAO;
import agro.Conexion;
import static agro.Personales.txtCI;
import static agro.Personales.txtDireccion;
import static agro.Personales.txtGmail;
import static agro.Personales.txtapellido;
import static agro.Personales.txtnombre;
import static agro.Personales.txttelefono;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalCTR {

    PersonalDAO personal = new PersonalDAO();
    Conexion conn = new Conexion();
    String cn;
    Statement st;
    ResultSet rs;

    public void InsertaDato() {
        String sql = "Insert into empleados (Nombre, Apellido, CI, telefono, direccion, gmail)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conexion.prepareStatement(sql);
            ps.setString(1, txtnombre.getText());
            ps.setString(2, txtapellido.getText());
            ps.setString(3, txtCI.getText());
            ps.setString(4, txttelefono.getText());
            ps.setString(5, txtDireccion.getText());
            ps.setString(6, txtGmail.getText());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PersonalCTR.class.getName()).log(Level.SEVERE, null, e);

        }

        System.out.println(sql);
    }

    public void ModificaDato() {

        String sql = "update empleados set Nombre=?, Apellido=?, telefono=?, direccion=?, gmail=?"
                + "where id= ?";
        try {
            PreparedStatement ps = conn.conexion.prepareStatement(sql);
            ps.setString(1, txtnombre.getText());
            ps.setString(2, txtapellido.getText());
            ps.setString(3, txttelefono.getText());
            ps.setString(4, txtDireccion.getText());
            ps.setString(5, txtGmail.getText());
            ps.setString(6, txtCI.getText());
            ps.setString(6, txtCI.getText());

            ps.execute();
        } catch (SQLException e) {
            Logger.getLogger(PersonalCTR.class.getName()).log(Level.SEVERE, null, e);
        }

        System.out.println(sql);

    }

}
