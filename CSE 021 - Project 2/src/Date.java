
public class Date {

	public int year;
	public int month;
	public int day;


	public Date(int y, int m, int d) {
		if (y >= 1900 && y <= 3000) {
			year = y;
		}
		if (m >= 1 && m <= 12) {
			month = m;
		}
		if (d >= 1900 && d <= 3000) {
			day = d;
		}
	}

	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}

	public int compare(Date dt) {
		int yearsDifferenceInDays = Math.abs((year * dayOfYear()) - (dt.year * dt.dayOfYear())) * 365;
		if (yearsDifferenceInDays/30 <= 60) {
			return yearsDifferenceInDays/30;}
		else return 60;


	}

	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays;
	}


	
}
