package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Map;

public final class RemoteMessage extends zzbfm {
   public static final Creator<RemoteMessage> CREATOR = new zzf();
   Bundle a;
   private Map<String, String> b;

   RemoteMessage(Bundle var1) {
      this.a = var1;
   }

   public final Map<String, String> a() {
      if (this.b == null) {
         this.b = new ArrayMap<>();

         for (String var2 : this.a.keySet()) {
            Object var3 = this.a.get(var2);
            if (var3 instanceof String) {
               String var4 = (String)var3;
               if (!var2.startsWith("google.")
                  && !var2.startsWith("gcm.")
                  && !var2.equals("from")
                  && !var2.equals("message_type")
                  && !var2.equals("collapse_key")) {
                  this.b.put(var2, var4);
               }
            }
         }
      }

      return this.b;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, var2);
   }
}
