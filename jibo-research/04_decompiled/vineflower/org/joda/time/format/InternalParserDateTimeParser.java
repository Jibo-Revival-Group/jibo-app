package org.joda.time.format;

class InternalParserDateTimeParser implements DateTimeParser, InternalParser {
   private final InternalParser a;

   private InternalParserDateTimeParser(InternalParser var1) {
      this.a = var1;
   }

   static DateTimeParser a(InternalParser var0) {
      DateTimeParser var1;
      if (var0 instanceof DateTimeParserInternalParser) {
         var1 = ((DateTimeParserInternalParser)var0).a();
      } else if (var0 instanceof DateTimeParser) {
         var1 = (DateTimeParser)var0;
      } else if (var0 == null) {
         var1 = null;
      } else {
         var1 = new InternalParserDateTimeParser(var0);
      }

      return var1;
   }

   @Override
   public int a(DateTimeParserBucket var1, String var2, int var3) {
      return this.a.parseInto(var1, var2, var3);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 == this) {
         var2 = true;
      } else if (var1 instanceof InternalParserDateTimeParser) {
         var1 = var1;
         var2 = this.a.equals(var1.a);
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int estimateParsedLength() {
      return this.a.estimateParsedLength();
   }

   @Override
   public int parseInto(DateTimeParserBucket var1, CharSequence var2, int var3) {
      return this.a.parseInto(var1, var2, var3);
   }
}
