package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Comercial;
import logica.negocios.Factura;
import logica.negocios.Tasador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class BuscarFactura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Factura> listaFacturas= new ArrayList<Factura>();
	private MenuAdministrador padre;
	private ArrayList<Comercial> listaComerciales= new ArrayList<Comercial>();
	private ArrayList<Tasador> listaTasadores= new ArrayList<Tasador>();
	private int ocasion;
	private JLabel lblBusquedaFactura;

	

	/**
	 * Create the frame
	 * @param nombreDomicilios
	 * @param numFac
	 * @param coste
	 * @param fecha
	 * @param menuAdministrador
	 * @param facturasBD
	 */
	
	
	
	// buscar factura por fecha
		public BuscarFactura(ArrayList<Factura> facturasBD, MenuAdministrador padre, String dato, int ocasion) {
			this.listaFacturas = facturasBD;
			this.padre = padre;
			lblBusquedaFactura = new JLabel(dato);
			ocasion = ocasion;
			cargarVentana();
		}
		
	/**
	 * @wbp.parser.constructor
	 */
	public BuscarFactura(ArrayList <Comercial> comercialesBD,ArrayList <Tasador> tasadoresBD, ArrayList<Factura> facturasBD, String dato,MenuAdministrador menuAdministrador, Date fecha, int coste,
			int numFac, ArrayList<String> nombreDomicilios) {
		setResizable(false);
		this.listaComerciales = comercialesBD;
		this.listaTasadores=tasadoresBD;
		this.padre = padre;
		lblBusquedaFactura = new JLabel(dato);
		ocasion = ocasion;
		cargarVentana();
		
	}
		public void cargarVentana(){
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("dd-MM-yyyy");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(140, 38, 115, 20);
		contentPane.add(label);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Accion OK buscar por fecha FACTURAS

				String fecha = textField.getText();
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

				if (ocasion == 1) {

					ArrayList<Factura> seleccion = listaFacturas.stream()
							.filter(w -> (formatter.format(w.getFecha())).equals(fecha))
							.collect(Collectors.toCollection(() -> new ArrayList<Factura>()));

					if (!seleccion.isEmpty()) {

						BuscarFactura.this.dispose();
						VisualizacionFactura nuevo = new VisualizacionFactura(BuscarFactura.this, fecha, seleccion);
						nuevo.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(BuscarFactura.this, "No hay facturas con esa fecha");

					}
				}
			}
		});
		btnOk.setBounds(271, 88, 115, 29);
		contentPane.add(btnOk);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BuscarFactura.this.dispose();
				padre.setVisible(true);

			}
		});
		btnSalir.setBounds(271, 175, 115, 29);
		contentPane.add(btnSalir);

		textField = new JTextField();
		textField.setBounds(109, 89, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("FECHA: ");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(15, 86, 78, 31);
		contentPane.add(label_1);
	}
	
		public static Date variarFecha(Date fecha, int campo, int valor) {
			if (valor == 0)
				return fecha;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha);
			calendar.add(campo, valor);
			return calendar.getTime();
		}
}

