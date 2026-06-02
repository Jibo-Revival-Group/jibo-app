package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mixpanel.android.util.MPLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class InstallReferrerReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private final Pattern f11908a = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");

    /* JADX INFO: renamed from: b */
    private final Pattern f11909b = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");

    /* JADX INFO: renamed from: c */
    private final Pattern f11910c = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");

    /* JADX INFO: renamed from: d */
    private final Pattern f11911d = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");

    /* JADX INFO: renamed from: e */
    private final Pattern f11912e = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String string;
        Bundle extras = intent.getExtras();
        if (extras != null && (string = extras.getString("referrer")) != null) {
            HashMap map = new HashMap();
            map.put("referrer", string);
            String strM11761a = m11761a(this.f11908a.matcher(string));
            if (strM11761a != null) {
                map.put("utm_source", strM11761a);
            }
            String strM11761a2 = m11761a(this.f11909b.matcher(string));
            if (strM11761a2 != null) {
                map.put("utm_medium", strM11761a2);
            }
            String strM11761a3 = m11761a(this.f11910c.matcher(string));
            if (strM11761a3 != null) {
                map.put("utm_campaign", strM11761a3);
            }
            String strM11761a4 = m11761a(this.f11911d.matcher(string));
            if (strM11761a4 != null) {
                map.put("utm_content", strM11761a4);
            }
            String strM11761a5 = m11761a(this.f11912e.matcher(string));
            if (strM11761a5 != null) {
                map.put("utm_term", strM11761a5);
            }
            PersistentIdentity.m11890a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", map);
        }
    }

    /* JADX INFO: renamed from: a */
    private String m11761a(Matcher matcher) {
        String strGroup;
        if (matcher.find() && (strGroup = matcher.group(2)) != null) {
            try {
                return URLDecoder.decode(strGroup, HTTP.UTF_8);
            } catch (UnsupportedEncodingException e) {
                MPLog.m12030e("MixpanelAPI.InstRfrRcvr", "Could not decode a parameter into UTF-8");
            }
        }
        return null;
    }
}
