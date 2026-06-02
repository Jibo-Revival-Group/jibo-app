package org.joda.time;

import java.io.Serializable;
import org.joda.time.base.BaseDateTime;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTime extends BaseDateTime implements Serializable, ReadableDateTime {
    public DateTime() {
    }

    public DateTime(long j, DateTimeZone dateTimeZone) {
        super(j, dateTimeZone);
    }

    public DateTime(long j, Chronology chronology) {
        super(j, chronology);
    }

    public DateTime(Object obj) {
        super(obj, (Chronology) null);
    }

    public DateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, Chronology chronology) {
        super(i, i2, i3, i4, i5, i6, i7, chronology);
    }

    @Override // org.joda.time.base.AbstractInstant, org.joda.time.ReadableDateTime
    /* JADX INFO: renamed from: a */
    public DateTime mo16433a() {
        return this;
    }
}
