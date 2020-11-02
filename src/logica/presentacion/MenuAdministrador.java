package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Administrador;
import logica.negocios.Cliente;
import logica.negocios.Comercial;
import logica.negocios.Factura;
import logica.negocios.Tasador;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;

public class MenuAdministrador extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 * @param padre 
	 * @param tasadores 
	 * @param comerciales 
	 * @param admin 
	 * @param facturas 
	 * @param clientes 
	 * @param password 
	 * @param usuario 
	 */
	public MenuAdministrador(String usuario, String password, ArrayList<Cliente> clientes, ArrayList<Factura> facturas, ArrayList<Administrador> admin, ArrayList<Comercial> comerciales, ArrayList<Tasador> tasadores, PantallaInicial padre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblBienvenido.setBounds(171, 37, 139, 38);
		contentPane.add(lblBienvenido);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(449, 119, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(449, 278, 115, 29);
		contentPane.add(btnSalir);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(80, 119, 312, 29);
		contentPane.add(comboBox);
		
		JList list_1 = new JList();
		list_1.setBounds(95, 173, 286, 221);
		contentPane.add(list_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 171, 288, 223);
		contentPane.add(scrollPane);
	}
}
