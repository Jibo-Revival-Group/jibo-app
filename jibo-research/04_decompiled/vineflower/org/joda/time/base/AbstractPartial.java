package org.joda.time.base;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.ReadablePartial;
import org.joda.time.field.FieldUtils;

public abstract class AbstractPartial implements Comparable<ReadablePartial>, ReadablePartial {
   protected AbstractPartial() {
   }

   @Override
   public int a(DateTimeFieldType var1) {
      return this.a(this.d(var1));
   }

   public int a(ReadablePartial var1) {
      byte var4 = 0;
      byte var2;
      if (this == var1) {
         var2 = var4;
      } else {
         if (this.a() != var1.a()) {
            throw new ClassCastException("ReadablePartial objects must have matching field types");
         }

         int var3 = this.a();

         for (int var6 = 0; var6 < var3; var6++) {
            if (this.b(var6) != var1.b(var6)) {
               throw new ClassCastException("ReadablePartial objects must have matching field types");
            }
         }

         int var5 = this.a();
         var3 = 0;

         while (true) {
            var2 = var4;
            if (var3 >= var5) {
               break;
            }

            if (this.a(var3) > var1.a(var3)) {
               var2 = 1;
               break;
            }

            if (this.a(var3) < var1.a(var3)) {
               var2 = -1;
               break;
            }

            var3++;
         }
      }

      return var2;
   }

   protected abstract DateTimeField a(int var1, Chronology var2);

   @Override
   public DateTimeFieldType b(int var1) {
      return this.a(var1, this.c()).a();
   }

   @Override
   public boolean b(DateTimeFieldType var1) {
      boolean var2;
      if (this.c(var1) != -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public int c(DateTimeFieldType var1) {
      int var2 = 0;
      int var3 = this.a();

      while (true) {
         if (var2 >= var3) {
            var2 = -1;
            break;
         }

         if (this.b(var2) == var1) {
            break;
         }

         var2++;
      }

      return var2;
   }

   protected int d(DateTimeFieldType var1) {
      int var2 = this.c(var1);
      if (var2 == -1) {
         throw new IllegalArgumentException("Field '" + var1 + "' is not supported");
      } else {
         return var2;
      }
   }

   @Override
   public boolean equals(Object var1) {
      boolean var5 = false;
      boolean var4;
      if (this == var1) {
         var4 = true;
      } else {
         var4 = var5;
         if (var1 instanceof ReadablePartial) {
            var1 = var1;
            var4 = var5;
            if (this.a() == var1.a()) {
               int var3 = this.a();
               int var2 = 0;

               while (true) {
                  if (var2 >= var3) {
                     var4 = FieldUtils.a(this.c(), var1.c());
                     break;
                  }

                  var4 = var5;
                  if (this.a(var2) != var1.a(var2)) {
                     break;
                  }

                  var4 = var5;
                  if (this.b(var2) != var1.b(var2)) {
                     break;
                  }

                  var2++;
               }
            }
         }
      }

      return var4;
   }

   @Override
   public int hashCode() {
      int var1 = 157;
      int var2 = 0;

      for (int var3 = this.a(); var2 < var3; var2++) {
         var1 = (var1 * 23 + this.a(var2)) * 23 + this.b(var2).hashCode();
      }

      return this.c().hashCode() + var1;
   }
}
