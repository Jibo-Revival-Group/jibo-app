package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class SessionReport implements Report {
   private final File a;
   private final File[] b;
   private final Map<String, String> c;

   public SessionReport(File var1) {
      this(var1, Collections.emptyMap());
   }

   public SessionReport(File var1, Map<String, String> var2) {
      this.a = var1;
      this.b = new File[]{var1};
      this.c = new HashMap<>(var2);
      if (this.a.length() == 0L) {
         this.c.putAll(ReportUploader.a);
      }
   }

   @Override
   public String a() {
      return this.c().getName();
   }

   @Override
   public String b() {
      String var1 = this.a();
      return var1.substring(0, var1.lastIndexOf(46));
   }

   @Override
   public File c() {
      return this.a;
   }

   @Override
   public File[] d() {
      return this.b;
   }

   @Override
   public Map<String, String> e() {
      return Collections.unmodifiableMap(this.c);
   }

   @Override
   public void f() {
      Fabric.h().a("CrashlyticsCore", "Removing report at " + this.a.getPath());
      this.a.delete();
   }
}
