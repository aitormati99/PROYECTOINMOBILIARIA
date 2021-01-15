package junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.datos.CrearBaseDatos;
import logica.datos.FacturaBaseDatos;
import logica.negocios.Factura;

/**
 * se teste todo lo de la BD de las facturas
 * 
 * @author Aitor
 *
 */
public class FacturaBDTest {

	private CrearBaseDatos basedatos;

	@Before
	/**
	 * donde se inicializan los valores
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {

		basedatos = new CrearBaseDatos("Inmobiliaria.bd");
		basedatos.createLink();
	}

	@After
	/**
	 * se cierra al conexion despues de testear
	 * 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		basedatos.closeLink();

	}

	@Test
	/**
	 * donde se testea si se ha creado o no la tabla
	 * 
	 * @throws SQLException
	 */
	public void testFail() throws SQLException {

		logica.datos.AdministradorBaseDatos.insertAdministrador(basedatos.getConn(), "12345678G", 200, 5, "anetxu",
				"anebo9");

		fail("Tabla no creada");
	}

	@Test
	/**
	 * donde se testea el insert de facturas
	 */
	public void testInsert() {

		logica.datos.FacturaBaseDatos.createFacturaTable(basedatos.getConn());
		ArrayList<String> domicilios = new ArrayList<>();
		domicilios.add("Villa1");
		domicilios.add("Villa2");
		domicilios.add("Villa3");

		logica.datos.FacturaBaseDatos.insertFactura(basedatos.getConn(), 1, "02-12-2019", 870.000, domicilios);

		ArrayList<Factura> visto = logica.datos.FacturaBaseDatos.selectAllFactura(basedatos.getConn());

		for (Factura a : visto) {

			if (a.getNumFac() == 1) {

				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getFecha());
				assertEquals(fechaS, "02-12-2019");
				assertNotEquals(fechaS, "20-10-2019");

				assertEquals(a.getCoste(), 870.000);
				assertNotEquals(a.getCoste(), 0);

				for (int i = 0; i < domicilios.size(); i++) {

					assertEquals(domicilios.get(0), "Villa1");
					assertEquals(domicilios.get(1), "Villa2");
					assertEquals(domicilios.get(2), "Villa3");

					assertNotEquals(domicilios.get(0), "Villa4");
					assertNotEquals(domicilios.get(1), "Villa3");
					assertNotEquals(domicilios.get(2), "Villa1");

				}
			}
		}

	}

	@Test
	/**
	 * se testea el select de facturas
	 */
	public void select() {

		logica.datos.FacturaBaseDatos.createFacturaTable(basedatos.getConn());
		ArrayList<String> domicilios = new ArrayList<>();
		domicilios.add("Villa1");
		domicilios.add("Villa2");
		domicilios.add("Villa3");

		logica.datos.FacturaBaseDatos.insertFactura(basedatos.getConn(), 3, "13-01-2020", 999.999, domicilios);

		ArrayList<Factura> visto = logica.datos.FacturaBaseDatos.selectAllFactura(basedatos.getConn());

		for (Factura a : visto) {

			if (a.getNumFac() == 3) {

				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String fechaS = format.format(a.getFecha());
				assertEquals(fechaS, "13-01-2020");
				assertNotEquals(fechaS, "29-01-2021");

				assertEquals(a.getCoste(), 999.999);
				assertNotEquals(a.getCoste(), 22);

				for (int i = 0; i < domicilios.size(); i++) {

					assertEquals(domicilios.get(0), "Villa1");
					assertEquals(domicilios.get(1), "Villao");
					assertEquals(domicilios.get(2), "Villa3");

					assertNotEquals(domicilios.get(0), "Villa4");
					assertNotEquals(domicilios.get(1), "Villa3");
					assertNotEquals(domicilios.get(2), "Villa1");

				}
			}
		}

	}

}
