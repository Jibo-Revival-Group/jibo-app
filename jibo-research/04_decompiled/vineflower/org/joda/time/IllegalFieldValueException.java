package org.joda.time;

public class IllegalFieldValueException extends IllegalArgumentException {
   private final DateTimeFieldType a;
   private final DurationFieldType b;
   private final String c;
   private final Number d;
   private final String e;
   private final Number f;
   private final Number g;
   private String h;

   public IllegalFieldValueException(DateTimeFieldType var1, Number var2, Number var3, Number var4) {
      super(a(var1.x(), var2, var3, var4, null));
      this.a = var1;
      this.b = null;
      this.c = var1.x();
      this.d = var2;
      this.e = null;
      this.f = var3;
      this.g = var4;
      this.h = super.getMessage();
   }

   public IllegalFieldValueException(DateTimeFieldType var1, Number var2, String var3) {
      super(a(var1.x(), var2, null, null, var3));
      this.a = var1;
      this.b = null;
      this.c = var1.x();
      this.d = var2;
      this.e = null;
      this.f = null;
      this.g = null;
      this.h = super.getMessage();
   }

   public IllegalFieldValueException(DateTimeFieldType var1, String var2) {
      super(a(var1.x(), var2));
      this.a = var1;
      this.b = null;
      this.c = var1.x();
      this.e = var2;
      this.d = null;
      this.f = null;
      this.g = null;
      this.h = super.getMessage();
   }

   private static String a(String var0, Number var1, Number var2, Number var3, String var4) {
      StringBuilder var5 = new StringBuilder().append("Value ").append(var1).append(" for ").append(var0).append(' ');
      if (var2 == null) {
         if (var3 == null) {
            var5.append("is not supported");
         } else {
            var5.append("must not be larger than ").append(var3);
         }
      } else if (var3 == null) {
         var5.append("must not be smaller than ").append(var2);
      } else {
         var5.append("must be in the range [").append(var2).append(',').append(var3).append(']');
      }

      if (var4 != null) {
         var5.append(": ").append(var4);
      }

      return var5.toString();
   }

   private static String a(String var0, String var1) {
      StringBuffer var2 = new StringBuffer().append("Value ");
      if (var1 == null) {
         var2.append("null");
      } else {
         var2.append('"');
         var2.append(var1);
         var2.append('"');
      }

      var2.append(" for ").append(var0).append(' ').append("is not supported");
      return var2.toString();
   }

   public void a(String var1) {
      if (this.h == null) {
         this.h = var1;
      } else if (var1 != null) {
         this.h = var1 + ": " + this.h;
      }
   }

   @Override
   public String getMessage() {
      return this.h;
   }
}
