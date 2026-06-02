package org.joda.time.format;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadablePartial;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDateTimeField;

public class DateTimeFormatterBuilder {
   private ArrayList<Object> a = new ArrayList<>();
   private Object b;

   private DateTimeFormatterBuilder a(Object var1) {
      this.b = null;
      this.a.add(var1);
      this.a.add(var1);
      return this;
   }

   private DateTimeFormatterBuilder a(InternalPrinter var1, InternalParser var2) {
      this.b = null;
      this.a.add(var1);
      this.a.add(var2);
      return this;
   }

   static void a(Appendable var0, int var1) throws IOException {
      while (--var1 >= 0) {
         var0.append('�');
      }
   }

   private void a(DateTimePrinter var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("No printer supplied");
      }
   }

   static boolean a(CharSequence var0, int var1, String var2) {
      boolean var6 = false;
      int var4 = var2.length();
      boolean var5;
      if (var0.length() - var1 < var4) {
         var5 = var6;
      } else {
         int var3 = 0;

         while (true) {
            if (var3 >= var4) {
               var5 = true;
               break;
            }

            var5 = var6;
            if (var0.charAt(var1 + var3) != var2.charAt(var3)) {
               break;
            }

            var3++;
         }
      }

      return var5;
   }

   static boolean b(CharSequence var0, int var1, String var2) {
      boolean var8 = false;
      int var6 = var2.length();
      boolean var7;
      if (var0.length() - var1 < var6) {
         var7 = var8;
      } else {
         int var5 = 0;

         while (true) {
            if (var5 >= var6) {
               var7 = true;
               break;
            }

            char var4 = var0.charAt(var1 + var5);
            char var3 = var2.charAt(var5);
            if (var4 != var3) {
               var4 = Character.toUpperCase(var4);
               var3 = Character.toUpperCase(var3);
               if (var4 != var3) {
                  var7 = var8;
                  if (Character.toLowerCase(var4) != Character.toLowerCase(var3)) {
                     break;
                  }
               }
            }

            var5++;
         }
      }

      return var7;
   }

   private boolean b(Object var1) {
      boolean var2;
      if (var1 instanceof InternalPrinter) {
         if (var1 instanceof DateTimeFormatterBuilder.Composite) {
            var2 = ((DateTimeFormatterBuilder.Composite)var1).a();
         } else {
            var2 = true;
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   private void c(DateTimeParser var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("No parser supplied");
      }
   }

   private boolean c(Object var1) {
      boolean var2;
      if (var1 instanceof InternalParser) {
         if (var1 instanceof DateTimeFormatterBuilder.Composite) {
            var2 = ((DateTimeFormatterBuilder.Composite)var1).b();
         } else {
            var2 = true;
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   private Object k() {
      Object var2 = this.b;
      Object var1 = var2;
      if (var2 == null) {
         var1 = var2;
         if (this.a.size() == 2) {
            Object var3 = this.a.get(0);
            Object var4 = this.a.get(1);
            label21:
            if (var3 != null) {
               if (var3 != var4) {
                  var1 = var2;
                  if (var4 != null) {
                     break label21;
                  }
               }

               var1 = var3;
            } else {
               var1 = var4;
            }
         }

         var2 = var1;
         if (var1 == null) {
            var2 = new DateTimeFormatterBuilder.Composite(this.a);
         }

         this.b = var2;
         var1 = var2;
      }

      return var1;
   }

   public DateTimeFormatter a() {
      Object var2 = this.k();
      InternalPrinter var1;
      if (this.b(var2)) {
         var1 = (InternalPrinter)var2;
      } else {
         var1 = null;
      }

      InternalParser var3;
      if (this.c(var2)) {
         var3 = (InternalParser)var2;
      } else {
         var3 = null;
      }

      if (var1 == null && var3 == null) {
         throw new UnsupportedOperationException("Both printing and parsing not supported");
      } else {
         return new DateTimeFormatter(var1, var3);
      }
   }

   public DateTimeFormatterBuilder a(char var1) {
      return this.a(new DateTimeFormatterBuilder.CharacterLiteral(var1));
   }

   public DateTimeFormatterBuilder a(int var1) {
      return this.a(DateTimeFieldType.c(), var1, 2);
   }

   public DateTimeFormatterBuilder a(int var1, int var2) {
      return this.c(DateTimeFieldType.d(), var1, var2);
   }

   public DateTimeFormatterBuilder a(int var1, boolean var2) {
      return this.a(new DateTimeFormatterBuilder.TwoDigitYear(DateTimeFieldType.s(), var1, var2));
   }

   public DateTimeFormatterBuilder a(String var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Literal must not be null");
      }

      DateTimeFormatterBuilder var2 = this;
      switch (var1.length()) {
         case 0:
            break;
         case 1:
            var2 = this.a(new DateTimeFormatterBuilder.CharacterLiteral(var1.charAt(0)));
            break;
         default:
            var2 = this.a(new DateTimeFormatterBuilder.StringLiteral(var1));
      }

      return var2;
   }

   public DateTimeFormatterBuilder a(String var1, String var2, boolean var3, int var4, int var5) {
      return this.a(new DateTimeFormatterBuilder.TimeZoneOffset(var1, var2, var3, var4, var5));
   }

   public DateTimeFormatterBuilder a(String var1, boolean var2, int var3, int var4) {
      return this.a(new DateTimeFormatterBuilder.TimeZoneOffset(var1, var1, var2, var3, var4));
   }

   public DateTimeFormatterBuilder a(Map<String, DateTimeZone> var1) {
      DateTimeFormatterBuilder.TimeZoneName var2 = new DateTimeFormatterBuilder.TimeZoneName(1, var1);
      return this.a(var2, var2);
   }

   public DateTimeFormatterBuilder a(DateTimeFieldType var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Field type must not be null");
      } else {
         return this.a(new DateTimeFormatterBuilder.TextField(var1, false));
      }
   }

   public DateTimeFormatterBuilder a(DateTimeFieldType var1, int var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("Field type must not be null");
      } else if (var2 <= 0) {
         throw new IllegalArgumentException("Illegal number of digits: " + var2);
      } else {
         return this.a(new DateTimeFormatterBuilder.FixedNumber(var1, var2, false));
      }
   }

   public DateTimeFormatterBuilder a(DateTimeFieldType var1, int var2, int var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("Field type must not be null");
      }

      int var4 = var3;
      if (var3 < var2) {
         var4 = var2;
      }

      if (var2 >= 0 && var4 > 0) {
         DateTimeFormatterBuilder var5;
         if (var2 <= 1) {
            var5 = this.a(new DateTimeFormatterBuilder.UnpaddedNumber(var1, var4, false));
         } else {
            var5 = this.a(new DateTimeFormatterBuilder.PaddedNumber(var1, var4, false, var2));
         }

         return var5;
      } else {
         throw new IllegalArgumentException();
      }
   }

   public DateTimeFormatterBuilder a(DateTimeFormatter var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("No formatter supplied");
      } else {
         return this.a(var1.a(), var1.c());
      }
   }

   public DateTimeFormatterBuilder a(DateTimeParser var1) {
      this.c(var1);
      return this.a(null, DateTimeParserInternalParser.a(var1));
   }

   public DateTimeFormatterBuilder a(DateTimePrinter var1, DateTimeParser[] var2) {
      int var3 = 0;
      if (var1 != null) {
         this.a(var1);
      }

      if (var2 == null) {
         throw new IllegalArgumentException("No parsers supplied");
      }

      int var4 = var2.length;
      DateTimeFormatterBuilder var7;
      if (var4 == 1) {
         if (var2[0] == null) {
            throw new IllegalArgumentException("No parser supplied");
         }

         var7 = this.a(DateTimePrinterInternalPrinter.a(var1), DateTimeParserInternalParser.a(var2[0]));
      } else {
         InternalParser[] var6 = new InternalParser[var4];

         while (var3 < var4 - 1) {
            InternalParser var5 = DateTimeParserInternalParser.a(var2[var3]);
            var6[var3] = var5;
            if (var5 == null) {
               throw new IllegalArgumentException("Incomplete parser array");
            }

            var3++;
         }

         var6[var3] = DateTimeParserInternalParser.a(var2[var3]);
         var7 = this.a(DateTimePrinterInternalPrinter.a(var1), new DateTimeFormatterBuilder.MatchingParser(var6));
      }

      return var7;
   }

   public DateTimeFormatterBuilder b(int var1) {
      return this.a(DateTimeFieldType.e(), var1, 2);
   }

   public DateTimeFormatterBuilder b(int var1, int var2) {
      return this.c(DateTimeFieldType.f(), var1, var2);
   }

   public DateTimeFormatterBuilder b(int var1, boolean var2) {
      return this.a(new DateTimeFormatterBuilder.TwoDigitYear(DateTimeFieldType.p(), var1, var2));
   }

   public DateTimeFormatterBuilder b(DateTimeFieldType var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Field type must not be null");
      } else {
         return this.a(new DateTimeFormatterBuilder.TextField(var1, true));
      }
   }

   public DateTimeFormatterBuilder b(DateTimeFieldType var1, int var2, int var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("Field type must not be null");
      }

      int var4 = var3;
      if (var3 < var2) {
         var4 = var2;
      }

      if (var2 >= 0 && var4 > 0) {
         DateTimeFormatterBuilder var5;
         if (var2 <= 1) {
            var5 = this.a(new DateTimeFormatterBuilder.UnpaddedNumber(var1, var4, true));
         } else {
            var5 = this.a(new DateTimeFormatterBuilder.PaddedNumber(var1, var4, true, var2));
         }

         return var5;
      } else {
         throw new IllegalArgumentException();
      }
   }

   public DateTimeFormatterBuilder b(DateTimeParser var1) {
      this.c(var1);
      return this.a(null, new DateTimeFormatterBuilder.MatchingParser(new InternalParser[]{DateTimeParserInternalParser.a(var1), null}));
   }

   public DateTimeParser b() {
      Object var1 = this.k();
      if (this.c(var1)) {
         return InternalParserDateTimeParser.a((InternalParser)var1);
      } else {
         throw new UnsupportedOperationException("Parsing is not supported");
      }
   }

   public DateTimeFormatterBuilder c() {
      return this.a(DateTimeFieldType.k());
   }

   public DateTimeFormatterBuilder c(int var1) {
      return this.a(DateTimeFieldType.g(), var1, 2);
   }

   public DateTimeFormatterBuilder c(int var1, int var2) {
      return this.c(DateTimeFieldType.g(), var1, var2);
   }

   public DateTimeFormatterBuilder c(DateTimeFieldType var1, int var2, int var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("Field type must not be null");
      }

      int var4 = var3;
      if (var3 < var2) {
         var4 = var2;
      }

      if (var2 >= 0 && var4 > 0) {
         return this.a(new DateTimeFormatterBuilder.Fraction(var1, var2, var4));
      } else {
         throw new IllegalArgumentException();
      }
   }

   public DateTimeFormatterBuilder d() {
      return this.a(DateTimeFieldType.l());
   }

   public DateTimeFormatterBuilder d(int var1) {
      return this.a(DateTimeFieldType.h(), var1, 2);
   }

   public DateTimeFormatterBuilder d(int var1, int var2) {
      return this.b(DateTimeFieldType.p(), var1, var2);
   }

   public DateTimeFormatterBuilder e() {
      return this.b(DateTimeFieldType.l());
   }

   public DateTimeFormatterBuilder e(int var1) {
      return this.a(DateTimeFieldType.i(), var1, 2);
   }

   public DateTimeFormatterBuilder e(int var1, int var2) {
      return this.b(DateTimeFieldType.s(), var1, var2);
   }

   public DateTimeFormatterBuilder f() {
      return this.a(DateTimeFieldType.r());
   }

   public DateTimeFormatterBuilder f(int var1) {
      return this.a(DateTimeFieldType.j(), var1, 2);
   }

   public DateTimeFormatterBuilder f(int var1, int var2) {
      return this.a(DateTimeFieldType.t(), var1, var2);
   }

   public DateTimeFormatterBuilder g() {
      return this.b(DateTimeFieldType.r());
   }

   public DateTimeFormatterBuilder g(int var1) {
      return this.a(DateTimeFieldType.l(), var1, 1);
   }

   public DateTimeFormatterBuilder g(int var1, int var2) {
      return this.b(DateTimeFieldType.v(), var1, var2);
   }

   public DateTimeFormatterBuilder h() {
      return this.a(DateTimeFieldType.w());
   }

   public DateTimeFormatterBuilder h(int var1) {
      return this.a(DateTimeFieldType.m(), var1, 2);
   }

   public DateTimeFormatterBuilder i() {
      return this.a(new DateTimeFormatterBuilder.TimeZoneName(0, null), null);
   }

   public DateTimeFormatterBuilder i(int var1) {
      return this.a(DateTimeFieldType.n(), var1, 3);
   }

   public DateTimeFormatterBuilder j() {
      return this.a(DateTimeFormatterBuilder.TimeZoneId.INSTANCE, DateTimeFormatterBuilder.TimeZoneId.INSTANCE);
   }

   public DateTimeFormatterBuilder j(int var1) {
      return this.a(DateTimeFieldType.o(), var1, 2);
   }

   public DateTimeFormatterBuilder k(int var1) {
      return this.a(DateTimeFieldType.r(), var1, 2);
   }

   static class CharacterLiteral implements InternalParser, InternalPrinter {
      private final char a;

      CharacterLiteral(char var1) {
         this.a = var1;
      }

      @Override
      public int estimateParsedLength() {
         return 1;
      }

      @Override
      public int estimatePrintedLength() {
         return 1;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         if (var3 >= var2.length()) {
            var3 = ~var3;
         } else {
            char var5 = var2.charAt(var3);
            char var4 = this.a;
            if (var5 != var4) {
               var5 = Character.toUpperCase(var5);
               var4 = Character.toUpperCase(var4);
               if (var5 != var4 && Character.toLowerCase(var5) != Character.toLowerCase(var4)) {
                  var3 = ~var3;
                  return var3;
               }
            }

            var3++;
         }

         return var3;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         var1.append(this.a);
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
         var1.append(this.a);
      }
   }

   static class Composite implements InternalParser, InternalPrinter {
      private final InternalPrinter[] a;
      private final InternalParser[] b;
      private final int c;
      private final int d;

      Composite(List<Object> var1) {
         byte var4 = 0;
         super();
         ArrayList var7 = new ArrayList();
         ArrayList var6 = new ArrayList();
         this.a(var1, var7, var6);
         if (!var7.contains(null) && !var7.isEmpty()) {
            int var5 = var7.size();
            this.a = new InternalPrinter[var5];
            int var2 = 0;
            int var3 = 0;

            while (var2 < var5) {
               InternalPrinter var8 = (InternalPrinter)var7.get(var2);
               var3 += var8.estimatePrintedLength();
               this.a[var2] = var8;
               var2++;
            }

            this.c = var3;
         } else {
            this.a = null;
            this.c = 0;
         }

         if (!var6.contains(null) && !var6.isEmpty()) {
            int var12 = var6.size();
            this.b = new InternalParser[var12];
            int var10 = 0;

            for (int var11 = var4; var11 < var12; var11++) {
               InternalParser var9 = (InternalParser)var6.get(var11);
               var10 += var9.estimateParsedLength();
               this.b[var11] = var9;
            }

            this.d = var10;
         } else {
            this.b = null;
            this.d = 0;
         }
      }

      private void a(List<Object> var1, List<Object> var2, List<Object> var3) {
         int var5 = var1.size();

         for (byte var4 = 0; var4 < var5; var4 += 2) {
            Object var6 = var1.get(var4);
            if (var6 instanceof DateTimeFormatterBuilder.Composite) {
               this.a(var2, ((DateTimeFormatterBuilder.Composite)var6).a);
            } else {
               var2.add(var6);
            }

            var6 = var1.get(var4 + 1);
            if (var6 instanceof DateTimeFormatterBuilder.Composite) {
               this.a(var3, ((DateTimeFormatterBuilder.Composite)var6).b);
            } else {
               var3.add(var6);
            }
         }
      }

      private void a(List<Object> var1, Object[] var2) {
         if (var2 != null) {
            for (int var3 = 0; var3 < var2.length; var3++) {
               var1.add(var2[var3]);
            }
         }
      }

      boolean a() {
         boolean var1;
         if (this.a != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      boolean b() {
         boolean var1;
         if (this.b != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public int estimateParsedLength() {
         return this.d;
      }

      @Override
      public int estimatePrintedLength() {
         return this.c;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         InternalParser[] var6 = this.b;
         if (var6 == null) {
            throw new UnsupportedOperationException();
         }

         int var5 = var6.length;

         for (int var4 = 0; var4 < var5 && var3 >= 0; var4++) {
            var3 = var6[var4].parseInto(var1, var2, var3);
         }

         return var3;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         InternalPrinter[] var10 = this.a;
         if (var10 == null) {
            throw new UnsupportedOperationException();
         }

         if (var7 == null) {
            var7 = Locale.getDefault();
         }

         int var9 = var10.length;

         for (int var8 = 0; var8 < var9; var8++) {
            var10[var8].printTo(var1, var2, var4, var5, var6, var7);
         }
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
         InternalPrinter[] var7 = this.a;
         if (var7 == null) {
            throw new UnsupportedOperationException();
         }

         Locale var6 = var3;
         if (var3 == null) {
            var6 = Locale.getDefault();
         }

         int var5 = var7.length;

         for (int var4 = 0; var4 < var5; var4++) {
            var7[var4].printTo(var1, var2, var6);
         }
      }
   }

   static class FixedNumber extends DateTimeFormatterBuilder.PaddedNumber {
      protected FixedNumber(DateTimeFieldType var1, int var2, boolean var3) {
         super(var1, var2, var3, var2);
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         int var6 = super.parseInto(var1, var2, var3);
         int var4;
         if (var6 < 0) {
            var4 = var6;
         } else {
            int var7 = this.b + var3;
            var4 = var6;
            if (var6 != var7) {
               int var5;
               var5 = var7;
               label22:
               if (this.c) {
                  char var8 = var2.charAt(var3);
                  if (var8 != '-') {
                     var5 = var7;
                     if (var8 != '+') {
                        break label22;
                     }
                  }

                  var5 = var7 + 1;
               }

               if (var6 > var5) {
                  var4 = ~(var5 + 1);
               } else {
                  var4 = var6;
                  if (var6 < var5) {
                     var4 = ~var6;
                  }
               }
            }
         }

         return var4;
      }
   }

   static class Fraction implements InternalParser, InternalPrinter {
      protected int a;
      protected int b;
      private final DateTimeFieldType c;

      protected Fraction(DateTimeFieldType var1, int var2, int var3) {
         this.c = var1;
         int var4 = var3;
         if (var3 > 18) {
            var4 = 18;
         }

         this.a = var2;
         this.b = var4;
      }

      private long[] a(long var1, DateTimeField var3) {
         long var7 = var3.d().d();
         int var4 = this.b;

         while (true) {
            long var5;
            switch (var4) {
               case 1:
                  var5 = 10L;
                  break;
               case 2:
                  var5 = 100L;
                  break;
               case 3:
                  var5 = 1000L;
                  break;
               case 4:
                  var5 = 10000L;
                  break;
               case 5:
                  var5 = 100000L;
                  break;
               case 6:
                  var5 = 1000000L;
                  break;
               case 7:
                  var5 = 10000000L;
                  break;
               case 8:
                  var5 = 100000000L;
                  break;
               case 9:
                  var5 = 1000000000L;
                  break;
               case 10:
                  var5 = 10000000000L;
                  break;
               case 11:
                  var5 = 100000000000L;
                  break;
               case 12:
                  var5 = 1000000000000L;
                  break;
               case 13:
                  var5 = 10000000000000L;
                  break;
               case 14:
                  var5 = 100000000000000L;
                  break;
               case 15:
                  var5 = 1000000000000000L;
                  break;
               case 16:
                  var5 = 10000000000000000L;
                  break;
               case 17:
                  var5 = 100000000000000000L;
                  break;
               case 18:
                  var5 = 1000000000000000000L;
                  break;
               default:
                  var5 = 1L;
            }

            if (var7 * var5 / var5 == var7) {
               return new long[]{var5 * var1 / var7, var4};
            }

            var4--;
         }
      }

      protected void a(Appendable var1, long var2, Chronology var4) throws IOException {
         DateTimeField var11 = this.c.a(var4);
         int var7 = this.a;

         try {
            var2 = var11.i(var2);
         } catch (RuntimeException var8) {
            DateTimeFormatterBuilder.a(var1, var7);
            return;
         }

         if (var2 == 0L) {
            while (--var7 >= 0) {
               var1.append('0');
            }
         } else {
            long[] var12 = this.a(var2, var11);
            var2 = var12[0];
            int var5 = (int)var12[1];
            String var13;
            if ((2147483647L & var2) == var2) {
               var13 = Integer.toString((int)var2);
            } else {
               var13 = Long.toString(var2);
            }

            int var6;
            for (var6 = var13.length(); var6 < var5; var5--) {
               var1.append('0');
               var7--;
            }

            if (var7 < var5) {
               while (var7 < var5 && var6 > 1 && var13.charAt(var6 - 1) == '0') {
                  var5--;
                  var6--;
               }

               if (var6 < var13.length()) {
                  for (int var14 = 0; var14 < var6; var14++) {
                     var1.append(var13.charAt(var14));
                  }

                  return;
               }
            }

            var1.append(var13);
         }
      }

      @Override
      public int estimateParsedLength() {
         return this.b;
      }

      @Override
      public int estimatePrintedLength() {
         return this.b;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         DateTimeField var11 = this.c.a(var1.a());
         int var5 = Math.min(this.b, var2.length() - var3);
         long var7 = 0L;
         long var9 = var11.d().d() * 10L;
         int var4 = 0;

         while (var4 < var5) {
            char var6 = var2.charAt(var3 + var4);
            if (var6 < '0' || var6 > '9') {
               break;
            }

            var4++;
            var9 /= 10L;
            var7 += (var6 - '0') * var9;
         }

         var7 /= 10L;
         if (var4 == 0) {
            var3 = ~var3;
         } else if (var7 > 2147483647L) {
            var3 = ~var3;
         } else {
            var1.a(new PreciseDateTimeField(DateTimeFieldType.a(), MillisDurationField.a, var11.d()), (int)var7);
            var3 = var4 + var3;
         }

         return var3;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         this.a(var1, var2, var4);
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
         this.a(var1, var2.c().a(var2, 0L), var2.c());
      }
   }

   static class MatchingParser implements InternalParser {
      private final InternalParser[] a;
      private final int b;

      MatchingParser(InternalParser[] var1) {
         this.a = var1;
         int var2 = 0;
         int var3 = var1.length;

         while (--var3 >= 0) {
            InternalParser var5 = var1[var3];
            if (var5 != null) {
               int var4 = var5.estimateParsedLength();
               if (var4 > var2) {
                  var2 = var4;
               }
            }
         }

         this.b = var2;
      }

      @Override
      public int estimateParsedLength() {
         return this.b;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         InternalParser[] var11 = this.a;
         int var8 = var11.length;
         Object var10 = var1.f();
         Object var9 = null;
         int var5 = 0;
         int var6 = var3;
         int var4 = var3;

         while (true) {
            boolean var13;
            if (var5 < var8) {
               InternalParser var12 = var11[var5];
               if (var12 != null) {
                  int var7 = var12.parseInto(var1, var2, var3);
                  if (var7 >= var3) {
                     if (var7 > var4) {
                        if (var7 >= var2.length() || var5 + 1 >= var8 || var11[var5 + 1] == null) {
                           var3 = var7;
                           break;
                        }

                        var9 = var1.f();
                        var4 = var7;
                     }
                  } else if (var7 < 0) {
                     var7 = ~var7;
                     if (var7 > var6) {
                        var6 = var7;
                     }
                  }

                  var1.a(var10);
                  var5++;
                  continue;
               }

               if (var4 <= var3) {
                  break;
               }

               var13 = true;
            } else {
               var13 = false;
            }

            if (var4 > var3 || var4 == var3 && var13) {
               if (var9 != null) {
                  var1.a(var9);
               }

               var3 = var4;
               break;
            }

            var3 = ~var6;
            break;
         }

         return var3;
      }
   }

   abstract static class NumberFormatter implements InternalParser, InternalPrinter {
      protected final DateTimeFieldType a;
      protected final int b;
      protected final boolean c;

      NumberFormatter(DateTimeFieldType var1, int var2, boolean var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public int estimateParsedLength() {
         return this.b;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         int var9 = Math.min(this.b, var2.length() - var3);
         int var6 = 0;
         int var4 = 0;
         int var5 = 0;

         boolean var21;
         while (true) {
            var21 = (boolean)var5;
            boolean var8 = (boolean)var4;
            if (var6 < var9) {
               char var10 = var2.charAt(var3 + var6);
               if (var6 == 0 && (var10 == '-' || var10 == '+') && this.c) {
                  if (var10 == '-') {
                     var4 = 1;
                  } else {
                     var4 = 0;
                  }

                  if (var10 == '+') {
                     var5 = 1;
                  } else {
                     var5 = 0;
                  }

                  var21 = (boolean)var5;
                  var8 = (boolean)var4;
                  if (var6 + 1 < var9) {
                     var10 = var2.charAt(var3 + var6 + 1);
                     var21 = (boolean)var5;
                     var8 = (boolean)var4;
                     if (var10 >= '0') {
                        if (var10 > '9') {
                           var21 = (boolean)var4;
                           break;
                        }

                        var6++;
                        var9 = Math.min(var9 + 1, var2.length() - var3);
                        continue;
                     }
                  }
               } else {
                  var21 = (boolean)var5;
                  var8 = (boolean)var4;
                  if (var10 >= '0') {
                     if (var10 > '9') {
                        var21 = (boolean)var4;
                        break;
                     }

                     var6++;
                     continue;
                  }
               }
            }

            var5 = var21;
            var21 = var8;
            break;
         }

         if (var6 == 0) {
            var3 = ~var3;
         } else {
            if (var6 >= 9) {
               if (var5) {
                  var5 = var3 + var6;
                  var4 = Integer.parseInt(var2.subSequence(var3 + 1, var5).toString());
                  var3 = var5;
               } else {
                  var5 = var3 + var6;
                  var4 = Integer.parseInt(var2.subSequence(var3, var5).toString());
                  var3 = var5;
               }
            } else {
               if (!var21 && !var5) {
                  var4 = var3;
               } else {
                  var4 = var3 + 1;
               }

               try {
                  var18 = var2.charAt(var4);
               } catch (StringIndexOutOfBoundsException var11) {
                  var3 = ~var3;
                  return var3;
               }

               var6 = var3 + var6;
               var5 = var18 - '0';

               for (int var13 = var4 + 1; var13 < var6; var13++) {
                  var5 = var2.charAt(var13) + (var5 << 3) + (var5 << 1) - 48;
               }

               var4 = var5;
               var3 = var6;
               if (var21) {
                  var4 = -var5;
                  var3 = var6;
               }
            }

            var1.a(this.a, var4);
         }

         return var3;
      }
   }

   static class PaddedNumber extends DateTimeFormatterBuilder.NumberFormatter {
      protected final int d;

      protected PaddedNumber(DateTimeFieldType var1, int var2, boolean var3, int var4) {
         super(var1, var2, var3);
         this.d = var4;
      }

      @Override
      public int estimatePrintedLength() {
         return this.b;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         try {
            FormatUtils.a(var1, this.a.a(var4).a(var2), this.d);
         } catch (RuntimeException var8) {
            DateTimeFormatterBuilder.a(var1, this.d);
         }
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
         if (var2.b(this.a)) {
            try {
               FormatUtils.a(var1, var2.a(this.a), this.d);
            } catch (RuntimeException var4) {
               DateTimeFormatterBuilder.a(var1, this.d);
            }
         } else {
            DateTimeFormatterBuilder.a(var1, this.d);
         }
      }
   }

   static class StringLiteral implements InternalParser, InternalPrinter {
      private final String a;

      StringLiteral(String var1) {
         this.a = var1;
      }

      @Override
      public int estimateParsedLength() {
         return this.a.length();
      }

      @Override
      public int estimatePrintedLength() {
         return this.a.length();
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         if (DateTimeFormatterBuilder.b(var2, var3, this.a)) {
            var3 = this.a.length() + var3;
         } else {
            var3 = ~var3;
         }

         return var3;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         var1.append(this.a);
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
         var1.append(this.a);
      }
   }

   static class TextField implements InternalParser, InternalPrinter {
      private static Map<Locale, Map<DateTimeFieldType, Object[]>> a = new ConcurrentHashMap<>();
      private final DateTimeFieldType b;
      private final boolean c;

      TextField(DateTimeFieldType var1, boolean var2) {
         this.b = var1;
         this.c = var2;
      }

      private String a(long var1, Chronology var3, Locale var4) {
         DateTimeField var5 = this.b.a(var3);
         String var6;
         if (this.c) {
            var6 = var5.b(var1, var4);
         } else {
            var6 = var5.a(var1, var4);
         }

         return var6;
      }

      private String a(ReadablePartial var1, Locale var2) {
         String var4;
         if (var1.b(this.b)) {
            DateTimeField var3 = this.b.a(var1.c());
            if (this.c) {
               var4 = var3.b(var1, var2);
            } else {
               var4 = var3.a(var1, var2);
            }
         } else {
            var4 = "�";
         }

         return var4;
      }

      @Override
      public int estimateParsedLength() {
         return this.estimatePrintedLength();
      }

      @Override
      public int estimatePrintedLength() {
         byte var1;
         if (this.c) {
            var1 = 6;
         } else {
            var1 = 20;
         }

         return var1;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         Locale var9 = var1.b();
         Map var7 = a.get(var9);
         if (var7 == null) {
            var7 = new ConcurrentHashMap();
            a.put(var9, var7);
         }

         Object[] var8 = (Object[])var7.get(this.b);
         int var11;
         if (var8 == null) {
            ConcurrentHashMap var14 = new ConcurrentHashMap(32);
            MutableDateTime.Property var10 = new MutableDateTime(0L, DateTimeZone.a).a(this.b);
            var11 = var10.g();
            int var6 = var10.h();
            if (var6 - var11 > 32) {
               return ~var3;
            }

            int var5 = var10.c(var9);

            while (var11 <= var6) {
               var10.a(var11);
               var14.put(var10.b(var9), Boolean.TRUE);
               var14.put(var10.b(var9).toLowerCase(var9), Boolean.TRUE);
               var14.put(var10.b(var9).toUpperCase(var9), Boolean.TRUE);
               var14.put(var10.a(var9), Boolean.TRUE);
               var14.put(var10.a(var9).toLowerCase(var9), Boolean.TRUE);
               var14.put(var10.a(var9).toUpperCase(var9), Boolean.TRUE);
               var11++;
            }

            var11 = var5;
            if ("en".equals(var9.getLanguage())) {
               var11 = var5;
               if (this.b == DateTimeFieldType.w()) {
                  var14.put("BCE", Boolean.TRUE);
                  var14.put("bce", Boolean.TRUE);
                  var14.put("CE", Boolean.TRUE);
                  var14.put("ce", Boolean.TRUE);
                  var11 = 3;
               }
            }

            var7.put(this.b, new Object[]{var14, var11});
            var7 = var14;
         } else {
            var7 = (Map)var8[0];
            var11 = (Integer)var8[1];
         }

         var11 = Math.min(var2.length(), var11 + var3);

         while (true) {
            if (var11 <= var3) {
               var11 = ~var3;
               break;
            }

            String var15 = var2.subSequence(var3, var11).toString();
            if (var7.containsKey(var15)) {
               var1.a(this.b, var15, var9);
               break;
            }

            var11--;
         }

         return var11;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         try {
            var1.append(this.a(var2, var4, var7));
         } catch (RuntimeException var8) {
            var1.append('�');
         }
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
         try {
            var1.append(this.a(var2, var3));
         } catch (RuntimeException var4) {
            var1.append('�');
         }
      }
   }

   enum TimeZoneId implements InternalParser, InternalPrinter {
      INSTANCE;

      private static final DateTimeFormatterBuilder.TimeZoneId[] $VALUES = new DateTimeFormatterBuilder.TimeZoneId[]{
         DateTimeFormatterBuilder.TimeZoneId.INSTANCE
      };
      private static final List<String> ALL_IDS = new ArrayList<>(DateTimeZone.b());
      private static final List<String> BASE_GROUPED_IDS = new ArrayList<>();
      private static final Map<String, List<String>> GROUPED_IDS = new HashMap<>();
      static final int MAX_LENGTH;
      static final int MAX_PREFIX_LENGTH;

      static {
         Collections.sort(ALL_IDS);
         Iterator var4 = ALL_IDS.iterator();
         int var1 = 0;
         int var0 = 0;

         while (var4.hasNext()) {
            String var5 = (String)var4.next();
            int var3 = var5.indexOf(47);
            if (var3 >= 0) {
               int var2 = var3;
               if (var3 < var5.length()) {
                  var2 = var3 + 1;
               }

               var1 = Math.max(var1, var2);
               String var6 = var5.substring(0, var2 + 1);
               String var7 = var5.substring(var2);
               if (!GROUPED_IDS.containsKey(var6)) {
                  GROUPED_IDS.put(var6, new ArrayList<>());
               }

               GROUPED_IDS.get(var6).add(var7);
            } else {
               BASE_GROUPED_IDS.add(var5);
            }

            var0 = Math.max(var0, var5.length());
         }

         MAX_LENGTH = var0;
         MAX_PREFIX_LENGTH = var1;
      }

      @Override
      public int estimateParsedLength() {
         return MAX_LENGTH;
      }

      @Override
      public int estimatePrintedLength() {
         return MAX_LENGTH;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         List var10 = BASE_GROUPED_IDS;
         int var6 = var2.length();
         int var5 = Math.min(var6, MAX_PREFIX_LENGTH + var3);
         String var9 = "";
         int var4 = var3;

         while (true) {
            if (var4 < var5) {
               if (var2.charAt(var4) != '/') {
                  var4++;
                  continue;
               }

               var9 = var2.subSequence(var3, var4 + 1).toString();
               var5 = var3 + var9.length();
               String var7;
               if (var4 < var6) {
                  var7 = var9 + var2.charAt(var4 + 1);
               } else {
                  var7 = var9;
               }

               var10 = GROUPED_IDS.get(var7);
               if (var10 == null) {
                  var3 = ~var3;
                  break;
               }

               var4 = var5;
            } else {
               var4 = var3;
            }

            String var16 = null;
            var5 = 0;

            while (var5 < var10.size()) {
               String var8;
               label35: {
                  String var11 = (String)var10.get(var5);
                  if (DateTimeFormatterBuilder.a(var2, var4, var11)) {
                     var8 = var11;
                     if (var16 == null) {
                        break label35;
                     }

                     if (var11.length() > var16.length()) {
                        var8 = var11;
                        break label35;
                     }
                  }

                  var8 = var16;
               }

               var5++;
               var16 = var8;
            }

            if (var16 != null) {
               var1.a(DateTimeZone.a(var9 + var16));
               var3 = var16.length() + var4;
            } else {
               var3 = ~var3;
            }
            break;
         }

         return var3;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         String var8;
         if (var6 != null) {
            var8 = var6.e();
         } else {
            var8 = "";
         }

         var1.append(var8);
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
      }
   }

   static class TimeZoneName implements InternalParser, InternalPrinter {
      private final Map<String, DateTimeZone> a;
      private final int b;

      TimeZoneName(int var1, Map<String, DateTimeZone> var2) {
         this.b = var1;
         this.a = var2;
      }

      private String a(long var1, DateTimeZone var3, Locale var4) {
         String var5;
         if (var3 == null) {
            var5 = "";
         } else {
            switch (this.b) {
               case 0:
                  var5 = var3.b(var1, var4);
                  break;
               case 1:
                  var5 = var3.a(var1, var4);
                  break;
               default:
                  var5 = "";
            }
         }

         return var5;
      }

      @Override
      public int estimateParsedLength() {
         byte var1;
         if (this.b == 1) {
            var1 = 4;
         } else {
            var1 = 20;
         }

         return var1;
      }

      @Override
      public int estimatePrintedLength() {
         byte var1;
         if (this.b == 1) {
            var1 = 4;
         } else {
            var1 = 20;
         }

         return var1;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         Map var6 = this.a;
         if (var6 == null) {
            var6 = DateTimeUtils.b();
         }

         String var4 = null;

         for (String var7 : var6.keySet()) {
            String var5;
            label29: {
               if (DateTimeFormatterBuilder.a(var2, var3, var7)) {
                  var5 = var7;
                  if (var4 == null) {
                     break label29;
                  }

                  if (var7.length() > var4.length()) {
                     var5 = var7;
                     break label29;
                  }
               }

               var5 = var4;
            }

            var4 = var5;
         }

         if (var4 != null) {
            var1.a((DateTimeZone)var6.get(var4));
            var3 = var4.length() + var3;
         } else {
            var3 = ~var3;
         }

         return var3;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         var1.append(this.a(var2 - var5, var6, var7));
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
      }
   }

   static class TimeZoneOffset implements InternalParser, InternalPrinter {
      private final String a;
      private final String b;
      private final boolean c;
      private final int d;
      private final int e;

      TimeZoneOffset(String var1, String var2, boolean var3, int var4, int var5) {
         byte var6 = 4;
         super();
         this.a = var1;
         this.b = var2;
         this.c = var3;
         if (var4 > 0 && var5 >= var4) {
            if (var4 > 4) {
               var5 = 4;
               var4 = var6;
            }

            this.d = var4;
            this.e = var5;
         } else {
            throw new IllegalArgumentException();
         }
      }

      private int a(CharSequence var1, int var2, int var3) {
         var3 = Math.min(var1.length() - var2, var3);
         int var4 = 0;

         while (var3 > 0) {
            char var5 = var1.charAt(var2 + var4);
            if (var5 < '0' || var5 > '9') {
               break;
            }

            var4++;
            var3--;
         }

         return var4;
      }

      @Override
      public int estimateParsedLength() {
         return this.estimatePrintedLength();
      }

      @Override
      public int estimatePrintedLength() {
         int var2 = this.d + 1 << 1;
         int var1 = var2;
         if (this.c) {
            var1 = var2 + (this.d - 1);
         }

         var2 = var1;
         if (this.a != null) {
            var2 = var1;
            if (this.a.length() > var1) {
               var2 = this.a.length();
            }
         }

         return var2;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         label164: {
            boolean var7 = false;
            int var4 = var2.length() - var3;
            if (this.b != null) {
               if (this.b.length() == 0) {
                  if (var4 <= 0) {
                     break label164;
                  }

                  char var5 = var2.charAt(var3);
                  if (var5 != '-' && var5 != '+') {
                     break label164;
                  }
               } else if (DateTimeFormatterBuilder.b(var2, var3, this.b)) {
                  var1.a(0);
                  var3 += this.b.length();
                  return var3;
               }
            }

            if (var4 <= 1) {
               return ~var3;
            }

            int var18 = var2.charAt(var3);
            boolean var6;
            if (var18 == 45) {
               var6 = true;
            } else {
               if (var18 != 43) {
                  return ~var3;
               }

               var6 = false;
            }

            var18 = var3 + 1;
            if (this.a(var2, var18, 2) < 2) {
               return ~var18;
            }

            var3 = FormatUtils.a(var2, var18);
            if (var3 > 23) {
               var3 = ~var18;
            } else {
               var3 *= 3600000;
               int var8 = var4 - 1 - 2;
               var18 += 2;
               if (var8 <= 0) {
                  var4 = var18;
               } else {
                  label119: {
                     label143: {
                        int var9 = var2.charAt(var18);
                        if (var9 == 58) {
                           var4 = var18 + 1;
                           var8--;
                           var7 = true;
                        } else {
                           if (var9 < 48) {
                              break label143;
                           }

                           var4 = var18;
                           if (var9 > 57) {
                              break label143;
                           }
                        }

                        var18 = this.a(var2, var4, 2);
                        if (var18 == 0 && !var7) {
                           break label119;
                        }

                        if (var18 < 2) {
                           return ~var4;
                        }

                        var18 = FormatUtils.a(var2, var4);
                        if (var18 > 59) {
                           return ~var4;
                        }

                        var18 = var3 + var18 * 60000;
                        var9 = var8 - 2;
                        var4 += 2;
                        if (var9 <= 0) {
                           var3 = var18;
                        } else {
                           var8 = var9;
                           var3 = var4;
                           if (var7) {
                              if (var2.charAt(var4) != ':') {
                                 var3 = var18;
                                 break label119;
                              }

                              var8 = var9 - 1;
                              var3 = var4 + 1;
                           }

                           var4 = this.a(var2, var3, 2);
                           if (var4 == 0 && !var7) {
                              var4 = var3;
                              var3 = var18;
                           } else {
                              if (var4 < 2) {
                                 return ~var3;
                              }

                              var4 = FormatUtils.a(var2, var3);
                              if (var4 > 59) {
                                 return ~var3;
                              }

                              var4 = var18 + var4 * 1000;
                              var8 -= 2;
                              var18 = var3 + 2;
                              if (var8 <= 0) {
                                 var3 = var4;
                                 var4 = var18;
                              } else {
                                 var3 = var18;
                                 if (var7) {
                                    if (var2.charAt(var18) != '.' && var2.charAt(var18) != ',') {
                                       var3 = var4;
                                       var4 = var18;
                                       break label119;
                                    }

                                    var3 = var18 + 1;
                                 }

                                 var8 = this.a(var2, var3, 3);
                                 if (var8 == 0 && !var7) {
                                    var18 = var3;
                                    var3 = var4;
                                    var4 = var18;
                                 } else {
                                    if (var8 < 1) {
                                       return ~var3;
                                    }

                                    var18 = var3 + 1;
                                    var3 = (var2.charAt(var3) - '0') * 100 + var4;
                                    if (var8 > 1) {
                                       var4 = var18 + 1;
                                       var3 += (var2.charAt(var18) - '0') * 10;
                                       if (var8 > 2) {
                                          var3 += var2.charAt(var4) - '0';
                                          var4++;
                                       }
                                    } else {
                                       var4 = var18;
                                    }
                                 }
                              }
                           }
                        }
                        break label119;
                     }

                     var4 = var18;
                  }
               }

               if (var6) {
                  var3 = -var3;
               }

               var1.a(var3);
               var3 = var4;
            }

            return var3;
         }

         var1.a(0);
         return var3;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         if (var6 != null) {
            if (var5 == 0 && this.a != null) {
               var1.append(this.a);
            } else {
               if (var5 >= 0) {
                  var1.append('+');
               } else {
                  var1.append('-');
                  var5 = -var5;
               }

               int var8 = var5 / 3600000;
               FormatUtils.a(var1, var8, 2);
               if (this.e != 1) {
                  var5 -= var8 * 3600000;
                  if (var5 != 0 || this.d > 1) {
                     var8 = var5 / 60000;
                     if (this.c) {
                        var1.append(':');
                     }

                     FormatUtils.a(var1, var8, 2);
                     if (this.e != 2) {
                        var5 -= var8 * 60000;
                        if (var5 != 0 || this.d > 2) {
                           var8 = var5 / 1000;
                           if (this.c) {
                              var1.append(':');
                           }

                           FormatUtils.a(var1, var8, 2);
                           if (this.e != 3) {
                              var5 -= var8 * 1000;
                              if (var5 != 0 || this.d > 3) {
                                 if (this.c) {
                                    var1.append('.');
                                 }

                                 FormatUtils.a(var1, var5, 3);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
      }
   }

   static class TwoDigitYear implements InternalParser, InternalPrinter {
      private final DateTimeFieldType a;
      private final int b;
      private final boolean c;

      TwoDigitYear(DateTimeFieldType var1, int var2, boolean var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      private int a(long var1, Chronology var3) {
         int var5;
         try {
            var5 = this.a.a(var3).a(var1);
         } catch (RuntimeException var6) {
            return -1;
         }

         int var7 = var5;
         if (var5 < 0) {
            var7 = -var5;
         }

         return var7 % 100;
      }

      private int a(ReadablePartial var1) {
         if (var1.b(this.a)) {
            int var3;
            try {
               var3 = var1.a(this.a);
            } catch (RuntimeException var4) {
               return -1;
            }

            int var5 = var3;
            if (var3 < 0) {
               var5 = -var3;
            }

            return var5 % 100;
         } else {
            return -1;
         }
      }

      @Override
      public int estimateParsedLength() {
         byte var1;
         if (this.c) {
            var1 = 4;
         } else {
            var1 = 2;
         }

         return var1;
      }

      @Override
      public int estimatePrintedLength() {
         return 2;
      }

      @Override
      public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
         byte var8 = 0;
         int var7 = var2.length() - var3;
         int var22;
         if (!this.c) {
            var22 = var3;
            if (Math.min(2, var7) < 2) {
               var3 = ~var3;
               return var3;
            }
         } else {
            label136: {
               int var5 = 0;
               boolean var4 = false;
               int var6 = 0;

               while (var5 < var7) {
                  char var9 = var2.charAt(var3 + var5);
                  if (var5 != 0 || var9 != '-' && var9 != '+') {
                     if (var9 < '0' || var9 > '9') {
                        break;
                     }

                     var5++;
                  } else {
                     if (var9 == '-') {
                        var4 = true;
                     } else {
                        var4 = false;
                     }

                     if (var4) {
                        var5++;
                        var6 = 1;
                     } else {
                        var3++;
                        var6 = 1;
                        var7--;
                     }
                  }
               }

               if (var5 == 0) {
                  return ~var3;
               }

               if (!var6) {
                  var22 = var3;
                  if (var5 == 2) {
                     break label136;
                  }
               }

               if (var5 >= 9) {
                  var5 = var3 + var5;
                  var6 = Integer.parseInt(var2.subSequence(var3, var5).toString());
               } else {
                  if (var4) {
                     var6 = var3 + 1;
                  } else {
                     var6 = var3;
                  }

                  try {
                     var27 = var2.charAt(var6);
                  } catch (StringIndexOutOfBoundsException var10) {
                     return ~var3;
                  }

                  var7 = var3 + var5;
                  var3 = var27 - '0';

                  for (int var20 = var6 + 1; var20 < var7; var20++) {
                     var3 = var2.charAt(var20) + (var3 << 3) + (var3 << 1) - 48;
                  }

                  var6 = var3;
                  var5 = var7;
                  if (var4) {
                     var6 = -var3;
                     var5 = var7;
                  }
               }

               var1.a(this.a, var6);
               return var5;
            }
         }

         int var13 = var2.charAt(var22);
         if (var13 >= 48 && var13 <= 57) {
            var13 -= 48;
            char var17 = var2.charAt(var22 + 1);
            if (var17 >= '0' && var17 <= '9') {
               int var21 = (var13 << 1) + (var13 << 3) + var17 - 48;
               var13 = this.b;
               if (var1.e() != null) {
                  var13 = var1.e();
               }

               var7 = var13 - 50;
               if (var7 >= 0) {
                  var13 = var7 % 100;
               } else {
                  var13 = (var7 + 1) % 100 + 99;
               }

               byte var18 = var8;
               if (var21 < var13) {
                  var18 = 100;
               }

               var1.a(this.a, var18 + var7 - var13 + var21);
               var13 = var22 + 2;
            } else {
               var13 = ~var22;
            }
         } else {
            var13 = ~var22;
         }

         return var13;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         var5 = this.a(var2, var4);
         if (var5 < 0) {
            var1.append('�');
            var1.append('�');
         } else {
            FormatUtils.a(var1, var5, 2);
         }
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
         int var4 = this.a(var2);
         if (var4 < 0) {
            var1.append('�');
            var1.append('�');
         } else {
            FormatUtils.a(var1, var4, 2);
         }
      }
   }

   static class UnpaddedNumber extends DateTimeFormatterBuilder.NumberFormatter {
      protected UnpaddedNumber(DateTimeFieldType var1, int var2, boolean var3) {
         super(var1, var2, var3);
      }

      @Override
      public int estimatePrintedLength() {
         return this.b;
      }

      @Override
      public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
         try {
            FormatUtils.a(var1, this.a.a(var4).a(var2));
         } catch (RuntimeException var8) {
            var1.append('�');
         }
      }

      @Override
      public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
         if (var2.b(this.a)) {
            try {
               FormatUtils.a(var1, var2.a(this.a));
            } catch (RuntimeException var4) {
               var1.append('�');
            }
         } else {
            var1.append('�');
         }
      }
   }
}
