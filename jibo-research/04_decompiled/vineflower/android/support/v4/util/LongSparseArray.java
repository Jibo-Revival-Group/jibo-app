package android.support.v4.util;

public class LongSparseArray<E> implements Cloneable {
   private static final Object a = new Object();
   private boolean b = false;
   private long[] c;
   private Object[] d;
   private int e;

   public LongSparseArray() {
      this(10);
   }

   public LongSparseArray(int var1) {
      if (var1 == 0) {
         this.c = ContainerHelpers.b;
         this.d = ContainerHelpers.c;
      } else {
         var1 = ContainerHelpers.b(var1);
         this.c = new long[var1];
         this.d = new Object[var1];
      }

      this.e = 0;
   }

   private void d() {
      int var4 = this.e;
      long[] var7 = this.c;
      Object[] var5 = this.d;
      int var1 = 0;
      int var2 = 0;

      while (var1 < var4) {
         Object var6 = var5[var1];
         int var3 = var2;
         if (var6 != a) {
            if (var1 != var2) {
               var7[var2] = var7[var1];
               var5[var2] = var6;
               var5[var1] = null;
            }

            var3 = var2 + 1;
         }

         var1++;
         var2 = var3;
      }

      this.b = false;
      this.e = var2;
   }

   public LongSparseArray<E> a() {
      LongSparseArray var1;
      try {
         var1 = (LongSparseArray)super.clone();
      } catch (CloneNotSupportedException var4) {
         return null;
      }

      try {
         var1.c = (long[])this.c.clone();
         var1.d = (Object[])this.d.clone();
      } catch (CloneNotSupportedException var3) {
      }

      return var1;
   }

   public E a(long var1) {
      return this.a(var1, null);
   }

   public E a(long var1, E var3) {
      int var4 = ContainerHelpers.a(this.c, this.e, var1);
      Object var5 = var3;
      if (var4 >= 0) {
         if (this.d[var4] == a) {
            var5 = var3;
         } else {
            var5 = this.d[var4];
         }
      }

      return (E)var5;
   }

   public void a(int var1) {
      if (this.d[var1] != a) {
         this.d[var1] = a;
         this.b = true;
      }
   }

   public int b() {
      if (this.b) {
         this.d();
      }

      return this.e;
   }

   public long b(int var1) {
      if (this.b) {
         this.d();
      }

      return this.c[var1];
   }

   public void b(long var1) {
      int var3 = ContainerHelpers.a(this.c, this.e, var1);
      if (var3 >= 0 && this.d[var3] != a) {
         this.d[var3] = a;
         this.b = true;
      }
   }

   public void b(long var1, E var3) {
      int var4 = ContainerHelpers.a(this.c, this.e, var1);
      if (var4 >= 0) {
         this.d[var4] = var3;
      } else {
         int var5 = ~var4;
         if (var5 < this.e && this.d[var5] == a) {
            this.c[var5] = var1;
            this.d[var5] = var3;
         } else {
            var4 = var5;
            if (this.b) {
               var4 = var5;
               if (this.e >= this.c.length) {
                  this.d();
                  var4 = ~ContainerHelpers.a(this.c, this.e, var1);
               }
            }

            if (this.e >= this.c.length) {
               var5 = ContainerHelpers.b(this.e + 1);
               long[] var6 = new long[var5];
               Object[] var7 = new Object[var5];
               System.arraycopy(this.c, 0, var6, 0, this.c.length);
               System.arraycopy(this.d, 0, var7, 0, this.d.length);
               this.c = var6;
               this.d = var7;
            }

            if (this.e - var4 != 0) {
               System.arraycopy(this.c, var4, this.c, var4 + 1, this.e - var4);
               System.arraycopy(this.d, var4, this.d, var4 + 1, this.e - var4);
            }

            this.c[var4] = var1;
            this.d[var4] = var3;
            this.e++;
         }
      }
   }

   public int c(long var1) {
      if (this.b) {
         this.d();
      }

      return ContainerHelpers.a(this.c, this.e, var1);
   }

   public E c(int var1) {
      if (this.b) {
         this.d();
      }

      return (E)this.d[var1];
   }

   public void c() {
      int var2 = this.e;
      Object[] var3 = this.d;

      for (int var1 = 0; var1 < var2; var1++) {
         var3[var1] = null;
      }

      this.e = 0;
      this.b = false;
   }

   @Override
   public String toString() {
      String var2;
      if (this.b() <= 0) {
         var2 = "{}";
      } else {
         StringBuilder var4 = new StringBuilder(this.e * 28);
         var4.append('{');

         for (int var1 = 0; var1 < this.e; var1++) {
            if (var1 > 0) {
               var4.append(", ");
            }

            var4.append(this.b(var1));
            var4.append('=');
            Object var3 = this.c(var1);
            if (var3 != this) {
               var4.append(var3);
            } else {
               var4.append("(this Map)");
            }
         }

         var4.append('}');
         var2 = var4.toString();
      }

      return var2;
   }
}
