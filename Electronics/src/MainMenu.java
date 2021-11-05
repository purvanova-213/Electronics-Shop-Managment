import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField add;
	private JTextField phno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	ResultSet rs; 
	Connection con;
	PreparedStatement pst;
	
	public void Connect() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "Purva12");
			
		}catch(ClassNotFoundException ex){
			
		}catch(SQLException ex) {
			
		}
	}
	
	public void table_load() {
		try {
            String username, phone, address,prod,m,p;
            
			
			username=name.getText();
			phone=phno.getText();
			address=add.getText();
			prod=product;
			m=model;
			p=price;
			pst = con.prepareStatement("Select * from store where name = ?,phone_no = ?,address = ?,product=?, model= ?,price= ?");
			pst.setString(1, username);
		    pst.setString(2, phone);
			pst.setString(3, address);
			pst.setString(4, prod);
	        pst.setString(5, m);
		    pst.setString(6, p);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next() ==true) {
				//table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			else
				JOptionPane.showMessageDialog(null, "not found");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	String product;
	String model;
	String username, phone, address;
	String price;
	public MainMenu() {
		Connect();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Purva Masurkar\\Downloads\\icons8-appliances-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 774);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Electronics Shop Managment");
		
		JLabel lblNewLabel_1 = new JLabel("Fans");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_1.setBounds(66, 67, 89, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ACs");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_2.setBounds(333, 67, 69, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Television");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_3.setBounds(571, 67, 155, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Washing Machines\r\n");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_4.setBounds(801, 59, 187, 52);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Electomate Turbospeed");
		rdbtnNewRadioButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()==true) {
					  product="fans"; 
					  model ="Electomate Turbospeed";
					  price="Rs 10000";
				}
				
				}
		});
		
		rdbtnNewRadioButton.setBounds(6, 122, 228, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Light-In Ceiling Fan");
		rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()==true) {
					  product="fans"; 
					  model ="Light-In Ceiling Fan";
					  price="Rs 18000";
				}
				 
			}
		});
		rdbtnNewRadioButton_1.setBounds(6, 275, 228, 28);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Electromate Split AC");
		rdbtnNewRadioButton_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_2.isSelected()==true) {
					  product="AC"; 
					  model ="Electromate Split AC";
					  price="Rs 40000";
				}
			}
		});
		rdbtnNewRadioButton_2.setBounds(262, 116, 232, 32);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Electromate Window AC");
		rdbtnNewRadioButton_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_3.isSelected()==true) {
					  product="AC"; 
					  model ="Electromate Window AC";
					  price="Rs 45000";
				}
			}
		});
		rdbtnNewRadioButton_3.setBounds(262, 272, 232, 34);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Electromate LED");
		rdbtnNewRadioButton_4.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_4.isSelected()==true) {
					  product="TV"; 
					  model ="Electromate LED";
					  price="Rs 60000";
				}
			}
		});
		rdbtnNewRadioButton_4.setBounds(551, 114, 175, 32);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Electromate LCD");
		rdbtnNewRadioButton_5.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_5.isSelected()==true) {
					  product="TV"; 
					  model ="Electromate LCD";
					  price="Rs 65000";
				}
			}
		});
		rdbtnNewRadioButton_5.setBounds(551, 272, 181, 34);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Electromate Front-Load");
		rdbtnNewRadioButton_6.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		rdbtnNewRadioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_6.isSelected()==true) {
					  product="Washing Machine"; 
					  model ="Electromate Front-Load";
					  price="Rs 35000";
				}
			}
		});
		rdbtnNewRadioButton_6.setBounds(811, 117, 216, 36);
		contentPane.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Electromate Top-Load");
		rdbtnNewRadioButton_7.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		rdbtnNewRadioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_7.isSelected()==true) {
					  product="Washing Machine"; 
					  model ="model2";
					  price="Rs 37000";
				}
			}
		});
		rdbtnNewRadioButton_7.setBounds(801, 272, 216, 34);
		contentPane.add(rdbtnNewRadioButton_7);
		
		JLabel lblNewLabel_6 = new JLabel("Name");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_6.setBounds(66, 438, 89, 27);
		contentPane.add(lblNewLabel_6);
		
		name = new JTextField();
		name.setBackground(new Color(255, 240, 245));
		name.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		name.setBorder(BorderFactory.createLineBorder(new Color(255, 240, 245)));
		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});
		name.setBounds(32, 475, 299, 30);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Phone Number");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_7.setBounds(66, 529, 166, 27);
		contentPane.add(lblNewLabel_7);
		
		add = new JTextField();
		add.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		add.setBackground(new Color(255, 240, 245));
		add.setBorder(BorderFactory.createLineBorder(new Color(255, 240, 245)));
		
		add.setBounds(24, 675, 443, 32);
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add.setText("");
			}
		});
		contentPane.add(add);
		add.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_8.setBounds(66, 638, 155, 27);
		contentPane.add(lblNewLabel_8);
		
		phno = new JTextField();
		phno.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		phno.setBackground(new Color(255, 240, 245));
		phno.setBounds(24, 561, 334, 37);
		phno.setBorder(BorderFactory.createLineBorder(new Color(255, 240, 245)));
		phno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				phno.setText("");
			}
		});
		contentPane.add(phno);
		phno.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String username, phone, address,prod,m,p;
				
				username=name.getText();
				phone=phno.getText();
				address=add.getText();
				prod=product;
				m=model;
				p=price;
				if(username.equals("") || phone.equals("")|| address.equals("")|| prod.equals("")|| m.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter required information"); 
					 return;
				}
				
				try {
					 Connection conn;
                     PreparedStatement ps;

                     Class.forName("com.mysql.cj.jdbc.Driver");
                     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "Purva12");

					 ps = conn.prepareStatement("insert into store(name,phone_no,address,product,model,price)values(?,?,?,?,?,?)");
					 ps.setString(1, username);
					 ps.setString(2, phone);
					 ps.setString(3, address);
					 ps.setString(4, prod);
					 ps.setString(5, m);
					 ps.setString(6, p);
					
					 //JLabel textPane = null;
					//textPane.setText("Name-:"+username+"Phone no-:"+phone+"Address-:"+address+"Product Selected-:"+prod+"Model selected-:"+m+"Price-:"+p);
					 
					 
					 
					 
					 ps.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Thank you for shopping, delivery will arrive in 2-3 business days at your doorstep");
					 setVisible(false);
                     thanks f=new thanks();
                     f.setVisible(true);
					 table_load();
					
					
				}catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
				
				
		
		btnNewButton.setBounds(635, 550, 352, 58);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_13 = new JLabel("Price= 10k");
		lblNewLabel_13.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_13.setBounds(54, 166, 101, 26);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Price=18k");
		lblNewLabel_14.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_14.setBounds(64, 329, 129, 21);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Price=40k\r\n");
		lblNewLabel_15.setForeground(new Color(0, 0, 0));
		lblNewLabel_15.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_15.setBounds(316, 157, 112, 45);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Price=45k\r\n");
		lblNewLabel_16.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_16.setBounds(310, 321, 118, 37);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Price=60k");
		lblNewLabel_17.setForeground(new Color(0, 0, 0));
		lblNewLabel_17.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_17.setBounds(573, 157, 118, 33);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Price=66k");
		lblNewLabel_18.setForeground(new Color(0, 0, 0));
		lblNewLabel_18.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_18.setBounds(573, 323, 98, 37);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Price=35k");
		lblNewLabel_19.setForeground(new Color(0, 0, 0));
		lblNewLabel_19.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_19.setBounds(849, 160, 112, 39);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Price=37k");
		lblNewLabel_20.setForeground(new Color(0, 0, 0));
		lblNewLabel_20.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_20.setBounds(849, 324, 112, 34);
		contentPane.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("New label");
		lblNewLabel_21.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\blur-shopping-mall_1203-8327.jpg"));
		lblNewLabel_21.setBounds(0, 68, 627, 360);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("New label");
		lblNewLabel_22.setForeground(new Color(75, 0, 130));
		lblNewLabel_22.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\blur-shopping-mall_1203-8327.jpg"));
		lblNewLabel_22.setBounds(625, 68, 421, 360);
		contentPane.add(lblNewLabel_22);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 609, 336, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.activeCaption);
		separator_2.setForeground(SystemColor.activeCaption);
		separator_2.setBounds(19, 706, 448, 21);
		contentPane.add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 509, 336, 9);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-fan-64.png"));
		lblNewLabel.setBounds(65, 0, 63, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-ac-64 (1).png"));
		lblNewLabel_5.setBounds(316, 14, 83, 57);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-tv-64.png"));
		lblNewLabel_9.setBounds(585, 0, 69, 71);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-washing-machine-64.png"));
		lblNewLabel_10.setBounds(879, 6, 69, 58);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-name-30.png"));
		lblNewLabel_11.setBounds(22, 438, 33, 28);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-address-24.png"));
		lblNewLabel_12.setBounds(24, 638, 33, 28);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon("C:\\Users\\Purva Masurkar\\Downloads\\icons8-phone-30.png"));
		lblNewLabel_23.setBounds(22, 528, 33, 28);
		contentPane.add(lblNewLabel_23);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(6, 437, 496, 290);
		contentPane.add(panel);
		table_load();
	}
}
