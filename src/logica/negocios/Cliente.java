package logica.negocios;

import java.util.ArrayList;

/**
 * Represents a cliente.
 * 
 * @author Alumno Aitor
 * @version 1.0
 * @since 2020
 */
public class Cliente {

	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private String dni;
	private ArrayList<String> nombreDomicilios;

	/**
	 * Represents Cliente.
	 */
	public Cliente() {

	}

	/**
	 * Creates an Cliente.
	 * 
	 * @param nombre
	 *            The Cliente's nombre.
	 * @param apellido
	 *            The Cliente's apellido.
	 * @param direccion
	 *            The Cliente's direccion.
	 * @param telefono
	 *            The Cliente's telefono.
	 * @param dni
	 *            The Cliente's dni.
	 * @param casas
	 *            The Cliente's casas.
	 */
	public Cliente(String nombre, String apellido, String direccion, int telefono, String dni,
			ArrayList<String> nombreDomicilios) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
		this.nombreDomicilios = nombreDomicilios;
	}

	/**
	 * Gets the Cliente's nombre.
	 * 
	 * @return A string representing the Cliente's nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the Cliente's nombre.
	 * 
	 * @param nombre
	 *            A string containing the Cliente's nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the Cliente's apellido.
	 * 
	 * @return A string representing the Cliente's apellido.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Sets the Cliente's apellido.
	 * 
	 * @param nombre
	 *            A string containing the Cliente's apellido.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Gets the Cliente's direccion.
	 * 
	 * @return A string representing the Cliente's direccion.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Sets the Cliente's direccion.
	 * 
	 * @param nombre
	 *            A string containing the Cliente's direccion.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Gets the Cliente's telefono.
	 * 
	 * @return A string representing the Cliente's telefono.
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Sets the Cliente's telefono.
	 * 
	 * @param nombre
	 *            A string containing the Cliente's telefono.
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Gets the Cliente's dni.
	 * 
	 * @return A string representing the Cliente's dni.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the Cliente's dni.
	 * 
	 * @param nombre
	 *            A string containing the Cliente's dni.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the Cliente's nombredomicilios.
	 * 
	 * @return A string representing the Cliente's nombredomicilios.
	 */

	public ArrayList<String> getNombreDomicilios() {
		return nombreDomicilios;
	}

	public void setNombreDomicilios(ArrayList<String> nombreDomicilios) {
		this.nombreDomicilios = nombreDomicilios;
	}

}
