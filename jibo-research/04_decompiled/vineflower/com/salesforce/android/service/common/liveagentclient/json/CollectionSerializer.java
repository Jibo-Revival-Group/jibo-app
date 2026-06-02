package com.salesforce.android.service.common.liveagentclient.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

class CollectionSerializer implements JsonSerializer<Collection<?>> {
   public JsonElement a(Collection<?> var1, Type var2, JsonSerializationContext var3) {
      JsonArray var5;
      if (var1 != null && !var1.isEmpty()) {
         JsonArray var6 = new JsonArray();
         Iterator var4 = var1.iterator();

         while (true) {
            var5 = var6;
            if (!var4.hasNext()) {
               break;
            }

            var6.a(var3.a(var4.next()));
         }
      } else {
         var5 = null;
      }

      return var5;
   }
}
