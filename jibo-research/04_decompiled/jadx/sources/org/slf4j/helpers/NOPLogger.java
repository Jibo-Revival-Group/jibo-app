package org.slf4j.helpers;

/* JADX INFO: loaded from: classes2.dex */
public class NOPLogger extends MarkerIgnoringBase {

    /* JADX INFO: renamed from: a */
    public static final NOPLogger f16217a = new NOPLogger();

    protected NOPLogger() {
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase
    /* JADX INFO: renamed from: a */
    public String mo17054a() {
        return "NOP";
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public final void mo17018a(String str) {
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: b */
    public final void mo17023b(String str) {
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public final void mo17019a(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public final void mo17021a(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public final void mo17020a(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public final void mo17022a(String str, Object... objArr) {
    }
}
