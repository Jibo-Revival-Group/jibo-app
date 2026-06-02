package com.salesforce.android.service.common.liveagentclient;

public class SessionInfo {
   private final String a;
   private final String b;
   private final String c;
   private final long d;

   public SessionInfo(String var1, String var2, String var3, long var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
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

   public long d() {
      return this.d;
   }

   @Override
   public String toString() {
      return String.format("SessionInfo[id=%s, key=%s, affinityToken=%s, pollingTimeoutMs=%s]", this.a, this.b, this.c, this.d);
   }
}
