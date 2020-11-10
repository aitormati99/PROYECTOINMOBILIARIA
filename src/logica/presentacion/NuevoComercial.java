package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NuevoComercial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public NuevoComercial() {
		setResizable(false);
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

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(163, 192, 291, 26);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 259, 291, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 335, 291, 26);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(163, 119, 291, 26);
		contentPane.add(textField_3);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(29, 122, 84, 20);
		contentPane.add(lblNombre);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(128, 441, 115, 29);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(339, 441, 115, 29);
		contentPane.add(btnOk);
	}

}
