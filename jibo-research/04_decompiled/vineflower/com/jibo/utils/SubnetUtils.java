package com.jibo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubnetUtils {
   private static final Pattern a = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
   private static final Pattern b = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,3})");
   private int c = 0;
   private int d = 0;
   private int e = 0;
   private int f = 0;

   public SubnetUtils(String var1, String var2) {
      this.a(this.a(var1, var2));
   }

   private int a(int var1, int var2, int var3) {
      if (var1 >= var2 && var1 <= var3) {
         return var1;
      } else {
         throw new IllegalArgumentException("Value out of range: [" + var1 + "]");
      }
   }

   private int a(Matcher var1) {
      int var3 = 1;
      int var2 = 0;

      while (var3 <= 4) {
         var2 |= (this.a(Integer.parseInt(var1.group(var3)), 0, 255) & 0xFF) << (4 - var3) * 8;
         var3++;
      }

      return var2;
   }

   private String a(String var1, String var2) {
      return var1 + "/" + this.a(this.b(var2));
   }

   private String a(int[] var1) {
      StringBuilder var3 = new StringBuilder();

      for (int var2 = 0; var2 < var1.length; var2++) {
         var3.append(var1[var2]);
         if (var2 != var1.length - 1) {
            var3.append(".");
         }
      }

      return var3.toString();
   }

   private void a(String var1) {
      int var2 = 0;
      Matcher var4 = b.matcher(var1);
      if (!var4.matches()) {
         throw new IllegalArgumentException("Could not parse [" + var1 + "]");
      }

      this.d = this.a(var4);

      for (int var3 = this.a(Integer.parseInt(var4.group(5)), 0, 31); var2 < var3; var2++) {
         this.c |= 1 << 31 - var2;
      }

      this.e = this.d & this.c;
      this.f = this.e | ~this.c;
   }

   private int b(String var1) {
      Matcher var2 = a.matcher(var1);
      if (var2.matches()) {
         return this.a(var2);
      } else {
         throw new IllegalArgumentException("Could not parse [" + var1 + "]");
      }
   }

   private int[] b(int var1) {
      int[] var3 = new int[4];

      for (int var2 = 3; var2 >= 0; var2--) {
         var3[var2] |= var1 >>> (3 - var2) * 8 & 0xFF;
      }

      return var3;
   }

   int a(int var1) {
      var1 -= var1 >>> 1 & 1431655765;
      var1 = (var1 >>> 2 & 858993459) + (var1 & 858993459);
      var1 = var1 + (var1 >>> 4) & 252645135;
      var1 += var1 >>> 8;
      return var1 + (var1 >>> 16) & 63;
   }

   public final SubnetUtils.SubnetInfo a() {
      return new SubnetUtils.SubnetInfo(this);
   }

   public final class SubnetInfo {
      final SubnetUtils a;

      private SubnetInfo(SubnetUtils var1) {
         this.a = var1;
      }

      private int b() {
         return this.a.e;
      }

      public String a() {
         return this.a.a(this.a.b(this.b()));
      }
   }
}
