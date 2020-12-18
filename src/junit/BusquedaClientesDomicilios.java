package junit;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BusquedaClientesDomicilios {


	
		private ArrayList<Integer> Input = new ArrayList<>();
		private ArrayList<String> domicilios = new ArrayList<>();

		@Before
		/**
		 * para inicializar los valores
		 * 
		 * @throws Exception
		 */
		public void setUp() throws Exception {

			// array input
			Input.add(4);
			Input.add(3);
			Input.add(5);
			Input.add(1);
			Input.add(2);

			// array domicilios nombres
			domicilios.add("Villa1");
			domicilios.add("Villa2");
			domicilios.add("Villa3");
			domicilios.add("Villa4");
			domicilios.add("Villa5");
		}

		@Test
		/**
		 *  para testear el merge
	 */
		public void testMerge() {
			ArrayList<Integer> num = logica.presentacion.BusquedaClienteDomicilio.mergeSort(Input, domicilios);

			for (int i = 0; i < num.size(); i++) {
				assertSame(4, num.get(0));
				assertSame(3, num.get(1));
				assertSame(5, num.get(2));
				assertSame(1, num.get(3));
				assertSame(2, num.get(4));
			}

			for (int i = 0; i < num.size(); i++) {
				assertNotSame(4, num.get(0));
				assertNotSame(2, num.get(1));
				assertNotSame(3, num.get(2));
				assertNotSame(7, num.get(3));
				assertNotSame(5, num.get(4));
			}
		}

		@Test
		public void testMergeSort() {
			fail("Not yet implemented");
		}



}
