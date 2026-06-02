package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class VersionInfo {
   public static final String PROPERTY_MODULE = "info.module";
   public static final String PROPERTY_RELEASE = "info.release";
   public static final String PROPERTY_TIMESTAMP = "info.timestamp";
   public static final String UNAVAILABLE = "UNAVAILABLE";
   public static final String VERSION_PROPERTY_FILE = "version.properties";
   private final String infoClassloader;
   private final String infoModule;
   private final String infoPackage;
   private final String infoRelease;
   private final String infoTimestamp;

   protected VersionInfo(String var1, String var2, String var3, String var4, String var5) {
      Args.notNull(var1, "Package identifier");
      this.infoPackage = var1;
      if (var2 == null) {
         var2 = "UNAVAILABLE";
      }

      this.infoModule = var2;
      if (var3 == null) {
         var3 = "UNAVAILABLE";
      }

      this.infoRelease = var3;
      if (var4 == null) {
         var4 = "UNAVAILABLE";
      }

      this.infoTimestamp = var4;
      if (var5 == null) {
         var5 = "UNAVAILABLE";
      }

      this.infoClassloader = var5;
   }

   protected static VersionInfo fromMap(String var0, Map<?, ?> var1, ClassLoader var2) {
      Object var6 = null;
      Args.notNull(var0, "Package identifier");
      String var9;
      String var10;
      String var11;
      if (var1 != null) {
         var10 = (String)var1.get("info.module");
         if (var10 != null && var10.length() < 1) {
            var10 = null;
         }

         var11 = (String)var1.get("info.release");
         if (var11 != null && (var11.length() < 1 || var11.equals("${pom.version}"))) {
            var11 = null;
         }

         String var5 = (String)var1.get("info.timestamp");
         if (var5 == null || var5.length() >= 1 && !var5.equals("${mvn.timestamp}")) {
            var9 = var10;
            var10 = var11;
            var11 = var5;
         } else {
            Object var7 = null;
            String var8 = var11;
            var5 = var10;
            var11 = (String)var7;
            var10 = var8;
            var9 = var5;
         }
      } else {
         var11 = null;
         var10 = null;
         var9 = null;
      }

      String var13 = (String)var6;
      if (var2 != null) {
         var13 = var2.toString();
      }

      return new VersionInfo(var0, var9, var10, var11, var13);
   }

   public static String getUserAgent(String var0, String var1, Class<?> var2) {
      VersionInfo var3 = loadVersionInfo(var1, var2.getClassLoader());
      if (var3 != null) {
         var1 = var3.getRelease();
      } else {
         var1 = "UNAVAILABLE";
      }

      return String.format("%s/%s (Java/%s)", var0, var1, System.getProperty("java.version"));
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static VersionInfo loadVersionInfo(String var0, ClassLoader var1) {
      VersionInfo var3 = null;
      Args.notNull(var0, "Package identifier");
      ClassLoader var2;
      if (var1 != null) {
         var2 = var1;
      } else {
         var2 = Thread.currentThread().getContextClassLoader();
      }

      label62: {
         InputStream var4;
         try {
            StringBuilder var15 = new StringBuilder();
            var4 = var2.getResourceAsStream(var15.append(var0.replace('.', '/')).append("/").append("version.properties").toString());
         } catch (IOException var13) {
            var14 = null;
            break label62;
         }

         label55:
         if (var4 != null) {
            boolean var9 = false /* VF: Semaphore variable */;

            try {
               var9 = true;
               var14 = new Properties();
               var14.load(var4);
               var9 = false;
            } finally {
               if (var9) {
                  try {
                     var4.close();
                  } catch (IOException var11) {
                     var14 = null;
                     break label55;
                  }
               }
            }

            try {
               var4.close();
            } catch (IOException var10) {
            }
         } else {
            var14 = null;
         }
      }

      if (var14 != null) {
         var3 = fromMap(var0, var14, var2);
      }

      return var3;
   }

   public static VersionInfo[] loadVersionInfo(String[] var0, ClassLoader var1) {
      Args.notNull(var0, "Package identifier array");
      ArrayList var5 = new ArrayList(var0.length);
      int var3 = var0.length;

      for (int var2 = 0; var2 < var3; var2++) {
         VersionInfo var4 = loadVersionInfo(var0[var2], var1);
         if (var4 != null) {
            var5.add(var4);
         }
      }

      return var5.toArray(new VersionInfo[var5.size()]);
   }

   public final String getClassloader() {
      return this.infoClassloader;
   }

   public final String getModule() {
      return this.infoModule;
   }

   public final String getPackage() {
      return this.infoPackage;
   }

   public final String getRelease() {
      return this.infoRelease;
   }

   public final String getTimestamp() {
      return this.infoTimestamp;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(
         this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length()
      );
      var1.append("VersionInfo(").append(this.infoPackage).append(':').append(this.infoModule);
      if (!"UNAVAILABLE".equals(this.infoRelease)) {
         var1.append(':').append(this.infoRelease);
      }

      if (!"UNAVAILABLE".equals(this.infoTimestamp)) {
         var1.append(':').append(this.infoTimestamp);
      }

      var1.append(')');
      if (!"UNAVAILABLE".equals(this.infoClassloader)) {
         var1.append('@').append(this.infoClassloader);
      }

      return var1.toString();
   }
}
