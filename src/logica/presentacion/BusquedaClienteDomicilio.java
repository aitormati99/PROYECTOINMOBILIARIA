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
import javax.swing.ImageIcon;
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

						contenido += "- " + domicilios.get(i) + " " ;

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

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> input, ArrayList<String> domicilios) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean comprobarCliente(String dni) throws UsuarioNoExiste {

		boolean existencia = false;

		for (Cliente a : clientes) {

			if (a.getDni().equals(dni)) {
				existencia = true;
				elegido = a;
				break;

			}

		}

		if (existencia == true) {

			return true;

		} else {

			throw new UsuarioNoExiste("DNI no Existente");

		}

	}
	
	/**
	 * Este metodo sirve para ordenar de menor a mayor el arraylist de los
	 * domicilios de los clientes 
	 */
	
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<String> leftP,
			ArrayList<String> rightP) {

		ArrayList<Integer> aux = new ArrayList<>();
		ArrayList<String> auxDomicilios = new ArrayList<>();

		while (!left.isEmpty() && !right.isEmpty()) {

			if (left.get(0) > right.get(0)) {
				aux.add(right.get(0));
				right.remove(0);
				auxDomicilios.add(rightP.get(0));
				rightP.remove(0);
			} else {
				aux.add(left.get(0));
				left.remove(0);
				auxDomicilios.add(leftP.get(0));
				leftP.remove(0);
			}

		}

		while (!left.isEmpty()) {

			aux.add(left.get(0));
			left.remove(0);
			auxDomicilios.add(leftP.get(0));
			leftP.remove(0);
		}
		while (!right.isEmpty()) {

			aux.add(right.get(0));
			right.remove(0);
			auxDomicilios.add(rightP.get(0));
			rightP.remove(0);
		}

		domicilios = auxDomicilios;
		return aux;

	}
}
