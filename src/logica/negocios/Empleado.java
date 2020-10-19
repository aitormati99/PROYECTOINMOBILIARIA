package logica.negocios;
/** Represents Empleado
 * @author Alumno Aitor Matilla
 * @version 1.0
 * @since 2020
 */
public abstract class Empleado {

	private String nombre;
	private String dni;
	private int sueldo;
	private int horarioLaboral;
	
	/**
	 * Represents Empleado.
	 */
	public Empleado() {
		super();
		
	}
	/**Creates a Empleado.
	 *@param nombre The Empleado's nombre.
	 *@param dni The Empleado's  dni.
	 *@param sueldo The Empleado's  sueldo.
	 *@param horarioLaboral The Empleado's  horarioLaboral.
	 */
	public Empleado(String nombre, String dni, int sueldo, int horarioLaboral) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sueldo = sueldo;
		this.horarioLaboral = horarioLaboral;
	}
	/**Gets the Empleado's nombre.
	 * @return A string representing the Empleado's nombre.
	 */
	public String getNombre() {
		return nombre;
	}
	/** Sets the Empleado's nombre.
	 * @param nombre A string containing the Empleado's nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**Gets the Empleado's dni.
	 * @return A string representing the Empleado's dni.
	 */
	public String getDni() {
		return dni;
	}
	/** Sets the Empleado's dni.
	 * @param nombre A string containing the Empleado's dni.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**Gets the Empleado's suedo.
	 * @return A string representing the Empleado's sueldo.
	 */
	public int getSueldo() {
		return sueldo;
	}
	/** Sets the Empleado's sueldo.
	 * @param nombre A string containing the Empleado's sueldo.
	 */
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	/**Gets the Empleado's horarioLaboral .
	 * @return A string representing the Empleado's horarioLaboral.
	 */
	public int getHorarioLaboral() {
		return horarioLaboral;
	}
	/** Sets the Empleado's horarioLaboral.
	 * @param nombre A string containing the Empleado's horarioLaboral.
	 */
	public void setHorarioLaboral(int horarioLaboral) {
		this.horarioLaboral = horarioLaboral;
	}


	
	
	
}
