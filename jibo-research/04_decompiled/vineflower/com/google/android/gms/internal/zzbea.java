package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.TimeZone;

public final class zzbea {
   private int a;
   private String b;
   private String c;
   private String d;
   private int e;
   private final zzbec f;
   private ArrayList<Integer> g;
   private ArrayList<String> h;
   private ArrayList<Integer> i;
   private ArrayList<zzctx> j;
   private ArrayList<byte[]> k;
   private boolean l;
   private final zzfkq m;
   private boolean n;
   private zzbdy o;

   private zzbea(zzbdy var1, byte[] var2) {
      this(var1, var2, (zzbec)null);
   }

   private zzbea(zzbdy var1, byte[] var2, zzbec var3) {
      this.o = var1;
      super();
      this.a = zzbdy.a(this.o);
      this.b = zzbdy.b(this.o);
      zzbdy var6 = this.o;
      this.c = null;
      zzbdy var7 = this.o;
      this.d = null;
      this.e = 0;
      this.g = null;
      this.h = null;
      this.i = null;
      this.j = null;
      this.k = null;
      this.l = true;
      this.m = new zzfkq();
      this.n = false;
      this.c = null;
      this.d = null;
      this.m.a = zzbdy.c(var1).a();
      this.m.b = zzbdy.c(var1).b();
      zzfkq var8 = this.m;
      zzbdy.d(var1);
      long var4 = this.m.a;
      var8.d = TimeZone.getDefault().getOffset(var4) / 1000;
      if (var2 != null) {
         this.m.c = var2;
      }

      this.f = null;
   }

   public final void a() {
      if (this.n) {
         throw new IllegalStateException("do not reuse LogEventBuilder");
      }

      this.n = true;
      zzbeh var1 = new zzbeh(
         new zzbew(zzbdy.f(this.o), zzbdy.g(this.o), this.a, this.b, this.c, this.d, zzbdy.e(this.o), 0),
         this.m,
         null,
         null,
         zzbdy.a((ArrayList)null),
         null,
         zzbdy.a((ArrayList)null),
         null,
         null,
         this.l
      );
      zzbew var2 = var1.a;
      if (zzbdy.h(this.o).a(var2.b, var2.a)) {
         zzbdy.i(this.o).a(var1);
      } else {
         PendingResults.a(Status.a);
      }
   }
}
