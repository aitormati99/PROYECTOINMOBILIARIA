package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.AdministradorBaseDatos;
import logica.datos.CrearBaseDatos;
import logica.negocios.Administrador;

/**
 * esta clase es para testear todo lo de la base de datos del administrador
 * 
 * @author Aitor
 */

public class AdministradorBDTest {

	private CrearBaseDatos basedatos;

	@Before
	/**
	 * este metodo lo hago para inicializar los valores
	 * 
	 * @throws Exception
	 */

	public void setUp() throws Exception {

		basedatos = new CrearBaseDatos("Inmobiliaria.bd");
		basedatos.createLink();

	}

	@After
	/**
	 * esto es para cerrar la conexion despues de testear
	 * 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		basedatos.closeLink();

	}

	@Test
	/**
	 * este es el test en caso de que no se cree la tabla
	 * 
	 * @throws SQLException
	 */
	public void testFail() throws SQLException {

		logica.datos.AdministradorBaseDatos.insertAdministrador(basedatos.getConn(), "98977600H", 2989, 5, "unaitxo",
				"unai007");

		fail("Tabla no creada");
	}

	@Test
	/**
	 * este es el test de insertar los administradores
	 * 
	 * @throws SQLException
	 */
	public void testInsert() throws SQLException {

		logica.datos.AdministradorBaseDatos.createAdministradorTable(basedatos.getConn());
		logica.datos.AdministradorBaseDatos.insertAdministrador(basedatos.getConn(), "18237292P", 1300, 7, "olatzi10",
				"alo");
		ArrayList<Administrador> visto = logica.datos.AdministradorBaseDatos
				.selectAllAdministrador(basedatos.getConn());

		for (Administrador a : visto) {

			if (a.getDni().equals("18237292P")) {

				assertEquals(a.getSueldo(), 1300);
				assertEquals(a.getHorarioLaboral(), 7);
				assertEquals(a.getUsuario(), "olatzi10");
				assertEquals(a.getContrasenya(), "alo");

				assertNotEquals(a.getSueldo(), 2000);
				assertNotEquals(a.getHorarioLaboral(), 4);
				assertNotEquals(a.getUsuario(), "peter77");
				assertNotEquals(a.getContrasenya(), "hey");

			}
		}

	}

	@Test
	/**
	 * este es el test de seleccionar los administradores
	 * 
	 * @throws SQLException
	 */
	public void select() throws SQLException {

		logica.datos.AdministradorBaseDatos.createAdministradorTable(basedatos.getConn());
		logica.datos.AdministradorBaseDatos.insertAdministrador(basedatos.getConn(), "18237292P", 1300, 7, "olatzi10",
				"alo");
		ArrayList<Administrador> visto = logica.datos.AdministradorBaseDatos
				.selectAllAdministrador(basedatos.getConn());

		for (Administrador a : visto) {

			if (a.getDni().equals("73036697N")) {

				assertEquals(a.getSueldo(), 1300);
				assertEquals(a.getHorarioLaboral(), 7);
				assertEquals(a.getUsuario(), "olatzi10");
				assertEquals(a.getContrasenya(), "alo");

				assertNotEquals(a.getSueldo(), 2000);
				assertNotEquals(a.getHorarioLaboral(), 4);
				assertNotEquals(a.getUsuario(), "peter77");
				assertNotEquals(a.getContrasenya(), "hey");
			}
		}

		logica.datos.AdministradorBaseDatos.insertAdministrador(basedatos.getConn(), "18237292P", 1300, 7, null, "alo");
		ArrayList<Administrador> visto1 = logica.datos.AdministradorBaseDatos
				.selectAllAdministrador(basedatos.getConn());

		for (Administrador a : visto) {

			if (a.getDni().equals("73036697N")) {

				assertEquals(a.getSueldo(), 1300);
				assertEquals(a.getHorarioLaboral(), 7);
				assertEquals(a.getUsuario(), "olatzi10");
				assertEquals(a.getContrasenya(), "alo");

				assertNotEquals(a.getSueldo(), 2000);
				assertNotEquals(a.getHorarioLaboral(), 4);
				assertNotEquals(a.getUsuario(), "peter77");
				assertNotEquals(a.getContrasenya(), "hey");

				assertNull(a.getUsuario());

			}
		}

	}
}
