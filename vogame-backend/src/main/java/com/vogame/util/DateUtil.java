package com.vogame.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    private static ZoneId defaultZoneId = ZoneId.systemDefault();

    public static Date localDateToDate(LocalDate in) {
        return Date.from(in.atStartOfDay(defaultZoneId).toInstant());
    }

    public static LocalDate dateToLocalDate(Date in) {
        return in.toInstant().atZone(defaultZoneId).toLocalDate();
    }

}
