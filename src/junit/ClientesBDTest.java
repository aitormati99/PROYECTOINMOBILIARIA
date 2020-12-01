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

import logica.datos.ClienteBaseDatos;
import logica.datos.CrearBaseDatos;
import logica.negocios.Cliente;

/**
 * esta es la clase para testear todo lo de la BD de los clientes
 * 
 * @author Alumno
 *
 */

public class ClientesBDTest {

	private CrearBaseDatos basedatos;

	@Before
	/**
	 * este es el metodo para inicializar los valores
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {

		basedatos = new CrearBaseDatos("Inmobiliaria.db");
		basedatos.createLink();
	}

	@After
	/**
	 * este es el metodo para cerrar la conexion al finalziar de testear
	 * 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		basedatos.closeLink();

	}

	@Test
	/**
	 * este es el metodo para ver si al tabla no se crea
	 * 
	 * @throws SQLException
	 */
	public void testFail() throws SQLException {

		logica.datos.ClienteBaseDatos.createClienteTable(basedatos.getConn());
		fail("Tabla no creada");
	}

	@Test
	/**
	 * este es el metodo para testear el insert de clientes
	 */
	public void testInsert() {

		logica.datos.ClienteBaseDatos.createClienteTable(basedatos.getConn());

		ArrayList<String> domicilios = new ArrayList<>();
		domicilios.add("Villa1");
		domicilios.add("Villa2");
		logica.datos.ClienteBaseDatos.insertCliente(basedatos.getConn(), "Aitor", "Pepito", "Intxa", "943212178",
				"88877765O", domicilios);
		ArrayList<Cliente> visto = logica.datos.ClienteBaseDatos.selectAllCliente(basedatos.getConn());

		for (Cliente c : visto) {

			if (c.getDni().equals("88877765O")) {

				assertEquals(c.getNombre(), "Aitor");
				assertEquals(c.getApellido(), "Pepito");
				assertEquals(c.getDireccion(), "Intxa");
				assertEquals(c.getTelefono(), "943212178");

				ArrayList<String> domicilioLeido = c.getNombreDomicilios();

				assertEquals(domicilioLeido.get(0), "Villa1");
				assertEquals(domicilioLeido.get(1), "Villa2");

			}

			logica.datos.ClienteBaseDatos.insertCliente(basedatos.getConn(), "Aitor", "Pepito", "Intxa", null,
					"88877765O", domicilios);
			ArrayList<Cliente> visto1 = logica.datos.ClienteBaseDatos.selectAllCliente(basedatos.getConn());

		}

		for (Cliente c : visto) {

			if (c.getDni().equals("88877765O")) {

				assertNull(c.getNombre());
				assertNull(c.getApellido());
				assertNull(c.getDireccion());
				assertNull(c.getTelefono());
				ArrayList<String> domicilioLeido = c.getNombreDomicilios();

				assertNotEquals(domicilioLeido.get(0), "Villa1");
				assertNotEquals(domicilioLeido.get(1), "Villa2");

			}
		}
	}

	@Test
	/**
	 * este es el metodo para seleccionar el select de los clientes
	 */
	public void select() {

		logica.datos.ClienteBaseDatos.createClienteTable(basedatos.getConn());

		ArrayList<String> domicilios = new ArrayList<>();
		domicilios.add("Villa1");
		domicilios.add("Villa2");
		logica.datos.ClienteBaseDatos.insertCliente(basedatos.getConn(), "Aitor", "Matilla", "Berio", "645567543",
				"73087432Q", domicilios);
		ArrayList<Cliente> visto = logica.datos.ClienteBaseDatos.selectAllCliente(basedatos.getConn());

		for (Cliente c : visto) {

			if (c.getDni().equals("73087432Q")) {

				assertEquals(c.getNombre(), "Aitor");
				assertEquals(c.getApellido(), "Matilla");
				assertEquals(c.getDireccion(), "Berio");
				assertEquals(c.getTelefono(), "645567543");

				ArrayList<String> domicilioLeido = c.getNombreDomicilios();

				assertEquals(domicilioLeido.get(0), "Villa1");
				assertEquals(domicilioLeido.get(1), "Villa2");

			}

		}
		logica.datos.ClienteBaseDatos.insertCliente(basedatos.getConn(), "Aitor", "Matilla", "Berio", null, "73087432Q",
				domicilios);
		ArrayList<Cliente> visto1 = logica.datos.ClienteBaseDatos.selectAllCliente(basedatos.getConn());

		for (Cliente c : visto1) {

			if (c.getDni().equals("73087432Q")) {

				assertNull(c.getNombre());
				assertNull(c.getApellido());
				assertNull(c.getDireccion());
				assertNull(c.getTelefono());

				ArrayList<String> domicilioLeido = c.getNombreDomicilios();

				assertNotEquals(domicilioLeido.get(0), "Villa1");
				assertNotEquals(domicilioLeido.get(1), "Villa2");
			}
		}
	}

	@Test
	/**
	 * este es el metodo para testear el delete de los clientes
	 */
	public void delete() {

		logica.datos.ClienteBaseDatos.createClienteTable(basedatos.getConn());

		ArrayList<String> domicilios = new ArrayList<>();
		domicilios.add("Villa1");
		domicilios.add("Villa2");
		logica.datos.ClienteBaseDatos.insertCliente(basedatos.getConn(), "Pedro", "Martinez", "Asuncion", null,
				"77766654P", domicilios);
		logica.datos.ClienteBaseDatos.delete(basedatos.getConn(), "71234567N");
		ArrayList<Cliente> visto = logica.datos.ClienteBaseDatos.selectAllCliente(basedatos.getConn());

		for (Cliente a : visto) {

			assertNotEquals(a.getDni(), "77766654P");

		}

	}

}
