package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.FirebaseApp;

public class FirebaseInitProvider extends ContentProvider {
   public void attachInfo(Context var1, ProviderInfo var2) {
      zzbq.a(var2, "FirebaseInitProvider ProviderInfo cannot be null.");
      if ("com.google.firebase.firebaseinitprovider".equals(var2.authority)) {
         throw new IllegalStateException(
            "Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle."
         );
      }

      super.attachInfo(var1, var2);
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
      if (FirebaseApp.a(this.getContext()) == null) {
         Log.i("FirebaseInitProvider", "FirebaseApp initialization unsuccessful");
      } else {
         Log.i("FirebaseInitProvider", "FirebaseApp initialization successful");
      }

      return false;
   }

   public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      return null;
   }

   public int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      return 0;
   }
}
