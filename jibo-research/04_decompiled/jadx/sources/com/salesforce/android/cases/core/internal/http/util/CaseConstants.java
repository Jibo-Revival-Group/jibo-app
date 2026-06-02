package com.salesforce.android.cases.core.internal.http.util;

import android.annotation.SuppressLint;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SimpleDateFormat"})
public class CaseConstants {

    /* JADX INFO: renamed from: a */
    public static final Date f12329a = new Date(0);

    /* JADX INFO: renamed from: b */
    public static final Map<String, String> f12330b = new HashMap();

    static {
        f12330b.put("equals", "=");
        f12330b.put("notEquals", "!=");
        f12330b.put("lessThan", "<");
        f12330b.put("greaterThan", ">");
        f12330b.put("lessThanOrEqualTo", "<=");
        f12330b.put("greaterThanOrEqualTo", ">=");
        f12330b.put("like", "like");
    }
}
