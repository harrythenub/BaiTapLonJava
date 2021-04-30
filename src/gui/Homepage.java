package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Homepage extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public Homepage() {
		
		setTitle("Demo Quản lý mua bán linh Kiện");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);
		JLabel lbl = new JLabel("Welcome Híu");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
}