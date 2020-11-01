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

public class BusquedaClienteDomicilio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaClienteDomicilio frame = new BusquedaClienteDomicilio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BusquedaClienteDomicilio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("BUSQUEDA CLIENTE");
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setBounds(75, 16, 338, 26);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("DNI:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_1.setBounds(38, 111, 72, 20);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(111, 111, 192, 26);
		contentPane.add(textField);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(298, 161, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(298, 206, 115, 29);
		contentPane.add(btnAtras);
	}
}
