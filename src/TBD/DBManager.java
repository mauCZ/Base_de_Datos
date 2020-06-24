package TBD;
import java.sql.*;

public class DBManager {
	private Conexion conexion;
	
	public DBManager(Conexion c) {
		conexion = c;
	}
	/*
	 * Los 2 siguientes metodos se encargan de apagar y conectar la conexion
	 */
	public void conectar() throws SQLException{
		conexion.conectar();
	}
	public void apagar() throws SQLException{
		conexion.apagar();
	}
	
	//Obtenemos el id del usuario que  quiere loggearse, si es errorneo retorna -1
	public int getID(String username, String password) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select id from usuario where username='"+username+"' and password='"+password+"';";
		ResultSet res = stm.executeQuery(querie);
		//si la tabla resultado tiene almenos una fila
		if(res.isBeforeFirst()) {	
			res.next();
			return res.getInt(1);
		}
		else return -1;
	}
	
	//usuario esta activo o descact. para que 2 usuarios con misma user y pass no entren concurrentemente
	public void usuario_activo(int id) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "call usuario_activo("+id+");";
		stm.executeUpdate(querie);
	}
	public void usuario_inactivo(int id) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "call usuario_inactivo("+id+");";
		stm.executeUpdate(querie);
	}
	
	//retorna true si usuario con id esta conectado, falso sino
	//PUEDE CAMBIAR O MEJORAR
	public boolean estaConectado(int id) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select estaConectado("+id+");";
		ResultSet res = stm.executeQuery(querie);
		res.next();
		return res.getBoolean(1);
	}
}