package com.salesforce.android.cases.core;

import com.salesforce.androidsdk.accounts.UserAccount;
import java.util.concurrent.TimeUnit;

public class CaseConfiguration {
   private final String a;
   private final String b;
   private final String c;
   private final long d;
   private final boolean e;
   private final boolean f;
   private final int g;
   private final CaseClientCallbacks h;
   private final UserAccount i;

   private CaseConfiguration(
      String var1, String var2, String var3, long var4, boolean var6, boolean var7, int var8, CaseClientCallbacks var9, UserAccount var10
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var6;
      this.f = var7;
      this.g = var8;
      this.h = var9;
      this.i = var10;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public boolean d() {
      return this.e;
   }

   public long e() {
      return this.d;
   }

   public boolean f() {
      return this.f;
   }

   public int g() {
      return this.g;
   }

   public CaseClientCallbacks h() {
      return this.h;
   }

   public UserAccount i() {
      return this.i;
   }

   public static class Builder {
      private final String a;
      private final String b;
      private String c;
      private long d = TimeUnit.DAYS.toSeconds(1L);
      private boolean e;
      private boolean f;
      private int g;
      private CaseClientCallbacks h;
      private UserAccount i;

      public Builder(String var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      public CaseConfiguration.Builder a(CaseClientCallbacks var1) {
         this.h = var1;
         return this;
      }

      public CaseConfiguration a() {
         return new CaseConfiguration(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
      }
   }
}
