package logica.negocios;

/**
 * Represents a Domicilio
 * 
 * @author Aitor
 * @version 1.0
 * @since 2020
 */
public class Domicilio {

	private String nombre;
	private double precio;
	private boolean comprada;

	/**
	 * Represents Domicilio.
	 */
	public Domicilio() {

	}

	/**
	 * Creates a Domicilio.
	 * 
	 * @param nombre
	 *            The Domicilio's nombre.
	 * @param precio
	 *            The Domicilio's precio.
	 * @param comprada
	 *            The Domicilio's comprada.
	 */
	public Domicilio(String nombre, double precio, boolean comprada) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.comprada = comprada;
	}

	/**
	 * Gets the Domicilio's nombre.
	 * 
	 * @return A string representing the Domicilio's nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the Domicilio's nombre.
	 * 
	 * @param nombre
	 *            A string containing the Domicilio's nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the Domicilio's precio.
	 * 
	 * @return A string representing the Domicilio's precio.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Sets the Domicilio's precio.
	 * 
	 * @param nombre
	 *            A string containing the Domicilio's precio.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Gets the Domicilio's isComprada.
	 * 
	 * @return A string representing the Domicilio's isComprada.
	 */
	public boolean isComprada() {
		return comprada;
	}

	/**
	 * Sets the Domicilio's isComprada.
	 * 
	 * @param nombre
	 *            A string containing the Domicilio's isComprada.
	 */
	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}

}
