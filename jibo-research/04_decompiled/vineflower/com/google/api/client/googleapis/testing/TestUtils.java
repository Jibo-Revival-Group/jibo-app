package com.google.api.client.googleapis.testing;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class TestUtils {
   private static final String UTF_8 = "UTF-8";

   private TestUtils() {
   }

   public static Map<String, String> parseQuery(String var0) throws IOException {
      HashMap var1 = new HashMap();

      for (String var2 : Splitter.a('&').a(var0)) {
         ArrayList var4 = Lists.a(Splitter.a('=').a(var2));
         if (var4.size() != 2) {
            throw new IOException("Invalid Query String");
         }

         var1.put(URLDecoder.decode((String)var4.get(0), "UTF-8"), URLDecoder.decode((String)var4.get(1), "UTF-8"));
      }

      return var1;
   }
}
