package hilos;

import logica.negocios.Cliente;
import logica.negocios.Inmobiliaria;

/**
 * 
 * @author Aitor
 *
 */
public class Proveedor extends Thread {

	@Override
	/**
	 * lo que hace el proveedor cuando se ejecute
	 */
	public void run() {

		while (Inmobiliaria.getInstancia().isOn()) {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				System.out.println("Fallo al parar el hilo");
			}

			Cliente compradorEntrandoInmo = new Cliente();
			compradorEntrandoInmo.setDni(crearDni());

			System.out.println(
					"El comprador con DNI: " + compradorEntrandoInmo.getDni() + " esta entrando a la inmobiliaria");

			Inmobiliaria.getInstancia().agregarClienteFila(compradorEntrandoInmo);

		}
	}

	/**
	 * creo dnis aleatoriamente
	 * 
	 * @return dni
	 */
	public String crearDni() {
		char[] caracteres = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] agrupacion = new char[8];

		for (int i = 0; i < 8; i++) {

			if (i < 7) {
				int a1 = (int) (Math.random() * 10);
				agrupacion[i] = (char) num[a1];

			} else {
				int a2 = (int) (Math.random() * 27);
				agrupacion[i] = (char) caracteres[a2];
			}

		}
		String dni = new String(agrupacion);
		return dni;
	}
}
