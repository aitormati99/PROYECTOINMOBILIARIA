package logica.datos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.negocios.Administrador;
import logica.negocios.Factura;
import logica.negocios.Comercial;
import logica.negocios.Domicilio;
import logica.negocios.Tasador;
import logica.negocios.Cliente;

/**
 * Es el que gestiona la base de datos
 * 
 * @author Aitor
 */

public class CrearBaseDatos {

	private Connection conn;
	private String BDnombre;
	private final String URL = "jdbc:sqlite:";

	/**
	 * Es el constructor
	 * 
	 * @param BDname
	 *            es el nombre de la base de datos
	 */

	public CrearBaseDatos(String BDnombre) {
		this.BDnombre = this.URL + BDnombre;

	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Lo que hace es lanzar el gestor
	 */

	public void inicializarBD() {

		try {

			// crear las tablas cliente, administrador, comercial, tasador y
			// factura
			ClienteBaseDatos.createClienteTable(this.conn);
			AdministradorBaseDatos.createAdministradorTable(this.conn);
			ComercialBaseDatos.createComercialTable(this.conn);
			TasadorBaseDatos.createTasadorTable(this.conn);
			FacturaBaseDatos.createFacturaTable(this.conn);

			// insertar datos en la tabla cliente
			ArrayList<String> domicilios = new ArrayList<String>();
			domicilios.add("Villa1");
			ClienteBaseDatos.insertCliente(this.conn, "Jesus", "Remiro", "Berio", "943566578", "12332122X", domicilios);

			ArrayList<String> domicilios1 = new ArrayList<String>();
			domicilios1.add("Villa2");
			ClienteBaseDatos.insertCliente(this.conn, "Maria", "Perez", "Amara", "949860087", "76589709Z", domicilios);

			ArrayList<String> domicilios2 = new ArrayList<String>();
			domicilios2.add("Villa3");
			ClienteBaseDatos.insertCliente(this.conn, "Pedro", "Almodovar", "Martutene", "987065432", "76589743Q",
					domicilios);

			// insertar datos en la tabla administrador

			ArrayList<String> administradores = new ArrayList<String>();
			administradores.add("Admin 1");
			AdministradorBaseDatos.insertAdministrador(this.conn, "78936696Y", 1600, 4, "peter", "aaaa");

			ArrayList<String> administradores1 = new ArrayList<String>();
			administradores.add("Admin 2");
			AdministradorBaseDatos.insertAdministrador(this.conn, "73039996F", 2400, 8, "anebo", "bbbb");

			ArrayList<String> administradores2 = new ArrayList<String>();
			administradores2.add("Admin 3");
			AdministradorBaseDatos.insertAdministrador(this.conn, "74798774G", 1800, 6, "juancen", "cccc");

			ArrayList<String> administradores3 = new ArrayList<String>();
			administradores3.add("Admin 4");
			AdministradorBaseDatos.insertAdministrador(this.conn, "76434000A", 2000, 7, "goros", "dddd");

			ArrayList<String> administradores4 = new ArrayList<String>();
			administradores4.add("Admin 5");
			AdministradorBaseDatos.insertAdministrador(this.conn, "99995392G", 2500, 8, "anti", "eeee");

			// insertar datos en la tabla comercial

			ArrayList<String> clientes = new ArrayList<String>();
			clientes.add("Elena");
			ComercialBaseDatos.insertComercial(this.conn, "73054320U", 1800, 6, clientes);

			ArrayList<String> clientes1 = new ArrayList<String>();
			clientes1.add("Irene");
			ComercialBaseDatos.insertComercial(this.conn, "73087690Y", 2000, 7, clientes);

			ArrayList<String> clientes2 = new ArrayList<String>();
			clientes2.add("Juan");
			ComercialBaseDatos.insertComercial(this.conn, "73043212D", 2100, 8, clientes);

			// insertar datos en la tabla tasador

			ArrayList<String> tasadores = new ArrayList<String>();
			tasadores.add("Maribel");
			TasadorBaseDatos.insertTasador(this.conn, "74565421O", 3456, 5, 1);

			ArrayList<String> tasadores1 = new ArrayList<String>();
			tasadores.add("Francisco");
			TasadorBaseDatos.insertTasador(this.conn, "88877765P", 1234, 6, 2);

			ArrayList<String> tasadores2 = new ArrayList<String>();
			tasadores2.add("Antuan");
			TasadorBaseDatos.insertTasador(this.conn, "44321234U", 1233, 4, 3);

			// insertar datos en la tabla factura
			Domicilio casacomprada;
			ArrayList<String> domicilios3 = new ArrayList<String>();
			domicilios3.add("Villa4");
			FacturaBaseDatos.insertFactura(this.conn, 1, "12-08-2009", 870.000, domicilios3);

			ArrayList<String> domicilios4 = new ArrayList<String>();
			domicilios4.add("Villa5");
			FacturaBaseDatos.insertFactura(this.conn, 2, "04-10-2020", 1.500000, domicilios4);

			// Close connection
			this.closeLink();

		} catch (SQLException e) {

			System.out.println("Process terminated with errors");
		}

	}

	/**
	 * crea la conexion con la base de datos
	 * 
	 */
	public void createLink() {
		try {
			this.conn = DriverManager.getConnection(this.BDnombre);

		} catch (SQLException e) {
			System.out.println("BadAss error creating connection. " + e.getMessage());
		}
	}

	/**
	 * Connect to database
	 *
	 * @param fileName
	 *            the database file name
	 */
	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * cierra la conexion
	 * 
	 */

	public void closeLink() {

		try {

			if (this.conn != null) {

				this.conn.close();
			}
		} catch (SQLException ex) {

			System.out.println("BadAss error closing connection" + ex.getMessage());

		}

	}
}
