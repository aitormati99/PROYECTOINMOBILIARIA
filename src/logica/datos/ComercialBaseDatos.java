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
 * Es la clase donde estan los diferentes metodos que corresponden a la tabla de
 * los repartidores que estan en la base de datos
 * 
 * @author Aitor
 *
 */

public class ComercialBaseDatos {

	/**
	 * Este metodo crea la tabla de los comerciales
	 * 
	 * @throws SQLException
	 *             si no se puede realizar salta la excepción sqlexception
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
	 * Este metodo sirve para insertar los comerciales en la base de datos
	 * 
	 * @param DNI
	 *            es el dni del comercial
	 * @param sueldo
	 *            es el sueldo del comercial
	 * @param horasDia
	 *            es las horas qe trabaja al dia el comercial
	 * @param clientes
	 *            son los clientes del comercial
	 * @throws SQLException
	 *             si no se puede realizar salta la excepción sqlexception
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
	 * Es el metodo que selecciona todos los comerciales de la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * 
	 * @return devuelve todos los comerciales de la base de datos en un array
	 */
	public static ArrayList<Comercial> selectAllComercial(Connection conn) {
		String sql = "SELECT DNI, sueldo, horarioLaboral,nombreClientes FROM repartidor";
		ArrayList<Comercial> lista = new ArrayList<Comercial>();
		ArrayList<String> listaClientes = new ArrayList<String>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				String dni = rs.getString("DNI");
				int sueldo = rs.getInt("sueldo");
				int horas = rs.getInt("horarioLaboral");

				// COMO LEER LOS STRING CON , DE LAS PIZZAS Y VECES
				Collections.addAll(listaClientes, rs.getString("nombreClientes").split("\\s*,\\s*"));

				Comercial elegido = new Comercial(dni, sueldo, horas, listaClientes);
				lista.add(elegido);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	/**
	 * Es el metodo que modifica los comerciales de la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * 
	 * @param DNI
	 *            es el dni del comercial
	 * @param sueldo
	 *            es el sueldo del comercial
	 * @param horasDia
	 *            es las horas qe trabaja al dia el comercial
	 * @param cadCarne
	 *            los nombres de los clioentes al que atiende el comercial
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
	 *            es la conexion de la base de datos
	 * 
	 * @param dni
	 *            el dni del comercial
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
