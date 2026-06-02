package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class zzfjp implements Cloneable {
   private zzfjn<?, ?> a;
   private Object b;
   private List<zzfju> c = new ArrayList<>();

   private final byte[] b() throws IOException {
      byte[] var1 = new byte[this.a()];
      this.a(zzfjk.a(var1));
      return var1;
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private zzfjp c() {
      zzfjp var2 = new zzfjp();

      label154: {
         try {
            var2.a = this.a;
            if (this.c == null) {
               var2.c = null;
               break label154;
            }
         } catch (CloneNotSupportedException var18) {
            throw new AssertionError(var18);
         }

         try {
            var2.c.addAll(this.c);
         } catch (CloneNotSupportedException var6) {
            throw new AssertionError(var6);
         }
      }

      label155: {
         try {
            if (this.b == null) {
               break label155;
            }

            if (this.b instanceof zzfjs) {
               var2.b = (zzfjs)((zzfjs)this.b).clone();
               break label155;
            }
         } catch (CloneNotSupportedException var17) {
            throw new AssertionError(var17);
         }

         try {
            if (this.b instanceof byte[]) {
               var2.b = ((byte[])this.b).clone();
               break label155;
            }
         } catch (CloneNotSupportedException var16) {
            throw new AssertionError(var16);
         }

         label157: {
            byte[][] var3;
            byte[][] var4;
            try {
               if (!(this.b instanceof byte[][])) {
                  break label157;
               }

               var3 = (byte[][])this.b;
               var4 = new byte[var3.length][];
               var2.b = var4;
            } catch (CloneNotSupportedException var15) {
               throw new AssertionError(var15);
            }

            int var1 = 0;

            while (true) {
               try {
                  if (var1 >= var3.length) {
                     break label155;
                  }

                  var4[var1] = (byte[])var3[var1].clone();
               } catch (CloneNotSupportedException var14) {
                  throw new AssertionError(var14);
               }

               var1++;
            }
         }

         try {
            if (this.b instanceof boolean[]) {
               var2.b = ((boolean[])this.b).clone();
               break label155;
            }
         } catch (CloneNotSupportedException var13) {
            throw new AssertionError(var13);
         }

         try {
            if (this.b instanceof int[]) {
               var2.b = ((int[])this.b).clone();
               break label155;
            }
         } catch (CloneNotSupportedException var12) {
            throw new AssertionError(var12);
         }

         try {
            if (this.b instanceof long[]) {
               var2.b = ((long[])this.b).clone();
               break label155;
            }
         } catch (CloneNotSupportedException var11) {
            throw new AssertionError(var11);
         }

         try {
            if (this.b instanceof float[]) {
               var2.b = ((float[])this.b).clone();
               break label155;
            }
         } catch (CloneNotSupportedException var10) {
            throw new AssertionError(var10);
         }

         try {
            if (this.b instanceof double[]) {
               var2.b = ((double[])this.b).clone();
               break label155;
            }
         } catch (CloneNotSupportedException var9) {
            throw new AssertionError(var9);
         }

         zzfjs[] var20;
         zzfjs[] var21;
         try {
            if (!(this.b instanceof zzfjs[])) {
               break label155;
            }

            var21 = (zzfjs[])this.b;
            var20 = new zzfjs[var21.length];
            var2.b = var20;
         } catch (CloneNotSupportedException var8) {
            throw new AssertionError(var8);
         }

         int var19 = 0;

         while (true) {
            try {
               if (var19 >= var21.length) {
                  break;
               }

               var20[var19] = (zzfjs)var21[var19].clone();
            } catch (CloneNotSupportedException var7) {
               throw new AssertionError(var7);
            }

            var19++;
         }
      }

      try {
         return var2;
      } catch (CloneNotSupportedException var5) {
         throw new AssertionError(var5);
      }
   }

   final int a() {
      int var1 = 0;
      int var2;
      if (this.b != null) {
         zzfjn var6 = this.a;
         Object var5 = this.b;
         if (var6.c) {
            int var4 = Array.getLength(var5);
            int var3 = 0;

            while (true) {
               var2 = var1;
               if (var3 >= var4) {
                  break;
               }

               var2 = var1;
               if (Array.get(var5, var3) != null) {
                  var2 = var1 + var6.a(Array.get(var5, var3));
               }

               var3++;
               var1 = var2;
            }
         } else {
            var2 = var6.a(var5);
         }
      } else {
         Iterator var10 = this.c.iterator();
         var1 = 0;

         while (var10.hasNext()) {
            zzfju var11 = (zzfju)var10.next();
            var2 = zzfjk.d(var11.a);
            var1 += var11.b.length + var2 + 0;
         }

         var2 = var1;
      }

      return var2;
   }

   final void a(zzfjk var1) throws IOException {
      if (this.b != null) {
         zzfjn var6 = this.a;
         Object var4 = this.b;
         if (var6.c) {
            int var3 = Array.getLength(var4);

            for (int var2 = 0; var2 < var3; var2++) {
               Object var5 = Array.get(var4, var2);
               if (var5 != null) {
                  var6.a(var5, var1);
               }
            }
         } else {
            var6.a(var4, var1);
         }
      } else {
         for (zzfju var7 : this.c) {
            var1.c(var7.a);
            var1.c(var7.b);
         }
      }
   }

   final void a(zzfju var1) {
      this.c.add(var1);
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 instanceof zzfjp) {
            var1 = var1;
            if (this.b != null && var1.b != null) {
               var2 = var3;
               if (this.a == var1.a) {
                  if (!this.a.a.isArray()) {
                     var2 = this.b.equals(var1.b);
                  } else if (this.b instanceof byte[]) {
                     var2 = Arrays.equals((byte[])this.b, (byte[])var1.b);
                  } else if (this.b instanceof int[]) {
                     var2 = Arrays.equals((int[])this.b, (int[])var1.b);
                  } else if (this.b instanceof long[]) {
                     var2 = Arrays.equals((long[])this.b, (long[])var1.b);
                  } else if (this.b instanceof float[]) {
                     var2 = Arrays.equals((float[])this.b, (float[])var1.b);
                  } else if (this.b instanceof double[]) {
                     var2 = Arrays.equals((double[])this.b, (double[])var1.b);
                  } else if (this.b instanceof boolean[]) {
                     var2 = Arrays.equals((boolean[])this.b, (boolean[])var1.b);
                  } else {
                     var2 = Arrays.deepEquals((Object[])this.b, (Object[])var1.b);
                  }
               }
            } else if (this.c != null && var1.c != null) {
               var2 = this.c.equals(var1.c);
            } else {
               try {
                  var2 = Arrays.equals(this.b(), var1.b());
               } catch (IOException var4) {
                  throw new IllegalStateException(var4);
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      int var1;
      try {
         var1 = Arrays.hashCode(this.b());
      } catch (IOException var3) {
         throw new IllegalStateException(var3);
      }

      return var1 + 527;
   }
}
