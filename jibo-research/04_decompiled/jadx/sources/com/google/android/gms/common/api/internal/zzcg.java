package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzcg extends Fragment implements zzcf {

    /* JADX INFO: renamed from: a */
    private static WeakHashMap<Activity, WeakReference<zzcg>> f6339a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b */
    private Map<String, LifecycleCallback> f6340b = new ArrayMap();

    /* JADX INFO: renamed from: c */
    private int f6341c = 0;

    /* JADX INFO: renamed from: d */
    private Bundle f6342d;

    /* JADX INFO: renamed from: a */
    public static zzcg m7167a(Activity activity) {
        zzcg zzcgVar;
        WeakReference<zzcg> weakReference = f6339a.get(activity);
        if (weakReference == null || (zzcgVar = weakReference.get()) == null) {
            try {
                zzcgVar = (zzcg) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (zzcgVar == null || zzcgVar.isRemoving()) {
                    zzcgVar = new zzcg();
                    activity.getFragmentManager().beginTransaction().add(zzcgVar, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f6339a.put(activity, new WeakReference<>(zzcgVar));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        return zzcgVar;
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    /* JADX INFO: renamed from: a */
    public final Activity mo7163a() {
        return getActivity();
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    /* JADX INFO: renamed from: a */
    public final <T extends LifecycleCallback> T mo7164a(String str, Class<T> cls) {
        return cls.cast(this.f6340b.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    /* JADX INFO: renamed from: a */
    public final void mo7165a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f6340b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f6340b.put(str, lifecycleCallback);
        if (this.f6341c > 0) {
            new Handler(Looper.getMainLooper()).post(new zzch(this, lifecycleCallback, str));
        }
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.f6340b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6953a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<LifecycleCallback> it = this.f6340b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6951a(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6341c = 1;
        this.f6342d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f6340b.entrySet()) {
            entry.getValue().mo6952a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f6341c = 5;
        Iterator<LifecycleCallback> it = this.f6340b.values().iterator();
        while (it.hasNext()) {
            it.next().m6958e();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f6341c = 3;
        Iterator<LifecycleCallback> it = this.f6340b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6956c();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f6340b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().mo6955b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f6341c = 2;
        Iterator<LifecycleCallback> it = this.f6340b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6954b();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f6341c = 4;
        Iterator<LifecycleCallback> it = this.f6340b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6957d();
        }
    }
}
