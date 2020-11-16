package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ConfirmacionCompra extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param precioTot 
	 */
	public ConfirmacionCompra(int precioTot) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("IMPORTE 0\u20AC");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(475, 32, 166, 77);
		contentPane.add(label);

		JLabel lblhemosRecibidoTu = new JLabel("\u00A1Hemos recibido tu compra!");
		lblhemosRecibidoTu.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblhemosRecibidoTu.setBounds(135, 155, 385, 49);
		contentPane.add(lblhemosRecibidoTu);

		JLabel lblWwwinmobiliariamaticom = new JLabel("www.InmobiliariaMati.com");
		lblWwwinmobiliariamaticom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWwwinmobiliariamaticom.setBounds(26, 456, 229, 24);
		contentPane.add(lblWwwinmobiliariamaticom);

		JLabel label_1 = new JLabel("943 421 422");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(475, 458, 134, 28);
		contentPane.add(label_1);

		JLabel lblEnBreveEmpezaremos = new JLabel("En breve empezaremos a preparar tu compra");
		lblEnBreveEmpezaremos.setBounds(152, 249, 432, 28);
		contentPane.add(lblEnBreveEmpezaremos);
	}

}
