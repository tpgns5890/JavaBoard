package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import co.gui.MailScreen.MyActionListener;

public class SmsScreen extends JFrame {

	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(35, 15);

	JPanel center, bottom;
	JLabel fromLbl, toLbl, contentLbl;
	JTextField toTxt, fromTxt;
	JTextArea contentTxt;
	JButton send, cancel;

	SmsApp app = new SmsApp();

	public SmsScreen() {
		setTitle("메세지보내기 UI");
		setSize(350, 300);
		setLayout(new BorderLayout());

		// panel
		center = new JPanel();
		bottom = new JPanel();

		// label
		toLbl = new JLabel("수신자 번호");
		fromLbl = new JLabel("발신자 번호");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);

		// textfield
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);

		// button
		send = new JButton("전송");
		send.addActionListener(new MyActionListener());
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		// container setting.
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		// 컨테이너에 컴포넌트 배치.
		bottom.add(send);
		bottom.add(cancel);

		// 윈도우에 컨테이너 배치.
		add("Center", center);
		add("South", bottom);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	// 기능을 실행하는 구현객체.
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if (src == send) {
				System.out.println("보내기 버튼 actionPerformed.");
				String from = fromTxt.getText();
				String to = toTxt.getText();
				String content = contentTxt.getText();

				if (app.SendSms(to, from, content).equals("Success")) {
					System.out.println("성공!");
					fromTxt.setText("");
					toTxt.setText("");
					contentTxt.setText("");
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				} else {
					System.out.println("실패");
					JOptionPane.showMessageDialog(null, "발송실패!!", "에러", JOptionPane.WARNING_MESSAGE);
				}
			} else if (src == cancel) {
				System.out.println("취소 버튼 actionPerformed.");
			}
		}

	}
	public static void main(String[] args) {
		new SmsScreen();
	}
}
