package co.edu.board;

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
		String sql = "update board set board_content = ?, creation_date = sysdate where board_num = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getBoardContent());
			psmt.setInt(2, brd.getBoardNum());

			psmt.executeUpdate();
			System.out.println("수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	public void delete(int brdNum) {
		String sql = "delete from board where board_num = ?";
		conn = getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brdNum);
			int r = psmt.executeUpdate();
			if (r == 0) {
				System.out.println("삭제할 게시글이 없습니다.");
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
			rs = stmt.executeQuery("select board_num, board_title, board_writer, creation_date from board order by board_num");
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_writer"), rs.getString("creation_date")));
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
		String sql = "update board set cnt = cnt + 1 where board_num= ?";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brdNum);
			psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		String sql1 = "select board_num, board_title, board_content, board_writer, creation_date, cnt from board where board_num = ? order by board_num";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, brdNum);
			psmt.executeQuery();
			
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
}
