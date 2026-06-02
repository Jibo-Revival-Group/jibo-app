package io.fabric.sdk.android.services.persistence;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Kit;

public class PreferenceStoreImpl implements PreferenceStore {
   private final SharedPreferences a;
   private final String b;
   private final Context c;

   public PreferenceStoreImpl(Context var1, String var2) {
      if (var1 == null) {
         throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
      }

      this.c = var1;
      this.b = var2;
      this.a = this.c.getSharedPreferences(this.b, 0);
   }

   @Deprecated
   public PreferenceStoreImpl(Kit var1) {
      this(var1.r(), var1.getClass().getName());
   }

   @Override
   public SharedPreferences a() {
      return this.a;
   }

   @TargetApi(9)
   @Override
   public boolean a(Editor var1) {
      boolean var2;
      if (VERSION.SDK_INT >= 9) {
         var1.apply();
         var2 = true;
      } else {
         var2 = var1.commit();
      }

      return var2;
   }

   @Override
   public Editor b() {
      return this.a.edit();
   }
}
