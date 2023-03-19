package com.project.ViewFrame;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.project.controller.UserController;
import com.project.dto.UserDTO;

public class UserViewFrame extends JFrame {

	private JButton loginButton;
	private JButton joinButton;
	private JButton deleteButton;

	public JTextField getUsername() {
		return username;
	}

	public JTextField getPassword() {
		return password;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getJoinButton() {
		return joinButton;
	}

	private JTextField username;
	private JTextField password;
	private JLabel idLabel;
	private JLabel passwordLabel;
	private TextArea textArea;

	public TextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}

	public UserViewFrame() {
		initData();
		setInitLayout();
		loginButton.addActionListener(loginButtonListener); // 로그인 버튼에 ActionListener 추가
		joinButton.addActionListener(joinButtonListener);
		deleteButton.addActionListener(deleteButtonListener);
	}

	private void initData() {
		// Set up the login button
		loginButton = new JButton("로그인");
		loginButton.setSize(80, 30);
		loginButton.setLocation(480, 30);

		// 회원가입 버튼
		joinButton = new JButton("회원가입");
		joinButton.setSize(100, 30);
		joinButton.setLocation(570, 100);

		// 삭제 버튼
		deleteButton = new JButton("탙퇴");
		deleteButton.setSize(100, 30);
		deleteButton.setLocation(570, 150);

		// Id 입력창
		username = new JTextField();
		username.setSize(150, 30);
		username.setLocation(100, 30);

		idLabel = new JLabel("아이디");
		idLabel.setSize(50, 30);
		idLabel.setLocation(50, 30);

		// password 입력창
		password = new JTextField();
		password.setSize(150, 30);
		password.setLocation(320, 30);

		passwordLabel = new JLabel("비밀번호");
		passwordLabel.setSize(50, 30);
		passwordLabel.setLocation(260, 30);

		textArea = new TextArea();
		textArea.setSize(500, 400);
		textArea.setLocation(50, 90);
	}

	private void setInitLayout() {
		setLayout(null);
		add(loginButton);
		add(username);
		add(password);
		add(idLabel);
		add(passwordLabel);
		add(joinButton);
		add(deleteButton);
		add(textArea);
		setSize(700, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 회원가입
	ActionListener joinButtonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			UserJoinView view = new UserJoinView();
			view.getJoinButton().addActionListener(joinButtonListener);

		}
	};

	// 로그인
	ActionListener loginButtonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String username = getUsername().getText();
			String password = getPassword().getText();

			// 회원 조회
			UserController userController = new UserController();
			UserDTO responseUser = userController.login(username, password);
			if (responseUser != null) {
				System.out.println("로그인에 성공했습니다.");
				// System.out.println(responseUser.getEmail());
				System.out.println(responseUser.toString());
			}
			if (responseUser == null) {
				System.out.println("로그인에 실패했습니다.");
			}

			textArea.append(responseUser.toString());

		}
	};
	ActionListener deleteButtonListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			UserController userController = new UserController();
			UserDTO responseUser = userController.login(username, password);
			
			String usernameDelete = responseUser.getUsername();
			String passwordDelete = responseUser.getPassword();
			
			
			int check = userController.delete(usernameDelete, passwordDelete);
			System.out.println(check);
			
			
		}
	};
	
}