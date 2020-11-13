package logica.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import logica.negocios.Administrador;
import logica.negocios.Domicilio;
import logica.negocios.Factura;

/**
 * 
 * @author Aitor
 *
 */
public class FacturaBaseDatos {

	/**
	 * creo la tabla de las facturas
	 * 
	 * @param conn
	 *            conexion de la bd
	 */
	public static void createFacturaTable(Connection conn) {
		;

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS factura (\n" + "    numFac integer PRIMARY KEY,\n"
				+ "    fecha text NOT NULL,\n" + "	   coste integer NOT NULL,\n"
				+ "    nombreDomicilios text NOT NULL \n" + ");";

		try (Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * insertar datos de las facturas
	 * 
	 * @param conn
	 *            conexion de la bd
	 * 
	 * @param numFac
	 *            numero de la factura
	 * @param fecha
	 *            fecha de la factura
	 * @param coste
	 *            coste total de la factura
	 * @param domicilios
	 *            nombre de los domicilios comprados
	 */
	public static void insertFactura(Connection conn, int numFac, String fecha, double coste,
			ArrayList<String> domicilios) {
		String sql = "INSERT INTO factura(numFac,fecha,coste,nombreDomicilios) VALUES(?,?,?,?)";
		String nombreDomicilios = "";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < domicilios.size(); i++) {

				if (i == domicilios.size() - 1) {
					nombreDomicilios += domicilios.get(i);
				} else if (i < domicilios.size() - 1) {
					nombreDomicilios += domicilios.get(i) + ",";

				}

			}

			pstmt.setInt(1, numFac);
			pstmt.setString(2, fecha);
			pstmt.setDouble(3, coste);
			pstmt.setString(4, nombreDomicilios);
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * selecciona las facturas
	 * 
	 * @param conn
	 *            conexion de la bd
	 * 
	 * @return devuelve las facturas de la bd
	 */
	public static ArrayList<Factura> selectAllFactura(Connection conn) {
		String sql = "SELECT numFac, fecha, coste, nombreDomicilios FROM factura";
		ArrayList<Factura> list = new ArrayList<Factura>();
		String fecha = null;
		int numfac = 0;
		int coste = 0;
		ArrayList<String> listaDomicilios = new ArrayList<String>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				numfac = rs.getInt("numFac");
				fecha = rs.getString("fecha");
				coste = rs.getInt("coste");

				// COMO LEER LOS STRING DE LOS DOMICILIOS
				Collections.addAll(listaDomicilios, rs.getString("nombreDomicilios").split("\\s*,\\s*"));

				Date fechaFac = null;
				try {
					fechaFac = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(fecha);

				} catch (ParseException e) {

					e.printStackTrace();
				}

				// pasar a arraylist

				Factura select = new Factura(fechaFac, coste, numfac, listaDomicilios);
				list.add(select);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

}
