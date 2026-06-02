package org.joda.time.format;

import java.util.Arrays;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;

public class DateTimeParserBucket {
   private final Chronology a;
   private final long b;
   private final Locale c;
   private final int d;
   private final DateTimeZone e;
   private final Integer f;
   private DateTimeZone g;
   private Integer h;
   private Integer i;
   private DateTimeParserBucket.SavedField[] j;
   private int k;
   private boolean l;
   private Object m;

   public DateTimeParserBucket(long var1, Chronology var3, Locale var4, Integer var5, int var6) {
      var3 = DateTimeUtils.a(var3);
      this.b = var1;
      this.e = var3.a();
      this.a = var3.b();
      Locale var8 = var4;
      if (var4 == null) {
         var8 = Locale.getDefault();
      }

      this.c = var8;
      this.d = var6;
      this.f = var5;
      this.g = this.e;
      this.i = this.f;
      this.j = new DateTimeParserBucket.SavedField[8];
   }

   static int a(DurationField var0, DurationField var1) {
      int var2;
      if (var0 != null && var0.b()) {
         if (var1 != null && var1.b()) {
            var2 = -var0.compareTo(var1);
         } else {
            var2 = 1;
         }
      } else if (var1 != null && var1.b()) {
         var2 = -1;
      } else {
         var2 = 0;
      }

      return var2;
   }

   private static void a(DateTimeParserBucket.SavedField[] var0, int var1) {
      int var2 = 0;
      if (var1 > 10) {
         Arrays.sort(var0, 0, var1);
      } else {
         while (var2 < var1) {
            for (int var3 = var2; var3 > 0 && var0[var3 - 1].a(var0[var3]) > 0; var3--) {
               DateTimeParserBucket.SavedField var4 = var0[var3];
               var0[var3] = var0[var3 - 1];
               var0[var3 - 1] = var4;
            }

            var2++;
         }
      }
   }

   private DateTimeParserBucket.SavedField g() {
      DateTimeParserBucket.SavedField[] var3 = this.j;
      int var2 = this.k;
      if (var2 == var3.length || this.l) {
         int var1;
         if (var2 == var3.length) {
            var1 = var2 * 2;
         } else {
            var1 = var3.length;
         }

         DateTimeParserBucket.SavedField[] var4 = new DateTimeParserBucket.SavedField[var1];
         System.arraycopy(var3, 0, var4, 0, var2);
         this.j = var4;
         this.l = false;
         var3 = var4;
      }

      this.m = null;
      DateTimeParserBucket.SavedField var6 = var3[var2];
      DateTimeParserBucket.SavedField var5;
      if (var6 == null) {
         var6 = new DateTimeParserBucket.SavedField();
         var3[var2] = var6;
         var5 = var6;
      } else {
         var5 = var6;
      }

      this.k = var2 + 1;
      return var5;
   }

   long a(InternalParser var1, CharSequence var2) {
      int var4 = var1.parseInto(this, var2, 0);
      int var3;
      if (var4 >= 0) {
         var3 = var4;
         if (var4 >= var2.length()) {
            return this.a(true, var2);
         }
      } else {
         var3 = ~var4;
      }

      throw new IllegalArgumentException(FormatUtils.a(var2.toString(), var3));
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public long a(boolean var1, CharSequence var2) {
      DateTimeParserBucket.SavedField[] var9 = this.j;
      int var4 = this.k;
      if (this.l) {
         var9 = (DateTimeParserBucket.SavedField[])this.j.clone();
         this.j = var9;
         this.l = false;
      }

      a(var9, var4);
      if (var4 > 0) {
         DurationField var11 = DurationFieldType.i().a(this.a);
         DurationField var12 = DurationFieldType.f().a(this.a);
         DurationField var10 = var9[0].a.d();
         if (a(var10, var11) >= 0 && a(var10, var12) <= 0) {
            this.a(DateTimeFieldType.s(), this.d);
            long var24 = this.a(var1, var2);
            return var24;
         }
      }

      long var5 = this.b;
      int var3 = 0;

      long var7;
      label70:
      while (true) {
         label84: {
            IllegalFieldValueException var20;
            if (var3 < var4) {
               try {
                  var5 = var9[var3].a(var5, var1);
                  break label84;
               } catch (IllegalFieldValueException var13) {
                  var20 = var13;
                  if (var2 == null) {
                     throw var13;
                  }
               }
            } else {
               var7 = var5;
               if (!var1) {
                  break;
               }

               var3 = 0;

               while (true) {
                  var7 = var5;
                  if (var3 >= var4) {
                     break label70;
                  }

                  DateTimeParserBucket.SavedField var22 = var9[var3];
                  if (var3 == var4 - 1) {
                     var1 = true;
                  } else {
                     var1 = false;
                  }

                  try {
                     var5 = var22.a(var5, var1);
                  } catch (IllegalFieldValueException var14) {
                     var20 = var14;
                     if (var2 == null) {
                        throw var14;
                     }
                     break;
                  }

                  var3++;
               }
            }

            var20.a("Cannot parse \"" + var2 + '"');
            throw var20;
         }

         var3++;
      }

      if (this.h != null) {
         var5 = var7 - this.h.intValue();
      } else {
         var5 = var7;
         if (this.g != null) {
            var3 = this.g.e(var7);
            var7 -= var3;
            var5 = var7;
            if (var3 != this.g.b(var7)) {
               String var23 = "Illegal instant due to time zone offset transition (" + this.g + ')';
               String var21 = var23;
               if (var2 != null) {
                  var21 = "Cannot parse \"" + var2 + "\": " + var23;
               }

               throw new IllegalInstantException(var21);
            }
         }
      }

      return var5;
   }

   public long a(boolean var1, String var2) {
      return this.a(var1, (CharSequence)var2);
   }

   public Chronology a() {
      return this.a;
   }

   public void a(Integer var1) {
      this.m = null;
      this.h = var1;
   }

   public void a(DateTimeField var1, int var2) {
      this.g().a(var1, var2);
   }

   public void a(DateTimeFieldType var1, int var2) {
      this.g().a(var1.a(this.a), var2);
   }

   public void a(DateTimeFieldType var1, String var2, Locale var3) {
      this.g().a(var1.a(this.a), var2, var3);
   }

   public void a(DateTimeZone var1) {
      this.m = null;
      this.g = var1;
   }

   public boolean a(Object var1) {
      boolean var2;
      if (var1 instanceof DateTimeParserBucket.SavedState && ((DateTimeParserBucket.SavedState)var1).a(this)) {
         this.m = var1;
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public Locale b() {
      return this.c;
   }

   public DateTimeZone c() {
      return this.g;
   }

   public Integer d() {
      return this.h;
   }

   public Integer e() {
      return this.i;
   }

   public Object f() {
      if (this.m == null) {
         this.m = new DateTimeParserBucket.SavedState(this);
      }

      return this.m;
   }

   static class SavedField implements Comparable<DateTimeParserBucket.SavedField> {
      DateTimeField a;
      int b;
      String c;
      Locale d;

      public int a(DateTimeParserBucket.SavedField var1) {
         DateTimeField var3 = var1.a;
         int var2 = DateTimeParserBucket.a(this.a.e(), var3.e());
         if (var2 == 0) {
            var2 = DateTimeParserBucket.a(this.a.d(), var3.d());
         }

         return var2;
      }

      long a(long var1, boolean var3) {
         if (this.c == null) {
            var1 = this.a.c(var1, this.b);
         } else {
            var1 = this.a.a(var1, this.c, this.d);
         }

         long var4 = var1;
         if (var3) {
            var4 = this.a.d(var1);
         }

         return var4;
      }

      void a(DateTimeField var1, int var2) {
         this.a = var1;
         this.b = var2;
         this.c = null;
         this.d = null;
      }

      void a(DateTimeField var1, String var2, Locale var3) {
         this.a = var1;
         this.b = 0;
         this.c = var2;
         this.d = var3;
      }
   }

   class SavedState {
      final DateTimeZone a;
      final Integer b;
      final DateTimeParserBucket.SavedField[] c;
      final int d;
      final DateTimeParserBucket e;

      SavedState(DateTimeParserBucket var1) {
         this.e = var1;
         this.a = var1.g;
         this.b = var1.h;
         this.c = var1.j;
         this.d = var1.k;
      }

      boolean a(DateTimeParserBucket var1) {
         boolean var2 = true;
         if (var1 != this.e) {
            var2 = false;
         } else {
            var1.g = this.a;
            var1.h = this.b;
            var1.j = this.c;
            if (this.d < var1.k) {
               var1.l = true;
            }

            var1.k = this.d;
         }

         return var2;
      }
   }
}
