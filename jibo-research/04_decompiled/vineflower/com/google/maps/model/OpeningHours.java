package com.google.maps.model;

import org.joda.time.LocalTime;

public class OpeningHours {
   public Boolean openNow;
   public OpeningHours.Period[] periods;
   public Boolean permanentlyClosed;
   public String[] weekdayText;

   public static class Period {
      public OpeningHours.Period.OpenClose close;
      public OpeningHours.Period.OpenClose open;

      public static class OpenClose {
         public OpeningHours.Period.OpenClose.DayOfWeek day;
         public LocalTime time;

         public enum DayOfWeek {
            FRIDAY,
            MONDAY,
            SATURDAY,
            SUNDAY,
            THURSDAY,
            TUESDAY,
            UNKNOWN,
            WEDNESDAY;

            private static final OpeningHours.Period.OpenClose.DayOfWeek[] $VALUES = new OpeningHours.Period.OpenClose.DayOfWeek[]{
               OpeningHours.Period.OpenClose.DayOfWeek.SUNDAY,
               OpeningHours.Period.OpenClose.DayOfWeek.MONDAY,
               OpeningHours.Period.OpenClose.DayOfWeek.TUESDAY,
               OpeningHours.Period.OpenClose.DayOfWeek.WEDNESDAY,
               OpeningHours.Period.OpenClose.DayOfWeek.THURSDAY,
               OpeningHours.Period.OpenClose.DayOfWeek.FRIDAY,
               OpeningHours.Period.OpenClose.DayOfWeek.SATURDAY,
               OpeningHours.Period.OpenClose.DayOfWeek.UNKNOWN
            };
         }
      }
   }
}
