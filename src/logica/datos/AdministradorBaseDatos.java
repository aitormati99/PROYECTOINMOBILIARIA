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
	 * Con este metodo creo la tabla de los administradores
	 * 
	 * @param conn
	 *            es la conexion con la base de datos
	 */

	public static void createAdministradorTable(Connection conn) {

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS administrador (\n" + "    DNI text PRIMARY KEY,\n"
				+ "    sueldo integer NOT NULL,\n" + "    horarioLaboral integer NOT NULL,\n"
				+ "    nombreUsuario text NOT NULL,\n" + "    password text NOT NULL\n" + ");";

		try (Statement stmt = conn.createStatement();) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * con esto meto los administradores a la base de datos
	 * 
	 * @param conn
	 *            la conexion con la base de datos
	 * @param DNI
	 *            dni del admin
	 * @param sueldo
	 *            sueldo del admin
	 * @param horarioLaboral
	 *            horas trabaja el admin
	 * @param nombreUsuario
	 *            nombre usuario del admin
	 * @param password
	 *            password del administrador
	 * @throws SQLException
	 *             si no se realiza salta la excepción
	 */
	public static void insertAdministrador(Connection conn, String DNI, int sueldo, int horarioLaboral,
			String nombreUsuario, String password) throws SQLException {
		String sql = "INSERT INTO administrador(DNI,sueldo,horarioLaboral,nombreUsuario,password) VALUES(?,?,?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, DNI);
			pstmt.setInt(2, sueldo);
			pstmt.setInt(3, horarioLaboral);
			pstmt.setString(4, nombreUsuario);
			pstmt.setString(5, password);

			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * con esto selecciono a los admin que estan en la bd
	 * 
	 * @param conn
	 *            conexion con la base de datos
	 * @return devuelve un arrayList de los administradores
	 */
	public static ArrayList<Administrador> selectAllAdministrador(Connection conn) {
		String sql = "SELECT DNI,sueldo,horarioLaboral,nombreUsuario,password FROM administrador";
		ArrayList<Administrador> list = new ArrayList<Administrador>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				Administrador seleccionado = new Administrador(rs.getString("DNI"), rs.getInt("sueldo"),
						rs.getInt("horarioLaboral"), rs.getString("nombreUsuario"), rs.getString("password"));
				list.add(seleccionado);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

}
