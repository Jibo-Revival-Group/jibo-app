package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.util.MPLog;
import com.yalantis.ucrop.util.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class Tweaks {

    /* JADX INFO: renamed from: a */
    private final ConcurrentMap<String, TweakValue> f12034a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    private final ConcurrentMap<String, TweakValue> f12035b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c */
    private final List<OnTweakDeclaredListener> f12036c = new ArrayList();

    /* JADX INFO: renamed from: com.mixpanel.android.mpmetrics.Tweaks$1 */
    class C14881 {
    }

    public interface OnTweakDeclaredListener {
        /* JADX INFO: renamed from: a */
        void mo11959a();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11954a(OnTweakDeclaredListener onTweakDeclaredListener) {
        if (onTweakDeclaredListener == null) {
            throw new NullPointerException("listener cannot be null");
        }
        this.f12036c.add(onTweakDeclaredListener);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11955a(String str, Object obj) {
        if (!this.f12034a.containsKey(str)) {
            MPLog.m12028d("MixpanelAPI.Tweaks", "Attempt to set a tweak \"" + str + "\" which has never been defined.");
        } else {
            this.f12034a.put(str, this.f12034a.get(str).m11963a(obj));
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m11958b(String str, Object obj) {
        boolean z = false;
        synchronized (this) {
            if (!this.f12034a.containsKey(str)) {
                MPLog.m12028d("MixpanelAPI.Tweaks", "Attempt to reference a tweak \"" + str + "\" which has never been defined.");
            } else {
                z = !this.f12034a.get(str).f12038b.equals(obj);
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public synchronized Map<String, TweakValue> m11953a() {
        return new HashMap(this.f12034a);
    }

    /* JADX INFO: renamed from: b */
    public synchronized Map<String, TweakValue> m11957b() {
        return new HashMap(this.f12035b);
    }

    public static class TweakValue {

        /* JADX INFO: renamed from: a */
        public final int f12037a;

        /* JADX INFO: renamed from: b */
        private final Object f12038b;

        /* JADX INFO: renamed from: c */
        private final Object f12039c;

        /* JADX INFO: renamed from: d */
        private final Number f12040d;

        /* JADX INFO: renamed from: e */
        private final Number f12041e;

        /* JADX INFO: renamed from: f */
        private final String f12042f;

        /* synthetic */ TweakValue(int i, Object obj, Number number, Number number2, Object obj2, String str, C14881 c14881) {
            this(i, obj, number, number2, obj2, str);
        }

        private TweakValue(int i, Object obj, Number number, Number number2, Object obj2, String str) {
            this.f12037a = i;
            this.f12042f = str;
            this.f12040d = number;
            this.f12041e = number2;
            if (this.f12040d != null && this.f12041e != null) {
                if (!m11962b(obj)) {
                    obj = Long.valueOf(Math.min(Math.max(((Number) obj).longValue(), this.f12040d.longValue()), this.f12041e.longValue()));
                    MPLog.m12028d("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + this.f12042f + "\" with default value " + obj + " out of its bounds [" + this.f12040d + ", " + this.f12041e + "]Tweak \"" + this.f12042f + "\" new default value: " + obj + FileUtils.HIDDEN_PREFIX);
                }
                if (!m11962b(obj2)) {
                    obj2 = Long.valueOf(Math.min(Math.max(((Number) obj2).longValue(), this.f12040d.longValue()), this.f12041e.longValue()));
                    MPLog.m12028d("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + this.f12042f + "\" with value " + obj + " out of its bounds [" + this.f12040d + ", " + this.f12041e + "]Tweak \"" + this.f12042f + "\" new value: " + obj2 + FileUtils.HIDDEN_PREFIX);
                }
            }
            this.f12039c = obj;
            this.f12038b = obj2;
        }

        /* JADX INFO: renamed from: b */
        private boolean m11962b(Object obj) {
            Number number;
            try {
                number = (Number) obj;
            } catch (ClassCastException e) {
            }
            if (Math.min(Math.max(number.longValue(), this.f12040d.longValue()), this.f12041e.longValue()) != this.f12040d.longValue()) {
                if (Math.min(Math.max(number.longValue(), this.f12040d.longValue()), this.f12041e.longValue()) != this.f12041e.longValue()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public TweakValue m11963a(Object obj) {
            return new TweakValue(this.f12037a, this.f12039c, this.f12040d, this.f12041e, obj, this.f12042f);
        }

        /* JADX INFO: renamed from: a */
        public String m11964a() {
            String str = null;
            try {
                str = (String) this.f12039c;
            } catch (ClassCastException e) {
            }
            try {
                return (String) this.f12038b;
            } catch (ClassCastException e2) {
                return str;
            }
        }

        /* JADX INFO: renamed from: b */
        public Number m11965b() {
            Number number = 0;
            if (this.f12039c != null) {
                try {
                    number = (Number) this.f12039c;
                } catch (ClassCastException e) {
                }
            }
            if (this.f12038b != null) {
                try {
                    return (Number) this.f12038b;
                } catch (ClassCastException e2) {
                    return number;
                }
            }
            return number;
        }

        /* JADX INFO: renamed from: c */
        public Boolean m11966c() {
            Boolean bool = false;
            if (this.f12039c != null) {
                try {
                    bool = (Boolean) this.f12039c;
                } catch (ClassCastException e) {
                }
            }
            if (this.f12038b != null) {
                try {
                    return (Boolean) this.f12038b;
                } catch (ClassCastException e2) {
                    return bool;
                }
            }
            return bool;
        }

        /* JADX INFO: renamed from: d */
        public Number m11967d() {
            return this.f12040d;
        }

        /* JADX INFO: renamed from: e */
        public Number m11968e() {
            return this.f12041e;
        }

        /* JADX INFO: renamed from: f */
        public Object m11969f() {
            return this.f12039c;
        }

        /* JADX INFO: renamed from: g */
        public Object m11970g() {
            return this.f12038b;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00e5 A[PHI: r0 r1 r2 r4
          0x00e5: PHI (r0v19 java.lang.Object) = (r0v18 java.lang.Object), (r0v24 java.lang.Object) binds: [B:22:0x009e, B:11:0x0050] A[DONT_GENERATE, DONT_INLINE]
          0x00e5: PHI (r1v12 java.lang.Object) = (r1v11 java.lang.Object), (r1v15 java.lang.Object) binds: [B:22:0x009e, B:11:0x0050] A[DONT_GENERATE, DONT_INLINE]
          0x00e5: PHI (r2v4 int) = (r2v3 int), (r2v7 int) binds: [B:22:0x009e, B:11:0x0050] A[DONT_GENERATE, DONT_INLINE]
          0x00e5: PHI (r4v8 java.lang.Number) = (r4v5 java.lang.Number), (r4v13 java.lang.Number) binds: [B:22:0x009e, B:11:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static com.mixpanel.android.mpmetrics.Tweaks.TweakValue m11960a(org.json.JSONObject r11) {
            /*
                Method dump skipped, instruction units count: 237
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.Tweaks.TweakValue.m11960a(org.json.JSONObject):com.mixpanel.android.mpmetrics.Tweaks$TweakValue");
        }
    }

    Tweaks() {
    }

    /* JADX INFO: renamed from: a */
    public void m11956a(String str, Object obj, Number number, Number number2, int i) {
        if (this.f12034a.containsKey(str)) {
            MPLog.m12028d("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + str + "\" twice with the same name");
            return;
        }
        TweakValue tweakValue = new TweakValue(i, obj, number, number2, obj, str, null);
        this.f12034a.put(str, tweakValue);
        this.f12035b.put(str, tweakValue);
        int size = this.f12036c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f12036c.get(i2).mo11959a();
        }
    }
}
