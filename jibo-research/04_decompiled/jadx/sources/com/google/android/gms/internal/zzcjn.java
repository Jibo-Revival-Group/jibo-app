package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzcjn extends zzcjl {

    /* JADX INFO: renamed from: a */
    protected zzckb f7444a;

    /* JADX INFO: renamed from: b */
    private AppMeasurement.EventInterceptor f7445b;

    /* JADX INFO: renamed from: c */
    private final Set<AppMeasurement.OnEventListener> f7446c;

    /* JADX INFO: renamed from: d */
    private boolean f7447d;

    /* JADX INFO: renamed from: e */
    private final AtomicReference<String> f7448e;

    protected zzcjn(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7446c = new CopyOnWriteArraySet();
        this.f7448e = new AtomicReference<>();
    }

    /* JADX INFO: renamed from: a */
    private final void m8266a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                if (obj instanceof Bundle) {
                    bundle2.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < parcelableArr.length) {
                            if (parcelableArr[i2] instanceof Bundle) {
                                parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                            }
                            i = i2 + 1;
                        }
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < arrayList.size()) {
                            Object obj2 = arrayList.get(i4);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i4, new Bundle((Bundle) obj2));
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
            }
        }
        mo7871s().m8173a(new zzcjv(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    /* JADX INFO: renamed from: a */
    private final void m8267a(String str, String str2, long j, Object obj) {
        mo7871s().m8173a(new zzcjw(this, str, str2, obj, j));
    }

    /* JADX INFO: renamed from: a */
    private final void m8268a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        m8266a(str, str2, mo7863k().mo7496a(), bundle, true, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m8269a(String str, String str2, Object obj, long j) {
        zzbq.m7375a(str);
        zzbq.m7375a(str2);
        mo7855c();
        m8259Q();
        if (!this.f7441p.m8205B()) {
            mo7872t().m8100D().m8108a("User property not set since app measurement is disabled");
        } else if (this.f7441p.m8227b()) {
            mo7872t().m8100D().m8110a("Setting user property (FE)", mo7867o().m8090a(str2), obj);
            mo7861i().m8341a(new zzcln(str2, j, obj, str));
        }
    }

    /* JADX INFO: renamed from: b */
    private final List<AppMeasurement.ConditionalUserProperty> m8270b(String str, String str2, String str3) {
        if (mo7871s().m8176z()) {
            mo7872t().m8106y().m8108a("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        mo7871s();
        if (zzcih.m8170y()) {
            mo7872t().m8106y().m8108a("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.f7441p.m8235h().m8173a(new zzcjr(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                mo7872t().m8097A().m8110a("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<zzcgl> list = (List) atomicReference.get();
        if (list == null) {
            mo7872t().m8097A().m8109a("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzcgl zzcglVar : list) {
            AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = zzcglVar.f7105d;
            conditionalUserProperty.mName = zzcglVar.f7104c.f7598a;
            conditionalUserProperty.mValue = zzcglVar.f7104c.m8383a();
            conditionalUserProperty.mActive = zzcglVar.f7106e;
            conditionalUserProperty.mTriggerEventName = zzcglVar.f7107f;
            if (zzcglVar.f7108g != null) {
                conditionalUserProperty.mTimedOutEventName = zzcglVar.f7108g.f7156a;
                if (zzcglVar.f7108g.f7157b != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzcglVar.f7108g.f7157b.m8031b();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzcglVar.f7109h;
            if (zzcglVar.f7110i != null) {
                conditionalUserProperty.mTriggeredEventName = zzcglVar.f7110i.f7156a;
                if (zzcglVar.f7110i.f7157b != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzcglVar.f7110i.f7157b.m8031b();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzcglVar.f7104c.f7599b;
            conditionalUserProperty.mTimeToLive = zzcglVar.f7111j;
            if (zzcglVar.f7112k != null) {
                conditionalUserProperty.mExpiredEventName = zzcglVar.f7112k.f7156a;
                if (zzcglVar.f7112k.f7157b != null) {
                    conditionalUserProperty.mExpiredEventParams = zzcglVar.f7112k.f7157b.m8031b();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    private final Map<String, Object> m8271b(String str, String str2, String str3, boolean z) {
        if (mo7871s().m8176z()) {
            mo7872t().m8106y().m8108a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        mo7871s();
        if (zzcih.m8170y()) {
            mo7872t().m8106y().m8108a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.f7441p.m8235h().m8173a(new zzcjs(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                mo7872t().m8097A().m8109a("Interrupted waiting for get user properties", e);
            }
        }
        List<zzcln> list = (List) atomicReference.get();
        if (list == null) {
            mo7872t().m8097A().m8108a("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzcln zzclnVar : list) {
            arrayMap.put(zzclnVar.f7598a, zzclnVar.m8383a());
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m8273b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int length;
        zzbq.m7375a(str);
        zzbq.m7375a(str2);
        zzbq.m7373a(bundle);
        mo7855c();
        m8259Q();
        if (!this.f7441p.m8205B()) {
            mo7872t().m8100D().m8108a("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.f7447d) {
            this.f7447d = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", Context.class).invoke(null, mo7864l());
                } catch (Exception e) {
                    mo7872t().m8097A().m8109a("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException e2) {
                mo7872t().m8099C().m8108a("Tag Manager is not found and thus will not be used");
            }
        }
        boolean zEquals = "am".equals(str);
        boolean zM8410i = zzclq.m8410i(str2);
        if (z && this.f7445b != null && !zM8410i && !zEquals) {
            mo7872t().m8100D().m8110a("Passing event to registered event handler (FE)", mo7867o().m8090a(str2), mo7867o().m8084a(bundle));
            this.f7445b.m8917a(str, str2, bundle, j);
            return;
        }
        if (this.f7441p.m8227b()) {
            int iM8434c = mo7868p().m8434c(str2);
            if (iM8434c != 0) {
                mo7868p();
                this.f7441p.m8242o().m8426a(str3, iM8434c, "_ev", zzclq.m8387a(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            List<String> listSingletonList = Collections.singletonList("_o");
            Bundle bundleM8418a = mo7868p().m8418a(str2, bundle, listSingletonList, z3, true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleM8418a);
            long jNextLong = mo7868p().m8444z().nextLong();
            int i = 0;
            String[] strArr = (String[]) bundleM8418a.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr);
            int length2 = strArr.length;
            int i2 = 0;
            while (i2 < length2) {
                String str4 = strArr[i2];
                Object obj = bundleM8418a.get(str4);
                mo7868p();
                Bundle[] bundleArrM8402a = zzclq.m8402a(obj);
                if (bundleArrM8402a != null) {
                    bundleM8418a.putInt(str4, bundleArrM8402a.length);
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= bundleArrM8402a.length) {
                            break;
                        }
                        Bundle bundleM8418a2 = mo7868p().m8418a("_ep", bundleArrM8402a[i4], listSingletonList, z3, false);
                        bundleM8418a2.putString("_en", str2);
                        bundleM8418a2.putLong("_eid", jNextLong);
                        bundleM8418a2.putString("_gn", str4);
                        bundleM8418a2.putInt("_ll", bundleArrM8402a.length);
                        bundleM8418a2.putInt("_i", i4);
                        arrayList.add(bundleM8418a2);
                        i3 = i4 + 1;
                    }
                    length = bundleArrM8402a.length + i;
                } else {
                    length = i;
                }
                i2++;
                i = length;
            }
            if (i != 0) {
                bundleM8418a.putLong("_eid", jNextLong);
                bundleM8418a.putInt("_epc", i);
            }
            zzckf zzckfVarM8317y = mo7862j().m8317y();
            if (zzckfVarM8317y != null && !bundleM8418a.containsKey("_sc")) {
                zzckfVarM8317y.f7507a = true;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= arrayList.size()) {
                    break;
                }
                Bundle bundle2 = (Bundle) arrayList.get(i6);
                String str5 = i6 != 0 ? "_ep" : str2;
                bundle2.putString("_o", str);
                if (!bundle2.containsKey("_sc")) {
                    zzckc.m8307a(zzckfVarM8317y, bundle2);
                }
                Bundle bundleM8417a = z2 ? mo7868p().m8417a(bundle2) : bundle2;
                mo7872t().m8100D().m8110a("Logging event (FE)", mo7867o().m8090a(str2), mo7867o().m8084a(bundleM8417a));
                mo7861i().m8338a(new zzcha(str5, new zzcgx(bundleM8417a), str, j), str3);
                if (!zEquals) {
                    Iterator<AppMeasurement.OnEventListener> it = this.f7446c.iterator();
                    while (it.hasNext()) {
                        it.next().m8918a(str, str2, new Bundle(bundleM8417a), j);
                    }
                }
                i5 = i6 + 1;
            }
            if (mo7862j().m8317y() == null || !"_ae".equals(str2)) {
                return;
            }
            mo7870r().m8374a(true);
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m8274b(String str, String str2, String str3, Bundle bundle) {
        long jMo7496a = mo7863k().mo7496a();
        zzbq.m7375a(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = jMo7496a;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        mo7871s().m8173a(new zzcjq(this, conditionalUserProperty));
    }

    /* JADX INFO: renamed from: c */
    private final void m8275c(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long jMo7496a = mo7863k().mo7496a();
        zzbq.m7373a(conditionalUserProperty);
        zzbq.m7375a(conditionalUserProperty.mName);
        zzbq.m7375a(conditionalUserProperty.mOrigin);
        zzbq.m7373a(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = jMo7496a;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (mo7868p().m8437e(str) != 0) {
            mo7872t().m8106y().m8109a("Invalid conditional user property name", mo7867o().m8092c(str));
            return;
        }
        if (mo7868p().m8431b(str, obj) != 0) {
            mo7872t().m8106y().m8110a("Invalid conditional user property value", mo7867o().m8092c(str), obj);
            return;
        }
        Object objM8435c = mo7868p().m8435c(str, obj);
        if (objM8435c == null) {
            mo7872t().m8106y().m8110a("Unable to normalize conditional user property value", mo7867o().m8092c(str), obj);
            return;
        }
        conditionalUserProperty.mValue = objM8435c;
        long j = conditionalUserProperty.mTriggerTimeout;
        if (!TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) && (j > 15552000000L || j < 1)) {
            mo7872t().m8106y().m8110a("Invalid conditional user property timeout", mo7867o().m8092c(str), Long.valueOf(j));
            return;
        }
        long j2 = conditionalUserProperty.mTimeToLive;
        if (j2 > 15552000000L || j2 < 1) {
            mo7872t().m8106y().m8110a("Invalid conditional user property time to live", mo7867o().m8092c(str), Long.valueOf(j2));
        } else {
            mo7871s().m8173a(new zzcjp(this, conditionalUserProperty));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public final void m8276c(boolean z) {
        mo7855c();
        m8259Q();
        mo7872t().m8100D().m8109a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        mo7873u().m8128b(z);
        mo7861i().m8348z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public final void m8277d(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        mo7855c();
        m8259Q();
        zzbq.m7373a(conditionalUserProperty);
        zzbq.m7375a(conditionalUserProperty.mName);
        zzbq.m7375a(conditionalUserProperty.mOrigin);
        zzbq.m7373a(conditionalUserProperty.mValue);
        if (!this.f7441p.m8205B()) {
            mo7872t().m8100D().m8108a("Conditional property not sent since Firebase Analytics is disabled");
            return;
        }
        zzcln zzclnVar = new zzcln(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzcha zzchaVarM8420a = mo7868p().m8420a(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0L, true, false);
            mo7861i().m8337a(new zzcgl(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzclnVar, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, mo7868p().m8420a(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0L, true, false), conditionalUserProperty.mTriggerTimeout, zzchaVarM8420a, conditionalUserProperty.mTimeToLive, mo7868p().m8420a(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0L, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public final void m8278e(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        mo7855c();
        m8259Q();
        zzbq.m7373a(conditionalUserProperty);
        zzbq.m7375a(conditionalUserProperty.mName);
        if (!this.f7441p.m8205B()) {
            mo7872t().m8100D().m8108a("Conditional property not cleared since Firebase Analytics is disabled");
            return;
        }
        try {
            mo7861i().m8337a(new zzcgl(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, new zzcln(conditionalUserProperty.mName, 0L, null, null), conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, mo7868p().m8420a(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    /* JADX INFO: renamed from: A */
    public final void m8279A() {
        mo7871s().m8173a(new zzcka(this));
    }

    /* JADX INFO: renamed from: a */
    public final List<AppMeasurement.ConditionalUserProperty> m8280a(String str, String str2) {
        return m8270b((String) null, str, str2);
    }

    /* JADX INFO: renamed from: a */
    public final List<AppMeasurement.ConditionalUserProperty> m8281a(String str, String str2, String str3) {
        zzbq.m7375a(str);
        mo7850a();
        return m8270b(str, str2, str3);
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, Object> m8282a(String str, String str2, String str3, boolean z) {
        zzbq.m7375a(str);
        mo7850a();
        return m8271b(str, str2, str3, z);
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, Object> m8283a(String str, String str2, boolean z) {
        return m8271b((String) null, str, str2, z);
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    public final void m8284a(long j) {
        mo7871s().m8173a(new zzcjt(this, j));
    }

    /* JADX INFO: renamed from: a */
    public final void m8285a(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzbq.m7373a(conditionalUserProperty);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            mo7872t().m8097A().m8108a("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        m8275c(conditionalUserProperty2);
    }

    /* JADX INFO: renamed from: a */
    public final void m8286a(AppMeasurement.EventInterceptor eventInterceptor) {
        mo7855c();
        m8259Q();
        if (eventInterceptor != null && eventInterceptor != this.f7445b) {
            zzbq.m7379a(this.f7445b == null, "EventInterceptor already set.");
        }
        this.f7445b = eventInterceptor;
    }

    /* JADX INFO: renamed from: a */
    public final void m8287a(AppMeasurement.OnEventListener onEventListener) {
        m8259Q();
        zzbq.m7373a(onEventListener);
        if (this.f7446c.add(onEventListener)) {
            return;
        }
        mo7872t().m8097A().m8108a("OnEventListener already registered");
    }

    /* JADX INFO: renamed from: a */
    final void m8288a(String str) {
        this.f7448e.set(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m8289a(String str, String str2, Bundle bundle) {
        m8268a(str, str2, bundle, true, this.f7445b == null || zzclq.m8410i(str2), false, null);
    }

    /* JADX INFO: renamed from: a */
    public final void m8290a(String str, String str2, Bundle bundle, long j) {
        m8266a(str, str2, j, bundle, false, true, true, null);
    }

    /* JADX INFO: renamed from: a */
    public final void m8291a(String str, String str2, Bundle bundle, boolean z) {
        m8268a(str, str2, bundle, true, this.f7445b == null || zzclq.m8410i(str2), true, null);
    }

    /* JADX INFO: renamed from: a */
    public final void m8292a(String str, String str2, Object obj) {
        zzbq.m7375a(str);
        long jMo7496a = mo7863k().mo7496a();
        int iM8437e = mo7868p().m8437e(str2);
        if (iM8437e != 0) {
            mo7868p();
            this.f7441p.m8242o().m8422a(iM8437e, "_ev", zzclq.m8387a(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj == null) {
            m8267a(str, str2, jMo7496a, (Object) null);
            return;
        }
        int iM8431b = mo7868p().m8431b(str2, obj);
        if (iM8431b != 0) {
            mo7868p();
            this.f7441p.m8242o().m8422a(iM8431b, "_ev", zzclq.m8387a(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
        } else {
            Object objM8435c = mo7868p().m8435c(str2, obj);
            if (objM8435c != null) {
                m8267a(str, str2, jMo7496a, objM8435c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8293a(String str, String str2, String str3, Bundle bundle) {
        zzbq.m7375a(str);
        mo7850a();
        m8274b(str, str2, str3, bundle);
    }

    /* JADX INFO: renamed from: a */
    public final void m8294a(boolean z) {
        m8259Q();
        mo7871s().m8173a(new zzcjo(this, z));
    }

    /* JADX INFO: renamed from: b */
    public final List<zzcln> m8295b(boolean z) {
        m8259Q();
        mo7872t().m8100D().m8108a("Fetching user attributes (FE)");
        if (mo7871s().m8176z()) {
            mo7872t().m8106y().m8108a("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        mo7871s();
        if (zzcih.m8170y()) {
            mo7872t().m8106y().m8108a("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.f7441p.m8235h().m8173a(new zzcjx(this, atomicReference, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e) {
                mo7872t().m8097A().m8109a("Interrupted waiting for get user properties", e);
            }
        }
        List<zzcln> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        mo7872t().m8097A().m8108a("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    /* JADX INFO: renamed from: b */
    public final void m8296b(long j) {
        mo7871s().m8173a(new zzcju(this, j));
    }

    /* JADX INFO: renamed from: b */
    public final void m8297b(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzbq.m7373a(conditionalUserProperty);
        zzbq.m7375a(conditionalUserProperty.mAppId);
        mo7850a();
        m8275c(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    /* JADX INFO: renamed from: b */
    public final void m8298b(AppMeasurement.OnEventListener onEventListener) {
        m8259Q();
        zzbq.m7373a(onEventListener);
        if (this.f7446c.remove(onEventListener)) {
            return;
        }
        mo7872t().m8097A().m8108a("OnEventListener had not been registered");
    }

    /* JADX INFO: renamed from: b */
    public final void m8299b(String str, String str2, Bundle bundle) {
        m8274b((String) null, str, str2, bundle);
    }

    /* JADX INFO: renamed from: c */
    final String m8300c(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            mo7871s().m8173a(new zzcjz(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                mo7872t().m8097A().m8108a("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void mo7855c() {
        super.mo7855c();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: e */
    public final /* bridge */ /* synthetic */ zzcgk mo7857e() {
        return super.mo7857e();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ zzcjn mo7858f() {
        return super.mo7858f();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ zzchh mo7859g() {
        return super.mo7859g();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ zzcgu mo7860h() {
        return super.mo7860h();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: i */
    public final /* bridge */ /* synthetic */ zzckg mo7861i() {
        return super.mo7861i();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: j */
    public final /* bridge */ /* synthetic */ zzckc mo7862j() {
        return super.mo7862j();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: k */
    public final /* bridge */ /* synthetic */ zzd mo7863k() {
        return super.mo7863k();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: l */
    public final /* bridge */ /* synthetic */ Context mo7864l() {
        return super.mo7864l();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: m */
    public final /* bridge */ /* synthetic */ zzchi mo7865m() {
        return super.mo7865m();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: n */
    public final /* bridge */ /* synthetic */ zzcgo mo7866n() {
        return super.mo7866n();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: o */
    public final /* bridge */ /* synthetic */ zzchk mo7867o() {
        return super.mo7867o();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: p */
    public final /* bridge */ /* synthetic */ zzclq mo7868p() {
        return super.mo7868p();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: q */
    public final /* bridge */ /* synthetic */ zzcig mo7869q() {
        return super.mo7869q();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ zzclf mo7870r() {
        return super.mo7870r();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: s */
    public final /* bridge */ /* synthetic */ zzcih mo7871s() {
        return super.mo7871s();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: t */
    public final /* bridge */ /* synthetic */ zzchm mo7872t() {
        return super.mo7872t();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: u */
    public final /* bridge */ /* synthetic */ zzchx mo7873u() {
        return super.mo7873u();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: v */
    public final /* bridge */ /* synthetic */ zzcgn mo7874v() {
        return super.mo7874v();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return false;
    }

    /* JADX INFO: renamed from: y */
    public final Task<String> m8301y() {
        try {
            String strM8133z = mo7873u().m8133z();
            return strM8133z != null ? Tasks.m8939a(strM8133z) : Tasks.m8940a(mo7871s().m8171A(), new zzcjy(this));
        } catch (Exception e) {
            mo7872t().m8097A().m8108a("Failed to schedule task for getAppInstanceId");
            return Tasks.m8938a(e);
        }
    }

    /* JADX INFO: renamed from: z */
    public final String m8302z() {
        return this.f7448e.get();
    }
}
