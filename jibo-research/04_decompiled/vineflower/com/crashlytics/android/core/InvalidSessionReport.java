package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class InvalidSessionReport implements Report {
   private final File[] a;
   private final Map<String, String> b;
   private final String c;

   public InvalidSessionReport(String var1, File[] var2) {
      this.a = var2;
      this.b = new HashMap<>(ReportUploader.a);
      this.c = var1;
   }

   @Override
   public String a() {
      return this.a[0].getName();
   }

   @Override
   public String b() {
      return this.c;
   }

   @Override
   public File c() {
      return this.a[0];
   }

   @Override
   public File[] d() {
      return this.a;
   }

   @Override
   public Map<String, String> e() {
      return Collections.unmodifiableMap(this.b);
   }

   @Override
   public void f() {
      for (File var4 : this.a) {
         Fabric.h().a("CrashlyticsCore", "Removing invalid report file at " + var4.getPath());
         var4.delete();
      }
   }
}
