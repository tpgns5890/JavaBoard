package co.edu.inherit.dbinterface;

public class CompanyApp {
	public static void main(String[] args) {
		//추가, 수정, 삭제, 조회,가능
//		MysqlDAO dao = new MysqlDAO();
//		dao.insert();
//		dao.search();
//		dao.update();
//		dao.delete();
		
//		OracleDAO dao = new OracleDAO();
//		dao.add();
//		dao.modify();
//		dao.find();
//		dao.remove();
		
		DaoService dao = new MysqlDAO();
//		dao = new OracleDAO();
		dao.insert();
		dao.modify();
		dao.remove();
		dao.search();
		
		//익명구현객체 : 인터페이스 구현 코드만
		DaoService anonym = new DaoService() {

			@Override
			public void insert() {
				System.out.println("익명db 입력");
			}

			@Override
			public void modify() {
				System.out.println("익명db 수정");
			}

			@Override
			public void remove() {
				System.out.println("익명db 삭제");
			}

			@Override
			public void search() {
				System.out.println("익명db 조회");
			}
			
		};
		anonym.insert();
		anonym.modify();
		anonym.remove();
		anonym.search();
	}
}
