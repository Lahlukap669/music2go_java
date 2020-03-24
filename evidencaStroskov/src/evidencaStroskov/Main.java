package evidencaStroskov;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import java.awt.Cursor;

public class Main {

	JFrame frmMain;
	private JTextField plURL;
	private JTextField plName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("Main");
		frmMain.getContentPane().setBackground(Color.BLACK);
		frmMain.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("PLAYLIST NAME:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(130, 123, 99, 17);
		frmMain.getContentPane().add(lblNewLabel_1_1);
		
		JLabel bigname = new JLabel(Vars.user_ime + " " + Vars.user_priimek);
		bigname.setForeground(Color.WHITE);
		bigname.setBackground(Color.BLACK);
		bigname.setBounds(130, 305, 126, 13);
		frmMain.getContentPane().add(bigname);
		
		JLabel lblNewLabel_1 = new JLabel("PLAYLIST URL:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(130, 62, 99, 17);
		frmMain.getContentPane().add(lblNewLabel_1);
		
		plURL = new JTextField();
		plURL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		plURL.setColumns(10);
		plURL.setBounds(130, 89, 462, 33);
		frmMain.getContentPane().add(plURL);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 99, 335);
		frmMain.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Nothing since we are on this slide
			}
		});
		btnNewButton.setSelected(true);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon(Main.class.getResource("/images/url2.png")));
		btnNewButton.setBounds(20, 10, 79, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Playlists PlaylistsScreen = new Playlists();
				PlaylistsScreen.setVisible(true);
				frmMain.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon(Main.class.getResource("/images/playlist2.png")));
		btnNewButton_1.setBounds(20, 90, 79, 70);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Settings SettingsScreen = new Settings();
				SettingsScreen.setVisible(true);
				frmMain.dispose();
			}
		});
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(Main.class.getResource("/images/settings2.png")));
		btnNewButton_2.setBounds(20, 244, 79, 70);
		panel.add(btnNewButton_2);
	
		plName = new JTextField();
		plName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		plName.setColumns(10);
		plName.setBounds(130, 140, 196, 24);
		frmMain.getContentPane().add(plName);
		
		JButton btnLogin = new JButton("DOWNLOAD AND SAVE");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user_id = "" + Vars.user_id;
				String empty = "Empty";
				Integer i = Vars.user_id != null ? Vars.user_id.intValue() : null;
				final String input = String.format("{\"user_id\": %d, \"ime\":\"%s\", \"url\":\"%s\", \"opis\":\"%s\"}", i, plName.getText(), plURL.getText(), empty);
		        
		        JSONParser parser = new JSONParser();
		        try {
		        OkHttpClient httpClient = new OkHttpClient();
		        Response response = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/add_playlist").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
		        
		        JSONObject jsonResult = (JSONObject) parser.parse(response.body().string());
		        
		        System.out.println(jsonResult.get("bool"));	
		        boolean bool = (boolean) jsonResult.get("bool");
		        if(bool==true) {
		        	Vars.p_name = plName.getText();
		        	Vars.p_url = plURL.getText();
		        	Loading Loadingwindow = new Loading();
		        	Loadingwindow.setVisible(true);
		        	JOptionPane.showMessageDialog(null, "Playlist added!", "InfoBox", JOptionPane.INFORMATION_MESSAGE);		        	 
		        }else {
		        	JOptionPane.showMessageDialog(frmMain,"Error sending request!","Warning",JOptionPane.WARNING_MESSAGE);
		        }
		        
		        }catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnLogin.setForeground(new Color(192, 192, 192));
		btnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(34, 139, 34));
		btnLogin.setBounds(130, 177, 196, 46);
		frmMain.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/images/bg2.jpg")));
		lblNewLabel.setBounds(144, 34, 566, 346);
		frmMain.getContentPane().add(lblNewLabel);
		frmMain.setBounds(100, 100, 631, 365);
		
		
	}
	public void setVisible(boolean b) {
		Main window = new Main();
		window.frmMain.setVisible(true);		
	}
}
