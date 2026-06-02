package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public final class UnsupportedDurationField extends DurationField implements Serializable {
   private static HashMap<DurationFieldType, UnsupportedDurationField> a;
   private final DurationFieldType b;

   private UnsupportedDurationField(DurationFieldType var1) {
      this.b = var1;
   }

   public static UnsupportedDurationField a(DurationFieldType param0) {
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
      // 00: ldc org/joda/time/field/UnsupportedDurationField
      // 02: monitorenter
      // 03: getstatic org/joda/time/field/UnsupportedDurationField.a Ljava/util/HashMap;
      // 06: ifnonnull 36
      // 09: new java/util/HashMap
      // 0c: astore 1
      // 0d: aload 1
      // 0e: bipush 7
      // 10: invokespecial java/util/HashMap.<init> (I)V
      // 13: aload 1
      // 14: putstatic org/joda/time/field/UnsupportedDurationField.a Ljava/util/HashMap;
      // 17: aconst_null
      // 18: astore 1
      // 19: aload 1
      // 1a: astore 2
      // 1b: aload 1
      // 1c: ifnonnull 31
      // 1f: new org/joda/time/field/UnsupportedDurationField
      // 22: astore 2
      // 23: aload 2
      // 24: aload 0
      // 25: invokespecial org/joda/time/field/UnsupportedDurationField.<init> (Lorg/joda/time/DurationFieldType;)V
      // 28: getstatic org/joda/time/field/UnsupportedDurationField.a Ljava/util/HashMap;
      // 2b: aload 0
      // 2c: aload 2
      // 2d: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 30: pop
      // 31: ldc org/joda/time/field/UnsupportedDurationField
      // 33: monitorexit
      // 34: aload 2
      // 35: areturn
      // 36: getstatic org/joda/time/field/UnsupportedDurationField.a Ljava/util/HashMap;
      // 39: aload 0
      // 3a: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 3d: checkcast org/joda/time/field/UnsupportedDurationField
      // 40: astore 1
      // 41: goto 19
      // 44: astore 0
      // 45: ldc org/joda/time/field/UnsupportedDurationField
      // 47: monitorexit
      // 48: aload 0
      // 49: athrow
      // try (2 -> 11): 37 null
      // try (17 -> 27): 37 null
      // try (31 -> 36): 37 null
   }

   private UnsupportedOperationException f() {
      return new UnsupportedOperationException(this.b + " field is unsupported");
   }

   private Object readResolve() {
      return a(this.b);
   }

   public int a(DurationField var1) {
      return 0;
   }

   @Override
   public long a(long var1, int var3) {
      throw this.f();
   }

   @Override
   public long a(long var1, long var3) {
      throw this.f();
   }

   @Override
   public final DurationFieldType a() {
      return this.b;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean c() {
      return true;
   }

   @Override
   public long d() {
      return 0L;
   }

   public String e() {
      return this.b.m();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof UnsupportedDurationField) {
            var1 = var1;
            if (var1.e() == null) {
               if (this.e() != null) {
                  var2 = false;
               }
            } else {
               var2 = var1.e().equals(this.e());
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.e().hashCode();
   }

   @Override
   public String toString() {
      return "UnsupportedDurationField[" + this.e() + ']';
   }
}
