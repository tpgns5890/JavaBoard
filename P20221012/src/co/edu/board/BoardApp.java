package co.edu.board;

import java.util.List;
import java.util.Scanner;

//main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		String userId = null;

		while (true) {
			System.out.println("1.로그인 2.회원가입 4.종료");
			System.out.println("메뉴를 선택하세요>> ");
			int logInMenu = Integer.parseInt(scn.nextLine());
			if (logInMenu == 1) {
				System.out.print("아이디를 입력하세요>> ");
				userId = scn.nextLine();
				System.out.print("비밀번호를 입력하세요>> ");
				String userPw = scn.nextLine();
				int checked = dao.userCheck(userId, userPw);
				if (checked == 1) {
					System.out.println(userId + "님 환영합니다!!!");
					while (true) {
						System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.글상세조회 9.로그아웃");
						System.out.print("메뉴를 선택하세요>> ");
						try {
							int menu = Integer.parseInt(scn.nextLine());

							if (menu == 1) {
								System.out.print("글번호를 입력하세요>> ");
								int no = Integer.parseInt(scn.nextLine());
								System.out.print("글제목을 입력하세요>> ");
								String title = scn.nextLine();
								System.out.print("글내용을 입력하세요>> ");
								String content = scn.nextLine();
//								System.out.print("작성자를 입력하세요>> ");
								String writer = userId;

								Board brd = new Board(no, title, content, writer);
								dao.insert(brd);
								System.out.println();
							} else if (menu == 2) {
								System.out.print("수정할 글의 글 번호를 입력하세요>> ");
								int no = Integer.parseInt(scn.nextLine());
								System.out.print("수정하실 내용을 입력하세요>> ");
								String content = scn.nextLine();
								String writer = userId;
								Board brd = new Board(no, content, writer);
								dao.update(brd);
								System.out.println();
							} else if (menu == 3) {
								System.out.print("삭제할 게시글의 글번호를 입력하세요>> ");
								int no = Integer.parseInt(scn.nextLine());
								dao.delete(no, userId);
								System.out.println();
							} else if (menu == 4) {
								System.out.println("<글 전체 목록>");
								List<Board> brd = dao.search();

								for (Board boards : brd) {
									System.out.println(boards.searchString());
								}
								System.out.println();

							} else if (menu == 5) {
								System.out.println("<게시글 상세 조회>");
								System.out.print("조회할 게시글의 번호를 입력하세요>> ");
								int no = Integer.parseInt(scn.nextLine());
								Board brd = dao.getBoard(no);
								List<Reply> reply = dao.searchReply(no);
								if (brd != null) {
										System.out.println("<<<<<<<<글번호 <" + no + "> 상세보기>>>>>>>>\n");
										System.out.println(brd.toString());
										for (Reply replys : reply) {
											System.out.println(replys.stringReply());
										}
										while (true) {
										System.out.println("\n1.댓글쓰기 2.댓글삭제 3.상세보기종료");
										System.out.print("메뉴를 입력하세요>> ");
										int rNo = Integer.parseInt(scn.nextLine());
										if(rNo == 1) {
											System.out.print("댓글내용을 입력하세요>> ");
											String rContent = scn.nextLine();
											dao.insertRep(no, rContent, userId);
											System.out.println();
										}else if (rNo ==2) {
											System.out.print("삭제할 댓글번호를 입력하세요>> ");
											int repNo = Integer.parseInt(scn.nextLine());
											dao.deleteRep(repNo, userId);
											System.out.println();
										}else if(rNo ==3) {
											System.out.println(no+"번 글의 상세보기를 종료합니다.");
											System.out.println();
											break;
										}else {
											System.out.println("없는 번호입니다.");
										}
									}
								} else {
									System.out.println(no + "번에 해당하는 글이 없습니다.");
									System.out.println();

								}
							} else if (menu == 9) {
								System.out.println("로그아웃합니다.");
								break;
							} else {
								System.out.println("없는 메뉴입니다.");
							}
						} catch (NumberFormatException e) {
							System.out.println("숫자를 입력해 주세요.");
							System.out.println();
						}

					}
				} else {
					System.out.println("로그인 실패! 다시시도하세요");
					System.out.println();
				}
			} else if (logInMenu == 2) {
				System.out.println("회원가입 메뉴입니다.");
			} else if (logInMenu == 4) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		} // end of while
	}// end of main
}// end of class
