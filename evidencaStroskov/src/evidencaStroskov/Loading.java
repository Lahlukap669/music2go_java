package evidencaStroskov;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
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
import java.io.File;

public class Loading {

	JFrame frmLoading;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading window = new Loading();
					window.frmLoading.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loading() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		
		//Icon imgIcon = new ImageIcon(this.getClass().getResource("D:/Desktop/music/1_e_Loq49BI4WmN7o9ItTADg.gif"));
		//JLabel label = new JLabel(imgIcon);
		//label.setBounds(668, 43, 46, 14); // for example, you can use your own values
		//frame.getContentPane().add(label);
		
		frmLoading = new JFrame();
		frmLoading.setTitle("Loading");
		frmLoading.getContentPane().setBackground(new java.awt.Color(18, 7, 36));
		frmLoading.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Wait while your music is being loaded...");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(25, 22, 267, 28);
		frmLoading.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Loading.class.getResource("/images/gif1.gif")));
		lblNewLabel.setBounds(68, 10, 170, 170);
		frmLoading.getContentPane().add(lblNewLabel);
		frmLoading.setBounds(100, 100, 322, 187);
		
		final String input = String.format("{\"name\":\"%s\", \"url\":\"%s\"}", Vars.p_name, Vars.p_url);
        
        JSONParser parser = new JSONParser();
        try {JSONObject json = (JSONObject) parser.parse(input);
        OkHttpClient httpClient = new OkHttpClient();
        Response response = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/download").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
        
        JSONObject jsonResult = (JSONObject) parser.parse(response.body().string());
        
        //System.out.println(jsonResult.get("bool"));	
        boolean bool = (boolean) jsonResult.get("bool");
        if(bool==true) {
        	String link = "http://127.0.0.1:5000"+jsonResult.get("url");
        	System.out.println(link);
        	File out = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory();
        	//String o =  out.replace("\\", "/");
        	Download d1 = new Download(link, out);
        	d1.run();
			Playlists PlaylistsScreen = new Playlists();
			PlaylistsScreen.setVisible(true);
        }else {
        	JOptionPane.showMessageDialog(null ,"Error loading!!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
        }catch(Exception e1) {System.out.println(e1);}
		
	}
	public void setVisible(boolean b) {
		Loading window = new Loading();
		window.frmLoading.setVisible(true);		
	}
}
