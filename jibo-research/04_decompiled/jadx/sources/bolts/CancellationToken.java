package bolts;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CancellationToken {

    /* JADX INFO: renamed from: a */
    private final CancellationTokenSource f4585a;

    /* JADX INFO: renamed from: a */
    public boolean m5110a() {
        return this.f4585a.m5114a();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f4585a.m5114a()));
    }
}
