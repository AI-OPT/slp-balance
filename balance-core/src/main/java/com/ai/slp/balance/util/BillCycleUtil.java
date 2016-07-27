package com.ai.slp.balance.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.opt.sdk.util.DateUtil;

public final class BillCycleUtil {

    private static final Logger LOG = LoggerFactory.getLogger(BillCycleUtil.class);

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_FORMAT2 = "yyyyMMdd HH:mm:ss";
    
    public static final String DATETIME_FORMAT3 = "yyyy-MM-dd HH:mm:ss.SS";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMM = "yyyyMM";
    public static final String YYYY_MM = "yyyy-MM";
    
    public static final String YYYY = "yyyy";

    public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    public static final String BILL_CYCLE_ID = "BILL_CYCLE_ID";
    
    public static final String PAY_DATE = "PAY_DATE";
    
    public static final String PAY_DATE_NEW = "PAY_DATE_NEW";
    
    public static final String BILL_GEN_TYPE_DAY = "D";
    
    public static final String BILL_GEN_TYPE_WEEK = "W";
    
    public static final String BILL_GEN_TYPE_MONTH = "M";
    
    private BillCycleUtil() {
        // 禁止实例化
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }
    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                     calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }
   
    /**
     * 根据D/W/M获取周期Id和最晚还款时间
     * @param DateType
     * @param amount
     * @return
     * @author zhangzd
     * @ApiDocMethod
     * @ApiCode
     */
    public static Map<String,Object> getBillCycleIdAndPayDate(String billGenType,int amount){
    	LOG.info("当前账单周期类型："+billGenType);
    	LOG.info("当前还款时限周期数："+amount);
    	Map<String,Object> timeMap = new HashMap<String,Object>();
		String dateFormatStr = "";
		int DateType = Calendar.DAY_OF_MONTH;
		//
		if(billGenType.equals(BILL_GEN_TYPE_DAY)){
			//天
			dateFormatStr = YYYYMMDD;
			DateType = Calendar.DAY_OF_MONTH;
		}else if(billGenType.equals(BILL_GEN_TYPE_WEEK)){
			//周
			dateFormatStr = YYYYMMDD;
			DateType = Calendar.WEEK_OF_YEAR;
		}else if(billGenType.equals(BILL_GEN_TYPE_MONTH)){
			//月
			dateFormatStr = YYYYMM;
			DateType = Calendar.MONTH;
		}
		
		//
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormatStr);
		
		Calendar cal = Calendar.getInstance();
		
		//
		String startTime = sdf.format(cal.getTime());
		Calendar nowCalendar = cal;
		String nowYear = String.valueOf(nowCalendar.get(Calendar.YEAR));
		String nowWeek = String.valueOf(nowCalendar.get(Calendar.WEEK_OF_YEAR)+12);
		LOG.info("当前日期第几周："+nowCalendar.get(Calendar.WEEK_OF_YEAR));
		//
		cal.add(DateType, amount);
		
		String endTime = sdf.format(cal.getTime());
		//天
		if(billGenType.equals(BILL_GEN_TYPE_DAY)){
			timeMap.put(BILL_CYCLE_ID, startTime);
			timeMap.put(PAY_DATE, endTime);
			
		}else if(billGenType.equals(BILL_GEN_TYPE_WEEK)){
		//周	
			timeMap.put(BILL_CYCLE_ID, nowYear+nowWeek);
			SimpleDateFormat sdfNew = new SimpleDateFormat(YYYYMMDD);
			//获取多少周以后的周的最后一天的日期
			timeMap.put(PAY_DATE, sdfNew.format(getLastDayOfWeek(cal.get(Calendar.YEAR),cal.get(Calendar.WEEK_OF_YEAR))));
			
		}else if(billGenType.equals(BILL_GEN_TYPE_MONTH)){
			timeMap.put(BILL_CYCLE_ID, startTime);
			timeMap.put(PAY_DATE, endTime+cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		SimpleDateFormat payDateFormat = new SimpleDateFormat(YYYY_MM);
		String payDateMonth = payDateFormat.format(cal.getTime());
		//
		timeMap.put(PAY_DATE_NEW,payDateMonth+"-"+timeMap.get(PAY_DATE).toString().substring(6)+ " 00:00:00.0");
		
		//
		LOG.info("BILL_CYCLE_ID:"+timeMap.get(BILL_CYCLE_ID));
		LOG.info("PAY_DATE:"+timeMap.get(PAY_DATE));
		LOG.info("year:"+cal.get(Calendar.YEAR));
		LOG.info("month:"+ cal.get(Calendar.MONTH));
		LOG.info("day:"+ cal.get(Calendar.DAY_OF_MONTH));
		LOG.info("WeeksInWeekYear:"+ cal.getWeeksInWeekYear());
		LOG.info("getActualMaximum:"+cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		LOG.info("getActualMaximum 周的最后一天:"+cal.getActualMaximum(Calendar.DAY_OF_WEEK));
		LOG.info("getActualMaximum DAY_OF_WEEK_IN_MONTH:"+cal.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH));
		LOG.info("getWeekYear:"+ cal.getWeekYear());
		LOG.info("cl.get(Calendar.WEEK_OF_YEAR):"+cal.get(Calendar.WEEK_OF_YEAR));
		//
		return timeMap;
		
	}
    
    public static void main(String[] args){
    	//DateUtil.getTimeInterval(Calendar.DAY_OF_MONTH, -5);
    	Map<String,Object> map = BillCycleUtil.getBillCycleIdAndPayDate("W",28);
    	System.out.println("日期转换timstamp："+Timestamp.valueOf(map.get(PAY_DATE_NEW).toString()));
    	System.out.println(Timestamp.valueOf("2018-11-30 00:00:00")); 
    	
    	//
    	String timeStr = DateUtil.getDateString(DateUtil.getSysDate(),DATE_FORMAT );
    	Timestamp timestamp = DateUtil.getTimestamp(timeStr+" 23:59:59", DATETIME_FORMAT);
    	System.out.println("timeStr:"+timeStr);
    	System.out.println("timestamp:"+timestamp);
    }
}
