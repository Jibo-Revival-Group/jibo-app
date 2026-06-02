package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class DefaultIndenter extends DefaultPrettyPrinter.NopIndenter {
   public static final String a;
   public static final DefaultIndenter b;
   private final char[] d;
   private final int e;
   private final String f;

   static {
      String var0;
      try {
         var0 = System.getProperty("line.separator");
      } catch (Throwable var1) {
         var0 = "\n";
      }

      a = var0;
      b = new DefaultIndenter("  ", a);
   }

   public DefaultIndenter() {
      this("  ", a);
   }

   public DefaultIndenter(String var1, String var2) {
      this.e = var1.length();
      this.d = new char[var1.length() * 16];
      int var4 = 0;
      int var3 = 0;

      while (var4 < 16) {
         var1.getChars(0, var1.length(), this.d, var3);
         var3 += var1.length();
         var4++;
      }

      this.f = var2;
   }

   @Override
   public void a(JsonGenerator var1, int var2) throws IOException {
      var1.c(this.f);
      if (var2 > 0) {
         for (var2 = this.e * var2; var2 > this.d.length; var2 -= this.d.length) {
            var1.a(this.d, 0, this.d.length);
         }

         var1.a(this.d, 0, var2);
      }
   }

   @Override
   public boolean a() {
      return false;
   }
}
