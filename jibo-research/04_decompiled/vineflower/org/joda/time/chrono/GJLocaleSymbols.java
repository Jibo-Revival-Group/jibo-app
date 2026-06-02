package org.joda.time.chrono;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.IllegalFieldValueException;

class GJLocaleSymbols {
   private static ConcurrentMap<Locale, GJLocaleSymbols> a = new ConcurrentHashMap<>();
   private final String[] b;
   private final String[] c;
   private final String[] d;
   private final String[] e;
   private final String[] f;
   private final String[] g;
   private final TreeMap<String, Integer> h;
   private final TreeMap<String, Integer> i;
   private final TreeMap<String, Integer> j;
   private final int k;
   private final int l;
   private final int m;
   private final int n;
   private final int o;
   private final int p;

   private GJLocaleSymbols(Locale var1) {
      DateFormatSymbols var3 = DateTimeUtils.a(var1);
      this.b = var3.getEras();
      this.c = b(var3.getWeekdays());
      this.d = b(var3.getShortWeekdays());
      this.e = a(var3.getMonths());
      this.f = a(var3.getShortMonths());
      this.g = var3.getAmPmStrings();
      Integer[] var4 = new Integer[13];

      for (int var2 = 0; var2 < 13; var2++) {
         var4[var2] = var2;
      }

      this.h = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
      a(this.h, this.b, var4);
      if ("en".equals(var1.getLanguage())) {
         this.h.put("BCE", var4[0]);
         this.h.put("CE", var4[1]);
      }

      this.i = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
      a(this.i, this.c, var4);
      a(this.i, this.d, var4);
      a(this.i, 1, 7, var4);
      this.j = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
      a(this.j, this.e, var4);
      a(this.j, this.f, var4);
      a(this.j, 1, 12, var4);
      this.k = c(this.b);
      this.l = c(this.c);
      this.m = c(this.d);
      this.n = c(this.e);
      this.o = c(this.f);
      this.p = c(this.g);
   }

   static GJLocaleSymbols a(Locale var0) {
      Locale var1 = var0;
      if (var0 == null) {
         var1 = Locale.getDefault();
      }

      GJLocaleSymbols var2 = a.get(var1);
      GJLocaleSymbols var3 = var2;
      if (var2 == null) {
         var3 = new GJLocaleSymbols(var1);
         GJLocaleSymbols var4 = a.putIfAbsent(var1, var3);
         if (var4 != null) {
            var3 = var4;
         }
      }

      return var3;
   }

   private static void a(TreeMap<String, Integer> var0, int var1, int var2, Integer[] var3) {
      while (var1 <= var2) {
         var0.put(String.valueOf(var1).intern(), var3[var1]);
         var1++;
      }
   }

   private static void a(TreeMap<String, Integer> var0, String[] var1, Integer[] var2) {
      int var3 = var1.length;

      while (true) {
         int var4 = var3 - 1;
         if (var4 < 0) {
            return;
         }

         String var5 = var1[var4];
         var3 = var4;
         if (var5 != null) {
            var0.put(var5, var2[var4]);
            var3 = var4;
         }
      }
   }

   private static String[] a(String[] var0) {
      String[] var2 = new String[13];

      for (int var1 = 1; var1 < 13; var1++) {
         var2[var1] = var0[var1 - 1];
      }

      return var2;
   }

   private static String[] b(String[] var0) {
      String[] var3 = new String[8];

      for (int var1 = 1; var1 < 8; var1++) {
         int var2;
         if (var1 < 7) {
            var2 = var1 + 1;
         } else {
            var2 = 1;
         }

         var3[var1] = var0[var2];
      }

      return var3;
   }

   private static int c(String[] var0) {
      int var1 = 0;
      int var2 = var0.length;

      while (--var2 >= 0) {
         String var4 = var0[var2];
         if (var4 != null) {
            int var3 = var4.length();
            if (var3 > var1) {
               var1 = var3;
            }
         }
      }

      return var1;
   }

   public int a() {
      return this.k;
   }

   public int a(String var1) {
      Integer var2 = this.h.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         throw new IllegalFieldValueException(DateTimeFieldType.w(), var1);
      }
   }

   public String a(int var1) {
      return this.b[var1];
   }

   public int b() {
      return this.n;
   }

   public int b(String var1) {
      Integer var2 = this.j.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         throw new IllegalFieldValueException(DateTimeFieldType.r(), var1);
      }
   }

   public String b(int var1) {
      return this.e[var1];
   }

   public int c() {
      return this.l;
   }

   public int c(String var1) {
      Integer var2 = this.i.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         throw new IllegalFieldValueException(DateTimeFieldType.l(), var1);
      }
   }

   public String c(int var1) {
      return this.f[var1];
   }

   public int d() {
      return this.p;
   }

   public int d(String var1) {
      String[] var4 = this.g;
      int var2 = var4.length;

      int var3;
      do {
         var3 = var2 - 1;
         if (var3 < 0) {
            throw new IllegalFieldValueException(DateTimeFieldType.k(), var1);
         }

         var2 = var3;
      } while (!var4[var3].equalsIgnoreCase(var1));

      return var3;
   }

   public String d(int var1) {
      return this.c[var1];
   }

   public String e(int var1) {
      return this.d[var1];
   }

   public String f(int var1) {
      return this.g[var1];
   }
}
