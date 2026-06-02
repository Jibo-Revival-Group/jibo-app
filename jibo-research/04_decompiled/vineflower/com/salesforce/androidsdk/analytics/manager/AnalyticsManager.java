package com.salesforce.androidsdk.analytics.manager;

import android.content.Context;
import com.salesforce.androidsdk.analytics.model.DeviceAppAttributes;
import com.salesforce.androidsdk.analytics.store.EventStoreManager;

public class AnalyticsManager {
   private EventStoreManager a;
   private DeviceAppAttributes b;
   private int c;

   public AnalyticsManager(String var1, Context var2, String var3, DeviceAppAttributes var4) {
      this.a = new EventStoreManager(var1, var2, var3);
      this.b = var4;
      this.c = 0;
   }

   public void a() {
      this.a.b();
   }

   public void a(int var1) {
      synchronized (this) {
         this.c = var1;
      }
   }

   public void a(String var1, String var2) {
      this.a.a(var1, var2);
   }

   public int b() {
      synchronized (this) {
         return this.c;
      }
   }

   public DeviceAppAttributes c() {
      return this.b;
   }

   public EventStoreManager d() {
      return this.a;
   }
}
