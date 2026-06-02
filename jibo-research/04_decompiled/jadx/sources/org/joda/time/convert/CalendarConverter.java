package org.joda.time.convert;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;

/* JADX INFO: loaded from: classes2.dex */
final class CalendarConverter extends AbstractConverter implements InstantConverter, PartialConverter {

    /* JADX INFO: renamed from: a */
    static final CalendarConverter f15975a = new CalendarConverter();

    protected CalendarConverter() {
    }

    @Override // org.joda.time.convert.AbstractConverter, org.joda.time.convert.InstantConverter
    /* JADX INFO: renamed from: b */
    public Chronology mo16728b(Object obj, Chronology chronology) {
        DateTimeZone dateTimeZoneM16523a;
        if (chronology == null) {
            Calendar calendar = (Calendar) obj;
            try {
                dateTimeZoneM16523a = DateTimeZone.m16527a(calendar.getTimeZone());
            } catch (IllegalArgumentException e) {
                dateTimeZoneM16523a = DateTimeZone.m16523a();
            }
            return mo16727a(calendar, dateTimeZoneM16523a);
        }
        return chronology;
    }

    @Override // org.joda.time.convert.AbstractConverter
    /* JADX INFO: renamed from: a */
    public Chronology mo16727a(Object obj, DateTimeZone dateTimeZone) {
        if (obj.getClass().getName().endsWith(".BuddhistCalendar")) {
            return BuddhistChronology.m16667b(dateTimeZone);
        }
        if (obj instanceof GregorianCalendar) {
            long time = ((GregorianCalendar) obj).getGregorianChange().getTime();
            if (time == Long.MIN_VALUE) {
                return GregorianChronology.m16705b(dateTimeZone);
            }
            if (time == Long.MAX_VALUE) {
                return JulianChronology.m16710b(dateTimeZone);
            }
            return GJChronology.m16670a(dateTimeZone, time, 4);
        }
        return ISOChronology.m16708b(dateTimeZone);
    }

    @Override // org.joda.time.convert.AbstractConverter, org.joda.time.convert.InstantConverter
    /* JADX INFO: renamed from: a */
    public long mo16726a(Object obj, Chronology chronology) {
        return ((Calendar) obj).getTime().getTime();
    }

    @Override // org.joda.time.convert.Converter
    /* JADX INFO: renamed from: a */
    public Class<?> mo16729a() {
        return Calendar.class;
    }
}
