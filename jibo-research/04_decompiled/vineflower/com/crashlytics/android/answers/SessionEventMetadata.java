package com.crashlytics.android.answers;

final class SessionEventMetadata {
   public final String a;
   public final String b;
   public final String c;
   public final String d;
   public final String e;
   public final Boolean f;
   public final String g;
   public final String h;
   public final String i;
   public final String j;
   public final String k;
   public final String l;
   private String m;

   public SessionEventMetadata(
      String var1,
      String var2,
      String var3,
      String var4,
      String var5,
      Boolean var6,
      String var7,
      String var8,
      String var9,
      String var10,
      String var11,
      String var12
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
      this.i = var9;
      this.j = var10;
      this.k = var11;
      this.l = var12;
   }

   @Override
   public String toString() {
      if (this.m == null) {
         this.m = "appBundleId="
            + this.a
            + ", executionId="
            + this.b
            + ", installationId="
            + this.c
            + ", androidId="
            + this.d
            + ", advertisingId="
            + this.e
            + ", limitAdTrackingEnabled="
            + this.f
            + ", betaDeviceToken="
            + this.g
            + ", buildId="
            + this.h
            + ", osVersion="
            + this.i
            + ", deviceModel="
            + this.j
            + ", appVersionCode="
            + this.k
            + ", appVersionName="
            + this.l;
      }

      return this.m;
   }
}
