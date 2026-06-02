package com.salesforce.androidsdk.util;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class UriFragmentParser {
   static final boolean a;

   static {
      boolean var0;
      if (!UriFragmentParser.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
   }

   private UriFragmentParser() {
      if (!a) {
         throw new AssertionError("don't construct me!");
      }
   }

   public static Map<String, String> a(Uri var0) {
      Map var2 = a(var0.getEncodedFragment());
      Map var1 = var2;
      if (var2.size() == 0) {
         var1 = a(var0.getEncodedQuery());
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Map<String, String> a(String var0) {
      HashMap var3 = new HashMap();
      if (var0 != null) {
         var0 = var0.trim();
         if (var0.length() != 0) {
            String[] var4 = var0.split("&");
            int var2 = var4.length;

            for (int var1 = 0; var1 < var2; var1++) {
               String[] var9 = var4[var1].split("=");

               String var5;
               label30: {
                  try {
                     var5 = URLDecoder.decode(var9[0], "UTF-8");
                     if (var9.length > 1) {
                        var0 = URLDecoder.decode(var9[1], "UTF-8");
                        break label30;
                     }
                  } catch (UnsupportedEncodingException var7) {
                     SalesforceSDKLogger.a("UriFragmentParser", "Unsupported encoding", var7);
                     continue;
                  }

                  var0 = "";
               }

               try {
                  var3.put(var5, var0);
               } catch (UnsupportedEncodingException var6) {
                  SalesforceSDKLogger.a("UriFragmentParser", "Unsupported encoding", var6);
               }
            }
         }
      }

      return var3;
   }
}
