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
 * Es la clase donde estan los diferentes metodos que corresponden a la tabla de
 * los administradores que estan en la base de datos
 * 
 * @author Aitor
 *
 */
public class FacturaBaseDatos {

	
	
	
	
	
	/**
	 * Este metodo crea la tabla de las facturas
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 */
	public static void createFacturaTable(Connection conn) {
		;

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS factura (\n" 
				+ "    numFac integer PRIMARY KEY,\n"
				+ "    fecha text NOT NULL,\n" 
				+ "	   coste integer NOT NULL,\n" 
				+ "    nombreDomicilios text NOT NULL \n"
				+ ");";

		try (Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Es para insertar los datos de las facturas
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * 
	 * @param numFac
	 *            el numero de la factura que sirve para identificarla
	 * @param fecha
	 *            es la fecha de la factura
	 * @param coste
	 *            es el coste total de la factura
	 * @param domicilios
	 *            es el nombre de los domicilios comprados
	 */
	public static void insertFactura(Connection conn, int numFac, String fecha, double coste, ArrayList<String> domicilios) {
		String sql = "INSERT INTO factura(numFac,fecha,coste,nombreDomicilios) VALUES(?,?,?,?)";
		String nombreDomicilios = "";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < domicilios.size(); i++) {

				if (i == domicilios.size() - 1) {
					nombreDomicilios += domicilios.get(i);
				} else if(i<domicilios.size()-1) {
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
	 * selecciona todas las facturas
	 * 
	 * @param conn
	 *            es la conexion de la base de datos
	 * 
	 * @return devuelve las facturas de la base de datos en un array list
	 */
	public static ArrayList<Factura> selectAllFactura(Connection conn) {
		String sql = "SELECT numFac, fecha, coste, nombreDomicilios FROM factura";
		ArrayList<Factura> lista = new ArrayList<Factura>();
		String fecha = null;
		int numfac = 0;
		int coste = 0;
		ArrayList<String> listaDomicilios = new ArrayList<String>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {

				numfac = rs.getInt("numFac");
				fecha = rs.getString("fecha");
				coste = rs.getInt("coste");

				// COMO LEER LOS STRING CON , DE LAS PIZZAS Y VECES
				Collections.addAll(listaDomicilios, rs.getString("nombreDomicilios").split("\\s*,\\s*"));

				Date fechaFac = null;
				try {
					fechaFac = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(fecha);

				} catch (ParseException e) {

					e.printStackTrace();
				}

				// pasar a arraylist

				Factura elegida = new Factura(fechaFac, coste, numfac, listaDomicilios);
				lista.add(elegida);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	
	
}
