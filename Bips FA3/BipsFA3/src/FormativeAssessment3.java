import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class FormativeAssessment3 extends JFrame {

	private JTextField txtPhone;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtSubject;
	private JTextField txtSurname;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormativeAssessment3 frame = new FormativeAssessment3();
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
	public FormativeAssessment3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 625, 422);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel NameLabel = new JLabel("Winter School Booking");
		NameLabel.setFont(new Font("Arial Nova Cond", Font.BOLD | Font.ITALIC, 17));
		NameLabel.setBounds(207, 11, 175, 22);
		panel.add(NameLabel);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel.setBounds(27, 91, 71, 22);
		panel.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblEmail.setBounds(27, 142, 65, 22);
		panel.add(lblEmail);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblSubject.setBounds(27, 198, 71, 22);
		panel.add(lblSubject);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblSurname.setBounds(326, 91, 76, 22);
		panel.add(lblSurname);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblPhone.setBounds(326, 142, 76, 22);
		panel.add(lblPhone);
		
		JButton Exitbtn = new JButton("Exit");
		Exitbtn.setBounds(10, 376, 605, 22);
		panel.add(Exitbtn);
		
		JButton insertBtn = new JButton("Insert");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				String surname = txtSurname.getText();
				String email = txtEmail.getText();
				String phone = txtPhone.getText();
				String subject = txtSubject.getText();
				
				
				try {
					//open connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fa3_assessment","root","");
					Statement st = con.createStatement();

					
					//String sql = "INSERT INTO CLASS5 VALUES('"+name+"','"+surname+"','"+email+"','"+phone+"','"+subject+"')";
					//st.executeUpdate(sql);
					
					// Use prepared statement to avoid SQL injection
					String sql = "INSERT INTO student_booking (FName, LName, Email, Phone, Subject) VALUES (?, ?, ?, ?, ?)";


		            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		                preparedStatement.setString(1, name);
		                preparedStatement.setString(2, surname);
		                preparedStatement.setString(3, email);
		                preparedStatement.setString(4, phone);
		                preparedStatement.setString(5, subject);
					
					
		                // Execute the update
		                preparedStatement.executeUpdate();
		            }

		            con.close();
		        } catch (Exception e1) {
		            e1.printStackTrace();
		            System.out.println(e1.getMessage());
		        
				}
				
			}
		});
		insertBtn.setBounds(10, 329, 89, 23);
		panel.add(insertBtn);
		
		JButton viewBtn = new JButton("View");
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//database connection
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fa3_assessment","root","");
						
						Statement st = con.createStatement();
						
						String sql = "select * from student_booking";
						ResultSet rs = st.executeQuery(sql);
						
						
						while(rs.next()) {
							//data will be added until finished
							String name = rs.getString("FName");
							String Surname = rs.getString("LName");
							String email = rs.getString("Email");
							String phone = rs.getString("Phone");
							String subject = rs.getString("Subject");


							//String array for store data into the table
							
							String tbData[] ={name,Surname,email,phone,subject};
							DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
							
							// add string array to data into jtable
							tblModel.addRow(tbData);
							
							
							
						}
						con.close();
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println(e1.getMessage());
					}
					
			
			}
		});
		viewBtn.setBounds(526, 329, 89, 23);
		panel.add(viewBtn);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Arial", Font.BOLD, 13));
		txtName.setBounds(108, 91, 180, 23);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.BOLD, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(108, 145, 180, 23);
		panel.add(txtEmail);
		
		txtSubject = new JTextField();
		txtSubject.setFont(new Font("Arial", Font.BOLD, 13));
		txtSubject.setColumns(10);
		txtSubject.setBounds(108, 198, 180, 23);
		panel.add(txtSubject);
		
		 txtPhone = new JTextField();
		txtPhone.setFont(new Font("Arial", Font.BOLD, 13));
		txtPhone.setColumns(10);
		txtPhone.setBounds(412, 144, 180, 23);
		panel.add(txtPhone);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Arial", Font.BOLD, 13));
		txtSurname.setColumns(10);
		txtSurname.setBounds(412, 93, 180, 23);
		panel.add(txtSurname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 229, 588, 89);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Surname", "Email", "Phone", "Subject"
			}
		));
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
	}
}
