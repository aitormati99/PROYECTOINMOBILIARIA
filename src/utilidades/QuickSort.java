package utilidades;

import java.util.List;

// He hecho uso de quicksort no se si se utiliza de forma eficiente

public class QuickSort {

	public static void QuickSort(List<Integer> a, int inicio, int fin) {

		// base case

		if (fin <= inicio || inicio >= fin) {


		}

		else {

			int pivot = a.get(inicio); //  primer elemento como pivote

			int ini = inicio + 1; // primer elemento del array quito el
									// pivote

			int aux;

			// partition array

			for (int j = ini; j <= fin; j++) {

				if (pivot > a.get(j)) {

					// los intercambio

					aux = a.get(j);

					a.set(j, a.get(ini));

					a.set(ini, a.get(j));

					ini++; // llega a tamaño del array

				}

			}


			a.set(inicio, a.get(ini - 1)); //  pivote a la ultima
											// posicion

			a.set(ini - 1, pivot); //

			// llama a la funcion del quicksort en el lado izquierdo y derecho
			// del pivote

			QuickSort(a, inicio, ini - 2);

			QuickSort(a, ini, fin);

		}

	}

}
