package logica.negocios;
import java.util.ArrayList;
import java.util.Date;
/**Represents Factura
 * @author Alumno Aitor Matilla
 * @version 1.0
 * @since 2020
 */
public class Factura {

	private Date fecha;
	private int coste;
	private int numFac;
	private ArrayList<String> nombreDomicilios;
	
	/**
	 * Represents Escritura.
	 */
	public Factura() {
		super();
		
	}

	/**Creates a Factura.
	 *@param fecha The Factura's fecha.
	 *@param coste The Factura's  coste.
	 *@param numFac The Factura's  numFac.
	 *@param dniTasador The Factura's  dniTasador.
	 *@param nombreDomicilios The Factura's  nombreDomicilios.
	 */
	
	public Factura(Date fecha, int coste, int numFac, ArrayList<String> nombreDomicilios) {
		super();
		this.fecha = fecha;
		this.coste = coste;
		this.numFac = numFac;
		this.nombreDomicilios = nombreDomicilios;
	}

	/**Gets the Factura's fecha.
	 * @return A string representing the Factura's fecha.
	 */
	public Date getFecha() {
		return fecha;
	}


	

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**Gets the Factura's coste.
	 * @return A string representing the Factura's coste.
	 */
	public int getCoste() {
		return coste;
	}

	/** Sets the Factura's coste.
	 * @param nombre A string containing the Factura's coste.
	 */
	public void setCoste(int coste) {
		this.coste = coste;
	}

	/**Gets the Factura's numFac.
	 * @return A string representing the Factura's numFac.
	 */
	public int getNumFac() {
		return numFac;
	}

	/** Sets the Factura's numFac.
	 * @param nombre A string containing the Factura's numFac.
	 */
	public void setNumFac(int numFac) {
		this.numFac = numFac;
	}

	
	
	/**Gets the Factura's nombreDomicilios.
	 * @return A string representing the Factura's nombreDomicilios.
	 */
	
	

	public ArrayList<String> getNombreDomicilios() {
		return nombreDomicilios;
	}
	
	/** Sets the Factura's nombreDomicilios.
	 * @param nombre A string containing the Factura's nombreDomicilios.
	 */

	public void setNombreDomicilios(ArrayList<String> nombreDomicilios) {
		this.nombreDomicilios = nombreDomicilios;
	}

	
	
	
}
