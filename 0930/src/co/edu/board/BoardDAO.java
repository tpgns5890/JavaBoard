package co.edu.board;

import java.util.Scanner;

//	기능만...,
public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {};
	public static BoardDAO getInstance() {
		return instance;		
	}
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100];

	// 1.글 등록
	public void addBoard() {
		System.out.println("글 등록 기능입니다.");
		System.out.print("글 번호를 입력하세요 >>> ");
		int bNo = scn.nextInt();
		scn.nextLine();
		System.out.print("글 제목을 입력하세요 >>> ");
		String title = scn.nextLine();
		System.out.print("글 내용을 입력하세요 >>> ");
		String content = scn.nextLine();

		Board brd = new Board(bNo, title, content);
		for (int i = 0; i < myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo() == bNo){
				System.out.println("이미 존재하는 글 번호입니다");
				break;
			}
			if (myBoards[i] == null) {
				myBoards[i] = brd;
				System.out.println(bNo + "번 글이 등록되었습니다");
				System.out.println();
				break;
			}
		}

	}

	// 2.글 목록
	public void boardList() {
		System.out.println("글 목록 기능입니다.");
		for (Board brd : myBoards) {
			if (brd != null) {
				System.out.println(brd.toString());
				System.out.println();
			}
		}
	}

	// 3.글 상세보기
	public void boardDetail() {
		System.out.println("글 상세보기 기능입니다.");
		System.out.print("상세보기할 글 번호를 입력하세요>>> ");
		int bNo = scn.nextInt();
		for (int i = 0; i < myBoards.length;) {
			if (myBoards[i] != null && myBoards[i].getBoardNo() == bNo) {
				System.out.println(myBoards[i].toString());
				System.out.println();
				break;
			}
			System.out.println("존재하지 않는 글 번호입니다.");
			System.out.println();
			break;
		}

	}

	// 4.글 삭제
	public void delBoard() {
		System.out.println("글 삭제 기능입니다.");
		System.out.print("삭제할 글 번호를 입력하세요>>> ");
		int bNo = scn.nextInt();
		for (int i = 0; i < myBoards.length;) {
			if (myBoards[i] != null && myBoards[i].getBoardNo() == bNo) {
				myBoards[i] = null;
				System.out.println(bNo +"번 글이 삭제되었습니다.");
				System.out.println();
				break;
			}
		System.out.println("존재하지 않는 글 번호입니다.");
		System.out.println();
		break;
		}
	}
	// 5.전체 메뉴

	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("1.글등록 2.글목록 3.글상세보기 4.글삭제 9.종료");
			System.out.print("선택>>");

			int menu = scn.nextInt();
			switch (menu) {
			case 1:
				addBoard();
				break;
			case 2:
				boardList();
				break;
			case 3:
				boardDetail();
				break;
			case 4:
				delBoard();
				break;
			case 9:
				run = false;
				break;
			default:
				System.out.println("잘못된 기능입니다");

			}
		} // end of while
		System.out.println("프로그램 종료.");
	}// end of exe
}
