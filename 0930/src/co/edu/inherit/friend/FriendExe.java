package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();
	

	// 친구 등록- 학교/회사/친구...
	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("1.친구등록 2.친구조회 3.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			switch (menu) {
			case 1:
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int submenu = scn.nextInt();
				if (submenu == 1) {
					addComFriend();
				} else if (submenu == 2) {
					addUnivFriend();
				} else if (submenu == 3) {
					addFriend();
				} else {
					System.out.println("잘못된 메뉴 선택입니다");
				}
				break;
			case 2:
				searchFriend();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다");
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}

	}// end of exe
		// 추가 메소드()

	public void addComFriend() {
		System.out.println("회사친구 등록 메뉴입니다.");
		System.out.print("회사친구 이름을 입력하세요>> ");
		scn.nextLine();
		String name = scn.nextLine();
		System.out.print("회사친구의 연락처를 입력하세요>> ");
		String phone = scn.nextLine();
		System.out.print("회사친구의 회사명을 입력하세요>> ");
		String company = scn.nextLine();
		System.out.print("회사친구의 부서명을 입력하세요>> ");
		String dept = scn.nextLine();

		Friend comFrnd = new ComFriend(name, phone, company, dept);
		
		friends.add(comFrnd);
//		for (int i = 0; i < friends.size(); i++) {
//			if (friends.get(i) == null) {
//				friends.add(comFrnd);
//				System.out.println("회사 친구가 등록되었습니다.");
//				System.out.println();
//				break;
//			}
//		}
	}

	public void addUnivFriend() {
		System.out.println("대학친구 등록 메뉴입니다.");
		System.out.print("대학친구 이름을 입력하세요>> ");
		scn.nextLine();
		String name = scn.nextLine();
		System.out.print("대학친구의 연락처를 입력하세요>> ");
		String phone = scn.nextLine();
		System.out.print("대학친구의 학교명을 입력하세요>> ");
		String univ = scn.nextLine();
		System.out.print("대학친구의 전공을 입력하세요>> ");
		String major = scn.nextLine();

		Friend univFrnd = new UnivFriend(name, phone, univ, major);
		
		friends.add(univFrnd);
//		for (int i = 0; i < friends.size(); i++) {
//			if (friends.get(i) == null) {
//				friends.add(univFrnd);
//				System.out.println("대학 친구가 등록되었습니다.");
//				System.out.println();
//				break;
//			}
//		}
	}

	public void addFriend() {
		System.out.println("친구 등록 메뉴입니다.");
		System.out.print("친구 이름을 입력하세요>> ");
		scn.nextLine();
		String name = scn.nextLine();
		System.out.print("친구의 연락처를 입력하세요>> ");
		String phone = scn.nextLine();

		Friend frnd = new Friend(name, phone);
		
		friends.add(frnd); //비워져있는 위치에 한건 등록
		
//		for (int i = 0; i < friends.size(); i++) {
//			if (friends.get(i) == null) {
//				friends.add(frnd);
//				System.out.println("친구가 등록되었습니다.");
//				System.out.println();
//				break;
//			}
//		}
	}

	public void searchFriend() {
		// 자바 문자열 포함 검색
		System.out.println("친구 검색 기능입니다.");
		System.out.print("검색할 문자를 입력하세요>> ");
		scn.nextLine();
		String search = scn.nextLine();
		
		for(int i = 0; i<friends.size(); i++) {
			//Friend 클래스의 상속. Friend, ComFriend, UnivFriend
			Object frnd = friends.get(i); //Object
			if(frnd instanceof Friend) { //frnd 변수의 타입이 어떤 유형의 클래스인지...
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
			
		}
		
//		for (int i = 0; i < friends.size(); i++) {
//			if (friends[i] != null &&  friends[i].getName().contains(search)) {
//				System.out.println(friends[i].get(i).showInfo());
//			} else {
//				System.out.println("찾는 이름이 없습니다.");
//				break;}
//		}
		
	}
}
