package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

class InternalPrinterDateTimePrinter implements DateTimePrinter, InternalPrinter {
   private final InternalPrinter a;

   @Override
   public void a(Writer var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
      this.a.printTo(var1, var2, var4, var5, var6, var7);
   }

   @Override
   public void a(Writer var1, ReadablePartial var2, Locale var3) throws IOException {
      this.a.printTo(var1, var2, var3);
   }

   @Override
   public void a(StringBuffer var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) {
      try {
         this.a.printTo(var1, var2, var4, var5, var6, var7);
      } catch (IOException var8) {
      }
   }

   @Override
   public void a(StringBuffer var1, ReadablePartial var2, Locale var3) {
      try {
         this.a.printTo(var1, var2, var3);
      } catch (IOException var4) {
      }
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 == this) {
         var2 = true;
      } else if (var1 instanceof InternalPrinterDateTimePrinter) {
         var1 = var1;
         var2 = this.a.equals(var1.a);
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int estimatePrintedLength() {
      return this.a.estimatePrintedLength();
   }

   @Override
   public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
      this.a.printTo(var1, var2, var4, var5, var6, var7);
   }

   @Override
   public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
      this.a.printTo(var1, var2, var3);
   }
}
