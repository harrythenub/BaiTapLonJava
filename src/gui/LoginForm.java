package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.NhanVienDAO;
import entity.NhanVien;

public class LoginForm extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JButton btnExit, btnLogin,btnRepair;
	
	
	public LoginForm() {
		
		setTitle("Đăng nhập");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(510, 350);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblTopTitle  = new JLabel("Đăng Nhập");
		lblTopTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTopTitle.setForeground(Color.decode("#2c3e50"));
		lblTopTitle.setBounds(80,20,200,40);
		add(lblTopTitle);
//		mainPanel.add(lblTopTitle);
		
//		lbl user name
		lblUserName = new JLabel("Tài khoản:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setForeground(Color.decode("#1abc9c"));
		lblUserName.setBounds(80, 80, 290, 34);
		add(lblUserName);
		
//		txt user name
		add(txtUserName = new JTextField(20));
		txtUserName.addActionListener(this);
		txtUserName.setBounds(80, 110, 340, 34);
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
//		lbl password 
		lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setForeground(Color.decode("#1abc9c"));
		lblPassword.setBounds(80, 150, 290, 34);
		add(lblPassword);
		
//		txt password
		add(txtPassword = new JPasswordField(20));
		txtPassword.setEchoChar('●');
		txtPassword.addActionListener(this);
		txtPassword.setBounds(80, 180, 340, 34);
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		add(btnRepair = new JButton("Đổi mật khẩu"));
		btnRepair.setFocusable(false);
		btnRepair.setPreferredSize(new Dimension(150,30));
		btnRepair.setBounds(80, 240, 120, 34);
		
		add(btnLogin = new JButton("Đăng nhập"));
		btnLogin.setFocusable(false);
		btnLogin.setPreferredSize(new Dimension(150,30));
		btnLogin.setBounds(80 +130, 240, 100, 34);
		
		
		
		add(btnExit = new JButton("Thoát"));
		btnExit.setFocusable(false);
		btnExit.setPreferredSize(new Dimension(75,30));
		btnExit.setBounds(190+130, 240, 100, 34);
		
		
		txtUserName.setText("19524691");
		txtPassword.setText("123456");
		
		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
		btnRepair.addActionListener(this);
		setVisible(true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnLogin) || e.getSource().equals(txtUserName) || e.getSource().equals(txtPassword))
		{
			if(checkAccount(txtUserName.getText(), txtPassword.getText()))
			{
				NhanVien nv = null;
				try {
					nv = new NhanVienDAO().getEmployeeByID(txtUserName.getText());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				new frame_appControl(nv);
				this.dispose();
			}
			else
				showMessage("Opps! Something went wrong!");
		}
		else if(e.getSource().equals(btnRepair))
		{
			new frame_ChangePass();
		}
		else
		{
			System.exit(0);
		}
			
	}
	
	private boolean checkAccount(String user, String pass) {
		NhanVien nv = null;
		
		try {
			
			nv = new NhanVienDAO().getEmployeeByID(user);
//			
//			if(nv == null) {
//				return false;
//			}
//			
//			u = nv.getMaNhanVien();
//			pass = nv.getMatKhau();
			
		} catch (SQLException e) {
//			return false;
		}
		return nv.getMaNhanVien().trim().equals(user) && nv.getMatKhau().trim().equals(pass);
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
}