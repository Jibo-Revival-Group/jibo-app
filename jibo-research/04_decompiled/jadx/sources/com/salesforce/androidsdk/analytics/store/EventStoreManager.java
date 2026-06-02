package com.salesforce.androidsdk.analytics.store;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EventStoreManager {

    /* JADX INFO: renamed from: a */
    private String f14076a;

    /* JADX INFO: renamed from: b */
    private File f14077b;

    /* JADX INFO: renamed from: c */
    private EventFileFilter f14078c;

    /* JADX INFO: renamed from: d */
    private Context f14079d;

    /* JADX INFO: renamed from: e */
    private String f14080e;

    /* JADX INFO: renamed from: f */
    private boolean f14081f = true;

    /* JADX INFO: renamed from: g */
    private int f14082g = 1000;

    public EventStoreManager(String str, Context context, String str2) {
        this.f14076a = str;
        this.f14079d = context;
        this.f14080e = str2;
        this.f14078c = new EventFileFilter(str);
        this.f14077b = context.getFilesDir();
    }

    /* JADX INFO: renamed from: a */
    public void m14382a(InstrumentationEvent instrumentationEvent) {
        if (instrumentationEvent == null || TextUtils.isEmpty(instrumentationEvent.m14354t().toString())) {
            SalesforceAnalyticsLogger.m14399b(this.f14079d, "EventStoreManager", "Invalid event");
            return;
        }
        if (m14379c()) {
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = this.f14079d.openFileOutput(instrumentationEvent.m14335a() + this.f14076a, 0);
                fileOutputStreamOpenFileOutput.write(m14377b(instrumentationEvent.m14354t().toString()).getBytes());
                fileOutputStreamOpenFileOutput.close();
            } catch (Exception e) {
                SalesforceAnalyticsLogger.m14396a(this.f14079d, "EventStoreManager", "Exception occurred while saving event to filesystem", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14384a(List<InstrumentationEvent> list) {
        if (list == null || list.size() == 0) {
            SalesforceAnalyticsLogger.m14399b(this.f14079d, "EventStoreManager", "No events to store");
        } else if (m14379c()) {
            Iterator<InstrumentationEvent> it = list.iterator();
            while (it.hasNext()) {
                m14382a(it.next());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public List<InstrumentationEvent> m14381a() {
        List<File> listM14380d = m14380d();
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = listM14380d.iterator();
        while (it.hasNext()) {
            InstrumentationEvent instrumentationEventM14376a = m14376a(it.next());
            if (instrumentationEventM14376a != null) {
                arrayList.add(instrumentationEventM14376a);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public boolean m14386a(String str) {
        if (TextUtils.isEmpty(str)) {
            SalesforceAnalyticsLogger.m14395a(this.f14079d, "EventStoreManager", "Invalid event ID supplied: " + str);
            return false;
        }
        return new File(this.f14077b, str + this.f14076a).delete();
    }

    /* JADX INFO: renamed from: b */
    public void m14388b(List<String> list) {
        if (list == null || list.size() == 0) {
            SalesforceAnalyticsLogger.m14399b(this.f14079d, "EventStoreManager", "No events to delete");
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            m14386a(it.next());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m14387b() {
        Iterator<File> it = m14380d().iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14383a(String str, String str2) {
        List<InstrumentationEvent> listM14381a = m14381a();
        m14387b();
        this.f14080e = str2;
        m14384a(listM14381a);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m14385a(boolean z) {
        this.f14081f = z;
    }

    /* JADX INFO: renamed from: c */
    private boolean m14379c() {
        List<File> listM14380d = m14380d();
        return this.f14081f && (listM14380d != null ? listM14380d.size() : 0) < this.f14082g;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.salesforce.androidsdk.analytics.model.InstrumentationEvent m14376a(java.io.File r6) {
        /*
            r5 = this;
            r1 = 0
            if (r6 == 0) goto L9
            boolean r0 = r6.exists()
            if (r0 != 0) goto L13
        L9:
            android.content.Context r0 = r5.f14079d
            java.lang.String r2 = "EventStoreManager"
            java.lang.String r3 = "File does not exist"
            com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger.m14395a(r0, r2, r3)
        L12:
            return r1
        L13:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L32
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Exception -> L32
            r3.<init>(r6)     // Catch: java.lang.Exception -> L32
            r2.<init>(r3)     // Catch: java.lang.Exception -> L32
        L22:
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Exception -> L32
            if (r3 == 0) goto L4f
            java.lang.StringBuilder r3 = r0.append(r3)     // Catch: java.lang.Exception -> L32
            r4 = 10
            r3.append(r4)     // Catch: java.lang.Exception -> L32
            goto L22
        L32:
            r0 = move-exception
            android.content.Context r2 = r5.f14079d
            java.lang.String r3 = "EventStoreManager"
            java.lang.String r4 = "Exception occurred while attempting to read file contents"
            com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger.m14396a(r2, r3, r4, r0)
            r0 = r1
        L3d:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L12
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5b
            r2.<init>(r0)     // Catch: org.json.JSONException -> L5b
            com.salesforce.androidsdk.analytics.model.InstrumentationEvent r0 = new com.salesforce.androidsdk.analytics.model.InstrumentationEvent     // Catch: org.json.JSONException -> L5b
            r0.<init>(r2)     // Catch: org.json.JSONException -> L5b
            r1 = r0
            goto L12
        L4f:
            r2.close()     // Catch: java.lang.Exception -> L32
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L32
            java.lang.String r0 = r5.m14378c(r0)     // Catch: java.lang.Exception -> L32
            goto L3d
        L5b:
            r0 = move-exception
            android.content.Context r2 = r5.f14079d
            java.lang.String r3 = "EventStoreManager"
            java.lang.String r4 = "Exception occurred while attempting to convert to JSON"
            com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger.m14396a(r2, r3, r4, r0)
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.analytics.store.EventStoreManager.m14376a(java.io.File):com.salesforce.androidsdk.analytics.model.InstrumentationEvent");
    }

    /* JADX INFO: renamed from: d */
    private List<File> m14380d() {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f14077b.listFiles()) {
            if (file != null && this.f14078c.accept(this.f14077b, file.getName())) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    private String m14377b(String str) {
        return Encryptor.m14371b(str, this.f14080e);
    }

    /* JADX INFO: renamed from: c */
    private String m14378c(String str) {
        return Encryptor.m14365a(str, this.f14080e);
    }

    private static class EventFileFilter implements FilenameFilter {

        /* JADX INFO: renamed from: a */
        private String f14083a;

        public EventFileFilter(String str) {
            this.f14083a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str != null && str.endsWith(this.f14083a);
        }
    }
}
