package Board;

import java.util.Scanner;

//main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		String userId = null;

		while (true) {
			System.out.println("===========게시판에 오신것을 환영합니다!============");
			System.out.println("1.로그인 2.회원가입 3.회원탈퇴 4.익명으로로그인 9. 종료");
			int logMenu = Integer.parseInt(scn.nextLine());
			switch (logMenu) {
			case 1:
				System.out.print("아이디를 입력하세요>> ");
				userId = scn.nextLine();
				System.out.print("비밀번호를 입력하세요>> ");
				String userPw = scn.nextLine();
				boolean userCheck = dao.userCheck(userId, userPw);
				if (userCheck == true) {
					while (true) {
						System.out.println("=====================로그인 성공!" + userId + "님 환영합니다=======================");
						System.out.println("1.글쓰기 2.전체목록조회 3.내가 쓴 글 4.조회수랭킹 5.게시글 수 랭킹 6.메세지함 9.로그아웃");
						int mainMenu = Integer.parseInt(scn.nextLine());

						switch (mainMenu) {
						case 1:
							System.out.print("글제목을 입력하세요>> ");
							String boardTitle = scn.nextLine();
							System.out.print("글내용을 입력하세요>> ");
							String boardContent = scn.nextLine();
							
							dao.boardInsert(boardTitle, boardContent, userId);
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
						case 9:
							System.out.println("============로그아웃합니다." + userId + "님 안녕히 가세요===========");
							System.out.println();
							break;
						default:
							System.out.println("없는 메뉴입니다. 다시 선택해 주세요.");
							System.out.println();
							continue;
						}break;
					}
				} else {
					System.out.println("로그인 실패 ㅠㅠ 다시 시도하세요!");
					System.out.println();
				}continue;
			case 2:
				System.out.print("아이디를 입력하세요>> ");
				userId = scn.nextLine();
				System.out.println("비밀번호를 입력하세요>> ");
				userPw = scn.nextLine();
				System.out.println("이름을 입력하세요>> ");
				String userName = scn.nextLine();

				dao.userCreate(userId, userPw, userName);
				continue;
			case 3:
				System.out.print("삭제할 아이디를 입력하세요>> ");
				userId = scn.nextLine();
				System.out.println("삭제할 비밀번호를 입력하세요>> ");
				userPw = scn.nextLine();

				dao.userDelete(userId, userPw);
				continue;
			case 4:
				System.out.println("익명으로 로그인하셨습니다");

			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("없는 메뉴입니다. 다시 선택해 주세요.");
				System.out.println();
				continue;
			}
			break;
		} // end of while

	} // end of main
} // end of class
