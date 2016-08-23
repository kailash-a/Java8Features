package in.ka.java8.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * @author kailash
 *LocalDate
 *LocalTIme
 *Month
 *Year
 *YearMonth
 */

public class DateAndTimeApi {
	public static void main(String[] args) {
		// get today date.
		LocalDate today = LocalDate.now();
		System.out.println("today date is :" + today);
		Exercise ex = new Exercise();
		ex.returnLengthofMonthsV2(2016);
		//
		ex.listAllMondays(8);

	}
}

class Exercise {
	// Write an example that, for a given year, reports the length of each month
	// within that year.
	// version 1
	public void returnLengthofMonths(int year) {
		LocalDate date = LocalDate.of(year, 1, 1);
		for (int i = 1; i <= 12; i++) {
			System.out.println(date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " : " + date.lengthOfMonth());
			date = date.plusMonths(1);
		}
	}

	// version 2 with using Month enum and YearMonth Class
	public void returnLengthofMonthsV2(int year) {
		for (Month m : Month.values()) {
			YearMonth yearMonth = YearMonth.of(year, m);
			System.out.println(m.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " : " + yearMonth.lengthOfMonth());
		}
	}

	// Write an example that, for a given month of the current year, lists all
	// of the Mondays in that month.
	// version 1
	public void listAllMondays(int month) {
		LocalDate date = LocalDate.of(2016, month, 1);

		for (int i = 0; i <= 7; i++) {
			if (date.getDayOfWeek().toString().equalsIgnoreCase("Monday")) {
				break;
			}
			date = date.plusDays(1);
		}

		// list all the mondays
		System.out.println(date);
		int i = 1;
		do {
			System.out.println(i++ + " Monday Date is " + date);
			date = date.plusDays(7);
			// System.out.println(date+" date");
		} while (date.getMonthValue() == month);

	}
}