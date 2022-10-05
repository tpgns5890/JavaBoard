package co.edu.Emp.list;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		today.set(2020, 1, 1); //2022년 10월 1일
//		System.out.println("요일정보: " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("날짜정보: " + today.get(Calendar.DATE));
		System.out.println("월정보: " + today.get(Calendar.MONTH));
		System.out.println("월말정보: " + today.getActualMaximum(Calendar.DATE));
	}
}
