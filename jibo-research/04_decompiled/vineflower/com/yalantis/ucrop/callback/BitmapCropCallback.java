package com.yalantis.ucrop.callback;

import android.net.Uri;

public interface BitmapCropCallback {
   void onBitmapCropped(Uri var1);

   void onCropFailure(Throwable var1);
}
