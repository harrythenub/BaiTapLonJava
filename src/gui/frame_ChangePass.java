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

public class frame_ChangePass extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblUserName;
	private JLabel lblPasswordOld;
	private JLabel lblPasswordNew;
	private JTextField txtUserName;
	private JPasswordField txtPasswordOld;
	private JPasswordField txtPasswordNew;
	private JButton btnExit,btnRepair;
	
	public frame_ChangePass() {
		
		setTitle("Đổi mật khẩu");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(510, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblTopTitle  = new JLabel("Đổi mật khẩu");
		lblTopTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTopTitle.setForeground(Color.decode("#2c3e50"));
		lblTopTitle.setBounds(80,20,300,40);
		add(lblTopTitle);
		//	mainPanel.add(lblTopTitle);
		
		//	lbl user name
		lblUserName = new JLabel("Tài khoản:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setForeground(Color.decode("#1abc9c"));
		lblUserName.setBounds(80, 80, 290, 34);
		add(lblUserName);
		
		//	txt user name
		add(txtUserName = new JTextField(20));
		txtUserName.addActionListener(this);
		txtUserName.setBounds(80, 110, 340, 34);
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//	lbl txt passwordOLD
		lblPasswordOld = new JLabel("Mật khẩu cũ:");
		lblPasswordOld.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPasswordOld.setForeground(Color.decode("#1abc9c"));
		lblPasswordOld.setBounds(80, 150, 290, 34);
		add(lblPasswordOld);
		
		txtPasswordOld = new JPasswordField(20);
		txtPasswordOld.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPasswordOld.setForeground(Color.decode("#1abc9c"));
		txtPasswordOld.setBounds(80, 180, 340, 34);
		add(txtPasswordOld);
		
		//	txt password New
		lblPasswordNew = new JLabel("Mật khẩu mới:");
		lblPasswordNew.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPasswordNew.setForeground(Color.decode("#1abc9c"));
		lblPasswordNew.setBounds(80, 220, 290, 34);
		add(lblPasswordNew);
		
		txtPasswordNew = new JPasswordField(20);
		txtPasswordNew.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPasswordNew.setForeground(Color.decode("#1abc9c"));
		txtPasswordNew.setBounds(80, 250, 340, 34);
		add(txtPasswordNew);
		
		
		add(btnRepair = new JButton("Đổi mật khẩu"));
		btnRepair.setFocusable(false);
		btnRepair.setPreferredSize(new Dimension(150,30));
		btnRepair.setBounds(120, 310, 120, 34);
		
		add(btnExit = new JButton("Thoát"));
		btnExit.setFocusable(false);
		btnExit.setPreferredSize(new Dimension(75,30));
		btnExit.setBounds(270, 310, 100, 34);
		
		btnExit.addActionListener(this);
		btnRepair.addActionListener(this);
		
		setVisible(true);
	}
	
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			NhanVien nv = null;
			if(e.getSource().equals(btnRepair)) {
				if(checkAccount(txtUserName.getText())) {
					try {
						nv = new NhanVienDAO().getEmployeeByID(txtUserName.getText());
						System.out.println(nv);
					} catch (Exception e2) {
						// TODO: handle exception
						
					}
					if(regex()) {
						nv.setMatKhau(txtPasswordNew.getText());
						try {
							new NhanVienDAO().updateEmployeeInfoByID(txtUserName.getText(), nv);
							nv = new NhanVienDAO().getEmployeeByID(txtUserName.getText());
						} catch (Exception e2) {
							// TODO: handle exception
						}
						if(nv.getMatKhau().equals(txtPasswordNew.getText())) {
							showMessage("doi mk thanh cong");
							this.dispose();
						}
					}
				}
				else {
					showMessage("Tài khoản không hợp lệ");
				}
			}
			else {
				this.dispose();
			}
		}
		
		private boolean checkAccount(String user) {
			NhanVien nv = null;
			System.out.println(user);
			try {
				
				nv = new NhanVienDAO().getEmployeeByID(user);
				
				if(nv == null) {
					return false;
				}
//				
//				u = nv.getMaNhanVien();
//				pass = nv.getMatKhau();
				
			} catch (SQLException e) {
//				return false;
			}
			return nv.getMaNhanVien().trim().equals(user);
		}
		
		private void showMessage(String msg) {
			JOptionPane.showMessageDialog(null, msg);
		}
		
		@SuppressWarnings("deprecation")
		private boolean regex() {
			if(txtUserName.getText().trim().equals("")||txtPasswordNew.getText().trim().equals("")||txtPasswordOld.getText().trim().equals("")) {
				showMessage("Không được để trống");
				return false;
			}
			NhanVien nv = null;
			if(checkAccount(txtUserName.getText())) {
				try {
					nv = new NhanVienDAO().getEmployeeByID(txtUserName.getText());
				} catch (Exception e) {
					// TODO: handle exception
					return false;
				}
				if(!txtPasswordOld.getText().equals(nv.getMatKhau())) {
					showMessage("Mật khẩu cũ không hợp lệ");
					return false;
				}
			}
			if(!txtPasswordNew.getText().matches("[\\w]{6,}")) 
			{
				showMessage("Mật khẩu không được chứa kí tự đặc biệt");
				return false;
			}
			return true;
		}
}
