package com.aosica.common.util;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * date 工具类。
 */
public final class DateUtil {
	
	private DateUtil() {}

	public static final String YYYY = "yyyy";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYYMMDD = "yyyy/MM/dd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public static final String YMDGB_DATA = "yyyy年MM月dd日";
	public static final String YMDTHMSGB_DATA = "yyyy年MM月dd日 HH时mm分ss秒";
	public static final String YMD24H_DATA = "yyyy-MM-dd HH:mm:ss";
	public static final String[] DAYNAMES = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

	public static final Calendar INSTANCE = Calendar.getInstance();


	/**
	 * 一天的毫秒数
	 */
	public static final int ONE_DATE_MILLISECOND = 24 * 60 * 60 * 1000;

	/**
	 * 当前年
	 * @return
	 */
	public static int getYear() {

		return INSTANCE.get(Calendar.YEAR);
	}

	/**
	 * 当前月
	 * @return
	 */
	public static int getMonth() {
		return INSTANCE.get(Calendar.MONTH)+1;
	}

	/**
	 * 当前日
	 * @return
	 */
	public static int getDay() {
		return INSTANCE.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 当前周
	 * @return
	 */
	public static int getWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 当前星期
	 * @return
	 */
	public static String getDayOfWeek() {
//		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = INSTANCE.get(Calendar.DAY_OF_WEEK);
		return DAYNAMES[dayOfWeek - 1];
	}

	/**
	 * 当前年月日
	 * @return
	 */
	public static String getYMD_CN() {
//		Calendar now = Calendar.getInstance();
		return INSTANCE.get(Calendar.YEAR) + "年" + (INSTANCE.get(Calendar.MONTH) + 1) + "月" + INSTANCE.get(Calendar.DAY_OF_MONTH) + "日";
	}


	/**
	 *  获取当前日期
	 *  根据指定的格式
	 * @return
	 */
	public static String getCurrentDate(String format) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return  sdf.format(new Date());
		}
		catch (Exception e) {
			e.printStackTrace();
			return  null ;
		}
	}
	
	/**
	 * Date转字符串
	 * @param format
	 * @return
	 */
	public static String format(String format) {
		return format(new Date(), format);
	}

	/**
	 * Date转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format) {
		date = date == null ? new Date() : date;
		String result = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			result = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 字符串转Date
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseDate(String dateStr, String format) {
		if (dateStr == null || dateStr.length() == 0) {
			return null;
		}
		Date date = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateStr);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}
	
	/**
	 * String转long
	 * @param date
	 * @param format
	 * @return
	 */
//	public static long string2long(String date, String format) {
//		try {
//			if (StringUtils.isBlank(format)) {
//				format = YMDHMS_DATA;
//			}
//			SimpleDateFormat sf = new SimpleDateFormat(format);
//			return sf.parse(date).getTime();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0l;
//	}
	
	/**
	 * long转string
	 * @param time
	 * @param format
	 * @return
	 */
//	public static String long2String(long time, String format) {
//		try {
//			if (StringUtils.isBlank(format)) {
//				format = YMDHMS_DATA;
//			}
//			SimpleDateFormat sf = new SimpleDateFormat(format);
//			Date date = new Date(time);
//			return sf.format(date);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
	
	/**
	 * long转Date
	 * @param time
	 * @param format
	 * @return
	 */
//	public static Date long2Date(long time, String format) {
//		try {
//			if (StringUtils.isBlank(format)) {
//				format = YMDHMS_DATA;
//			}
//			Date date = new Date(time);
//			return date;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new Date();
//	}
	

	/**
	 * 两日期相差X天
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDayDiff(Date start, Date end) {
		return (int) ((end.getTime() - start.getTime()) / ONE_DATE_MILLISECOND);
	}

	/**
	 * 指定日期加X天
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDay(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);
		return calendar.getTime();
	}

	/**
	 * 指定日期加X月
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addMonth(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	
	/**
	 * 指定日期加X毫秒数
	 * @param date
	 * @param millisecond
	 * @return
	 */
	public static String addTime(Date date, long millisecond) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = "";
        try {
        	//1分钟60秒，1秒1000毫秒
            str = sim.format(date.getTime()+millisecond);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return str;
	}

	/**
	 * 当天结束时间
	 * @param date
	 * @return
	 */
	public static Date dayEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
	
	/**
	 * 本周所有日期
	 * @return
	 */
	public static List<String> getWeekList() {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK );
        if (c.getFirstDayOfWeek() == Calendar.SUNDAY) {
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
        for (int i=1;i<=7;i++) {
            c.add(Calendar.DAY_OF_MONTH, 1);
            list.add(sdf.format(c.getTime()));
        }
        return list;
	}
	
	/**
	 * 本月最后一天
	 * @return
	 */
	public static Date getLastDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 给某个日期加时间
	 * @param date
	 * @return
	 */
	public static String getStartTimeByDay(String date){
		return date + " 00:00:00";
	}

	/**
	 * 给某个日期加时间
	 * @param date
	 * @return
	 */
	public static String getEndTimeByDay(String date){
		return date + " 23:59:59";
	}

	/**
	 * 获取当前日期是星期几<br>
	 * @param date
	 * @return 当前日期是星期几
	 */
	public static  String getWeekOfDate(Date date) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	/**
	 * @desc 得到两个时间段的天数
	 * @param startDate
	 * @return
	 * @author dwj
	 * @date 2018/3/27 15:30
	 */
	public static List<String> getDayList(String startDate, String endDate) {
		List<String> list = new ArrayList<String>();
		Date sd = DateUtil.parseDate(startDate, DateUtil.YYYY_MM_DD);
		Date ed = DateUtil.parseDate(endDate, DateUtil.YYYY_MM_DD);
		Calendar cal = Calendar.getInstance();
		while (sd.compareTo(ed) <= 0) {
			list.add(DateUtil.format(sd, DateUtil.YYYY_MM_DD));

			cal.setTime(sd);
			cal.add(Calendar.DATE, 1);
			String sdStr = DateUtil.format(cal.getTime(), DateUtil.YYYY_MM_DD);
			sd = DateUtil.parseDate(sdStr, DateUtil.YYYY_MM_DD);
		}
		return list;
	}

	/**
	 *  获取指定日期下一个月
	 *
	 *   dataStr : yyyy-MM
	 * @return
	 */
	public static String getNextMonthStr(String dataStr) {
		Date date = parseDate(dataStr, DateUtil.YYYY_MM);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);

		return format(cal.getTime(),YYYY_MM) ;
	}


	/**
	 * 获取过去第几天的日期
	 *
	 * @param past
	 * @return
	 */
	public static String getPastDate(int past,Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - past);
		Date today = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = sdf.format(today);
		return result;
	}
	public static void main(String[] args) {
//		System.out.println("当前年 - "+getYear());
//		System.out.println("当前月 - "+getMonth());
//		System.out.println("当前日 - "+getDay());
//		System.out.println("当前周 - "+getWeek());
//		System.out.println("当前星期 - "+getDayOfWeek());
//		System.out.println("当前星期 - "+getWeekOfDate(new Date()));
//		System.out.println("当前年月日 - "+getYMD_CN());
//		System.out.println("Date转字符串 - "+format(new Date(), "yyyy-MM-dd HH:mm:ss"));
//		System.out.println("字符串转Date - "+parseDate("2016-03-24 12:12:12", "yyyy-MM-dd HH:mm:ss"));
//		System.out.println("String转long - "+string2long("2016-03-24 12:12:12", "yyyy-MM-dd HH:mm:ss"));
//		System.out.println("long转String - "+long2String(1502506858703L,""));
//		System.out.println("两日期相差X天 - "+getDayDiff(new Date(), new Date()));
//		System.out.println("指定日期加X天 - "+addDay(new Date(), 2));
//		System.out.println("指定日期加X月 - "+addMonth(new Date(), 2));
//		System.out.println("指定日期加X毫秒数 - "+addTime(new Date(), 20L * 60L * 1000L));
//		System.out.println("当天结束时间 - "+dayEnd(new Date()));
//		System.out.println("本周所有日期 - "+getWeekList());
//		System.out.println("本月最后一天 - "+getLastDayOfMonth());

//		System.out.println("Date转字符串 - "+format(new Date(), YM));
//
//		System.out.println("Date转字符串 - "+format(new Date(), YMD_DATA));
//		String str = getPastDate(7,new Date());
//		List<String> list = getDayList(str,"2019-09-07");
//		System.out.println(list);

		System.out.println(getNextMonthStr("2019-09"));
	}
}
