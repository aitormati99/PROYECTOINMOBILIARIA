package logica.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VisualizaciondelCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VisualizaciondelCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(34, 133, 433, 195);
		contentPane.add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(482, 318, 115, 29);
		contentPane.add(btnCancel);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(66, 45, 69, 20);
		contentPane.add(lblCliente);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(349, 45, 69, 20);
		contentPane.add(lblDni);
	}
}
