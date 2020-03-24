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

public class Settings {

	JFrame frmSettings;
	public String AdminR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
					window.frmSettings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSettings = new JFrame();
		frmSettings.setTitle("Settings");
		frmSettings.getContentPane().setBackground(Color.BLACK);
		frmSettings.getContentPane().setLayout(null);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login LoginScreen = new Login();
				LoginScreen.setVisible(true);
				frmSettings.dispose();
			}
		});
		btnLogout.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogout.setForeground(Color.LIGHT_GRAY);
		btnLogout.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnLogout.setBackground(new Color(34, 139, 34));
		btnLogout.setBounds(284, 260, 83, 46);
		frmSettings.getContentPane().add(btnLogout);
				
		String Admin = "" + Vars.user_admin;
		JLabel admin = new JLabel("Admin: "+ Admin);
		admin.setForeground(Color.WHITE);
		admin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		admin.setBackground(Color.BLACK);
		admin.setBounds(130, 94, 99, 17);
		frmSettings.getContentPane().add(admin);
		
		JLabel priimek = new JLabel(Vars.user_priimek);
		priimek.setForeground(Color.WHITE);
		priimek.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priimek.setBackground(Color.BLACK);
		priimek.setBounds(130, 56, 360, 17);
		frmSettings.getContentPane().add(priimek);
		
		JLabel email = new JLabel(Vars.user_email);
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email.setBackground(Color.BLACK);
		email.setBounds(130, 74, 354, 17);
		frmSettings.getContentPane().add(email);
		
		JLabel ime = new JLabel(Vars.user_ime);
		ime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ime.setForeground(Color.WHITE);
		ime.setBackground(Color.BLACK);
		ime.setBounds(130, 37, 404, 17);
		frmSettings.getContentPane().add(ime);
		
		JLabel lblNewLabel_1 = new JLabel("SETTINGS:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(130, 10, 99, 17);
		frmSettings.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 99, 335);
		frmSettings.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main MainScreen = new Main();
				MainScreen.setVisible(true);
				frmSettings.dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon(Settings.class.getResource("/images/url2.png")));
		btnNewButton.setBounds(20, 10, 79, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Playlists PlaylistScreen = new Playlists();
				PlaylistScreen.setVisible(true);
				frmSettings.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon(Settings.class.getResource("/images/playlist2.png")));
		btnNewButton_1.setBounds(20, 90, 79, 70);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Nothing sice we are already one the slide
			}
		});
		btnNewButton_2.setSelected(true);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(Settings.class.getResource("/images/settings2.png")));
		btnNewButton_2.setBounds(20, 244, 79, 70);
		panel.add(btnNewButton_2);
		
		JButton btnLogin = new JButton("CHANGE PASSWORD");
		btnLogin.setForeground(new Color(192, 192, 192));
		btnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnLogin.setBackground(new Color(34, 139, 34));
		btnLogin.setBounds(119, 260, 155, 46);
		frmSettings.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Settings.class.getResource("/images/bg2.jpg")));
		lblNewLabel.setBounds(140, 37, 566, 346);
		frmSettings.getContentPane().add(lblNewLabel);
		frmSettings.setBounds(100, 100, 631, 365);
		
		
	}
	public void setVisible(boolean b) {
		Settings window = new Settings();
		window.frmSettings.setVisible(true);		
	}
}
