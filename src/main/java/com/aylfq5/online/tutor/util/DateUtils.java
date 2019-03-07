package com.aylfq5.online.tutor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/1 11:14
 * @Version: 1.0
 */
public class DateUtils {
    public static Date parse(Long returnTime) {
        if (returnTime == null) {
            return null;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
            String result = format.format(new Date(returnTime));
            return format.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Long timeDifferLong(Long startTime, Long returnTime) {
        if (startTime == null || returnTime == null) {
            return null;
        }
        return returnTime - startTime;
    }
}
