package GCMU.DataBase;

import GCMU.DataBase.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Discente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DiscenteDAO {

    public boolean insert(Discente discente) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "INSERT INTO discente_tb(matricula, curso, name, email, permissao) VALUES(?,?,?,?,?)";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, discente.getMatricula());
            stmt.setString(2, discente.getCurso());
            stmt.setString(3, discente.getName());
            stmt.setString(4, discente.getEmail());
            stmt.setString(5, discente.getPermissao());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo!");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;

    }

    public List<Discente> read() {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Discente> drcs = new ArrayList<Discente>();

        try {

            String sql = "SELECT * FROM discente_tb";

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Discente drc = new Discente();
                drc.setMatricula(rs.getInt("matricula"));
                drc.setCurso(rs.getString("curso"));
                drc.setEmail(rs.getString("email"));
                drc.setName(rs.getString("name"));
                drc.setPermissao(rs.getString("permissao"));
                drcs.add(drc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChavesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return drcs;

    }
     public List<Discente> read2(Discente di) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Discente> dis = new ArrayList<Discente>();
        Discente discente = new Discente();
        try {
            String sql = "SELECT name , permissao FROM discente_tb where matricula = ?";
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, di.getMatricula());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                // Pessoa
                Discente disc = new Discente();

               
                
                disc.setName(rs.getString("name"));
                
                disc.setPermissao(rs.getString("permissao"));

                dis.add(disc);
            }

        } catch (SQLException sqle) {

           
        }

        return dis;
    }

    public Discente getById(Integer pk) throws SQLException {

        Discente discente = null;

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT discente.matricula,"
                    + " discente.curso,"
                    + " discente.name,"
                    + " discente.email,"
                    + " discente.permissao"
                    + " FROM discente_tb AS discente"
                    + " WHERE discente.m = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Discente> discentes = convertToList(rs);

            if (!discentes.isEmpty()) {
                discente = discentes.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return discente;
    }

    private List<Discente> convertToList(ResultSet rs) throws SQLException {

        List<Discente> discentes = new ArrayList<Discente>();

        try {

            while (rs.next()) {

                // Pessoa
                Discente discente = new Discente();

                discente.setMatricula(rs.getInt("discente.matricula"));
                discente.setCurso(rs.getString("discente.curso"));
                discente.setEmail(rs.getString("discente.email"));
                discente.setPermissao("discente.permissao");
                discente.setName(rs.getString("discente.name"));

                discentes.add(discente);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return discentes;
    }

    public boolean delete(Discente discente) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "DELETE FROM discente_tb"
                    + " WHERE matricula = ? ";

            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, discente.getMatricula());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido!");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;
    }

    public void update(Discente discente) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE discente_tb"
                    + " SET matricula=?, curso=?"
                    + " WHERE matricula=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setLong(1, discente.getMatricula());
            stmt.setString(2, discente.getCurso());
            stmt.setLong(3, discente.getMatricula());

            stmt.execute();

        } catch (SQLException e) {

            System.out.println(e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Discente> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Discente> find(Discente entity) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
