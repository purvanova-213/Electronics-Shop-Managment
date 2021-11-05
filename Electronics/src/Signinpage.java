import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JSeparator;


public class Signinpage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEnterName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signinpage frame = new Signinpage();
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
	public Signinpage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Purva Masurkar\\OneDrive - Vidyalankar Institute of Technology\\Documents\\Java Project\\image icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Electronics Shop Managment");
		
		JLabel lblNewLabel = new JLabel("We at Electromate offer quality products Our product range includes Television, AC, \r\n");
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		lblNewLabel.setBounds(84, 92, 661, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Washing Machine and Fan Our doorstep delivery feature ensures  your shopping reaches you safely.\r\n ");
		lblNewLabel_1.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		lblNewLabel_1.setBounds(44, 123, 757, 58);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField.setBackground(new Color(255, 248, 220));
		textField.setText("Enter Email id");
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 220)));
		textField.setBounds(84, 511, 547, 28);
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user, pass;
				user=txtEnterName.getText();
				pass=passwordField .getText();
				if(pass.equals("") || user.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter required information"); 
					 return;
				}
				
				try {
					 Connection conn;
                     PreparedStatement ps;

                     Class.forName("com.mysql.cj.jdbc.Driver");
                     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "Purva12");

					 ps = conn.prepareStatement("insert into login(username,password)values(?,?)");
					 ps.setString(1, user);
					 ps.setString(2, pass);
					 ps.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Signup is done");
					
					 txtEnterName.setText("");
					 passwordField.setText("");
					
					 contentPane.setVisible(false);
					 Loginpage l = new Loginpage();
					 l.setVisible(true);
					
					
				}catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		btnNewButton.setForeground(new Color(248, 248, 255));
		btnNewButton.setBackground(new Color(160, 82, 45));
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnNewButton.setBounds(84, 686, 124, 51);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setText("Enter Address");
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
			}
		});
		textField_1.setBounds(84, 607, 573, 51);
		textField_1.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 220)));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		txtEnterName = new JTextField();
		txtEnterName.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtEnterName.setText("Enter Name");
		txtEnterName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterName.setText("");
			}
		});
		txtEnterName.setBackground(new Color(255, 248, 220));
		txtEnterName.setBounds(84, 314, 547, 28);
		txtEnterName.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 220)));
		contentPane.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("Happy Shopping : )");
		lblNewLabel_2.setFont(new Font("Sitka Banner", Font.BOLD, 19));
		lblNewLabel_2.setBounds(325, 668, 221, 69);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SIGN UP");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_3.setBounds(174, 171, 123, 61);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(124, 258, 96, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(124, 368, 106, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email id");
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(124, 453, 96, 48);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(124, 562, 96, 35);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\_MG_6463_DREAM(12X12).jpg"));
		lblNewLabel_8.setBounds(0, 0, 690, 28);
		contentPane.add(lblNewLabel_8);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		passwordField.setBackground(new Color(255, 248, 220));
		passwordField.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 220)));
		passwordField.setBounds(84, 409, 547, 34);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-showing-small-size-48.png"));
		lblNewLabel_11.setBounds(383, 38, 51, 58);
		contentPane.add(lblNewLabel_11);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(Color.BLACK);
		separator.setBounds(84, 356, 547, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(84, 446, 547, 13);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(84, 550, 547, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(0, 0, 0));
		separator_3.setBounds(81, 668, 573, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-sign-up-64.png"));
		lblNewLabel_12.setBounds(84, 174, 78, 58);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\_MG_6463_DREAM(12X12).jpg"));
		lblNewLabel_9.setBounds(689, 0, 136, 28);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-name-30.png"));
		lblNewLabel_10.setBounds(84, 259, 30, 30);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-password-24.png"));
		lblNewLabel_13.setBounds(84, 371, 30, 28);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-email-24.png"));
		lblNewLabel_14.setBounds(84, 460, 45, 41);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-address-24.png"));
		lblNewLabel_15.setBounds(84, 569, 30, 28);
		contentPane.add(lblNewLabel_15);
	}
}
