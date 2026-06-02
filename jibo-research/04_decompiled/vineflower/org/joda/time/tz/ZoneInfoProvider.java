package org.joda.time.tz;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;

public class ZoneInfoProvider implements Provider {
   private final File a;
   private final String b;
   private final ClassLoader c;
   private final Map<String, Object> d;
   private final Set<String> e;

   public ZoneInfoProvider(File var1) throws IOException {
      if (var1 == null) {
         throw new IllegalArgumentException("No file directory provided");
      }

      if (!var1.exists()) {
         throw new IOException("File directory doesn't exist: " + var1);
      }

      if (!var1.isDirectory()) {
         throw new IOException("File doesn't refer to a directory: " + var1);
      }

      this.a = var1;
      this.b = null;
      this.c = null;
      this.d = a(this.b("ZoneInfoMap"));
      this.e = Collections.unmodifiableSortedSet(new TreeSet<>(this.d.keySet()));
   }

   public ZoneInfoProvider(String var1) throws IOException {
      this(var1, null, false);
   }

   private ZoneInfoProvider(String var1, ClassLoader var2, boolean var3) throws IOException {
      if (var1 == null) {
         throw new IllegalArgumentException("No resource path provided");
      }

      String var4 = var1;
      if (!var1.endsWith("/")) {
         var4 = var1 + '/';
      }

      this.a = null;
      this.b = var4;
      ClassLoader var5 = var2;
      if (var2 == null) {
         var5 = var2;
         if (!var3) {
            var5 = this.getClass().getClassLoader();
         }
      }

      this.c = var5;
      this.d = a(this.b("ZoneInfoMap"));
      this.e = Collections.unmodifiableSortedSet(new TreeSet<>(this.d.keySet()));
   }

   private static Map<String, Object> a(InputStream var0) throws IOException {
      ConcurrentHashMap var1 = new ConcurrentHashMap();
      DataInputStream var2 = new DataInputStream(var0);

      try {
         a(var2, var1);
      } finally {
         try {
            var2.close();
         } catch (IOException var6) {
         }
      }

      var1.put("UTC", new SoftReference<>(DateTimeZone.a));
      return var1;
   }

   private static void a(DataInputStream var0, Map<String, Object> var1) throws IOException {
      byte var3 = 0;
      int var4 = var0.readUnsignedShort();
      String[] var5 = new String[var4];

      for (int var2 = 0; var2 < var4; var2++) {
         var5[var2] = var0.readUTF().intern();
      }

      var4 = var0.readUnsignedShort();

      for (int var7 = var3; var7 < var4; var7++) {
         try {
            var1.put(var5[var0.readUnsignedShort()], var5[var0.readUnsignedShort()]);
         } catch (ArrayIndexOutOfBoundsException var6) {
            throw new IOException("Corrupt zone info map");
         }
      }
   }

   private InputStream b(String var1) throws IOException {
      InputStream var4;
      if (this.a != null) {
         var4 = new FileInputStream(new File(this.a, var1));
      } else {
         String var3 = this.b.concat(var1);
         InputStream var2 = AccessController.doPrivileged(new PrivilegedAction<InputStream>(this, var3) {
            final String a;
            final ZoneInfoProvider b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public InputStream a() {
               InputStream var1x;
               if (this.b.c != null) {
                  var1x = this.b.c.getResourceAsStream(this.a);
               } else {
                  var1x = ClassLoader.getSystemResourceAsStream(this.a);
               }

               return var1x;
            }
         });
         var4 = var2;
         if (var2 == null) {
            StringBuilder var6 = new StringBuilder(40).append("Resource not found: \"").append(var3).append("\" ClassLoader: ");
            if (this.c != null) {
               var1 = this.c.toString();
            } else {
               var1 = "system";
            }

            throw new IOException(var6.append(var1).toString());
         }
      }

      return var4;
   }

   private DateTimeZone c(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: invokespecial org/joda/time/tz/ZoneInfoProvider.b (Ljava/lang/String;)Ljava/io/InputStream;
      // 05: astore 3
      // 06: aload 3
      // 07: astore 2
      // 08: aload 3
      // 09: aload 1
      // 0a: invokestatic org/joda/time/tz/DateTimeZoneBuilder.a (Ljava/io/InputStream;Ljava/lang/String;)Lorg/joda/time/DateTimeZone;
      // 0d: astore 4
      // 0f: aload 3
      // 10: astore 2
      // 11: aload 0
      // 12: getfield org/joda/time/tz/ZoneInfoProvider.d Ljava/util/Map;
      // 15: astore 5
      // 17: aload 3
      // 18: astore 2
      // 19: new java/lang/ref/SoftReference
      // 1c: astore 6
      // 1e: aload 3
      // 1f: astore 2
      // 20: aload 6
      // 22: aload 4
      // 24: invokespecial java/lang/ref/SoftReference.<init> (Ljava/lang/Object;)V
      // 27: aload 3
      // 28: astore 2
      // 29: aload 5
      // 2b: aload 1
      // 2c: aload 6
      // 2e: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 33: pop
      // 34: aload 4
      // 36: astore 1
      // 37: aload 3
      // 38: ifnull 42
      // 3b: aload 3
      // 3c: invokevirtual java/io/InputStream.close ()V
      // 3f: aload 4
      // 41: astore 1
      // 42: aload 1
      // 43: areturn
      // 44: astore 4
      // 46: aconst_null
      // 47: astore 3
      // 48: aload 3
      // 49: astore 2
      // 4a: aload 0
      // 4b: aload 4
      // 4d: invokevirtual org/joda/time/tz/ZoneInfoProvider.a (Ljava/lang/Exception;)V
      // 50: aload 3
      // 51: astore 2
      // 52: aload 0
      // 53: getfield org/joda/time/tz/ZoneInfoProvider.d Ljava/util/Map;
      // 56: aload 1
      // 57: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 5c: pop
      // 5d: aload 3
      // 5e: ifnull 65
      // 61: aload 3
      // 62: invokevirtual java/io/InputStream.close ()V
      // 65: aconst_null
      // 66: astore 1
      // 67: goto 42
      // 6a: astore 1
      // 6b: aconst_null
      // 6c: astore 2
      // 6d: aload 2
      // 6e: ifnull 75
      // 71: aload 2
      // 72: invokevirtual java/io/InputStream.close ()V
      // 75: aload 1
      // 76: athrow
      // 77: astore 1
      // 78: aload 4
      // 7a: astore 1
      // 7b: goto 42
      // 7e: astore 1
      // 7f: goto 65
      // 82: astore 2
      // 83: goto 75
      // 86: astore 1
      // 87: goto 6d
      // 8a: astore 4
      // 8c: goto 48
      // try (0 -> 4): 41 java/io/IOException
      // try (0 -> 4): 63 null
      // try (6 -> 10): 82 java/io/IOException
      // try (6 -> 10): 80 null
      // try (12 -> 15): 82 java/io/IOException
      // try (12 -> 15): 80 null
      // try (17 -> 19): 82 java/io/IOException
      // try (17 -> 19): 80 null
      // try (21 -> 24): 82 java/io/IOException
      // try (21 -> 24): 80 null
      // try (26 -> 31): 82 java/io/IOException
      // try (26 -> 31): 80 null
      // try (35 -> 37): 72 java/io/IOException
      // try (46 -> 49): 80 null
      // try (51 -> 56): 80 null
      // try (58 -> 60): 76 java/io/IOException
      // try (68 -> 70): 78 java/io/IOException
   }

   @Override
   public Set<String> a() {
      return this.e;
   }

   @Override
   public DateTimeZone a(String var1) {
      DateTimeZone var2;
      if (var1 == null) {
         var2 = null;
      } else {
         Object var4 = this.d.get(var1);
         if (var4 == null) {
            var2 = null;
         } else if (var4 instanceof SoftReference) {
            DateTimeZone var3 = (DateTimeZone)((SoftReference)var4).get();
            var2 = var3;
            if (var3 == null) {
               var2 = this.c(var1);
            }
         } else if (var1.equals(var4)) {
            var2 = this.c(var1);
         } else {
            var2 = this.a((String)var4);
         }
      }

      return var2;
   }

   protected void a(Exception var1) {
      var1.printStackTrace();
   }
}
