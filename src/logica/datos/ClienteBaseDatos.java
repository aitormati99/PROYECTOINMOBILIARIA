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
 * 
 * @author Aitor
 *
 */
public class ClienteBaseDatos {

	/**
	 * metodo para crear la tabla de clientes
	 * 
	 * @param conn
	 *            conexion con la base de datos
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
	 * insertar clientes a la bd
	 * 
	 * @param conn
	 *            conexion con la base de datos
	 * @param DNI
	 *            dni del cliente
	 * @param nombre
	 *            nombre del cliente
	 * @param apellido
	 *            apellido del cliente
	 * @param direccion
	 *            direccion del cliente
	 * @param telefono
	 *            telefono del cliente
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
	 * seleccionar todos los clientes de la bd
	 * 
	 * @param conn
	 *            conexion con la base de datos
	 * @return devuelve los clientes de la bd
	 */
	public static ArrayList<Cliente> selectAllCliente(Connection conn) {
		String sql = "SELECT nombre,apellido,telefono,direccion,DNI,nombreDomicilios FROM cliente";
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellido");
				int telefono = rs.getInt("Telefono");
				String direccion = rs.getString("Direccion");
				String dni = rs.getString("DNI");

				// COMO LEER LOS STRING DE LOS DOMICILIOS

				ArrayList<String> listaDomicilios = new ArrayList<String>();
				Collections.addAll(listaDomicilios, rs.getString("nombreDomicilios").split("\\s*,\\s*"));

				Cliente elegido = new Cliente(nombre, apellido, direccion, telefono, dni, listaDomicilios);
				list.add(elegido);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	/**
	 * eliminar un cliente de la base de datos
	 * 
	 * @param conn
	 *            conexion con la base de datos
	 * @param dni
	 *            dni del cliente
	 */
	public static void delete(Connection conn, String dni) {
		String sql = "DELETE FROM cliente WHERE DNI = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, dni);

			// delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
