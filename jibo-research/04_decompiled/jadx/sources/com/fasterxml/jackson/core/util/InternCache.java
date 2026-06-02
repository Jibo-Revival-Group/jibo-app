package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class InternCache extends ConcurrentHashMap<String, String> {

    /* JADX INFO: renamed from: a */
    public static final InternCache f5676a = new InternCache();

    /* JADX INFO: renamed from: b */
    private final Object f5677b;

    private InternCache() {
        super(180, 0.8f, 4);
        this.f5677b = new Object();
    }

    /* JADX INFO: renamed from: a */
    public String m6467a(String str) {
        String str2 = get(str);
        if (str2 == null) {
            if (size() >= 180) {
                synchronized (this.f5677b) {
                    if (size() >= 180) {
                        clear();
                    }
                }
            }
            String strIntern = str.intern();
            put(strIntern, strIntern);
            return strIntern;
        }
        return str2;
    }
}
