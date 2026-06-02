package com.google.android.gms.measurement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.internal.zzcim;

@Deprecated
public class AppMeasurementContentProvider extends ContentProvider {
   public void attachInfo(Context var1, ProviderInfo var2) {
      super.attachInfo(var1, var2);
      if ("com.google.android.gms.measurement.google_measurement_service".equals(var2.authority)) {
         throw new IllegalStateException(
            "Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle."
         );
      }
   }

   public int delete(Uri var1, String var2, String[] var3) {
      return 0;
   }

   public String getType(Uri var1) {
      return null;
   }

   public Uri insert(Uri var1, ContentValues var2) {
      return null;
   }

   public boolean onCreate() {
      zzcim.a(this.getContext());
      return false;
   }

   public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      return null;
   }

   public int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      return 0;
   }
}
