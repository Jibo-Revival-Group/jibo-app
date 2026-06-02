package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzal;
import java.util.Locale;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgg {

    /* JADX INFO: renamed from: a */
    private final String f6936a;

    /* JADX INFO: renamed from: b */
    private final String f6937b;

    /* JADX INFO: renamed from: c */
    private final zzal f6938c;

    /* JADX INFO: renamed from: d */
    private final int f6939d;

    private zzbgg(String str, String str2) {
        this.f6937b = str2;
        this.f6936a = str;
        this.f6938c = new zzal(str);
        this.f6939d = m7768a();
    }

    public zzbgg(String str, String... strArr) {
        this(str, m7769a(strArr));
    }

    /* JADX INFO: renamed from: a */
    private final int m7768a() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f6936a, i)) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private static String m7769a(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(str);
        }
        sb.append(']').append(TokenParser.f15715SP);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private final boolean m7770a(int i) {
        return this.f6939d <= i;
    }

    /* JADX INFO: renamed from: d */
    private final String m7771d(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f6937b.concat(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m7772a(String str, Object... objArr) {
        if (m7770a(3)) {
            Log.d(this.f6936a, m7771d(str, objArr));
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m7773b(String str, Object... objArr) {
        Log.i(this.f6936a, m7771d(str, objArr));
    }

    /* JADX INFO: renamed from: c */
    public final void m7774c(String str, Object... objArr) {
        Log.w(this.f6936a, m7771d(str, objArr));
    }
}
