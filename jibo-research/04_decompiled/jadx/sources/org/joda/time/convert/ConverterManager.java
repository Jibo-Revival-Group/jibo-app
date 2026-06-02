package org.joda.time.convert;

/* JADX INFO: loaded from: classes2.dex */
public final class ConverterManager {

    /* JADX INFO: renamed from: a */
    private static ConverterManager f15976a;

    /* JADX INFO: renamed from: b */
    private ConverterSet f15977b = new ConverterSet(new Converter[]{ReadableInstantConverter.f15990a, StringConverter.f15994a, CalendarConverter.f15975a, DateConverter.f15986a, LongConverter.f15987a, NullConverter.f15988a});

    /* JADX INFO: renamed from: c */
    private ConverterSet f15978c = new ConverterSet(new Converter[]{ReadablePartialConverter.f15992a, ReadableInstantConverter.f15990a, StringConverter.f15994a, CalendarConverter.f15975a, DateConverter.f15986a, LongConverter.f15987a, NullConverter.f15988a});

    /* JADX INFO: renamed from: d */
    private ConverterSet f15979d = new ConverterSet(new Converter[]{ReadableDurationConverter.f15989a, ReadableIntervalConverter.f15991a, StringConverter.f15994a, LongConverter.f15987a, NullConverter.f15988a});

    /* JADX INFO: renamed from: e */
    private ConverterSet f15980e = new ConverterSet(new Converter[]{ReadableDurationConverter.f15989a, ReadablePeriodConverter.f15993a, ReadableIntervalConverter.f15991a, StringConverter.f15994a, NullConverter.f15988a});

    /* JADX INFO: renamed from: f */
    private ConverterSet f15981f = new ConverterSet(new Converter[]{ReadableIntervalConverter.f15991a, StringConverter.f15994a, NullConverter.f15988a});

    /* JADX INFO: renamed from: a */
    public static ConverterManager m16730a() {
        if (f15976a == null) {
            f15976a = new ConverterManager();
        }
        return f15976a;
    }

    protected ConverterManager() {
    }

    /* JADX INFO: renamed from: a */
    public InstantConverter m16731a(Object obj) {
        InstantConverter instantConverter = (InstantConverter) this.f15977b.m16734a(obj == null ? null : obj.getClass());
        if (instantConverter != null) {
            return instantConverter;
        }
        throw new IllegalArgumentException("No instant converter found for type: " + (obj == null ? "null" : obj.getClass().getName()));
    }

    public String toString() {
        return "ConverterManager[" + this.f15977b.m16733a() + " instant," + this.f15978c.m16733a() + " partial," + this.f15979d.m16733a() + " duration," + this.f15980e.m16733a() + " period," + this.f15981f.m16733a() + " interval]";
    }
}
