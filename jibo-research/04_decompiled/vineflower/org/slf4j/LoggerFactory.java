package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

public final class LoggerFactory {
   static volatile int a = 0;
   static final SubstituteLoggerFactory b = new SubstituteLoggerFactory();
   static final NOPLoggerFactory c = new NOPLoggerFactory();
   static boolean d = Util.b("slf4j.detectLoggerNameMismatch");
   private static final String[] e = new String[]{"1.6", "1.7"};
   private static String f = "org/slf4j/impl/StaticLoggerBinder.class";

   private LoggerFactory() {
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static Set<URL> a() {
      LinkedHashSet var1 = new LinkedHashSet();

      ClassLoader var0;
      try {
         var0 = LoggerFactory.class.getClassLoader();
      } catch (IOException var5) {
         Util.a("Error getting resources from path", var5);
         return var1;
      }

      Enumeration var6;
      if (var0 == null) {
         try {
            var6 = ClassLoader.getSystemResources(f);
         } catch (IOException var4) {
            Util.a("Error getting resources from path", var4);
            return var1;
         }
      } else {
         try {
            var6 = var0.getResources(f);
         } catch (IOException var3) {
            Util.a("Error getting resources from path", var3);
            return var1;
         }
      }

      while (true) {
         try {
            if (!var6.hasMoreElements()) {
               break;
            }

            var1.add((URL)var6.nextElement());
         } catch (IOException var2) {
            Util.a("Error getting resources from path", var2);
            break;
         }
      }

      return var1;
   }

   public static Logger a(String var0) {
      return b().a(var0);
   }

   private static void a(int var0) {
      Util.c("A number (" + var0 + ") of logging calls during the initialization phase have been intercepted and are");
      Util.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
      Util.c("See also http://www.slf4j.org/codes.html#replay");
   }

   static void a(Throwable var0) {
      a = 2;
      Util.a("Failed to instantiate SLF4J LoggerFactory", var0);
   }

   private static void a(SubstituteLoggingEvent var0) {
      if (var0 != null) {
         SubstituteLogger var2 = var0.a();
         String var1 = var2.a();
         if (var2.d()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
         }

         if (!var2.e()) {
            if (var2.c()) {
               var2.a(var0);
            } else {
               Util.c(var1);
            }
         }
      }
   }

   private static void a(SubstituteLoggingEvent var0, int var1) {
      if (var0.a().c()) {
         a(var1);
      } else if (!var0.a().e()) {
         g();
      }
   }

   private static boolean a(Set<URL> var0) {
      boolean var1 = true;
      if (var0.size() <= 1) {
         var1 = false;
      }

      return var1;
   }

   public static ILoggerFactory b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic org/slf4j/LoggerFactory.a I
      // 03: ifne 19
      // 06: ldc org/slf4j/LoggerFactory
      // 08: monitorenter
      // 09: getstatic org/slf4j/LoggerFactory.a I
      // 0c: ifne 16
      // 0f: bipush 1
      // 10: putstatic org/slf4j/LoggerFactory.a I
      // 13: invokestatic org/slf4j/LoggerFactory.c ()V
      // 16: ldc org/slf4j/LoggerFactory
      // 18: monitorexit
      // 19: getstatic org/slf4j/LoggerFactory.a I
      // 1c: tableswitch 32 1 4 74 64 48 57
      // 3c: new java/lang/IllegalStateException
      // 3f: dup
      // 40: ldc "Unreachable code"
      // 42: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 45: athrow
      // 46: astore 0
      // 47: ldc org/slf4j/LoggerFactory
      // 49: monitorexit
      // 4a: aload 0
      // 4b: athrow
      // 4c: invokestatic org/slf4j/impl/StaticLoggerBinder.a ()Lorg/slf4j/impl/StaticLoggerBinder;
      // 4f: invokevirtual org/slf4j/impl/StaticLoggerBinder.b ()Lorg/slf4j/ILoggerFactory;
      // 52: astore 0
      // 53: aload 0
      // 54: areturn
      // 55: getstatic org/slf4j/LoggerFactory.c Lorg/slf4j/helpers/NOPLoggerFactory;
      // 58: astore 0
      // 59: goto 53
      // 5c: new java/lang/IllegalStateException
      // 5f: dup
      // 60: ldc "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit"
      // 62: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 65: athrow
      // 66: getstatic org/slf4j/LoggerFactory.b Lorg/slf4j/helpers/SubstituteLoggerFactory;
      // 69: astore 0
      // 6a: goto 53
      // try (4 -> 9): 18 null
      // try (9 -> 11): 18 null
      // try (19 -> 21): 18 null
   }

   private static void b(Set<URL> var0) {
      if (a(var0)) {
         Util.c("Class path contains multiple SLF4J bindings.");

         for (URL var1 : var0) {
            Util.c("Found binding in [" + var1 + "]");
         }

         Util.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
      }
   }

   private static boolean b(String var0) {
      boolean var1 = false;
      if (var0 != null) {
         if (var0.contains("org/slf4j/impl/StaticLoggerBinder")) {
            var1 = true;
         } else if (var0.contains("org.slf4j.impl.StaticLoggerBinder")) {
            var1 = true;
         }
      }

      return var1;
   }

   private static final void c() {
      d();
      if (a == 3) {
         h();
      }
   }

   private static void c(Set<URL> var0) {
      if (var0 != null && a(var0)) {
         Util.c("Actual binding is of type [" + StaticLoggerBinder.a().c() + "]");
      }
   }

   private static final void d() {
      Set var0 = null;

      try {
         if (!i()) {
            var0 = a();
            b(var0);
         }

         StaticLoggerBinder.a();
         a = 3;
         c(var0);
         e();
         f();
         b.d();
      } catch (NoClassDefFoundError var2) {
         if (!b(var2.getMessage())) {
            a(var2);
            throw var2;
         }

         a = 4;
         Util.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
         Util.c("Defaulting to no-operation (NOP) logger implementation");
         Util.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
      } catch (NoSuchMethodError var3) {
         String var5 = var3.getMessage();
         if (var5 != null && var5.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
            a = 2;
            Util.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
            Util.c("Your binding is version 1.5.5 or earlier.");
            Util.c("Upgrade your binding to version 1.6.x.");
         }

         throw var3;
      } catch (Exception var4) {
         a(var4);
         throw new IllegalStateException("Unexpected initialization failure", var4);
      }
   }

   private static void e() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic org/slf4j/LoggerFactory.b Lorg/slf4j/helpers/SubstituteLoggerFactory;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: getstatic org/slf4j/LoggerFactory.b Lorg/slf4j/helpers/SubstituteLoggerFactory;
      // 09: invokevirtual org/slf4j/helpers/SubstituteLoggerFactory.c ()V
      // 0c: getstatic org/slf4j/LoggerFactory.b Lorg/slf4j/helpers/SubstituteLoggerFactory;
      // 0f: invokevirtual org/slf4j/helpers/SubstituteLoggerFactory.a ()Ljava/util/List;
      // 12: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 17: astore 1
      // 18: aload 1
      // 19: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1e: ifeq 3e
      // 21: aload 1
      // 22: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 27: checkcast org/slf4j/helpers/SubstituteLogger
      // 2a: astore 2
      // 2b: aload 2
      // 2c: aload 2
      // 2d: invokevirtual org/slf4j/helpers/SubstituteLogger.a ()Ljava/lang/String;
      // 30: invokestatic org/slf4j/LoggerFactory.a (Ljava/lang/String;)Lorg/slf4j/Logger;
      // 33: invokevirtual org/slf4j/helpers/SubstituteLogger.a (Lorg/slf4j/Logger;)V
      // 36: goto 18
      // 39: astore 1
      // 3a: aload 0
      // 3b: monitorexit
      // 3c: aload 1
      // 3d: athrow
      // 3e: aload 0
      // 3f: monitorexit
      // 40: return
      // try (4 -> 10): 23 null
      // try (10 -> 22): 23 null
      // try (24 -> 26): 23 null
      // try (28 -> 30): 23 null
   }

   private static void f() {
      LinkedBlockingQueue var2 = b.b();
      int var1 = var2.size();
      int var0 = 0;
      ArrayList var3 = new ArrayList(128);

      while (var2.drainTo(var3, 128) != 0) {
         for (SubstituteLoggingEvent var5 : var3) {
            a(var5);
            if (var0 == 0) {
               a(var5, var1);
            }

            var0++;
         }

         var3.clear();
      }
   }

   private static void g() {
      Util.c("The following set of substitute loggers may have been accessed");
      Util.c("during the initialization phase. Logging calls during this");
      Util.c("phase were not honored. However, subsequent logging calls to these");
      Util.c("loggers will work as normally expected.");
      Util.c("See also http://www.slf4j.org/codes.html#substituteLogger");
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static final void h() {
      boolean var1 = false;

      int var2;
      String var3;
      String[] var4;
      try {
         var3 = StaticLoggerBinder.a;
         var4 = e;
         var2 = var4.length;
      } catch (NoSuchFieldError var9) {
         return;
      } catch (Throwable var10) {
         Util.a("Unexpected problem occured during version sanity check", var10);
         return;
      }

      int var0 = 0;

      while (true) {
         if (var0 >= var2) {
            if (!var1) {
               try {
                  StringBuilder var11 = new StringBuilder();
                  Util.c(
                     var11.append("The requested version ")
                        .append(var3)
                        .append(" by your slf4j binding is not compatible with ")
                        .append(Arrays.asList(e).toString())
                        .toString()
                  );
                  Util.c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
               } catch (NoSuchFieldError var5) {
               } catch (Throwable var6) {
                  Util.a("Unexpected problem occured during version sanity check", var6);
               }
            }
            break;
         }

         label35: {
            try {
               if (!var3.startsWith(var4[var0])) {
                  break label35;
               }
            } catch (NoSuchFieldError var7) {
               break;
            } catch (Throwable var8) {
               Util.a("Unexpected problem occured during version sanity check", var8);
               break;
            }

            var1 = true;
         }

         var0++;
      }
   }

   private static boolean i() {
      String var1 = Util.a("java.vendor.url");
      boolean var0;
      if (var1 == null) {
         var0 = false;
      } else {
         var0 = var1.toLowerCase().contains("android");
      }

      return var0;
   }
}
