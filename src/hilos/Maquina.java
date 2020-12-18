package hilos;

import logica.negocios.Cliente;

import logica.negocios.Inmobiliaria;

/**
 * 
 * @author Aitor
 *
 */

public class Maquina extends Thread {

	private String nombre;

	/**
	 * Metodo que obtengo el nombre de la maqina
	 * 
	 * @return  nombre de la maquina 
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *  metodo  para poner el nombre de la maquina 
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *  metodo que pausa la maquina 
	 * 
	 * @param tiempo
	 *             tiempo que se quiere pausar
	 */
	private void pausar(long tiempo) {

		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException ex) {
			System.out.println("Error al pausar el hilo");
		}
	}

	/**
	 *   lo que hace la maquina cuando se ejecuta
	 */
	public void run() {

		while (Inmobiliaria.getInstancia().isEnServicio()) {

			Cliente clienteAtender = Inmobiliaria.getInstancia().pasarClienteAlCajero();

			if (clienteAtender == null) {

				System.out.println(this + " MAQUINA " + nombre + ": esperando usuarios");
				pausar(1000);
				continue;
			}

			System.out.println("MAQUINA " + nombre + ": atendiendo al usuario con" + "DNI " + clienteAtender.getDni());
			pausar(5000);
		}
	}

}
