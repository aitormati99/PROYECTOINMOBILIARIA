package logica.datos;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import logica.negocios.Comercial;

import java.text.SimpleDateFormat;

/**
 * 
 * @author Aitor
 *
 */

public class ComercialBaseDatos {

	/**
	 * con este metodo creo la tabla de los comerciales
	 * 
	 * @throws SQLException
	 *             si no se hace salta la excepción
	 */

	public static void createComercialTable(Connection conn) throws SQLException {

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS comercial (\n" + "    DNI text PRIMARY KEY,\n"
				+ "    sueldo integer NOT NULL,\n" + "    horarioLaboral integer NOT NULL,\n"
				+ "    nombreClientes text NOT NULL\n" + " );";

		try (Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * metodo para insertar los comerciales en la bd
	 * 
	 * @param DNI
	 *            dni del comercial
	 * @param sueldo
	 *            sueldo del comercial
	 * @param horarioLaboral
	 *            horas que trabaja el comercial
	 * @param clientes
	 *            son los clientes del comercial
	 * @throws SQLException
	 *             si no se hace salta la excepción
	 */
	public static void insertComercial(Connection conn, String DNI, int sueldo, int horarioLaboral,
			ArrayList<String> clientes) {
		String sql = "INSERT INTO comercial(DNI,sueldo, horarioLaboral,nombreClientes) VALUES(?,?,?,?)";
		String nombreClientes = "";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < clientes.size(); i++) {

				if (i == clientes.size() - 1) {
					nombreClientes += clientes.get(i);
				} else if (i < clientes.size() - 1) {
					nombreClientes += clientes.get(i) + ",";

				}

			}

			pstmt.setString(1, DNI);
			pstmt.setInt(2, sueldo);
			pstmt.setInt(3, horarioLaboral);
			pstmt.setString(4, nombreClientes);
			pstmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * selecciona los comerciales de la bd
	 * 
	 * @param conn
	 *            conexion de la bd
	 * 
	 * @return devuelve todos los comerciales de la bd
	 */
	public static ArrayList<Comercial> selectAllComercial(Connection conn) {
		String sql = "SELECT DNI, sueldo, horarioLaboral,nombreClientes FROM comercial";
		ArrayList<Comercial> list = new ArrayList<Comercial>();
		ArrayList<String> listaClientes = new ArrayList<String>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				String dni = rs.getString("DNI");
				int sueldo = rs.getInt("sueldo");
				int horas = rs.getInt("horarioLaboral");

				// COMO LEER LOS STRING DE LOS DOMICILIOS
				Collections.addAll(listaClientes, rs.getString("nombreClientes").split("\\s*,\\s*"));

				Comercial elegido = new Comercial(dni, sueldo, horas, listaClientes);
				list.add(elegido);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	/**
	 * modifica los comerciales de la bd
	 * 
	 * @param conn
	 *            conexion de la base de datos
	 * 
	 * @param DNI
	 *            dni del comercial
	 * @param sueldo
	 *            sueldo del comercial
	 * @param horarioLaboral
	 *            horas que trabaja el comercial
	 * @param nombreClientes
	 *            los nombres de los clientes que atiende el comercial
	 */
	public static void updateComercial(Connection conn, String DNI, int sueldo, int horarioLaboral,
			ArrayList<String> clientes) {
		String sql = "UPDATE comercial SET sueldo = ? , horarioLaboral = ? , clientes= ? WHERE DNI = ?";
		String nombreClientes = "";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < clientes.size(); i++) {

				if (i == clientes.size() - 1) {
					nombreClientes += clientes.get(i);
				} else if (i < clientes.size() - 1) {
					nombreClientes += clientes.get(i) + ",";

				}

			}

			// set the corresponding param
			pstmt.setString(1, DNI);
			pstmt.setDouble(2, sueldo);
			pstmt.setInt(3, horarioLaboral);
			pstmt.setString(4, nombreClientes);

			// update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * elimina el comercial
	 * 
	 * @param conn
	 *            conexion de la bd
	 * 
	 * @param dni
	 *            dni del comercial
	 */

	public static void delete(Connection conn, String dni) {
		String sql = "DELETE FROM comercial WHERE DNI = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setString(1, dni);

			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
