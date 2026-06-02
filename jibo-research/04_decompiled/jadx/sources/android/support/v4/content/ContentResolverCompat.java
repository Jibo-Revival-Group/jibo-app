package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.OperationCanceledException;
import android.support.v4.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class ContentResolverCompat {
    /* JADX INFO: renamed from: a */
    public static Cursor m1831a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) throws Exception {
        Object objM2317d;
        if (Build.VERSION.SDK_INT >= 16) {
            if (cancellationSignal != null) {
                try {
                    objM2317d = cancellationSignal.m2317d();
                } catch (Exception e) {
                    if (e instanceof OperationCanceledException) {
                        throw new android.support.v4.os.OperationCanceledException();
                    }
                    throw e;
                }
            } else {
                objM2317d = null;
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2, (android.os.CancellationSignal) objM2317d);
        }
        if (cancellationSignal != null) {
            cancellationSignal.m2315b();
        }
        return contentResolver.query(uri, strArr, str, strArr2, str2);
    }
}
