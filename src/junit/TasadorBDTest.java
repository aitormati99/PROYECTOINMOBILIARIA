package junit;

import static org.junit.Assert.*;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.TasadorBaseDatos;
import logica.datos.CrearBaseDatos;

import logica.negocios.Tasador;

/**
 * este es la clase donde se testea todo lo de la BD de tasadores
 * 
 * @author Aitor
 *
 */
public class TasadorBDTest {

	private CrearBaseDatos basedatos;

	@Before
	/**
	 * este es el metodo donde se inicializan los valores
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {

		basedatos = new CrearBaseDatos("Inmobiliaria.bd");
		basedatos.createLink();
	}

	@After
	/**
	 * este es el metodo donde se cierra la conexion despues de testear
	 * 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		basedatos.closeLink();

	}

	@Test
	/**
	 * este es el metodo donde se testea si se a creado o no la tabla
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
	 * este es el metodo donde se testea el insert
	 * 
	 * @throws SQLException
	 */
	public void testInsert() throws SQLException {

		
		logica.datos.TasadorBaseDatos.createTasadorTable(basedatos.getConn());
		logica.datos.TasadorBaseDatos.insertTasador(basedatos.getConn(), "84864532Ñ", 2500, 8, 1);
		ArrayList<Tasador> visto = logica.datos.TasadorBaseDatos.selectAllTasador(basedatos.getConn());

		for (Tasador t : visto) {

			if (t.getDni().equals("84864532Ñ")) {

				assertEquals(t.getSueldo(), 2500);
				assertEquals(t.getHorarioLaboral(), 8);
				assertEquals(t.getContadorFacturas(), 1);

				}
			}

			logica.datos.TasadorBaseDatos.insertTasador(basedatos.getConn(), "12345633P", 2500, 8, 1);
			ArrayList<Tasador> visto1 = logica.datos.TasadorBaseDatos.selectAllTasador(basedatos.getConn());

			for (Tasador t : visto1) {

				if (t.getDni().equals("12345633P")) {

					assertNotEquals(t.getSueldo(), 300);
					assertNotEquals(t.getHorarioLaboral(), 7);
					assertNotEquals(t.getContadorFacturas(), 3);
					
				}
			}
		}

	

	@Test
	/**
	 * este es el metodo donde se testea el select
	 * 
	 * @throws SQLException
	 */
	public void testSelect() throws SQLException {


		logica.datos.TasadorBaseDatos.createTasadorTable(basedatos.getConn());
		logica.datos.TasadorBaseDatos.insertTasador(basedatos.getConn(), "11111111A", 2500, 8, 3);
		ArrayList<Tasador> visto = logica.datos.TasadorBaseDatos.selectAllTasador(basedatos.getConn());

		for (Tasador t : visto) {

			if (t.getDni().equals("11111111A")) {

				assertEquals(t.getSueldo(), 2500);
				assertEquals(t.getHorarioLaboral(), 8);
				assertEquals(t.getContadorFacturas(), 3);

				
			}

			logica.datos.TasadorBaseDatos.insertTasador(basedatos.getConn(), "12345699A", 3450, 10, 2);
			ArrayList<Tasador> visto1 = logica.datos.TasadorBaseDatos.selectAllTasador(basedatos.getConn());

			for (Tasador a : visto1) {

				if (a.getDni().equals("12345699A")) {

					assertNotEquals(a.getSueldo(), 2590);
					assertNotEquals(a.getHorarioLaboral(), 6);
					assertNotEquals(a.getContadorFacturas(), 1);
				}
			}

		}
	}

	@Test
	/**
	 * este es el metodo donde se testea el update
	 * 
	 * @throws SQLException
	 */
	public void testUpdate() throws SQLException {


		logica.datos.TasadorBaseDatos.createTasadorTable(basedatos.getConn());
		logica.datos.TasadorBaseDatos.insertTasador(basedatos.getConn(), "12345699A", 3450, 10, 2);
		logica.datos.TasadorBaseDatos.updateTasador(basedatos.getConn(), "12345699A", 3000, 9, 2);
		ArrayList<Tasador> visto = logica.datos.TasadorBaseDatos.selectAllTasador(basedatos.getConn());

		for (Tasador c : visto) {

			if (c.getDni().equals("12345699A")) {

				assertEquals(c.getSueldo(), 3000);
				assertEquals(c.getHorarioLaboral(), 9);
			

				assertNotEquals(c.getSueldo(), 3450);
				assertNotEquals(c.getHorarioLaboral(), 10);
				}
			}

	}


	@Test
	/**
	 * este es el metodo donde se testea el delete
	 * 
	 * @throws SQLException
	 */
	public void testDelete() throws SQLException {

	

		logica.datos.TasadorBaseDatos.createTasadorTable(basedatos.getConn());
		logica.datos.TasadorBaseDatos.insertTasador(basedatos.getConn(), "12345699A", 3450, 10, 5);
		logica.datos.TasadorBaseDatos.delete(basedatos.getConn(), "12345699A");
		ArrayList<Tasador> visto = logica.datos.TasadorBaseDatos.selectAllTasador(basedatos.getConn());

		for (Tasador a : visto) {

			assertNotEquals(a.getDni(), "12345699A");

		}

	}

}
