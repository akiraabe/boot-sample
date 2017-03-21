package com.sample.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUtil {

	public static Calendar addYear(Calendar baseDate, int addYear) {
		return add(baseDate, addYear, 0, 0, 0, 0, 0, 0);
	}

	public static Calendar addMonth(Calendar baseDate, int addMonth) {
		return add(baseDate, 0, addMonth, 0, 0, 0, 0, 0);
	}

	public static Date addMonth(Date baseDate, int addMonth) {

		Calendar cal = new GregorianCalendar();
		cal.setTime(baseDate);
		Calendar addedDate = add(cal, 0, addMonth, 0, 0, 0, 0, 0);

		if (isLastDayOfMonth(baseDate)
				&& !isLastDayOfMonth(addedDate.getTime())) {
			Calendar cal01 = addMonth(addedDate, 1);
			Calendar cal02 = new GregorianCalendar(cal01.get(Calendar.YEAR), cal01
					.get(Calendar.MONTH), 01);
			return addDate(cal02, -1).getTime();

		} else {
			return addedDate.getTime();
		}
	}

	public static Calendar addDate(Calendar baseDate, int addDate) {
		return add(baseDate, 0, 0, addDate, 0, 0, 0, 0);
	}

	public static Calendar addHour(Calendar baseDate, int addHour) {
		return add(baseDate, 0, 0, 0, addHour, 0, 0, 0);
	}

	public static Calendar addMinute(Calendar baseDate, int addMinute) {
		return add(baseDate, 0, 0, 0, 0, addMinute, 0, 0);
	}

	public static Calendar addSecond(Calendar baseDate, int addSecond) {
		return add(baseDate, 0, 0, 0, 0, 0, addSecond, 0);
	}

	public static Calendar add(Calendar cal, int addYera, int addMonth,
			int addDate, int addHour, int addMinute, int addSecond,
			int addMillisecond) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		cal.add(Calendar.YEAR, addYera);
		cal.add(Calendar.MONTH, addMonth);
		cal.add(Calendar.DATE, addDate);
		cal.add(Calendar.HOUR_OF_DAY, addHour);
		cal.add(Calendar.MINUTE, addMinute);
		cal.add(Calendar.SECOND, addSecond);
		cal.add(Calendar.MILLISECOND, addMillisecond);
		return cal;
	}

	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isLastDayOfMonth(Date date) {

		Calendar cal01 = new GregorianCalendar();
		cal01.setTime(date);

		int dd = cal01.getActualMaximum(Calendar.DATE);

		Calendar cal02 = new GregorianCalendar(cal01.get(Calendar.YEAR), cal01
				.get(Calendar.MONTH), dd);

		if (cal01.equals(cal02)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Date getLastDayOfMonth(Date date) {

		Calendar cal01 = new GregorianCalendar();
		cal01.setTime(date);

		int dd = cal01.getActualMaximum(Calendar.DATE);

		Calendar cal02 = new GregorianCalendar(cal01.get(Calendar.YEAR), cal01
				.get(Calendar.MONTH), dd);

		return cal02.getTime();
	}

	public static boolean isDate(Object object) {

		String in = object.toString();

		Date date;

		DateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = formater.parse(in);
		} catch (ParseException e) {
			return false;
		}
//		System.out.println(date);

		String dateStr = formater.format(date);
		
		if (dateStr.equals(in)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Date toDate(Object object) {

		String in = object.toString();

		Date date;

		DateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = formater.parse(in);
			return date;
		} catch (ParseException e) {
			return null;
		}

	}
	
	
	public static int differenceMonth(String strDate1, String strDate2) 
	    throws ParseException {
	    Date date1 = DateFormat.getDateInstance().parse(strDate1);
	    Date date2 = DateFormat.getDateInstance().parse(strDate2);
	    return differenceMonth(date1,date2);
	}
	public static int differenceMonth(Date date1, Date date2) {
	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(date1);
	    cal1.set(Calendar.DATE, 1);
	    Calendar cal2 = Calendar.getInstance(); 
	    cal2.setTime(date2);
	    cal2.set(Calendar.DATE, 1);
	    int count = 0;
	    if (cal1.before(cal2)) {
	        while (cal1.before(cal2)) {
	            cal1.add(Calendar.MONTH, 1);
	            count--;
	        }
	    } else {
	        count--;
	        while (!cal1.before(cal2)) {
	            cal1.add(Calendar.MONTH, -1);
	            count++;
	        }
	    }
	    return count;
	}

	public static int differenceDay(Date toDate, Date fromDate) {
		Calendar to = Calendar.getInstance();
		to.setTime(toDate);
		Calendar from = Calendar.getInstance();
		from.setTime(fromDate);
		
		long day = (to.getTimeInMillis() - from.getTimeInMillis())/1000/60/60/24;
		return (int) day;
	}

}