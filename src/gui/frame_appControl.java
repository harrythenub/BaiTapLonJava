package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Base64.Decoder;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import entity.NhanVien;

public class frame_appControl extends JFrame implements ActionListener,MouseListener {

	private JPanel infoCurNhanvien;
	private JTabbedPane tablePane;
	private JLabel lblDangXuat;
	
	
	public frame_appControl(NhanVien nv) {
		// TODO Auto-generated constructor stub
		setTitle("Quản Lý mua bán linh kiện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#c8ddf2"));
		
		JPanel infoCurNhanvien = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		infoCurNhanvien.setLayout(null);
		
		JPanel infoCurNhanvienR = new JPanel();
		infoCurNhanvienR.setBackground(Color.decode("#c8ddf2"));
		infoCurNhanvienR.setLayout(new BoxLayout(infoCurNhanvienR, BoxLayout.X_AXIS));
		
		
		JLabel tenNV = new JLabel("Nhân viên : " + nv.getHoTen());
		tenNV.setIcon(new ImageIcon(frame_appControl.class.getResource("/img/baseline_portrait_white_36dp.png")));
		tenNV.setFont(new Font("Tahoma",Font.BOLD, 16));
		tenNV.setForeground(Color.decode("#e84118"));
		

		lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.setIcon(new ImageIcon(frame_appControl.class.getResource("/img/baseline_exit_to_app_white_36dp.png")));
		lblDangXuat.setForeground(Color.decode("#e84118"));
		lblDangXuat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDangXuat.setFont(new Font("Tahoma",Font.BOLD, 16));
		
		
		infoCurNhanvienR.add(tenNV);
		infoCurNhanvienR.add(Box.createHorizontalStrut(20));
		infoCurNhanvienR.add(lblDangXuat);
		
		
		infoCurNhanvien.add(infoCurNhanvienR);
		infoCurNhanvien.setBackground(Color.decode("#c8ddf2"));
		add(infoCurNhanvien,BorderLayout.NORTH);
		
		
//		JPanel mainWork = new JPanel();
		tablePane = new JTabbedPane();
		
		tablePane.addTab("Trang Chủ", new ImageIcon(frame_appControl.class.getResource("/img/baseline_home_white_36dp.png")),
				new JLabel("Trang chủ"));
		tablePane.addTab("Hóa Đơn", new ImageIcon(frame_appControl.class.getResource("/img/baseline_receipt_long_white_36dp.png")),
				new JLabel("Hóa Đơn"));
		tablePane.addTab("Khách Hàng", new ImageIcon(frame_appControl.class.getResource("/img/baseline_supervisor_account_white_36dp.png")),
				new JLabel("Khách Hàng"));
		tablePane.addTab("Linh Kiện", new ImageIcon(frame_appControl.class.getResource("/img/baseline_devices_other_white_36dp.png")),
				new JLabel("Linh Kiện"));
		tablePane.addTab("Nhân Viên", new ImageIcon(frame_appControl.class.getResource("/img/baseline_portrait_white_36dp.png")),
				new JLabel("Nhân Viên"));
		
		tablePane.setBackground(Color.decode("#1abc9c"));
		tablePane.setForeground(Color.white);
		tablePane.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
//		mainWork.setBounds(0,200, 1300, 500);
//		mainWork.add(tablePane);
		add(tablePane,BorderLayout.CENTER);
		

		setVisible(true);
		
		lblDangXuat.addMouseListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		new LoginForm();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
