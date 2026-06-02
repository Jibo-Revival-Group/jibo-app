package com.google.android.gms.common.util;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzp {
    /* JADX INFO: renamed from: a */
    public static void m7509a(StringBuilder sb, HashMap<String, String> map) {
        boolean z;
        sb.append("{");
        boolean z2 = true;
        for (String str : map.keySet()) {
            if (z2) {
                z = false;
            } else {
                sb.append(",");
                z = z2;
            }
            String str2 = map.get(str);
            sb.append("\"").append(str).append("\":");
            if (str2 == null) {
                sb.append("null");
                z2 = z;
            } else {
                sb.append("\"").append(str2).append("\"");
                z2 = z;
            }
        }
        sb.append("}");
    }
}
