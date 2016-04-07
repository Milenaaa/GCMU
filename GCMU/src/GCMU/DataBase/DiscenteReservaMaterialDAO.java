/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.DataBase.ConnectionFactory;
import GCMU.classes.DiscenteReservaChave;
import GCMU.classes.DiscenteReservaMaterial;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Milena
 */
public class DiscenteReservaMaterialDAO {

    public void insert(DiscenteReservaMaterial discenteReservaMaterial) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        String sql = "INSERT INTO Discente_Reserva_Materiais_tb(horaPedido, horaDevolucao, data, matricula, idMaterial) VALUES(CURTIME(),null,CURDATE(),?,?)";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, discenteReservaMaterial.getMatricula());
            stmt.setInt(2, discenteReservaMaterial.getIdMaterial());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<DiscenteReservaMaterial> read() {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DiscenteReservaMaterial> drcs = new ArrayList<DiscenteReservaMaterial>();

        try {

            String sql = "SELECT * FROM Discente_Reserva_Materiais_tb";

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DiscenteReservaMaterial drc = new DiscenteReservaMaterial();
                drc.setIdMaterial(rs.getInt("idMaterial"));
                drc.setData(rs.getDate("data"));
                drc.setMatricula(rs.getInt("matricula"));
                drc.setHoraDevolucao(rs.getString("horaDevolucao"));
                drc.setHoraPedido(rs.getString("horaPedido"));
                drcs.add(drc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChavesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return drcs;

    }

    public DiscenteReservaMaterial getById(Integer pk) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        DiscenteReservaMaterial discenteReservaMaterial = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT id,"
                    + " horaPedido,"
                    + " horaDevolucao,"
                    + " data,"
                    + " matricula,"
                    + " idChave"
                    + " FROM Discente_Reserva_Material_tb"
                    + " WHERE id = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<DiscenteReservaMaterial> discenteReservaMateriais = convertToList(rs);

            if (!discenteReservaMateriais.isEmpty()) {
                discenteReservaMaterial = discenteReservaMateriais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);

        }

        return discenteReservaMaterial;
    }

    private List<DiscenteReservaMaterial> convertToList(ResultSet rs) throws SQLException {

        List<DiscenteReservaMaterial> discenteReservaMateriais = new ArrayList<DiscenteReservaMaterial>();

        try {

            while (rs.next()) {

                // Chaves
                DiscenteReservaMaterial discenteReservaMaterial = new DiscenteReservaMaterial();

                discenteReservaMaterial.setId(rs.getInt("id"));
                discenteReservaMaterial.setHoraDevolucao(rs.getString("horaDevolucao"));
                discenteReservaMaterial.setHoraPedido(rs.getString("horaPedido"));
                discenteReservaMaterial.setData(rs.getDate("data"));

                MateriaisDAO materiaisdao = new MateriaisDAO();
                discenteReservaMaterial.setMaterial(materiaisdao.getById(rs.getInt("idMaterial")));

                discenteReservaMateriais.add(discenteReservaMaterial);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return discenteReservaMateriais;
    }

    public void update(DiscenteReservaMaterial discenteReservaMaterial) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE Discente_Reserva_Materiais_tb"
                    + " SET horaDevolucao=?"
                    + " WHERE id=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, discenteReservaMaterial.getHoraDevolucao());
            stmt.setInt(2, discenteReservaMaterial.getId());

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

            String sql = "DELETE FROM Discente_Reserva_Materiais_tb"
                    + " WHERE matricula = "+pk;

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
