package com.yalantis.ucrop.callback;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public interface BitmapCropCallback {
    void onBitmapCropped(Uri uri);

    void onCropFailure(Throwable th);
}
