package android.support.v4.app;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteInput {

    /* JADX INFO: renamed from: a */
    private final String f1752a;

    /* JADX INFO: renamed from: b */
    private final CharSequence f1753b;

    /* JADX INFO: renamed from: c */
    private final CharSequence[] f1754c;

    /* JADX INFO: renamed from: d */
    private final boolean f1755d;

    /* JADX INFO: renamed from: e */
    private final Bundle f1756e;

    /* JADX INFO: renamed from: f */
    private final Set<String> f1757f;

    /* JADX INFO: renamed from: a */
    public String m1784a() {
        return this.f1752a;
    }

    /* JADX INFO: renamed from: b */
    public CharSequence m1785b() {
        return this.f1753b;
    }

    /* JADX INFO: renamed from: c */
    public CharSequence[] m1786c() {
        return this.f1754c;
    }

    /* JADX INFO: renamed from: d */
    public Set<String> m1787d() {
        return this.f1757f;
    }

    /* JADX INFO: renamed from: e */
    public boolean m1788e() {
        return this.f1755d;
    }

    /* JADX INFO: renamed from: f */
    public Bundle m1789f() {
        return this.f1756e;
    }

    /* JADX INFO: renamed from: a */
    static android.app.RemoteInput[] m1783a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = m1782a(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    /* JADX INFO: renamed from: a */
    static android.app.RemoteInput m1782a(RemoteInput remoteInput) {
        return new RemoteInput.Builder(remoteInput.m1784a()).setLabel(remoteInput.m1785b()).setChoices(remoteInput.m1786c()).setAllowFreeFormInput(remoteInput.m1788e()).addExtras(remoteInput.m1789f()).build();
    }
}
