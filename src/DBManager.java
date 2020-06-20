import java.sql.*;

public class DBManager {
	private Conexion conexion;
	
	public DBManager(Conexion c) {
		conexion = c;
	}
	public void conectar() throws SQLException{
		conexion.conectar();
	}
	public void apagar() throws SQLException{
		conexion.apagar();
	}
}
