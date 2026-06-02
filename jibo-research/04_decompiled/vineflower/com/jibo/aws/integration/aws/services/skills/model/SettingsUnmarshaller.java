package com.jibo.aws.integration.aws.services.skills.model;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.io.BufferedReader;

public class SettingsUnmarshaller implements Unmarshaller<String, JsonUnmarshallerContext> {
   private static SettingsUnmarshaller instance;

   public static SettingsUnmarshaller getInstance() {
      if (instance == null) {
         instance = new SettingsUnmarshaller();
      }

      return instance;
   }

   public String unmarshall(JsonUnmarshallerContext var1) {
      BufferedReader var4 = new BufferedReader(var1.getReader().getReader());
      StringBuilder var3 = new StringBuilder();

      while (true) {
         String var2 = var4.readLine();
         if (var2 == null) {
            return var3.toString();
         }

         var3.append(var2);
      }
   }
}
