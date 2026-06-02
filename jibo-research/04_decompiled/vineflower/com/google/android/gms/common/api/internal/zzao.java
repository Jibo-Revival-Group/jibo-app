package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.internal.zzcxq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zzao implements zzbh {
   private final zzbi a;
   private final Lock b;
   private final Context c;
   private final com.google.android.gms.common.zzf d;
   private ConnectionResult e;
   private int f;
   private int g = 0;
   private int h;
   private final Bundle i = new Bundle();
   private final Set<Api.zzc> j = new HashSet<>();
   private zzcxd k;
   private boolean l;
   private boolean m;
   private boolean n;
   private com.google.android.gms.common.internal.zzan o;
   private boolean p;
   private boolean q;
   private final com.google.android.gms.common.internal.zzr r;
   private final Map<Api<?>, Boolean> s;
   private final Api.zza<? extends zzcxd, zzcxe> t;
   private ArrayList<Future<?>> u = new ArrayList<>();

   public zzao(
      zzbi var1,
      com.google.android.gms.common.internal.zzr var2,
      Map<Api<?>, Boolean> var3,
      com.google.android.gms.common.zzf var4,
      Api.zza<? extends zzcxd, zzcxe> var5,
      Lock var6,
      Context var7
   ) {
      this.a = var1;
      this.r = var2;
      this.s = var3;
      this.d = var4;
      this.t = var5;
      this.b = var6;
      this.c = var7;
   }

   private final void a(zzcxq var1) {
      if (this.b(0)) {
         ConnectionResult var2 = var1.a();
         if (var2.b()) {
            com.google.android.gms.common.internal.zzbt var4 = var1.b();
            ConnectionResult var3 = var4.b();
            if (!var3.b()) {
               String var5 = String.valueOf(var3);
               Log.wtf(
                  "GoogleApiClientConnecting",
                  new StringBuilder(String.valueOf(var5).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(var5).toString(),
                  new Exception()
               );
               this.b(var3);
            } else {
               this.n = true;
               this.o = var4.a();
               this.p = var4.c();
               this.q = var4.d();
               this.e();
            }
         } else if (this.a(var2)) {
            this.g();
            this.e();
         } else {
            this.b(var2);
         }
      }
   }

   private final void a(boolean var1) {
      if (this.k != null) {
         if (this.k.g() && var1) {
            this.k.e();
         }

         this.k.f();
         this.o = null;
      }
   }

   private final boolean a(ConnectionResult var1) {
      boolean var2;
      if (this.l && !var1.a()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private final void b(ConnectionResult var1) {
      this.h();
      boolean var2;
      if (!var1.a()) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.a(var2);
      this.a.a(var1);
      this.a.e.a(var1);
   }

   private final void b(ConnectionResult var1, Api<?> var2, boolean var3) {
      int var6;
      boolean var7;
      label31: {
         label34: {
            boolean var5 = true;
            var6 = var2.a().a();
            if (var3) {
               if (var1.a()) {
                  var7 = true;
               } else if (this.d.c(var1.c()) != null) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               if (!var7) {
                  break label34;
               }
            }

            var7 = var5;
            if (this.e == null) {
               break label31;
            }

            if (var6 < this.f) {
               var7 = var5;
               break label31;
            }
         }

         var7 = false;
      }

      if (var7) {
         this.e = var1;
         this.f = var6;
      }

      this.a.b.put(var2.c(), var1);
   }

   private final boolean b(int var1) {
      boolean var3;
      if (this.g != var1) {
         Log.w("GoogleApiClientConnecting", this.a.d.n());
         String var4 = String.valueOf(this);
         Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(var4).length() + 23).append("Unexpected callback in ").append(var4).toString());
         int var2 = this.h;
         Log.w("GoogleApiClientConnecting", new StringBuilder(33).append("mRemainingConnections=").append(var2).toString());
         var4 = c(this.g);
         String var5 = c(var1);
         Log.wtf(
            "GoogleApiClientConnecting",
            new StringBuilder(String.valueOf(var4).length() + 70 + String.valueOf(var5).length())
               .append("GoogleApiClient connecting is in step ")
               .append(var4)
               .append(" but received callback for step ")
               .append(var5)
               .toString(),
            new Exception()
         );
         this.b(new ConnectionResult(8, null));
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   private static String c(int var0) {
      String var1;
      switch (var0) {
         case 0:
            var1 = "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            break;
         case 1:
            var1 = "STEP_GETTING_REMOTE_SERVICE";
            break;
         default:
            var1 = "UNKNOWN";
      }

      return var1;
   }

   private final boolean d() {
      boolean var1 = false;
      this.h--;
      if (this.h <= 0) {
         if (this.h < 0) {
            Log.w("GoogleApiClientConnecting", this.a.d.n());
            Log.wtf(
               "GoogleApiClientConnecting",
               "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.",
               new Exception()
            );
            this.b(new ConnectionResult(8, null));
         } else if (this.e != null) {
            this.a.c = this.f;
            this.b(this.e);
         } else {
            var1 = true;
         }
      }

      return var1;
   }

   private final void e() {
      if (this.h == 0 && (!this.m || this.n)) {
         ArrayList var2 = new ArrayList();
         this.g = 1;
         this.h = this.a.a.size();

         for (Api.zzc var1 : this.a.a.keySet()) {
            if (this.a.b.containsKey(var1)) {
               if (this.d()) {
                  this.f();
               }
            } else {
               var2.add(this.a.a.get(var1));
            }
         }

         if (!var2.isEmpty()) {
            this.u.add(zzbl.a().submit(new zzau(this, var2)));
         }
      }
   }

   private final void f() {
      this.a.h();
      zzbl.a().execute(new zzap(this));
      if (this.k != null) {
         if (this.p) {
            this.k.a(this.o, this.q);
         }

         this.a(false);
      }

      for (Api.zzc var2 : this.a.b.keySet()) {
         this.a.a.get(var2).f();
      }

      Bundle var3;
      if (this.i.isEmpty()) {
         var3 = null;
      } else {
         var3 = this.i;
      }

      this.a.e.a(var3);
   }

   private final void g() {
      this.m = false;
      this.a.d.c = Collections.emptySet();

      for (Api.zzc var1 : this.j) {
         if (!this.a.b.containsKey(var1)) {
            this.a.b.put(var1, new ConnectionResult(17, null));
         }
      }
   }

   private final void h() {
      ArrayList var4 = this.u;
      int var2 = var4.size();
      int var1 = 0;

      while (var1 < var2) {
         Object var3 = var4.get(var1);
         var1++;
         ((Future)var3).cancel(true);
      }

      this.u.clear();
   }

   private final Set<Scope> i() {
      Set var1;
      if (this.r == null) {
         var1 = Collections.emptySet();
      } else {
         var1 = new HashSet<>(this.r.d());
         Map var2 = this.r.f();

         for (Api var3 : var2.keySet()) {
            if (!this.a.b.containsKey(var3.c())) {
               var1.addAll(((com.google.android.gms.common.internal.zzt)var2.get(var3)).a);
            }
         }
      }

      return var1;
   }

   @Override
   public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      this.a.d.a.add(var1);
      return (T)var1;
   }

   @Override
   public final void a() {
      this.a.b.clear();
      this.m = false;
      this.e = null;
      this.g = 0;
      this.l = true;
      this.n = false;
      this.p = false;
      HashMap var4 = new HashMap();
      Iterator var6 = this.s.keySet().iterator();
      boolean var1 = false;

      while (var6.hasNext()) {
         Api var7 = (Api)var6.next();
         Api.zze var5 = this.a.a.get(var7.c());
         boolean var2;
         if (var7.a().a() == 1) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var3 = this.s.get(var7);
         if (var5.i()) {
            this.m = true;
            if (var3) {
               this.j.add(var7.c());
            } else {
               this.l = false;
            }
         }

         var4.put(var5, new zzaq(this, var7, var3));
         var1 |= var2;
      }

      if (var1) {
         this.m = false;
      }

      if (this.m) {
         this.r.a(System.identityHashCode(this.a.d));
         zzax var8 = new zzax(this, null);
         this.k = this.t.a(this.c, this.a.d.c(), this.r, this.r.i(), var8, var8);
      }

      this.h = this.a.a.size();
      this.u.add(zzbl.a().submit(new zzar(this, var4)));
   }

   @Override
   public final void a(int var1) {
      this.b(new ConnectionResult(8, null));
   }

   @Override
   public final void a(Bundle var1) {
      if (this.b(1)) {
         if (var1 != null) {
            this.i.putAll(var1);
         }

         if (this.d()) {
            this.f();
         }
      }
   }

   @Override
   public final void a(ConnectionResult var1, Api<?> var2, boolean var3) {
      if (this.b(1)) {
         this.b(var1, var2, var3);
         if (this.d()) {
            this.f();
         }
      }
   }

   @Override
   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1) {
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
   }

   @Override
   public final boolean b() {
      this.h();
      this.a(true);
      this.a.a((ConnectionResult)null);
      return true;
   }

   @Override
   public final void c() {
   }
}
