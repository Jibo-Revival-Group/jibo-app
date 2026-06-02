package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
abstract class zzr<T> {

    /* JADX INFO: renamed from: a */
    final int f8677a;

    /* JADX INFO: renamed from: b */
    final TaskCompletionSource<T> f8678b = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: c */
    final int f8679c;

    /* JADX INFO: renamed from: d */
    final Bundle f8680d;

    zzr(int i, int i2, Bundle bundle) {
        this.f8677a = i;
        this.f8679c = i2;
        this.f8680d = bundle;
    }

    /* JADX INFO: renamed from: a */
    abstract void mo9149a(Bundle bundle);

    /* JADX INFO: renamed from: a */
    final void m9151a(zzs zzsVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(zzsVar);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(strValueOf).length() + 14 + String.valueOf(strValueOf2).length()).append("Failing ").append(strValueOf).append(" with ").append(strValueOf2).toString());
        }
        this.f8678b.m8934a(zzsVar);
    }

    /* JADX INFO: renamed from: a */
    final void m9152a(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(t);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(strValueOf).length() + 16 + String.valueOf(strValueOf2).length()).append("Finishing ").append(strValueOf).append(" with ").append(strValueOf2).toString());
        }
        this.f8678b.m8935a(t);
    }

    /* JADX INFO: renamed from: a */
    abstract boolean mo9150a();

    public String toString() {
        int i = this.f8679c;
        int i2 = this.f8677a;
        return new StringBuilder(55).append("Request { what=").append(i).append(" id=").append(i2).append(" oneWay=").append(mo9150a()).append("}").toString();
    }
}
