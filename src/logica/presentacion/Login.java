package logica.presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.UsuarioNoExiste;
import logica.negocios.Administrador;
import logica.negocios.Cliente;
import logica.negocios.Comercial;
import logica.negocios.Factura;
import logica.negocios.Tasador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author AITOR
 *
 */

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField adminText;
	private JPasswordField passText;

	private ArrayList<Cliente> clientesBD = new ArrayList<Cliente>();
	private ArrayList<Administrador> adminBD = new ArrayList<Administrador>();
	private ArrayList<Factura> facturasBD = new ArrayList<Factura>();
	private ArrayList<Comercial> comercialesBD = new ArrayList<Comercial>();
	private ArrayList<Tasador> tasadoresBD= new ArrayList <Tasador>();
	private PantallaInicial padre;

	/**
	 * Create the frame Login que es donde introduce el administrador el nombre de
	 * usuario y contraseña y le da acceso al menu del administrador
	 */
	
	public Login(ArrayList<Cliente> clientes, ArrayList<Factura> facturas, ArrayList<Administrador> admin, ArrayList<Comercial> comerciales, ArrayList<Tasador> tasadores, PantallaInicial padre) {
		setResizable(false);
		
		
		this.clientesBD=clientes;
		this.adminBD=admin;
		this.facturasBD=facturas;
		this.comercialesBD=comerciales;
		this.tasadoresBD=tasadores;
		this.padre=padre;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(81, 117, 83, 20);
		contentPane.add(lblNombre);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(81, 217, 98, 20);
		contentPane.add(lblPassword);
		
		adminText = new JTextField();
		adminText.setBounds(206, 108, 219, 42);
		contentPane.add(adminText);
		adminText.setColumns(10);
		
		passText = new JPasswordField();
		passText.setBounds(206, 208, 219, 42);
		contentPane.add(passText);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CUANDO LE DAMOS AL OK
				
				String usuario = adminText.getText();
				String password = passText.getText();

				try {
					boolean encontrado = comprobarAdministrador(usuario, password);
					if (encontrado) {

						MenuAdministrador menuAdmi = new MenuAdministrador(usuario,password,clientes,facturas,admin,comerciales,tasadores,padre);
						menuAdmi.setVisible(true);
						Login.this.dispose();
					}

				} catch (UsuarioNoExiste e1) {
					JOptionPane.showMessageDialog(Login.this, e1.getMessage());

				}
				
			}
		});
		btnOk.setBounds(183, 324, 128, 42);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//CUANDO LE DAMOS A CANCEL
				
				Login.this.dispose();
				padre.setVisible(true);
			
			
			}
		});
		btnCancel.setBounds(337, 324, 128, 42);
		contentPane.add(btnCancel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 29));
		lblLogin.setBounds(256, 16, 209, 43);
		contentPane.add(lblLogin);
	}
	/**
	 * Este metodo sirve para comprobar si existe el nombre usuario y contraseña
	 * introducido por pantalla para ello mirara en la base de datos en el caso de
	 * existir, le dara acceso a la pantalla adminstrador, y en el caso de que no,
	 * le monstrara un mensaje indicandole que el usuario o contraseña no existe.
	 * 
	 * @param usuario
	 *            el nombre usuario introducido por pantalla
	 * @param password
	 *            la contraseña introducida por pantalla
	 * @return devolvera un true en caso de existir y un false en caso de que no
	 * @throws UsuarioNoExiste
	 *             es la clase en la que se implementa la excepcion del usuario no
	 *             existente
	 */
	public boolean comprobarAdministrador(String usuario, String password) throws UsuarioNoExiste {

		boolean existencia = false;

		for (Administrador a : adminBD) {

			if (a.getUsuario().equals(usuario)) {
				existencia = true;
				break;

			} else {
				if (a.getContrasenya().equals(password)) {

					existencia = true;
					break;
				}

			}
		}

		if (existencia == true) {

			return true;

		} else {

			throw new UsuarioNoExiste("Usuario o contrasenya no Existente");

		}

	}
}



