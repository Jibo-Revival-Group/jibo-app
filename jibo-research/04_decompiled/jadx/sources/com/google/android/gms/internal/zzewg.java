package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzewg {
    /* JADX INFO: renamed from: a */
    public static String m8589a(AbstractMap.SimpleEntry<String, String> simpleEntry) {
        String key = simpleEntry.getKey();
        String value = simpleEntry.getValue();
        if (key == null) {
            return "Attribute key must not be null";
        }
        if (value == null) {
            return "Attribute value must not be null";
        }
        if (key.length() > 40) {
            return String.format(Locale.US, "Attribute key length must not exceed %d characters", 40);
        }
        if (value.length() > 100) {
            return String.format(Locale.US, "Attribute value length must not exceed %d characters", 100);
        }
        if (key.matches("^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*")) {
            return null;
        }
        return "Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_";
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo8560a();
}
