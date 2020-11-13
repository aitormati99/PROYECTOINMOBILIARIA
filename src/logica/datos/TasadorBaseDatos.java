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
import logica.negocios.Tasador;

import java.text.SimpleDateFormat;

/**
 * 
 * @author Aitor
 *
 */

public class TasadorBaseDatos {

	/**
	 * creo la tabla de los comerciales
	 * 
	 * @throws SQLException
	 *             si no se hace salta la excepción
	 */

	public static void createTasadorTable(Connection conn) throws SQLException {

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS tasador (\n" + "    DNI text PRIMARY KEY,\n"
				+ "    sueldo integer NOT NULL,\n" + "    horarioLaboral integer NOT NULL,\n"
				+ "    contadorFacturas integer NOT NULL\n" + " );";

		try (Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * insertar los tasadores en la bd
	 * 
	 * @param DNI
	 *            dni del tasador
	 * @param sueldo
	 *            sueldo del tasador
	 * @param horarioLaboral
	 *            horas que trabaja el tasador
	 * @param contadorFacturas
	 *            numero de facturas del tasador
	 * @throws SQLException
	 *             si no se hace salta la excepción
	 */
	public static void insertTasador(Connection conn, String DNI, int sueldo, int horarioLaboral,
			int contadorFacturas) {
		String sql = "INSERT INTO tasador(DNI,sueldo, horarioLaboral,contadorFacturas) VALUES(?,?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, DNI);
			pstmt.setInt(2, sueldo);
			pstmt.setInt(3, horarioLaboral);
			pstmt.setInt(4, contadorFacturas);
			pstmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * selecciona todos los tasadores de la bd
	 * 
	 * @param conn
	 *            conexion con la bd
	 * @return devuelve tasadores de la bd
	 */
	public static ArrayList<Tasador> selectAllTasador(Connection conn) {
		String sql = "SELECT DNI, sueldo, horarioLaboral,nombreClientes FROM tasador";
		ArrayList<Tasador> list = new ArrayList<Tasador>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				String dni = rs.getString("DNI");
				int sueldo = rs.getInt("sueldo");
				int horas = rs.getInt("horarioLaboral");
				int contadorFacturas = rs.getInt("contadorFacturas");

				Tasador select = new Tasador(dni, sueldo, horas, contadorFacturas);
				list.add(select);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	/**
	 * modifica los tasadores de la bd
	 * 
	 * @param conn
	 *            conexion de la bd
	 * 
	 * @param conn
	 *            conexion de la bd
	 * 
	 * @param DNI
	 *            dni del tasador
	 * @param sueldo
	 *            sueldo del tasador
	 * @param horasDia
	 *            horas que trabaja el tasador
	 * @param contadorFacturas
	 *            facturas de los tasadores
	 */
	public static void updateTasador(Connection conn, String DNI, int sueldo, int horarioLaboral,
			int contadorFacturas) {
		String sql = "UPDATE tasador SET sueldo = ? , horarioLaboral = ? , contadorFacturas= ? WHERE DNI = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setString(1, DNI);
			pstmt.setDouble(2, sueldo);
			pstmt.setInt(3, horarioLaboral);
			pstmt.setInt(4, contadorFacturas);

			// update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * elimina el tasador
	 * 
	 * @param conn
	 *            conexion de la bd
	 * 
	 * @param dni
	 *            dni del tasador
	 */

	public static void delete(Connection conn, String dni) {
		String sql = "DELETE FROM tasador WHERE DNI = ?";

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
