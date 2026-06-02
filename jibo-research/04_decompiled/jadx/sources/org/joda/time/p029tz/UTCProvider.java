package org.joda.time.p029tz;

import java.util.Collections;
import java.util.Set;
import org.joda.time.DateTimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class UTCProvider implements Provider {

    /* JADX INFO: renamed from: a */
    private static final Set<String> f16191a = Collections.singleton("UTC");

    @Override // org.joda.time.p029tz.Provider
    /* JADX INFO: renamed from: a */
    public DateTimeZone mo17009a(String str) {
        if ("UTC".equalsIgnoreCase(str)) {
            return DateTimeZone.f15751a;
        }
        return null;
    }

    @Override // org.joda.time.p029tz.Provider
    /* JADX INFO: renamed from: a */
    public Set<String> mo17008a() {
        return f16191a;
    }
}
