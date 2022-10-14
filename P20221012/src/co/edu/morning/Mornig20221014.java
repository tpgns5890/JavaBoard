package co.edu.morning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Member implements Serializable {
	String id;
	String name;
	int point;

	public Member(String id, String name, int point) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return id + "  " + name + "  " + point;
	}

}

public class Mornig20221014 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("1.멤버입력 2.목록보기 3.종료");
				System.out.print("메뉴를 입력하세요>> ");
				int menu = scn.nextInt();
				scn.nextLine();
				if (menu == 1) {
					while (true) {
						System.out.print("회원아이디>> ");
						String id = scn.nextLine();
						System.out.print("회원이름>> ");
						String name = scn.nextLine();
						System.out.print("회원포인트>> ");
						int point = scn.nextInt();

						ArrayList<Member> mem = new ArrayList<>();
						mem.add(new Member(id, name, point));
						System.out.println("입력완료!!");
						System.out.println("1.추가입력 2.입력완료");
						System.out.print("선택>> ");
						int inMenu = scn.nextInt();
						scn.nextLine();
						if (inMenu == 1) {
							continue;
						} else if (inMenu == 2) {
							try (FileWriter fw = new FileWriter("C:/temp/memberList.txt", true);
									BufferedWriter bw = new BufferedWriter(fw);) {
								for (Member m : mem) {
									bw.write(m.getId() + " " + m.getName() + " " + m.getPoint() + "\n");
								}
								bw.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						} else {
							System.out.println("다시시도하세요");
						}
					}
				}

				else if (menu == 2) {
					try (FileReader fr = new FileReader("c:/temp/memberlist.txt");
							BufferedReader br = new BufferedReader(fr);) {
						while (true) {
							Member mem1 = null;
							String members = br.readLine();
							if (members == null) {
								break;
							}
							System.out.println(members);
						}
						System.out.println();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (menu == 3) {
					System.out.println("종료합니다");
					break;
				} else {
					System.out.println("잘못된 값입니다.");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
}
