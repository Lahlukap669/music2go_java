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

public class Songs {

	JFrame frmSongs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Songs window = new Songs();
					window.frmSongs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Songs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSongs = new JFrame();
		frmSongs.setTitle("Songs");
		frmSongs.getContentPane().setBackground(Color.BLACK);
		frmSongs.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SONGS:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 10, 99, 17);
		frmSongs.getContentPane().add(lblNewLabel_1);
		
		
		
		JButton btnDelete_1 = new JButton("BACK");
		btnDelete_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmSongs.dispose();
			}
		});
		btnDelete_1.setHorizontalAlignment(SwingConstants.CENTER);
		btnDelete_1.setForeground(Color.LIGHT_GRAY);
		btnDelete_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnDelete_1.setBackground(new Color(34, 139, 34));
		btnDelete_1.setBounds(20, 236, 266, 46);
		frmSongs.getContentPane().add(btnDelete_1);
		
		
		
		DefaultListModel<String> data_list = new DefaultListModel<String>();
		//List<String> data_list = new ArrayList<>();
		final JList list = new JList(data_list);
		list.setBackground(new Color(128, 128, 128));
		list.setBounds(20, 32, 266, 199);
		frmSongs.getContentPane().add(list);
		
		String idd = Vars.pid;
		
		final String input = String.format("{\"id\":%s}", idd);
        
        JSONParser parser = new JSONParser();
        try {       	
	        OkHttpClient httpClient = new OkHttpClient();
	        Response response = httpClient.newCall(new Request.Builder().addHeader("Content-Type", "application/json").url("http://127.0.0.1:5000/songs").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),input)).build()).execute();
	        
	        JSONObject jsonResult = (JSONObject) parser.parse(response.body().string());
	        
	        //Vars sp1 = new Vars(user_id, user_ime, user_priimek, user_email, user_geslo, user_admin);
	        Long in1 = (Long) jsonResult.get("count");
	        Integer size = jsonResult.get("count") != null ? in1.intValue() : null;
	        JSONArray jsonArray = (JSONArray)jsonResult.get("playlists");
	        //Iterator<String> iterator = jsonArray.iterator();
	         /*while(iterator.hasNext()) {
	            System.out.println(iterator.next());
	            data_list.addElement(iterator.next());
	         }*/
	        //System.out.println();
	        for(int i=0; i<size; i++) {
	        	//String element = jsonArray.get(i);
	        	JSONObject element = (JSONObject)jsonArray.get(i);
	        	String id =  "" + element.get("id");
	        	data_list.addElement(id+"  "+(String)element.get("ime"));
	        	
	        }
	        //String playlist = jsonResult.get("id")
	        			        
	        //System.out.println(sp1.ime());
	        boolean bool = (boolean) jsonResult.get("bool");
	        if(bool==true){
				//
	        }else {
	        	JOptionPane.showMessageDialog(frmSongs,"Username or password incorrect!!","Warning",JOptionPane.WARNING_MESSAGE);
	        }
	        
        }catch(Exception e1) {System.out.println("exception: "+e1);}
		
		JLabel lblNewLabel_1_1 = new JLabel("Playlist: ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 9));
		lblNewLabel_1_1.setBounds(111, 10, 99, 17);
		frmSongs.getContentPane().add(lblNewLabel_1_1);
        
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Songs.class.getResource("/images/bg2.jpg")));
		lblNewLabel.setBounds(140, 37, 566, 346);
		frmSongs.getContentPane().add(lblNewLabel);
		frmSongs.setBounds(100, 100, 316, 329);
		
		
	}
	public void setVisible(boolean b) {
		Songs window = new Songs();
		window.frmSongs.setVisible(true);		
	}
}
