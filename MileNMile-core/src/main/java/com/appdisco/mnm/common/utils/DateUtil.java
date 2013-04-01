/*
 * @(#)DateUtil.java
 *
 * Copyright (c) 2009 Moduad, Inc.
 * All rights reserved.
 */
package com.appdisco.mnm.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/** 
 * Class desciption here.
 *
 * @author Sehwan Noh (sehwan@java2go.net)
 * @version 1.0
 */
public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String TIME_PATTERN = "HH:mm:ss";

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        return sdf.format(new Date());
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
        return sdf.format(new Date());
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
        return sdf.format(new Date());
    }

    public static String addDays(String strDate, int days) throws ParseException {
        Date date = convertStringToDate(strDate, DATE_PATTERN);
        return convertDateToString(DateUtils.addDays(date, days), DATE_PATTERN);
    }

    public static String convertDateToString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static Date convertStringToDate(String strDate, String pattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(addDays("2009-02-08", -30));
    }

}
