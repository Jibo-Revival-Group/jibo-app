package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: e */
    static final Object f1642e = new Object();

    /* JADX INFO: renamed from: f */
    static final HashMap<ComponentName, Object> f1643f = new HashMap<>();

    /* JADX INFO: renamed from: a */
    boolean f1644a = false;

    /* JADX INFO: renamed from: b */
    boolean f1645b = false;

    /* JADX INFO: renamed from: c */
    boolean f1646c = false;

    /* JADX INFO: renamed from: d */
    final ArrayList<Object> f1647d;

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1647d = null;
        } else {
            this.f1647d = new ArrayList<>();
        }
    }
}
