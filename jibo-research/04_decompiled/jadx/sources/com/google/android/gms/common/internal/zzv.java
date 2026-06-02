package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzcf;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzv implements DialogInterface.OnClickListener {
    /* JADX INFO: renamed from: a */
    public static zzv m7475a(Activity activity, Intent intent, int i) {
        return new zzw(intent, activity, i);
    }

    /* JADX INFO: renamed from: a */
    public static zzv m7476a(Fragment fragment, Intent intent, int i) {
        return new zzx(intent, fragment, i);
    }

    /* JADX INFO: renamed from: a */
    public static zzv m7477a(zzcf zzcfVar, Intent intent, int i) {
        return new zzy(intent, zzcfVar, 2);
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo7478a();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo7478a();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
