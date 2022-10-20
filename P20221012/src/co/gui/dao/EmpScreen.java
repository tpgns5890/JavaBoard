package co.gui.dao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmpScreen extends JFrame implements ActionListener, MouseListener {
	// 입력항목.
	private String[] labels = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
	private JTextField[] fields = new JTextField[6];

	// 컨테이너.
	private JPanel topPanel;
	private JScrollPane centerPanel;
	private JPanel rightPanel;

	// 데이터
	private JTable table;

	// 버튼.
	private JButton addBtn, delBtn, findBtn, initBtn;

	EmpDAO dao = new EmpDAO();
	List<EmployeeVO> list;

	public EmpScreen() {
		setTitle("사원정보 관리화면");
		setLayout(new BorderLayout(10, 10));

		// topPanel 추가
		topPanel = new JPanel(new GridLayout(6, 2));
		for (int i = 0; i < labels.length; i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}

		// centerPanel 추가.
		String[] headers = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		table.addMouseListener(this);
		centerPanel = new JScrollPane(table);

		// 오른쪽 버튼.
		rightPanel = new JPanel(new GridLayout(4, 1));
		addBtn = new JButton("레코드 추가");
		delBtn = new JButton("레코드 삭제");
		findBtn = new JButton("레코드 조회");
		initBtn = new JButton("초기화");

		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		findBtn.addActionListener(this);
		initBtn.addActionListener(this);

		rightPanel.add(addBtn);
		rightPanel.add(delBtn);
		rightPanel.add(findBtn);
		rightPanel.add(initBtn);

		add("North", topPanel); // 위 입력항목들 배치.
		add("Center", centerPanel);
		add("East", rightPanel);

		setSize(620, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	} // end of EmpScreen()

	// DB조회 후 table 결과를 반영.
	public void searchData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		//화면에 조회된 결과 있으면...clear
		int allCnt = model.getRowCount();
		for(int i=0;i<allCnt; i++) {
			model.removeRow(0);
		}
		
		String[] record = new String[6];
		list = dao.empList(new EmployeeVO(0, fields[1].getText(), null, null, null, fields[5].getText()));

		for (int i = 0; i < list.size(); i++) {
			record[0] = String.valueOf(list.get(i).getEmployeeId());
			record[1] = list.get(i).getFirstName();
			record[2] = list.get(i).getLastName();
			record[3] = list.get(i).getEmail();
			record[4] = list.get(i).getHireDate();
			record[5] = list.get(i).getJobId();
			model.addRow(record);
		}
	}
	
	//삭제위한 메소드.
	public void removeDate() {
		int selectedRow = table.getSelectedRow(); // 선택된 row 반환
		if(selectedRow<0) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int empId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
		
		dao.deleteEmp(empId);
		
		model.removeRow(selectedRow); //화면에서 삭제
	}
	
	//등록.
	public void addData() {
		String[] records = new String[6];
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=0; i<fields.length; i++) {
			records[i] = fields[i].getText();
		}
		EmployeeVO emp = new EmployeeVO(0, records[1], records[2], records[3], records[4], records[5]);
		dao.insertEmp(emp);
		records[0] = String.valueOf(emp.getEmployeeId());
		model.addRow(records);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// add, del, find, initBtn.. 구분해줘야함
		Object src = e.getSource(); // 이벤트가 발생한 객체가 어느것인지

		if (src == addBtn) {
			addData();
		} else if (src == delBtn) {
			removeDate();
		} else if (src == findBtn) {
			searchData();
		} else if (src == initBtn) {

		}

	}// end of actionPerformed(ActionEvent e)


	@Override
	public void mouseClicked(MouseEvent e) {
		// table 이벤트.
		
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
	// 프로그램 시작
	public static void main(String[] args) {
		new EmpScreen();
	}
} // end of class
