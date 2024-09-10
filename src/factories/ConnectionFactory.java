package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnetion() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_exercicio02", "postgres", "coti");
			
			
		} catch (Exception e) {
			System.out.println("\nFalha ao tentar conectar ao banco de dados");
			System.out.println(e.getMessage());
		}
		
		return connection;
	}
}
