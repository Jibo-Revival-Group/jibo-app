package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.zzf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzckg extends zzcjl {
   private final zzcku a;
   private zzche b;
   private volatile Boolean c;
   private final zzcgs d;
   private final zzclk e;
   private final List<Runnable> f = new ArrayList<>();
   private final zzcgs g;

   protected zzckg(zzcim var1) {
      super(var1);
      this.e = new zzclk(var1.u());
      this.a = new zzcku(this);
      this.d = new zzckh(this, var1);
      this.g = new zzckm(this, var1);
   }

   private final void F() {
      this.c();
      this.e.a();
      this.d.a(zzchc.I.b());
   }

   private final void G() {
      this.c();
      if (this.y()) {
         this.t().E().a("Inactivity, disconnecting from the service");
         this.E();
      }
   }

   private final void H() {
      this.c();
      this.t().E().a("Processing queued up service tasks", this.f.size());

      for (Runnable var2 : this.f) {
         try {
            var2.run();
         } catch (Throwable var3) {
            this.t().y().a("Task exception while flushing queue", var3);
         }
      }

      this.f.clear();
      this.g.c();
   }

   private final zzcgi a(boolean var1) {
      zzchh var3 = this.g();
      String var2;
      if (var1) {
         var2 = this.t().F();
      } else {
         var2 = null;
      }

      return var3.a(var2);
   }

   private final void a(ComponentName var1) {
      this.c();
      if (this.b != null) {
         this.b = null;
         this.t().E().a("Disconnected from device MeasurementService", var1);
         this.c();
         this.C();
      }
   }

   private final void a(Runnable var1) throws IllegalStateException {
      this.c();
      if (this.y()) {
         var1.run();
      } else if (this.f.size() >= 1000L) {
         this.t().y().a("Discarding data. Max runnable queue size reached");
      } else {
         this.f.add(var1);
         this.g.a(60000L);
         this.C();
      }
   }

   protected final void A() {
      this.c();
      this.Q();
      zzcgi var1 = this.a(false);
      this.m().y();
      this.a(new zzcki(this, var1));
   }

   protected final void B() {
      this.c();
      this.Q();
      this.a(new zzckk(this, this.a(true)));
   }

   final void C() {
      boolean var2 = true;
      this.c();
      this.Q();
      if (!this.y()) {
         if (this.c == null) {
            this.c();
            this.Q();
            Boolean var5 = this.u().A();
            boolean var4;
            if (var5 != null && var5) {
               var4 = true;
            } else {
               boolean var3;
               boolean var6;
               if (this.g().C() == 1) {
                  var6 = 1;
                  var3 = true;
               } else {
                  this.t().E().a("Checking service availability");
                  zzclq var8 = this.p();
                  var6 = zzf.b().a(var8.l());
                  switch (var6) {
                     case 0:
                        this.t().E().a("Service available");
                        var6 = 1;
                        var3 = true;
                        break;
                     case 1:
                        this.t().E().a("Service missing");
                        var6 = 1;
                        var3 = false;
                        break;
                     case 2:
                        this.t().D().a("Service container out of date");
                        zzclq var9 = this.p();
                        zzf.b();
                        if (zzf.d(var9.l()) < 11400) {
                           var6 = 1;
                           var3 = false;
                           break;
                        }

                        var5 = this.u().A();
                        if (var5 != null && !var5) {
                           var3 = false;
                        } else {
                           var3 = true;
                        }

                        var6 = 0;
                        break;
                     case 3:
                        this.t().A().a("Service disabled");
                        var6 = 0;
                        var3 = false;
                        break;
                     case 9:
                        this.t().A().a("Service invalid");
                        var6 = 0;
                        var3 = false;
                        break;
                     case 18:
                        this.t().A().a("Service updating");
                        var6 = 1;
                        var3 = true;
                        break;
                     default:
                        this.t().A().a("Unexpected service status", var6);
                        var6 = 0;
                        var3 = false;
                  }
               }

               var4 = var3;
               if (var6) {
                  this.u().a(var3);
                  var4 = var3;
               }
            }

            this.c = var4;
         }

         if (this.c) {
            this.a.a();
         } else {
            List var11 = this.l()
               .getPackageManager()
               .queryIntentServices(new Intent().setClassName(this.l(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            boolean var7;
            if (var11 != null && var11.size() > 0) {
               var7 = var2;
            } else {
               var7 = false;
            }

            if (var7) {
               Intent var12 = new Intent("com.google.android.gms.measurement.START");
               var12.setComponent(new ComponentName(this.l(), "com.google.android.gms.measurement.AppMeasurementService"));
               this.a.a(var12);
            } else {
               this.t()
                  .y()
                  .a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
         }
      }
   }

   final Boolean D() {
      return this.c;
   }

   public final void E() {
      this.c();
      this.Q();

      try {
         zza.a();
         this.l().unbindService(this.a);
      } catch (IllegalStateException var2) {
      } catch (IllegalArgumentException var3) {
      }

      this.b = null;
   }

   protected final void a(zzcgl var1) {
      zzbq.a(var1);
      this.c();
      this.Q();
      boolean var2;
      if (this.m().a(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.a(new zzckp(this, true, var2, new zzcgl(var1), this.a(true), var1));
   }

   protected final void a(zzcha var1, String var2) {
      zzbq.a(var1);
      this.c();
      this.Q();
      boolean var3;
      if (this.m().a(var1)) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.a(new zzcko(this, true, var3, var1, this.a(true), var2));
   }

   protected final void a(zzche var1) {
      this.c();
      zzbq.a(var1);
      this.b = var1;
      this.F();
      this.H();
   }

   final void a(zzche var1, zzbfm var2, zzcgi var3) {
      this.c();
      this.Q();
      int var5 = 0;

      for (int var4 = 100; var5 < 1001 && var4 == 100; var5++) {
         ArrayList var9 = new ArrayList();
         ArrayList var8 = this.m().a(100);
         if (var8 != null) {
            var9.addAll(var8);
            var4 = var8.size();
         } else {
            var4 = 0;
         }

         if (var2 != null && var4 < 100) {
            var9.add(var2);
         }

         var8 = var9;
         int var7 = var8.size();
         int var6 = 0;

         while (var6 < var7) {
            Object var14 = var8.get(var6);
            var6++;
            zzbfm var15 = (zzbfm)var14;
            if (var15 instanceof zzcha) {
               try {
                  var1.a((zzcha)var15, var3);
               } catch (RemoteException var12) {
                  this.t().y().a("Failed to send event to the service", var12);
               }
            } else if (var15 instanceof zzcln) {
               try {
                  var1.a((zzcln)var15, var3);
               } catch (RemoteException var11) {
                  this.t().y().a("Failed to send attribute to the service", var11);
               }
            } else if (var15 instanceof zzcgl) {
               try {
                  var1.a((zzcgl)var15, var3);
               } catch (RemoteException var10) {
                  this.t().y().a("Failed to send conditional property to the service", var10);
               }
            } else {
               this.t().y().a("Discarding data. Unrecognized parcel type.");
            }
         }
      }
   }

   protected final void a(zzcln var1) {
      this.c();
      this.Q();
      boolean var2;
      if (this.m().a(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.a(new zzcks(this, var2, var1, this.a(true)));
   }

   protected final void a(AppMeasurement.zzb var1) {
      this.c();
      this.Q();
      this.a(new zzckl(this, var1));
   }

   public final void a(AtomicReference<String> var1) {
      this.c();
      this.Q();
      this.a(new zzckj(this, var1, this.a(false)));
   }

   protected final void a(AtomicReference<List<zzcgl>> var1, String var2, String var3, String var4) {
      this.c();
      this.Q();
      this.a(new zzckq(this, var1, var2, var3, var4, this.a(false)));
   }

   protected final void a(AtomicReference<List<zzcln>> var1, String var2, String var3, String var4, boolean var5) {
      this.c();
      this.Q();
      this.a(new zzckr(this, var1, var2, var3, var4, var5, this.a(false)));
   }

   protected final void a(AtomicReference<List<zzcln>> var1, boolean var2) {
      this.c();
      this.Q();
      this.a(new zzckt(this, var1, this.a(false), var2));
   }

   @Override
   protected final boolean w() {
      return false;
   }

   public final boolean y() {
      this.c();
      this.Q();
      boolean var1;
      if (this.b != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected final void z() {
      this.c();
      this.Q();
      this.a(new zzckn(this, this.a(true)));
   }
}
