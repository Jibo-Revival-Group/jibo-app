package com.google.firebase.perf.network;

import android.util.Log;
import com.google.android.gms.internal.zzevv;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    /* JADX INFO: renamed from: a */
    public static Long m9328a(HttpMessage httpMessage) {
        try {
            Header firstHeader = httpMessage.getFirstHeader("content-length");
            if (firstHeader != null) {
                return Long.valueOf(Long.parseLong(firstHeader.getValue()));
            }
        } catch (NumberFormatException e) {
            Log.d("FirebasePerformance", "The content-length value is not a valid number");
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static String m9329a(HttpResponse httpResponse) {
        String value;
        Header firstHeader = httpResponse.getFirstHeader("content-type");
        if (firstHeader == null || (value = firstHeader.getValue()) == null) {
            return null;
        }
        return value;
    }

    /* JADX INFO: renamed from: a */
    public static void m9330a(zzevv zzevvVar) {
        if (zzevvVar.m8533a() == null) {
            zzevvVar.m8534b();
        }
        zzevvVar.m8541d();
    }
}
