package com.amazonaws.util.json;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
   private static volatile AwsJsonFactory factory = new GsonFactory();

   public static AwsJsonReader getJsonReader(Reader var0) {
      if (factory == null) {
         throw new IllegalStateException("Json engine is unavailable.");
      } else {
         return factory.getJsonReader(var0);
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Map<String, String> jsonToMap(Reader var0) {
      AwsJsonReader var9 = getJsonReader(var0);

      label57: {
         try {
            if (var9.peek() == null) {
               var10 = Collections.EMPTY_MAP;
               break label57;
            }
         } catch (IOException var8) {
            throw new AmazonClientException("Unable to parse JSON String.", var8);
         }

         HashMap var2;
         try {
            var2 = new HashMap();
            var9.beginObject();
         } catch (IOException var6) {
            throw new AmazonClientException("Unable to parse JSON String.", var6);
         }

         while (true) {
            String var1;
            try {
               if (!var9.hasNext()) {
                  break;
               }

               var1 = var9.nextName();
               if (var9.isContainer()) {
                  var9.skipValue();
                  continue;
               }
            } catch (IOException var7) {
               throw new AmazonClientException("Unable to parse JSON String.", var7);
            }

            try {
               var2.put(var1, var9.nextString());
            } catch (IOException var5) {
               throw new AmazonClientException("Unable to parse JSON String.", var5);
            }
         }

         try {
            var9.endObject();
            var9.close();
            var10 = Collections.unmodifiableMap(var2);
         } catch (IOException var4) {
            throw new AmazonClientException("Unable to parse JSON String.", var4);
         }
      }

      try {
         return var10;
      } catch (IOException var3) {
         throw new AmazonClientException("Unable to parse JSON String.", var3);
      }
   }
}
