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
import java.awt.Button;
import java.awt.Cursor;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JList;

public class Playlists {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Playlists window = new Playlists();
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
	public Playlists() {
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
		
		JLabel lblNewLabel_1 = new JLabel("PLAYLISTS:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(130, 10, 99, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 99, 335);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon(Playlists.class.getResource("/images/url2.png")));
		btnNewButton.setBounds(20, 10, 79, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setSelected(true);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon(Playlists.class.getResource("/images/playlist2.png")));
		btnNewButton_1.setBounds(20, 90, 79, 70);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(Playlists.class.getResource("/images/settings2.png")));
		btnNewButton_2.setBounds(20, 244, 79, 70);
		panel.add(btnNewButton_2);
		
		JButton btnLogin = new JButton("EDIT");
		btnLogin.setForeground(new Color(192, 192, 192));
		btnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(34, 139, 34));
		btnLogin.setBounds(119, 260, 99, 46);
		frame.getContentPane().add(btnLogin);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setHorizontalAlignment(SwingConstants.CENTER);
		btnDelete.setForeground(Color.LIGHT_GRAY);
		btnDelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnDelete.setBackground(new Color(34, 139, 34));
		btnDelete.setBounds(228, 260, 99, 46);
		frame.getContentPane().add(btnDelete);
		
		JList list = new JList();
		list.setBackground(new Color(128, 128, 128));
		list.setBounds(119, 37, 266, 199);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Playlists.class.getResource("/images/bg2.jpg")));
		lblNewLabel.setBounds(140, 37, 566, 346);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 631, 365);
		
		
	}
	public void setVisible(boolean b) {
		Playlists window = new Playlists();
		window.frame.setVisible(true);		
	}
}
