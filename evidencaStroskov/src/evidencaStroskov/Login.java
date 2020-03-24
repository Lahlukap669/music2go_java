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
import javax.swing.JPasswordField;
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

public class Login {

	JFrame frame;
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
		
		final JPasswordField JPasswordField = new JPasswordField(20);
		//JPasswordField.setActionCommand(OK);
		JPasswordField.setColumns(10);
		JPasswordField.setBounds(309, 156, 274, 28);
		frame.getContentPane().add(JPasswordField);
		
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
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = textField.getText();
				char[] pas = JPasswordField.getPassword();
				String geslo = new String(pas);
				//"http://music2go.herokuapp.com/register"
				
				//Connection to API (method=POST)
				final String input = String.format("{\"email\":\"%s\", \"geslo\":\"%s\"}", email, geslo);
		        
		        JSONParser parser = new JSONParser();
		        try {
			        OkHttpClient httpClient = new OkHttpClient();
			        Response response = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/login").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
			        
			        JSONObject jsonResult = (JSONObject) parser.parse(response.body().string());
			        
			        
			        //CONNECTION API 2
	
			        Response response1 = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/userinfo").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
			        
			        JSONObject jsonResult1 = (JSONObject) parser.parse(response1.body().string());
			        //Vars sp1 = new Vars(user_id, user_ime, user_priimek, user_email, user_geslo, user_admin);
			        
			        Vars.user_id = (Long) jsonResult1.get("id");
			        Vars.user_ime = (String) jsonResult1.get("ime");
			        Vars.user_priimek = (String) jsonResult1.get("priimek");
			        Vars.user_email = (String) jsonResult1.get("email");
			        Vars.user_geslo = (String) jsonResult1.get("geslo");
			        Vars.user_admin = (Long) jsonResult1.get("admin");
			        			        
			        //System.out.println(sp1.ime());
			        boolean bool = (boolean) jsonResult.get("bool");
			        if(bool==true){
						Main MainScreen = new Main();
						MainScreen.setVisible(true);
						frame.dispose();
			        }else {
			        	JOptionPane.showMessageDialog(frame,"Username or password incorrect!!","Warning",JOptionPane.WARNING_MESSAGE);
			        }
			        
		        }catch(Exception e1) {System.out.println("exception: "+e1);}
			}
		});
		btnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(255, 150, 0));
		btnLogin.setBounds(309, 199, 274, 46);
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
