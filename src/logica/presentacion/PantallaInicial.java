package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class PantallaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicial frame = new PantallaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.setBounds(46, 112, 144, 29);
		contentPane.add(btnAdministrador);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBounds(253, 112, 115, 29);
		contentPane.add(btnCliente);
		
		JLabel lblInmobiliariaMati = new JLabel("Inmobiliaria MATI");
		lblInmobiliariaMati.setForeground(Color.RED);
		lblInmobiliariaMati.setBounds(148, 16, 150, 20);
		contentPane.add(lblInmobiliariaMati);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(161, 199, 115, 29);
		contentPane.add(btnSalir);
	}
}
