package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.UsuarioNoExiste;
import logica.negocios.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusquedaClienteDomicilio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private Cliente elegido = new Cliente();
	private static ArrayList<String> domicilios = new ArrayList<>();
	private MenuAdministrador papi;

	public ArrayList<Cliente> getClientes() {
		return clientes;

	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * Create the frame.
	 * 
	 * @param clientesBD
	 * @param menuAdministrador
	 */
	public BusquedaClienteDomicilio(MenuAdministrador padre, ArrayList<Cliente> clientes) {

		this.clientes = clientes;
		this.papi = padre;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("BUSQUEDA CLIENTE");
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setBounds(197, 49, 338, 26);
		contentPane.add(label);

		JLabel label_1 = new JLabel("DNI:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_1.setBounds(58, 182, 72, 20);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(163, 182, 318, 26);
		contentPane.add(textField);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String dni = textField.getText();
				ArrayList<String> domicilios = new ArrayList<String>();
				try {
					boolean encontrado = comprobarCliente(dni);
					domicilios = elegido.getNombreDomicilios();

					// abrir otra ventana mostrando la info
					String contenido = "";
					for (int i = 0; i < domicilios.size(); i++) {

						contenido += "- " + domicilios.get(i) + " ";

					}
					BusquedaClienteDomicilio.this.dispose();
					VisualizaciondelCliente nueva = new VisualizaciondelCliente(dni, contenido, papi, 1);
					nueva.setVisible(true);

				} catch (UsuarioNoExiste z) {

					JOptionPane.showMessageDialog(BusquedaClienteDomicilio.this, z.getMessage());
				}

			}
		});
		btnOk.setBounds(163, 354, 115, 29);
		contentPane.add(btnOk);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				papi.setVisible(true);
				BusquedaClienteDomicilio.this.dispose();

			}
		});
		btnAtras.setBounds(366, 354, 115, 29);
		contentPane.add(btnAtras);
	}

	

	/**
	 * compruebo si existe o no el dni que ha introducido para hacer la busqueda
	 * 
	 * @param dni
	 *            dni del ciente
	 * @return false si no existe, true si existe
	 * @throws UsuarioNoExiste
	 *             clase que se implementa la excepcion del usuario no existente
	 */
	public boolean comprobarCliente(String dni) throws UsuarioNoExiste {

		boolean existe = false;

		for (Cliente a : clientes) {

			if (a.getDni().equals(dni)) {
				existe = true;
				elegido = a;
				break;

			}

		}

		if (existe == true) {

			return true;

		} else {

			throw new UsuarioNoExiste("DNI no existe");

		}

	}

	/**
	 * Este metodo sirve para ordenar de menor a mayor el arraylist de los
	 * domicilios de los clientes
	 * 
	 * 
	 * @param input
	 *            un arraylist del numero de veces que las compra
	 * @param domicilios
	 *            un arraylist de los domicilios de los clientes
	 * @return devuelve el arraylist del numero de veces ordenado
	 */

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> input, ArrayList<String> domicilios) {
		// TODO Auto-generated method stub
		
		if (input.size() == 1) {
			return input;
		} else {
			int a = input.size() / 2;
			ArrayList<Integer> left = new ArrayList<Integer>(a);
			ArrayList<Integer> right = new ArrayList<Integer>(input.size() - a);
			ArrayList<String> leftP = new ArrayList<String>(a);
			ArrayList<String> rightP = new ArrayList<String>(input.size() - a);

			for (int i = 0; i < a; i++) {
				left.add(input.get(i));
				leftP.add(domicilios.get(i));
			}

			for (int i = a; i < input.size(); i++) {
				right.add(input.get(i));
				rightP.add(domicilios.get(i));
			}

			left = mergeSort(left, leftP);
			right = mergeSort(right, rightP);
			return merge(left, right, leftP, rightP);

		}

	}
	
	/**
	 * ordenar de menor a mayor el arraylist de los
	 * domicilios de los clientes 
	 * 
	 * @param left
	 *            es la parte izquierda del arraylist del numero de veces de los
	 *            clientes
	 * @param right
	 *            es la parte derecha del arraylist del numero de veces de los
	 *            clientes
	 * @param leftP
	 *            es la parte izquierda del arraylist de los domicilios de los
	 *            clientes
	 * @param rightP
	 *            es la parte derecha del arraylist del numero de veces de los
	 *            clientes
	 * @return devuelve el arraylist del numero de veces ordenado
	 */
	
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<String> leftP,
			ArrayList<String> rightP) {

		ArrayList<Integer> auxiliar = new ArrayList<>();
		ArrayList<String> auxDomicilios = new ArrayList<>();

		while (!left.isEmpty() && !right.isEmpty()) {

			if (left.get(0) > right.get(0)) {
				auxiliar.add(right.get(0));
				right.remove(0);
				auxDomicilios.add(rightP.get(0));
				rightP.remove(0);
			} else {
				auxiliar.add(left.get(0));
				left.remove(0);
				auxDomicilios.add(leftP.get(0));
				leftP.remove(0);
			}

		}

		while (!left.isEmpty()) {

			auxiliar.add(left.get(0));
			left.remove(0);
			auxDomicilios.add(leftP.get(0));
			leftP.remove(0);
		}
		while (!right.isEmpty()) {

			auxiliar.add(right.get(0));
			right.remove(0);
			auxDomicilios.add(rightP.get(0));
			rightP.remove(0);
		}

		domicilios = auxDomicilios;
		return auxiliar;

	}
}
