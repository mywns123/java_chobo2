package java_chobo2.ch10;

import java.util.Calendar;
import java.util.Date;

public class DateToCalendarEx {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2020, 0, 1);
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE));

		Date d = new Date();
		d.setYear(19);
		d.setMonth(0);
		d.setDate(1);
		System.out.printf("%tF %n", d);

		convCalToDate(cal);
		convDateToCal(d);

	}

	private static void convCalToDate(Calendar cal) {
		System.out.println("convert Calendar To Date()");

		Date d = new Date(cal.getTimeInMillis());
		System.out.printf("%tF %n", d);

	}

	private static void convDateToCal(Date d) {
		System.out.println("convDateToCal()");

		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE));
	}

}
