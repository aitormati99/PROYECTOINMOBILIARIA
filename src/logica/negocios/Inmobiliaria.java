package logica.negocios;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * esta clase es la inmobiliaria
 * 
 * @author  AITOR
 *
 */
public class Inmobiliaria {

	private static Inmobiliaria instancia;
	private ConcurrentLinkedQueue<Cliente> clientes;

	// Indica si la maquina esta ocupada o no
	private boolean enServicio;

	private Inmobiliaria() {

		clientes = new ConcurrentLinkedQueue<>();
	}

	/**
	 * este metodo sirve para obtener la instancia de la inmobiliaria
	 * 
	 * @return
	 */
	public static Inmobiliaria getInstancia() {

		if (instancia == null) {
			instancia = new Inmobiliaria();
		}

		return instancia;
	}

	/**
	 * este metodo sirve para obtener si esta en servicio o no
	 * 
	 * @return en caso de que este en servicio enviara un true y sino un false
	 */
	public boolean isEnServicio() {
		return enServicio;
	}

	/**
	 * este metodo sirve para establecer el servicio
	 * 
	 * @param enServicio
	 *            un true si esta en servicio y false si no
	 */
	public void setEnServicio(boolean enServicio) {
		this.enServicio = enServicio;
	}

	/**
	 * este metodo sirve para pasar clientes al cajero
	 * 
	 * @return devuelve un cliente
	 */
	public Cliente pasarClienteAlCajero() {

		Cliente usuario = null;

		try {
			System.out.println("La longitud de la fila es de: " + clientes.size() + " clientes");
			usuario = clientes.remove();
		} catch (NoSuchElementException e) {
			System.out.println("La fila se encuentra vacia");
		}

		return usuario;

	}

	/**
	 * este metodod sirve para agregar clientes a la fila
	 * 
	 * @param cliente
	 *            cliente que llega a la fila
	 */
	public void agregarClienteFila(Cliente cliente) {

		System.out.println("Ha llegado un cliente a la pizzeria");
		clientes.add(cliente);
	}

}
