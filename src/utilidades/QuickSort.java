package utilidades;

import java.util.List;

// He hecho  quicksort no se si se utiliza de forma muy eficiente la verdad

public class QuickSort {

	public static void QuickSort(List<Integer> a, int inicio, int fin) {

		// base case

		if (fin <= inicio || inicio >= fin) {


		}

		else {

		//  primer elemento como pivote
			
			int pivot = a.get(inicio); 

			// primer elemento del array quito el pivote
		
			
			int ini = inicio + 1; 

			int aux;

			// partition array

			for (int j = ini; j <= fin; j++) {

				if (pivot > a.get(j)) {

					// los intercambio

					aux = a.get(j);

					a.set(j, a.get(ini));

					a.set(ini, a.get(j));
					
					// llega a tamaño del array

					ini++; 

				}

			}

		//  pivote a la ultima posicion

			a.set(inicio, a.get(ini - 1)); 

			a.set(ini - 1, pivot); //

			// llama a la funcion del quicksort en el lado izquierdo y derecho  del pivote

			QuickSort(a, inicio, ini - 2);

			QuickSort(a, ini, fin);

		}

	}

}
