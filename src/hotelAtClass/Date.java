package hotelAtClass;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public boolean isLeapYear() {
        return isLeapYear(this.year);
    }

    private static boolean checkMonth(int month) {
        return (month >= 1) && (month <= 12);
    }

    public static int getDayPerMonth(int month, int year) {
        if (checkMonth(month)) {
            int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (isLeapYear(year) && (month == 2)) {
                return 29;
            } else {
                return days[month];
            }
        } else {
            return 0;
        }
    }

    public int getDayPerMonth() {
        return getDayPerMonth(this.month, this.year);
    }


    public int daysFromNewYear() {
        int rez = 0;
        for (int i = 1; i < this.month; i++) {
            rez += getDayPerMonth(i, this.year);
        }
        rez += this.day;
        return rez;
    }

    public int daysToNewYear() {
        return getDaysPerYear() - this.daysFromNewYear();
    }

    public static int getDaysPerYear(int year) {
        return (isLeapYear(year) ? 366 : 365);
    }

    public int getDaysPerYear() {
        return getDaysPerYear(this.year);
    }

    @Override
    public int compareTo(Date o) {
        int dateComparing = this.day - o.day;
        int monthComparing = this.month - o.month;
        int yearComparing = this.year - o.year;

        if (dateComparing == 0 && monthComparing == 0 && yearComparing == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int compareTo(Date o) {
        int comparingYear = this.year - o.year;
        int comparingMonth = this.month - o.month;
        int comparingDay = this.day - o.day;
        if (comparingYear == 0) {
            if (comparingMonth == 0) {
                return comparingDay;
            }
            else {
                return comparingMonth;
            }
        } else {
            return comparingYear;
        }
    }
}
