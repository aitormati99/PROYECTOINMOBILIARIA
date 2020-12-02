package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.negocios.Administrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private MenuAdministrador papi;
	private ArrayList<Administrador> listaAdministradores;

	/**
	 * Create the frame.
	 * 
	 * @param adminBD
	 * @param menuAdministrador
	 */
	public BuscarAdmin(MenuAdministrador menuAdministrador, ArrayList<Administrador> adminBD) {
		setResizable(false);

		this.papi = menuAdministrador;
		this.listaAdministradores = adminBD;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("BUSCAR ADMINISTRADOR POR DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setBounds(64, 48, 510, 20);
		contentPane.add(label);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION OK

				String dniMetido = txtDni.getText();
				HashMap<String, String> datoAdministrador = new HashMap<String, String>();
				boolean existe = false;

				if (dniMetido != null) {

					for (Administrador a : listaAdministradores) {

						if (a.getDni().equals(dniMetido)) {
							existe = true;
							datoAdministrador.put(dniMetido, a.getUsuario());
							break;
						}
					}

					if (existe == false) {
						JOptionPane.showMessageDialog(BuscarAdmin.this, "ERROR! No existe administrador con ese dni.");
					}

					else if (existe == true) {
						// abro pantalla visualizacion enviandole el hashmap y
						// dni
						VisualizaciondelCliente open = new VisualizaciondelCliente(papi, 2, datoAdministrador,
								dniMetido);
						open.setVisible(true);
						BuscarAdmin.this.dispose();
					}
				}

			}
		});
		btnOk.setBounds(384, 204, 115, 29);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION CANCEL
				BuscarAdmin.this.dispose();
				papi.setVisible(true);
			}
		});
		btnCancel.setBounds(384, 338, 115, 29);
		contentPane.add(btnCancel);

		txtDni = new JTextField();
		txtDni.setBounds(150, 205, 206, 26);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDni.setBounds(68, 208, 69, 20);
		contentPane.add(lblDni);
	}
}
