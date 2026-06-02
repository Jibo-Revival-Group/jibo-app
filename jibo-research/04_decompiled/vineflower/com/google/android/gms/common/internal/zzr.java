package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxe;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzr {
   private final Account a;
   private final Set<Scope> b;
   private final Set<Scope> c;
   private final Map<Api<?>, zzt> d;
   private final int e;
   private final View f;
   private final String g;
   private final String h;
   private final zzcxe i;
   private Integer j;

   public zzr(Account var1, Set<Scope> var2, Map<Api<?>, zzt> var3, int var4, View var5, String var6, String var7, zzcxe var8) {
      this.a = var1;
      Set var9;
      if (var2 == null) {
         var9 = Collections.EMPTY_SET;
      } else {
         var9 = Collections.unmodifiableSet(var2);
      }

      this.b = var9;
      Map var10 = var3;
      if (var3 == null) {
         var10 = Collections.EMPTY_MAP;
      }

      this.d = var10;
      this.f = var5;
      this.e = var4;
      this.g = var6;
      this.h = var7;
      this.i = var8;
      HashSet var11 = new HashSet<>(this.b);
      Iterator var12 = this.d.values().iterator();

      while (var12.hasNext()) {
         var11.addAll(((zzt)var12.next()).a);
      }

      this.c = Collections.unmodifiableSet(var11);
   }

   @Deprecated
   public final String a() {
      String var1;
      if (this.a != null) {
         var1 = this.a.name;
      } else {
         var1 = null;
      }

      return var1;
   }

   public final Set<Scope> a(Api<?> var1) {
      zzt var2 = this.d.get(var1);
      Set var3;
      if (var2 != null && !var2.a.isEmpty()) {
         var3 = new HashSet<>(this.b);
         var3.addAll(var2.a);
      } else {
         var3 = this.b;
      }

      return var3;
   }

   public final void a(Integer var1) {
      this.j = var1;
   }

   public final Account b() {
      return this.a;
   }

   public final Account c() {
      Account var1;
      if (this.a != null) {
         var1 = this.a;
      } else {
         var1 = new Account("<<default account>>", "com.google");
      }

      return var1;
   }

   public final Set<Scope> d() {
      return this.b;
   }

   public final Set<Scope> e() {
      return this.c;
   }

   public final Map<Api<?>, zzt> f() {
      return this.d;
   }

   public final String g() {
      return this.g;
   }

   public final String h() {
      return this.h;
   }

   public final zzcxe i() {
      return this.i;
   }

   public final Integer j() {
      return this.j;
   }
}
