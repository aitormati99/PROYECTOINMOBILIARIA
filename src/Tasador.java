/** Represents Tasador
 * @author Alumno Aitor Matilla
 * @version 1.0
 * @since 2020
 */
public class Tasador extends Empleado {

	private int contadorFacturas;
	/**
	 * Represents Tasador.
	 */
	public Tasador() {
		super();
		
	}
	/**Creates a Tasador.
	 *@param nombre The Tasador's nombre.
	 *@param dni The Tasador's  dni.
	 *@param sueldo The Tasador's sueldo.
	 *@param horarioLaboral The Tasador's horarioLaboral.
	 **@param contadorFacturas The Tasador's contadorFacturas.
	 */
	public Tasador(String nombre, String dni, int sueldo, int horarioLaboral,int contadorFacturas) {
		super(nombre, dni, sueldo, horarioLaboral);
		this.contadorFacturas = contadorFacturas;
	}
	/**Gets the Tasador's contadorFacturas.
	 * @return A string representing the Proveedor's casas.
	 */
	public int getContadorFacturas() {
		return contadorFacturas;
	}
	/** Sets the Tasador's contadorFacturas.
	 * @param nombre A string containing the Tasador's contadorFacturas.
	 */
	public void setContadorFacturas(int contadorFacturas) {
		this.contadorFacturas = contadorFacturas;
	}

	
	
	
}
