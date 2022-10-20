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
			System.out.println("1.로그인 2.회원가입 3.비밀번호찾기 4.회원탈퇴 9. 종료");
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
									dao.boardInsert(userId, boardTitle, boardContent);
								} else if (mainMenu == 2) {
									int pageNum = 1, from = 0, to = 0;
									while (true) {
										List<Board> boards = dao.boardSearch();
										int totalCnt = boards.size();  //전체 목록수
										int totalPage = (int) Math.ceil(totalCnt / 5.0); //총 페이지 수
										from = (pageNum - 1) * 5; //현재페이지의 첫번째 값
										to = (pageNum * 5) - 1;		//현재 페이지의 마지막 값
										System.out.println(
												"==================================글 전체 목록===============================");
										for (int j = 0; j < totalCnt; j++) {
											if (j >= from && j <= to) {
												System.out.println(boards.get(j).showAll());
											}
										}
										System.out.println("======================================" + pageNum + "/"
												+ totalPage + "==================================");
										System.out.println("1.이전페이지 2.다음페이지 3.상세조회 4.이전");
										System.out.print("선택>> ");
										try {
											int boardMenu = Integer.parseInt(scn.nextLine());

											if (boardMenu == 1) {
												if (pageNum > 1) {
													pageNum = pageNum - 1;
												} else {
													System.out.println("<첫번째 페이지입니다>");
													System.out.println();
												}
											} else if (boardMenu == 2) {
												if (pageNum < totalPage) {
													pageNum = pageNum + 1;
												} else {
													System.out.println("<마지막 페이지입니다>");
													System.out.println();
												}
											} else if (boardMenu == 3) {
												System.out.print("조회할 게시글의 고유번호를 입력해주세요>> ");
												int no = Integer.parseInt(scn.nextLine());
												while (true) {
													Board brd = dao.getBoard(no);
													List<Reply> reply = dao.showReply(no);
													if (brd != null) {
														System.out.println("\n========================" + no
																+ "번 게시글 상세보기==========================");
														System.out.println(brd.toString());
														for (Reply replys : reply) {
															System.out.println(replys.toString());
														}
														System.out.println(
																"==================================================================\n");
														System.out.println("1.댓글쓰기 2.댓글삭제 3.작성자에게 쪽지 쓰기 4.상세보기종료");
														System.out.print("선택>> ");
														int repMenu = Integer.parseInt(scn.nextLine());
														if (repMenu == 1) {
															System.out.print("댓글내용 입력>> ");
															String repContent = scn.nextLine();
															dao.insertRep(no, userId, repContent);
														} else if (repMenu == 2) {
															System.out.print("삭제할 댓글 고유번호>> ");
															int repNo = Integer.parseInt(scn.nextLine());
															dao.deleteRep(userId, repNo);
														} else if (repMenu == 3) {
															System.out.print("제목 입력>> ");
															String msgTitle = scn.nextLine();
															System.out.print("내용 입력>> ");
															String msgContent = scn.nextLine();
															String getMsg = brd.getWriter();
															dao.sendMsg(msgTitle, msgContent, getMsg, userId);
														} else if (repMenu == 4) {
															break;
														}
													}else {
														System.out.println("해당하는 게시글이 없습니다.");
														break;
													}
												}

											} else if (boardMenu == 4) {
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
										System.out.println(
												"\n===============================내가 쓴 글===============================");
										List<Board> boards = dao.MyBoards(userId);
										for (Board brd : boards) {
											System.out.println(brd.myBoards());
										}
										System.out.println(
												"======================================================================\n");
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
												dao.updateBoard(userId, boardNum, boardTitle, boardContent);
											} else if (menu == 2) {
												System.out.print("삭제할 글 고유번호 입력>> ");
												int boardNum = Integer.parseInt(scn.nextLine());
												dao.deleteBoard(userId, boardNum);
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
									System.out.println("\n===================조회수 랭킹입니다===================");
									List<Board> boards = dao.ViewRank();
									int i = 1;
									for (Board brd : boards) {
										System.out.println(i + "위: " + brd.showRank());
										i++;
									}
									System.out.println("=====================!축하합니다!=====================\n\n");

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
									System.out.print("제목 입력>> ");
									String msgTitle = scn.nextLine();
									System.out.print("내용 입력>> ");
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
					System.out.print("이메일을 입력하세요>> ");
					String email = scn.nextLine();
					String key = dao.emailAuth(email);
					System.out.println("이메일로 인증번호가 발송되었습니다.");
					while (true) {
						System.out.print("인증번호 입력>> ");
						String AuthKey = scn.nextLine();
						if (AuthKey.equals(key)) {
							System.out.println("인증성공!");
							dao.userCreate(userId, userPw, userName, email);
							break;
						} else if (AuthKey.equals("quit")) {
							break;
						} else {
							System.out.println("인증실패 다시 시도해 주세요(종료:quit)");
							System.out.println();
						}
					}
				} else if (logMenu == 3) {
					System.out.println("아이디를 입력해주세요>> ");
					String findId = scn.nextLine();
					dao.findPw(findId);
					continue;
				} else if (logMenu == 4) {
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
								System.out.println();
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
