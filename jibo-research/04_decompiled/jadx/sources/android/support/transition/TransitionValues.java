package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {

    /* JADX INFO: renamed from: b */
    public View f1324b;

    /* JADX INFO: renamed from: a */
    public final Map<String, Object> f1323a = new HashMap();

    /* JADX INFO: renamed from: c */
    final ArrayList<Transition> f1325c = new ArrayList<>();

    public boolean equals(Object obj) {
        return (obj instanceof TransitionValues) && this.f1324b == ((TransitionValues) obj).f1324b && this.f1323a.equals(((TransitionValues) obj).f1323a);
    }

    public int hashCode() {
        return (this.f1324b.hashCode() * 31) + this.f1323a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f1324b + "\n") + "    values:";
        Iterator<String> it = this.f1323a.keySet().iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                String next = it.next();
                str = str2 + "    " + next + ": " + this.f1323a.get(next) + "\n";
            } else {
                return str2;
            }
        }
    }
}
