package okhttp3.internal.http;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

public final class HttpHeaders {
   private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

   public static int a(String var0, int var1) {
      while (var1 < var0.length()) {
         char var2 = var0.charAt(var1);
         if (var2 == ' ' || var2 == '\t') {
            var1++;
            continue;
         }
         break;
      }

      return var1;
   }

   public static int a(String var0, int var1, String var2) {
      while (var1 < var0.length() && var2.indexOf(var0.charAt(var1)) == -1) {
         var1++;
      }

      return var1;
   }

   private static long a(String var0) {
      long var1 = -1L;
      if (var0 != null) {
         long var3;
         try {
            var3 = Long.parseLong(var0);
         } catch (NumberFormatException var5) {
            return var1;
         }

         var1 = var3;
      }

      return var1;
   }

   public static long a(Headers var0) {
      return a(var0.a("Content-Length"));
   }

   public static long a(Response var0) {
      return a(var0.g());
   }

   public static Headers a(Headers var0, Headers var1) {
      Set var4 = c(var1);
      if (var4.isEmpty()) {
         var0 = new Headers.Builder().a();
      } else {
         Headers.Builder var5 = new Headers.Builder();
         int var2 = 0;

         for (int var3 = var0.a(); var2 < var3; var2++) {
            String var7 = var0.a(var2);
            if (var4.contains(var7)) {
               var5.a(var7, var0.b(var2));
            }
         }

         var0 = var5.a();
      }

      return var0;
   }

   public static void a(CookieJar var0, HttpUrl var1, Headers var2) {
      if (var0 != CookieJar.a) {
         List var3 = Cookie.a(var1, var2);
         if (!var3.isEmpty()) {
            var0.a(var1, var3);
         }
      }
   }

   public static boolean a(Response var0, Headers var1, Request var2) {
      Iterator var4 = e(var0).iterator();

      boolean var3;
      while (true) {
         if (var4.hasNext()) {
            String var5 = (String)var4.next();
            if (Util.a(var1.b(var5), var2.b(var5))) {
               continue;
            }

            var3 = false;
            break;
         }

         var3 = true;
         break;
      }

      return var3;
   }

   public static int b(String var0, int var1) {
      long var2;
      try {
         var2 = Long.parseLong(var0);
      } catch (NumberFormatException var4) {
         return var1;
      }

      if (var2 > 2147483647L) {
         var1 = Integer.MAX_VALUE;
      } else if (var2 < 0L) {
         var1 = 0;
      } else {
         var1 = (int)var2;
      }

      return var1;
   }

   public static boolean b(Headers var0) {
      return c(var0).contains("*");
   }

   public static boolean b(Response var0) {
      return b(var0.g());
   }

   public static Set<String> c(Headers var0) {
      Set var6 = Collections.emptySet();
      int var3 = var0.a();

      for (int var1 = 0; var1 < var3; var1++) {
         if ("Vary".equalsIgnoreCase(var0.a(var1))) {
            String var7 = var0.b(var1);
            Set var5 = var6;
            if (var6.isEmpty()) {
               var5 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
            }

            String[] var8 = var7.split(",");
            int var4 = var8.length;
            int var2 = 0;

            while (true) {
               var6 = var5;
               if (var2 >= var4) {
                  break;
               }

               var5.add(var8[var2].trim());
               var2++;
            }
         }
      }

      return var6;
   }

   public static Headers c(Response var0) {
      return a(var0.j().a().c(), var0.g());
   }

   public static boolean d(Response var0) {
      boolean var2 = false;
      if (!var0.a().b().equals("HEAD")) {
         int var1 = var0.c();
         if ((var1 < 100 || var1 >= 200) && var1 != 204 && var1 != 304) {
            var2 = true;
         } else if (a(var0) != -1L || "chunked".equalsIgnoreCase(var0.a("Transfer-Encoding"))) {
            var2 = true;
         }
      }

      return var2;
   }

   private static Set<String> e(Response var0) {
      return c(var0.g());
   }
}
