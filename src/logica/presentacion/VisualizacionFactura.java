package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Comercial;
import logica.negocios.Factura;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

public class VisualizacionFactura extends JFrame {

	private JPanel contentPane;
 
	private int ocasion;
	private MenuAdministrador padreone;
	private BuscarFactura padretwo;
	private String fechaA;
	private ArrayList<Factura> seleccionadoA;
	private ArrayList<Comercial> elegido;
	private JLabel lblFactura;
	/**
	 * Create the frame.
	 * @param seleccion 
	 * @param fecha 
	 * @param buscarFactura 
	 * @wbp.parser.constructor
	 */
	public VisualizacionFactura(BuscarFactura padre, String fecha, ArrayList<Factura> seleccionado) {
		
		// mostrar facturas por fecha determinada
				ocasion = padre.getOcasion();
				padretwo = padre;
				padreone = padre.getPadre();
				fechaA = fecha;
				seleccionadoA = seleccionado;
				lblFactura = new JLabel("FACTURAS: ");
				cargarVentana();
	}
		
		
		
	public VisualizacionFactura(BuscarFactura padre, ArrayList<Factura> seleccionado, String fecha) {

		
		setResizable(false);
		
		
		
		
		// mOSTRAR numero de facturas de un repartidor concreto
				ocasion = padre.getOcasion();
				padretwo = padre;
				padreone = padre.getPadre();
				fechaA = fecha;
				seleccionadoA = seleccionado;
				lblFactura = new JLabel("COMERCIALES: ");

				cargarVentana();

			}
	
	public void cargarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(27, 152, 421, 222);
		contentPane.add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblComerciales = new JLabel("COMERCIALES:");
		lblComerciales.setForeground(Color.BLACK);
		lblComerciales.setFont(new Font("Dialog", Font.BOLD, 24));
		lblComerciales.setBounds(59, 16, 258, 57);
		contentPane.add(lblComerciales);

		if (ocasion == 1) {

			// todas las facturas de esa fecha
			String contenido = "";

			for (Factura a : seleccionadoA) {

				contenido = "NUMERO FACTURA: " + a.getNumFac() + " --> COSTE: " + a.getCoste() + "€\n";
			}
			textPane.setText(contenido);
		
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VisualizacionFactura.this.dispose();
				padreone.setVisible(true);
			}

			
		});
		btnSalir.setBounds(462, 384, 115, 29);
		contentPane.add(btnSalir);
	}
		
	}
}



