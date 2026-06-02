package com.google.maps.model;

import org.joda.time.LocalTime;

/* JADX INFO: loaded from: classes.dex */
public class OpeningHours {
    public Boolean openNow;
    public Period[] periods;
    public Boolean permanentlyClosed;
    public String[] weekdayText;

    public static class Period {
        public OpenClose close;
        public OpenClose open;

        public static class OpenClose {
            public DayOfWeek day;
            public LocalTime time;

            public enum DayOfWeek {
                SUNDAY,
                MONDAY,
                TUESDAY,
                WEDNESDAY,
                THURSDAY,
                FRIDAY,
                SATURDAY,
                UNKNOWN
            }
        }
    }
}
