package org.blank.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static void main(String[] args) {

    }

    /**
     * 默认显示日期时间的格式 yyyyMMdd
     */
    public static final String YYYYMMDD = "yyyyMMdd";
    /**
     * 默认显示日期时间的格式 yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /**
     * 默认显示日期的格式 yyyy-MM-dd
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 默认显示日期时间的格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认显示日期时间的格式yyyy-MM年月
     */
    public static final String YYYY_MM = "yyyy-MM";

    /**
     * 计算两个日期之间的天数差
     *
     * @param startDate  起始日期
     * @param endDate    结束日期
     * @param ignoreTime 是否忽略时间（只比较日期，不比较时间）
     * @return 日期差
     */
    public int getDaysBetween(Date startDate, Date endDate, boolean ignoreTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long startTime = cal.getTimeInMillis();
        cal.setTime(endDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long endTime = cal.getTimeInMillis();
        if (ignoreTime) {
            return (int) ((endTime - startTime) / (1000 * 3600 * 24));
        } else {
            return (int) ((endTime - startTime) / (24 * 60 * 60 * 1000));
        }
    }

    /*
     * 计算两个日期之间的月数差
     * @param startDate 起始日期
     * @param endDate 结束日期
     * @return 月数差
     */
    public int getMonthsBetween(Date startDate, Date endDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int startYear = cal.get(Calendar.YEAR);
        int startMonth = cal.get(Calendar.MONTH);
        cal.setTime(endDate);
        int endYear = cal.get(Calendar.YEAR);
        int endMonth = cal.get(Calendar.MONTH);
        return (endYear - startYear) * 12 + (endMonth - startMonth);
    }

    /*
     * 计算两个日期之间的年数差
     * @param startDate 起始日期
     * @param endDate 结束日期
     * @return 年数差
     */
    public int getYearsBetween(Date startDate, Date endDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int startYear = cal.get(Calendar.YEAR);
        cal.setTime(endDate);
        int endYear = cal.get(Calendar.YEAR);
        return endYear - startYear;
    }

    /*
     * 将日期转换为字符串
     * @param date 日期
     * @param format 日期格式
     * @return 日期字符串
     */
    public String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /*
     * 将字符串转换为日期
     * @param strDate 日期字符串
     * @param format 日期格式
     * @return 日期
     * @throws ParseException 解析异常
     */
    public Date parseDate(String strDate, String format) throws ParseException {
        if (strDate == null || format == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(strDate);
    }

    /*
     * 比较两个日期的大小
     * @param date1 日期1
     * @param date2 日期2
     * @return 0：相等，1：date1 > date2，-1：date1 < date2
     */
    public int compareDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        if (time1 == time2) {
            return 0;
        } else if (time1 > time2) {
            return 1;
        } else {
            return -1;
        }
    }

    /*
     * 将日期转换成指定格式的字符串
     * @param date 日期
     * @param format 格式
     * @return 格式化后的日期字符串
     * @throws IllegalArgumentException 如果日期或格式为空
     */
    public String format(Date date, String format) {
        if (date == null || format == null) {
            throw new IllegalArgumentException("Date and format must not be null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /*
     * 将字符串转换成指定格式的日期
     * @param dateString 日期字符串
     * @param format 日期格式
     * @return 日期
     * @throws ParseException 解析异常
     * @throws IllegalArgumentException 如果日期字符串或格式为空
     */
    public Date parse(String dateString, String format) throws ParseException {
        if (dateString == null || format == null) {
            throw new IllegalArgumentException("Date string and format must not be null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateString);
    }

    /**
     * 指定日期并且增加年份(b为true加反之减)
     *
     * @param date
     * @param years
     * @param b
     * @return
     */
    public Date addYears(Date date, int years, boolean b) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (b) {
            calendar.add(Calendar.YEAR, years);
        } else {
            calendar.add(Calendar.YEAR, -years);
        }
        return calendar.getTime();
    }

    /**
     * 指定日期并且增加月份(b为true加反之减)
     *
     * @param date
     * @param months
     * @param b
     * @return
     */
    public Date addMonth(Date date, int months, boolean b) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (b) {
            calendar.add(Calendar.MONTH, months);
        } else {
            calendar.add(Calendar.MONTH, -months);
        }
        return calendar.getTime();
    }

    /**
     * 指定日期并且增加天数(b为true加反之减)
     *
     * @param date
     * @param days
     * @param b
     * @return
     */
    public Date addDays(Date date, int days, boolean b) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (b) {
            calendar.add(Calendar.DATE, days);
        } else {
            calendar.add(Calendar.DATE, -days);
        }
        return calendar.getTime();
    }

    /**
     * 当前月
     *
     * @return
     */
    public int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.MONTH) + 1;
        return i;
    }

    /**
     * 获取当前时间 天数
     *
     * @return
     */
    public int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }
}