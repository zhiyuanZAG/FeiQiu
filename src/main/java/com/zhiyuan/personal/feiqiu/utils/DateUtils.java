package com.zhiyuan.personal.feiqiu.utils;


import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈时间的转换工具类〉
 *
 * @author zhiyuanzhang9
 * @create 2020/8/5 17:36
 * @since 1.0
 */
public class DateUtils {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final DateFormat DF_FULL = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
    public static final DateFormat DF_HMS = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final DateFormat DF_DATE = new SimpleDateFormat("yyyyMMdd");
    public static final DateFormat DF_CHINESE = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
    public static final DateFormat DF_YEAR = new SimpleDateFormat("yyyy");
    public static final DateFormat DF_MONTH = new SimpleDateFormat("MM");
    public static final DateFormat DF_DAY = new SimpleDateFormat("dd");
    public static final DateFormat DF_DOT = new SimpleDateFormat("yyyy.MM.dd");
    public static final DateFormat DF_BAR = new SimpleDateFormat(YYYY_MM_DD);


    /**
     * 获取日期格式(yyyy-MM-dd)的字符串
     *
     * @param date
     * @return
     */
    public static String dateToDayString(Date date) {
        if (date == null) {
            return "";
        }
        return DF_BAR.format(date);
    }

    /**
     * 获取日期格式(yyyy-MM-dd HH:mm:ss)的字符串
     *
     * @param date
     * @return
     */
    public static String dateToSecondString(Date date) {
        if (date == null) {
            return "";
        }
        return DF_FULL.format(date);
    }

    /**
     * 根据传入的format格式化日期字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String dateFormat(Date date, DateFormat dateFormat) {
        String dateString = "";
        if (date != null) {
            dateString = dateFormat.format(date);
        }
        return dateString;
    }


    /**
     * 日期格转换为字符串
     *
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        String dateStr = DF_HMS.format(date);
        return dateStr;
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return
     */
    public static String formatDT(Date date) {
        if (date != null) {
            return DF_FULL.format(date);
        }
        return "";
    }

    /**
     * 格式化时间
     *
     * @param localDateTime
     * @return
     */
    public static String localDateTimeFormatDT(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
            return dtf2.format(localDateTime);
        }
        return "";
    }

    /**
     * 获取传入日期所在月份的第一天
     *
     * @param calendar
     * @return
     * @throws Exception
     */
    public static Date getFirstDayOfMonth(Calendar calendar) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 本月的第一天
        calendar.set(Calendar.DATE, 1);
        String dataStr = sdf.format(calendar.getTime());
        return sdf.parse(dataStr);
    }

    /**
     * @return String 返回类型
     * @throws ParseException
     * @Description: 获取当前月份开始时间
     * @author gaoxiang
     * @date 2016年4月26日 下午7:02:54
     */
    public static Date getThisMonthStartDate() throws ParseException {
        String ymDate = new SimpleDateFormat("yyyy-MM").format(new Date());
        return DF_FULL.parse(ymDate + "-01 00:00:00");
    }


    public static Date getThisDayStart(String dateStr){
        if (StringUtils.isEmpty(dateStr)){
            return null;
        }
        try {
            return DF_FULL.parse(dateStr + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getThisDayEnd(String dateStr){
        if (StringUtils.isEmpty(dateStr)){
            return null;
        }
        try {
            return DF_FULL.parse(dateStr + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {

    }


    /**
     * @return Date 返回类型
     * @throws ParseException
     * @Description: 获取当前月份下个月开始时间
     * @author gaoxiang
     * @date 2016年4月26日 下午7:10:26
     */
    public static Date getNextMonthStartDate() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        String ymDate = new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
        return DF_FULL.parse(ymDate + "-01 00:00:00");
    }

    /**
     * 获取一天的开始时间
     *
     * @return
     */
    public static Date getStartDateOfDay() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return (Date) currentDate.getTime().clone();
    }

    /**
     * 获取一天的结束时间
     *
     * @return
     */
    public static Date getEndDateOfDay() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return (Date) currentDate.getTime().clone();
    }

    /**
     * 获取指定日期的结束时间
     * @param date
     * @return
     */
    public static Date getEndDateOfDay(Date date){
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(date);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return (Date) currentDate.getTime().clone();
    }

//    public static boolean isCanBeParsedDateStr(String dateStr) {
//        if (StringUtils.isEmpty(dateStr)) {
//            return false;
//        }
//        try {
//            DateTime.parse(dateStr);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//    public static boolean isCannotBeParsedDateStr(String dateStr) {
//        return !isCanBeParsedDateStr(dateStr);
//    }
//
//    public static int getDifferenceOfDays(Date from, Date to) {
//        DateTime fromDateTime = new DateTime(from).millisOfDay().withMinimumValue();
//        DateTime toDateTime = new DateTime(to).millisOfDay().withMinimumValue();
//        return Days.daysBetween(fromDateTime, toDateTime).getDays();
//    }

    public static Date parseDate(String dateStr, String pattern) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, pattern);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 修改日期的展示格式
     *
     * @param dateStr      日期字符串
     * @param sourceFormat 原始的日期格式
     * @param destFormat   转换后的日期格式
     * @return
     */
    public static String changeFormat(String dateStr, String sourceFormat, String destFormat) {
        if (StringUtils.isBlank(sourceFormat)) {
            return sourceFormat;
        }
        try {
            SimpleDateFormat source = new SimpleDateFormat(sourceFormat);
            Date date = source.parse(dateStr);
            SimpleDateFormat destion = new SimpleDateFormat(destFormat);
            return destion.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @param date
     * @param days
     * @return
     * @Description (指定日期添加天数)
     */
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    /**
     * 获取日期格式(yyyyMMdd)的字符串
     *
     * @param date
     * @return
     */
    public static String dateToDayStringDot(Date date) {
        if (date == null) {
            return "";
        }
        String dateStr = DF_DOT.format(date);
        return dateStr;
    }
    public static Date formatDateYYYYMMDDHHMMSS(String str) throws ParseException{
        if (!org.springframework.util.StringUtils.isEmpty(str)){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sf.parse(str);
        }
        return null;
    }

    public static String formatDateYYYYMMDDHHMMSS(Date date){
        if(date!=null){
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
            return sf.format(date);
        }
        return "";
    }

    public static String formatDateYYMMDD(Date date) {
        if(date!=null){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            return sf.format(date);
        }
        return "";
    }

    /**
     * 增加月份
     * @param date
     * @return
     * @throws ParseException
     */
    public static String addMonth(String date,int num) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, num);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 增加分钟的时间
     *
     * @param date
     * @param minute
     * @return
     */
    public final static Date addMinute(Date date, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }

    /**
     * 两个日期相差多少分钟
     * @param startDay
     * @param endDay
     * @return
     */
    public static int reduceMinute(Date startDay,Date endDay) {
        return (int) ((endDay.getTime() - startDay.getTime()) / (1000*60));
    }

    public static Integer getMinuteBetweenNow(LocalDateTime target) {
        if (target ==null){
            return null;
        }
        LocalDateTime start = LocalDateTime.now();
        return Math.abs((int) ChronoUnit.MINUTES.between(start, target));
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime){
        if(localDateTime == null){
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        return Date.from(zdt.toInstant());
    }

    public static Long date2TimeStamp(String dateStr) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        return sdf.parse(dateStr).getTime();
    }
}
