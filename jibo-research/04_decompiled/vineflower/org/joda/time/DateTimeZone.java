package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.FormatUtils;
import org.joda.time.tz.DefaultNameProvider;
import org.joda.time.tz.FixedDateTimeZone;
import org.joda.time.tz.NameProvider;
import org.joda.time.tz.Provider;

public abstract class DateTimeZone implements Serializable {
   public static final DateTimeZone a = UTCDateTimeZone.b;
   private static final AtomicReference<Provider> b = new AtomicReference<>();
   private static final AtomicReference<NameProvider> c = new AtomicReference<>();
   private static final AtomicReference<DateTimeZone> d = new AtomicReference<>();
   private final String e;

   protected DateTimeZone(String var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Id must not be null");
      }

      this.e = var1;
   }

   public static DateTimeZone a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: getstatic org/joda/time/DateTimeZone.d Ljava/util/concurrent/atomic/AtomicReference;
      // 03: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 06: checkcast org/joda/time/DateTimeZone
      // 09: astore 1
      // 0a: aload 1
      // 0b: astore 2
      // 0c: aload 1
      // 0d: ifnonnull 55
      // 10: aload 1
      // 11: astore 0
      // 12: ldc "user.timezone"
      // 14: invokestatic java/lang/System.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 17: astore 2
      // 18: aload 1
      // 19: astore 0
      // 1a: aload 2
      // 1b: ifnull 27
      // 1e: aload 1
      // 1f: astore 0
      // 20: aload 2
      // 21: invokestatic org/joda/time/DateTimeZone.a (Ljava/lang/String;)Lorg/joda/time/DateTimeZone;
      // 24: astore 2
      // 25: aload 2
      // 26: astore 0
      // 27: aload 0
      // 28: astore 1
      // 29: aload 0
      // 2a: ifnonnull 34
      // 2d: invokestatic java/util/TimeZone.getDefault ()Ljava/util/TimeZone;
      // 30: invokestatic org/joda/time/DateTimeZone.a (Ljava/util/TimeZone;)Lorg/joda/time/DateTimeZone;
      // 33: astore 1
      // 34: aload 1
      // 35: astore 0
      // 36: aload 1
      // 37: ifnonnull 3e
      // 3a: getstatic org/joda/time/DateTimeZone.a Lorg/joda/time/DateTimeZone;
      // 3d: astore 0
      // 3e: aload 0
      // 3f: astore 2
      // 40: getstatic org/joda/time/DateTimeZone.d Ljava/util/concurrent/atomic/AtomicReference;
      // 43: aconst_null
      // 44: aload 0
      // 45: invokevirtual java/util/concurrent/atomic/AtomicReference.compareAndSet (Ljava/lang/Object;Ljava/lang/Object;)Z
      // 48: ifne 55
      // 4b: getstatic org/joda/time/DateTimeZone.d Ljava/util/concurrent/atomic/AtomicReference;
      // 4e: invokevirtual java/util/concurrent/atomic/AtomicReference.get ()Ljava/lang/Object;
      // 51: checkcast org/joda/time/DateTimeZone
      // 54: astore 2
      // 55: aload 2
      // 56: areturn
      // 57: astore 1
      // 58: aload 0
      // 59: astore 1
      // 5a: goto 34
      // 5d: astore 0
      // 5e: aload 1
      // 5f: astore 0
      // 60: goto 27
      // try (10 -> 13): 54 java/lang/RuntimeException
      // try (10 -> 13): 50 java/lang/IllegalArgumentException
      // try (19 -> 22): 54 java/lang/RuntimeException
      // try (19 -> 22): 50 java/lang/IllegalArgumentException
      // try (28 -> 31): 50 java/lang/IllegalArgumentException
   }

   public static DateTimeZone a(int var0) {
      if (var0 >= -86399999 && var0 <= 86399999) {
         return a(b(var0), var0);
      } else {
         throw new IllegalArgumentException("Millis out of range: " + var0);
      }
   }

   @FromString
   public static DateTimeZone a(String var0) {
      DateTimeZone var2;
      if (var0 == null) {
         var2 = a();
      } else if (var0.equals("UTC")) {
         var2 = a;
      } else {
         DateTimeZone var3 = c().a(var0);
         var2 = var3;
         if (var3 == null) {
            if (!var0.startsWith("+") && !var0.startsWith("-")) {
               throw new IllegalArgumentException("The datetime zone id '" + var0 + "' is not recognised");
            }

            int var1 = d(var0);
            if (var1 == 0L) {
               var2 = a;
            } else {
               var2 = a(b(var1), var1);
            }
         }
      }

      return var2;
   }

   private static DateTimeZone a(String var0, int var1) {
      DateTimeZone var2;
      if (var1 == 0) {
         var2 = a;
      } else {
         var2 = new FixedDateTimeZone(var0, null, var1, var1);
      }

      return var2;
   }

   public static DateTimeZone a(TimeZone var0) {
      DateTimeZone var8;
      if (var0 == null) {
         var8 = a();
      } else {
         String var5 = var0.getID();
         if (var5 == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
         }

         if (var5.equals("UTC")) {
            var8 = a;
         } else {
            DateTimeZone var7 = null;
            String var4 = c(var5);
            Provider var6 = c();
            if (var4 != null) {
               var7 = var6.a(var4);
            }

            DateTimeZone var3 = var7;
            if (var7 == null) {
               var3 = var6.a(var5);
            }

            var8 = var3;
            if (var3 == null) {
               if (var4 != null || !var5.startsWith("GMT+") && !var5.startsWith("GMT-")) {
                  throw new IllegalArgumentException("The datetime zone id '" + var5 + "' is not recognised");
               }

               String var10 = var5.substring(3);
               String var9 = var10;
               if (var10.length() > 2) {
                  char var1 = var10.charAt(1);
                  var9 = var10;
                  if (var1 > '9') {
                     var9 = var10;
                     if (Character.isDigit(var1)) {
                        var9 = b(var10);
                     }
                  }
               }

               int var2 = d(var9);
               if (var2 == 0L) {
                  var8 = a;
               } else {
                  var8 = a(b(var2), var2);
               }
            }
         }
      }

      return var8;
   }

   private static Provider a(Provider var0) {
      Set var1 = var0.a();
      if (var1 == null || var1.size() == 0) {
         throw new IllegalArgumentException("The provider doesn't have any available ids");
      } else if (!var1.contains("UTC")) {
         throw new IllegalArgumentException("The provider doesn't support UTC");
      } else if (!a.equals(var0.a("UTC"))) {
         throw new IllegalArgumentException("Invalid UTC zone provided");
      } else {
         return var0;
      }
   }

   private static String b(int var0) {
      StringBuffer var2 = new StringBuffer();
      if (var0 >= 0) {
         var2.append('+');
      } else {
         var2.append('-');
         var0 = -var0;
      }

      int var1 = var0 / 3600000;
      FormatUtils.a(var2, var1, 2);
      var0 -= var1 * 3600000;
      var1 = var0 / 60000;
      var2.append(':');
      FormatUtils.a(var2, var1, 2);
      var0 -= var1 * 60000;
      String var8;
      if (var0 == 0) {
         var8 = var2.toString();
      } else {
         var1 = var0 / 1000;
         var2.append(':');
         FormatUtils.a(var2, var1, 2);
         var0 -= var1 * 1000;
         if (var0 == 0) {
            var8 = var2.toString();
         } else {
            var2.append('.');
            FormatUtils.a(var2, var0, 3);
            var8 = var2.toString();
         }
      }

      return var8;
   }

   private static String b(String var0) {
      StringBuilder var3 = new StringBuilder(var0);

      for (int var1 = 0; var1 < var3.length(); var1++) {
         int var2 = Character.digit(var3.charAt(var1), 10);
         if (var2 >= 0) {
            var3.setCharAt(var1, (char)(var2 + 48));
         }
      }

      return var3.toString();
   }

   public static Set<String> b() {
      return c().a();
   }

   private static String c(String var0) {
      return DateTimeZone.LazyInit.a.get(var0);
   }

   public static Provider c() {
      Provider var1 = b.get();
      Provider var0 = var1;
      if (var1 == null) {
         var1 = g();
         var0 = var1;
         if (!b.compareAndSet(null, var1)) {
            var0 = b.get();
         }
      }

      return var0;
   }

   private static int d(String var0) {
      return -((int)DateTimeZone.LazyInit.b.a(var0));
   }

   public static NameProvider d() {
      NameProvider var1 = c.get();
      NameProvider var0 = var1;
      if (var1 == null) {
         var1 = h();
         var0 = var1;
         if (!c.compareAndSet(null, var1)) {
            var0 = c.get();
         }
      }

      return var0;
   }

   private static Provider g() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc_w "org.joda.time.DateTimeZone.Provider"
      // 03: invokestatic java/lang/System.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 06: astore 0
      // 07: aload 0
      // 08: ifnull 28
      // 0b: aload 0
      // 0c: invokestatic java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
      // 0f: invokevirtual java/lang/Class.newInstance ()Ljava/lang/Object;
      // 12: checkcast org/joda/time/tz/Provider
      // 15: invokestatic org/joda/time/DateTimeZone.a (Lorg/joda/time/tz/Provider;)Lorg/joda/time/tz/Provider;
      // 18: astore 0
      // 19: aload 0
      // 1a: areturn
      // 1b: astore 1
      // 1c: new java/lang/RuntimeException
      // 1f: astore 0
      // 20: aload 0
      // 21: aload 1
      // 22: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/Throwable;)V
      // 25: aload 0
      // 26: athrow
      // 27: astore 0
      // 28: ldc_w "org.joda.time.DateTimeZone.Folder"
      // 2b: invokestatic java/lang/System.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 2e: astore 0
      // 2f: aload 0
      // 30: ifnull 5a
      // 33: new org/joda/time/tz/ZoneInfoProvider
      // 36: astore 2
      // 37: new java/io/File
      // 3a: astore 1
      // 3b: aload 1
      // 3c: aload 0
      // 3d: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 40: aload 2
      // 41: aload 1
      // 42: invokespecial org/joda/time/tz/ZoneInfoProvider.<init> (Ljava/io/File;)V
      // 45: aload 2
      // 46: invokestatic org/joda/time/DateTimeZone.a (Lorg/joda/time/tz/Provider;)Lorg/joda/time/tz/Provider;
      // 49: astore 0
      // 4a: goto 19
      // 4d: astore 1
      // 4e: new java/lang/RuntimeException
      // 51: astore 0
      // 52: aload 0
      // 53: aload 1
      // 54: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/Throwable;)V
      // 57: aload 0
      // 58: athrow
      // 59: astore 0
      // 5a: new org/joda/time/tz/ZoneInfoProvider
      // 5d: astore 0
      // 5e: aload 0
      // 5f: ldc_w "org/joda/time/tz/data"
      // 62: invokespecial org/joda/time/tz/ZoneInfoProvider.<init> (Ljava/lang/String;)V
      // 65: aload 0
      // 66: invokestatic org/joda/time/DateTimeZone.a (Lorg/joda/time/tz/Provider;)Lorg/joda/time/tz/Provider;
      // 69: astore 0
      // 6a: goto 19
      // 6d: astore 0
      // 6e: aload 0
      // 6f: invokevirtual java/lang/Exception.printStackTrace ()V
      // 72: new org/joda/time/tz/UTCProvider
      // 75: dup
      // 76: invokespecial org/joda/time/tz/UTCProvider.<init> ()V
      // 79: astore 0
      // 7a: goto 19
      // try (0 -> 3): 21 java/lang/SecurityException
      // try (5 -> 11): 13 java/lang/Exception
      // try (5 -> 11): 21 java/lang/SecurityException
      // try (14 -> 21): 21 java/lang/SecurityException
      // try (22 -> 25): 49 java/lang/SecurityException
      // try (27 -> 40): 41 java/lang/Exception
      // try (27 -> 40): 49 java/lang/SecurityException
      // try (42 -> 49): 49 java/lang/SecurityException
      // try (50 -> 58): 59 java/lang/Exception
   }

   private static NameProvider h() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc_w "org.joda.time.DateTimeZone.NameProvider"
      // 03: invokestatic java/lang/System.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 06: astore 0
      // 07: aload 0
      // 08: ifnull 38
      // 0b: aload 0
      // 0c: invokestatic java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
      // 0f: invokevirtual java/lang/Class.newInstance ()Ljava/lang/Object;
      // 12: checkcast org/joda/time/tz/NameProvider
      // 15: astore 0
      // 16: aload 0
      // 17: astore 1
      // 18: aload 0
      // 19: ifnonnull 24
      // 1c: new org/joda/time/tz/DefaultNameProvider
      // 1f: dup
      // 20: invokespecial org/joda/time/tz/DefaultNameProvider.<init> ()V
      // 23: astore 1
      // 24: aload 1
      // 25: areturn
      // 26: astore 1
      // 27: new java/lang/RuntimeException
      // 2a: astore 0
      // 2b: aload 0
      // 2c: aload 1
      // 2d: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/Throwable;)V
      // 30: aload 0
      // 31: athrow
      // 32: astore 0
      // 33: aconst_null
      // 34: astore 0
      // 35: goto 16
      // 38: aconst_null
      // 39: astore 0
      // 3a: goto 16
      // try (0 -> 3): 28 java/lang/SecurityException
      // try (5 -> 10): 20 java/lang/Exception
      // try (5 -> 10): 28 java/lang/SecurityException
      // try (21 -> 28): 28 java/lang/SecurityException
   }

   public long a(long var1, boolean var3) {
      long var8 = Long.MAX_VALUE;
      int var5 = this.b(var1);
      int var4 = this.b(var1 - var5);
      if (var5 != var4 && (var3 || var5 < 0)) {
         long var10 = this.g(var1 - var5);
         long var6 = var10;
         if (var10 == var1 - var5) {
            var6 = Long.MAX_VALUE;
         }

         var10 = this.g(var1 - var4);
         if (var10 != var1 - var4) {
            var8 = var10;
         }

         if (var6 != var8) {
            if (var3) {
               throw new IllegalInstantException(var1, this.e());
            }

            var4 = var5;
         }
      }

      long var12 = var1 - var4;
      if ((var1 ^ var12) < 0L && (var4 ^ var1) < 0L) {
         throw new ArithmeticException("Subtracting time zone offset caused overflow");
      } else {
         return var12;
      }
   }

   public long a(long var1, boolean var3, long var4) {
      int var6 = this.b(var4);
      var4 = var1 - var6;
      if (this.b(var4) == var6) {
         var1 = var4;
      } else {
         var1 = this.a(var1, var3);
      }

      return var1;
   }

   public long a(DateTimeZone var1, long var2) {
      if (var1 == null) {
         var1 = a();
      }

      if (var1 != this) {
         var2 = var1.a(this.f(var2), false, var2);
      }

      return var2;
   }

   public abstract String a(long var1);

   public String a(long var1, Locale var3) {
      Locale var4 = var3;
      if (var3 == null) {
         var4 = Locale.getDefault();
      }

      String var6 = this.a(var1);
      String var7;
      if (var6 == null) {
         var7 = this.e;
      } else {
         NameProvider var5 = d();
         String var8;
         if (var5 instanceof DefaultNameProvider) {
            var8 = ((DefaultNameProvider)var5).a(var4, this.e, var6, this.d(var1));
         } else {
            var8 = var5.a(var4, this.e, var6);
         }

         var7 = var8;
         if (var8 == null) {
            var7 = b(this.b(var1));
         }
      }

      return var7;
   }

   public abstract int b(long var1);

   public String b(long var1, Locale var3) {
      Locale var4 = var3;
      if (var3 == null) {
         var4 = Locale.getDefault();
      }

      String var6 = this.a(var1);
      String var7;
      if (var6 == null) {
         var7 = this.e;
      } else {
         NameProvider var5 = d();
         String var8;
         if (var5 instanceof DefaultNameProvider) {
            var8 = ((DefaultNameProvider)var5).b(var4, this.e, var6, this.d(var1));
         } else {
            var8 = var5.b(var4, this.e, var6);
         }

         var7 = var8;
         if (var8 == null) {
            var7 = b(this.b(var1));
         }
      }

      return var7;
   }

   public abstract int c(long var1);

   public boolean d(long var1) {
      boolean var3;
      if (this.b(var1) == this.c(var1)) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public int e(long var1) {
      long var9 = Long.MAX_VALUE;
      int var5 = this.b(var1);
      long var7 = var1 - var5;
      int var4 = this.b(var7);
      if (var5 != var4) {
         if (var5 - var4 < 0) {
            long var11 = this.g(var7);
            var7 = var11;
            if (var11 == var1 - var5) {
               var7 = Long.MAX_VALUE;
            }

            var11 = this.g(var1 - var4);
            if (var11 == var1 - var4) {
               var1 = var9;
            } else {
               var1 = var11;
            }

            if (var7 != var1) {
               return var5;
            }
         }
      } else if (var5 >= 0) {
         var1 = this.h(var7);
         if (var1 < var7) {
            int var6 = this.b(var1);
            int var3 = var6;
            if (var7 - var1 <= var6 - var5) {
               return var3;
            }
         }
      }

      return var4;
   }

   @ToString
   public final String e() {
      return this.e;
   }

   @Override
   public abstract boolean equals(Object var1);

   public long f(long var1) {
      int var3 = this.b(var1);
      long var4 = var3 + var1;
      if ((var1 ^ var4) < 0L && (var3 ^ var1) >= 0L) {
         throw new ArithmeticException("Adding time zone offset caused overflow");
      } else {
         return var4;
      }
   }

   public abstract boolean f();

   public abstract long g(long var1);

   public abstract long h(long var1);

   @Override
   public int hashCode() {
      return this.e().hashCode() + 57;
   }

   @Override
   public String toString() {
      return this.e();
   }

   protected Object writeReplace() throws ObjectStreamException {
      return new DateTimeZone.Stub(this.e);
   }

   static final class LazyInit {
      static final Map<String, String> a = b();
      static final DateTimeFormatter b = a();

      private static DateTimeFormatter a() {
         BaseChronology var0 = new BaseChronology() {
            @Override
            public Chronology a(DateTimeZone var1) {
               return this;
            }

            @Override
            public DateTimeZone a() {
               return null;
            }

            @Override
            public Chronology b() {
               return this;
            }

            @Override
            public String toString() {
               return this.getClass().getName();
            }
         };
         return new DateTimeFormatterBuilder().a(null, true, 2, 4).a().a(var0);
      }

      private static Map<String, String> b() {
         HashMap var0 = new HashMap();
         var0.put("GMT", "UTC");
         var0.put("WET", "WET");
         var0.put("CET", "CET");
         var0.put("MET", "CET");
         var0.put("ECT", "CET");
         var0.put("EET", "EET");
         var0.put("MIT", "Pacific/Apia");
         var0.put("HST", "Pacific/Honolulu");
         var0.put("AST", "America/Anchorage");
         var0.put("PST", "America/Los_Angeles");
         var0.put("MST", "America/Denver");
         var0.put("PNT", "America/Phoenix");
         var0.put("CST", "America/Chicago");
         var0.put("EST", "America/New_York");
         var0.put("IET", "America/Indiana/Indianapolis");
         var0.put("PRT", "America/Puerto_Rico");
         var0.put("CNT", "America/St_Johns");
         var0.put("AGT", "America/Argentina/Buenos_Aires");
         var0.put("BET", "America/Sao_Paulo");
         var0.put("ART", "Africa/Cairo");
         var0.put("CAT", "Africa/Harare");
         var0.put("EAT", "Africa/Addis_Ababa");
         var0.put("NET", "Asia/Yerevan");
         var0.put("PLT", "Asia/Karachi");
         var0.put("IST", "Asia/Kolkata");
         var0.put("BST", "Asia/Dhaka");
         var0.put("VST", "Asia/Ho_Chi_Minh");
         var0.put("CTT", "Asia/Shanghai");
         var0.put("JST", "Asia/Tokyo");
         var0.put("ACT", "Australia/Darwin");
         var0.put("AET", "Australia/Sydney");
         var0.put("SST", "Pacific/Guadalcanal");
         var0.put("NST", "Pacific/Auckland");
         return Collections.unmodifiableMap(var0);
      }
   }

   private static final class Stub implements Serializable {
      private transient String a;

      Stub(String var1) {
         this.a = var1;
      }

      private void readObject(ObjectInputStream var1) throws IOException {
         this.a = var1.readUTF();
      }

      private Object readResolve() throws ObjectStreamException {
         return DateTimeZone.a(this.a);
      }

      private void writeObject(ObjectOutputStream var1) throws IOException {
         var1.writeUTF(this.a);
      }
   }
}
