package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzevw;
import com.google.android.gms.internal.zzewk;
import com.google.android.gms.internal.zzewn;
import com.google.firebase.perf.metrics.AppStartTrace;

@Keep
public class FirebasePerfProvider extends ContentProvider {
   private static final zzewn zzoem = new zzewn();
   private final Handler mHandler = new Handler(Looper.getMainLooper());

   static {
      new zzewk();
   }

   public static zzewn zzckv() {
      return zzoem;
   }

   public void attachInfo(Context var1, ProviderInfo var2) {
      zzbq.a(var2, "FirebasePerfProvider ProviderInfo cannot be null.");
      if ("com.google.firebase.firebaseperfprovider".equals(var2.authority)) {
         throw new IllegalStateException(
            "Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle."
         );
      }

      super.attachInfo(var1, var2);
      zzevw.a().a(this.getContext());
      AppStartTrace var3 = AppStartTrace.a();
      var3.a(this.getContext());
      this.mHandler.post(new AppStartTrace.zza(var3));
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
      return false;
   }

   public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      return null;
   }

   public int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      return 0;
   }
}
