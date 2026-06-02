package com.salesforce.android.service.common.analytics.internal;

import com.salesforce.android.service.common.analytics.ServiceAnalyticsListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class InternalServiceAnalytics {

    /* JADX INFO: renamed from: a */
    static final Set<ServiceAnalyticsListener> f13442a = new HashSet();

    /* JADX INFO: renamed from: a */
    public static void m13720a(ServiceAnalyticsListener serviceAnalyticsListener) {
        f13442a.add(serviceAnalyticsListener);
    }

    /* JADX INFO: renamed from: b */
    public static void m13723b(ServiceAnalyticsListener serviceAnalyticsListener) {
        f13442a.remove(serviceAnalyticsListener);
    }

    /* JADX INFO: renamed from: a */
    public static void m13721a(String str, Map<String, Object> map) {
        Iterator<ServiceAnalyticsListener> it = f13442a.iterator();
        while (it.hasNext()) {
            it.next().mo13029a(str, map);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m13722a(String str, Object... objArr) {
        m13721a(str, m13719a(objArr));
    }

    /* JADX INFO: renamed from: a */
    static Map<String, Object> m13719a(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("Analytics Event Data is invalid. Please specify an even number of data arguments. Data: " + Arrays.toString(objArr));
        }
        HashMap map = new HashMap();
        for (int i = 0; i < objArr.length; i += 2) {
            map.put(objArr[i].toString(), objArr[i + 1]);
        }
        return map;
    }
}
