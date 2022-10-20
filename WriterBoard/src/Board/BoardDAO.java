package Board;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BoardDAO extends DAO {
	Connection conn = getConnect();
	Scanner scn = new Scanner(System.in);

// 로그인 확인
	public boolean userCheck(String userId) {
		System.out.print("비밀번호를 입력하세요>> ");
		String userPw = scn.nextLine();
		String sql = "select user_id, user_pw from writer where user_id = ? and user_pw = ?";
		conn = getConnect();
		boolean r = false;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, userPw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				r = true;
			} else {
				r = false;
			}
		} catch (SQLException e) {
			System.out.println("존재하지 않는 아이디와 비밀번호입니다.");
		} catch (NullPointerException e1) {
			System.out.println("회원이 존재하지 않습니다.");
			System.out.println();
		} finally {
			disconnect();
		}

		return r;

	}

//회원가입
	public void userCreate() {
		System.out.print("아이디를 입력하세요>> ");
		String userId = scn.nextLine();
		System.out.print("비밀번호를 입력하세요>> ");
		String userPw = scn.nextLine();
		System.out.print("이름을 입력하세요>> ");
		String userName = scn.nextLine();
		System.out.print("이메일을 입력하세요>> ");
		String email = scn.nextLine();
		String sql = "insert into writer values (?, ?, ?, 0,?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, userPw);
			psmt.setString(3, userName);
			psmt.setString(4, email);
			psmt.executeUpdate();
			System.out.println("회원가입 완료!");
			System.out.println();

		} catch (SQLIntegrityConstraintViolationException e1) { // 아이디 중복 exception
			System.out.println("중복된 아이디가 존재하거나 필수항목을 입력하지 않았습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//회원삭제
	public void userDelete() {
		System.out.print("본인의 아이디를 입력하세요>> ");
		String userId = scn.nextLine();
		System.out.print("비밀번호를 입력하세요>> ");
		String userPw = scn.nextLine();
		String sql = "delete from writer where user_id = ? and user_pw =?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, userPw);
			int r = psmt.executeUpdate();
			if (r != 1) {
				System.out.println("존재하지 않는 아이디거나 비밀번호가 맞지 않습니다.");
			} else {
				System.out.println("회원삭제 완료!");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//글쓰기
	public void boardInsert(String userId) {
		System.out.print("글제목을 입력하세요>> ");
		String boardTitle = scn.nextLine();
		System.out.print("글내용을 입력하세요>> ");
		String boardContent = scn.nextLine();
		String sql = "update writer set post_cnt = post_cnt + 1 where user_id = ?";
		String sql1 = "insert into board values (board_seq.nextVal, ?, ?, ?, sysdate, 0)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.executeUpdate();
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, boardTitle);
			psmt.setString(2, boardContent);
			psmt.setString(3, userId);
			psmt.executeUpdate();
			System.out.println("글 등록이 완료되었습니다!");
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//전체목록조회
	public List<Board> boardSearch() {
		String sql = "select rownum, board_seq, board_title, board_content, writer, creation_date, view_cnt from board order by board_seq";
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt("rownum"), rs.getInt("board_seq"), rs.getString("board_title"),
						rs.getString("board_content"), rs.getString("writer"), rs.getString("creation_date"),
						rs.getInt("view_cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//내가 쓴 글
	public List<Board> MyBoards(String userId) {
		String sql = "select * from board where writer = ? order by board_seq";
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt("board_seq"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("writer"), rs.getString("creation_date"), rs.getInt("view_cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//글 수정
	public void updateBoard(String userId) {
		System.out.print("수정할 글 고유번호 입력>> ");
		int boardNum = Integer.parseInt(scn.nextLine());
		System.out.print("제목수정>> ");
		String boardTitle = scn.nextLine();
		System.out.print("내용수정>> ");
		String boardContent = scn.nextLine();
		String sql = "update board set board_title = ?, board_content = ?, creation_date = sysdate where board_seq = ? and writer = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boardTitle);
			psmt.setString(2, boardContent);
			psmt.setInt(3, boardNum);
			psmt.setString(4, userId);
			psmt.executeUpdate();
			System.out.println("수정완료!");
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//글 삭제
	public void deleteBoard(String userId) {
		System.out.print("삭제할 글 고유번호 입력>> ");
		int boardNum = Integer.parseInt(scn.nextLine());
		String sql1 = "update writer set post_cnt = post_cnt - 1 where user_id = ?";
		String sql = "delete from board where board_seq = ? and writer = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			psmt.setString(2, userId);
			psmt.executeUpdate();
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, userId);
			psmt.executeUpdate();
			System.out.println("삭제완료!");
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//조회수랭킹
	public List<Board> ViewRank() {
		String sql = "select * from (select * from board order by view_cnt desc) where rownum <=3";
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt("board_seq"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("writer"), rs.getString("creation_date"), rs.getInt("view_cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//게시글랭킹
	public List<Writer> PostRank() {
		String sql = "select * from (select * from writer order by post_cnt desc) where rownum <=3";
		conn = getConnect();
		List<Writer> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Writer(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("user_name"),
						rs.getInt("post_cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//쪽지읽기
	public List<Message> readMsg(String userId) {
		String sql = "select * from message where get_msg = ? order by creation_date";
		conn = getConnect();
		List<Message> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Message(rs.getString("msg_title"), rs.getString("msg_content"), rs.getString("get_msg"),
						rs.getString("send_msg"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//상세보기
	public Board getBoard(int no) {
		Board brd = new Board();

		String sql = "update board set view_cnt = view_cnt + 1 where board_seq = ?";
		String sql1 = "select * from board where board_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			if (rs.next()) {
				brd = new Board(rs.getInt("board_seq"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("writer"), rs.getString("creation_date"), rs.getInt("view_cnt"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return brd;

	}

//댓글출력
	public List<Reply> showReply(int no) {
		String sql = "select * from reply where board_num = ? order by rep_seq";
		conn = getConnect();
		List<Reply> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Reply(rs.getInt("rep_seq"), rs.getInt("board_num"), rs.getString("rep_content"),
						rs.getString("rep_writer"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//댓글쓰기
	public void insertRep(int no, String userId) {
		System.out.print("댓글내용 입력>> ");
		String repContent = scn.nextLine();
		String sql = "insert into reply values (rep_seq.nextval, ?, ?, ?, sysdate)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.setString(2, repContent);
			psmt.setString(3, userId);
			psmt.executeUpdate();
			System.out.println("댓글입력완료!\n");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//댓글삭제
	public void deleteRep(String userId) {
		System.out.print("삭제할 댓글 고유번호>> ");
		int repNo = Integer.parseInt(scn.nextLine());
		String sql = "delete from reply where rep_seq = ? and rep_writer = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, repNo);
			psmt.setString(2, userId);
			int r = psmt.executeUpdate();
			if (r == 0) {
				System.out.println("삭제할 게시글이 없거나 해당 게시글을 삭제할 권한이 없습니다.");
			} else {
				System.out.println("삭제완료!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//쪽지보내기
	public void sendMsg(String getMsg, String userId) {
		System.out.print("제목 입력>> ");
		String msgTitle = scn.nextLine();
		System.out.print("내용 입력>> ");
		String msgContent = scn.nextLine();
		String sql = "insert into message values(?, ? ,? ,?, sysdate)";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, msgTitle);
			psmt.setString(2, msgContent);
			psmt.setString(3, getMsg);
			psmt.setString(4, userId);
			psmt.executeUpdate();
			System.out.println("보내기 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//회원목록 출력
	public List<Writer> showWriter() {
		String sql = "select * from writer";
		conn = getConnect();
		List<Writer> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Writer(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("user_name"),
						rs.getInt("post_cnt"), rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//회원정보 수정
	public void updateUser() {
		System.out.print("수정할 회원의 아이디를 입력하세요>> ");
		String userId1 = scn.nextLine();
		System.out.print("비밀번호 수정>> ");
		String userPw1 = scn.nextLine();
		String sql = "update writer set user_pw = ? where user_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userPw1);
			psmt.setString(2, userId1);
			psmt.executeUpdate();
			System.out.println("비밀번호가 수정되었습니다.");
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//회원삭제
	public void deleteUser() {
		System.out.println("삭제할 회원의 아이디를 입력하세요>> ");
		String userId1 = scn.nextLine();
		String sql = "delete from writer where user_id =?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId1);
			psmt.executeUpdate();
			System.out.println("삭제완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//회원삭제(관리자)
	public void deleteUserM() {
		System.out.println("삭제할 게시글의 고유번호 입력>> ");
		int boardNo = Integer.parseInt(scn.nextLine());
		String sql = "delete from board where board_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			psmt.executeUpdate();
			System.out.println("삭제완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//비밀번호 찾기
	public void findPw() {
		MailApp dao = new MailApp();
		String toId = "";
		String password = "";
		System.out.println("아이디를 입력해주세요");
		System.out.print("선택>> ");
		String findId = scn.nextLine();
		String sql = "select email from writer where user_id = ?";
		String sql1 = "select user_pw from writer where user_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, findId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				toId = rs.getString(1);
			}
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, findId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				password = "안녕하세요! 게시판 운영자입니다\n" + findId + " 회원님의 비밀번호는 " + rs.getString(1) + "입니다.";
			}
//			dao.sendMail(toId, password);
			if (dao.sendMail(toId, password).equals("Success")) {
				System.out.println("등록된 이메일로 비밀번호를 발송하였습니다!");

			} else {
				System.out.println("전송실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
