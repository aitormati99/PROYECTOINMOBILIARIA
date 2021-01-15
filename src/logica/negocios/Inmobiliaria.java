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

	// si la maquina esta ocupada o no
	private boolean On;

	private Inmobiliaria() {

		clientes = new ConcurrentLinkedQueue<>();
	}

	/**
	 * obtener la instancia de la inmobiliaria
	 * 
	 * @return instancia
	 */
	public static Inmobiliaria getInstancia() {

		if (instancia == null) {
			instancia = new Inmobiliaria();
		}

		return instancia;
	}

	/**
	 * si esta en servicio o no
	 * 
	 * @return si esta en servicio envia true y sino un false
	 */
	public boolean isOn() {
		return On;
	}

	/**
	 * dar el servicio
	 * 
	 * @param enServicio
	 *            un true si esta en servicio y false si no
	 */
	public void setEnServicio(boolean enServicio) {
		this.On = On;
	}

	/**
	 * este metodo sirve para pasar clientes al cajero
	 * 
	 * @return devuelve un cliente
	 */
	public Cliente atenderCliente() {

		Cliente usuario = null;

		try {
			System.out.println("El tamaño de la fila es de: " + clientes.size() + " clientes");
			usuario = clientes.remove();
		} catch (NoSuchElementException e) {
			System.out.println("La fila está vacia");
		}

		return usuario;

	}

	/**
	 * añadir clientes a la fila
	 * 
	 * @param cliente
	 *            nuevo cliente que llega a la fila
	 */
	public void agregarClienteFila(Cliente cliente) {

		System.out.println("Ha llegado un cliente a la inmobiliaria");
		clientes.add(cliente);
	}

}
