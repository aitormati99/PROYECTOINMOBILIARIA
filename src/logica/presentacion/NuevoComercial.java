package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.datos.CrearBaseDatos;
import logica.negocios.Comercial;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

/**
 * 
 * @author Aitor
 *
 */

public class NuevoComercial extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtSueldo;
	private JTextField txtHorarioLaboral;
	private JList listClientes;
	private int forma;
	private MenuAdministrador papi;
	ArrayList<Comercial> listaComercial = new ArrayList<Comercial>();

	// nuevo comercial
	/**
	 * constructor para en el caso de que sea un nuevo comercial la opcion
	 * elegida por el admin
	 * 
	 * @param ventanaPadre
	 *            es la ventana de MenuAdministrador
	 * @param ocasion1
	 *            es la ocasion que se elige en el menuAdministrador, establece
	 *            que la ocasion es el nuevo comercial
	 */
	public NuevoComercial(MenuAdministrador ventanaPadre, int ocasion1) {
		setResizable(false);
		this.papi = ventanaPadre;
		this.listaComercial = papi.getComercialesBD();
		this.forma = ocasion1;
		cargarVentana();
	}

	/**
	 * constructor para en el caso de que sea la modificacion del comercial la
	 * opcion elegida por el admin
	 * 
	 * @param ventanaPadre
	 *            es la ventana de MenuAdministrador
	 * @param dni
	 *            es el dni del comercial
	 * @param sueldo
	 *            es el sueldo del comercial
	 * @param horario
	 *            es el horario del comercial
	 * @param clientes
	 *            los clientes que ha atendido el comercial
	 * @param ocasion1
	 *            es la ocasion que se eligen en el menuAdministrador y
	 *            establece que la ocasion es modificar el comercial
	 */

	// modificar comercial
	public NuevoComercial(MenuAdministrador ventanaPadre, String dni, int sueldo, int horarioLaboral,
			ArrayList<String> clientes, int ocasion1) {

		this.papi = ventanaPadre;
		this.listaComercial = papi.getComercialesBD();
		this.forma = ocasion1;

		cargarVentana();

		txtDni.setText(dni);
		txtSueldo.setText(sueldo + "");
		txtHorarioLaboral.setText(horarioLaboral + "");
		// ((Clientes) listClientes).addElement();
		// porque el dni no se puede cambiar, es unico para cada persona
		txtDni.setEditable(false);

	}

	/**
	 * sirve para cargar los datos de cada constructor en la ventana
	 */
	public void cargarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblComercial = new JLabel("COMERCIAL");
		lblComercial.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblComercial.setBackground(Color.BLACK);
		lblComercial.setBounds(222, 31, 190, 35);
		contentPane.add(lblComercial);

		JLabel label = new JLabel("DNI:");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(32, 194, 69, 20);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Sueldo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_1.setBounds(29, 260, 101, 20);
		contentPane.add(label_1);

		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblHoras.setBounds(29, 336, 124, 20);
		contentPane.add(lblHoras);

		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblClientes.setBounds(29, 393, 124, 20);
		contentPane.add(lblClientes);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(163, 259, 291, 26);
		contentPane.add(txtDni);

		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(163, 335, 291, 26);
		contentPane.add(txtSueldo);

		txtHorarioLaboral = new JTextField();
		txtHorarioLaboral.setBounds(171, 189, 291, 26);
		contentPane.add(txtHorarioLaboral);
		txtHorarioLaboral.setColumns(10);

		JList list = new JList();
		list.setBounds(163, 393, 291, 20);
		contentPane.add(list);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION OK
				// NUEVO COMERCIAL

				if (forma == 1) {

					String dni = txtDni.getText();
					int sueldo = Integer.parseInt(txtSueldo.getText());
					int horarioLaboral = Integer.parseInt(txtHorarioLaboral.getText());
					// NSE CMO METER EL ARRAY
					// ArrayList<String> clientes= listClientes.getName();

					boolean existe = false;

					for (Comercial a : listaComercial) {

						if (a.getDni().equals(dni)) {
							existe = true;
						}
					}

					if (existe == true) {
						JOptionPane.showMessageDialog(NuevoComercial.this, "Este dni del comercial ya existe");
					} else {

						// Comercial nuevo = new Comercial(dni, sueldo,
						// horarioLaboral, clientes);
						// listaComercial.add(nuevo);
						papi.setComercialesBD(listaComercial);
						papi.cargarLista();

						CrearBaseDatos mibd = new CrearBaseDatos("Inmobiliaria.db");
						mibd.createLink();
						// logica.datos.ComercialBaseDatos.insertComercial(mibd.getConn(),
						// dni, sueldo, horarioLaboral, clientes);
						mibd.closeLink();
						NuevoComercial.this.dispose();
						papi.setVisible(true);

					}

				}

				else if (forma == 2) {

					String dni = txtDni.getText();
					int sueldo = Integer.parseInt(txtSueldo.getText());
					int horarioLaboral = Integer.parseInt(txtHorarioLaboral.getText());
					// nosee
					// ArrayList<String> clientes= listClientes.getName();

					Comercial eliminar = null;
					Comercial cambiado = null;

					boolean existe = false;

					for (Comercial a : listaComercial) {

						if (a.getDni().equals(dni)) {
							existe = true;
							eliminar = a;
							break;
						}
					}

					if (existe == true) {

						listaComercial.remove(eliminar);
						// cambiado = new Comercial(dni, sueldo, horarioLaboral,
						// clientes);
						listaComercial.add(cambiado);
						papi.setComercialesBD(listaComercial);
						papi.cargarLista();

						CrearBaseDatos mibd = new CrearBaseDatos("Inmobiliaria.db");
						mibd.createLink();
						logica.datos.ComercialBaseDatos.delete(mibd.getConn(), dni);
						// logica.datos.ComercialBaseDatos.insertComercial(mibd.getConn(),
						// dni, sueldo, horarioLaboral, clientes);
						mibd.closeLink();
						NuevoComercial.this.dispose();
						papi.setVisible(true);

					}

				}

			}
		});
		btnOk.setBounds(339, 441, 115, 29);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION CANCEL
				NuevoComercial.this.dispose();
				papi.setVisible(true);
			}
		});
		btnCancel.setBounds(128, 441, 115, 29);
		contentPane.add(btnCancel);

		JButton btnAadirClientes = new JButton("A\u00F1adir Clientes");
		btnAadirClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnAadirClientes.setBounds(469, 391, 156, 29);
		contentPane.add(btnAadirClientes);

	}
}
