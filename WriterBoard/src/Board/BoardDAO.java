package Board;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends DAO {
	Connection conn = getConnect();

// 로그인 확인
	public boolean userCheck(String userId, String userPw) {
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
	public void userCreate(String userId, String userPw, String userName) {
		String sql = "insert into writer values (?, ?, ?, 0)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, userPw);
			psmt.setString(3, userName);
			psmt.executeUpdate();
			System.out.println("회원가입 완료!");
			System.out.println();

		} catch (SQLIntegrityConstraintViolationException e1) { // 아이디 중복 exception
			System.out.println("중복된 아이디가 존재합니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//회원삭제
	public void userDelete(String userId, String userPw) {
		String sql = "delete from writer where user_id = ? and user_pw =?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, userPw);
			psmt.executeUpdate();
			System.out.println("회원삭제 완료!");
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//글쓰기
	public void boardInsert(String boardTitle, String boardContent, String userId) {
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
		String sql = "select * from board order by board_seq";
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_seq"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("writer"), rs.getString("creation_date"), rs.getInt("view_cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
//내가 쓴 글
	public List<Board> MyBoards(String userId){
		String sql = "select * from board where writer = ? order by board_seq";
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_seq"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("writer"), rs.getString("creation_date"), rs.getInt("view_cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
//조회수랭킹
	public List<Board> ViewRank(){
		String sql = "select * from board where rownum <= 10 order by view_cnt";
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_seq"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("writer"), rs.getString("creation_date"), rs.getInt("view_cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
//게시글랭킹
	public List<Writer> PostRank(){
		String sql = "select * from board where rownum <= 3 order by view_cnt";
		conn = getConnect();
		List<Writer> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Writer(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("user_name"),
						rs.getInt("post_cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}

	public List<Message> readMsg(String userId) {
		String sql = "select * from message where get_msg = ? order by creation_date";
		conn = getConnect();
		List<Message> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Message(rs.getString("msg_title"), rs.getString("msg_content"), rs.getString("get_msg"),
						rs.getString("sent_msg"),rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
}
