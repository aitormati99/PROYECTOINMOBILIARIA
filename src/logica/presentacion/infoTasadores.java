package logica.presentacion;


import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import utilidades.Calcular;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextPane;

import logica.negocios.Tasador;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class infoTasadores extends JFrame {

	
		private JPanel contentPane;
		private MenuAdministrador padre;

		/**
		 * Create the frame.
		 */
		public infoTasadores(ArrayList<Tasador> leido, MenuAdministrador papi) {
			setResizable(false);

			padre = papi;

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 517, 385);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblTasadores = new JLabel("Tasadores");
			lblTasadores.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblTasadores.setBounds(15, 16, 183, 48);
			contentPane.add(lblTasadores);

			JTextPane textPane = new JTextPane();
			textPane.setBounds(15, 66, 174, 141);
			// contentPane.add(textPane);

			// añadir contenido al textPane
			Tasador todos = new Tasador();
			ArrayList<Integer> infoTasadores = todos.calcular(leido);
			String mostrar = "La inmobiliaria tiene " + infoTasadores.get(0) + " tasadores \n" + "y gasta "
					+ infoTasadores.get(1) + "€ en ellos";
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
					infoTasadores.this.dispose();
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

					infoTasadores.this.dispose();

				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnSalir.setBounds(27, 284, 115, 29);
			contentPane.add(btnSalir);

			

		}
	}


