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

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuCliente extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 * @param papi 
	 * @param clientes 
	 */
	public MenuCliente(ArrayList<Cliente> clientes, PantallaInicial papi) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDomicilios = new JLabel("DOMICILIOS");
		lblDomicilios.setFont(new Font("Verdana", Font.BOLD, 29));
		lblDomicilios.setBounds(345, 59, 209, 43);
		contentPane.add(lblDomicilios);
		
		JLabel lblVilla = new JLabel("VILLA 1");
		lblVilla.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVilla.setBounds(122, 174, 139, 20);
		contentPane.add(lblVilla);
		
		JLabel lblVilla_1 = new JLabel("VILLA 2");
		lblVilla_1.setIcon(new ImageIcon("imagenes/villa1.jpg"));
		lblVilla_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVilla_1.setBounds(117, 317, 139, 25);
		contentPane.add(lblVilla_1);
		
		JLabel lblVilla_2 = new JLabel("VILLA 3");
		lblVilla_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVilla_2.setBounds(119, 449, 108, 20);
		contentPane.add(lblVilla_2);
		
		JLabel lblVilla_3 = new JLabel("VILLA 4");
		lblVilla_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVilla_3.setBounds(628, 178, 108, 20);
		contentPane.add(lblVilla_3);
		
		JLabel lblVilla_4 = new JLabel("VILLA 5");
		lblVilla_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVilla_4.setBounds(628, 323, 108, 25);
		contentPane.add(lblVilla_4);
		
		JLabel lblVilla_5 = new JLabel("VILLA 6");
		lblVilla_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVilla_5.setBounds(629, 453, 108, 25);
		contentPane.add(lblVilla_5);
		
		JLabel label = new JLabel("1.000.000");
		label.setBounds(122, 235, 102, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("1.900.000");
		label_1.setBounds(119, 376, 102, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("870.000");
		label_2.setBounds(126, 518, 102, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("1.500.000");
		label_3.setBounds(623, 236, 102, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("2.500.000");
		label_4.setBounds(631, 383, 102, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("400.000");
		label_5.setBounds(626, 515, 102, 20);
		contentPane.add(label_5);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(271, 601, 115, 29);
		contentPane.add(btnCancelar);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setBounds(512, 601, 115, 29);
		contentPane.add(btnComprar);
		
		JButton btnAadir = new JButton("A\u00D1ADIR");
		btnAadir.setBounds(224, 200, 115, 29);
		contentPane.add(btnAadir);
		
		JButton btnAadiir = new JButton("A\u00D1ADIIR");
		btnAadiir.setBounds(224, 344, 115, 29);
		contentPane.add(btnAadiir);
		
		JButton btnAadir_1 = new JButton("A\u00D1ADIR");
		btnAadir_1.setBounds(224, 494, 115, 29);
		contentPane.add(btnAadir_1);
		
		JButton btnAadir_2 = new JButton("A\u00D1ADIR");
		btnAadir_2.setBounds(716, 200, 115, 29);
		contentPane.add(btnAadir_2);
		
		JButton btnAadir_3 = new JButton("A\u00D1ADIR");
		btnAadir_3.setBounds(716, 494, 115, 29);
		contentPane.add(btnAadir_3);
		
		JButton btnAadir_4 = new JButton("A\u00D1ADIR");
		btnAadir_4.setBounds(716, 344, 115, 29);
		contentPane.add(btnAadir_4);
		
		JLabel label_6 = new JLabel("\u20AC");
		label_6.setBounds(202, 235, 25, 20);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u20AC");
		label_7.setBounds(202, 376, 25, 20);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u20AC");
		label_8.setBounds(202, 518, 25, 20);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u20AC");
		label_9.setBounds(701, 235, 25, 20);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u20AC");
		label_10.setBounds(711, 383, 25, 20);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("\u20AC");
		label_11.setBounds(687, 515, 25, 20);
		contentPane.add(label_11);
	}

}
