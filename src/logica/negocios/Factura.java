package logica.negocios;
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
	private int dniTasador;
	private Domicilio casacomprada;
	
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
	 *@param casaComprada The Factura's  casaComprada.
	 */
	public Factura(Date fecha, int coste, int numFac, int dniTasador, Domicilio casacomprada) {
		super();
		this.fecha = fecha;
		this.coste = coste;
		this.numFac = numFac;
		this.dniTasador = dniTasador;
		this.casacomprada = casacomprada;
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

	/**Gets the Factura's dniTasador.
	 * @return A string representing the Factura's dniTasador.
	 */
	public int getDniTasador() {
		return dniTasador;
	}

	/** Sets the Factura's dniTasador.
	 * @param nombre A string containing the Factura's dniTasador.
	 */
	public void setDniTasador(int dniTasador) {
		this.dniTasador = dniTasador;
	}

	/**Gets the Factura's casaComprada.
	 * @return A string representing the Factura's casaComprada.
	 */
	public Domicilio getCasacomprada() {
		return casacomprada;
	}

	/** Sets the Factura's casaComprada.
	 * @param nombre A string containing the Factura's casaComprada.
	 */
	public void setCasacomprada(Domicilio casacomprada) {
		this.casacomprada = casacomprada;
	}
	
	
	
}
