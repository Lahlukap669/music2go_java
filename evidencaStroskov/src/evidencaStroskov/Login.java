package evidencaStroskov;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Login");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(309, 70, 99, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(309, 91, 274, 28);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(309, 129, 99, 17);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(309, 150, 274, 28);
		frame.getContentPane().add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 269, 335);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/image2.jpg")));
		lblNewLabel.setBounds(-245, -45, 533, 425);
		panel.add(lblNewLabel);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(255, 150, 0));
		btnLogin.setBounds(309, 240, 274, 46);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("I don't have account yet");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Register RegisterScreen = new Register();
				RegisterScreen.setVisible(true);
			}
		});
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 8));
		lblNewLabel_2.setBounds(395, 300, 99, 13);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBounds(100, 100, 631, 365);
		
		
	}
	public void setVisible(boolean b) {
		Login window = new Login();
		window.frame.setVisible(true);		
	}
}
