package com.salesforce.android.service.common.utilities.internal.connectivity;

import android.net.NetworkInfo;
import java.util.Locale;

public class ConnectionInfo {
   private final Technology a;
   private final RadioType b;
   private final boolean c;

   protected ConnectionInfo(ConnectionInfo.Builder var1) {
      NetworkInfo var2 = var1.a;
      if (var2 == null) {
         this.a = Technology.WIFI;
         this.b = RadioType.UNKNOWN;
         this.c = false;
      } else {
         this.a = Technology.fromType(var2.getType());
         this.b = RadioType.fromType(var2.getSubtype());
         this.c = var2.isConnected();
      }
   }

   public boolean a() {
      return this.c;
   }

   public Technology b() {
      return this.a;
   }

   public RadioType c() {
      return this.b;
   }

   @Override
   public String toString() {
      return String.format(Locale.getDefault(), "ConnectionInfo[IsConnected=%s, Technology=%s, RadioType=%s]", this.c, this.a, this.b);
   }

   public static class Builder {
      protected NetworkInfo a;

      public ConnectionInfo.Builder a(NetworkInfo var1) {
         this.a = var1;
         return this;
      }

      public ConnectionInfo a() {
         return new ConnectionInfo(this);
      }
   }
}
