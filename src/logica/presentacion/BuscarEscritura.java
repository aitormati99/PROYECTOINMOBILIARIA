package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class BuscarEscritura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 * 
	 * @param dni
	 * @param codigo
	 * @param menuAdministrador
	 */
	public BuscarEscritura(MenuAdministrador menuAdministrador, int codigo, String dni) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBuscarEscrituraPor = new JLabel("Buscar Escritura por Codigo");
		lblBuscarEscrituraPor.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBuscarEscrituraPor.setBounds(155, 69, 397, 53);
		contentPane.add(lblBuscarEscrituraPor);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(187, 196, 318, 26);
		contentPane.add(textField);

		JLabel lblCod = new JLabel("Cod:");
		lblCod.setForeground(Color.BLACK);
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblCod.setBounds(89, 196, 72, 20);
		contentPane.add(lblCod);

		JButton button = new JButton("OK");
		button.setBounds(519, 254, 115, 29);
		contentPane.add(button);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(519, 386, 115, 29);
		contentPane.add(btnSalir);
	}
}
