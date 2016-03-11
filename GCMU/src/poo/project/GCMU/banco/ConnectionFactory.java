package poo.project.GCMU.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	private static ConnectionFactory connFactory;

	public static ConnectionFactory getInstance() {

		if (connFactory == null)
			connFactory = new ConnectionFactory();

		return connFactory;
	}

	public Connection getConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			// Endere�o do Banco, Usu�rio e Senha. Substituir: [BANCO], [USUARIO], [SENHA]
			return DriverManager.getConnection("jdbc:mysql://localhost/gcmu", "root","ifpbinfo");

		} catch (SQLException | ClassNotFoundException e) {

			throw new RuntimeException(e);
		}
	}

}
