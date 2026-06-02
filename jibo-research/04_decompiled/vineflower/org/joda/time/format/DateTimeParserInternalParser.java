package org.joda.time.format;

class DateTimeParserInternalParser implements InternalParser {
   private final DateTimeParser a;

   private DateTimeParserInternalParser(DateTimeParser var1) {
      this.a = var1;
   }

   static InternalParser a(DateTimeParser var0) {
      InternalParser var1;
      if (var0 instanceof InternalParserDateTimeParser) {
         var1 = (InternalParser)var0;
      } else if (var0 == null) {
         var1 = null;
      } else {
         var1 = new DateTimeParserInternalParser(var0);
      }

      return var1;
   }

   DateTimeParser a() {
      return this.a;
   }

   @Override
   public int estimateParsedLength() {
      return this.a.estimateParsedLength();
   }

   @Override
   public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
      return this.a.a(var1, var2.toString(), var3);
   }
}
