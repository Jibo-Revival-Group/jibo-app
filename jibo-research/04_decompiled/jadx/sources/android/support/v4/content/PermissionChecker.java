package android.support.v4.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionChecker {
    /* JADX INFO: renamed from: a */
    public static int m1897a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String strM1356a = AppOpsManagerCompat.m1356a(str);
        if (strM1356a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return AppOpsManagerCompat.m1355a(context, strM1356a, str2) != 0 ? -2 : 0;
    }

    /* JADX INFO: renamed from: a */
    public static int m1896a(Context context, String str) {
        return m1897a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    /* JADX INFO: renamed from: b */
    public static int m1898b(Context context, String str) {
        return m1897a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }
}
