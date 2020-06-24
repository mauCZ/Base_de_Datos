package TBD;
import java.sql.*;
import GUI.*;
public class Main {

	public static void main(String[] args) {
	
//		MainFrame m = new MainFrame(new DBManager(new Conexion("tbd","tbd")));
		DBManager db = new DBManager(new Conexion("tbd","tbd"));
		try {
			db.conectar();
			db.usuario_activo(19);
			System.out.println(db.estaConectado(19));
			db.usuario_inactivo(19);
			System.out.println(db.estaConectado(19));
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
