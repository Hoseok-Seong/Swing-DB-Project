package com.project.ViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.project.controller.UserController;
import com.project.dto.UserDTO;

public class UserJoinView extends JFrame implements ActionListener {
	
	public JTextField getUsername() {
		return username;
	}

	public JTextField getPassword() {
		return password;
	}
	
	public JTextField getMyName() {
		return name;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getPhone() {
		return phone;
	}

	public JTextField getAddress() {
		return address;
	}
	
	// 버튼
	public JButton getJoinButton() {
		return joinButton;
	}

	private JButton joinButton;
	private JTextField username;
	private JTextField name;
	private JTextField password;
	private JTextField email;
	private JTextField phone;
	private JTextField address;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JLabel emailLabel;
	private JLabel phoneLabel;
	private JLabel addressLabel;
	


	public UserJoinView() {
		initData();
		setInitLayout();
		joinButton.addActionListener(this); // 로그인 버튼에 ActionListener 추가
	}
	
	private void initData() {
		// 가입하기 버튼
		joinButton = new JButton("가입하기");
		joinButton.setSize(100, 30);
		joinButton.setLocation(100, 280);
		
		// Id 입력창 
		username = new JTextField();
		username.setSize(150, 30);
		username.setLocation(110, 30);
		
		idLabel = new JLabel("아이디");
		idLabel.setSize(50,30);
		idLabel.setLocation(50, 30);
		
		// 이름 입력창
		name = new JTextField();
		name.setSize(150, 30);
		name.setLocation(110, 70);
		
		nameLabel = new JLabel("이름");
		nameLabel.setSize(50,30);
		nameLabel.setLocation(50,70);
		
		// password 입력창
		password = new JTextField();
		password.setSize(150, 30);
		password.setLocation(110, 110);
		
		passwordLabel = new JLabel("비밀번호");
		passwordLabel.setSize(50,30);
		passwordLabel.setLocation(50,110);
		
		// 이메일 입력창
		email = new JTextField();
		email.setSize(150, 30);
		email.setLocation(110, 150);
		
		emailLabel = new JLabel("이메일");
		emailLabel.setSize(50,30);
		emailLabel.setLocation(50,150);
		
		// 전화번호 입력창
		phone = new JTextField();
		phone.setSize(150, 30);
		phone.setLocation(110, 190);
		
		phoneLabel = new JLabel("전화번호");
		phoneLabel.setSize(50,30);
		phoneLabel.setLocation(50,190);
	
		// 주소 입력창
		address = new JTextField();
		address.setSize(150, 30);
		address.setLocation(110,230);
		
		addressLabel = new JLabel("주소");
		addressLabel.setSize(50,30);
		addressLabel.setLocation(50,230);
	}
	
	
	private void setInitLayout() {
		setLayout(null);
		add(joinButton);
		add(username);
		add(name);
		add(password);
		add(email);
		add(phone);
		add(address);
		add(idLabel);
		add(nameLabel);
		add(passwordLabel);
		add(emailLabel);
		add(phoneLabel);
		add(addressLabel);
		setSize(300, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String username = getUsername().getText();
		String name = getMyName().getText();
		String password = getPassword().getText();
		String email = getEmail().getText();
		String phone = getPhone().getText();
		String address = getAddress().getText();
		
		UserDTO dto = new UserDTO(username, name, password, email, phone, address);
		UserController controller = new UserController();
		String result2 = controller.join(dto, "localhost");
		System.out.println(result2);
	}
	

}