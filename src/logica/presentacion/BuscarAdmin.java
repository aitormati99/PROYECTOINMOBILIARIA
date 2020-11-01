package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BuscarAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarAdmin frame = new BuscarAdmin();
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
	public BuscarAdmin() {
		setResizable(false);
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
		btnOk.setBounds(384, 204, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(384, 338, 115, 29);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(150, 205, 206, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("DNI:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(68, 208, 69, 20);
		contentPane.add(label_1);
	}
}
