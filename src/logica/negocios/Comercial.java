package logica.negocios;

import java.util.ArrayList;

import interfaces.ICalcular;

/**
 * Represents a Comercial.
 * 
 * @author Alumno Aitor Matilla
 * @version 1.0
 * @since 2020
 */
public class Comercial extends Empleado implements ICalcular<Comercial> {

	private ArrayList<String> clientes;

	/**
	 * Represents Comercial.
	 */
	public Comercial() {
		super();

	}

	/**
	 * Creates a Comercial.
	 * 
	 * @param nombre
	 *            The Comercial's nombre.
	 * @param dni
	 *            The Comercial's dni.
	 * @param sueldo
	 *            The Comercial's sueldo.
	 * @param horarioLaboral
	 *            The Comercial's horarioLaboral.
	 * @param clientes
	 *            The Comercial's clientes.
	 */
	public Comercial(String dni, int sueldo, int horarioLaboral, ArrayList<String> clientes) {
		super(dni, sueldo, horarioLaboral);
		this.clientes = clientes;
	}

	/**
	 * Gets the Comercial's clientes.
	 * 
	 * @return A string representing the Comercial's clientes.
	 */
	public ArrayList<String> getClientes() {
		return clientes;
	}

	/**
	 * Sets the Comercial's clientes.
	 * 
	 * @param nombre
	 *            A string containing the Comercial's clientes.
	 */
	public void setClientes(ArrayList<String> clientes) {
		this.clientes = clientes;
	}

	@Override
	public ArrayList<Integer> calcular(ArrayList<Comercial> t) {
		// TODO Auto-generated method stub
		return null;
	}

}
