package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.datos.CrearBaseDatos;
import logica.negocios.Tasador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Aitor
 *
 */

public class NuevoTasador extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtSueldo;
	private JTextField txtHorarioLaboral;
	private JTextField txtContadorFacturas;
	private int forma;
	private MenuAdministrador papi;
	ArrayList<Tasador> listaTasador = new ArrayList<Tasador>();

	// nuevo tasador
	/**
	 * constructor para en el caso de que sea un nuevo tasador la opcion elegida
	 * por el admin
	 * 
	 * @param ventanaPadre
	 *            es la ventana de MenuAdministrador
	 * @param ocasion1
	 *            es la ocasion que se elige en el menuAdministrador, establece
	 *            que la ocasion es el nuevo tasador
	 */

	public NuevoTasador(MenuAdministrador ventanaPadre, int ocasion1) {
		setResizable(false);
		this.papi = ventanaPadre;
		this.listaTasador = papi.getTasadoresBD();
		this.forma = ocasion1;
		cargarVentana();
	}

	/**
	 * constructor para en el caso de que sea la modificacion del tasador la
	 * opcion elegida por el admin
	 * 
	 * @param ventanaPadre
	 *            es la ventana de MenuAdministrador
	 * @param dni
	 *            es el dni del tasador
	 * @param sueldo
	 *            es el sueldo del tasador
	 * @param horario
	 *            es el horario del tasador
	 * @param contadorFacturas
	 *            las facturas que emiten los tasadores
	 * @param ocasion1
	 *            es la ocasion que se eligen en el menuAdministrador y
	 *            establece que la ocasion es modificar el tasador
	 * @wbp.parser.constructor
	 */

	// modificar comercial
	public NuevoTasador(MenuAdministrador ventanaPadre, String dni, int sueldo, int horarioLaboral,
			int contadorFacturas, int ocasion1) {

		this.papi = ventanaPadre;
		this.listaTasador = papi.getTasadoresBD();
		this.forma = ocasion1;

		cargarVentana();

		txtDni.setText(dni);
		txtSueldo.setText(sueldo + "");
		txtHorarioLaboral.setText(horarioLaboral + "");
		txtContadorFacturas.setText(contadorFacturas + "");
		// porque el dni no se puede cambiar, es unico para cada persona
		txtDni.setEditable(false);

	}

	/**
	 * sirve para cargar los datos de cada constructor en la ventana
	 */

	public void cargarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTasador = new JLabel("TASADOR");
		lblTasador.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTasador.setBackground(Color.BLACK);
		lblTasador.setBounds(261, 59, 190, 35);
		contentPane.add(lblTasador);

		JLabel label_1 = new JLabel("DNI:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(65, 168, 69, 20);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Sueldo:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_2.setBounds(65, 249, 101, 20);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Horas:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_3.setBounds(65, 344, 124, 20);
		contentPane.add(label_3);

		JLabel lblContadorFacturas = new JLabel("ContadorFacturas:");
		lblContadorFacturas.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblContadorFacturas.setBounds(28, 438, 124, 20);
		contentPane.add(lblContadorFacturas);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(186, 166, 291, 26);
		contentPane.add(txtDni);

		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(186, 248, 291, 26);
		contentPane.add(txtSueldo);

		txtHorarioLaboral = new JTextField();
		txtHorarioLaboral.setColumns(10);
		txtHorarioLaboral.setBounds(186, 343, 291, 26);
		contentPane.add(txtHorarioLaboral);

		txtContadorFacturas = new JTextField();
		txtContadorFacturas.setColumns(10);
		txtContadorFacturas.setBounds(186, 437, 291, 26);
		contentPane.add(txtContadorFacturas);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(182, 520, 115, 29);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION OK
				// NUEVO TASADOR

				if (forma == 1) {

					String dni = txtDni.getText();
					int sueldo = Integer.parseInt(txtSueldo.getText());
					int horarioLaboral = Integer.parseInt(txtHorarioLaboral.getText());
					int contadorFacturas = Integer.parseInt(txtContadorFacturas.getText());

					boolean existe = false;

					for (Tasador a : listaTasador) {

						if (a.getDni().equals(dni)) {
							existe = true;
						}
					}

					if (existe == true) {
						JOptionPane.showMessageDialog(NuevoTasador.this, "Este dni del comercial ya existe");
					} else {

						Tasador nuevo = new Tasador(dni, sueldo, horarioLaboral, contadorFacturas);
						listaTasador.add(nuevo);
						papi.setTasadoresBD(listaTasador);
						papi.cargarLista();

						CrearBaseDatos mibd = new CrearBaseDatos("Inmobiliaria.db");
						mibd.createLink();
						logica.datos.TasadorBaseDatos.insertTasador(mibd.getConn(), dni, sueldo, horarioLaboral,
								contadorFacturas);
						mibd.closeLink();
						NuevoTasador.this.dispose();
						papi.setVisible(true);

					}

				}

				else if (forma == 2) {

					String dni = txtDni.getText();
					int sueldo = Integer.parseInt(txtSueldo.getText());
					int horarioLaboral = Integer.parseInt(txtHorarioLaboral.getText());
					int contadorFacturas = Integer.parseInt(txtContadorFacturas.getText());

					Tasador eliminar = null;
					Tasador cambiado = null;

					boolean existe = false;

					for (Tasador a : listaTasador) {

						if (a.getDni().equals(dni)) {
							existe = true;
							eliminar = a;
							break;
						}
					}

					if (existe == true) {

						listaTasador.remove(eliminar);
						cambiado = new Tasador(dni, sueldo, horarioLaboral, contadorFacturas);
						listaTasador.add(cambiado);
						papi.setTasadoresBD(listaTasador);
						papi.cargarLista();

						CrearBaseDatos mibd = new CrearBaseDatos("Inmobiliaria.db");
						mibd.createLink();
						logica.datos.TasadorBaseDatos.delete(mibd.getConn(), dni);
						logica.datos.TasadorBaseDatos.insertTasador(mibd.getConn(), dni, sueldo, horarioLaboral,
								contadorFacturas);
						mibd.closeLink();
						NuevoTasador.this.dispose();
						papi.setVisible(true);

					}

				}

			}
		});
		btnOk.setBounds(336, 520, 115, 29);
		contentPane.add(btnOk);
	}

}
