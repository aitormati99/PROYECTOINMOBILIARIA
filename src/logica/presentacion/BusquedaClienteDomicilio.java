package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BusquedaClienteDomicilio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 * 
	 * @param clientesBD
	 * @param menuAdministrador
	 */
	public BusquedaClienteDomicilio(MenuAdministrador menuAdministrador, ArrayList<Cliente> clientesBD) {
		setResizable(false);
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
		btnOk.setBounds(163, 354, 115, 29);
		contentPane.add(btnOk);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(366, 354, 115, 29);
		contentPane.add(btnAtras);
	}
}
