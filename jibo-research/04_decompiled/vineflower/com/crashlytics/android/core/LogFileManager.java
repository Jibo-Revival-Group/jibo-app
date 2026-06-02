package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.Set;

class LogFileManager {
   private static final LogFileManager.NoopLogStore a = new LogFileManager.NoopLogStore();
   private final Context b;
   private final LogFileManager.DirectoryProvider c;
   private FileLogStore d;

   LogFileManager(Context var1, LogFileManager.DirectoryProvider var2) {
      this(var1, var2, null);
   }

   LogFileManager(Context var1, LogFileManager.DirectoryProvider var2, String var3) {
      this.b = var1;
      this.c = var2;
      this.d = a;
      this.a(var3);
   }

   private String a(File var1) {
      String var3 = var1.getName();
      int var2 = var3.lastIndexOf(".temp");
      if (var2 != -1) {
         var3 = var3.substring("crashlytics-userlog-".length(), var2);
      }

      return var3;
   }

   private File b(String var1) {
      var1 = "crashlytics-userlog-" + var1 + ".temp";
      return new File(this.c.a(), var1);
   }

   ByteString a() {
      return this.d.a();
   }

   void a(File var1, int var2) {
      this.d = new QueueFileLogStore(var1, var2);
   }

   final void a(String var1) {
      this.d.b();
      this.d = a;
      if (var1 != null) {
         if (!CommonUtils.a(this.b, "com.crashlytics.CollectCustomLogs", true)) {
            Fabric.h().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
         } else {
            this.a(this.b(var1), 65536);
         }
      }
   }

   void a(Set<String> var1) {
      File[] var4 = this.c.a().listFiles();
      if (var4 != null) {
         for (File var5 : var4) {
            if (!var1.contains(this.a(var5))) {
               var5.delete();
            }
         }
      }
   }

   void b() {
      this.d.c();
   }

   public interface DirectoryProvider {
      File a();
   }

   private static final class NoopLogStore implements FileLogStore {
      private NoopLogStore() {
      }

      @Override
      public ByteString a() {
         return null;
      }

      @Override
      public void b() {
      }

      @Override
      public void c() {
      }
   }
}
