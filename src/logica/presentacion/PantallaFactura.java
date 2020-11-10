package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaFactura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public PantallaFactura() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("FACTURA");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(165, 31, 117, 38);
		contentPane.add(label);

		JLabel label_1 = new JLabel("DNI:");
		label_1.setBounds(60, 107, 69, 20);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("TLF:");
		label_2.setBounds(58, 170, 69, 20);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Fecha:");
		label_3.setBounds(58, 239, 69, 20);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("N\u00BA Factura:");
		label_4.setBounds(50, 297, 93, 20);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Coste total:");
		label_5.setBounds(50, 377, 93, 20);
		contentPane.add(label_5);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(151, 105, 146, 26);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 166, 146, 26);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 235, 146, 26);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(151, 294, 146, 26);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 374, 146, 26);
		contentPane.add(textField_4);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(86, 483, 115, 29);
		contentPane.add(btnCancelar);

		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setBounds(264, 483, 115, 29);
		contentPane.add(btnConfirmar);

		JLabel label_6 = new JLabel("\u20AC");
		label_6.setBounds(312, 377, 18, 20);
		contentPane.add(label_6);
	}

}
