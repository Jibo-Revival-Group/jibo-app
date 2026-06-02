package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;

/* JADX INFO: loaded from: classes.dex */
public abstract class StatsEvent extends zzbfm implements ReflectedParcelable {
    /* JADX INFO: renamed from: a */
    public abstract long mo7479a();

    /* JADX INFO: renamed from: b */
    public abstract int mo7480b();

    /* JADX INFO: renamed from: c */
    public abstract long mo7481c();

    /* JADX INFO: renamed from: d */
    public abstract String mo7482d();

    public String toString() {
        long jMo7479a = mo7479a();
        int iMo7480b = mo7480b();
        long jMo7481c = mo7481c();
        String strMo7482d = mo7482d();
        return new StringBuilder(String.valueOf("\t").length() + 51 + String.valueOf("\t").length() + String.valueOf(strMo7482d).length()).append(jMo7479a).append("\t").append(iMo7480b).append("\t").append(jMo7481c).append(strMo7482d).toString();
    }
}
