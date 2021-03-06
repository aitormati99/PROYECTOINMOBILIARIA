package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VisualizaciondelCliente extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	private MenuAdministrador padre;
	private String contenidoCliente;
	private String dniCliente;
	private int i;
	private String dniAdmin;
	private HashMap<String, String> adminInformacion;
	
	
	public VisualizaciondelCliente(String dni, String contenido, MenuAdministrador papi,
			int i) {
		// TODO Auto-generated constructor stub
		
		this.padre = papi;
		this.contenidoCliente = contenido;
		this.dniCliente = dni;
		this.i = i;
		
		cargarVentana();

	}
	public VisualizaciondelCliente(MenuAdministrador papi, int i, HashMap<String, String> datoAdministrador,
			String dniMetido) {
		// TODO Auto-generated constructor stub
		
		this.padre = papi;
		this.i = i;
		datoAdministrador= datoAdministrador;

		cargarVentana();
	}
	public void cargarVentana() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(34, 133, 433, 195);
		contentPane.add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(482, 318, 115, 29);
		contentPane.add(btnCancel);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(66, 45, 69, 20);
		contentPane.add(lblCliente);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(349, 45, 69, 20);
		contentPane.add(lblDni);
	}
	

	private class ClickListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			VisualizaciondelCliente.this.dispose();
			padre.setVisible(true);
		}

	}
	
}
