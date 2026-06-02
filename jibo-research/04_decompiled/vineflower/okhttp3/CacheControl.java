package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.http.HttpHeaders;

public final class CacheControl {
   public static final CacheControl a = new CacheControl.Builder().a().c();
   public static final CacheControl b = new CacheControl.Builder().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
   String c;
   private final boolean d;
   private final boolean e;
   private final int f;
   private final int g;
   private final boolean h;
   private final boolean i;
   private final boolean j;
   private final int k;
   private final int l;
   private final boolean m;
   private final boolean n;
   private final boolean o;

   CacheControl(CacheControl.Builder var1) {
      this.d = var1.a;
      this.e = var1.b;
      this.f = var1.c;
      this.g = -1;
      this.h = false;
      this.i = false;
      this.j = false;
      this.k = var1.d;
      this.l = var1.e;
      this.m = var1.f;
      this.n = var1.g;
      this.o = var1.h;
   }

   private CacheControl(
      boolean var1,
      boolean var2,
      int var3,
      int var4,
      boolean var5,
      boolean var6,
      boolean var7,
      int var8,
      int var9,
      boolean var10,
      boolean var11,
      boolean var12,
      String var13
   ) {
      this.d = var1;
      this.e = var2;
      this.f = var3;
      this.g = var4;
      this.h = var5;
      this.i = var6;
      this.j = var7;
      this.k = var8;
      this.l = var9;
      this.m = var10;
      this.n = var11;
      this.o = var12;
      this.c = var13;
   }

   public static CacheControl a(Headers var0) {
      boolean var19 = false;
      int var6 = -1;
      int var5 = -1;
      boolean var21 = false;
      boolean var20 = false;
      boolean var18 = false;
      int var4 = -1;
      int var3 = -1;
      boolean var17 = false;
      boolean var16 = false;
      boolean var15 = false;
      boolean var1 = true;
      int var13 = var0.a();
      int var7 = 0;
      String var30 = null;
      boolean var14 = false;

      while (var7 < var13) {
         int var2;
         int var9;
         int var10;
         int var11;
         int var12;
         boolean var22;
         boolean var23;
         boolean var24;
         boolean var25;
         boolean var26;
         boolean var27;
         boolean var28;
         boolean var29;
         String var40;
         label92: {
            var40 = var0.a(var7);
            String var32 = var0.b(var7);
            if (var40.equalsIgnoreCase("Cache-Control")) {
               if (var30 != null) {
                  var1 = false;
               } else {
                  var30 = var32;
               }
            } else {
               if (!var40.equalsIgnoreCase("Pragma")) {
                  var22 = var14;
                  var2 = var1;
                  var23 = var15;
                  var24 = var16;
                  var25 = var17;
                  var9 = var3;
                  var10 = var4;
                  var26 = var18;
                  var27 = var20;
                  var28 = var21;
                  var11 = var5;
                  var12 = var6;
                  var29 = var19;
                  var40 = var30;
                  break label92;
               }

               var1 = false;
            }

            int var8 = 0;

            while (true) {
               var40 = var30;
               var29 = var19;
               var12 = var6;
               var11 = var5;
               var28 = var21;
               var27 = var20;
               var26 = var18;
               var10 = var4;
               var9 = var3;
               var25 = var17;
               var24 = var16;
               var23 = var15;
               var2 = var1;
               var22 = var14;
               if (var8 >= var32.length()) {
                  break;
               }

               var2 = HttpHeaders.a(var32, var8, "=,;");
               String var33 = var32.substring(var8, var2).trim();
               if (var2 != var32.length() && var32.charAt(var2) != ',' && var32.charAt(var2) != ';') {
                  var8 = HttpHeaders.a(var32, var2 + 1);
                  if (var8 < var32.length() && var32.charAt(var8) == '"') {
                     var2 = HttpHeaders.a(var32, ++var8, "\"");
                     var40 = var32.substring(var8, var2);
                     var2++;
                  } else {
                     var2 = HttpHeaders.a(var32, var8, ",;");
                     var40 = var32.substring(var8, var2).trim();
                  }
               } else {
                  var2++;
                  var40 = null;
               }

               if ("no-cache".equalsIgnoreCase(var33)) {
                  var14 = true;
                  var8 = var2;
               } else if ("no-store".equalsIgnoreCase(var33)) {
                  var19 = true;
                  var8 = var2;
               } else if ("max-age".equalsIgnoreCase(var33)) {
                  var6 = HttpHeaders.b(var40, -1);
                  var8 = var2;
               } else if ("s-maxage".equalsIgnoreCase(var33)) {
                  var5 = HttpHeaders.b(var40, -1);
                  var8 = var2;
               } else if ("private".equalsIgnoreCase(var33)) {
                  var21 = true;
                  var8 = var2;
               } else if ("public".equalsIgnoreCase(var33)) {
                  var20 = true;
                  var8 = var2;
               } else if ("must-revalidate".equalsIgnoreCase(var33)) {
                  var18 = true;
                  var8 = var2;
               } else if ("max-stale".equalsIgnoreCase(var33)) {
                  var4 = HttpHeaders.b(var40, Integer.MAX_VALUE);
                  var8 = var2;
               } else if ("min-fresh".equalsIgnoreCase(var33)) {
                  var3 = HttpHeaders.b(var40, -1);
                  var8 = var2;
               } else if ("only-if-cached".equalsIgnoreCase(var33)) {
                  var17 = true;
                  var8 = var2;
               } else if ("no-transform".equalsIgnoreCase(var33)) {
                  var16 = true;
                  var8 = var2;
               } else {
                  var8 = var2;
                  if ("immutable".equalsIgnoreCase(var33)) {
                     var15 = true;
                     var8 = var2;
                  }
               }
            }
         }

         var7++;
         var14 = var22;
         var30 = var40;
         var19 = var29;
         var6 = var12;
         var5 = var11;
         var21 = var28;
         var20 = var27;
         var18 = var26;
         var4 = var10;
         var3 = var9;
         var17 = var25;
         var16 = var24;
         var15 = var23;
         var1 = (boolean)var2;
      }

      String var34;
      if (!var1) {
         var34 = null;
      } else {
         var34 = var30;
      }

      return new CacheControl(var14, var19, var6, var5, var21, var20, var18, var4, var3, var17, var16, var15, var34);
   }

   private String j() {
      StringBuilder var1 = new StringBuilder();
      if (this.d) {
         var1.append("no-cache, ");
      }

      if (this.e) {
         var1.append("no-store, ");
      }

      if (this.f != -1) {
         var1.append("max-age=").append(this.f).append(", ");
      }

      if (this.g != -1) {
         var1.append("s-maxage=").append(this.g).append(", ");
      }

      if (this.h) {
         var1.append("private, ");
      }

      if (this.i) {
         var1.append("public, ");
      }

      if (this.j) {
         var1.append("must-revalidate, ");
      }

      if (this.k != -1) {
         var1.append("max-stale=").append(this.k).append(", ");
      }

      if (this.l != -1) {
         var1.append("min-fresh=").append(this.l).append(", ");
      }

      if (this.m) {
         var1.append("only-if-cached, ");
      }

      if (this.n) {
         var1.append("no-transform, ");
      }

      if (this.o) {
         var1.append("immutable, ");
      }

      String var2;
      if (var1.length() == 0) {
         var2 = "";
      } else {
         var1.delete(var1.length() - 2, var1.length());
         var2 = var1.toString();
      }

      return var2;
   }

   public boolean a() {
      return this.d;
   }

   public boolean b() {
      return this.e;
   }

   public int c() {
      return this.f;
   }

   public boolean d() {
      return this.h;
   }

   public boolean e() {
      return this.i;
   }

   public boolean f() {
      return this.j;
   }

   public int g() {
      return this.k;
   }

   public int h() {
      return this.l;
   }

   public boolean i() {
      return this.m;
   }

   @Override
   public String toString() {
      String var1 = this.c;
      if (var1 == null) {
         var1 = this.j();
         this.c = var1;
      }

      return var1;
   }

   public static final class Builder {
      boolean a;
      boolean b;
      int c = -1;
      int d = -1;
      int e = -1;
      boolean f;
      boolean g;
      boolean h;

      public CacheControl.Builder a() {
         this.a = true;
         return this;
      }

      public CacheControl.Builder a(int var1, TimeUnit var2) {
         if (var1 < 0) {
            throw new IllegalArgumentException("maxStale < 0: " + var1);
         }

         long var3 = var2.toSeconds(var1);
         if (var3 > 2147483647L) {
            var1 = Integer.MAX_VALUE;
         } else {
            var1 = (int)var3;
         }

         this.d = var1;
         return this;
      }

      public CacheControl.Builder b() {
         this.f = true;
         return this;
      }

      public CacheControl c() {
         return new CacheControl(this);
      }
   }
}
