package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzdb extends Fragment implements zzcf {

    /* JADX INFO: renamed from: a */
    private static WeakHashMap<FragmentActivity, WeakReference<zzdb>> f6371a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b */
    private Map<String, LifecycleCallback> f6372b = new ArrayMap();

    /* JADX INFO: renamed from: c */
    private int f6373c = 0;

    /* JADX INFO: renamed from: d */
    private Bundle f6374d;

    /* JADX INFO: renamed from: a */
    public static zzdb m7186a(FragmentActivity fragmentActivity) {
        zzdb zzdbVar;
        WeakReference<zzdb> weakReference = f6371a.get(fragmentActivity);
        if (weakReference == null || (zzdbVar = weakReference.get()) == null) {
            try {
                zzdbVar = (zzdb) fragmentActivity.getSupportFragmentManager().mo1470a("SupportLifecycleFragmentImpl");
                if (zzdbVar == null || zzdbVar.isRemoving()) {
                    zzdbVar = new zzdb();
                    fragmentActivity.getSupportFragmentManager().mo1471a().mo1367a(zzdbVar, "SupportLifecycleFragmentImpl").mo1386e();
                }
                f6371a.put(fragmentActivity, new WeakReference<>(zzdbVar));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return zzdbVar;
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Activity mo7163a() {
        return getActivity();
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    /* JADX INFO: renamed from: a */
    public final <T extends LifecycleCallback> T mo7164a(String str, Class<T> cls) {
        return cls.cast(this.f6372b.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.zzcf
    /* JADX INFO: renamed from: a */
    public final void mo7165a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f6372b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f6372b.put(str, lifecycleCallback);
        if (this.f6373c > 0) {
            new Handler(Looper.getMainLooper()).post(new zzdc(this, lifecycleCallback, str));
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.f6372b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6953a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<LifecycleCallback> it = this.f6372b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6951a(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6373c = 1;
        this.f6374d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f6372b.entrySet()) {
            entry.getValue().mo6952a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f6373c = 5;
        Iterator<LifecycleCallback> it = this.f6372b.values().iterator();
        while (it.hasNext()) {
            it.next().m6958e();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f6373c = 3;
        Iterator<LifecycleCallback> it = this.f6372b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6956c();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f6372b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().mo6955b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f6373c = 2;
        Iterator<LifecycleCallback> it = this.f6372b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6954b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f6373c = 4;
        Iterator<LifecycleCallback> it = this.f6372b.values().iterator();
        while (it.hasNext()) {
            it.next().mo6957d();
        }
    }
}
