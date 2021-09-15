/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.productoDAO;
import agro.Conexion;
import static agro.Productos.txtCantidad;
import static agro.Productos.txtCodigoP;
import static agro.Productos.txtDescripcion;
import static agro.Productos.txtIVA;
import static agro.Productos.txtSiglas;
import static agro.Productos.txtid;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dahia
 */
public class productoCTR {
     productoDAO personal = new productoDAO();
    Conexion conn = new Conexion();
    String cn;
    Statement st;
    ResultSet rs;
    public void InsertaDato() {
        String sql = "Insert into productos (descripcion, codigoP, siglas, cantidad, iva)"
                + " VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conexion.prepareStatement(sql);
            ps.setString(1, txtDescripcion.getText());
            ps.setString(2, txtCodigoP.getText());
            ps.setString(3, txtSiglas.getText());
            ps.setString(4, txtCantidad.getText());
            ps.setString(5, txtIVA.getText());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(productoCTR.class.getName()).log(Level.SEVERE, null, e);

        }

        System.out.println(sql);
    }

    public void ModificaDato() {

        String sql = "update productos set descripcion=?, codigoP=?, siglas=?, cantidad=?, iva=?"
                + "where id= ?";
        try {
            PreparedStatement ps = conn.conexion.prepareStatement(sql);
            ps.setString(1, txtDescripcion.getText());
            ps.setString(2, txtCodigoP.getText());
            ps.setString(3, txtSiglas.getText());
            ps.setString(4, txtCantidad.getText());
            ps.setString(5, txtIVA.getText());
            ps.setString(6, txtid.getText());

            ps.execute();
        } catch (SQLException e) {
            Logger.getLogger(productoCTR.class.getName()).log(Level.SEVERE, null, e);
        }

        System.out.println(sql);

    }
}
