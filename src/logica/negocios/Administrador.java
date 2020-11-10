package logica.negocios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.rmi.CORBA.Util;

import interfaces.ICalcular;
import utilidades.Utilidades;

/**
 * Represents an Administrador
 * 
 * @author Alumno Aitor Matilla
 * @version 1.0
 * @since 2020
 */

public class Administrador extends Empleado implements ICalcular<Administrador> {

	private String usuario;
	private String contrasenya;

	/**
	 * Represents Administrador.
	 */
	public Administrador() {
		super();

	}

	/**
	 * Creates an Administrador.
	 * 
	 * @param Dni
	 *            The Administrador's Dni.
	 * @param sueldo
	 *            The Administrador's sueldo.
	 * @param horarioLaboral
	 *            The Administrador's horarioLaboral.
	 * @param usuario
	 *            The Administrador's usuario.
	 * @param contrasenya
	 *            The Administrador's contrasenya.
	 */

	public Administrador(String dni, int sueldo, int horarioLaboral, String usuario, String contrasenya) {
		super(dni, sueldo, horarioLaboral);
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}

	/**
	 * Gets the Administrador's usuario.
	 * 
	 * @return A string representing the Administrador's usuario.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Sets the Administrador's usuario.
	 * 
	 * @param usuario
	 *            A string containing the Administrador's usuario.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the Administrador's contrasenya.
	 * 
	 * @return A string representing the Administrador's contrasenya.
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * Sets the Administrador's contrasenya.
	 * 
	 * @param usuario
	 *            A string containing the Administrador's contrasenya.
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public ArrayList<Integer> calcular(ArrayList<Administrador> t) {
		// TODO Auto-generated method stub
		return null;
	}

}
