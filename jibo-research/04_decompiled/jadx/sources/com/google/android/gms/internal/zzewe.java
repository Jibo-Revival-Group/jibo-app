package com.google.android.gms.internal;

import android.util.Log;
import java.net.URI;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
final class zzewe extends zzewg {

    /* JADX INFO: renamed from: a */
    private final zzewv f7869a;

    zzewe(zzewv zzewvVar) {
        this.f7869a = zzewvVar;
    }

    /* JADX INFO: renamed from: a */
    private static URI m8580a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Log.w("FirebasePerformance", "getResultUrl throws exception", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m8581a(long j) {
        return j >= 0;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m8582b(long j) {
        return j >= 0;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m8583b(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }

    /* JADX INFO: renamed from: c */
    private static boolean m8584c(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt > 127) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.zzewg
    /* JADX INFO: renamed from: a */
    public final boolean mo8560a() {
        if (m8583b(this.f7869a.f7907a)) {
            String strValueOf = String.valueOf(this.f7869a.f7907a);
            Log.i("FirebasePerformance", strValueOf.length() != 0 ? "URL is missing:".concat(strValueOf) : new String("URL is missing:"));
            return false;
        }
        URI uriM8580a = m8580a(this.f7869a.f7907a);
        if (uriM8580a == null) {
            Log.i("FirebasePerformance", "URL cannot be parsed");
            return false;
        }
        String host = uriM8580a.getHost();
        if (!((host == null || m8583b(host) || host.length() > 255) ? false : true)) {
            Log.i("FirebasePerformance", "URL host is null or invalid");
            return false;
        }
        String scheme = uriM8580a.getScheme();
        if (!(scheme != null && (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)))) {
            Log.i("FirebasePerformance", "URL scheme is null or invalid");
            return false;
        }
        if (!(uriM8580a.getUserInfo() == null)) {
            Log.i("FirebasePerformance", "URL user info is null");
            return false;
        }
        int port = uriM8580a.getPort();
        if (!(port == -1 || port > 0)) {
            Log.i("FirebasePerformance", "URL port is less than or equal to 0");
            return false;
        }
        Integer num = this.f7869a.f7908b;
        if (!((num == null || num.intValue() == 0) ? false : true)) {
            String strValueOf2 = String.valueOf(this.f7869a.f7908b);
            Log.i("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf2).length() + 32).append("HTTP Method is null or invalid: ").append(strValueOf2).toString());
            return false;
        }
        if (this.f7869a.f7912f != null) {
            if (!(this.f7869a.f7912f.intValue() > 0)) {
                String strValueOf3 = String.valueOf(this.f7869a.f7912f);
                Log.i("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf3).length() + 38).append("HTTP ResponseCode is a negative value:").append(strValueOf3).toString());
                return false;
            }
        }
        if (this.f7869a.f7909c != null && !m8582b(this.f7869a.f7909c.longValue())) {
            String strValueOf4 = String.valueOf(this.f7869a.f7909c);
            Log.i("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf4).length() + 36).append("Request Payload is a negative value:").append(strValueOf4).toString());
            return false;
        }
        if (this.f7869a.f7910d != null && !m8582b(this.f7869a.f7910d.longValue())) {
            String strValueOf5 = String.valueOf(this.f7869a.f7910d);
            Log.i("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf5).length() + 37).append("Response Payload is a negative value:").append(strValueOf5).toString());
            return false;
        }
        if (this.f7869a.f7914h == null || this.f7869a.f7914h.longValue() <= 0) {
            String strValueOf6 = String.valueOf(this.f7869a.f7914h);
            Log.i("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf6).length() + 64).append("Start time of the request is null, or zero, or a negative value:").append(strValueOf6).toString());
            return false;
        }
        if (this.f7869a.f7915i != null && !m8581a(this.f7869a.f7915i.longValue())) {
            String strValueOf7 = String.valueOf(this.f7869a.f7915i);
            Log.i("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf7).length() + 49).append("Time to complete the request is a negative value:").append(strValueOf7).toString());
            return false;
        }
        if (this.f7869a.f7916j != null && !m8581a(this.f7869a.f7916j.longValue())) {
            String strValueOf8 = String.valueOf(this.f7869a.f7916j);
            Log.i("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf8).length() + 92).append("Time from the start of the request to the start of the response is null or a negative value:").append(strValueOf8).toString());
            return false;
        }
        if (this.f7869a.f7917k == null || this.f7869a.f7917k.longValue() <= 0) {
            String strValueOf9 = String.valueOf(this.f7869a.f7917k);
            Log.i("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf9).length() + 88).append("Time from the start of the request to the end of the response is null, negative or zero:").append(strValueOf9).toString());
            return false;
        }
        if (this.f7869a.f7912f == null) {
            Log.i("FirebasePerformance", "Did not receive a HTTP Response Code");
            return false;
        }
        if (this.f7869a.f7913g != null && !m8584c(this.f7869a.f7913g)) {
            String strValueOf10 = String.valueOf(this.f7869a.f7913g);
            Log.i("FirebasePerformance", strValueOf10.length() != 0 ? "The content type of the response is not a valid content-type:".concat(strValueOf10) : new String("The content type of the response is not a valid content-type:"));
            this.f7869a.f7913g = null;
        }
        return true;
    }
}
