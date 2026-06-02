package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzcfs;
import java.util.List;

public class GeofencingRequest extends zzbfm {
   public static final Creator<GeofencingRequest> CREATOR = new zzl();
   private final List<zzcfs> a;
   private final int b;
   private final String c;

   GeofencingRequest(List<zzcfs> var1, int var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public int a() {
      return this.b;
   }

   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder();
      var3.append("GeofencingRequest[");
      var3.append("geofences=");
      var3.append(this.a);
      int var1 = this.b;
      var3.append(new StringBuilder(30).append(", initialTrigger=").append(var1).append(", ").toString());
      String var2 = String.valueOf(this.c);
      if (var2.length() != 0) {
         var2 = "tag=".concat(var2);
      } else {
         var2 = new String("tag=");
      }

      var3.append(var2);
      var3.append("]");
      return var3.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.c(var1, 1, this.a, false);
      zzbfp.a(var1, 2, this.a());
      zzbfp.a(var1, 3, this.c, false);
      zzbfp.a(var1, var2);
   }
}
