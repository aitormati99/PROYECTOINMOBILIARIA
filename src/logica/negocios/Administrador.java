package logica.negocios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.rmi.CORBA.Util;

import logica.presentacion.Utilidades;



/**Represents an Administrador 
 * @author Alumno Aitor Matilla
 * @version 1.0
 * @since 2020
 */

public class Administrador extends Empleado {

	private String usuario;
	private String contrasenya;
	
	/**
	 * Represents Administrador.
	 */
	public Administrador() {
		super();
		
	}
	/**Creates an Administrador.
	 *@param Dni The Administrador's Dni.
	 *@param dni The Administrador's dni.
	 *@param sueldo The Administrador's sueldo.
	 *@param horarioLaboral The Administrador's horarioLaboral.
	 *@param usuario The Administrador's usuario.
	 *@param contrasenya The Administrador's contrasenya.
	 */

	public Administrador(String Dni, String dni, int sueldo, int horarioLaboral,String usuario, String contrasenya) {
		super(Dni, dni, sueldo, horarioLaboral);
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}
	
	public static void darAltaTasador(ArrayList<Tasador> listaTasador) {

		ArrayList<String> casas = new ArrayList<String>();
		String nombre;
		String dni;
		int sueldo;
		int horarioLaboral;
		String ans;
		boolean corbata = false;
		int contadorFacturas = 0;


		System.out.println("Introduzca los datos del nuevo Tasador:");
		System.out.println("Dni:");

		boolean comprobar = true;
		do {

			dni = Utilidades.leerCadena();

			for (Tasador a : listaTasador) {

				if (dni.equals(a.getDni())) {
					comprobar = false;
				}
			}

			if (comprobar == false) {
				System.out.println("ERROR! Ese Dni ya existe,introduce otro Dni:");
			}
		} while (comprobar == false);

		System.out.println("Corbata Si/No:");

		ans = Utilidades.leerCadena().toUpperCase();
		if (ans.equals("SI")) {
			corbata = true;
		} else if (ans.equals("NO")) {

			corbata = false;
		}

		System.out.println("nombre");
		nombre = Utilidades.leerCadena();
		
		
		System.out.println("SUELDO");
		sueldo = Utilidades.leerEntero();

		System.out.println("HORARIO LABORAL");
		horarioLaboral = Utilidades.leerEntero();

		Tasador nuevo = new Tasador(nombre, dni, sueldo, horarioLaboral, contadorFacturas, corbata);
		listaTasador.add(nuevo);

	}

	public static void darBajaTasador(ArrayList<Tasador> listaTasador) {

		boolean fase = false;
		Tasador tasadorEliminar = null;

		System.out.println("Introduce el Dni del tasador que quieras dar de baja:");
		do {

			String Dni = Utilidades.leerCadena();

			for (Tasador a :  listaTasador) {

				if (Dni.equals(a.getDni())) {

					tasadorEliminar = a;
					listaTasador.remove(tasadorEliminar);
					fase = true;
					break;

				}

			}

			if (fase == false) {

				System.out.println("ERROR!Introduce un Dni que exista:");

			}

		} while (fase == false);

	}

	public static void modificarTasador(ArrayList<Tasador> listaTasador) {

		boolean fase = false;
		String nuevoDni;
		
		

		do {
			System.out.println("Introduce en DNI de la persona que quieras modificar: ");
			String Dni = Utilidades.leerCadena();
			for (Tasador a : listaTasador) {

				if (Dni.equals(a.getDni())) {

					fase = true;


					System.out.println("Nuevo DNI");
					nuevoDni = Utilidades.leerCadena();
					a.setDni(nuevoDni);
					

					System.out.println("Nuevo nombre");
					a.setNombre(Utilidades.leerCadena());
					

					System.out.println("Nuevo sueldo:");
					a.setSueldo(Utilidades.leerEntero());

					System.out.println("Nuevo horario:");
					a.setHorarioLaboral(Utilidades.leerEntero());

					boolean mas = true;

				}

			}

			if (fase == false) {

				System.out.println("ERROR!Introduce un Dni que exista:");

			}

		} while (fase == false);

	}

	public static void darAltaComercial(ArrayList<Comercial> listaComercial) {

		ArrayList<String> clientes = new ArrayList<String>();

		String nombre;
		String Dni;
		int sueldo;
		int horasLaboral;

		System.out.println("Introduzca los datos del nuevo Comercial:");
		System.out.println("DNI:");

		boolean comprobar = true;
		do {

			Dni = Utilidades.leerCadena();

			for (Comercial a : listaComercial) {

				if (Dni.equals(a.getDni())) {
					comprobar = false;
				}
			}

			if (comprobar == false) {
				System.out.println("ERROR! Ese DNI ya existe,introduce otro DNI:");
			}
		} while (comprobar == false);

		System.out.println("NOMBRE");
		nombre=Utilidades.leerCadena();
		
		System.out.println("SUELDO");
		sueldo = Utilidades.leerEntero();

		System.out.println("HORARIO LABORAL");
		horasLaboral = Utilidades.leerEntero();

		Comercial nuevo = new Comercial(nombre, Dni, sueldo, horasLaboral, clientes);
		listaComercial.add(nuevo);

	}

	public static void bajaComercial(ArrayList<Comercial> listaComercial) {

		boolean fase = false;
		Comercial comercialEliminar = null;

		System.out.println("Introduce en DNI del comercial que quieras dar de baja:");
		do {

			String Dni = Utilidades.leerCadena();

			for (Comercial a : listaComercial) {

				if (Dni.equals(a.getDni())) {

					comercialEliminar = a;
					listaComercial.remove(comercialEliminar);
					fase = true;
					break;

				}

			}

			if (fase == false) {

				System.out.println("ERROR!Introduce un DNI que exista:");

			}

		} while (fase == false);

	}

	public static void modificarComercial(ArrayList<Comercial> listaComercial) {

		boolean fase = false;
		String nuevoDni;
	

		do {
			System.out.println("Introduce en DNI del comercial que quieras modificar: ");
			String Dni = Utilidades.leerCadena();
			for (Comercial a : listaComercial) {

				if (Dni.equals(a.getDni())) {

					fase = true;

					
					System.out.println("Nuevo DNI");
					nuevoDni = Utilidades.leerCadena();
					a.setDni(nuevoDni);

					
					
					System.out.println("Nuevo nombre");
					a.setNombre(Utilidades.leerCadena());
					
					System.out.println("Nuevo sueldo:");
					a.setSueldo(Utilidades.leerEntero());

					System.out.println("Nuevo horarioLaboral:");
					a.setHorarioLaboral(Utilidades.leerEntero());


				}

			}

			if (fase == false) {

				System.out.println("ERROR!Introduce un Dni que exista:");

			}

		} while (fase == false);

	
	}
	
	/**Gets the Administrador's usuario.
	 * @return A string representing the Administrador's usuario.
	 */
	public String getUsuario() {
		return usuario;
	}
	/** Sets the Administrador's usuario.
	 * @param usuario A string containing the Administrador's usuario.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**Gets the Administrador's contrasenya.
	 * @return A string representing the Administrador's contrasenya.
	 */
	public String getContrasenya() {
		return contrasenya;
	}
	/** Sets the Administrador's contrasenya.
	 * @param usuario A string containing the Administrador's contrasenya.
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	

	
	
	
}
