package Board;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
			if (rs != null) {
				r = true;
			} else {
				r = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

		} catch (SQLIntegrityConstraintViolationException e1) { //아이디 중복 exception
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
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
