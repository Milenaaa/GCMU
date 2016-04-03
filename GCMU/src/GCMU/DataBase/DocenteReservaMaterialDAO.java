/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.DataBase.ConnectionFactory;
import GCMU.DataBase.MateriaisDAO;
import GCMU.classes.DiscenteReservaMaterial;
import GCMU.classes.DocenteReservaMaterial;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Milena
 */
public class DocenteReservaMaterialDAO {

    public void insert(DocenteReservaMaterial docenteReservaMaterial) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        String sql = "INSERT INTO Docente_Reserva_Materiais_tb(horaPedido, horaDevolucao, data, suap, idMaterial) VALUES(CURTIME(),null,CURDATE(),?,?)";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

           
            stmt.setInt(1, docenteReservaMaterial.getSuap());
            stmt.setInt(2, docenteReservaMaterial.getIdMaterial());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DocenteReservaMaterial getById(Integer pk) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        DocenteReservaMaterial docenteReservaMaterial = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT id,"
                    + " horaPedido,"
                    + " horaDevolucao,"
                    + " data,"
                    + " matricula,"
                    + " idChave"
                    + " FROM Docente_Reserva_Material_tb"
                    + " WHERE id = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<DocenteReservaMaterial> docenteReservaMateriais = convertToList(rs);

            if (!docenteReservaMateriais.isEmpty()) {
                docenteReservaMaterial = docenteReservaMateriais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return docenteReservaMaterial;
    }

    private List<DocenteReservaMaterial> convertToList(ResultSet rs) throws SQLException {

        List<DocenteReservaMaterial> docenteReservaMateriais = new ArrayList<DocenteReservaMaterial>();

        try {

            while (rs.next()) {

                // Chaves
                DocenteReservaMaterial docenteReservaMaterial = new DocenteReservaMaterial();

                docenteReservaMaterial.setId(rs.getInt("id"));
                docenteReservaMaterial.setHoraDevolucao(rs.getString("horaDevolucao"));
                docenteReservaMaterial.setHoraPedido(rs.getString("horaPedido"));
                docenteReservaMaterial.setData(rs.getDate("data"));

                MateriaisDAO materiaisdao = new MateriaisDAO();
                docenteReservaMaterial.setMaterial(materiaisdao.getById(rs.getInt("idMaterial")));

                docenteReservaMateriais.add(docenteReservaMaterial);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return docenteReservaMateriais;
    }
    
    public void update(DocenteReservaMaterial docenteReservaMaterial) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE Docente_Reserva_Materiais_tb"
                    + " SET horaDevolucao=?"
                    + " WHERE id=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, docenteReservaMaterial.getHoraDevolucao());
            stmt.setInt(2, docenteReservaMaterial.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alterado!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }

    }
    public boolean delete(Integer pk) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "DELETE FROM Docente_Reserva_Materiais_tb"
                    + " WHERE suap = "+pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;
    }

}
