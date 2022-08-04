package jdbc.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection con = null;
	public static Connection conectar() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String senha = "postgres";
		try {
			con = DriverManager.getConnection(url, user, senha);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	//Método para fechar a conexão
	public static void fechar() {
		con = null;
	}
}
