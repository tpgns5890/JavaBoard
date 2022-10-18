package Board;

import java.util.List;
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
			System.out.print("선택>> ");
			try {
				int logMenu = Integer.parseInt(scn.nextLine());
				switch (logMenu) {
				case 1:
					System.out.print("아이디를 입력하세요>> ");
					userId = scn.nextLine();
					System.out.print("비밀번호를 입력하세요>> ");
					String userPw = scn.nextLine();
					boolean userCheck = dao.userCheck(userId, userPw);
					if (userCheck == true) {
						System.out.println("=====================로그인 성공!" + userId + "님 환영합니다=======================");
						while (true) {
							System.out.println("1.글쓰기 2.전체목록조회 3.내가 쓴 글 4.조회수랭킹 5.게시글 수 랭킹 6.메세지함 9.로그아웃");
							System.out.print("선택>> ");
							try {
								int mainMenu = Integer.parseInt(scn.nextLine());

								if (mainMenu == 1) {

									System.out.print("글제목을 입력하세요>> ");
									String boardTitle = scn.nextLine();
									System.out.print("글내용을 입력하세요>> ");
									String boardContent = scn.nextLine();

									dao.boardInsert(boardTitle, boardContent, userId);
								} else if (mainMenu == 2) {
									while (true) {
										System.out.println(
												"=================================글 전체 목록=================================");
										List<Board> boards = dao.boardSearch();

										for (Board brd : boards) {
											System.out.println(brd.showAll());
										}
										System.out.println(
												"============================================================================");
										System.out.println("1.상세조회 2.이전");
										System.out.print("선택>> ");
										try {
											int boardMenu = Integer.parseInt(scn.nextLine());
											if (boardMenu == 1) {
												System.out.print("조회할 게시글의 번호를 입력해주세요>> ");
												int no = Integer.parseInt(scn.nextLine());
												Board brd = dao.getBoard(no);
												List<Reply> reply = dao.showReply(no);
												if (brd != null) {
													while (true) {
														System.out.println("\n=======================" + no
																+ "번 글 상세보기=======================");
														System.out.println(brd.toString());
														for (Reply replys : reply) {
															System.out.println(replys.toString());
														}
														System.out.println(
																"=============================================================\n");
														System.out.println("1.댓글쓰기 2.댓글삭제 3.작성자에게 쪽지 쓰기 4.상세보기종료");
														System.out.print("선택>> ");
														int repMenu = Integer.parseInt(scn.nextLine());
														if (repMenu == 1) {
															System.out.print("댓글내용 입력>> ");
															String repContent = scn.nextLine();
															dao.insertRep(no, repContent, userId);
														} else if (repMenu == 2) {
															System.out.print("삭제할 댓글 번호>> ");
															int repNo = Integer.parseInt(scn.nextLine());
															dao.deleteRep(repNo, userId);
														} else if (repMenu == 3) {
															System.out.print("쪽지 제목 입력>> ");
															String msgTitle = scn.nextLine();
															System.out.print("쪽지 내용 입력>> ");
															String msgContent = scn.nextLine();
															String getMsg = brd.getWriter();
															dao.sendMsg(msgTitle, msgContent, getMsg, userId);
														} else if (repMenu == 4) {
															break;
														}
													}
												}

											} else if (boardMenu == 2) {
												break;
											} else {
												System.out.println("없는 메뉴입니다.");
												System.out.println();
											}
										} catch (NumberFormatException e) {
											System.out.println("숫자를 입력해주세요");
											System.out.println();
										}
									}

								} else if (mainMenu == 3) {
									System.out.println("\n====================내가 쓴 글====================");
									while (true) {
										List<Board> boards = dao.MyBoards(userId);
										for (Board brd : boards) {
											System.out.println(brd.toString());
										}
										System.out.println("================================================\n");
										System.out.println("1.수정 2.삭제 3.뒤로가기");
										System.out.println("선택>> ");
										try {
											int menu = Integer.parseInt(scn.nextLine());
											if (menu == 1) {
												System.out.print("수정할 글번호 입력>> ");
												int boardNum = Integer.parseInt(scn.nextLine());
												System.out.print("제목수정>> ");
												String boardTitle = scn.nextLine();
												System.out.print("내용수정>> ");
												String boardContent = scn.nextLine();

												dao.updateBoard(boardNum, boardTitle, boardContent, userId);
											} else if (menu == 2) {
												System.out.print("수정할 글번호 입력>> ");
												int boardNum = Integer.parseInt(scn.nextLine());
												dao.deleteBoard(boardNum, userId);
											} else if (menu == 3) {
												break;
											} else {
												System.out.println("없는메뉴입니다");
												System.out.println();
											}
										} catch (NumberFormatException e) {
											System.out.println("숫자를 입력해주세요");
											System.out.println();
										}
									}

								} else if (mainMenu == 4) {
									System.out.println("\n==================조회수 랭킹입니다==================");
									List<Board> boards = dao.ViewRank();
									for (Board brd : boards) {
										int i = 1;
										System.out.println(i + "위: " + brd.showRank());
										i++;
									}
									System.out.println("====================!축하합니다!====================\n\n");
								} else if (mainMenu == 5) {
									System.out.println("\n===============게시글 수 랭킹입니다===============");

									List<Writer> writers = dao.PostRank();
									int i = 1;
									for (Writer wrt : writers) {
										System.out.println(i + "위: " + wrt.toString());
										i++;
									}
									System.out.println("==================!축하합니다!==================\n\n");
								} else if (mainMenu == 6) {
									System.out.println(
											"\n====================================내게 온 쪽지====================================");
									List<Message> messages = dao.readMsg(userId);
									for (Message msg : messages) {
										System.out.println(msg.toString());
									}
									System.out.println(
											"==================================================================================\n");
								} else if (mainMenu == 9) {
									System.out.println("============로그아웃합니다." + userId + "님 안녕히 가세요===========");
									System.out.println();
									break;
								} else {
									System.out.println("없는 메뉴입니다. 다시 선택해 주세요.");
									System.out.println();
									continue;
								}
							} catch (NumberFormatException e) {
								System.out.println("숫자를 입력해주세요");
								System.out.println();
							}
						}
					} else {
						System.out.println("로그인 실패 ㅠㅠ 다시 시도하세요!");
						System.out.println();
					}
				case 2:
					System.out.print("아이디를 입력하세요>> ");
					userId = scn.nextLine();
					System.out.print("비밀번호를 입력하세요>> ");
					userPw = scn.nextLine();
					System.out.print("이름을 입력하세요>> ");
					String userName = scn.nextLine();

					dao.userCreate(userId, userPw, userName);
					continue;
				case 3:
					System.out.print("삭제할 아이디를 입력하세요>> ");
					userId = scn.nextLine();
					System.out.print("삭제할 비밀번호를 입력하세요>> ");
					userPw = scn.nextLine();

					dao.userDelete(userId, userPw);
					continue;
				case 960704:
					System.out.println("관리자로 로그인하셨습니다.");
					
				case 9:
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("없는 메뉴입니다. 다시 선택해 주세요.");
					System.out.println();
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요");
				System.out.println();
			}
			break;
		} // end of while

	} // end of main
} // end of class
