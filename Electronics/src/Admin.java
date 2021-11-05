import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtEnterAdminUsername;
	private JPasswordField passwordField;
	private JPanel panel;
	private JSeparator separator;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin  frame = new Admin ();
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
	public Admin () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Electronics Shop Managment");
		contentPane.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(128, 193, 550, 344);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setColumnHeaderView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(51, 102, 153));
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					 String userValue = txtEnterAdminUsername.getText();        
				     String passValue = passwordField.getText();       
				          
				        //check whether the credentials are authentic or not  
				     if (userValue.equals("Admin") && passValue.equals("123"))
				     {
				    	 
						    Connection conn;
		                    PreparedStatement ps;
		                    ResultSet rs;

		                    Class.forName("com.mysql.cj.jdbc.Driver");
		                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "Purva12");

							 String q1 = "select * from store";
							 ps = conn.prepareStatement(q1);
							 rs= ps.executeQuery(q1);
							 table.setModel(DbUtils.resultSetToTableModel(rs));
					 }	
					 else
						 JOptionPane.showMessageDialog(null,"Login Unsuccessful",null,JOptionPane.INFORMATION_MESSAGE);
					
				}catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
	
		btnNewButton.setBounds(334, 587, 145, 39);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 786, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(59, 159, 281, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(545, 159, 231, 2);
		panel.add(separator_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-name-30.png"));
		lblNewLabel_3.setBounds(59, 74, 38, 42);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(95, 77, 105, 39);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-password-24.png"));
		lblNewLabel_4.setBounds(545, 74, 24, 42);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(579, 74, 105, 42);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-admin-64.png"));
		lblNewLabel_5.setBounds(228, 10, 67, 64);
		panel.add(lblNewLabel_5);
		
		txtEnterAdminUsername = new JTextField();
		txtEnterAdminUsername.setText("Enter Admin Username");
		txtEnterAdminUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterAdminUsername.setText("");
			}
		});
		txtEnterAdminUsername.setForeground(new Color(255, 255, 255));
		txtEnterAdminUsername.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtEnterAdminUsername.setBounds(59, 110, 260, 39);
		panel.add(txtEnterAdminUsername);
		txtEnterAdminUsername.setBackground(new Color(70, 130, 180));
		txtEnterAdminUsername.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));
		txtEnterAdminUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 18));		
		passwordField.setBounds(545, 110, 184, 39);
		panel.add(passwordField);
		passwordField.setBackground(new Color(70, 130, 180));
		passwordField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(322, 68, 202, 2);
		panel.add(separator_2);
		
		lblNewLabel = new JLabel("Admin login");
		lblNewLabel.setBounds(354, 19, 138, 39);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
	}
}
