package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi {

    /* JADX INFO: renamed from: a */
    private final List<String> f6572a;

    /* JADX INFO: renamed from: b */
    private final Object f6573b;

    private zzbi(Object obj) {
        this.f6573b = zzbq.m7373a(obj);
        this.f6572a = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    public final zzbi m7372a(String str, Object obj) {
        List<String> list = this.f6572a;
        String str2 = (String) zzbq.m7373a(str);
        String strValueOf = String.valueOf(obj);
        list.add(new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(strValueOf).length()).append(str2).append("=").append(strValueOf).toString());
        return this;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder(100).append(this.f6573b.getClass().getSimpleName()).append('{');
        int size = this.f6572a.size();
        for (int i = 0; i < size; i++) {
            sbAppend.append(this.f6572a.get(i));
            if (i < size - 1) {
                sbAppend.append(", ");
            }
        }
        return sbAppend.append('}').toString();
    }
}
