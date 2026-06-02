package org.slf4j.helpers;

import org.slf4j.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MarkerIgnoringBase extends NamedLoggerBase implements Logger {
    @Override // org.slf4j.helpers.NamedLoggerBase
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ String mo17054a() {
        return super.mo17054a();
    }

    public String toString() {
        return getClass().getName() + "(" + mo17054a() + ")";
    }
}
