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
public interface ICalcularCosas<T extends Empleado> {

	/**
	 * este metodo sirve para calcular el numero de comerciales
	 * 
	 * @param t
	 *            es un array de distintos tipos
	 * @return array con los datos que queremos
	 */
	public abstract ArrayList<Integer> calcular(ArrayList<T> t);

}
