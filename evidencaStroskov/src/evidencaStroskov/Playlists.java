package evidencaStroskov;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Playlists {

	JFrame frmPlaylists;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Playlists window = new Playlists();
					window.frmPlaylists.setVisible(true);
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
		frmPlaylists = new JFrame();
		frmPlaylists.setTitle("Playlists");
		frmPlaylists.getContentPane().setBackground(Color.BLACK);
		frmPlaylists.getContentPane().setLayout(null);
		
		JLabel bigname = new JLabel(Vars.user_ime + " " + Vars.user_priimek);
		bigname.setForeground(Color.WHITE);
		bigname.setBackground(Color.BLACK);
		bigname.setBounds(118, 316, 99, 17);
		frmPlaylists.getContentPane().add(bigname);
		
		JLabel lblNewLabel_1 = new JLabel("PLAYLISTS:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(130, 10, 99, 17);
		frmPlaylists.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 99, 335);
		frmPlaylists.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main MainScreen = new Main();
				MainScreen.setVisible(true);
				frmPlaylists.dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon(Playlists.class.getResource("/images/url2.png")));
		btnNewButton.setBounds(20, 10, 79, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Nothing since we already clicked
			}
		});
		btnNewButton_1.setSelected(true);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon(Playlists.class.getResource("/images/playlist2.png")));
		btnNewButton_1.setBounds(20, 90, 79, 70);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Settings SettingsScreen = new Settings();
				SettingsScreen.setVisible(true);
				frmPlaylists.dispose();
			}
		});
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(Playlists.class.getResource("/images/settings2.png")));
		btnNewButton_2.setBounds(20, 244, 79, 70);
		panel.add(btnNewButton_2);
		
		
		
		
		
		
		
		DefaultListModel<String> data_list = new DefaultListModel<String>();
		//List<String> data_list = new ArrayList<>();
		final JList list = new JList(data_list);
		list.setBackground(new Color(128, 128, 128));
		list.setBounds(119, 37, 266, 199);
		frmPlaylists.getContentPane().add(list);
		
		String email = Vars.user_email;
		
		final String input = String.format("{\"email\":\"%s\"}", email);
        
        JSONParser parser = new JSONParser();
        try {       	
	        OkHttpClient httpClient = new OkHttpClient();
	        Response response = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/playlists").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
	        
	        JSONObject jsonResult = (JSONObject) parser.parse(response.body().string());
	        
	        
	        //CONNECTION API 2

	        Response response1 = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/userinfo").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
	        
	        JSONObject jsonResult1 = (JSONObject) parser.parse(response1.body().string());
	        //Vars sp1 = new Vars(user_id, user_ime, user_priimek, user_email, user_geslo, user_admin);
	        Long in1 = (Long) jsonResult.get("count");
	        Integer size = jsonResult.get("count") != null ? in1.intValue() : null;
	        JSONArray jsonArray = (JSONArray)jsonResult.get("playlists");
	        //Iterator<String> iterator = jsonArray.iterator();
	         /*while(iterator.hasNext()) {
	            System.out.println(iterator.next());
	            data_list.addElement(iterator.next());
	         }*/
	        System.out.println();
	        for(int i=0; i<size; i++) {
	        	//String element = jsonArray.get(i);
	        	JSONObject element = (JSONObject)jsonArray.get(i);
	        	String id =  "" + element.get("id");
	        	data_list.addElement(id+"  "+(String)element.get("name")+"  "+(String)element.get("url")+"  "+(String)element.get("opis"));
	        	
	        }
	        //String playlist = jsonResult.get("id")
	        			        
	        //System.out.println(sp1.ime());
	        boolean bool = (boolean) jsonResult.get("bool");
	        if(bool==true){
				Main MainScreen = new Main();
				MainScreen.setVisible(true);
				frmPlaylists.dispose();
	        }else {
	        	JOptionPane.showMessageDialog(frmPlaylists,"Username or password incorrect!!","Warning",JOptionPane.WARNING_MESSAGE);
	        }
	        
        }catch(Exception e1) {System.out.println("exception: "+e1);}
		
        JButton btnDelete = new JButton("DELETE");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = (String)list.getSelectedValue();
				String[] arrOfStr = selected.split("  ", 3);
				System.out.println(arrOfStr[0]);
				
				final String input = String.format("{\"id\":%s}", arrOfStr[0]);
		        
		        JSONParser parser = new JSONParser();
		        try {       	
			        OkHttpClient httpClient = new OkHttpClient();
			        Response response = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/del_playlist").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
			        
			        JSONObject jsonResult = (JSONObject) parser.parse(response.body().string());
			        			        
			        boolean bool = (boolean) jsonResult.get("bool");
			        if(bool==true){
						Playlists PlaylistScreen = new Playlists();
						PlaylistScreen.setVisible(true);
						frmPlaylists.dispose();
			        }else {
			        	JOptionPane.showMessageDialog(frmPlaylists,"Username or password incorrect!!","Warning",JOptionPane.WARNING_MESSAGE);
			        }
			        
		        }catch(Exception e1) {System.out.println("exception: "+e1);}
			}
		});
		
		
		btnDelete.setHorizontalAlignment(SwingConstants.CENTER);
		btnDelete.setForeground(Color.LIGHT_GRAY);
		btnDelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnDelete.setBackground(new Color(34, 139, 34));
		btnDelete.setBounds(210, 260, 81, 46);
		frmPlaylists.getContentPane().add(btnDelete);
		JButton btnLogin = new JButton("EDIT");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = (String)list.getSelectedValue();
				String[] arrOfStr = selected.split("  ", 3);
				Vars.pid = arrOfStr[0];
				Update_playlist playlistwindow = new Update_playlist();
				playlistwindow.setVisible(true);
				frmPlaylists.dispose();
				
			}
		});
		btnLogin.setForeground(new Color(192, 192, 192));
		btnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(34, 139, 34));
		btnLogin.setBounds(119, 260, 81, 46);
		frmPlaylists.getContentPane().add(btnLogin);
        
		JButton btnDelete_1 = new JButton("SONGS");
		btnDelete_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = (String)list.getSelectedValue();
				String[] arrOfStr = selected.split("  ", 3);
				Vars.pid = arrOfStr[0];
				Songs SongScreen = new Songs();
				SongScreen.setVisible(true);
			}
		});
		btnDelete_1.setHorizontalAlignment(SwingConstants.CENTER);
		btnDelete_1.setForeground(Color.LIGHT_GRAY);
		btnDelete_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnDelete_1.setBackground(new Color(34, 139, 34));
		btnDelete_1.setBounds(301, 260, 81, 46);
		frmPlaylists.getContentPane().add(btnDelete_1);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Playlists.class.getResource("/images/bg2.jpg")));
		lblNewLabel.setBounds(140, 37, 566, 346);
		frmPlaylists.getContentPane().add(lblNewLabel);
		frmPlaylists.setBounds(100, 100, 631, 375);
		
		
	}
	public void setVisible(boolean b) {
		Playlists window = new Playlists();
		window.frmPlaylists.setVisible(true);		
	}
}
