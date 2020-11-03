package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.datos.AdministradorBaseDatos;
import logica.datos.CrearBaseDatos;
import logica.negocios.Administrador;
import logica.negocios.Cliente;
import logica.negocios.Comercial;
import logica.negocios.Factura;
import logica.negocios.Tasador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 * @author Aitor
 *
 */

public class PantallaInicial extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cliente> clientes;
	private ArrayList<Administrador> admin;
	private ArrayList<Factura> facturas;
	private ArrayList<Comercial> comerciales;
	private ArrayList <Tasador> tasadores;
	

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
	 * Create the frame pantalla inicial, en la que se le pide al usuario que en
	 * caso de ser un administrador pulse ese boton, y en el caso de ser un cliente,
	 * pulse el otro. Si pulsa el boton administrador le mostrara la pantalla login
	 * y en el caso de pulsar el boton cliente, le mostrara el menu cliente
	 */
	
	public PantallaInicial() {
		setResizable(false);
		
		CrearBaseDatos mydb = new CrearBaseDatos("Inmobiliaria.db");
		
		mydb.createLink();
		mydb.inicializarBD();

		admin = logica.datos.AdministradorBaseDatos.selectAllAdministrador(mydb.getConn());
		facturas = logica.datos.FacturaBaseDatos.selectAllFactura(mydb.getConn());
		comerciales = logica.datos.ComercialBaseDatos.selectAllComercial(mydb.getConn());
		tasadores = logica.datos.TasadorBaseDatos.selectAllTasador(mydb.getConn());
		clientes = logica.datos.ClienteBaseDatos.selectAllCliente(mydb.getConn());

		mydb.closeLink();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//ABRIMOS VENTANA LOGIN
			
				Login login = new Login(clientes, facturas, admin, comerciales,tasadores, PantallaInicial.this);
				login.setVisible(true);
				PantallaInicial.this.dispose();
			
			}
		});
		btnAdministrador.setBounds(74, 220, 180, 38);
		contentPane.add(btnAdministrador);
		
		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ABRIMOS VENTANA CLIENTE
				
				MenuCliente menuCliente = new MenuCliente(clientes, PantallaInicial.this);
				menuCliente.setVisible(true);
				PantallaInicial.this.dispose();
					
				
			}
		});
		btnCliente.setBounds(407, 222, 178, 34);
		contentPane.add(btnCliente);
		
		JLabel lblInmobiliariaMati = new JLabel("Inmobiliaria MATI");
		lblInmobiliariaMati.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblInmobiliariaMati.setForeground(Color.RED);
		lblInmobiliariaMati.setBounds(139, 52, 413, 75);
		contentPane.add(lblInmobiliariaMati);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//SALIMOS DE LA VENTANA 
				
				PantallaInicial.this.dispose();
			}
		});
		btnSalir.setBounds(277, 408, 115, 29);
		contentPane.add(btnSalir);
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon("imagenes/Villa1.jpg"));
//		lblNewLabel.setBounds(-83, -165, 1344, 794);
//		contentPane.add(lblNewLabel);
	}
}
