package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

public final class UnsupportedDateTimeField extends DateTimeField implements Serializable {
   private static HashMap<DateTimeFieldType, UnsupportedDateTimeField> a;
   private final DateTimeFieldType b;
   private final DurationField c;

   private UnsupportedDateTimeField(DateTimeFieldType var1, DurationField var2) {
      if (var1 != null && var2 != null) {
         this.b = var1;
         this.c = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   public static UnsupportedDateTimeField a(DateTimeFieldType param0, DurationField param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc org/joda/time/field/UnsupportedDateTimeField
      // 02: monitorenter
      // 03: getstatic org/joda/time/field/UnsupportedDateTimeField.a Ljava/util/HashMap;
      // 06: ifnonnull 37
      // 09: new java/util/HashMap
      // 0c: astore 2
      // 0d: aload 2
      // 0e: bipush 7
      // 10: invokespecial java/util/HashMap.<init> (I)V
      // 13: aload 2
      // 14: putstatic org/joda/time/field/UnsupportedDateTimeField.a Ljava/util/HashMap;
      // 17: aconst_null
      // 18: astore 2
      // 19: aload 2
      // 1a: astore 3
      // 1b: aload 2
      // 1c: ifnonnull 32
      // 1f: new org/joda/time/field/UnsupportedDateTimeField
      // 22: astore 3
      // 23: aload 3
      // 24: aload 0
      // 25: aload 1
      // 26: invokespecial org/joda/time/field/UnsupportedDateTimeField.<init> (Lorg/joda/time/DateTimeFieldType;Lorg/joda/time/DurationField;)V
      // 29: getstatic org/joda/time/field/UnsupportedDateTimeField.a Ljava/util/HashMap;
      // 2c: aload 0
      // 2d: aload 3
      // 2e: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 31: pop
      // 32: ldc org/joda/time/field/UnsupportedDateTimeField
      // 34: monitorexit
      // 35: aload 3
      // 36: areturn
      // 37: getstatic org/joda/time/field/UnsupportedDateTimeField.a Ljava/util/HashMap;
      // 3a: aload 0
      // 3b: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 3e: checkcast org/joda/time/field/UnsupportedDateTimeField
      // 41: astore 3
      // 42: aload 3
      // 43: astore 2
      // 44: aload 3
      // 45: ifnull 19
      // 48: aload 3
      // 49: invokevirtual org/joda/time/field/UnsupportedDateTimeField.d ()Lorg/joda/time/DurationField;
      // 4c: astore 4
      // 4e: aload 3
      // 4f: astore 2
      // 50: aload 4
      // 52: aload 1
      // 53: if_acmpeq 19
      // 56: aconst_null
      // 57: astore 2
      // 58: goto 19
      // 5b: astore 0
      // 5c: ldc org/joda/time/field/UnsupportedDateTimeField
      // 5e: monitorexit
      // 5f: aload 0
      // 60: athrow
      // try (2 -> 11): 52 null
      // try (17 -> 28): 52 null
      // try (32 -> 37): 52 null
      // try (41 -> 44): 52 null
   }

   private UnsupportedOperationException i() {
      return new UnsupportedOperationException(this.b + " field is unsupported");
   }

   private Object readResolve() {
      return a(this.b, this.c);
   }

   @Override
   public int a(long var1) {
      throw this.i();
   }

   @Override
   public int a(Locale var1) {
      throw this.i();
   }

   @Override
   public long a(long var1, int var3) {
      return this.d().a(var1, var3);
   }

   @Override
   public long a(long var1, long var3) {
      return this.d().a(var1, var3);
   }

   @Override
   public long a(long var1, String var3, Locale var4) {
      throw this.i();
   }

   @Override
   public String a(int var1, Locale var2) {
      throw this.i();
   }

   @Override
   public String a(long var1, Locale var3) {
      throw this.i();
   }

   @Override
   public String a(ReadablePartial var1, Locale var2) {
      throw this.i();
   }

   @Override
   public DateTimeFieldType a() {
      return this.b;
   }

   @Override
   public long b(long var1, int var3) {
      throw this.i();
   }

   @Override
   public String b() {
      return this.b.x();
   }

   @Override
   public String b(int var1, Locale var2) {
      throw this.i();
   }

   @Override
   public String b(long var1, Locale var3) {
      throw this.i();
   }

   @Override
   public String b(ReadablePartial var1, Locale var2) {
      throw this.i();
   }

   @Override
   public boolean b(long var1) {
      throw this.i();
   }

   @Override
   public int c(long var1) {
      throw this.i();
   }

   @Override
   public boolean c() {
      return false;
   }

   @Override
   public long d(long var1) {
      throw this.i();
   }

   @Override
   public DurationField d() {
      return this.c;
   }

   @Override
   public long e(long var1) {
      throw this.i();
   }

   @Override
   public DurationField e() {
      return null;
   }

   @Override
   public long f(long var1) {
      throw this.i();
   }

   @Override
   public DurationField f() {
      return null;
   }

   @Override
   public int g() {
      throw this.i();
   }

   @Override
   public long g(long var1) {
      throw this.i();
   }

   @Override
   public int h() {
      throw this.i();
   }

   @Override
   public long h(long var1) {
      throw this.i();
   }

   @Override
   public long i(long var1) {
      throw this.i();
   }

   @Override
   public String toString() {
      return "UnsupportedDateTimeField";
   }
}
