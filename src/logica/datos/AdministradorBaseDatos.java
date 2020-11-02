package logica.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logica.negocios.Administrador;

/**
 * Es la clase donde estan los diferentes metodos que corresponden a la tabla de
 * los administradores que estan en la base de datos
 * 
 * @author Aitor
 *
 */
public class AdministradorBaseDatos {

	/**
	 * Este metodo crea la tabla de los administradores
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 */
	
	
	
	public static void createAdministradorTable(Connection conn) {

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS administrador (\n"
				+ "    DNI text PRIMARY KEY,\n"
				+ "    sueldo integer NOT NULL,\n" 
				+ "    horarioLaboral integer NOT NULL,\n"
				+ "    nombreUser text NOT NULL,\n" 
				+ "    contraseña text NOT NULL\n" + ");";

		try (Statement stmt = conn.createStatement();) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * este metodo sirve para insertar administradores en la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * @param DNI
	 *            el dni del administrador
	 * @param sueldo
	 *            el sueldo del administrador
	 * @param horasDia
	 *            las horas que trabaja  el administrador
	 * @param nombreUser
	 *            el nombre del usuario del administrador
	 * @param contraseña
	 *            la contraseña del administrador
	 * @throws SQLException
	 *             si no se puede realizar salta la excepción sqlexception
	 */
	public static void insertAdministrador(Connection conn, String DNI, int sueldo, int horarioLaboral, String nombre,
			String contraseña) throws SQLException {
		String sql = "INSERT INTO administrador(DNI,sueldo,horarioLaboral,nombre,contraseña) VALUES(?,?,?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, DNI);
			pstmt.setInt(2, sueldo);
			pstmt.setInt(3, horarioLaboral);
			pstmt.setString(4, nombre);
			pstmt.setString(5, contraseña);

			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo selecciona a los administradores que hay que la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * @return devuelve un array list de todos los administradores que hay
	 */
	public static ArrayList<Administrador> selectAllAdministrador(Connection conn) {
		String sql = "SELECT DNI,sueldo,horarioLaboral,nombre,contraseña FROM administrador";
		ArrayList<Administrador> lista = new ArrayList<Administrador>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			
			while (rs.next()) {
				
				Administrador seleccionado = new Administrador(rs.getString("DNI"), rs.getInt("sueldo"),
						rs.getInt("horasDia"), rs.getString("nombreUser"), rs.getString("contraseña"));
				lista.add(seleccionado);


				
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	
	
}


