package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	// 조회 후 수정
	public void searchAndupdate() {
		
	}
	
	// 생성, 수정, 삭제, 한건조회, 목록조회
	
	
	public void memberInsert(MemberVO vo) {
		getConnect();
		String sql = "insert into members (id, passwd, name, email) values (?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			int r = psmt.executeUpdate();
			System.out.println(r+ "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public MemberVO memberSearch(String id) {
		getConnect();
		String sql = "select * from members where id = ?";
		MemberVO memList = new MemberVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				memList = new MemberVO(rs.getString("id"),rs.getString("passwd"),rs.getString("name"),rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return memList;
	}
	
	public void memberUpdate(MemberVO vo) {
		getConnect();
		String sql = "update members set passwd = ?, name = ?, email = ? where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());
			int r = psmt.executeUpdate();
			System.out.println(r+ "건 수정.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public void memberDelete(String id) {
		getConnect();
		String sql = "delete from members where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public List<MemberVO> memberList(){
		List<MemberVO> memList = new ArrayList<MemberVO>();
		getConnect();
		String sql = "select * from members";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mem = new MemberVO(rs.getString("id"),rs.getString("passwd"),rs.getString("name"),rs.getString("email"));
				memList.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

		return memList;
	}

}
