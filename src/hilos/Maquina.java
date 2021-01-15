package hilos;

import logica.negocios.Cliente;

import logica.negocios.Inmobiliaria;

/**
 * 
 * @author Aitor Aqui hago uso de los hilos aprendidos en clase de la manera que
 *         extiendo del thread
 */

public class Maquina extends Thread {

	private String nombre;

	/**
	 * Metodo que obtiene el nombre de la maqina
	 * 
	 * @return nombre de la maquina
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para poner el nombre de la maquina
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * metodo que pausa la maquina
	 * 
	 * @param tiempo
	 *            tiempo que quiero pausar
	 */
	private void pausar(long tiempo) {

		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException ex) {
			System.out.println("Fallo al parar el hilo");
		}
	}

	/**
	 * lo que hace la maquina cuando se ejecuta
	 */
	public void run() {

		while (Inmobiliaria.getInstancia().isOn()) {

			Cliente atendiendo = Inmobiliaria.getInstancia().atenderCliente();

			if (atendiendo == null) {

				System.out.println(this + " MAQUINA " + nombre + ": esperando compradores");
				pausar(1000);
				continue;
			}

			System.out.println("MAQUINA " + nombre + ": atendiendo al comprador con" + "DNI " + atendiendo.getDni());
			pausar(5000);
		}
	}

}
