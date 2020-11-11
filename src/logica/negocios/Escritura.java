package logica.negocios;

/**
 * Represents Escritura
 * 
 * @author Alumno Aitor
 * @version 1.0
 * @since 2020
 */
public class Escritura {

	private int codigo;
	private int dniCliente;

	/**
	 * Represents Escritura
	 */
	public Escritura() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a Escritura.
	 * 
	 * @param codigo
	 *            The Escritura's codigo.
	 * @param dniCliente
	 *            The Escritura's dniCliente.
	 */
	public Escritura(int codigo, int dniCliente) {
		super();
		this.codigo = codigo;
		this.dniCliente = dniCliente;
	}

	/**
	 * Gets the Escritura's codigo.
	 * 
	 * @return A string representing the Escritura's codigo.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Sets the Escritura's codigo.
	 * 
	 * @param nombre
	 *            A string containing the Escritura's codigo.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the Escritura's dniCliente.
	 * 
	 * @return A string representing the Escritura's dniCliente.
	 */
	public int getDniCliente() {
		return dniCliente;
	}

	/**
	 * Sets the Escritura's dniCliente.
	 * 
	 * @param nombre
	 *            A string containing the Escritura's dniCliente.
	 */
	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}

}
