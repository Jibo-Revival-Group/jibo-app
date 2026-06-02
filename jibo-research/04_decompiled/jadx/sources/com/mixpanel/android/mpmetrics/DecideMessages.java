package com.mixpanel.android.mpmetrics;

import android.content.Context;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.UpdatesFromMixpanel;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
class DecideMessages {

    /* JADX INFO: renamed from: h */
    private static final Set<Integer> f11848h = new HashSet();

    /* JADX INFO: renamed from: b */
    private final String f11850b;

    /* JADX INFO: renamed from: c */
    private final Set<Integer> f11851c;

    /* JADX INFO: renamed from: e */
    private final OnNewResultsListener f11853e;

    /* JADX INFO: renamed from: f */
    private final UpdatesFromMixpanel f11854f;

    /* JADX INFO: renamed from: i */
    private Boolean f11856i;

    /* JADX INFO: renamed from: j */
    private Context f11857j;

    /* JADX INFO: renamed from: a */
    private String f11849a = null;

    /* JADX INFO: renamed from: d */
    private final List<InAppNotification> f11852d = new LinkedList();

    /* JADX INFO: renamed from: g */
    private JSONArray f11855g = null;

    public interface OnNewResultsListener {
        /* JADX INFO: renamed from: a */
        void mo11715a();
    }

    public DecideMessages(Context context, String str, OnNewResultsListener onNewResultsListener, UpdatesFromMixpanel updatesFromMixpanel, HashSet<Integer> hashSet) {
        this.f11857j = context;
        this.f11850b = str;
        this.f11853e = onNewResultsListener;
        this.f11854f = updatesFromMixpanel;
        this.f11851c = new HashSet(hashSet);
    }

    /* JADX INFO: renamed from: a */
    public String m11707a() {
        return this.f11850b;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11709a(String str) {
        if (this.f11849a == null || !this.f11849a.equals(str)) {
            this.f11852d.clear();
        }
        this.f11849a = str;
    }

    /* JADX INFO: renamed from: b */
    public synchronized String m11711b() {
        return this.f11849a;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9 A[Catch: all -> 0x00c4, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0011, B:7:0x0017, B:9:0x002d, B:11:0x003e, B:14:0x0043, B:18:0x005d, B:20:0x0061, B:22:0x0068, B:28:0x00a5, B:34:0x00c9, B:36:0x00d8, B:37:0x00dd, B:40:0x00ea, B:41:0x00f5, B:43:0x012d, B:45:0x0131, B:26:0x00a0, B:25:0x0082), top: B:55:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0138  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m11710a(java.util.List<com.mixpanel.android.mpmetrics.InAppNotification> r10, org.json.JSONArray r11, org.json.JSONArray r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.DecideMessages.m11710a(java.util.List, org.json.JSONArray, org.json.JSONArray, boolean):void");
    }

    /* JADX INFO: renamed from: c */
    public synchronized JSONArray m11712c() {
        return this.f11855g;
    }

    /* JADX INFO: renamed from: a */
    public synchronized InAppNotification m11706a(boolean z) {
        InAppNotification inAppNotificationRemove;
        if (this.f11852d.isEmpty()) {
            MPLog.m12021a("MixpanelAPI.DecideUpdts", "No unseen notifications exist, none will be returned.");
            inAppNotificationRemove = null;
        } else {
            inAppNotificationRemove = this.f11852d.remove(0);
            if (z) {
                this.f11852d.add(inAppNotificationRemove);
            } else {
                MPLog.m12021a("MixpanelAPI.DecideUpdts", "Recording notification " + inAppNotificationRemove + " as seen.");
            }
        }
        return inAppNotificationRemove;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11708a(InAppNotification inAppNotification) {
        if (!MPConfig.f11915a) {
            this.f11852d.add(inAppNotification);
        }
    }

    /* JADX INFO: renamed from: d */
    public Boolean m11713d() {
        return this.f11856i;
    }

    /* JADX INFO: renamed from: e */
    public boolean m11714e() {
        if (m11713d() == null) {
            return true;
        }
        return m11713d().booleanValue();
    }
}
