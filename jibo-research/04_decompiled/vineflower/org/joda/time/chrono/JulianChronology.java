package org.joda.time.chrono;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.SkipDateTimeField;

public final class JulianChronology extends BasicGJChronology {
   private static final JulianChronology a = b(DateTimeZone.a);
   private static final ConcurrentHashMap<DateTimeZone, JulianChronology[]> b = new ConcurrentHashMap<>();

   JulianChronology(Chronology var1, Object var2, int var3) {
      super(var1, var2, var3);
   }

   public static JulianChronology a(DateTimeZone param0, int param1) {
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
      // 00: aload 0
      // 01: astore 3
      // 02: aload 0
      // 03: ifnonnull 0a
      // 06: invokestatic org/joda/time/DateTimeZone.a ()Lorg/joda/time/DateTimeZone;
      // 09: astore 3
      // 0a: getstatic org/joda/time/chrono/JulianChronology.b Ljava/util/concurrent/ConcurrentHashMap;
      // 0d: aload 3
      // 0e: invokevirtual java/util/concurrent/ConcurrentHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 11: checkcast [Lorg/joda/time/chrono/JulianChronology;
      // 14: astore 0
      // 15: aload 0
      // 16: ifnonnull 8a
      // 19: bipush 7
      // 1b: anewarray 2
      // 1e: astore 0
      // 1f: getstatic org/joda/time/chrono/JulianChronology.b Ljava/util/concurrent/ConcurrentHashMap;
      // 22: aload 3
      // 23: aload 0
      // 24: invokevirtual java/util/concurrent/ConcurrentHashMap.putIfAbsent (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 27: checkcast [Lorg/joda/time/chrono/JulianChronology;
      // 2a: astore 2
      // 2b: aload 2
      // 2c: ifnull 31
      // 2f: aload 2
      // 30: astore 0
      // 31: aload 0
      // 32: iload 1
      // 33: bipush 1
      // 34: isub
      // 35: aaload
      // 36: astore 4
      // 38: aload 4
      // 3a: astore 2
      // 3b: aload 4
      // 3d: ifnonnull 6b
      // 40: aload 0
      // 41: monitorenter
      // 42: aload 0
      // 43: iload 1
      // 44: bipush 1
      // 45: isub
      // 46: aaload
      // 47: astore 4
      // 49: aload 4
      // 4b: astore 2
      // 4c: aload 4
      // 4e: ifnonnull 69
      // 51: aload 3
      // 52: getstatic org/joda/time/DateTimeZone.a Lorg/joda/time/DateTimeZone;
      // 55: if_acmpne 6d
      // 58: new org/joda/time/chrono/JulianChronology
      // 5b: astore 2
      // 5c: aload 2
      // 5d: aconst_null
      // 5e: aconst_null
      // 5f: iload 1
      // 60: invokespecial org/joda/time/chrono/JulianChronology.<init> (Lorg/joda/time/Chronology;Ljava/lang/Object;I)V
      // 63: aload 0
      // 64: iload 1
      // 65: bipush 1
      // 66: isub
      // 67: aload 2
      // 68: aastore
      // 69: aload 0
      // 6a: monitorexit
      // 6b: aload 2
      // 6c: areturn
      // 6d: new org/joda/time/chrono/JulianChronology
      // 70: dup
      // 71: getstatic org/joda/time/DateTimeZone.a Lorg/joda/time/DateTimeZone;
      // 74: iload 1
      // 75: invokestatic org/joda/time/chrono/JulianChronology.a (Lorg/joda/time/DateTimeZone;I)Lorg/joda/time/chrono/JulianChronology;
      // 78: aload 3
      // 79: invokestatic org/joda/time/chrono/ZonedChronology.a (Lorg/joda/time/Chronology;Lorg/joda/time/DateTimeZone;)Lorg/joda/time/chrono/ZonedChronology;
      // 7c: aconst_null
      // 7d: iload 1
      // 7e: invokespecial org/joda/time/chrono/JulianChronology.<init> (Lorg/joda/time/Chronology;Ljava/lang/Object;I)V
      // 81: astore 2
      // 82: goto 63
      // 85: astore 2
      // 86: aload 0
      // 87: monitorexit
      // 88: aload 2
      // 89: athrow
      // 8a: goto 31
      // try (48 -> 58): 80 null
      // try (64 -> 66): 80 null
      // try (68 -> 79): 80 null
      // try (81 -> 83): 80 null
   }

   public static JulianChronology b(DateTimeZone var0) {
      return a(var0, 4);
   }

   static int h(int var0) {
      int var1 = var0;
      if (var0 <= 0) {
         if (var0 == 0) {
            throw new IllegalFieldValueException(DateTimeFieldType.s(), var0, null, null);
         }

         var1 = var0 + 1;
      }

      return var1;
   }

   private Object readResolve() {
      Chronology var3 = this.L();
      int var2 = this.N();
      int var1 = var2;
      if (var2 == 0) {
         var1 = 4;
      }

      JulianChronology var4;
      if (var3 == null) {
         var4 = a(DateTimeZone.a, var1);
      } else {
         var4 = a(var3.a(), var1);
      }

      return var4;
   }

   @Override
   int Q() {
      return -292269054;
   }

   @Override
   int R() {
      return 292272992;
   }

   @Override
   long T() {
      return 31557600000L;
   }

   @Override
   long U() {
      return 15778800000L;
   }

   @Override
   long V() {
      return 2629800000L;
   }

   @Override
   long W() {
      return 31083663600000L;
   }

   @Override
   public Chronology a(DateTimeZone var1) {
      DateTimeZone var2 = var1;
      if (var1 == null) {
         var2 = DateTimeZone.a();
      }

      JulianChronology var3;
      if (var2 == this.a()) {
         var3 = this;
      } else {
         var3 = b(var2);
      }

      return var3;
   }

   @Override
   protected void a(AssembledChronology.Fields var1) {
      if (this.L() == null) {
         super.a(var1);
         var1.E = new SkipDateTimeField(this, var1.E);
         var1.B = new SkipDateTimeField(this, var1.B);
      }
   }

   @Override
   long b(int var1, int var2, int var3) throws IllegalArgumentException {
      return super.b(h(var1), var2, var3);
   }

   @Override
   public Chronology b() {
      return a;
   }

   @Override
   boolean e(int var1) {
      boolean var2;
      if ((var1 & 3) == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   long f(int var1) {
      int var4 = var1 - 1968;
      int var2;
      if (var4 <= 0) {
         var2 = var4 + 3 >> 2;
      } else {
         int var3 = var4 >> 2;
         var2 = var3;
         if (!this.e(var1)) {
            var2 = var3 + 1;
         }
      }

      long var5 = var4;
      return (var2 + var5 * 365L) * 86400000L - 62035200000L;
   }
}
