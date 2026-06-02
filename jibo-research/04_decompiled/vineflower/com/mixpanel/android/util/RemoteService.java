package com.mixpanel.android.util;

import android.content.Context;
import java.io.IOException;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public interface RemoteService {
   void a();

   boolean a(Context var1, OfflineMode var2);

   byte[] a(String var1, Map<String, Object> var2, SSLSocketFactory var3) throws RemoteService.ServiceUnavailableException, IOException;

   class ServiceUnavailableException extends Exception {
      private final int a;

      public ServiceUnavailableException(String var1, String var2) {
         super(var1);

         int var3;
         try {
            var3 = Integer.parseInt(var2);
         } catch (NumberFormatException var4) {
            var3 = 0;
         }

         this.a = var3;
      }

      public int a() {
         return this.a;
      }
   }
}
