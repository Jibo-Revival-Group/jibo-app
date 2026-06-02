package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class zzv {
    @TargetApi(21)
    /* JADX INFO: renamed from: a */
    public static File m7521a(Context context) {
        return zzq.m7515f() ? context.getNoBackupFilesDir() : m7522a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    /* JADX INFO: renamed from: a */
    private static synchronized File m7522a(File file) {
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            String strValueOf = String.valueOf(file.getPath());
            Log.w("SupportV4Utils", strValueOf.length() != 0 ? "Unable to create no-backup dir ".concat(strValueOf) : new String("Unable to create no-backup dir "));
            file = null;
        }
        return file;
    }
}
