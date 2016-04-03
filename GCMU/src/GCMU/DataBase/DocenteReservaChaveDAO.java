/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.Chaves;
import GCMU.classes.Docente;
import GCMU.classes.DocenteReservaChave;
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
public class DocenteReservaChaveDAO {

    public void insert(DocenteReservaChave docenteReservaChave) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        String sql = "INSERT INTO Docente_Reserva_Chaves_tb(horaPedido, horaDevolucao, data, suap, idChave) VALUES(CURTIME(),null,CURDATE(),?,?)";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, docenteReservaChave.getSuap());
            stmt.setInt(2, docenteReservaChave.getIdChave());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<DocenteReservaChave> read() {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DocenteReservaChave> drcs = new ArrayList<DocenteReservaChave>();

        try {

            String sql = "SELECT * FROM Docente_Reserva_Chaves_tb";

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DocenteReservaChave drc = new DocenteReservaChave();
                drc.setIdChave(rs.getInt("idChave"));
                drc.setData(rs.getDate("data"));
                drc.setSuap(rs.getInt("suap"));
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

    public List<DocenteReservaChave> read2(Docente doc) {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DocenteReservaChave> drcs = new ArrayList<DocenteReservaChave>();

        try {

            String sql = "SELECT * FROM Docente_Reserva_Chaves_tb where suap = ?";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, doc.getSuap());
            rs = stmt.executeQuery();

            while (rs.next()) {
                DocenteReservaChave drc = new DocenteReservaChave();
                drc.setIdChave(rs.getInt("idChave"));
                drc.setData(rs.getDate("data"));
                drc.setSuap(rs.getInt("suap"));
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

    public DocenteReservaChave getById(Integer pk) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        DocenteReservaChave docenteReservaChave = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT id,"
                    + " horaPedido,"
                    + " horaDevolucao,"
                    + " data,"
                    + " suap,"
                    + " idChave"
                    + " FROM Docente_Reserva_Chaves_tb"
                    + " WHERE id = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<DocenteReservaChave> docenteReservaChaves = convertToList(rs);

            if (!docenteReservaChaves.isEmpty()) {
                docenteReservaChave = docenteReservaChaves.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return docenteReservaChave;
    }

    private List<DocenteReservaChave> convertToList(ResultSet rs) throws SQLException {

        List<DocenteReservaChave> docenteReservaChaves = new ArrayList<DocenteReservaChave>();

        try {

            while (rs.next()) {

                // Chaves
                DocenteReservaChave docenteReservaChave = new DocenteReservaChave();

                docenteReservaChave.setId(rs.getInt("id"));
                docenteReservaChave.setHoraDevolucao(rs.getString("horaDevolucao"));
                docenteReservaChave.setHoraPedido(rs.getString("horaPedido"));
                docenteReservaChave.setData(rs.getDate("data"));

                ChavesDAO chavesdao = new ChavesDAO();
                docenteReservaChave.setChaves(chavesdao.getById(rs.getInt("idChave")));

                docenteReservaChaves.add(docenteReservaChave);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return docenteReservaChaves;
    }

    public void update(DocenteReservaChave docenteReservaChave) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE Docente_Reserva_Chaves_tb"
                    + " SET horaDevolucao=?"
                    + " WHERE id=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, docenteReservaChave.getHoraDevolucao());
            stmt.setInt(2, docenteReservaChave.getId());

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

            String sql = "DELETE FROM Docente_Reserva_Chaves_tb"
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
     public int retornaId(int mat) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        

            String sql = "SELECT idChave FROM Docente_Reserva_Chaves_tb where suap = ?";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mat);

            stmt.executeUpdate();
            rs = stmt.executeQuery();
          
           
                
            int valor = rs.getInt("idChave");
          
               
            return valor;

        

        

    }
}
