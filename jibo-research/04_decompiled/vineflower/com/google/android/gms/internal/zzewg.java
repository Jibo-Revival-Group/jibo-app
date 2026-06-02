package com.google.android.gms.internal;

import java.util.Locale;
import java.util.AbstractMap.SimpleEntry;

public abstract class zzewg {
   public static String a(SimpleEntry<String, String> var0) {
      String var1 = (String)var0.getKey();
      String var2 = (String)var0.getValue();
      String var3;
      if (var1 == null) {
         var3 = "Attribute key must not be null";
      } else if (var2 == null) {
         var3 = "Attribute value must not be null";
      } else if (var1.length() > 40) {
         var3 = String.format(Locale.US, "Attribute key length must not exceed %d characters", 40);
      } else if (var2.length() > 100) {
         var3 = String.format(Locale.US, "Attribute value length must not exceed %d characters", 100);
      } else if (!var1.matches("^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*")) {
         var3 = "Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_";
      } else {
         var3 = null;
      }

      return var3;
   }

   public abstract boolean a();
}
