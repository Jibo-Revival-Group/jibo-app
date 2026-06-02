package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.Util;

public final class Headers {
   private final String[] a;

   Headers(Headers.Builder var1) {
      this.a = var1.a.toArray(new String[var1.a.size()]);
   }

   private Headers(String[] var1) {
      this.a = var1;
   }

   private static String a(String[] var0, String var1) {
      int var2 = ((Object[])var0).length - 2;

      while (true) {
         if (var2 < 0) {
            var0 = null;
            break;
         }

         if (var1.equalsIgnoreCase(((Object[])var0)[var2])) {
            var0 = ((Object[])var0)[var2 + 1];
            break;
         }

         var2 -= 2;
      }

      return var0;
   }

   public static Headers a(String... var0) {
      if (var0 == null) {
         throw new NullPointerException("namesAndValues == null");
      }

      if (var0.length % 2 != 0) {
         throw new IllegalArgumentException("Expected alternating header names and values");
      }

      String[] var3 = (String[])var0.clone();

      for (int var1 = 0; var1 < var3.length; var1++) {
         if (var3[var1] == null) {
            throw new IllegalArgumentException("Headers cannot be null");
         }

         var3[var1] = var3[var1].trim();
      }

      for (byte var5 = 0; var5 < var3.length; var5 += 2) {
         String var4 = var3[var5];
         String var2 = var3[var5 + 1];
         if (var4.length() == 0 || var4.indexOf(0) != -1 || var2.indexOf(0) != -1) {
            throw new IllegalArgumentException("Unexpected header: " + var4 + ": " + var2);
         }
      }

      return new Headers(var3);
   }

   public int a() {
      return this.a.length / 2;
   }

   public String a(int var1) {
      return this.a[var1 * 2];
   }

   public String a(String var1) {
      return a(this.a, var1);
   }

   public String b(int var1) {
      return this.a[var1 * 2 + 1];
   }

   public List<String> b(String var1) {
      int var3 = this.a();
      ArrayList var4 = null;
      int var2 = 0;

      while (var2 < var3) {
         ArrayList var5 = var4;
         if (var1.equalsIgnoreCase(this.a(var2))) {
            var5 = var4;
            if (var4 == null) {
               var5 = new ArrayList(2);
            }

            var5.add(this.b(var2));
         }

         var2++;
         var4 = var5;
      }

      List var6;
      if (var4 != null) {
         var6 = Collections.unmodifiableList(var4);
      } else {
         var6 = Collections.emptyList();
      }

      return var6;
   }

   public Headers.Builder b() {
      Headers.Builder var1 = new Headers.Builder();
      Collections.addAll(var1.a, this.a);
      return var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof Headers && Arrays.equals(((Headers)var1).a, this.a)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(this.a);
   }

   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder();
      int var1 = 0;

      for (int var2 = this.a(); var1 < var2; var1++) {
         var3.append(this.a(var1)).append(": ").append(this.b(var1)).append("\n");
      }

      return var3.toString();
   }

   public static final class Builder {
      final List<String> a = new ArrayList<>(20);

      private void d(String var1, String var2) {
         if (var1 == null) {
            throw new NullPointerException("name == null");
         }

         if (var1.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
         }

         int var4 = var1.length();

         for (int var3 = 0; var3 < var4; var3++) {
            char var5 = var1.charAt(var3);
            if (var5 <= ' ' || var5 >= 127) {
               throw new IllegalArgumentException(Util.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(var5), var3, var1));
            }
         }

         if (var2 == null) {
            throw new NullPointerException("value for name " + var1 + " == null");
         }

         var4 = var2.length();

         for (int var6 = 0; var6 < var4; var6++) {
            char var8 = var2.charAt(var6);
            if (var8 <= 31 && var8 != '\t' || var8 >= 127) {
               throw new IllegalArgumentException(Util.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(var8), var6, var1, var2));
            }
         }
      }

      Headers.Builder a(String var1) {
         int var2 = var1.indexOf(":", 1);
         Headers.Builder var3;
         if (var2 != -1) {
            var3 = this.b(var1.substring(0, var2), var1.substring(var2 + 1));
         } else if (var1.startsWith(":")) {
            var3 = this.b("", var1.substring(1));
         } else {
            var3 = this.b("", var1);
         }

         return var3;
      }

      public Headers.Builder a(String var1, String var2) {
         this.d(var1, var2);
         return this.b(var1, var2);
      }

      public Headers a() {
         return new Headers(this);
      }

      public Headers.Builder b(String var1) {
         int var2 = 0;

         while (var2 < this.a.size()) {
            int var3 = var2;
            if (var1.equalsIgnoreCase(this.a.get(var2))) {
               this.a.remove(var2);
               this.a.remove(var2);
               var3 = var2 - 2;
            }

            var2 = var3 + 2;
         }

         return this;
      }

      Headers.Builder b(String var1, String var2) {
         this.a.add(var1);
         this.a.add(var2.trim());
         return this;
      }

      public String c(String var1) {
         int var2 = this.a.size() - 2;

         while (true) {
            if (var2 < 0) {
               var1 = null;
               break;
            }

            if (var1.equalsIgnoreCase(this.a.get(var2))) {
               var1 = this.a.get(var2 + 1);
               break;
            }

            var2 -= 2;
         }

         return var1;
      }

      public Headers.Builder c(String var1, String var2) {
         this.d(var1, var2);
         this.b(var1);
         this.b(var1, var2);
         return this;
      }
   }
}
