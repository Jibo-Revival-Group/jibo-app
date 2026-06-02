package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;

public class DateTimeFormatter {
   private final InternalPrinter a;
   private final InternalParser b;
   private final Locale c;
   private final boolean d;
   private final Chronology e;
   private final DateTimeZone f;
   private final Integer g;
   private final int h;

   DateTimeFormatter(InternalPrinter var1, InternalParser var2) {
      this.a = var1;
      this.b = var2;
      this.c = null;
      this.d = false;
      this.e = null;
      this.f = null;
      this.g = null;
      this.h = 2000;
   }

   private DateTimeFormatter(InternalPrinter var1, InternalParser var2, Locale var3, boolean var4, Chronology var5, DateTimeZone var6, Integer var7, int var8) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
   }

   private void a(Appendable var1, long var2, Chronology var4) throws IOException {
      InternalPrinter var12 = this.e();
      Chronology var13 = this.b(var4);
      DateTimeZone var11 = var13.a();
      int var6 = var11.b(var2);
      long var9 = var6 + var2;
      long var7 = var9;
      int var5 = var6;
      DateTimeZone var14 = var11;
      if ((var2 ^ var9) < 0L) {
         var7 = var9;
         var5 = var6;
         var14 = var11;
         if ((var6 ^ var2) >= 0L) {
            var14 = DateTimeZone.a;
            var5 = 0;
            var7 = var2;
         }
      }

      var12.printTo(var1, var7, var13.b(), var5, var14, this.c);
   }

   private Chronology b(Chronology var1) {
      var1 = DateTimeUtils.a(var1);
      if (this.e != null) {
         var1 = this.e;
      }

      Chronology var2 = var1;
      if (this.f != null) {
         var2 = var1.a(this.f);
      }

      return var2;
   }

   private InternalPrinter e() {
      InternalPrinter var1 = this.a;
      if (var1 == null) {
         throw new UnsupportedOperationException("Printing not supported");
      } else {
         return var1;
      }
   }

   private InternalParser f() {
      InternalParser var1 = this.b;
      if (var1 == null) {
         throw new UnsupportedOperationException("Parsing not supported");
      } else {
         return var1;
      }
   }

   public long a(String var1) {
      InternalParser var2 = this.f();
      return new DateTimeParserBucket(0L, this.b(this.e), this.c, this.g, this.h).a(var2, var1);
   }

   public String a(ReadableInstant var1) {
      StringBuilder var2 = new StringBuilder(this.e().estimatePrintedLength());

      try {
         this.a(var2, var1);
      } catch (IOException var3) {
      }

      return var2.toString();
   }

   public String a(ReadablePartial var1) {
      StringBuilder var2 = new StringBuilder(this.e().estimatePrintedLength());

      try {
         this.a(var2, var1);
      } catch (IOException var3) {
      }

      return var2.toString();
   }

   public DateTimeFormatter a(Chronology var1) {
      DateTimeFormatter var2;
      if (this.e == var1) {
         var2 = this;
      } else {
         var2 = new DateTimeFormatter(this.a, this.b, this.c, this.d, var1, this.f, this.g, this.h);
      }

      return var2;
   }

   public DateTimeFormatter a(DateTimeZone var1) {
      DateTimeFormatter var2;
      if (this.f == var1) {
         var2 = this;
      } else {
         var2 = new DateTimeFormatter(this.a, this.b, this.c, false, this.e, var1, this.g, this.h);
      }

      return var2;
   }

   InternalPrinter a() {
      return this.a;
   }

   public void a(Appendable var1, long var2) throws IOException {
      this.a(var1, var2, null);
   }

   public void a(Appendable var1, ReadableInstant var2) throws IOException {
      this.a(var1, DateTimeUtils.a(var2), DateTimeUtils.b(var2));
   }

   public void a(Appendable var1, ReadablePartial var2) throws IOException {
      InternalPrinter var3 = this.e();
      if (var2 == null) {
         throw new IllegalArgumentException("The partial must not be null");
      }

      var3.printTo(var1, var2, this.c);
   }

   public void a(StringBuffer var1, long var2) {
      try {
         this.a((Appendable)var1, var2);
      } catch (IOException var4) {
      }
   }

   public LocalTime b(String var1) {
      return this.c(var1).d();
   }

   public DateTimeParser b() {
      return InternalParserDateTimeParser.a(this.b);
   }

   public LocalDateTime c(String var1) {
      InternalParser var8 = this.f();
      Chronology var6 = this.b((Chronology)null).b();
      DateTimeParserBucket var7 = new DateTimeParserBucket(0L, var6, this.c, this.g, this.h);
      int var3 = var8.parseInto(var7, var1, 0);
      int var2;
      if (var3 >= 0) {
         var2 = var3;
         if (var3 >= var1.length()) {
            long var4 = var7.a(true, var1);
            Chronology var9;
            if (var7.d() != null) {
               var9 = var6.a(DateTimeZone.a(var7.d()));
            } else {
               var9 = var6;
               if (var7.c() != null) {
                  var9 = var6.a(var7.c());
               }
            }

            return new LocalDateTime(var4, var9);
         }
      } else {
         var2 = ~var3;
      }

      throw new IllegalArgumentException(FormatUtils.a(var1, var2));
   }

   InternalParser c() {
      return this.b;
   }

   public DateTimeFormatter d() {
      return this.a(DateTimeZone.a);
   }
}
