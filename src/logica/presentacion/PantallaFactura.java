package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logica.datos.CrearBaseDatos;
import logica.negocios.Cliente;
import logica.negocios.Domicilio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Aitor
 *
 */
public class PantallaFactura extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtNumFac;
	private JTextField txtFecha;
	private JTextField txtCoste;
	private JTextField txtDNI;
	private JTextField txtTlf;
	
	
	private static ArrayList<Cliente> clientesBD = new ArrayList<Cliente>();
	private static ArrayList<Domicilio> compraCliente = new ArrayList<Domicilio>();
	private static ArrayList<String> nombreDomicicilios = new ArrayList<String>();
	private static String dniComprador;
	private static int countVilla1 = 0;
	private static int countVilla2 = 0;
	private static int countVilla3 = 0;
	private static int countVilla4 = 0;
	private static int countVilla5 = 0;
	private static int countVilla6 = 0;
	private PantallaInicial papi;

	/**
	 * Create the frame factura,hecha la compra, se le
	 * muestra al cliente la factura de la compra, con su precio,y con el domicilio comprado
	 * @param clientesBD 
	 * @param domicilios 
	 * @param precioTot 
	 * @param papi 
	 */
	public PantallaFactura(PantallaInicial papi, int precioTot, ArrayList<Domicilio> domicilios, ArrayList<Cliente> clientesBD) {
		setResizable(false);
		
		this.clientesBD=clientesBD;
		this.compraCliente=domicilios;
		this.papi=papi;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFactura = new JLabel("FACTURA");
		lblFactura.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFactura.setBounds(391, 16, 117, 38);
		contentPane.add(lblFactura);

		JLabel lblNumeroFactura = new JLabel("N\u00BA Factura:");
		lblNumeroFactura.setBounds(175, 458, 93, 20);
		contentPane.add(lblNumeroFactura);;
		
		txtNumFac = new JTextField();
		txtNumFac.setColumns(10);
		txtNumFac.setBounds(337, 452, 228, 26);
		contentPane.add(txtNumFac);
		// añadir un numero de factura aleatorio
				int n = 1000;
				int numero = (int) (Math.random() * n) + 1;
				txtNumFac.setText("" + numero);

	
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(175, 387, 69, 20);
		contentPane.add(lblFecha);
				
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(337, 384, 228, 26);
		contentPane.add(txtFecha);
		
		Date fecha = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFac = formatter.format(fecha);
		// Añadir la fecha actual
		txtFecha.setText(fechaFac);
				
		JLabel lblCompra = new JLabel("Compra:");
		lblCompra.setBounds(175, 567, 69, 20);
		contentPane.add(lblCompra);

	
		JLabel lblCosteTotal = new JLabel("Coste total:");
		lblCosteTotal.setBounds(175, 636, 93, 20);
		contentPane.add(lblCosteTotal);

		txtCoste = new JTextField();
		txtCoste.setColumns(10);
		txtCoste.setBounds(337, 633, 228, 26);
		contentPane.add(txtCoste);

		
		// añadir el coste total
				String totalString = " " + precioTot;
				txtCoste.setText(totalString);

	JLabel lblDni = new JLabel("DNI:");
	lblDni.setBounds(175, 264, 69, 20);
	contentPane.add(lblDni);

	txtDNI = new JTextField();
	txtDNI.setBounds(337, 261, 228, 26);
	contentPane.add(txtDNI);
	txtDNI.setColumns(10);
	
	txtTlf = new JTextField();
	txtTlf.setColumns(10);
	txtTlf.setBounds(337, 324, 228, 26);
	contentPane.add(txtTlf);
	
	JLabel lblTlf = new JLabel("TLF:");
	lblTlf.setBounds(175, 327, 69, 20);
	contentPane.add(lblTlf);
	txtTlf.setColumns(10);
	

	JLabel lblNombre = new JLabel("Nombre:");
	lblNombre.setBounds(175, 83, 69, 20);
	contentPane.add(lblNombre);
	
	txtNombre = new JTextField();
	txtNombre.setColumns(10);
	txtNombre.setBounds(337, 80, 228, 26);
	contentPane.add(txtNombre);
	
	JLabel lblApellido = new JLabel("Apellido:");
	lblApellido.setBounds(175, 146, 69, 20);
	contentPane.add(lblApellido);
	
	txtApellido = new JTextField();
	txtApellido.setColumns(10);
	txtApellido.setBounds(337, 143, 228, 26);
	contentPane.add(txtApellido);
	
	JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
	lblDireccion.setBounds(175, 197, 93, 20);
	contentPane.add(lblDireccion);
	
	txtDireccion = new JTextField();
	txtDireccion.setColumns(10);
	txtDireccion.setBounds(337, 194, 228, 26);
	contentPane.add(txtDireccion);

	JTextPane textPane = new JTextPane();
	textPane.setFont(new Font("Tahoma", Font.BOLD, 16));
	textPane.setBounds(208, 346, 327, 158);
	


	// PONER EL SCROLLPANE EN UN JLIST
	JScrollPane scroll = new JScrollPane();
	scroll.setViewportView(textPane);
	scroll.setBounds(337, 494, 228, 116);
	contentPane.add(scroll);
	
	
	
		

	// añadir la infor de los domicilios
	String contenido = "";
	for (int i = 0; i < compraCliente.size(); i++) {

		contenido += "- " + compraCliente.get(i).getNombre()+ compraCliente.get(i).getPrecio() + "€\n";

	}

	textPane.setText(contenido);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// ACCION CANCELAR

				PantallaFactura.this.dispose();
				papi.setVisible(true);
				
			}
		});
		btnCancelar.setBounds(272, 682, 136, 29);
		contentPane.add(btnCancelar);

		JButton btnConfirmarCompra = new JButton("CONFIRMAR");
		btnConfirmarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
				// FUNCION CONFIRMAR

				// CREO EL CLIENTE Y CREO LA FACTURA

				String nombre= null;
				String apellido= null;
				String direccion= null;
				String dni = null;
				String tlf = null;
				dni = txtDNI.getText();
				tlf = txtTlf.getText();

				dniComprador = dni;

				boolean pintado = false;

				if (dni != null && tlf != null) {
					pintado = true;

				}

				if (pintado == false) {
					JOptionPane.showMessageDialog(PantallaFactura.this, "DNI o telefono sin rellenar");
				}

				else if (pintado == true) {

					

					for (Cliente a : clientesBD) {

						if (a.getDni().equals(dniComprador)) {

							ArrayList<String> domicilios = a.getNombreDomicilios();
							CrearBaseDatos mibd1 = new CrearBaseDatos("Inmobiliaria.db");
							mibd1.createLink();
							logica.datos.ClienteBaseDatos.delete(mibd1.getConn(), dniComprador);
							mibd1.closeLink();

						}

					}
					// INTRODUCIR EN LA BD EL NUEVO CLIENTE

					 CrearBaseDatos mibd = new CrearBaseDatos("Inmobiliaria.db");
					mibd.createLink();

					logica.datos.ClienteBaseDatos.insertCliente(mibd.getConn(), nombre, apellido, tlf, direccion, dni, nombreDomicicilios);
					// INTRODUCIR EN LA BD LA NUEVA FACTURA

					logica.datos.FacturaBaseDatos.insertFactura(mibd.getConn(), numero, fechaFac, precioTot, nombreDomicicilios);
					mibd.closeLink();

					PantallaFactura.this.dispose();
					ConfirmacionCompra actualizacion = new ConfirmacionCompra(precioTot);
					actualizacion.setVisible(true);

				}

			
			}
		});
		btnConfirmarCompra.setBounds(520, 682, 136, 29);
		contentPane.add(btnConfirmarCompra);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(580, 636, 18, 20);
		contentPane.add(label);		
		
		
		
	}
}
