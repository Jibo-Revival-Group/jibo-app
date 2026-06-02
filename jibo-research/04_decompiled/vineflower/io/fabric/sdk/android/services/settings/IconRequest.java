package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;

public class IconRequest {
   public final String a;
   public final int b;
   public final int c;
   public final int d;

   public IconRequest(String var1, int var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public static IconRequest a(Context var0, String var1) {
      if (var1 != null) {
         try {
            int var2 = CommonUtils.l(var0);
            Logger var3 = Fabric.h();
            StringBuilder var4 = new StringBuilder();
            var3.a("Fabric", var4.append("App icon resource ID is ").append(var2).toString());
            Options var7 = new Options();
            var7.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(var0.getResources(), var2, var7);
            return new IconRequest(var1, var2, var7.outWidth, var7.outHeight);
         } catch (Exception var5) {
            Fabric.h().e("Fabric", "Failed to load icon", var5);
         }
      }

      return null;
   }
}
