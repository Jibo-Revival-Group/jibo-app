package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes2.dex */
abstract class NamedLoggerBase implements Serializable, Logger {

    /* JADX INFO: renamed from: b */
    protected String f16218b;

    NamedLoggerBase() {
    }

    /* JADX INFO: renamed from: a */
    public String mo17054a() {
        return this.f16218b;
    }

    protected Object readResolve() throws ObjectStreamException {
        return LoggerFactory.m17025a(mo17054a());
    }
}
