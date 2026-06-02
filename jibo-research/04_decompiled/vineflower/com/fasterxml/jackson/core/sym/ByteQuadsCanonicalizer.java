package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteQuadsCanonicalizer {
   protected final ByteQuadsCanonicalizer a;
   protected final AtomicReference<ByteQuadsCanonicalizer.TableInfo> b;
   protected boolean c;
   protected final boolean d;
   protected int[] e;
   protected int f;
   protected int g;
   protected int h;
   protected int i;
   protected int j;
   protected String[] k;
   protected int l;
   protected int m;
   private final int n;
   private transient boolean o;
   private boolean p;

   private ByteQuadsCanonicalizer(int var1, boolean var2, int var3, boolean var4) {
      byte var5 = 16;
      super();
      this.a = null;
      this.n = var3;
      this.c = var2;
      this.d = var4;
      if (var1 < 16) {
         var3 = 16;
      } else {
         var3 = var1;
         if ((var1 - 1 & var1) != 0) {
            var3 = var5;

            while (var3 < var1) {
               var3 += var3;
            }
         }
      }

      this.b = new AtomicReference<>(ByteQuadsCanonicalizer.TableInfo.a(var3));
   }

   private ByteQuadsCanonicalizer(ByteQuadsCanonicalizer var1, boolean var2, int var3, boolean var4, ByteQuadsCanonicalizer.TableInfo var5) {
      this.a = var1;
      this.n = var3;
      this.c = var2;
      this.d = var4;
      this.b = null;
      this.j = var5.b;
      this.f = var5.a;
      this.g = this.f << 2;
      this.h = this.g + (this.g >> 1);
      this.i = var5.c;
      this.e = var5.d;
      this.k = var5.e;
      this.l = var5.f;
      this.m = var5.g;
      this.o = false;
      this.p = true;
   }

   public static ByteQuadsCanonicalizer a() {
      long var1 = System.currentTimeMillis();
      int var0 = (int)var1;
      return a((int)(var1 >>> 32) + var0 | 1);
   }

   protected static ByteQuadsCanonicalizer a(int var0) {
      return new ByteQuadsCanonicalizer(64, true, var0, true);
   }

   private String a(int var1, int var2, int var3, int var4) {
      int var5 = this.h + (var1 >> this.i + 2 << this.i);
      int[] var8 = this.e;
      int var6 = this.i;
      var1 = var5;

      while (true) {
         if (var1 >= (1 << var6) + var5) {
            for (int var10 = this.m(); var10 < this.l; var10 += 4) {
               if (var2 == var8[var10] && var3 == var8[var10 + 1] && var4 == var8[var10 + 2] && 3 == var8[var10 + 3]) {
                  String var12 = this.k[var10 >> 2];
                  return var12;
               }
            }

            var11 = null;
            break;
         }

         int var7 = var8[var1 + 3];
         if (var2 == var8[var1] && var3 == var8[var1 + 1] && var4 == var8[var1 + 2] && 3 == var7) {
            var11 = this.k[var1 >> 2];
            break;
         }

         if (var7 == 0) {
            var11 = null;
            break;
         }

         var1 += 4;
      }

      return var11;
   }

   private String a(int var1, int var2, int[] var3, int var4) {
      int var5 = this.h + (var1 >> this.i + 2 << this.i);
      int[] var8 = this.e;
      int var6 = this.i;
      var1 = var5;

      while (true) {
         if (var1 >= (1 << var6) + var5) {
            for (int var10 = this.m(); var10 < this.l; var10 += 4) {
               if (var2 == var8[var10] && var4 == var8[var10 + 3] && this.a(var3, var4, var8[var10 + 1])) {
                  String var12 = this.k[var10 >> 2];
                  return var12;
               }
            }

            var11 = null;
            break;
         }

         int var7 = var8[var1 + 3];
         if (var2 == var8[var1] && var4 == var7 && this.a(var3, var4, var8[var1 + 1])) {
            var11 = this.k[var1 >> 2];
            break;
         }

         if (var7 == 0) {
            var11 = null;
            break;
         }

         var1 += 4;
      }

      return var11;
   }

   private void a(ByteQuadsCanonicalizer.TableInfo var1) {
      int var2 = var1.b;
      ByteQuadsCanonicalizer.TableInfo var3 = this.b.get();
      if (var2 != var3.b) {
         if (var2 > 6000) {
            var1 = ByteQuadsCanonicalizer.TableInfo.a(64);
         }

         this.b.compareAndSet(var3, var1);
      }
   }

   private void a(boolean var1) {
      this.j = 0;
      this.l = this.m();
      this.m = this.f << 3;
      if (var1) {
         Arrays.fill(this.e, 0);
         Arrays.fill(this.k, null);
      }
   }

   private boolean a(int[] var1, int var2, int var3) {
      boolean var7;
      int[] var8;
      label63: {
         label56: {
            label57: {
               var7 = false;
               var8 = this.e;
               switch (var2) {
                  case 4:
                     var2 = 0;
                     break label63;
                  case 5:
                     var2 = 0;
                     break label56;
                  case 6:
                     var2 = 0;
                     break label57;
                  case 7:
                     var2 = 0;
                     break;
                  case 8:
                     boolean var6 = var7;
                     if (var1[0] != var8[var3]) {
                        return var6;
                     }

                     var3++;
                     var2 = 1;
                     break;
                  default:
                     return this.b(var1, var2, var3);
               }

               boolean var20 = var7;
               if (var1[var2] != var8[var3]) {
                  return var20;
               }

               var3++;
               var2++;
            }

            boolean var21 = var7;
            if (var1[var2] != var8[var3]) {
               return var21;
            }

            var3++;
            var2++;
         }

         boolean var22 = var7;
         if (var1[var2] != var8[var3]) {
            return var22;
         }

         var3++;
         var2++;
      }

      int var5 = var2 + 1;
      var2 = var1[var2];
      int var4 = var3 + 1;
      boolean var23 = var7;
      if (var2 == var8[var3]) {
         var3 = var5 + 1;
         var5 = var1[var5];
         var2 = var4 + 1;
         var23 = var7;
         if (var5 == var8[var4]) {
            var4 = var3 + 1;
            var5 = var1[var3];
            var3 = var2 + 1;
            var23 = var7;
            if (var5 == var8[var2]) {
               var23 = var7;
               if (var1[var4] == var8[var3]) {
                  var23 = true;
               }
            }
         }
      }

      return var23;
   }

   private boolean b(int[] var1, int var2, int var3) {
      boolean var6 = false;
      int var5 = 0;
      int var4 = var3;
      var3 = var5;

      while (true) {
         var5 = var3 + 1;
         if (var1[var3] != this.e[var4]) {
            break;
         }

         if (var5 >= var2) {
            var6 = true;
            break;
         }

         var4++;
         var3 = var5;
      }

      return var6;
   }

   private int c(int[] var1, int var2) {
      int var3 = this.m;
      if (var3 + var2 > this.e.length) {
         int var6 = this.e.length;
         int var5 = Math.min(4096, this.f);
         int var4 = this.e.length;
         var5 = Math.max(var3 + var2 - var6, var5);
         this.e = Arrays.copyOf(this.e, var5 + var4);
      }

      System.arraycopy(var1, 0, this.e, var3, var2);
      this.m += var2;
      return var3;
   }

   private String c(int var1, int var2) {
      int var3 = this.h + (var1 >> this.i + 2 << this.i);
      int[] var6 = this.e;
      int var4 = this.i;
      var1 = var3;

      while (true) {
         if (var1 >= (1 << var4) + var3) {
            for (int var8 = this.m(); var8 < this.l; var8 += 4) {
               if (var2 == var6[var8] && 1 == var6[var8 + 3]) {
                  String var10 = this.k[var8 >> 2];
                  return var10;
               }
            }

            var9 = null;
            break;
         }

         int var5 = var6[var1 + 3];
         if (var2 == var6[var1] && 1 == var5) {
            var9 = this.k[var1 >> 2];
            break;
         }

         if (var5 == 0) {
            var9 = null;
            break;
         }

         var1 += 4;
      }

      return var9;
   }

   private String c(int var1, int var2, int var3) {
      int var4 = this.h + (var1 >> this.i + 2 << this.i);
      int[] var7 = this.e;
      int var5 = this.i;
      var1 = var4;

      while (true) {
         if (var1 >= (1 << var5) + var4) {
            for (int var9 = this.m(); var9 < this.l; var9 += 4) {
               if (var2 == var7[var9] && var3 == var7[var9 + 1] && 2 == var7[var9 + 3]) {
                  String var11 = this.k[var9 >> 2];
                  return var11;
               }
            }

            var10 = null;
            break;
         }

         int var6 = var7[var1 + 3];
         if (var2 == var7[var1] && var3 == var7[var1 + 1] && 2 == var6) {
            var10 = this.k[var1 >> 2];
            break;
         }

         if (var6 == 0) {
            var10 = null;
            break;
         }

         var1 += 4;
      }

      return var10;
   }

   static int e(int var0) {
      var0 >>= 2;
      byte var2;
      if (var0 < 64) {
         var2 = 4;
      } else if (var0 <= 256) {
         var2 = 5;
      } else if (var0 <= 1024) {
         var2 = 6;
      } else {
         var2 = 7;
      }

      return var2;
   }

   private final int f(int var1) {
      return (this.f - 1 & var1) << 2;
   }

   private int g(int var1) {
      var1 = this.f(var1);
      int[] var5 = this.e;
      if (var5[var1 + 3] != 0) {
         int var2 = this.g + (var1 >> 3 << 2);
         if (var5[var2 + 3] == 0) {
            var1 = var2;
         } else {
            var2 = this.h;
            int var3 = (var1 >> this.i + 2 << this.i) + var2;
            int var4 = this.i;
            var1 = var3;

            while (true) {
               var2 = var1;
               if (var2 >= (1 << var4) + var3) {
                  var2 = this.l;
                  this.l += 4;
                  var3 = this.f;
                  var1 = var2;
                  if (this.l >= var3 << 3) {
                     if (this.d) {
                        this.i();
                     }

                     this.o = true;
                     var1 = var2;
                  }
                  break;
               }

               var1 = var2;
               if (var5[var2 + 3] == 0) {
                  break;
               }

               var1 = var2 + 4;
            }
         }
      }

      return var1;
   }

   private void j() {
      if (this.j > this.f >> 1 && (this.l - this.m() >> 2 > this.j + 1 >> 7 || this.j > this.f * 0.8)) {
         this.o = true;
      }
   }

   private void k() {
      if (this.p) {
         this.e = Arrays.copyOf(this.e, this.e.length);
         this.k = Arrays.copyOf(this.k, this.k.length);
         this.p = false;
         this.j();
      }

      if (this.o) {
         this.l();
      }
   }

   private void l() {
      this.o = false;
      this.p = false;
      int[] var9 = this.e;
      String[] var8 = this.k;
      int var2 = this.f;
      int var4 = this.j;
      int var1 = var2 + var2;
      int var3 = this.l;
      if (var1 > 65536) {
         this.a(true);
      } else {
         this.e = new int[(var2 << 3) + var9.length];
         this.f = var1;
         this.g = var1 << 2;
         this.h = this.g + (this.g >> 1);
         this.i = e(var1);
         this.k = new String[var8.length << 1];
         this.a(false);
         int[] var6 = new int[16];
         byte var11 = 0;
         var2 = 0;

         while (var11 < var3) {
            int var5 = var9[var11 + 3];
            if (var5 != 0) {
               var2++;
               String var10 = var8[var11 >> 2];
               switch (var5) {
                  case 1:
                     var6[0] = var9[var11];
                     this.a(var10, var6, 1);
                     break;
                  case 2:
                     var6[0] = var9[var11];
                     var6[1] = var9[var11 + 1];
                     this.a(var10, var6, 2);
                     break;
                  case 3:
                     var6[0] = var9[var11];
                     var6[1] = var9[var11 + 1];
                     var6[2] = var9[var11 + 2];
                     this.a(var10, var6, 3);
                     break;
                  default:
                     int[] var7 = var6;
                     if (var5 > var6.length) {
                        var7 = new int[var5];
                     }

                     System.arraycopy(var9, var9[var11 + 1], var7, 0, var5);
                     this.a(var10, var7, var5);
                     var6 = var7;
               }
            }

            var11 += 4;
         }

         if (var2 != var4) {
            throw new IllegalStateException("Failed rehash(): old count=" + var4 + ", copyCount=" + var2);
         }
      }
   }

   private final int m() {
      int var1 = this.f;
      return (var1 << 3) - var1;
   }

   public String a(int var1, int var2) {
      Object var7 = null;
      int var3 = this.f(this.b(var1, var2));
      int[] var8 = this.e;
      int var4 = var8[var3 + 3];
      if (var4 == 2) {
         if (var1 == var8[var3] && var2 == var8[var3 + 1]) {
            return this.k[var3 >> 2];
         }
      } else {
         Object var6 = var7;
         if (var4 == 0) {
            return (String)var6;
         }
      }

      int var5 = this.g + (var3 >> 3 << 2);
      var4 = var8[var5 + 3];
      if (var4 == 2) {
         if (var1 == var8[var5] && var2 == var8[var5 + 1]) {
            String var10 = this.k[var5 >> 2];
            return var10;
         }
      } else {
         Object var11 = var7;
         if (var4 == 0) {
            return (String)var11;
         }
      }

      return this.c(var3, var1, var2);
   }

   public String a(int var1, int var2, int var3) {
      Object var8 = null;
      int var4 = this.f(this.b(var1, var2, var3));
      int[] var9 = this.e;
      int var5 = var9[var4 + 3];
      if (var5 == 3) {
         if (var1 == var9[var4] && var9[var4 + 1] == var2 && var9[var4 + 2] == var3) {
            return this.k[var4 >> 2];
         }
      } else {
         Object var7 = var8;
         if (var5 == 0) {
            return (String)var7;
         }
      }

      int var6 = this.g + (var4 >> 3 << 2);
      var5 = var9[var6 + 3];
      if (var5 == 3) {
         if (var1 == var9[var6] && var9[var6 + 1] == var2 && var9[var6 + 2] == var3) {
            String var11 = this.k[var6 >> 2];
            return var11;
         }
      } else {
         Object var12 = var8;
         if (var5 == 0) {
            return (String)var12;
         }
      }

      return this.a(var4, var1, var2, var3);
   }

   public String a(String var1, int[] var2, int var3) {
      this.k();
      String var6 = var1;
      if (this.c) {
         var6 = InternCache.a.a(var1);
      }

      switch (var3) {
         case 1:
            var3 = this.g(this.d(var2[0]));
            this.e[var3] = var2[0];
            this.e[var3 + 3] = 1;
            break;
         case 2:
            var3 = this.g(this.b(var2[0], var2[1]));
            this.e[var3] = var2[0];
            this.e[var3 + 1] = var2[1];
            this.e[var3 + 3] = 2;
            break;
         case 3:
            var3 = this.g(this.b(var2[0], var2[1], var2[2]));
            this.e[var3] = var2[0];
            this.e[var3 + 1] = var2[1];
            this.e[var3 + 2] = var2[2];
            this.e[var3 + 3] = 3;
            break;
         default:
            int var5 = this.b(var2, var3);
            int var4 = this.g(var5);
            this.e[var4] = var5;
            var5 = this.c(var2, var3);
            this.e[var4 + 1] = var5;
            this.e[var4 + 3] = var3;
            var3 = var4;
      }

      this.k[var3 >> 2] = var6;
      this.j++;
      this.j();
      return var6;
   }

   public String a(int[] var1, int var2) {
      Object var9 = null;
      String var8;
      if (var2 < 4) {
         if (var2 == 3) {
            var8 = this.a(var1[0], var1[1], var1[2]);
         } else if (var2 == 2) {
            var8 = this.a(var1[0], var1[1]);
         } else {
            var8 = this.c(var1[0]);
         }
      } else {
         int var4 = this.b(var1, var2);
         int var5 = this.f(var4);
         int[] var10 = this.e;
         int var3 = var10[var5 + 3];
         if (var4 == var10[var5] && var3 == var2 && this.a(var1, var2, var10[var5 + 1])) {
            var8 = this.k[var5 >> 2];
         } else {
            var8 = (String)var9;
            if (var3 != 0) {
               int var7 = this.g + (var5 >> 3 << 2);
               int var6 = var10[var7 + 3];
               if (var4 == var10[var7] && var6 == var2 && this.a(var1, var2, var10[var7 + 1])) {
                  var8 = this.k[var7 >> 2];
               } else {
                  var8 = (String)var9;
                  if (var3 != 0) {
                     var8 = this.a(var5, var4, var1, var2);
                  }
               }
            }
         }
      }

      return var8;
   }

   public int b(int var1, int var2) {
      var1 = (var1 >>> 15) + var1;
      var1 = (var1 ^ var1 >>> 9) + var2 * 33 ^ this.n;
      var1 += var1 >>> 16;
      var1 ^= var1 >>> 4;
      return var1 + (var1 << 3);
   }

   public int b(int var1, int var2, int var3) {
      var1 = this.n ^ var1;
      var1 = ((var1 + (var1 >>> 9)) * 31 + var2) * 33;
      var1 = var1 + (var1 >>> 15) ^ var3;
      var1 += var1 >>> 4;
      var1 += var1 >>> 15;
      return var1 ^ var1 << 9;
   }

   public int b(int[] var1, int var2) {
      if (var2 < 4) {
         throw new IllegalArgumentException();
      }

      int var3 = var1[0] ^ this.n;
      var3 = var3 + (var3 >>> 9) + var1[1];
      var3 = (var3 + (var3 >>> 15)) * 33 ^ var1[2];
      int var4 = (var3 >>> 4) + var3;

      for (int var10 = 3; var10 < var2; var10++) {
         int var5 = var1[var10];
         var4 += var5 ^ var5 >> 21;
      }

      var2 = 65599 * var4;
      var2 += var2 >>> 19;
      return var2 ^ var2 << 5;
   }

   public ByteQuadsCanonicalizer b(int var1) {
      return new ByteQuadsCanonicalizer(
         this, JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(var1), this.n, JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(var1), this.b.get()
      );
   }

   public void b() {
      if (this.a != null && this.c()) {
         this.a.a(new ByteQuadsCanonicalizer.TableInfo(this));
         this.p = true;
      }
   }

   public String c(int var1) {
      Object var6 = null;
      int var2 = this.f(this.d(var1));
      int[] var7 = this.e;
      int var3 = var7[var2 + 3];
      if (var3 == 1) {
         if (var7[var2] == var1) {
            return this.k[var2 >> 2];
         }
      } else {
         Object var5 = var6;
         if (var3 == 0) {
            return (String)var5;
         }
      }

      int var4 = this.g + (var2 >> 3 << 2);
      var3 = var7[var4 + 3];
      if (var3 == 1) {
         if (var7[var4] == var1) {
            String var9 = this.k[var4 >> 2];
            return var9;
         }
      } else {
         Object var10 = var6;
         if (var3 == 0) {
            return (String)var10;
         }
      }

      return this.c(var2, var1);
   }

   public boolean c() {
      boolean var1;
      if (!this.p) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public int d() {
      int var4 = this.g;
      int var3 = 0;
      byte var1 = 3;

      while (var1 < var4) {
         int var2 = var3;
         if (this.e[var1] != 0) {
            var2 = var3 + 1;
         }

         var1 += 4;
         var3 = var2;
      }

      return var3;
   }

   public int d(int var1) {
      var1 = this.n ^ var1;
      var1 += var1 >>> 16;
      var1 ^= var1 << 3;
      return var1 + (var1 >>> 12);
   }

   public int e() {
      int var1 = this.g;
      int var4 = this.h;
      int var2 = 0;
      var1 += 3;

      while (var1 < var4) {
         int var3 = var2;
         if (this.e[var1] != 0) {
            var3 = var2 + 1;
         }

         var1 += 4;
         var2 = var3;
      }

      return var2;
   }

   public int f() {
      int var4 = this.h + 3;
      int var5 = this.f;
      int var3 = 0;
      int var1 = var4;

      while (var1 < var5 + var4) {
         int var2 = var3;
         if (this.e[var1] != 0) {
            var2 = var3 + 1;
         }

         var1 += 4;
         var3 = var2;
      }

      return var3;
   }

   public int g() {
      return this.l - this.m() >> 2;
   }

   public int h() {
      int var4 = this.f;
      int var3 = 0;
      byte var1 = 3;

      while (var1 < var4 << 3) {
         int var2 = var3;
         if (this.e[var1] != 0) {
            var2 = var3 + 1;
         }

         var1 += 4;
         var3 = var2;
      }

      return var3;
   }

   protected void i() {
      if (this.f > 1024) {
         throw new IllegalStateException(
            "Spill-over slots in symbol table with "
               + this.j
               + " entries, hash area of "
               + this.f
               + " slots is now full (all "
               + (this.f >> 3)
               + " slots -- suspect a DoS attack based on hash collisions."
               + " You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`"
         );
      }
   }

   @Override
   public String toString() {
      int var3 = this.d();
      int var5 = this.e();
      int var2 = this.f();
      int var1 = this.g();
      int var4 = this.h();
      return String.format(
         "[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]",
         this.getClass().getName(),
         this.j,
         this.f,
         var3,
         var5,
         var2,
         var1,
         var4,
         var3 + var5 + var2 + var1,
         var4
      );
   }

   private static final class TableInfo {
      public final int a;
      public final int b;
      public final int c;
      public final int[] d;
      public final String[] e;
      public final int f;
      public final int g;

      public TableInfo(int var1, int var2, int var3, int[] var4, String[] var5, int var6, int var7) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
      }

      public TableInfo(ByteQuadsCanonicalizer var1) {
         this.a = var1.f;
         this.b = var1.j;
         this.c = var1.i;
         this.d = var1.e;
         this.e = var1.k;
         this.f = var1.l;
         this.g = var1.m;
      }

      public static ByteQuadsCanonicalizer.TableInfo a(int var0) {
         int var1 = var0 << 3;
         return new ByteQuadsCanonicalizer.TableInfo(var0, 0, ByteQuadsCanonicalizer.e(var0), new int[var1], new String[var0 << 1], var1 - var0, var1);
      }
   }
}
