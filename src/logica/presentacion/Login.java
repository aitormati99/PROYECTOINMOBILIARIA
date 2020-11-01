package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField adminText;
	private JPasswordField passText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(48, 67, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 129, 69, 20);
		contentPane.add(lblPassword);
		
		adminText = new JTextField();
		adminText.setBounds(157, 64, 146, 26);
		contentPane.add(adminText);
		adminText.setColumns(10);
		
		passText = new JPasswordField();
		passText.setBounds(157, 126, 146, 26);
		contentPane.add(passText);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(82, 199, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(245, 199, 115, 29);
		contentPane.add(btnCancel);
	}
}
