package android.support.v4.util;

/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {

    /* JADX INFO: renamed from: a */
    public final F f2228a;

    /* JADX INFO: renamed from: b */
    public final S f2229b;

    public Pair(F f, S s) {
        this.f2228a = f;
        this.f2229b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return m2437a(pair.f2228a, this.f2228a) && m2437a(pair.f2229b, this.f2229b);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2437a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return (this.f2228a == null ? 0 : this.f2228a.hashCode()) ^ (this.f2229b != null ? this.f2229b.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f2228a) + " " + String.valueOf(this.f2229b) + "}";
    }
}
