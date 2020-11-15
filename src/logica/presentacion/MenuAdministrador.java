package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.datos.CrearBaseDatos;
import logica.negocios.Administrador;
import logica.negocios.Cliente;
import logica.negocios.Comercial;
import logica.negocios.Factura;
import logica.negocios.Tasador;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Aitor
 *
 */
public class MenuAdministrador extends JFrame {

	private JPanel contentPane;
	private JList list;
	private ArrayList<Cliente> clientesBD = new ArrayList<Cliente>();
	private ArrayList<Administrador> adminBD = new ArrayList<Administrador>();
	private ArrayList<Factura> facturasBD = new ArrayList<Factura>();
	private ArrayList<Comercial> comercialesBD = new ArrayList<Comercial>();
	private ArrayList<Tasador> tasadoresBD = new ArrayList<Tasador>();
	private String usuario;
	private String password;
	private PantallaInicial papi;

	public ArrayList<Comercial> getComercialesBD() {
		return comercialesBD;
	}

	public void setComercialesBD(ArrayList<Comercial> comercialesBD) {
		this.comercialesBD = comercialesBD;
	}

	public ArrayList<Tasador> getTasadoresBD() {
		return tasadoresBD;
	}

	public void setTasadoresBD(ArrayList<Tasador> tasadoresBD) {
		this.tasadoresBD = tasadoresBD;

	}

	/**
	 * Create the frame.
	 * 
	 * @param papi
	 * @param tasadores
	 * @param comerciales
	 * @param admin
	 * @param facturas
	 * @param clientes
	 * @param password
	 * @param usuario
	 */
	public MenuAdministrador(String usuario, String password, ArrayList<Cliente> clientes, ArrayList<Factura> facturas,
			ArrayList<Administrador> admin, ArrayList<Comercial> comerciales, ArrayList<Tasador> tasadores,
			PantallaInicial papi) {

		setResizable(false);

		this.clientesBD = clientes;
		this.adminBD = admin;
		this.facturasBD = facturas;
		this.comercialesBD = comerciales;
		this.tasadoresBD = tasadores;
		usuario = usuario;
		password = password;
		this.papi = papi;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Dar de alta Comercial", "Dar de baja Comercial",
				"Dar de alta Tasador", "Dar de baja Tasador", "Modificar Comercial", "Modificar Tasador",
				"Domicilios requeridos por un cliente ", "Buscar facturas por fecha determinada",
				"Cual es el mes que mas gana la inmobiliaria", "Buscar nombre del administrador" }));
		comboBox.setBounds(80, 119, 312, 29);
		contentPane.add(comboBox);

		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblBienvenido.setBounds(171, 37, 139, 38);
		contentPane.add(lblBienvenido);

		list = new JList();
		list.setBounds(95, 173, 286, 221);
		// contentPane.add(list);

		// pongo el scrollpane en un jlist
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(93, 171, 288, 223);
		contentPane.add(scrollPane);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Accion OK

				String ocasion = (String) comboBox.getSelectedItem();

				if (ocasion.equals("Dar de alta Comercial")) {

					int ocasion1 = 1;
					NuevoComercial ventana = new NuevoComercial(MenuAdministrador.this, ocasion1);
					ventana.setVisible(true);
					MenuAdministrador.this.dispose();

				} else if (ocasion.equals("Dar de baja Comercial")) {

					eliminar();
				} else if (ocasion.equals("Dar de alta Tasador")) {

					int ocasion1 = 2;
					NuevoTasador ventana = new NuevoTasador(MenuAdministrador.this, ocasion1);
					ventana.setVisible(true);
					MenuAdministrador.this.dispose();

				} else if (ocasion.equals("Dar de baja Tasador")) {

					eliminar1();

				} else if (ocasion.equals("Modificar Comercial")) {

					ArrayList<String> clientes = new ArrayList<String>();
					String dni = null;
					dni = (String) list.getSelectedValue();

					int sueldo = 0;
					int horarioLaboral = 0;
					int ocasion1 = 3;

					if (dni != null) {

						for (Comercial a : comercialesBD) {

							if (a.getDni().equals(dni)) {

								sueldo = a.getSueldo();
								horarioLaboral = a.getHorarioLaboral();
								clientes = a.getClientes();
							}
						}

						NuevoComercial ventana = new NuevoComercial(MenuAdministrador.this, dni, sueldo, horarioLaboral,
								clientes, ocasion1);
						ventana.setVisible(true);
						MenuAdministrador.this.dispose();

					}

				} else if (ocasion.equals("Modificar Tasador")) {

					String dni = null;
					dni = (String) list.getSelectedValue();

					int sueldo = 0;
					int horarioLaboral = 0;
					int contadorFacturas = 0;
					int ocasion1 = 4;

					if (dni != null) {

						for (Tasador a : tasadoresBD) {

							if (a.getDni().equals(dni)) {

								sueldo = a.getSueldo();
								horarioLaboral = a.getHorarioLaboral();
								contadorFacturas = a.getContadorFacturas();
							}
						}

						NuevoTasador ventana = new NuevoTasador(MenuAdministrador.this, dni, sueldo, horarioLaboral,
								contadorFacturas, ocasion1);
						ventana.setVisible(true);
						MenuAdministrador.this.dispose();

					}

				} else if (ocasion.equals("Domicilios requeridos")) {

					BusquedaClienteDomicilio busqueda = new BusquedaClienteDomicilio(MenuAdministrador.this,
							clientesBD);
					busqueda.setVisible(true);
					MenuAdministrador.this.dispose();

				} else if (ocasion.equals("Buscar facturas por fecha determinada")) {

					Date fecha = null;
					int coste = 0;
					int numFac = 1;
					ArrayList<String> nombreDomicilios = new ArrayList<String>();
					BuscarFactura busqueda = new BuscarFactura(facturasBD, MenuAdministrador.this, fecha, coste, numFac,
							nombreDomicilios);
					busqueda.setVisible(true);
					MenuAdministrador.this.dispose();

				} else if (ocasion.equals("Buscar escritura por codigo determinado")) {

					int codigo = 0;
					String dni = null;

					BuscarEscritura busqueda = new BuscarEscritura(MenuAdministrador.this, codigo, dni);
					busqueda.setVisible(true);
					MenuAdministrador.this.dispose();

				} else if (ocasion.equals("Buscar nombre del administrador")) {

					BuscarAdmin abrir = new BuscarAdmin(MenuAdministrador.this, adminBD);
					abrir.setVisible(true);
					MenuAdministrador.this.dispose();
				}

			}
		});
		btnOk.setBounds(449, 119, 115, 29);
		contentPane.add(btnOk);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION SALIR

				MenuAdministrador.this.dispose();
				papi.setVisible(true);

			}
		});
		btnSalir.setBounds(449, 278, 115, 29);
		contentPane.add(btnSalir);

		cargarLista();
		cargarLista1();
	}

	/**
	 * sirve para cargar la lista de los comerciales en el Jlist
	 */

	public void cargarLista() {

		DefaultListModel model = new DefaultListModel<>();
		list.setModel(model);

		for (Comercial a : comercialesBD) {

			String DNI = a.getDni();
			model.addElement(DNI);
		}
	}

	public void eliminar() {

		String dni = null;
		dni = (String) list.getSelectedValue();

		if (dni != null) {

			for (Comercial a : comercialesBD) {

				if (a.getDni().equals(dni)) {

					CrearBaseDatos mybd1 = new CrearBaseDatos("Inmobiliaria.db");
					mybd1.createLink();
					logica.datos.ComercialBaseDatos.delete(mybd1.getConn(), a.getDni());
					comercialesBD.remove(a);
					break;
				}
			}

			cargarLista();
		}
	}

	/**
	 * sirve para cargar la lista de los tasadores en el Jlist
	 */

	public void cargarLista1() {

		DefaultListModel model = new DefaultListModel<>();
		list.setModel(model);

		for (Tasador a : tasadoresBD) {

			String DNI = a.getDni();
			model.addElement(DNI);
		}

	}

	public void eliminar1() {

		String dni = null;
		dni = (String) list.getSelectedValue();

		if (dni != null) {

			for (Tasador a : tasadoresBD) {

				if (a.getDni().equals(dni)) {

					CrearBaseDatos mybd1 = new CrearBaseDatos("Inmobiliaria.db");
					mybd1.createLink();
					logica.datos.TasadorBaseDatos.delete(mybd1.getConn(), a.getDni());
					tasadoresBD.remove(a);
					break;
				}
			}

			cargarLista1();
		}
	}
}
