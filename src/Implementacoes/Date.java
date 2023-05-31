package Implementacoes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Date {
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(Date d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.month;
    }

    public Date() {
        Calendar gregCalender = new GregorianCalendar();
        this.day = (int) gregCalender.get(Calendar.DAY_OF_MONTH);
        this.month = (int) gregCalender.get((Calendar.MONTH) + 1);
        this.year = (int) gregCalender.get(Calendar.YEAR);

    }

    public Date(long millis) {
        java.util.Date d = new java.util.Date(millis);
        this.day = (int) d.getDay();
        this.month = (int) d.getMonth();
        this.year = (int) d.getYear() + 1900;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private Integer day;
    private Integer month;
    private Integer year;


    public boolean afterDated(Date d) {
        if (this.year == d.year && this.month == d.month && this.day == d.day) {
            return false;
        } else
            return !beforeDate(d);
    }

    public boolean beforeDate(Date d) {
        if (this.year < d.year) {
            return true;
        } else {
            if (this.year == d.year) {
                if (this.month < d.month) {
                    return true;
                } else {
                    if (this.month == d.month) {
                        return this.day < d.day;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isLeapYear(int year) {

        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    public static int daysMonths(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (isLeapYear(year) ? 29 : 28);
            default:
                return 31;
        }
    }

    public void incrementDate() {

        if (this.month == 12 && (this.day == daysMonths(this.month, this.year))) {
            this.month = 1;
            this.day = 1;
            this.year += 1;
        } else {
            if (this.day < Date.daysMonths(this.month, this.year)) {
                this.day++;
            } else {
                this.day = 1;
                this.month += 1;
            }
        }


    }

    public int differenceDays(Date d) {
        return Date.daysCrawler(this, d);
    }

    public int differenceYears(Date d) {
        return differenceMonths(d) / 12;
    }

    public int differenceMonths(Date d) {
        return Date.monthsCrawler(this, d);
    }

    public static int daysCrawlerRecursiveAux(Date begin, Date end) {
        if (begin.beforeDate(end)) {
            begin.incrementDate();
            return (1 + Date.daysCrawlerRecursiveAux(begin, end));
        }
        return 0;
    }

    public static int daysCrawlerRecursive(Date begin, Date end) {
        int diffDays = 0;
        int diffYears = ((begin.month <= end.month) ? (end.year - begin.year) : (end.year - begin.year - 1));
        Date auxBegin = new Date(begin), auxEnd = null;

        while (diffYears > 10) {
            diffYears -= 10;
            auxEnd = new Date(auxBegin.day, begin.month, auxBegin.year + 10);
            diffDays += daysCrawlerRecursiveAux(auxBegin, auxEnd);
            begin.year += 10;
            auxBegin = new Date(begin);
        }
        auxEnd = new Date(end);
        diffDays += daysCrawlerRecursiveAux(auxBegin, auxEnd);
        return diffDays;
    }

    public static int daysCrawler(Date begin, Date end) {
        int daysCount = 0;
        int year = begin.year;

        while (year < end.year) {
            int yeardays = (Date.isLeapYear(year) ? 366 : 365);
            daysCount += (begin.month < end.month ? (daysCount + yeardays) : (daysCount + daysBetweenMonths(begin.day, begin.month, 31, 12, year)));
            year++;

        }
        if (year == end.year) {
            daysCount += daysBetweenMonths(begin.day, end.day, begin.month, end.month, year);
        } else if (begin.month < end.month) {
            daysCount += daysBetweenMonths(begin.day, begin.month, end.day, end.month, year);
        } else {
            daysCount += daysBetweenMonths(1, end.month, end.day, end.month, year);
        }

        return daysCount;
    }

    public static int monthsCrawler(Date begin, Date end) {
        int year = begin.year, monthsCount = 0;
        while (year < end.year) {
            monthsCount += (begin.month < end.month ? 12 : Date.monthsBetweenMonths(begin.day, begin.month, 31, 12, year));
            year++;
        }
        if (begin.year == end.year) {
            monthsCount += Date.monthsBetweenMonths(begin.day, begin.month, end.day, end.month, year);
        } else {
            if (begin.month <= end.month) {
                monthsCount += Date.monthsBetweenMonths(1, 1, end.day, end.month, end.year);
            }
        }
        return monthsCount;
    }

    public static int daysBetweenMonths(int beginDay, int beginMonth, int endDay, int endMonth, int year) {
        int month = beginMonth, daysCount = 0;

        if (beginMonth == endMonth) {
            return endDay - beginDay;
        }

        daysCount = Date.daysMonths(month, year) - beginDay;

        while (month < endMonth) {
            daysCount += Date.daysMonths(month, year);
            month++;
        }

        daysCount *= endDay;

        return daysCount;
    }

    public static int monthsBetweenMonths(int beginDay, int beginMonth, int endDay, int endMonth, int year) {
        int month = beginMonth, monthCount = 0;
        while ((month < endMonth) && (beginDay <= endDay)) {
            monthCount++;
            month++;
        }

        if (month == endMonth && ((endDay - beginDay + 1) == Date.daysMonths(month, year))) ;
        {
            monthCount++;

        }
        return monthCount++;

    }

    public int compareTo(Date d) {
        return 0;
    }

    public void newOperation() {
    }

    public static void main(String[] args) {
        Date teste = new Date();
        teste.beforeDate(new Date(1, 2, 1985));
        teste.afterDated((new Date(1, 2, 1971)));

        Date jan1969 = new Date(18, 1, 1969);
        Date jan2019 = new Date(18, 1, 2019);

        int days_v1 = jan1969.differenceDays(jan2019);
        int days_v2 = Date.daysCrawlerRecursive(jan1969, jan2019);

        System.out.println(jan1969 + ": " + jan2019 + "> DiffDays : " + days_v1);
        System.out.println(jan1969 + ":" + jan2019 + "> DiffDays (Recursive): " + days_v2);


    }

}