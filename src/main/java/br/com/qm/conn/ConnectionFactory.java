package br.com.qm.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			
			return DriverManager.getConnection(					
					"jdbc:postgresql://localhost:5432/qeepmoving","postgres","Coelho@1979");
			
		} catch (SQLException e) {
			System.err.println("Erro ao estabelecer conexão com o banco de dados!");
			System.err.println(e.getMessage());
		}
		
		return null;
		
	}
	

}
