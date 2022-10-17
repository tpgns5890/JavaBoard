package co.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//간단한 계산기.
public class ComponentExam3 extends JFrame {

	String[] keys = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/" };
	JButton[] keyBtn = new JButton[16];
	String displayText = "";
	String left = "";
	String right = "";
	public ComponentExam3() {
		setTitle("계산기 UI");
		setBounds(100, 100, 300, 220);// 위치와 크기.

		setLayout(new FlowLayout());

		// display 정보를 출력하기 위한 panel.
		JPanel displayPanel = new JPanel();
		JTextField display = new JTextField("0", 17);
		display.setHorizontalAlignment(JTextField.RIGHT);
		displayPanel.add(display);

		// 버튼을 생성하기 위한 panel.
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(4, 4, 5, 5));

		for (int i = 0; i < keyBtn.length; i++) {
			keyBtn[i] = new JButton(keys[i]);
			keyBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String keyOper = ((JButton) e.getSource()).getText();

					// 계산처리.
					if (keyOper.equals("=")) {
						left = displayText.substring(0, displayText.indexOf("+")); // 234+12
						right = displayText.substring(displayText.indexOf("+") + 1);
						displayText = String.valueOf(Integer.parseInt(left) + Integer.parseInt(right));
						display.setText(displayText);
						return;
					}
					if(keyOper.equals("C")) {
						displayText = "";
						display.setText(displayText);
						return;
					}
					displayText += keyOper;
					display.setText(displayText);
				}
			});
			keyPanel.add(keyBtn[i]);
		}

		add(displayPanel);
		add(keyPanel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new ComponentExam3();
	}

}
