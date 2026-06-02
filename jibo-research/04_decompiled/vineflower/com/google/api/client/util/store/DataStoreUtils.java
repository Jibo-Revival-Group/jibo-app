package com.google.api.client.util.store;

import java.io.IOException;
import java.util.Iterator;

public final class DataStoreUtils {
   private DataStoreUtils() {
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String toString(DataStore<?> var0) {
      StringBuilder var2;
      try {
         var2 = new StringBuilder();
         var2.append('{');
      } catch (IOException var9) {
         throw new RuntimeException(var9);
      }

      boolean var1 = true;

      Iterator var3;
      try {
         var3 = var0.keySet().iterator();
      } catch (IOException var8) {
         throw new RuntimeException(var8);
      }

      while (true) {
         String var4;
         try {
            if (!var3.hasNext()) {
               break;
            }

            var4 = (String)var3.next();
         } catch (IOException var10) {
            throw new RuntimeException(var10);
         }

         if (var1) {
            var1 = false;
         } else {
            try {
               var2.append(", ");
            } catch (IOException var7) {
               throw new RuntimeException(var7);
            }
         }

         try {
            var2.append(var4).append('=').append(var0.get(var4));
         } catch (IOException var6) {
            throw new RuntimeException(var6);
         }
      }

      try {
         return var2.append('}').toString();
      } catch (IOException var5) {
         throw new RuntimeException(var5);
      }
   }
}
