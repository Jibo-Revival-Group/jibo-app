package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;
import java.util.Map;

public final class zzbgo<I, O> extends zzbfm {
   public static final zzbgr CREATOR = new zzbgr();
   protected final int a;
   protected final boolean b;
   protected final int c;
   protected final boolean d;
   protected final String e;
   protected final int f;
   protected final Class<? extends zzbgn> g;
   private final int h;
   private String i;
   private zzbgt j;
   private zzbgp<I, O> k;

   zzbgo(int var1, int var2, boolean var3, int var4, boolean var5, String var6, int var7, String var8, zzbgh var9) {
      this.h = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      this.f = var7;
      if (var8 == null) {
         this.g = null;
         this.i = null;
      } else {
         this.g = zzbgy.class;
         this.i = var8;
      }

      if (var9 == null) {
         this.k = null;
      } else {
         this.k = (zzbgp<I, O>)var9.a();
      }
   }

   private zzbgo(int var1, boolean var2, int var3, boolean var4, String var5, int var6, Class<? extends zzbgn> var7, zzbgp<I, O> var8) {
      this.h = 1;
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      if (var7 == null) {
         this.i = null;
      } else {
         this.i = var7.getCanonicalName();
      }

      this.k = var8;
   }

   public static zzbgo<Integer, Integer> a(String var0, int var1) {
      return new zzbgo<>(0, false, 0, false, var0, var1, null, null);
   }

   public static <T extends zzbgn> zzbgo<T, T> a(String var0, int var1, Class<T> var2) {
      return new zzbgo(11, false, 11, false, var0, var1, var2, null);
   }

   public static zzbgo<String, String> b(String var0, int var1) {
      return new zzbgo<>(7, false, 7, false, var0, var1, null, null);
   }

   public static <T extends zzbgn> zzbgo<ArrayList<T>, ArrayList<T>> b(String var0, int var1, Class<T> var2) {
      return new zzbgo<>(11, true, 11, true, var0, var1, var2, null);
   }

   public static zzbgo<ArrayList<String>, ArrayList<String>> c(String var0, int var1) {
      return new zzbgo<>(7, true, 7, true, var0, var1, null, null);
   }

   public static zzbgo<byte[], byte[]> d(String var0, int var1) {
      return new zzbgo<>(8, false, 8, false, var0, 4, null, null);
   }

   private String d() {
      String var1;
      if (this.i == null) {
         var1 = null;
      } else {
         var1 = this.i;
      }

      return var1;
   }

   public final int a() {
      return this.f;
   }

   public final I a(O var1) {
      return this.k.a((O)var1);
   }

   public final void a(zzbgt var1) {
      this.j = var1;
   }

   public final boolean b() {
      boolean var1;
      if (this.k != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final Map<String, zzbgo<?, ?>> c() {
      zzbq.a((String)this.i);
      zzbq.a(this.j);
      return this.j.a(this.i);
   }

   @Override
   public final String toString() {
      zzbi var2 = zzbg.a(this)
         .a("versionCode", this.h)
         .a("typeIn", this.a)
         .a("typeInArray", this.b)
         .a("typeOut", this.c)
         .a("typeOutArray", this.d)
         .a("outputFieldName", this.e)
         .a("safeParcelFieldId", this.f)
         .a("concreteTypeName", this.d());
      Class var1 = this.g;
      if (var1 != null) {
         var2.a("concreteType.class", var1.getCanonicalName());
      }

      if (this.k != null) {
         var2.a("converterName", this.k.getClass().getCanonicalName());
      }

      return var2.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.h);
      zzbfp.a(var1, 2, this.a);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, 4, this.c);
      zzbfp.a(var1, 5, this.d);
      zzbfp.a(var1, 6, this.e, false);
      zzbfp.a(var1, 7, this.f);
      zzbfp.a(var1, 8, this.d(), false);
      zzbgh var4;
      if (this.k == null) {
         var4 = null;
      } else {
         var4 = zzbgh.a(this.k);
      }

      zzbfp.a(var1, 9, var4, var2, false);
      zzbfp.a(var1, var3);
   }
}
