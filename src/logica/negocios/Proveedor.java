package logica.negocios;

import java.util.ArrayList;

/**
 * Represents Proveedor
 * 
 * @author Alumno Aitor
 * @version 1.0
 * @since 2020
 */
public class Proveedor {

	private int codigo;
	private ArrayList<String> casas;
	private ArrayList<Integer> precios;

	/**
	 * Represents Proveedor.
	 */
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a Proveedor.
	 * 
	 * @param codigo
	 *            The Proveedor's codigo.
	 * @param casas
	 *            The Proveedor's casas.
	 * @param precios
	 *            The Proveedor's precios.
	 */
	public Proveedor(int codigo, ArrayList<String> casas, ArrayList<Integer> precios) {
		super();
		this.codigo = codigo;
		this.casas = casas;
		this.precios = precios;
	}

	/**
	 * Gets the Proveedor's codigo.
	 * 
	 * @return A string representing the Proveedor's codigo.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Sets the Proveedor's codigo.
	 * 
	 * @param nombre
	 *            A string containing the Proveedor's codigo.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the Proveedor's casas.
	 * 
	 * @return A string representing the Proveedor's casas.
	 */
	public ArrayList<String> getCasas() {
		return casas;
	}

	/**
	 * Sets the Proveedor's casas.
	 * 
	 * @param nombre
	 *            A string containing the Proveedor's casas.
	 */
	public void setCasas(ArrayList<String> casas) {
		this.casas = casas;
	}

	/**
	 * Gets the Proveedor's precios.
	 * 
	 * @return A string representing the Proveedor's precios.
	 */
	public ArrayList<Integer> getPrecios() {
		return precios;
	}

	/**
	 * Sets the Proveedor's precios.
	 * 
	 * @param nombre
	 *            A string containing the Proveedor's precios.
	 */
	public void setPrecios(ArrayList<Integer> precios) {
		this.precios = precios;
	}

}
