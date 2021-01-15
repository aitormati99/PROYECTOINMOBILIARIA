package exception;

import java.awt.List;

/**
 * @author Aitor Creo este paquete para poder guardar las excepciones que me
 *         surjan, en este caso la excepcion de UsuarioNoExiste
 *
 */
public class UsuarioNoExiste extends Exception {

	public UsuarioNoExiste(String alerta) {
		super(alerta);

	}

}
