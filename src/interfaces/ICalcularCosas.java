package interfaces;

import java.util.ArrayList;

import logica.negocios.Empleado;

/**
 * 
 * @author Aitor
 *
 * @param <T>
 *            (genericos) tipo de dato que se la pasa
 */
public interface ICalcularCosas <T extends Empleado> {

	/**
	 * este metodo sirve para calcular el numero de comerciales y el coste
	 * 
	 * @param t
	 *            array de diferentes tipos
	 * @return array con los datos deseados
	 */
	public abstract ArrayList<Integer> calcular(ArrayList<T> t);

}
