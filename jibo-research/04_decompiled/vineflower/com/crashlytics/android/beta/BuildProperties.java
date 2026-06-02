package com.crashlytics.android.beta;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class BuildProperties {
   public final String a;
   public final String b;
   public final String c;
   public final String d;

   BuildProperties(String var1, String var2, String var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public static BuildProperties a(InputStream var0) throws IOException {
      Properties var1 = new Properties();
      var1.load(var0);
      return a(var1);
   }

   public static BuildProperties a(Properties var0) {
      return new BuildProperties(
         var0.getProperty("version_code"), var0.getProperty("version_name"), var0.getProperty("build_id"), var0.getProperty("package_name")
      );
   }
}
