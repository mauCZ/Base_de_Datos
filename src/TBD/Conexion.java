package TBD;
import java.sql.*;
/*
 * Esta clase maneja una conexion, mas que todo para poder prenderla o apagarla
 */
public class Conexion{
	private Connection conexion;
	private String username,password;
	public Conexion(String username,String password) {
		this.username = username;
		this.password = password;
	}
	/*
	 * Prender conexion
	 */
public void conectar() throws SQLException{
		String url = "jdbc:postgresql://localhost:5432/TBD";
		conexion = DriverManager.getConnection(url,username,password);
	}
	public void apagar() throws SQLException{
		conexion.close();
	}
	public Connection getConexion() {
		return conexion;
	}
}
