package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

/* JADX INFO: loaded from: classes2.dex */
public class StaticLoggerBinder {

    /* JADX INFO: renamed from: d */
    private final ILoggerFactory f16233d = new NOPLoggerFactory();

    /* JADX INFO: renamed from: b */
    private static final StaticLoggerBinder f16231b = new StaticLoggerBinder();

    /* JADX INFO: renamed from: a */
    public static String f16230a = "1.6.99";

    /* JADX INFO: renamed from: c */
    private static final String f16232c = NOPLoggerFactory.class.getName();

    /* JADX INFO: renamed from: a */
    public static final StaticLoggerBinder m17071a() {
        return f16231b;
    }

    private StaticLoggerBinder() {
    }

    /* JADX INFO: renamed from: b */
    public ILoggerFactory m17072b() {
        return this.f16233d;
    }

    /* JADX INFO: renamed from: c */
    public String m17073c() {
        return f16232c;
    }
}
