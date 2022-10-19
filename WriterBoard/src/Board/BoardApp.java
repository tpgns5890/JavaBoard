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
			System.out.println("1.로그인 2.회원가입 3.회원탈퇴 9. 종료");
			System.out.print("선택>> ");
			try {
				int logMenu = Integer.parseInt(scn.nextLine());
				if (logMenu == 1) {
					System.out.print("아이디를 입력하세요>> ");
					userId = scn.nextLine();
					System.out.print("비밀번호를 입력하세요>> ");
					String userPw = scn.nextLine();
					boolean userCheck = dao.userCheck(userId, userPw);

					if (userCheck == true) {
						System.out.println("=====================로그인 성공!" + userId + "님 환영합니다=======================");
						while (true) {
							System.out.println("1.글쓰기 2.전체목록조회 3.내가 쓴 글 4.조회수랭킹 5.게시글 수 랭킹 6.메세지함 7.문의하기 9.로그아웃");
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
												System.out.print("조회할 게시글의 고유번호를 입력해주세요>> ");
												int no = Integer.parseInt(scn.nextLine());
												while (true) {
													Board brd = dao.getBoard(no);
													List<Reply> reply = dao.showReply(no);
													if (brd != null) {
														System.out.println("\n==============================="+no+"번 게시글 상세보기=================================");
														System.out.println(brd.toString());
														for (Reply replys : reply) {
															System.out.println(replys.toString());
														}
														System.out.println(
																"====================================================================\n");
														System.out.println("1.댓글쓰기 2.댓글삭제 3.작성자에게 쪽지 쓰기 4.상세보기종료");
														System.out.print("선택>> ");
														int repMenu = Integer.parseInt(scn.nextLine());

														if (repMenu == 1) {
															System.out.print("댓글내용 입력>> ");
															String repContent = scn.nextLine();
															dao.insertRep(no, repContent, userId);

														} else if (repMenu == 2) {
															System.out.print("삭제할 댓글 고유번호>> ");
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
									while (true) {
										System.out.println("\n====================내가 쓴 글====================");
										List<Board> boards = dao.MyBoards(userId);
										for (Board brd : boards) {
											System.out.println(brd.myBoards());
										}
										System.out.println("================================================\n");
										System.out.println("1.수정 2.삭제 3.뒤로가기");
										System.out.print("선택>> ");
										try {
											int menu = Integer.parseInt(scn.nextLine());

											if (menu == 1) {
												System.out.print("수정할 글 고유번호 입력>> ");
												int boardNum = Integer.parseInt(scn.nextLine());
												System.out.print("제목수정>> ");
												String boardTitle = scn.nextLine();
												System.out.print("내용수정>> ");
												String boardContent = scn.nextLine();
												dao.updateBoard(boardNum, boardTitle, boardContent, userId);

											} else if (menu == 2) {
												System.out.print("삭제할 글 고유번호 입력>> ");
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
											"==================================================================================\n\n");
								} else if (mainMenu == 7) {
									System.out.print("문의사항 제목입력>>");
									String msgTitle = scn.nextLine();
									System.out.print("문의사항 입력>> ");
									String msgContent = scn.nextLine();
									String getMsg = "manager";
									dao.sendMsg(msgTitle, msgContent, getMsg, userId);
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
						System.out.println("로그인 실패. 다시 시도하세요.");
						System.out.println();
					}
					continue;

				} else if (logMenu == 2) {
					System.out.print("아이디를 입력하세요>> ");
					userId = scn.nextLine();
					System.out.print("비밀번호를 입력하세요>> ");
					String userPw = scn.nextLine();
					System.out.print("이름을 입력하세요>> ");
					String userName = scn.nextLine();
					dao.userCreate(userId, userPw, userName);
					continue;

				} else if (logMenu == 3) {
					System.out.print("본인의 아이디를 입력하세요>> ");
					userId = scn.nextLine();
					System.out.print("비밀번호를 입력하세요>> ");
					String userPw = scn.nextLine();
					dao.userDelete(userId, userPw);
					continue;

				} else if (logMenu == 960704) {
					System.out.println("관리자로 로그인하셨습니다.");
					while (true) {
						System.out.println("1.회원관리 2.게시글관리 3.문의사항 4.로그아웃");
						System.out.print("선택>> ");
						int menu = Integer.parseInt(scn.nextLine());

						if (menu == 1) {
							while (true) {
								System.out.println("<회원목록>");
								List<Writer> writers = dao.showWriter();
								for (Writer wrt : writers) {
									System.out.println(wrt.showAll());
								}
								System.out.println("1.비밀번호수정 2.삭제 3.이전");
								System.out.print("선택>> ");
								int menu1 = Integer.parseInt(scn.nextLine());

								if (menu1 == 1) {
									System.out.print("수정할 회원의 아이디를 입력하세요>> ");
									String userId1 = scn.nextLine();
									System.out.print("비밀번호 수정>> ");
									String userPw1 = scn.nextLine();
									dao.updateUser(userId1, userPw1);

								} else if (menu1 == 2) {
									System.out.println("삭제할 회원의 아이디를 입력하세요>> ");
									String userId1 = scn.nextLine();
									dao.deleteUser(userId1);

								} else if (menu1 == 3) {
									break;

								} else {
									System.out.println("없는 메뉴입니다. 다시 입력해주세요");
									System.out.println();
								}
							}
						} else if (menu == 2) {
							while (true) {
								System.out.println("<게시글 목록>");
								System.out.println();
								List<Board> boards = dao.boardSearch();
								for (Board brd : boards) {
									System.out.println(brd.manageBrd());
								}
								System.out.println();
								System.out.println("1.삭제 2.이전");
								System.out.print("선택>> ");
								int menu1 = Integer.parseInt(scn.nextLine());

								if (menu1 == 1) {
									System.out.println("삭제할 게시글의 고유번호 입력>> ");
									int boardNo = Integer.parseInt(scn.nextLine());
									dao.deleteUserM(boardNo);

								} else if (menu1 == 2) {
									break;
								}
							}

						} else if (menu == 3) {
							System.out.println("<문의사항>");
							List<Message> messages = dao.readMsg("manager");
							for (Message msg : messages) {
								System.out.println(msg.toString());
							}
							System.out.println();
						} else if (menu == 4) {
							System.out.println("로그아웃합니다.");
							System.out.println();
							break;
						} else {
							System.out.println("없는 메뉴입니다. 다시 선택해 주세요.");
							System.out.println();
						}
					}

				} else if (logMenu == 9) {
					System.out.println("프로그램을 종료합니다.");
					scn.close();
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

		} // end of while

	} // end of main
} // end of class
