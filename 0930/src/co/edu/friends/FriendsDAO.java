package co.edu.friends;

import java.util.Scanner;

public class FriendsDAO {
	private static FriendsDAO instance = new FriendsDAO();
	private FriendsDAO() {};
	public static FriendsDAO getInstance() {
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Friends[] myFriends = new Friends[100];
	
//	1.친구등록
	public void addFriends() {
		System.out.println("친구 등록 기능입니다.");
		System.out.print("친구 번호를 입력하세요 >>> ");
		int fNo = scn.nextInt();
		scn.nextLine();
		System.out.print("친구 이름을 입력하세요 >>> ");
		String fName = scn.nextLine();
		System.out.print("전화번호를 입력하세요 >>> ");
		String pNo = scn.nextLine();

		Friends friend = new Friends(fNo, fName, pNo);
		for (int i = 0; i < myFriends.length; i++) {
			if(myFriends[i] != null && myFriends[i].getFriendsNo() == fNo){
				System.out.println("이미 존재하는 친구 번호입니다");
				break;
			}
			if (myFriends[i] == null) {
				myFriends[i] = friend;
				System.out.println(fNo + "번 친구가 등록되었습니다");
				System.out.println();
				break;
			}
		}
	}
	
//	2.친구목록
	public void friendsList() {
		System.out.println("친구 목록 기능입니다.");
		for (Friends friend : myFriends) {
			if (friend != null) {
				System.out.println(friend.toString());
				System.out.println();
			}
		}
	}
	
//	3.친구수정
	public void updateFriends() {
		System.out.println("친구 수정 기능입니다.");
		System.out.print("수정할 친구 번호를 입력하세요>>> ");
		int fNo = scn.nextInt();
		scn.nextLine();
		System.out.print("수정할 친구이름을 입력하세요 >>> ");
		String fName = scn.nextLine();
		System.out.print("수정할 전화번호를 입력하세요 >>> ");
		String pNo = scn.nextLine();
		Friends friend = new Friends(fNo, fName, pNo);
		for (int i = 0; i < myFriends.length;) {
			if (myFriends[i] != null && myFriends[i].getFriendsNo() == fNo) {
				myFriends[i] = friend;
				System.out.println(fNo + "번 친구가 수정되었습니다");
				System.out.println();
				break;
			}
		}
	}
	
//	4.친구삭제
	public void delFriends() {
		System.out.println("친구 삭제 기능입니다.");
		System.out.print("삭제할 친구 번호를 입력하세요>>> ");
		int fNo = scn.nextInt();
		for (int i = 0; i < myFriends.length;) {
			if (myFriends[i] != null && myFriends[i].getFriendsNo() == fNo) {
				myFriends[i] = null;
				System.out.println(fNo +"번 친구가 삭제되었습니다.");
				System.out.println();
				break;
			}
		System.out.println("존재하지 않는 친구 번호입니다.");
		System.out.println();
		break;
		}
	}
	
//	5.전체메뉴
	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("1.친구등록 2.친구목록 3.친구수정 4.친구삭제 9.종료");
			System.out.println("선택>> ");
			
			int menu = scn.nextInt();
			switch(menu) {
			case 1:
				addFriends();
				break;
			case 2:
				friendsList();
				break;
			case 3:
				updateFriends();
				break;
			case 4:
				delFriends();
				break;
			case 9:
				run = false;
				break;
			default:
				System.out.println("잘못된 기능입니다.");
			}
		}
		System.out.println("프로그램 종료.");
	}	
}
