package co.edu.friend;

import java.util.Scanner;

public class FriendListImpl implements FriendService {

	Friend[] friendList = new Friend[10]; // 친구정보 10명을 저장할 수 있는 공간생성 완료.
	Scanner scn = new Scanner(System.in);
	int idx = 0;

	private static FriendListImpl instance = new FriendListImpl();

	private FriendListImpl() {
	}

	public static FriendListImpl getInstance() {
		return instance;
	}

	@Override
	public void addFriend(Friend friend) {
		// 배열에 친구정보를 저장하도록 추가하세요.
		System.out.println("친구 등록 메뉴입니다.");
		System.out.print("친구 이름을 입력하세요>> ");
		String name = scn.nextLine();
		System.out.print("친구의 연락처를 입력하세요>> ");
		String phoneNumber = scn.nextLine();

		friendList[idx++] = new Friend(name, phoneNumber);

		System.out.println("친구가 정상적으로 등록되었습니다.");
	}

	public void addUnivFriend(Friend friend) {
		System.out.println("대학친구 등록 메뉴입니다.");
		System.out.print("대학친구 이름을 입력하세요>> ");
		String name = scn.nextLine();
		System.out.print("대학친구의 연락처를 입력하세요>> ");
		String phoneNumber = scn.nextLine();
		System.out.print("대학친구의 학교명을 입력하세요>> ");
		String college = scn.nextLine();
		System.out.print("대학친구의 전공을 입력하세요>> ");
		String major = scn.nextLine();

		friendList[idx++] = new UniFriend(name, phoneNumber, college, major);

		System.out.println("대학친구가 정상적으로 등록되었습니다.");
	}

	public void addComFriend(Friend friend) {
		System.out.println("회사친구 등록 메뉴입니다.");
		System.out.print("회사친구 이름을 입력하세요>> ");
		String name = scn.nextLine();
		System.out.print("회사친구의 연락처를 입력하세요>> ");
		String phoneNumber = scn.nextLine();
		System.out.print("회사친구의 회사명을 입력하세요>> ");
		String company = scn.nextLine();
		System.out.print("회사친구의 부서를 입력하세요>> ");
		String department = scn.nextLine();

		friendList[idx++] = new CoFriend(name, phoneNumber, company, department);

		System.out.println("회사 친구가 정상적으로 등록되었습니다.");
	}

	@Override
	public Friend[] friendList() {
		if (friendList != null) {
			for (int i = 0; i < idx; i++) {
				String result = friendList[i].getInfo();
				System.out.println(result);
			}
		} // 전체 친구목록을 반환하도록 수정하세요(반환유형에 유의).
		return friendList;

	}

	@Override
	public void modFriend(String name, String number) {

		Friend friend = new Friend(name, number);
		for (int i = 0; i < idx; i++) {
			if (friendList[i] != null && friendList[i].getName().equals(name)) {
				friendList[i] = friend;
				System.out.println("수정이 완료되었습니다.");
			}

		}

		// 친구이름을 찾아서 연락처를 변경하도록 추가하세요.
	}

	@Override
	public void delFriend(String phoneNo) {
		// 삭제할 연락처를 입력받아서 배열에서 찾아 삭제하세요.
		for (int i = 0; i < idx;) {
			if (friendList[i] != null && friendList[i].getPhoneNumber().equals(phoneNo)) {
				friendList[i] = null;
				System.out.println("친구가 삭제되었습니다.");
				System.out.println();
				break;
			}
			break;
		}

	}

}
