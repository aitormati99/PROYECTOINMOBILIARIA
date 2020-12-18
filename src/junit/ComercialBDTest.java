package junit;

import static org.junit.Assert.*;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.ComercialBaseDatos;
import logica.datos.CrearBaseDatos;

import logica.negocios.Comercial;

/**
 * se testea todo lo de la BD de comerciales
 * 
 * @author Aitor
 *
 */

public class ComercialBDTest {

	private CrearBaseDatos basedatos;

	@Before
	/**
	 * se inicializan los valores
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {

		basedatos = new CrearBaseDatos("Inmobiliaria.bd");
		basedatos.createLink();
	}

	@After
	/**
	 * se cierra la conexion despues de testear
	 * 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		basedatos.closeLink();

	}

	@Test
	/**
	 * se testea si se a creado o no la tabla
	 * 
	 * @throws SQLException
	 */
	public void testFail() throws SQLException {

		logica.datos.AdministradorBaseDatos.insertAdministrador(basedatos.getConn(), "85846733O", 2200, 8, "tata",
				"tatita");

		fail("Tabla no creada");
	}

	@Test
	/**
	 *  se testea el insert
	 * 
	 * @throws SQLException
	 */
	public void testInsert() throws SQLException {

		ArrayList<String> clientes = new ArrayList<String>();
		clientes.add("Pedro");
		clientes.add("Virginia");
		clientes.add("Andres");
		logica.datos.ComercialBaseDatos.createComercialTable(basedatos.getConn());
		logica.datos.ComercialBaseDatos.insertComercial(basedatos.getConn(), "84864532Ñ", 2500, 8, clientes);
		ArrayList<Comercial> visto = logica.datos.ComercialBaseDatos.selectAllComercial(basedatos.getConn());

		for (Comercial c : visto) {

			if (c.getDni().equals("84864532Ñ")) {

				assertEquals(c.getSueldo(), 2500);
				assertEquals(c.getHorarioLaboral(), 8);

				for (int i = 0; i < clientes.size(); i++) {

					assertEquals(clientes.get(0), "Pedro");
					assertEquals(clientes.get(1), "Virginia");
					assertEquals(clientes.get(2), "Andres");

					assertNotEquals(clientes.get(0), "Maria");
					assertNotEquals(clientes.get(1), "Domingo");
					assertNotEquals(clientes.get(2), "Lunes");

				}
			}

			logica.datos.ComercialBaseDatos.insertComercial(basedatos.getConn(), "12345633P", 2500, 8, null);
			ArrayList<Comercial> visto1 = logica.datos.ComercialBaseDatos.selectAllComercial(basedatos.getConn());

			for (Comercial a : visto1) {

				if (a.getDni().equals("12345633P")) {

					assertNotEquals(a.getSueldo(), 300);
					assertNotEquals(a.getHorarioLaboral(), 7);

					assertNull(c.getClientes());
				}
			}
		}

	}

	@Test
	/**
	 *  se testea el select
	 * 
	 * @throws SQLException
	 */
	public void testSelect() throws SQLException {

		ArrayList<String> clientes = new ArrayList<String>();
		clientes.add("Pedro");
		clientes.add("Virginia");
		clientes.add("Andres");

		logica.datos.ComercialBaseDatos.createComercialTable(basedatos.getConn());
		logica.datos.ComercialBaseDatos.insertComercial(basedatos.getConn(), "12112121Q", 2500, 8, clientes);
		ArrayList<Comercial> visto = logica.datos.ComercialBaseDatos.selectAllComercial(basedatos.getConn());

		for (Comercial c : visto) {

			if (c.getDni().equals("12112121Q")) {

				assertEquals(c.getSueldo(), 2500);
				assertEquals(c.getHorarioLaboral(), 8);

				for (int i = 0; i < clientes.size(); i++) {

					assertEquals(clientes.get(0), "Pedro");
					assertEquals(clientes.get(1), "Virginia");
					assertEquals(clientes.get(2), "Andres");

					assertNotEquals(clientes.get(0), "Maria");
					assertNotEquals(clientes.get(1), "Domingo");
					assertNotEquals(clientes.get(2), "Lunes");

				}
			}

			logica.datos.ComercialBaseDatos.insertComercial(basedatos.getConn(), "12345699A", 3450, 10, clientes);
			ArrayList<Comercial> visto1 = logica.datos.ComercialBaseDatos.selectAllComercial(basedatos.getConn());

			for (Comercial a : visto1) {

				if (a.getDni().equals("12345699A")) {

					assertNotEquals(a.getSueldo(), 2590);
					assertNotEquals(a.getHorarioLaboral(), 6);

					assertNotEquals(clientes.get(0), "Maria");
					assertNotEquals(clientes.get(1), "Domingo");
					assertNotEquals(clientes.get(2), "Lunes");
				}
			}

		}
	}

	@Test
	/**
	 *  se testea el update
	 * 
	 * @throws SQLException
	 */
	public void testUpdate() throws SQLException {

		ArrayList<String> clientes = new ArrayList<String>();
		clientes.add("Pedro");
		clientes.add("Virginia");
		clientes.add("Andres");

		logica.datos.ComercialBaseDatos.createComercialTable(basedatos.getConn());
		logica.datos.ComercialBaseDatos.insertComercial(basedatos.getConn(), "12345699A", 3450, 10, clientes);
		logica.datos.ComercialBaseDatos.updateComercial(basedatos.getConn(), "12345699A", 3000, 8, clientes);
		ArrayList<Comercial> visto = logica.datos.ComercialBaseDatos.selectAllComercial(basedatos.getConn());

		for (Comercial c : visto) {

			if (c.getDni().equals("12345699A")) {

				assertEquals(c.getSueldo(), 3000);
				assertEquals(c.getHorarioLaboral(), 8);

				for (int i = 0; i < clientes.size(); i++) {

					assertEquals(clientes.get(0), "Pedro");
					assertEquals(clientes.get(1), "Virginia");
					assertEquals(clientes.get(2), "Andres");

					assertNotEquals(c.getSueldo(), 3450);
					assertNotEquals(c.getHorarioLaboral(), 10);
				}
			}

		}
	}

	@Test
	/**
	 *  se testea el delete
	 * 
	 * @throws SQLException
	 */
	public void testDelete() throws SQLException {

		ArrayList<String> clientes = new ArrayList<String>();
		clientes.add("Pedro");
		clientes.add("Virginia");
		clientes.add("Andres");

		logica.datos.ComercialBaseDatos.createComercialTable(basedatos.getConn());
		logica.datos.ComercialBaseDatos.insertComercial(basedatos.getConn(), "12345699A", 3450, 10, clientes);
		logica.datos.ComercialBaseDatos.delete(basedatos.getConn(), "12345699A");
		ArrayList<Comercial> visto = logica.datos.ComercialBaseDatos.selectAllComercial(basedatos.getConn());

		for (Comercial a : visto) {

			assertNotEquals(a.getDni(), "12345699A");

		}

	}

}
