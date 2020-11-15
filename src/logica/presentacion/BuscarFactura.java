package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Factura;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class BuscarFactura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param nombreDomicilios
	 * @param numFac
	 * @param coste
	 * @param fecha
	 * @param menuAdministrador
	 * @param facturasBD
	 */
	public BuscarFactura(ArrayList<Factura> facturasBD, MenuAdministrador menuAdministrador, Date fecha, int coste,
			int numFac, ArrayList<String> nombreDomicilios) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("dd-MM-yyyy");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(140, 38, 115, 20);
		contentPane.add(label);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(271, 88, 115, 29);
		contentPane.add(btnOk);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(271, 175, 115, 29);
		contentPane.add(btnSalir);

		textField = new JTextField();
		textField.setBounds(109, 89, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("FECHA: ");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(15, 86, 78, 31);
		contentPane.add(label_1);
	}

}
