package com.summer.springcloud.springcloudcommon.utils.dateUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Summer_DM
 * @Summary TODO  专用于日期类型的格式化、转换等   其他的关于证件、银行卡之类的其他校验可以使用直接HuTool（官网API学习： https://www.hutool.cn/docs/#/），已经在pom文件中引入了依赖
 * @Version 1.0
 * @Date 2021/8/17 下午 01:54
 **/
public class DateUtils  extends org.apache.commons.lang.time.DateUtils{

    public static final String DEFAULT_DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 根据默认的格式格式化当前时间
     * @return 格式化后的日期字符串
     */
    public static String format() {
        return format(new Date(), DEFAULT_DATEFORMAT);
    }

    /**
     * 根据默认的格式格式化时间
     * @param date 要格式化的日期/时间
     * @return 格式化后的日期字符串
     */
    public static String format(Date date) {
        return format(date, DEFAULT_DATEFORMAT);
    }

    /**
     * 根据格式格式化日期/时间
     * @param date    要格式化的日期/时间
     * @param pattern 要使用的规则
     * @return 格式化后的日期字符串
     */
    public static String format(Date date, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_DATEFORMAT;
        }
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 根据默认格式把文本转换成日期/时间，
     * 转换出错，抛出异常
     * @param text 要转换的文本
     * @return 转换后的日期
     */
    public static Date parse(String text) {
        return parse(text, DEFAULT_DATEFORMAT);
    }

    /**
     * 根据格式把文本转换成日期/时间，
     * 转换出错，抛出异常
     * @param text    要转换的文本
     * @param pattern 要使用的规则
     * @return 转换后的日期
     */
    public static Date parse(String text, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_DATEFORMAT;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(text);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Date parse happen error![" + text + "," + pattern + "]");
        }
    }

    /**
     * 判断当前日期字符串是否为完全日期时间，
     * 并以1900年1月1日 0:00:00为基准校正为一个日期对象。
     * @param text 表示日期时间的字符串；
     * @return String 日期型数值。
     */
    public static Date parseDefault(String text) {
        if (text == null) {
            return null;
        }
        text = text.replaceAll("00:00:00.0", "0:0:0");
        text = text.replace('.', '-');
        text = text.replace('/', '-');
        if (text.indexOf("-") == -1) {
            //没有日期段。
            text = "1900-1-1 " + text;
        }
        if (text.indexOf(":") == -1) {
            //没有时间段
            text = text + " 0:0:0";
        }
        return parse(text);
    }

    /**
     * 根据月 返回格式为YYYYMMDD的日期
     *
     * @param month
     * @return
     */
    public static String getDateByMonth(int month) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);    //得到前month的日期
        System.out.println("开始日期为：" + format.format(cal.getTime()));
        return format.format(cal.getTime());
    }

    /**
     * 根据天数 返回格式为YYYYMMDD的日期
     * @param day
     * @return
     */
    public static String getDateByDay(int day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        if (day == 0) {
            return format.format(new Date());
        }
        cal.add(Calendar.DATE, day);    //得到前month的日期
        System.out.println("开始日期为：" + format.format(cal.getTime()));
        return format.format(cal.getTime());
    }

    /**
     * 根据类型 返回格式为YYYYMMDD的日期
     *
     * @param type 0:默认 全部| 1:近一周|2：近一月|3：近一季度|4:近半年|5：近一年
     * @return
     */
    public static String getDateByType(int type) {
        String startDate = "";
        if (type == 1) {
            startDate = DateUtils.getDateByDay(-7);
        } else if (type == 2) {
            startDate = DateUtils.getDateByMonth(-1);
        } else if (type == 3) {
            startDate = DateUtils.getDateByMonth(-4);
        } else if (type == 4) {
            startDate = DateUtils.getDateByMonth(-6);
        } else if (type == 5) {
            startDate = DateUtils.getDateByMonth(-12);
        }
        return startDate;
    }

    /**
     * 字符串时间转换
     * @param str  202012150203 ---->2020-12-15,02:03
     * @return
     */
    public static String getDateByString(String str) {
        String year = str.substring(0, 4);
        String month = str.substring(4, 6);
        String day = str.substring(6, 8);
        String time = year + "-" + month + "-" + day;
        if (str.length()>8){
            String hours = str.substring(8,10);
            String min = str.substring(10,str.length());
            return time +","+ hours +":"+ min;
        }
        return time;
    }
}
