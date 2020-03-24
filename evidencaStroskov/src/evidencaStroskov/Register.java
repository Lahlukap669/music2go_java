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

public class Register {

	private JFrame frame;
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
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 631, 365);
		frame.setTitle("Register");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBounds(0, 0, 269, 335);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/images/image2.jpg")));
		lblNewLabel.setBounds(-248, -25, 547, 376);
		panel.add(lblNewLabel);
		
		txtNeki = new JTextField();
		txtNeki.setBounds(309, 31, 274, 28);
		frame.getContentPane().add(txtNeki);
		txtNeki.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("GMAIL");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(309, 10, 99, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(309, 69, 99, 17);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(309, 88, 274, 28);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("SURNAME");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(309, 126, 99, 17);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(309, 145, 274, 28);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("PASSWORD");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(309, 183, 99, 17);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		final JPasswordField JPasswordField = new JPasswordField(20);
		//JPasswordField.setActionCommand(OK);
		JPasswordField.setColumns(10);
		JPasswordField.setBounds(309, 203, 274, 28);
		frame.getContentPane().add(JPasswordField);
		
		/*textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(309, 203, 274, 28);
		frame.getContentPane().add(textField_2);*/
		
		JLabel lblNewLabel_2 = new JLabel("I already have an account?");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Login LoginScreen = new Login();
				LoginScreen.setVisible(true);
			}
		});
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 8));
		lblNewLabel_2.setBounds(392, 305, 104, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnRegister = new JButton("REGISTER");
		
		
		btnRegister.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				String email = txtNeki.getText();
				String ime = textField.getText();
				String priimek = textField_1.getText();
				char[] pas = JPasswordField.getPassword();
				String geslo = new String(pas);
				//"http://music2go.herokuapp.com/register"
				
				//Connection to API (method=POST)
				final String input = String.format("{\"ime\":\"%s\", \"priimek\":\"%s\", \"email\":\"%s\", \"geslo\":\"%s\"}", ime, priimek, email, geslo);
		        
		        JSONParser parser = new JSONParser();
		        try {JSONObject json = (JSONObject) parser.parse(input);
		        OkHttpClient httpClient = new OkHttpClient();
		        Response response = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/register").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
		        
		        JSONParser parser1 = new JSONParser();
		        JSONObject jsonResult = (JSONObject) parser.parse(response.body().string());
		        
		        //System.out.println(jsonResult.get("bool"));	
		        boolean bool = (boolean) jsonResult.get("bool");
		        if(bool==true) {
					Login LoginScreen = new Login();
					LoginScreen.setVisible(true);
					frame.dispose();
		        }else {
		        	JOptionPane.showMessageDialog(frame,"Error registering!!","Warning",JOptionPane.WARNING_MESSAGE);
		        }
		        
		        }catch(Exception e1) {System.out.println(e1);}
		        					
			}
		});

		btnRegister.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegister.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnRegister.setBackground(new Color(255, 150, 0));
		btnRegister.setBounds(309, 249, 274, 46);
		frame.getContentPane().add(btnRegister);
	}

	public void setVisible(boolean b) {
		Register window = new Register();
		window.frame.setVisible(true);		
	}
}
