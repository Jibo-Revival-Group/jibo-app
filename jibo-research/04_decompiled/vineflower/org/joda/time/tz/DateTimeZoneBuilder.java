package org.joda.time.tz;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

public class DateTimeZoneBuilder {
   static long a(DataInput var0) throws IOException {
      int var1 = var0.readUnsignedByte();
      long var2;
      switch (var1 >> 6) {
         case 1:
            var2 = (var1 << 26 >> 2 | var0.readUnsignedByte() << 16 | var0.readUnsignedByte() << 8 | var0.readUnsignedByte()) * 60000L;
            break;
         case 2:
            var2 = (
                  (long)var1 << 58 >> 26
                     | var0.readUnsignedByte() << 24
                     | var0.readUnsignedByte() << 16
                     | var0.readUnsignedByte() << 8
                     | var0.readUnsignedByte()
               )
               * 1000L;
            break;
         case 3:
            var2 = var0.readLong();
            break;
         default:
            var2 = (var1 << 26 >> 26) * 1800000L;
      }

      return var2;
   }

   public static DateTimeZone a(DataInput var0, String var1) throws IOException {
      DateTimeZone var2;
      switch (var0.readUnsignedByte()) {
         case 67:
            var2 = CachedDateTimeZone.a(DateTimeZoneBuilder.PrecalculatedZone.a(var0, var1));
            break;
         case 70:
            FixedDateTimeZone var3 = new FixedDateTimeZone(var1, var0.readUTF(), (int)a(var0), (int)a(var0));
            var2 = var3;
            if (var3.equals(DateTimeZone.a)) {
               var2 = DateTimeZone.a;
            }
            break;
         case 80:
            var2 = DateTimeZoneBuilder.PrecalculatedZone.a(var0, var1);
            break;
         default:
            throw new IOException("Invalid encoding");
      }

      return var2;
   }

   public static DateTimeZone a(InputStream var0, String var1) throws IOException {
      DateTimeZone var2;
      if (var0 instanceof DataInput) {
         var2 = a((DataInput)var0, var1);
      } else {
         var2 = a(new DataInputStream(var0), var1);
      }

      return var2;
   }

   private static final class DSTZone extends DateTimeZone {
      final int b;
      final DateTimeZoneBuilder.Recurrence c;
      final DateTimeZoneBuilder.Recurrence d;

      DSTZone(String var1, int var2, DateTimeZoneBuilder.Recurrence var3, DateTimeZoneBuilder.Recurrence var4) {
         super(var1);
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      static DateTimeZoneBuilder.DSTZone a(DataInput var0, String var1) throws IOException {
         return new DateTimeZoneBuilder.DSTZone(
            var1, (int)DateTimeZoneBuilder.a(var0), DateTimeZoneBuilder.Recurrence.a(var0), DateTimeZoneBuilder.Recurrence.a(var0)
         );
      }

      private DateTimeZoneBuilder.Recurrence i(long var1) {
         int var3 = this.b;
         DateTimeZoneBuilder.Recurrence var8 = this.c;
         DateTimeZoneBuilder.Recurrence var9 = this.d;

         long var4;
         try {
            var4 = var8.a(var1, var3, var9.b());
         } catch (IllegalArgumentException var11) {
            var4 = var1;
         } catch (ArithmeticException var12) {
            var4 = var1;
         }

         label26: {
            long var6;
            try {
               var6 = var9.a(var1, var3, var8.b());
            } catch (IllegalArgumentException var13) {
               break label26;
            } catch (ArithmeticException var14) {
               break label26;
            }

            var1 = var6;
         }

         if (var4 <= var1) {
            var8 = var9;
         }

         return var8;
      }

      @Override
      public String a(long var1) {
         return this.i(var1).a();
      }

      @Override
      public int b(long var1) {
         return this.b + this.i(var1).b();
      }

      @Override
      public int c(long var1) {
         return this.b;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 instanceof DateTimeZoneBuilder.DSTZone) {
               var1 = var1;
               if (!this.e().equals(var1.e()) || this.b != var1.b || !this.c.equals(var1.c) || !this.d.equals(var1.d)) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public boolean f() {
         return false;
      }

      @Override
      public long g(long var1) {
         int var3 = this.b;
         DateTimeZoneBuilder.Recurrence var9 = this.c;
         DateTimeZoneBuilder.Recurrence var8 = this.d;

         long var4;
         label39: {
            long var6;
            try {
               var6 = var9.a(var1, var3, var8.b());
            } catch (IllegalArgumentException var13) {
               var4 = var1;
               break label39;
            } catch (ArithmeticException var14) {
               var4 = var1;
               break label39;
            }

            var4 = var6;
            if (var1 > 0L) {
               var4 = var6;
               if (var6 < 0L) {
                  var4 = var1;
               }
            }
         }

         label43: {
            long var15;
            try {
               var15 = var8.a(var1, var3, var9.b());
            } catch (IllegalArgumentException var11) {
               break label43;
            } catch (ArithmeticException var12) {
               break label43;
            }

            if (var1 <= 0L || var15 >= 0L) {
               var1 = var15;
            }
         }

         if (var4 <= var1) {
            var1 = var4;
         }

         return var1;
      }

      @Override
      public long h(long var1) {
         var1++;
         int var3 = this.b;
         DateTimeZoneBuilder.Recurrence var9 = this.c;
         DateTimeZoneBuilder.Recurrence var8 = this.d;

         long var4;
         label39: {
            long var6;
            try {
               var6 = var9.b(var1, var3, var8.b());
            } catch (IllegalArgumentException var13) {
               var4 = var1;
               break label39;
            } catch (ArithmeticException var14) {
               var4 = var1;
               break label39;
            }

            var4 = var6;
            if (var1 < 0L) {
               var4 = var6;
               if (var6 > 0L) {
                  var4 = var1;
               }
            }
         }

         label43: {
            long var16;
            try {
               var16 = var8.b(var1, var3, var9.b());
            } catch (IllegalArgumentException var11) {
               break label43;
            } catch (ArithmeticException var12) {
               break label43;
            }

            if (var1 >= 0L || var16 <= 0L) {
               var1 = var16;
            }
         }

         long var17 = var1;
         if (var4 > var1) {
            var17 = var4;
         }

         return var17 - 1L;
      }
   }

   private static final class OfYear {
      final char a;
      final int b;
      final int c;
      final int d;
      final boolean e;
      final int f;

      OfYear(char var1, int var2, int var3, int var4, boolean var5, int var6) {
         if (var1 != 'u' && var1 != 'w' && var1 != 's') {
            throw new IllegalArgumentException("Unknown mode: " + var1);
         }

         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
      }

      private long a(Chronology var1, long var2) {
         long var4;
         try {
            var4 = this.c(var1, var2);
         } catch (IllegalArgumentException var7) {
            if (this.b == 2 && this.c == 29) {
               while (!var1.E().b(var2)) {
                  var2 = var1.E().a(var2, 1);
               }

               return this.c(var1, var2);
            }

            throw var7;
         }

         return var4;
      }

      static DateTimeZoneBuilder.OfYear a(DataInput var0) throws IOException {
         return new DateTimeZoneBuilder.OfYear(
            (char)var0.readUnsignedByte(),
            var0.readUnsignedByte(),
            var0.readByte(),
            var0.readUnsignedByte(),
            var0.readBoolean(),
            (int)DateTimeZoneBuilder.a(var0)
         );
      }

      private long b(Chronology var1, long var2) {
         long var4;
         try {
            var4 = this.c(var1, var2);
         } catch (IllegalArgumentException var7) {
            if (this.b == 2 && this.c == 29) {
               while (!var1.E().b(var2)) {
                  var2 = var1.E().a(var2, -1);
               }

               return this.c(var1, var2);
            }

            throw var7;
         }

         return var4;
      }

      private long c(Chronology var1, long var2) {
         if (this.c >= 0) {
            var2 = var1.u().b(var2, this.c);
         } else {
            var2 = var1.u().b(var2, 1);
            var2 = var1.C().a(var2, 1);
            var2 = var1.u().a(var2, this.c);
         }

         return var2;
      }

      private long d(Chronology var1, long var2) {
         int var4 = var1.t().a(var2);
         int var5 = this.d - var4;
         long var6 = var2;
         if (var5 != 0) {
            if (this.e) {
               var4 = var5;
               if (var5 < 0) {
                  var4 = var5 + 7;
               }
            } else {
               var4 = var5;
               if (var5 > 0) {
                  var4 = var5 - 7;
               }
            }

            var6 = var1.t().a(var2, var4);
         }

         return var6;
      }

      public long a(long var1, int var3, int var4) {
         if (this.a == 'w') {
            var3 += var4;
         } else if (this.a != 's') {
            var3 = 0;
         }

         long var7 = var3 + var1;
         ISOChronology var9 = ISOChronology.N();
         var1 = var9.C().b(var7, this.b);
         var1 = var9.e().b(var1, 0);
         long var5 = this.a(var9, var9.e().a(var1, this.f));
         if (this.d == 0) {
            var1 = var5;
            if (var5 <= var7) {
               var1 = this.a(var9, var9.E().a(var5, 1));
            }
         } else {
            var5 = this.d(var9, var5);
            var1 = var5;
            if (var5 <= var7) {
               var1 = var9.E().a(var5, 1);
               var1 = this.d(var9, this.a(var9, var9.C().b(var1, this.b)));
            }
         }

         return var1 - var3;
      }

      public long b(long var1, int var3, int var4) {
         if (this.a == 'w') {
            var3 += var4;
         } else if (this.a != 's') {
            var3 = 0;
         }

         long var7 = var3 + var1;
         ISOChronology var9 = ISOChronology.N();
         var1 = var9.C().b(var7, this.b);
         var1 = var9.e().b(var1, 0);
         long var5 = this.b(var9, var9.e().a(var1, this.f));
         if (this.d == 0) {
            var1 = var5;
            if (var5 >= var7) {
               var1 = this.b(var9, var9.E().a(var5, -1));
            }
         } else {
            var5 = this.d(var9, var5);
            var1 = var5;
            if (var5 >= var7) {
               var1 = var9.E().a(var5, -1);
               var1 = this.d(var9, this.b(var9, var9.C().b(var1, this.b)));
            }
         }

         return var1 - var3;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 instanceof DateTimeZoneBuilder.OfYear) {
               var1 = var1;
               if (this.a != var1.a || this.b != var1.b || this.c != var1.c || this.d != var1.d || this.e != var1.e || this.f != var1.f) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public String toString() {
         return "[OfYear]\nMode: "
            + this.a
            + '\n'
            + "MonthOfYear: "
            + this.b
            + '\n'
            + "DayOfMonth: "
            + this.c
            + '\n'
            + "DayOfWeek: "
            + this.d
            + '\n'
            + "AdvanceDayOfWeek: "
            + this.e
            + '\n'
            + "MillisOfDay: "
            + this.f
            + '\n';
      }
   }

   private static final class PrecalculatedZone extends DateTimeZone {
      private final long[] b;
      private final int[] c;
      private final int[] d;
      private final String[] e;
      private final DateTimeZoneBuilder.DSTZone f;

      private PrecalculatedZone(String var1, long[] var2, int[] var3, int[] var4, String[] var5, DateTimeZoneBuilder.DSTZone var6) {
         super(var1);
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      static DateTimeZoneBuilder.PrecalculatedZone a(DataInput var0, String var1) throws IOException {
         int var4 = var0.readUnsignedShort();
         String[] var6 = new String[var4];

         for (int var2 = 0; var2 < var4; var2++) {
            var6[var2] = var0.readUTF();
         }

         int var5 = var0.readInt();
         long[] var10 = new long[var5];
         int[] var9 = new int[var5];
         int[] var7 = new int[var5];
         String[] var8 = new String[var5];

         for (int var13 = 0; var13 < var5; var13++) {
            var10[var13] = DateTimeZoneBuilder.a(var0);
            var9[var13] = (int)DateTimeZoneBuilder.a(var0);
            var7[var13] = (int)DateTimeZoneBuilder.a(var0);
            int var3;
            if (var4 < 256) {
               try {
                  var3 = var0.readUnsignedByte();
               } catch (ArrayIndexOutOfBoundsException var11) {
                  throw new IOException("Invalid encoding");
               }
            } else {
               try {
                  var3 = var0.readUnsignedShort();
               } catch (ArrayIndexOutOfBoundsException var12) {
                  throw new IOException("Invalid encoding");
               }
            }

            var8[var13] = var6[var3];
         }

         DateTimeZoneBuilder.DSTZone var14 = null;
         if (var0.readBoolean()) {
            var14 = DateTimeZoneBuilder.DSTZone.a(var0, var1);
         }

         return new DateTimeZoneBuilder.PrecalculatedZone(var1, var10, var9, var7, var8, var14);
      }

      @Override
      public String a(long var1) {
         long[] var4 = this.b;
         int var3 = Arrays.binarySearch(var4, var1);
         String var6;
         if (var3 >= 0) {
            var6 = this.e[var3];
         } else {
            var3 = ~var3;
            if (var3 < var4.length) {
               if (var3 > 0) {
                  var6 = this.e[var3 - 1];
               } else {
                  var6 = "UTC";
               }
            } else if (this.f == null) {
               var6 = this.e[var3 - 1];
            } else {
               var6 = this.f.a(var1);
            }
         }

         return var6;
      }

      @Override
      public int b(long var1) {
         long[] var4 = this.b;
         int var3 = Arrays.binarySearch(var4, var1);
         if (var3 >= 0) {
            var3 = this.c[var3];
         } else {
            var3 = ~var3;
            if (var3 < var4.length) {
               if (var3 > 0) {
                  var3 = this.c[var3 - 1];
               } else {
                  var3 = 0;
               }
            } else if (this.f == null) {
               var3 = this.c[var3 - 1];
            } else {
               var3 = this.f.b(var1);
            }
         }

         return var3;
      }

      @Override
      public int c(long var1) {
         long[] var4 = this.b;
         int var3 = Arrays.binarySearch(var4, var1);
         if (var3 >= 0) {
            var3 = this.d[var3];
         } else {
            var3 = ~var3;
            if (var3 < var4.length) {
               if (var3 > 0) {
                  var3 = this.d[var3 - 1];
               } else {
                  var3 = 0;
               }
            } else if (this.f == null) {
               var3 = this.d[var3 - 1];
            } else {
               var3 = this.f.c(var1);
            }
         }

         return var3;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 instanceof DateTimeZoneBuilder.PrecalculatedZone) {
               var1 = var1;
               if (!this.e().equals(var1.e())
                  || !Arrays.equals(this.b, var1.b)
                  || !Arrays.equals(this.e, var1.e)
                  || !Arrays.equals(this.c, var1.c)
                  || !Arrays.equals(this.d, var1.d)
                  || (this.f == null ? var1.f != null : !this.f.equals(var1.f))) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public boolean f() {
         return false;
      }

      @Override
      public long g(long var1) {
         long[] var8 = this.b;
         int var3 = Arrays.binarySearch(var8, var1);
         if (var3 >= 0) {
            var3++;
         } else {
            var3 = ~var3;
         }

         long var4;
         if (var3 < var8.length) {
            var4 = var8[var3];
         } else {
            var4 = var1;
            if (this.f != null) {
               long var6 = var8[var8.length - 1];
               var4 = var1;
               if (var1 < var6) {
                  var4 = var6;
               }

               var4 = this.f.g(var4);
            }
         }

         return var4;
      }

      @Override
      public long h(long var1) {
         long[] var8 = this.b;
         int var3 = Arrays.binarySearch(var8, var1);
         long var4;
         if (var3 >= 0) {
            var4 = var1;
            if (var1 > Long.MIN_VALUE) {
               var4 = var1 - 1L;
            }
         } else {
            var3 = ~var3;
            if (var3 < var8.length) {
               var4 = var1;
               if (var3 > 0) {
                  long var6 = var8[var3 - 1];
                  var4 = var1;
                  if (var6 > Long.MIN_VALUE) {
                     var4 = var6 - 1L;
                  }
               }
            } else {
               if (this.f != null) {
                  var4 = this.f.h(var1);
                  if (var4 < var1) {
                     return var4;
                  }
               }

               long var10 = var8[var3 - 1];
               var4 = var1;
               if (var10 > Long.MIN_VALUE) {
                  var4 = var10 - 1L;
               }
            }
         }

         return var4;
      }
   }

   private static final class Recurrence {
      final DateTimeZoneBuilder.OfYear a;
      final String b;
      final int c;

      Recurrence(DateTimeZoneBuilder.OfYear var1, String var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      static DateTimeZoneBuilder.Recurrence a(DataInput var0) throws IOException {
         return new DateTimeZoneBuilder.Recurrence(DateTimeZoneBuilder.OfYear.a(var0), var0.readUTF(), (int)DateTimeZoneBuilder.a(var0));
      }

      public long a(long var1, int var3, int var4) {
         return this.a.a(var1, var3, var4);
      }

      public String a() {
         return this.b;
      }

      public int b() {
         return this.c;
      }

      public long b(long var1, int var3, int var4) {
         return this.a.b(var1, var3, var4);
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 instanceof DateTimeZoneBuilder.Recurrence) {
               var1 = var1;
               if (this.c != var1.c || !this.b.equals(var1.b) || !this.a.equals(var1.a)) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public String toString() {
         return this.a + " named " + this.b + " at " + this.c;
      }
   }
}
