import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Loginpage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEnterYourUsername;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage frame = new Loginpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loginpage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Purva Masurkar\\OneDrive - Vidyalankar Institute of Technology\\Documents\\Java Project\\image icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1136, 753);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		contentPane.setLayout(null);
		setTitle("Electronics Shop Managment");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 204));
		panel.setBounds(0, 0, 564, 706);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 223, 564, 257);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(153, 204, 204));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\istockphoto-1297978855-612x612.jpg"));
		
		JLabel lblNewLabel_5 = new JLabel("Your One Stop for Home Appliances");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(65, 490, 452, 55);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 250, 250));
		separator.setBounds(65, 554, 426, 31);
		panel.add(separator);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome to Electromate!!");
		lblNewLabel_4.setBounds(132, 135, 301, 31);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(248, 248, 255));
		separator_1.setBounds(116, 576, 317, 25);
		panel.add(separator_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(112, 176, 348, 2);
		panel.add(separator_4);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-technology-128.png"));
		lblNewLabel_9.setBounds(210, 20, 126, 115);
		panel.add(lblNewLabel_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(563, 0, 549, 706);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.setBounds(153, 445, 121, 34);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Signinpage s = new Signinpage();
				s.setVisible(true);
				
				
			}
			
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 206, 209));
		btnNewButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		JLabel lblNewLabel_7 = new JLabel("LOGIN");
		lblNewLabel_7.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		lblNewLabel_7.setForeground(SystemColor.inactiveCaption);
		lblNewLabel_7.setBounds(144, 31, 97, 34);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have an account? Join now");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(154, 401, 356, 34);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(97, 309, 103, 34);
		btnNewButton.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 102)));
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton){
	                  try{
	                	
	                      String username = txtEnterYourUsername.getText();
	                      @SuppressWarnings("deprecation")
						  String Password = passwordField.getText();
	                      Connection conn;
	                      PreparedStatement ps;
	                     

	                      Class.forName("com.mysql.cj.jdbc.Driver");
	                      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "Purva12");

	                      String q1 = "select * from login where username = ? and password = ?";
	                      

	                      ps = conn.prepareStatement(q1);

	                      ps.setString(1,username);
	                      ps.setString(2,Password);

	                      ResultSet rs = ps.executeQuery();

	                      if(rs.next()){
	                          JOptionPane.showMessageDialog(null,"Login Successful","Welcome Customer",JOptionPane.INFORMATION_MESSAGE);
	                          setVisible(false);
	                          MainMenu f=new MainMenu();
	                          f.setVisible(true);
	                      }else{
	                          JOptionPane.showMessageDialog(null,"Incorrect Username or Password","Login Error",JOptionPane.ERROR_MESSAGE);
	                      }
	                  }catch (Exception ae){
	                      ae.printStackTrace();
	                      System.out.println(ae);
	                  }
	              }
	          }
	      });
		
			
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");
			}
		});
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(51, 51, 102));
		passwordField.setBounds(97, 240, 427, 34);
		passwordField.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 102)));
		panel_1.add(passwordField);
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		
		txtEnterYourUsername = new JTextField();
		txtEnterYourUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterYourUsername.setText("");
			}
		});
		txtEnterYourUsername.setText("Enter your Username");
		txtEnterYourUsername.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtEnterYourUsername.setForeground(new Color(255, 255, 255));
		txtEnterYourUsername.setBackground(new Color(51, 51, 102));
		txtEnterYourUsername.setBounds(97, 126, 427, 34);
		txtEnterYourUsername.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 102)));
		panel_1.add(txtEnterYourUsername);
		txtEnterYourUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(97, 209, 111, 21);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(97, 95, 111, 21);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(248, 248, 255));
		separator_2.setBounds(97, 170, 427, 21);
		panel_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(255, 255, 255));
		separator_3.setBounds(97, 284, 427, 31);
		panel_1.add(separator_3);
		
		JButton btnNewButton_2 = new JButton("ADMIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Admin a = new Admin();
				a.setVisible(true);
				
			}
		});
		btnNewButton_2.setBackground(new Color(0, 206, 209));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnNewButton_2.setBounds(166, 599, 121, 34);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("ADMIN LOGIN");
		lblNewLabel_6.setForeground(new Color(255, 250, 250));
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(166, 563, 178, 26);
		panel_1.add(lblNewLabel_6);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(SystemColor.window);
		separator_5.setBounds(154, 433, 356, 2);
		panel_1.add(separator_5);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-small-business-30 (1).png"));
		lblNewLabel_8.setBounds(97, 26, 37, 39);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-admin-64.png"));
		lblNewLabel_10.setBounds(97, 563, 61, 81);
		panel_1.add(lblNewLabel_10);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(166, 588, 144, 2);
		panel_1.add(separator_6);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-add-user-male-50.png"));
		lblNewLabel_11.setBounds(97, 401, 53, 78);
		panel_1.add(lblNewLabel_11);
	}

	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
}
