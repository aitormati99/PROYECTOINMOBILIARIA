package utilidades;

import java.util.ArrayList;

import logica.negocios.Empleado;

public class Calcular<T extends Empleado> {

	public ArrayList<Integer> calcular(ArrayList<T> solicitado) {

		

		ArrayList<Integer> informacionTotal = new ArrayList<Integer>();
		int totalEmpleados = (int) solicitado.stream().count();
		int sueldoTotal = 0;

		for (T a : solicitado) {

			sueldoTotal += a.getSueldo();
		}

		//  expresiones lambda sumo los sueldos.

		informacionTotal.add(totalEmpleados);
		informacionTotal.add(sueldoTotal);

		return informacionTotal;
	}

}
