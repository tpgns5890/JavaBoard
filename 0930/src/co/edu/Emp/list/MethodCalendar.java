package co.edu.Emp.list;

import java.util.Calendar;

public class MethodCalendar {

	private static MethodCalendar instance = new MethodCalendar();

	private MethodCalendar() {
	}

	public static MethodCalendar getInstance() {
		return instance;
	}

	public void makeCal(int year, int month) {
		System.out.println("     >>>>"+year+"년 "+ month + "월<<<<");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
//		요일 출력
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();

//		1일의 위치 지정
		for (int i = 0; i < getFirstDay(year, month); i++) {
			System.out.printf("%4s", " ");
		}
//		날짜 출력
		for (int i = 1; i <= getLastDate(year, month); i++) {
			System.out.printf("%4d", i);
			if ((i + getFirstDay(year, month)) % 7 == 0) {
				System.out.println();
			}
		}
	} // end of makeCal()

	public static int getFirstDay(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		return cal.get(Calendar.DAY_OF_WEEK) - 1 ; //1
	} // end of getFirstDay

	public static int getLastDate(int year, int month) {
		// switch...case..구문.
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		return cal.getActualMaximum(Calendar.DATE);
		
	}// end of getLastDate
} // end of class