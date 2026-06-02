package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzi extends zzo {
   private final SparseArray<zzi.zza> e = new SparseArray();

   private zzi(zzcf var1) {
      super(var1);
      this.a.a("AutoManageHelper", this);
   }

   private final zzi.zza b(int var1) {
      zzi.zza var2;
      if (this.e.size() <= var1) {
         var2 = null;
      } else {
         var2 = (zzi.zza)this.e.get(this.e.keyAt(var1));
      }

      return var2;
   }

   public static zzi b(zzce var0) {
      zzcf var1 = a(var0);
      zzi var2 = var1.a("AutoManageHelper", zzi.class);
      if (var2 == null) {
         var2 = new zzi(var1);
      }

      return var2;
   }

   public final void a(int var1) {
      zzi.zza var2 = (zzi.zza)this.e.get(var1);
      this.e.remove(var1);
      if (var2 != null) {
         var2.b.b(var2);
         var2.b.g();
      }
   }

   public final void a(int var1, GoogleApiClient var2, GoogleApiClient.OnConnectionFailedListener var3) {
      com.google.android.gms.common.internal.zzbq.a(var2, "GoogleApiClient instance cannot be null");
      boolean var4;
      if (this.e.indexOfKey(var1) < 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      com.google.android.gms.common.internal.zzbq.a(var4, new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(var1).toString());
      zzp var5 = this.c.get();
      var4 = this.b;
      String var6 = String.valueOf(var5);
      Log.d(
         "AutoManageHelper",
         new StringBuilder(String.valueOf(var6).length() + 49)
            .append("starting AutoManage for client ")
            .append(var1)
            .append(" ")
            .append(var4)
            .append(" ")
            .append(var6)
            .toString()
      );
      zzi.zza var7 = new zzi.zza(this, var1, var2, var3);
      this.e.put(var1, var7);
      if (this.b && var5 == null) {
         String var8 = String.valueOf(var2);
         Log.d("AutoManageHelper", new StringBuilder(String.valueOf(var8).length() + 11).append("connecting ").append(var8).toString());
         var2.e();
      }
   }

   @Override
   protected final void a(ConnectionResult var1, int var2) {
      Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
      if (var2 < 0) {
         Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
      } else {
         zzi.zza var3 = (zzi.zza)this.e.get(var2);
         if (var3 != null) {
            this.a(var2);
            GoogleApiClient.OnConnectionFailedListener var4 = var3.c;
            if (var4 != null) {
               var4.a(var1);
            }
         }
      }
   }

   @Override
   public final void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      for (int var5 = 0; var5 < this.e.size(); var5++) {
         zzi.zza var6 = this.b(var5);
         if (var6 != null) {
            var3.append(var1).append("GoogleApiClient #").print(var6.a);
            var3.println(":");
            var6.b.a(String.valueOf(var1).concat("  "), var2, var3, var4);
         }
      }
   }

   @Override
   public final void b() {
      super.b();
      boolean var2 = this.b;
      String var3 = String.valueOf(this.e);
      Log.d("AutoManageHelper", new StringBuilder(String.valueOf(var3).length() + 14).append("onStart ").append(var2).append(" ").append(var3).toString());
      if (this.c.get() == null) {
         for (int var1 = 0; var1 < this.e.size(); var1++) {
            zzi.zza var4 = this.b(var1);
            if (var4 != null) {
               var4.b.e();
            }
         }
      }
   }

   @Override
   public final void d() {
      super.d();

      for (int var1 = 0; var1 < this.e.size(); var1++) {
         zzi.zza var2 = this.b(var1);
         if (var2 != null) {
            var2.b.g();
         }
      }
   }

   @Override
   protected final void f() {
      for (int var1 = 0; var1 < this.e.size(); var1++) {
         zzi.zza var2 = this.b(var1);
         if (var2 != null) {
            var2.b.e();
         }
      }
   }

   final class zza implements GoogleApiClient.OnConnectionFailedListener {
      public final int a;
      public final GoogleApiClient b;
      public final GoogleApiClient.OnConnectionFailedListener c;
      private zzi d;

      public zza(zzi var1, int var2, GoogleApiClient var3, GoogleApiClient.OnConnectionFailedListener var4) {
         this.d = var1;
         super();
         this.a = var2;
         this.b = var3;
         this.c = var4;
         var3.a(this);
      }

      @Override
      public final void a(ConnectionResult var1) {
         String var2 = String.valueOf(var1);
         Log.d("AutoManageHelper", new StringBuilder(String.valueOf(var2).length() + 27).append("beginFailureResolution for ").append(var2).toString());
         this.d.b(var1, this.a);
      }
   }
}
