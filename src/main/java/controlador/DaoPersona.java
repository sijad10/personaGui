package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;

public class DaoPersona {

    public static void registrar(Persona pe) {
        Coneccion co = new Coneccion();
        Connection cn = co.getConeccion();
        String query = "INSERT INTO persona (nombre,profesion) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = cn.prepareCall(query);
            ps.setString(1, pe.getNombre());
            ps.setString(2, pe.getProfesion());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void editar(Persona pe) {
        Coneccion co = new Coneccion();
        Connection cn = co.getConeccion();
        String query = "UPDATE persona SET profesion=? where id=?";
        PreparedStatement ps = null;
        try {
            ps = cn.prepareCall(query);
            ps.setString(1, pe.getProfesion());
            ps.setInt(2, pe.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void eliminar(Persona pe) {
        Coneccion co = new Coneccion();
        Connection cn = co.getConeccion();
        String query = "DELETE FROM persona where id=?";
        PreparedStatement ps = null;
        try {
            ps = cn.prepareCall(query);
            ps.setInt(1, pe.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino el registro");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static DefaultTableModel leer() {
        DefaultTableModel modelo = new DefaultTableModel();
        Coneccion co = new Coneccion();
        Connection cn = co.getConeccion();
        String query = "SELECT * FROM persona";
        PreparedStatement ps = null;   
        ResultSet rs=null;
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("profesion");
        modelo.addColumn("fecha");
        try {
            ps = cn.prepareCall(query);
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnas=rsmd.getColumnCount();
            while(rs.next()){
                Object[] filas=new  Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i]=rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }     
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return modelo;
    }
}
