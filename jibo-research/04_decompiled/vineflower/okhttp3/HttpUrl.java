package okhttp3;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;

public final class HttpUrl {
   private static final char[] d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
   final String a;
   final String b;
   final int c;
   private final String e;
   private final String f;
   private final List<String> g;
   private final List<String> h;
   private final String i;
   private final String j;

   HttpUrl(HttpUrl.Builder var1) {
      Object var3 = null;
      super();
      this.a = var1.a;
      this.e = a(var1.b, false);
      this.f = a(var1.c, false);
      this.b = var1.d;
      this.c = var1.a();
      this.g = this.a(var1.f, false);
      List var2;
      if (var1.g != null) {
         var2 = this.a(var1.g, true);
      } else {
         var2 = null;
      }

      this.h = var2;
      String var4 = (String)var3;
      if (var1.h != null) {
         var4 = a(var1.h, false);
      }

      this.i = var4;
      this.j = var1.toString();
   }

   static int a(char var0) {
      if (var0 >= 48 && var0 <= 57) {
         var0 -= 48;
      } else if (var0 >= 97 && var0 <= 102) {
         var0 = var0 - 97 + 10;
      } else if (var0 >= 65 && var0 <= 70) {
         var0 = var0 - 65 + 10;
      } else {
         var0 = -1;
      }

      return var0;
   }

   public static int a(String var0) {
      short var1;
      if (var0.equals("http")) {
         var1 = 80;
      } else if (var0.equals("https")) {
         var1 = 443;
      } else {
         var1 = -1;
      }

      return var1;
   }

   static String a(String var0, int var1, int var2, String var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      int var8 = var1;

      while (true) {
         if (var8 >= var2) {
            var0 = var0.substring(var1, var2);
            break;
         }

         int var9 = var0.codePointAt(var8);
         if (var9 < 32
            || var9 == 127
            || var9 >= 128 && var7
            || var3.indexOf(var9) != -1
            || var9 == 37 && (!var4 || var5 && !a(var0, var8, var2))
            || var9 == 43 && var6) {
            Buffer var10 = new Buffer();
            var10.a(var0, var1, var8);
            a(var10, var0, var8, var2, var3, var4, var5, var6, var7);
            var0 = var10.q();
            break;
         }

         var8 += Character.charCount(var9);
      }

      return var0;
   }

   static String a(String var0, int var1, int var2, boolean var3) {
      int var4 = var1;

      while (true) {
         if (var4 >= var2) {
            var0 = var0.substring(var1, var2);
            break;
         }

         char var5 = var0.charAt(var4);
         if (var5 == '%' || var5 == '+' && var3) {
            Buffer var6 = new Buffer();
            var6.a(var0, var1, var4);
            a(var6, var0, var4, var2, var3);
            var0 = var6.q();
            break;
         }

         var4++;
      }

      return var0;
   }

   static String a(String var0, String var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      return a(var0, 0, var0.length(), var1, var2, var3, var4, var5);
   }

   static String a(String var0, boolean var1) {
      return a(var0, 0, var0.length(), var1);
   }

   private List<String> a(List<String> var1, boolean var2) {
      int var4 = var1.size();
      ArrayList var6 = new ArrayList(var4);

      for (int var3 = 0; var3 < var4; var3++) {
         String var5 = (String)var1.get(var3);
         if (var5 != null) {
            var5 = a(var5, var2);
         } else {
            var5 = null;
         }

         var6.add(var5);
      }

      return Collections.unmodifiableList(var6);
   }

   public static HttpUrl a(URI var0) {
      return e(var0.toString());
   }

   static void a(StringBuilder var0, List<String> var1) {
      int var3 = var1.size();

      for (int var2 = 0; var2 < var3; var2++) {
         var0.append('/');
         var0.append((String)var1.get(var2));
      }
   }

   static void a(Buffer var0, String var1, int var2, int var3, String var4, boolean var5, boolean var6, boolean var7, boolean var8) {
      Buffer var11 = null;

      while (var2 < var3) {
         int var10;
         Buffer var13;
         label81: {
            var10 = var1.codePointAt(var2);
            if (var5) {
               var13 = var11;
               if (var10 == 9) {
                  break label81;
               }

               var13 = var11;
               if (var10 == 10) {
                  break label81;
               }

               var13 = var11;
               if (var10 == 12) {
                  break label81;
               }

               if (var10 == 13) {
                  var13 = var11;
                  break label81;
               }
            }

            if (var10 == 43 && var7) {
               String var14;
               if (var5) {
                  var14 = "+";
               } else {
                  var14 = "%2B";
               }

               var0.a(var14);
               var13 = var11;
            } else if (var10 < 32
               || var10 == 127
               || var10 >= 128 && var8
               || var4.indexOf(var10) != -1
               || var10 == 37 && (!var5 || var6 && !a(var1, var2, var3))) {
               Buffer var12 = var11;
               if (var11 == null) {
                  var12 = new Buffer();
               }

               var12.a(var10);

               while (true) {
                  var13 = var12;
                  if (var12.f()) {
                     break;
                  }

                  int var9 = var12.i() & 255;
                  var0.b(37);
                  var0.b(d[var9 >> 4 & 15]);
                  var0.b(d[var9 & 15]);
               }
            } else {
               var0.a(var10);
               var13 = var11;
            }
         }

         var2 += Character.charCount(var10);
         var11 = var13;
      }
   }

   static void a(Buffer var0, String var1, int var2, int var3, boolean var4) {
      while (var2 < var3) {
         int var5;
         label31: {
            var5 = var1.codePointAt(var2);
            if (var5 == 37 && var2 + 2 < var3) {
               int var6 = a(var1.charAt(var2 + 1));
               int var7 = a(var1.charAt(var2 + 2));
               if (var6 != -1 && var7 != -1) {
                  var0.b((var6 << 4) + var7);
                  var2 += 2;
                  break label31;
               }
            } else if (var5 == 43 && var4) {
               var0.b(32);
               break label31;
            }

            var0.a(var5);
         }

         var2 += Character.charCount(var5);
      }
   }

   static boolean a(String var0, int var1, int var2) {
      boolean var3;
      if (var1 + 2 < var2 && var0.charAt(var1) == '%' && a(var0.charAt(var1 + 1)) != -1 && a(var0.charAt(var1 + 2)) != -1) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   static List<String> b(String var0) {
      ArrayList var4 = new ArrayList();
      int var1 = 0;

      while (var1 <= var0.length()) {
         int var3 = var0.indexOf(38, var1);
         int var2 = var3;
         if (var3 == -1) {
            var2 = var0.length();
         }

         var3 = var0.indexOf(61, var1);
         if (var3 != -1 && var3 <= var2) {
            var4.add(var0.substring(var1, var3));
            var4.add(var0.substring(var3 + 1, var2));
         } else {
            var4.add(var0.substring(var1, var2));
            var4.add(null);
         }

         var1 = var2 + 1;
      }

      return var4;
   }

   static void b(StringBuilder var0, List<String> var1) {
      int var3 = var1.size();

      for (byte var2 = 0; var2 < var3; var2 += 2) {
         String var4 = (String)var1.get(var2);
         String var5 = (String)var1.get(var2 + 1);
         if (var2 > 0) {
            var0.append('&');
         }

         var0.append(var4);
         if (var5 != null) {
            var0.append('=');
            var0.append(var5);
         }
      }
   }

   public static HttpUrl e(String var0) {
      HttpUrl var1 = null;
      HttpUrl.Builder var2 = new HttpUrl.Builder();
      if (var2.a((HttpUrl)null, var0) == HttpUrl.Builder.ParseResult.SUCCESS) {
         var1 = var2.c();
      }

      return var1;
   }

   public URL a() {
      try {
         return new URL(this.j);
      } catch (MalformedURLException var2) {
         throw new RuntimeException(var2);
      }
   }

   public URI b() {
      String var3 = this.p().b().toString();

      URI var1;
      try {
         var1 = new URI(var3);
      } catch (URISyntaxException var5) {
         try {
            var1 = URI.create(var3.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
         } catch (Exception var4) {
            throw new RuntimeException(var5);
         }
      }

      return var1;
   }

   public String c() {
      return this.a;
   }

   public HttpUrl c(String var1) {
      HttpUrl.Builder var2 = this.d(var1);
      HttpUrl var3;
      if (var2 != null) {
         var3 = var2.c();
      } else {
         var3 = null;
      }

      return var3;
   }

   public HttpUrl.Builder d(String var1) {
      HttpUrl.Builder var2 = new HttpUrl.Builder();
      HttpUrl.Builder var3;
      if (var2.a(this, var1) == HttpUrl.Builder.ParseResult.SUCCESS) {
         var3 = var2;
      } else {
         var3 = null;
      }

      return var3;
   }

   public boolean d() {
      return this.a.equals("https");
   }

   public String e() {
      String var3;
      if (this.e.isEmpty()) {
         var3 = "";
      } else {
         int var1 = this.a.length() + 3;
         int var2 = Util.a(this.j, var1, this.j.length(), ":@");
         var3 = this.j.substring(var1, var2);
      }

      return var3;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof HttpUrl && ((HttpUrl)var1).j.equals(this.j)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public String f() {
      String var3;
      if (this.f.isEmpty()) {
         var3 = "";
      } else {
         int var1 = this.j.indexOf(58, this.a.length() + 3);
         int var2 = this.j.indexOf(64);
         var3 = this.j.substring(var1 + 1, var2);
      }

      return var3;
   }

   public String g() {
      return this.b;
   }

   public int h() {
      return this.c;
   }

   @Override
   public int hashCode() {
      return this.j.hashCode();
   }

   public String i() {
      int var2 = this.j.indexOf(47, this.a.length() + 3);
      int var1 = Util.a(this.j, var2, this.j.length(), "?#");
      return this.j.substring(var2, var1);
   }

   public List<String> j() {
      int var1 = this.j.indexOf(47, this.a.length() + 3);
      int var2 = Util.a(this.j, var1, this.j.length(), "?#");
      ArrayList var4 = new ArrayList();

      while (var1 < var2) {
         int var3 = var1 + 1;
         var1 = Util.a(this.j, var3, var2, '/');
         var4.add(this.j.substring(var3, var1));
      }

      return var4;
   }

   public List<String> k() {
      return this.g;
   }

   public String l() {
      String var3;
      if (this.h == null) {
         var3 = null;
      } else {
         int var2 = this.j.indexOf(63) + 1;
         int var1 = Util.a(this.j, var2 + 1, this.j.length(), '#');
         var3 = this.j.substring(var2, var1);
      }

      return var3;
   }

   public String m() {
      String var1;
      if (this.h == null) {
         var1 = null;
      } else {
         StringBuilder var2 = new StringBuilder();
         b(var2, this.h);
         var1 = var2.toString();
      }

      return var1;
   }

   public String n() {
      String var2;
      if (this.i == null) {
         var2 = null;
      } else {
         int var1 = this.j.indexOf(35);
         var2 = this.j.substring(var1 + 1);
      }

      return var2;
   }

   public String o() {
      return this.d("/...").b("").c("").c().toString();
   }

   public HttpUrl.Builder p() {
      HttpUrl.Builder var2 = new HttpUrl.Builder();
      var2.a = this.a;
      var2.b = this.e();
      var2.c = this.f();
      var2.d = this.b;
      int var1;
      if (this.c != a(this.a)) {
         var1 = this.c;
      } else {
         var1 = -1;
      }

      var2.e = var1;
      var2.f.clear();
      var2.f.addAll(this.j());
      var2.g(this.l());
      var2.h = this.n();
      return var2;
   }

   @Override
   public String toString() {
      return this.j;
   }

   public static final class Builder {
      String a;
      String b = "";
      String c = "";
      String d;
      int e = -1;
      final List<String> f = new ArrayList<>();
      List<String> g;
      String h;

      public Builder() {
         this.f.add("");
      }

      private static String a(byte[] var0) {
         byte var7 = 0;
         int var3 = 0;
         int var2 = -1;
         int var1 = 0;

         while (var1 < var0.length) {
            int var4 = var1;

            while (var4 < 16 && var0[var4] == 0 && var0[var4 + 1] == 0) {
               var4 += 2;
            }

            int var8 = var4 - var1;
            int var6 = var3;
            int var5 = var2;
            if (var8 > var3) {
               var6 = var3;
               var5 = var2;
               if (var8 >= 4) {
                  var6 = var8;
                  var5 = var1;
               }
            }

            var1 = var4 + 2;
            var3 = var6;
            var2 = var5;
         }

         Buffer var9 = new Buffer();
         var1 = var7;

         while (var1 < var0.length) {
            if (var1 == var2) {
               var9.b(58);
               int var11 = var1 + var3;
               var1 = var11;
               if (var11 == 16) {
                  var9.b(58);
                  var1 = var11;
               }
            } else {
               if (var1 > 0) {
                  var9.b(58);
               }

               var9.k((long)((var0[var1] & 255) << 8 | var0[var1 + 1] & 0xFF));
               var1 += 2;
            }
         }

         return var9.q();
      }

      private HttpUrl.Builder a(String var1, boolean var2) {
         int var3 = 0;

         int var4;
         do {
            var4 = Util.a(var1, var3, var1.length(), "/\\");
            boolean var5;
            if (var4 < var1.length()) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.a(var1, var3, var4, var5, var2);
            var3 = ++var4;
         } while (var4 <= var1.length());

         return this;
      }

      private void a(String var1, int var2, int var3) {
         if (var2 != var3) {
            int var4 = var1.charAt(var2);
            if (var4 != 47 && var4 != 92) {
               this.f.set(this.f.size() - 1, "");
            } else {
               this.f.clear();
               this.f.add("");
               var2++;
            }

            while (var2 < var3) {
               var4 = Util.a(var1, var2, var3, "/\\");
               boolean var5;
               if (var4 < var3) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               this.a(var1, var2, var4, var5, true);
               var2 = var4;
               if (var5) {
                  var2 = var4 + 1;
               }
            }
         }
      }

      private void a(String var1, int var2, int var3, boolean var4, boolean var5) {
         var1 = HttpUrl.a(var1, var2, var3, " \"<>^`{}|/\\?#", var5, false, false, true);
         if (!this.h(var1)) {
            if (this.i(var1)) {
               this.d();
            } else {
               if (this.f.get(this.f.size() - 1).isEmpty()) {
                  this.f.set(this.f.size() - 1, var1);
               } else {
                  this.f.add(var1);
               }

               if (var4) {
                  this.f.add("");
               }
            }
         }
      }

      private static boolean a(String var0, int var1, int var2, byte[] var3, int var4) {
         int var6 = var4;
         int var5 = var1;

         boolean var9;
         while (true) {
            if (var5 >= var2) {
               if (var6 != var4 + 4) {
                  var9 = false;
               } else {
                  var9 = true;
               }
               break;
            }

            if (var6 == var3.length) {
               var9 = false;
               break;
            }

            var1 = var5;
            if (var6 != var4) {
               if (var0.charAt(var5) != '.') {
                  var9 = false;
                  break;
               }

               var1 = var5 + 1;
            }

            int var7 = 0;

            for (var5 = var1; var5 < var2; var5++) {
               char var8 = var0.charAt(var5);
               if (var8 < '0' || var8 > '9') {
                  break;
               }

               if (var7 == 0 && var1 != var5) {
                  return false;
               }

               var7 = var7 * 10 + var8 - 48;
               if (var7 > 255) {
                  return false;
               }
            }

            if (var5 - var1 == 0) {
               var9 = false;
               break;
            }

            var3[var6] = (byte)var7;
            var6++;
         }

         return var9;
      }

      private static int b(String var0, int var1, int var2) {
         byte var4 = -1;
         int var3;
         if (var2 - var1 < 2) {
            var3 = var4;
         } else {
            char var5 = var0.charAt(var1);
            if (var5 < 'a' || var5 > 'z') {
               byte var8 = var4;
               if (var5 < 'A') {
                  return var8;
               }

               var8 = var4;
               if (var5 > 'Z') {
                  return var8;
               }
            }

            var1++;

            while (true) {
               var3 = var4;
               if (var1 >= var2) {
                  break;
               }

               var5 = var0.charAt(var1);
               if ((var5 < 'a' || var5 > 'z') && (var5 < 'A' || var5 > 'Z') && (var5 < '0' || var5 > '9') && var5 != '+' && var5 != '-' && var5 != '.') {
                  var3 = var4;
                  if (var5 == ':') {
                     var3 = var1;
                  }
                  break;
               }

               var1++;
            }
         }

         return var3;
      }

      private static int c(String var0, int var1, int var2) {
         int var3 = 0;

         while (var1 < var2) {
            char var4 = var0.charAt(var1);
            if (var4 != '\\' && var4 != '/') {
               break;
            }

            var3++;
            var1++;
         }

         return var3;
      }

      private static int d(String var0, int var1, int var2) {
         while (true) {
            int var6;
            label21: {
               int var4;
               if (var1 < var2) {
                  var6 = var1;
                  var4 = var1;
                  switch (var0.charAt(var1)) {
                     case ':':
                        break;
                     case '[':
                        do {
                           var1 = var6 + 1;
                           var6 = var1;
                           if (var1 >= var2) {
                              break label21;
                           }

                           var6 = var1;
                        } while (var0.charAt(var1) != ']');

                        var6 = var1;
                        break label21;
                     default:
                        var6 = var1;
                        break label21;
                  }
               } else {
                  var4 = var2;
               }

               return var4;
            }

            var1 = var6 + 1;
         }
      }

      private void d() {
         if (this.f.remove(this.f.size() - 1).isEmpty() && !this.f.isEmpty()) {
            this.f.set(this.f.size() - 1, "");
         } else {
            this.f.add("");
         }
      }

      private static String e(String var0, int var1, int var2) {
         var0 = HttpUrl.a(var0, var1, var2, false);
         if (var0.contains(":")) {
            InetAddress var4;
            if (var0.startsWith("[") && var0.endsWith("]")) {
               var4 = f(var0, 1, var0.length() - 1);
            } else {
               var4 = f(var0, 0, var0.length());
            }

            if (var4 == null) {
               var0 = null;
            } else {
               byte[] var6 = var4.getAddress();
               if (var6.length != 16) {
                  throw new AssertionError();
               }

               var0 = a(var6);
            }
         } else {
            var0 = Util.a(var0);
         }

         return var0;
      }

      private static InetAddress f(String var0, int var1, int var2) {
         byte[] var9 = new byte[16];
         int var8 = -1;
         int var4 = -1;
         int var3 = 0;
         int var5 = var1;

         int var6;
         while (true) {
            var6 = var4;
            var1 = var3;
            if (var5 >= var2) {
               break;
            }

            if (var3 == var9.length) {
               return null;
            }

            int var7;
            if (var5 + 2 <= var2 && var0.regionMatches(var5, "::", 0, 2)) {
               if (var4 != -1) {
                  return null;
               }

               var1 = var5 + 2;
               var3 += 2;
               if (var1 == var2) {
                  var1 = var3;
                  var6 = var3;
                  break;
               }

               var7 = var3;
               var6 = var3;
            } else {
               var1 = var5;
               var6 = var4;
               var7 = var3;
               if (var3 != 0) {
                  if (!var0.regionMatches(var5, ":", 0, 1)) {
                     if (!var0.regionMatches(var5, ".", 0, 1)) {
                        return null;
                     }

                     if (!a(var0, var8, var2, var9, var3 - 2)) {
                        return null;
                     }

                     var1 = var3 + 2;
                     var6 = var4;
                     break;
                  }

                  var1 = var5 + 1;
                  var7 = var3;
                  var6 = var4;
               }
            }

            var4 = 0;

            for (var3 = var1; var3 < var2; var3++) {
               var5 = HttpUrl.a(var0.charAt(var3));
               if (var5 == -1) {
                  break;
               }

               var4 = (var4 << 4) + var5;
            }

            var5 = var3 - var1;
            if (var5 == 0 || var5 > 4) {
               return null;
            }

            var5 = var7 + 1;
            var9[var7] = (byte)(var4 >>> 8 & 0xFF);
            var7 = var5 + 1;
            var9[var5] = (byte)(var4 & 0xFF);
            var5 = var3;
            var4 = var6;
            var3 = var7;
            var8 = var1;
         }

         if (var1 != var9.length) {
            if (var6 == -1) {
               Object var22 = null;
               return (InetAddress)var22;
            }

            System.arraycopy(var9, var6, var9, var9.length - (var1 - var6), var1 - var6);
            Arrays.fill(var9, var6, var9.length - var1 + var6, (byte)0);
         }

         try {
            var11 = InetAddress.getByAddress(var9);
         } catch (UnknownHostException var10) {
            throw new AssertionError();
         }

         return var11;
      }

      private static int g(String var0, int var1, int var2) {
         try {
            var1 = Integer.parseInt(HttpUrl.a(var0, var1, var2, "", false, false, false, true));
         } catch (NumberFormatException var3) {
            return -1;
         }

         if (var1 <= 0 || var1 > 65535) {
            var1 = -1;
         }

         return var1;
      }

      private boolean h(String var1) {
         boolean var2;
         if (!var1.equals(".") && !var1.equalsIgnoreCase("%2e")) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      private boolean i(String var1) {
         boolean var2;
         if (!var1.equals("..") && !var1.equalsIgnoreCase("%2e.") && !var1.equalsIgnoreCase(".%2e") && !var1.equalsIgnoreCase("%2e%2e")) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      int a() {
         int var1;
         if (this.e != -1) {
            var1 = this.e;
         } else {
            var1 = HttpUrl.a(this.a);
         }

         return var1;
      }

      HttpUrl.Builder.ParseResult a(HttpUrl var1, String var2) {
         int var3 = Util.a(var2, 0, var2.length());
         int var8 = Util.b(var2, var3, var2.length());
         if (b(var2, var3, var8) != -1) {
            if (var2.regionMatches(true, var3, "https:", 0, 6)) {
               this.a = "https";
               var3 += "https:".length();
            } else {
               if (!var2.regionMatches(true, var3, "http:", 0, 5)) {
                  return HttpUrl.Builder.ParseResult.UNSUPPORTED_SCHEME;
               }

               this.a = "http";
               var3 += "http:".length();
            }
         } else {
            if (var1 == null) {
               return HttpUrl.Builder.ParseResult.MISSING_SCHEME;
            }

            this.a = var1.a;
         }

         int var16;
         int var6 = c(var2, var3, var8);
         label83:
         if (var6 < 2 && var1 != null && var1.a.equals(this.a)) {
            this.b = var1.e();
            this.c = var1.f();
            this.d = var1.b;
            this.e = var1.c;
            this.f.clear();
            this.f.addAll(var1.j());
            if (var3 != var8) {
               var16 = var3;
               if (var2.charAt(var3) != '#') {
                  break label83;
               }
            }

            this.g(var1.l());
            var16 = var3;
         } else {
            int var5 = 0;
            boolean var4 = false;
            var6 = var3 + var6;
            int var12 = var5;
            var5 = var6;

            label73:
            while (true) {
               int var7 = Util.a(var2, var5, var8, "@/\\?#");
               if (var7 != var8) {
                  var6 = var2.charAt(var7);
               } else {
                  var6 = -1;
               }

               boolean var19;
               switch (var6) {
                  case -1:
                  case 35:
                  case 47:
                  case 63:
                  case 92:
                     var12 = d(var2, var5, var7);
                     if (var12 + 1 < var7) {
                        this.d = e(var2, var5, var12);
                        this.e = g(var2, var12 + 1, var7);
                        if (this.e == -1) {
                           return HttpUrl.Builder.ParseResult.INVALID_PORT;
                        }
                     } else {
                        this.d = e(var2, var5, var12);
                        this.e = HttpUrl.a(this.a);
                     }

                     if (this.d == null) {
                        return HttpUrl.Builder.ParseResult.INVALID_HOST;
                     }

                     var16 = var7;
                     break label73;
                  case 64:
                     if (!var12) {
                        var6 = Util.a(var2, var5, var7, ':');
                        String var9 = HttpUrl.a(var2, var5, var6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        String var11 = var9;
                        if (var4) {
                           var11 = this.b + "%40" + var9;
                        }

                        this.b = var11;
                        if (var6 != var7) {
                           var12 = 1;
                           this.c = HttpUrl.a(var2, var6 + 1, var7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        }

                        var4 = true;
                     } else {
                        this.c = this.c + "%40" + HttpUrl.a(var2, var5, var7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                     }

                     var6 = var7 + 1;
                     var19 = (boolean)var12;
                     var12 = var6;
                     break;
                  default:
                     boolean var22 = (boolean)var12;
                     var12 = var5;
                     var19 = var22;
               }

               boolean var25 = var19;
               var5 = var12;
               var12 = var25;
            }
         }

         var3 = Util.a(var2, var16, var8, "?#");
         this.a(var2, var16, var3);
         if (var3 < var8 && var2.charAt(var3) == '?') {
            var16 = Util.a(var2, var3, var8, '#');
            this.g = HttpUrl.b(HttpUrl.a(var2, var3 + 1, var16, " \"'<>#", true, false, true, true));
            var3 = var16;
         }

         if (var3 < var8 && var2.charAt(var3) == '#') {
            this.h = HttpUrl.a(var2, var3 + 1, var8, "", true, false, false, false);
         }

         return HttpUrl.Builder.ParseResult.SUCCESS;
      }

      public HttpUrl.Builder a(int var1) {
         if (var1 > 0 && var1 <= 65535) {
            this.e = var1;
            return this;
         } else {
            throw new IllegalArgumentException("unexpected port: " + var1);
         }
      }

      public HttpUrl.Builder a(String var1) {
         if (var1 == null) {
            throw new NullPointerException("scheme == null");
         }

         if (var1.equalsIgnoreCase("http")) {
            this.a = "http";
         } else {
            if (!var1.equalsIgnoreCase("https")) {
               throw new IllegalArgumentException("unexpected scheme: " + var1);
            }

            this.a = "https";
         }

         return this;
      }

      public HttpUrl.Builder a(String var1, String var2) {
         if (var1 == null) {
            throw new NullPointerException("name == null");
         }

         if (this.g == null) {
            this.g = new ArrayList<>();
         }

         this.g.add(HttpUrl.a(var1, " \"'<>#&=", false, false, true, true));
         List var3 = this.g;
         if (var2 != null) {
            var1 = HttpUrl.a(var2, " \"'<>#&=", false, false, true, true);
         } else {
            var1 = null;
         }

         var3.add(var1);
         return this;
      }

      HttpUrl.Builder b() {
         int var2 = this.f.size();

         for (int var1 = 0; var1 < var2; var1++) {
            String var3 = this.f.get(var1);
            this.f.set(var1, HttpUrl.a(var3, "[]", true, true, false, true));
         }

         if (this.g != null) {
            var2 = this.g.size();

            for (int var4 = 0; var4 < var2; var4++) {
               String var6 = this.g.get(var4);
               if (var6 != null) {
                  this.g.set(var4, HttpUrl.a(var6, "\\^`{|}", true, true, true, true));
               }
            }
         }

         if (this.h != null) {
            this.h = HttpUrl.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
         }

         return this;
      }

      public HttpUrl.Builder b(String var1) {
         if (var1 == null) {
            throw new NullPointerException("username == null");
         }

         this.b = HttpUrl.a(var1, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
         return this;
      }

      public HttpUrl.Builder b(String var1, String var2) {
         if (var1 == null) {
            throw new NullPointerException("encodedName == null");
         }

         if (this.g == null) {
            this.g = new ArrayList<>();
         }

         this.g.add(HttpUrl.a(var1, " \"'<>#&=", true, false, true, true));
         List var3 = this.g;
         if (var2 != null) {
            var1 = HttpUrl.a(var2, " \"'<>#&=", true, false, true, true);
         } else {
            var1 = null;
         }

         var3.add(var1);
         return this;
      }

      public HttpUrl.Builder c(String var1) {
         if (var1 == null) {
            throw new NullPointerException("password == null");
         }

         this.c = HttpUrl.a(var1, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
         return this;
      }

      public HttpUrl c() {
         if (this.a == null) {
            throw new IllegalStateException("scheme == null");
         } else if (this.d == null) {
            throw new IllegalStateException("host == null");
         } else {
            return new HttpUrl(this);
         }
      }

      public HttpUrl.Builder d(String var1) {
         if (var1 == null) {
            throw new NullPointerException("host == null");
         }

         String var2 = e(var1, 0, var1.length());
         if (var2 == null) {
            throw new IllegalArgumentException("unexpected host: " + var1);
         }

         this.d = var2;
         return this;
      }

      public HttpUrl.Builder e(String var1) {
         if (var1 == null) {
            throw new NullPointerException("pathSegment == null");
         }

         this.a(var1, 0, var1.length(), false, false);
         return this;
      }

      public HttpUrl.Builder f(String var1) {
         if (var1 == null) {
            throw new NullPointerException("pathSegments == null");
         } else {
            return this.a(var1, false);
         }
      }

      public HttpUrl.Builder g(String var1) {
         List var2;
         if (var1 != null) {
            var2 = HttpUrl.b(HttpUrl.a(var1, " \"'<>#", true, false, true, true));
         } else {
            var2 = null;
         }

         this.g = var2;
         return this;
      }

      @Override
      public String toString() {
         StringBuilder var2 = new StringBuilder();
         var2.append(this.a);
         var2.append("://");
         if (!this.b.isEmpty() || !this.c.isEmpty()) {
            var2.append(this.b);
            if (!this.c.isEmpty()) {
               var2.append(':');
               var2.append(this.c);
            }

            var2.append('@');
         }

         if (this.d.indexOf(58) != -1) {
            var2.append('[');
            var2.append(this.d);
            var2.append(']');
         } else {
            var2.append(this.d);
         }

         int var1 = this.a();
         if (var1 != HttpUrl.a(this.a)) {
            var2.append(':');
            var2.append(var1);
         }

         HttpUrl.a(var2, this.f);
         if (this.g != null) {
            var2.append('?');
            HttpUrl.b(var2, this.g);
         }

         if (this.h != null) {
            var2.append('#');
            var2.append(this.h);
         }

         return var2.toString();
      }

      enum ParseResult {
         INVALID_HOST,
         INVALID_PORT,
         MISSING_SCHEME,
         SUCCESS,
         UNSUPPORTED_SCHEME;

         private static final HttpUrl.Builder.ParseResult[] $VALUES = new HttpUrl.Builder.ParseResult[]{
            HttpUrl.Builder.ParseResult.SUCCESS,
            HttpUrl.Builder.ParseResult.MISSING_SCHEME,
            HttpUrl.Builder.ParseResult.UNSUPPORTED_SCHEME,
            HttpUrl.Builder.ParseResult.INVALID_PORT,
            HttpUrl.Builder.ParseResult.INVALID_HOST
         };
      }
   }
}
