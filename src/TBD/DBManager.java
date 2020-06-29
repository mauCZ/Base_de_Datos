package TBD;
import java.sql.*;
import java.util.ArrayList;
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
	
	//retorna el P.I.D.
	public int getPID() throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select pg_backend_pid();";
		ResultSet res = stm.executeQuery(querie);
		res.next();
		return res.getInt(1);
	}
	
	public String getNombreUsuario(int id) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select username from usuario where id ="+id+";";
		ResultSet res = stm.executeQuery(querie);
		res.next();
		return res.getString(1);
	}
	
	//retorna true si un usuario especifico esta registrado en B.D.
	public boolean estaRegistrado(String username,String password) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select estaRegistrado('"+username+"','"+password+"');";
		ResultSet res = stm.executeQuery(querie);
		res.next();
		return res.getBoolean(1);
	}
	
	//registramos un nuevo usuario
	public  void registrarUsuario(String username, String password) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "call registrar_usuario('"+username+"','"+password+"');";
		stm.executeUpdate(querie);
	}
	
	//registramos sesion
	public void iniciarSesion(int id) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "call iniciar_sesion("+id+");";
		stm.executeUpdate(querie);
	}
	
	public void terminarSesion(int id) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "call terminar_sesion("+id+");";
		stm.executeUpdate(querie);
	}
	
	public String getRol(int id) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select rol.nombre from rol, \n" + 
				"(select usuario_rol.rol_id \n" + 
				"	from usuario_rol, (select id from usuario where id="+id+") as uno\n" + 
				"	where usuario_rol.usuario_id = uno.id) as dos\n" + 
				"where rol.id = dos.rol_id;";
		ResultSet res = stm.executeQuery(querie);
		res.next();
		return res.getString(1);
	}
	
	public ArrayList<String> getFunciones(String rol) throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select uno.nombre from\n" + 
				"	(select rol_id,nombre\n" + 
				"	from rol_funcion\n" + 
				"	join funcion \n" + 
				"	on rol_funcion.funcion_id = funcion.id\n" + 
				"	) as uno\n" + 
				"join rol\n" + 
				"on rol.id = uno.rol_id\n" + 
				"where rol.nombre='"+rol+"';";
		ArrayList<String> funciones = new ArrayList<>();
		ResultSet res = stm.executeQuery(querie);
		while(res.next()) {
			funciones.add(res.getString(1));
		}
		return funciones;
	}
	
	public ArrayList<String> getMateriasDisponibles() throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select nombre from asignatura where disponible = true;";
		ArrayList<String> funciones = new ArrayList<>();
		ResultSet res = stm.executeQuery(querie);
		while(res.next()) {
			funciones.add(res.getString(1));
		}
		return funciones;
	}
	
	public ArrayList<String> getPostulaciones() throws SQLException{
		Statement stm = conexion.getConexion().createStatement();
		String querie = "select e.nombre,p.gestion,a.nombre\n" + 
				"from estudiante as e,postulante as p,asignatura as a\n" + 
				"where e.id = p.estudiante_id and p.asignatura_id=a.id;";
		ArrayList<String> funciones = new ArrayList<>();
		ResultSet res = stm.executeQuery(querie);
		while(res.next()) {
			funciones.add(String.valueOf(res.getString(1))+" | "+String.valueOf(res.getString(2))+" | "+
					String.valueOf(res.getString(3)));
		}
		return funciones;
	}
}
