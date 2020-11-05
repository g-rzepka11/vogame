package com.vogame.util;

import java.time.*;
import java.util.Date;

public class DateUtil {

    private static ZoneId defaultZoneId = ZoneId.systemDefault();

    public static Date localDateToDate(LocalDate in) {
        return Date.from(in.atStartOfDay(defaultZoneId).toInstant());
    }

    public static LocalDate dateToLocalDate(Date in) {
        return in.toInstant().atZone(defaultZoneId).toLocalDate();
    }

    public static Date startOfTodayUTC() {
        LocalDateTime startOfDay = startOfDayLocalDateTime();
        return localDateTimeToDateUTC(startOfDay);
    }

    public static LocalDateTime startOfDayLocalDateTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    public static Date localDateTimeToDateUTC(LocalDateTime startOfDay) {
        return Date.from(startOfDay.toInstant(ZoneOffset.UTC));
    }

}
