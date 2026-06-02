package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static final SparseArray<PowerManager.WakeLock> f1836a = new SparseArray<>();

    /* JADX INFO: renamed from: b */
    private static int f1837b = 1;

    /* JADX INFO: renamed from: a_ */
    public static ComponentName m1900a_(Context context, Intent intent) {
        synchronized (f1836a) {
            int i = f1837b;
            f1837b++;
            if (f1837b <= 0) {
                f1837b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + componentNameStartService.flattenToShortString());
            wakeLockNewWakeLock.setReferenceCounted(false);
            wakeLockNewWakeLock.acquire(60000L);
            f1836a.put(i, wakeLockNewWakeLock);
            return componentNameStartService;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1899a(Intent intent) {
        boolean z = false;
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra != 0) {
            synchronized (f1836a) {
                PowerManager.WakeLock wakeLock = f1836a.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    f1836a.remove(intExtra);
                    z = true;
                } else {
                    Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
                    z = true;
                }
            }
        }
        return z;
    }
}
