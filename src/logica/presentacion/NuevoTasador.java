package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NuevoTasador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public NuevoTasador() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(61, 165, 84, 20);
		contentPane.add(label);

		JLabel label_1 = new JLabel("DNI:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(64, 250, 69, 20);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Sueldo:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_2.setBounds(64, 344, 101, 20);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Horas:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_3.setBounds(64, 438, 124, 20);
		contentPane.add(label_3);

		JLabel lblTasador = new JLabel("TASADOR");
		lblTasador.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTasador.setBackground(Color.BLACK);
		lblTasador.setBounds(261, 59, 190, 35);
		contentPane.add(lblTasador);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(186, 166, 291, 26);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 248, 291, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 343, 291, 26);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(186, 437, 291, 26);
		contentPane.add(textField_3);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(182, 520, 115, 29);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(336, 520, 115, 29);
		contentPane.add(btnOk);
	}

}
