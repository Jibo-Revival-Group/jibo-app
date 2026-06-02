package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.ReadableDateTime;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDateTime extends AbstractInstant implements ReadableDateTime {
    protected AbstractDateTime() {
    }

    /* JADX INFO: renamed from: f */
    public int m16605f() {
        return mo16581d().mo16395E().mo16434a(mo16580c());
    }

    /* JADX INFO: renamed from: g */
    public int m16606g() {
        return mo16581d().mo16432z().mo16434a(mo16580c());
    }

    @Override // org.joda.time.base.AbstractInstant
    @ToString
    public String toString() {
        return super.toString();
    }
}
