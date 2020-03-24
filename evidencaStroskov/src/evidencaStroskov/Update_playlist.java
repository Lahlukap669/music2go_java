package evidencaStroskov;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import okhttp3.*;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Update_playlist {

	private JFrame frmUpdate;
	private JTextField txtNeki;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_playlist window = new Update_playlist();
					window.frmUpdate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Update_playlist() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdate = new JFrame();
		frmUpdate.getContentPane().setBackground(Color.BLACK);
		frmUpdate.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frmUpdate.getContentPane().add(panel);
		frmUpdate.setBackground(Color.DARK_GRAY);
		frmUpdate.setBounds(100, 100, 631, 305);
		frmUpdate.setTitle("Update");
		frmUpdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBounds(0, 0, 269, 335);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Update_playlist.class.getResource("/images/image2.jpg")));
		lblNewLabel.setBounds(-248, -25, 547, 376);
		panel.add(lblNewLabel);
		
		txtNeki = new JTextField();
		txtNeki.setBounds(309, 31, 274, 28);
		frmUpdate.getContentPane().add(txtNeki);
		txtNeki.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PLAYLIST NAME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(309, 10, 162, 17);
		frmUpdate.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PLAYLIST URL");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(309, 69, 162, 17);
		frmUpdate.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(309, 88, 274, 28);
		frmUpdate.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("PLAYLIST DESCRIPTION");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(309, 126, 187, 17);
		frmUpdate.getContentPane().add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(309, 145, 274, 28);
		frmUpdate.getContentPane().add(textField_1);
		
		JButton btnUPDATE = new JButton("UPDATE");
		
		
		btnUPDATE.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				String id = Vars.pid;
				String ime = txtNeki.getText();
				String url = textField.getText();
				String opis = textField_1.getText();
				//"http://music2go.herokuapp.com/register"
				
				//Connection to API (method=POST)
				final String input = String.format("{\"id\":%s, \"ime\":\"%s\", \"url\":\"%s\", \"opis\":\"%s\"}",id , ime, url, opis);
		        
		        JSONParser parser = new JSONParser();
		        try {JSONObject json = (JSONObject) parser.parse(input);
		        OkHttpClient httpClient = new OkHttpClient();
		        Response response = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/update_playlist").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
		        
		        JSONParser parser1 = new JSONParser();
		        JSONObject jsonResult = (JSONObject) parser.parse(response.body().string());
		        
		        //System.out.println(jsonResult.get("bool"));	
		        boolean bool = (boolean) jsonResult.get("bool");
		        if(bool==true) {
					Playlists PlaylistsScreen = new Playlists();
					PlaylistsScreen.setVisible(true);
					frmUpdate.dispose();
		        }else {
		        	JOptionPane.showMessageDialog(frmUpdate,"Error registering!!","Warning",JOptionPane.WARNING_MESSAGE);
		        }
		        
		        }catch(Exception e1) {System.out.println(e1);}
		        					
			}
		});

		btnUPDATE.setHorizontalAlignment(SwingConstants.CENTER);
		btnUPDATE.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnUPDATE.setBackground(new Color(255, 150, 0));
		btnUPDATE.setBounds(458, 194, 125, 46);
		frmUpdate.getContentPane().add(btnUPDATE);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Playlists PlaylistsScreen = new Playlists();
				PlaylistsScreen.setVisible(true);
				frmUpdate.dispose();
			}
		});
		btnBack.setHorizontalAlignment(SwingConstants.CENTER);
		btnBack.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnBack.setBackground(new Color(255, 150, 0));
		btnBack.setBounds(309, 194, 125, 46);
		frmUpdate.getContentPane().add(btnBack);
	}

	public void setVisible(boolean b) {
		Update_playlist window = new Update_playlist();
		window.frmUpdate.setVisible(true);		
	}
}
