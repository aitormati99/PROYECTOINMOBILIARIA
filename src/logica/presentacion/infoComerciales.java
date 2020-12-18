package logica.presentacion;


import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import utilidades.CalculatorGenerico;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextPane;

import logica.negocios.Comercial;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class infoComerciales extends JFrame {

	
		private JPanel contentPane;
		private MenuAdministrador padre;

		/**
		 * Create the frame.
		 */
		public infoComerciales(ArrayList<Comercial> leido, MenuAdministrador papi) {
			setResizable(false);

			padre = papi;

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 517, 385);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblComerciales = new JLabel("COMERCIALES");
			lblComerciales.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblComerciales.setBounds(15, 16, 183, 48);
			contentPane.add(lblComerciales);

			JTextPane textPane = new JTextPane();
			textPane.setBounds(15, 66, 174, 141);
			// contentPane.add(textPane);

			// añadir contenido al textPane
			Comercial todos = new Comercial();
			ArrayList<Integer> infoComerciales = todos.calcular(leido);
			String mostrar = "La inmobiliaria tiene " + infoComerciales.get(0) + " comerciales \n" + "y gasta "
					+ infoComerciales.get(1) + "€ en ellos";
			textPane.setText(mostrar);

			// PONER EL SCROLLPANE EN UN JLIST
			JScrollPane scroll = new JScrollPane();
			scroll.setViewportView(textPane);
			scroll.setBounds(15, 66, 174, 141);
			contentPane.add(scroll);

			JButton btnAtras = new JButton("ATRAS");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// ACCION ATRAS
					infoComerciales.this.dispose();
					padre.setVisible(true);
				}
			});
			btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnAtras.setBounds(365, 284, 115, 29);
			contentPane.add(btnAtras);

			JButton btnSalir = new JButton("SALIR");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// aCCION SALIR

					infoComerciales.this.dispose();

				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnSalir.setBounds(27, 284, 115, 29);
			contentPane.add(btnSalir);

			

		}
	}


