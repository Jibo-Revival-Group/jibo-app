package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

class DateTimePrinterInternalPrinter implements InternalPrinter {
   private final DateTimePrinter a;

   private DateTimePrinterInternalPrinter(DateTimePrinter var1) {
      this.a = var1;
   }

   static InternalPrinter a(DateTimePrinter var0) {
      InternalPrinter var1;
      if (var0 instanceof InternalPrinterDateTimePrinter) {
         var1 = (InternalPrinter)var0;
      } else if (var0 == null) {
         var1 = null;
      } else {
         var1 = new DateTimePrinterInternalPrinter(var0);
      }

      return var1;
   }

   @Override
   public int estimatePrintedLength() {
      return this.a.estimatePrintedLength();
   }

   @Override
   public void printTo(Appendable var1, long var2, Chronology var4, int var5, DateTimeZone var6, Locale var7) throws IOException {
      if (var1 instanceof StringBuffer) {
         var1 = var1;
         this.a.a(var1, var2, var4, var5, var6, var7);
      } else if (var1 instanceof Writer) {
         Writer var10 = (Writer)var1;
         this.a.a(var10, var2, var4, var5, var6, var7);
      } else {
         StringBuffer var8 = new StringBuffer(this.estimatePrintedLength());
         this.a.a(var8, var2, var4, var5, var6, var7);
         var1.append(var8);
      }
   }

   @Override
   public void printTo(Appendable var1, ReadablePartial var2, Locale var3) throws IOException {
      if (var1 instanceof StringBuffer) {
         var1 = var1;
         this.a.a(var1, var2, var3);
      } else if (var1 instanceof Writer) {
         Writer var6 = (Writer)var1;
         this.a.a(var6, var2, var3);
      } else {
         StringBuffer var4 = new StringBuffer(this.estimatePrintedLength());
         this.a.a(var4, var2, var3);
         var1.append(var4);
      }
   }
}
