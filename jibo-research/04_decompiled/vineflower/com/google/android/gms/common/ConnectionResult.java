package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class ConnectionResult extends zzbfm {
   public static final Creator<ConnectionResult> CREATOR = new zzb();
   public static final ConnectionResult a = new ConnectionResult(0);
   private int b;
   private final int c;
   private final PendingIntent d;
   private final String e;

   public ConnectionResult(int var1) {
      this(var1, null, null);
   }

   ConnectionResult(int var1, int var2, PendingIntent var3, String var4) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
   }

   public ConnectionResult(int var1, PendingIntent var2) {
      this(var1, var2, null);
   }

   public ConnectionResult(int var1, PendingIntent var2, String var3) {
      this(1, var1, var2, var3);
   }

   static String a(int var0) {
      String var1;
      switch (var0) {
         case -1:
            var1 = "UNKNOWN";
            break;
         case 0:
            var1 = "SUCCESS";
            break;
         case 1:
            var1 = "SERVICE_MISSING";
            break;
         case 2:
            var1 = "SERVICE_VERSION_UPDATE_REQUIRED";
            break;
         case 3:
            var1 = "SERVICE_DISABLED";
            break;
         case 4:
            var1 = "SIGN_IN_REQUIRED";
            break;
         case 5:
            var1 = "INVALID_ACCOUNT";
            break;
         case 6:
            var1 = "RESOLUTION_REQUIRED";
            break;
         case 7:
            var1 = "NETWORK_ERROR";
            break;
         case 8:
            var1 = "INTERNAL_ERROR";
            break;
         case 9:
            var1 = "SERVICE_INVALID";
            break;
         case 10:
            var1 = "DEVELOPER_ERROR";
            break;
         case 11:
            var1 = "LICENSE_CHECK_FAILED";
            break;
         case 13:
            var1 = "CANCELED";
            break;
         case 14:
            var1 = "TIMEOUT";
            break;
         case 15:
            var1 = "INTERRUPTED";
            break;
         case 16:
            var1 = "API_UNAVAILABLE";
            break;
         case 17:
            var1 = "SIGN_IN_FAILED";
            break;
         case 18:
            var1 = "SERVICE_UPDATING";
            break;
         case 19:
            var1 = "SERVICE_MISSING_PERMISSION";
            break;
         case 20:
            var1 = "RESTRICTED_PROFILE";
            break;
         case 21:
            var1 = "API_VERSION_UPDATE_REQUIRED";
            break;
         case 99:
            var1 = "UNFINISHED";
            break;
         case 1500:
            var1 = "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            break;
         default:
            var1 = new StringBuilder(31).append("UNKNOWN_ERROR_CODE(").append(var0).append(")").toString();
      }

      return var1;
   }

   public final boolean a() {
      boolean var1;
      if (this.c != 0 && this.d != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean b() {
      boolean var1;
      if (this.c == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final int c() {
      return this.c;
   }

   public final PendingIntent d() {
      return this.d;
   }

   public final String e() {
      return this.e;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (!(var1 instanceof ConnectionResult)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.c != var1.c || !zzbg.a(this.d, var1.d) || !zzbg.a(this.e, var1.e)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.c, this.d, this.e});
   }

   @Override
   public final String toString() {
      return zzbg.a(this).a("statusCode", a(this.c)).a("resolution", this.d).a("message", this.e).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b);
      zzbfp.a(var1, 2, this.c());
      zzbfp.a(var1, 3, this.d(), var2, false);
      zzbfp.a(var1, 4, this.e(), false);
      zzbfp.a(var1, var3);
   }
}
