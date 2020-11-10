package logica.datos;

import java.sql.Statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import logica.negocios.Administrador;
import logica.negocios.Cliente;
import logica.negocios.Domicilio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Esta clase es todo lo que corresponde para la tabla de los clientes de la
 * base de datos
 * 
 * @author Aitor
 *
 */
public class ClienteBaseDatos {

	/**
	 * Este metodo sirve para crear la tabla de los clientes
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 */
	public static void createClienteTable(Connection conn) {

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS cliente (\n" + "    nombre text NOT NULL,\n"
				+ "    apellido text NOT NULL,\n" + "    telefono text NOT NULL,\n" + "    direccion text NOT NULL,\n"
				+ "    DNI text PRIMARY KEY,\n" + "    nombreDomicilios text NOT NULL\n" + ");";

		try (Statement stmt = conn.createStatement()) {
			// create a new table

			stmt.execute(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo sirve para insertar los clientes en la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * @param DNI
	 *            es el dni del cliente
	 * @param nombre
	 *            es el nombre del cliente
	 * @param apellido
	 *            es el apellido del cliente
	 * @param direccion
	 *            es la direccion del cliente
	 * @param telefono
	 *            es el telefono del cliente
	 * @param casas
	 *            es una lista de las casas que compra el cliente
	 */

	public static void insertCliente(Connection conn, String nombre, String apellido, String telefono, String direccion,
			String DNI, ArrayList<String> nombreDomicilios) {
		String sql = "INSERT INTO cliente(nombre,apellido,direccion,DNI,telefono,nombreDomicilios) VALUES(?,?,?,?,?,?)";
		String domicilios = "";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < nombreDomicilios.size(); i++) {

				if (i == nombreDomicilios.size() - 1) {
					domicilios += nombreDomicilios.get(i);
				} else if (i < nombreDomicilios.size() - 1) {
					domicilios += nombreDomicilios.get(i) + ",";
				}

			}

			pstmt.setString(1, nombre);
			pstmt.setString(2, apellido);
			pstmt.setString(3, telefono);
			pstmt.setString(4, direccion);
			pstmt.setString(5, DNI);
			pstmt.setString(6, domicilios);
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo sirve para seleccionar todos los clientes de la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * @return devuelve todos los clientes de la base de datos
	 */
	public static ArrayList<Cliente> selectAllCliente(Connection conn) {
		String sql = "SELECT nombre,apellido,telefono,direccion,DNI,nSombreDomicilios FROM cliente";
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellido");
				int telefono = rs.getInt("Telefono");
				String direccion = rs.getString("Direccion");
				String dni = rs.getString("DNI");

				// COMO LEER LOS STRING CON , DE LAS PIZZAS Y VECES

				ArrayList<String> listaDomicilios = new ArrayList<String>();
				Collections.addAll(listaDomicilios, rs.getString("nombreDomicilios").split("\\s*,\\s*"));

				Cliente elegido = new Cliente(nombre, apellido, direccion, telefono, dni, listaDomicilios);
				lista.add(elegido);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	/**
	 * Este metodo sirve para eliminar un cliente de la base de datos
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * @param dni
	 *            es el dni del cliente
	 */
	public static void delete(Connection conn, String dni) {
		String sql = "DELETE FROM cliente WHERE DNI = ?";

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
