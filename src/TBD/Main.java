package TBD;
import java.sql.*;
import GUI.*;
public class Main {

	public static void main(String[] args) {
		
		MainFrame m = new MainFrame(new DBManager(new Conexion("tbd","tbd")));
//		DBManager db = new DBManager(new Conexion("tbd","tbd"));
//		try {
//			db.conectar();
//			db.retirarMateria(3);
//		}catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
	}

}
