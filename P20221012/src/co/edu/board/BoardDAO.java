package co.edu.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD기능 구현
public class BoardDAO extends DAO {
	
	public void insert(Board brd) {
		String sql = "insert into board (board_num, board_title, board_content, board_writer) values(?, ?, ?, ?)";

		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brd.getBoardNum());
			psmt.setString(2, brd.getBoardTitle());
			psmt.setString(3, brd.getBoardContent());
			psmt.setString(4, brd.getBoardWriter());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 등록 완료.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void update(Board brd) {
		String sql = "update board set board_content = ?, creation_date = sysdate where board_num = ? and board_writer = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getBoardContent());
			psmt.setInt(2, brd.getBoardNum());
			psmt.setString(3, brd.getBoardWriter());
			int r = psmt.executeUpdate();
			if(r>0) {
			System.out.println("수정 완료");
			}else {
				System.out.println("수정 권한이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	public void delete(int brdNum, String userId) {
		String sql = "delete from board where board_num = ? and board_writer = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brdNum);
			psmt.setString(2, userId);
			int r = psmt.executeUpdate();
			if (r == 0) {
				System.out.println("삭제할 게시글이 없거나 해당 게시글을 삭제할 권한이 없습니다.");
			} else {
				System.out.println(r + "건 삭제되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public List<Board> search() {
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board order by board_num");
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"), rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}

	public Board getBoard(int brdNum) {
		Board brd = null;
		String sql, sql1;
				
		try {
			sql = "update board set cnt = cnt + 1 where board_num= ?";
			sql1 = "select board_num, board_title, board_content, board_writer, creation_date, cnt from board where board_num = ? order by board_num";
			conn = getConnect();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brdNum);
			psmt.executeUpdate();
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, brdNum);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				brd = new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"), rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return brd;
	}
	
	//로그인 확인하기
	public int userCheck(String userId, String userPw) {
		String sql = "select id, passwd from users where id = ? and passwd = ?";
		conn = getConnect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			psmt.setString(1, userId);
			psmt.setString(2, userPw);
			
			rs = psmt.executeQuery();
			rs.last();
			int rcnt = rs.getRow();
			if(rcnt == 1) {
				r = 1;
			}else {
				r = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}		
		return r;		
	}
	
	//댓글
	public List<Reply> searchReply(int no){
		String sql = "select * from reply where board_num = ? order by rep_seq";
		conn = getConnect();
		List<Reply> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Reply(rs.getInt("rep_seq"), rs.getInt("board_num"), rs.getString("rep_content"), rs.getString("rep_writer"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}		
		return list;
	}
	
	public void insertRep(int no, String rContent, String userId) {
		String sql = "insert into reply values (reply_seq.nextval, ?, ?, ?, sysdate)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.setString(2, rContent);
			psmt.setString(3, userId);
			psmt.executeUpdate();
			System.out.println("댓글입력완료!");
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public void deleteRep(int repNo, String userId) {
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
				System.out.println(r + "건 삭제되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}


}
