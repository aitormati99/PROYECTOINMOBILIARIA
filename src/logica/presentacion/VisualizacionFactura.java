package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Factura;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextPane;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

public class VisualizacionFactura extends JFrame {

	private JPanel contentPane;
 
	/**
	 * Create the frame.
	 * @param seleccion 
	 * @param fecha 
	 * @param buscarFactura 
	 */
	public VisualizacionFactura(BuscarFactura buscarFactura, String fecha, ArrayList<Factura> seleccion) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(27, 152, 421, 222);
		contentPane.add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblComerciales = new JLabel("COMERCIALES:");
		lblComerciales.setForeground(Color.BLACK);
		lblComerciales.setFont(new Font("Dialog", Font.BOLD, 24));
		lblComerciales.setBounds(59, 16, 258, 57);
		contentPane.add(lblComerciales);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(462, 384, 115, 29);
		contentPane.add(btnSalir);
	}

}
