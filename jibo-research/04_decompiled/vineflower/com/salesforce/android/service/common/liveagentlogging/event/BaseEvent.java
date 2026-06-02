package com.salesforce.android.service.common.liveagentlogging.event;

import java.util.Date;

public abstract class BaseEvent {
   private final transient Date a = new Date();
   private final transient String b;
   private final transient String c;
   private transient String d = "00D000000000000";

   public BaseEvent(String var1, String var2) {
      this.b = var1;
      this.c = var2;
      this.d = "00D000000000000";
   }

   public Date a() {
      return this.a;
   }

   public void a(String var1) {
      this.d = var1;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public String d() {
      return this.d;
   }
}
