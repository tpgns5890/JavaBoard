package co.edu.board;

import java.util.List;
import java.util.Scanner;

//main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.글상세조회 9.종료");
			System.out.println("메뉴를 선택하세요>> ");
			try {
				int menu = Integer.parseInt(scn.nextLine());

				if (menu == 1) {
					System.out.println("글등록 메뉴입니다.");
					System.out.print("글번호를 입력하세요>> ");
					int no = Integer.parseInt(scn.nextLine());
					System.out.print("글제목을 입력하세요>> ");
					String title = scn.nextLine();
					System.out.print("글내용을 입력하세요>> ");
					String content = scn.nextLine();
					System.out.print("작성자를 입력하세요>> ");
					String writer = scn.nextLine();

					Board brd = new Board(no, title, content, writer);
					dao.insert(brd);
					System.out.println();
				} else if (menu == 2) {
					System.out.println("글수정메뉴입니다.");
					System.out.print("수정할 글의 글 번호를 입력하세요>> ");
					int no = Integer.parseInt(scn.nextLine());
					System.out.print("수정하실 내용을 입력하세요>> ");
					String content = scn.nextLine();

					Board brd = new Board(no, content);
					dao.update(brd);
					System.out.println();
				} else if (menu == 3) {
					System.out.println("글삭제 메뉴입니다.");
					System.out.print("삭제할 게시글의 글번호를 입력하세요>> ");
					int no = Integer.parseInt(scn.nextLine());

					dao.delete(no);
					System.out.println();
				} else if (menu == 4) {
					System.out.println("<글 전체 목록>");
					List<Board> brd = dao.search();

					for (Board boards : brd) {
						System.out.println(boards);
					}
					System.out.println();

				} else if (menu == 5) {
					System.out.println("<게시글 상세 조회>");
					System.out.print("조회할 게시글의 번호를 입력하세요>> ");
					int no = Integer.parseInt(scn.nextLine());

					if(dao.getBoard(no) != null) {
					System.out.println("글번호 <" + no + "> 상세보기");
					System.out.println(dao.getBoard(no));
					System.out.println();
					}else {
						System.out.println(no + "번에 해당하는 글이 없습니다.");
						System.out.println();
					}
				} else if (menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("없는 메뉴입니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해 주세요.");
				System.out.println();
			}
		} // end of while
	}// end of main
}// end of class
