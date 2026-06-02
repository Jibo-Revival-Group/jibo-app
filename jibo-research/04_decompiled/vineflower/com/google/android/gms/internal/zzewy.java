package com.google.android.gms.internal;

import java.io.IOException;

public final class zzewy extends zzfjm<zzewy> {
   private static volatile zzewy[] g;
   public String a = null;
   public Long b;
   public Long c;
   public zzewz[] d;
   public zzewy[] e;
   public zzexa[] f;
   private Boolean h = null;

   public zzewy() {
      this.b = null;
      this.c = null;
      this.d = zzewz.a();
      this.e = a();
      this.f = zzexa.a();
      this.H = null;
      this.I = -1;
   }

   private static zzewy[] a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/google/android/gms/internal/zzewy.g [Lcom/google/android/gms/internal/zzewy;
      // 03: ifnonnull 1b
      // 06: getstatic com/google/android/gms/internal/zzfjq.b Ljava/lang/Object;
      // 09: astore 0
      // 0a: aload 0
      // 0b: monitorenter
      // 0c: getstatic com/google/android/gms/internal/zzewy.g [Lcom/google/android/gms/internal/zzewy;
      // 0f: ifnonnull 19
      // 12: bipush 0
      // 13: anewarray 2
      // 16: putstatic com/google/android/gms/internal/zzewy.g [Lcom/google/android/gms/internal/zzewy;
      // 19: aload 0
      // 1a: monitorexit
      // 1b: getstatic com/google/android/gms/internal/zzewy.g [Lcom/google/android/gms/internal/zzewy;
      // 1e: areturn
      // 1f: astore 1
      // 20: aload 0
      // 21: monitorexit
      // 22: aload 1
      // 23: athrow
      // try (6 -> 11): 15 null
      // try (11 -> 13): 15 null
      // try (16 -> 18): 15 null
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      byte var3 = 0;
      if (this.a != null) {
         var1.a(1, this.a);
      }

      if (this.h != null) {
         var1.a(2, this.h);
      }

      if (this.b != null) {
         var1.b(4, this.b);
      }

      if (this.c != null) {
         var1.b(5, this.c);
      }

      if (this.d != null && this.d.length > 0) {
         for (int var2 = 0; var2 < this.d.length; var2++) {
            zzewz var4 = this.d[var2];
            if (var4 != null) {
               var1.a(6, var4);
            }
         }
      }

      if (this.e != null && this.e.length > 0) {
         for (int var5 = 0; var5 < this.e.length; var5++) {
            zzewy var7 = this.e[var5];
            if (var7 != null) {
               var1.a(7, var7);
            }
         }
      }

      if (this.f != null && this.f.length > 0) {
         for (int var6 = var3; var6 < this.f.length; var6++) {
            zzexa var8 = this.f[var6];
            if (var8 != null) {
               var1.a(8, var8);
            }
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      byte var4 = 0;
      int var1 = super.b();
      int var2 = var1;
      if (this.a != null) {
         var2 = var1 + zzfjk.b(1, this.a);
      }

      var1 = var2;
      if (this.h != null) {
         this.h;
         var1 = var2 + zzfjk.b(2) + 1;
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1 + zzfjk.d(4, this.b);
      }

      var1 = var2;
      if (this.c != null) {
         var1 = var2 + zzfjk.d(5, this.c);
      }

      var2 = var1;
      if (this.d != null) {
         var2 = var1;
         if (this.d.length > 0) {
            var2 = 0;

            while (var2 < this.d.length) {
               zzewz var5 = this.d[var2];
               int var3 = var1;
               if (var5 != null) {
                  var3 = var1 + zzfjk.b(6, var5);
               }

               var2++;
               var1 = var3;
            }

            var2 = var1;
         }
      }

      var1 = var2;
      if (this.e != null) {
         var1 = var2;
         if (this.e.length > 0) {
            var1 = var2;
            int var14 = 0;

            while (var14 < this.e.length) {
               zzewy var17 = this.e[var14];
               var2 = var1;
               if (var17 != null) {
                  var2 = var1 + zzfjk.b(7, var17);
               }

               var14++;
               var1 = var2;
            }
         }
      }

      int var15 = var1;
      if (this.f != null) {
         var15 = var1;
         if (this.f.length > 0) {
            var2 = var4;

            while (true) {
               var15 = var1;
               if (var2 >= this.f.length) {
                  break;
               }

               zzexa var18 = this.f[var2];
               var15 = var1;
               if (var18 != null) {
                  var15 = var1 + zzfjk.b(8, var18);
               }

               var2++;
               var1 = var15;
            }
         }
      }

      return var15;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = true;
      boolean var2;
      if (var1 == this) {
         var2 = var3;
      } else if (!(var1 instanceof zzewy)) {
         var2 = false;
      } else {
         var1 = var1;
         if (this.a == null) {
            if (var1.a != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.a.equals(var1.a)) {
            var2 = false;
            return var2;
         }

         if (this.h == null) {
            if (var1.h != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.h.equals(var1.h)) {
            var2 = false;
            return var2;
         }

         if (this.b == null) {
            if (var1.b != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.b.equals(var1.b)) {
            var2 = false;
            return var2;
         }

         if (this.c == null) {
            if (var1.c != null) {
               var2 = false;
               return var2;
            }
         } else if (!this.c.equals(var1.c)) {
            var2 = false;
            return var2;
         }

         if (!zzfjq.a(this.d, var1.d)) {
            var2 = false;
         } else if (!zzfjq.a(this.e, var1.e)) {
            var2 = false;
         } else if (!zzfjq.a(this.f, var1.f)) {
            var2 = false;
         } else if (this.H != null && !this.H.b()) {
            var2 = this.H.equals(var1.H);
         } else {
            var2 = var3;
            if (var1.H != null) {
               var2 = var3;
               if (!var1.H.b()) {
                  var2 = false;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      byte var6 = 0;
      int var7 = this.getClass().getName().hashCode();
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a.hashCode();
      }

      int var2;
      if (this.h == null) {
         var2 = 0;
      } else {
         var2 = this.h.hashCode();
      }

      int var3;
      if (this.b == null) {
         var3 = 0;
      } else {
         var3 = this.b.hashCode();
      }

      int var4;
      if (this.c == null) {
         var4 = 0;
      } else {
         var4 = this.c.hashCode();
      }

      int var10 = zzfjq.a(this.d);
      int var9 = zzfjq.a(this.e);
      int var8 = zzfjq.a(this.f);
      int var5 = var6;
      if (this.H != null) {
         if (this.H.b()) {
            var5 = var6;
         } else {
            var5 = this.H.hashCode();
         }
      }

      return ((((var4 + (var3 + (var2 + (var1 + (var7 + 527) * 31) * 31) * 31) * 31) * 31 + var10) * 31 + var9) * 31 + var8) * 31 + var5;
   }
}
