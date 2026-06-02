package android.support.v4.util;

public class SparseArrayCompat<E> implements Cloneable {
   private static final Object a = new Object();
   private boolean b = false;
   private int[] c;
   private Object[] d;
   private int e;

   public SparseArrayCompat() {
      this(10);
   }

   public SparseArrayCompat(int var1) {
      if (var1 == 0) {
         this.c = ContainerHelpers.a;
         this.d = ContainerHelpers.c;
      } else {
         var1 = ContainerHelpers.a(var1);
         this.c = new int[var1];
         this.d = new Object[var1];
      }

      this.e = 0;
   }

   private void d() {
      int var4 = this.e;
      int[] var5 = this.c;
      Object[] var6 = this.d;
      int var1 = 0;
      int var2 = 0;

      while (var1 < var4) {
         Object var7 = var6[var1];
         int var3 = var2;
         if (var7 != a) {
            if (var1 != var2) {
               var5[var2] = var5[var1];
               var6[var2] = var7;
               var6[var1] = null;
            }

            var3 = var2 + 1;
         }

         var1++;
         var2 = var3;
      }

      this.b = false;
      this.e = var2;
   }

   public SparseArrayCompat<E> a() {
      SparseArrayCompat var1;
      try {
         var1 = (SparseArrayCompat)super.clone();
      } catch (CloneNotSupportedException var4) {
         return null;
      }

      try {
         var1.c = (int[])this.c.clone();
         var1.d = (Object[])this.d.clone();
      } catch (CloneNotSupportedException var3) {
      }

      return var1;
   }

   public E a(int var1) {
      return this.a(var1, null);
   }

   public E a(int var1, E var2) {
      var1 = ContainerHelpers.a(this.c, this.e, var1);
      Object var3 = var2;
      if (var1 >= 0) {
         if (this.d[var1] == a) {
            var3 = var2;
         } else {
            var3 = this.d[var1];
         }
      }

      return (E)var3;
   }

   public int b() {
      if (this.b) {
         this.d();
      }

      return this.e;
   }

   public void b(int var1) {
      var1 = ContainerHelpers.a(this.c, this.e, var1);
      if (var1 >= 0 && this.d[var1] != a) {
         this.d[var1] = a;
         this.b = true;
      }
   }

   public void b(int var1, E var2) {
      int var3 = ContainerHelpers.a(this.c, this.e, var1);
      if (var3 >= 0) {
         this.d[var3] = var2;
      } else {
         int var4 = ~var3;
         if (var4 < this.e && this.d[var4] == a) {
            this.c[var4] = var1;
            this.d[var4] = var2;
         } else {
            var3 = var4;
            if (this.b) {
               var3 = var4;
               if (this.e >= this.c.length) {
                  this.d();
                  var3 = ~ContainerHelpers.a(this.c, this.e, var1);
               }
            }

            if (this.e >= this.c.length) {
               var4 = ContainerHelpers.a(this.e + 1);
               int[] var6 = new int[var4];
               Object[] var5 = new Object[var4];
               System.arraycopy(this.c, 0, var6, 0, this.c.length);
               System.arraycopy(this.d, 0, var5, 0, this.d.length);
               this.c = var6;
               this.d = var5;
            }

            if (this.e - var3 != 0) {
               System.arraycopy(this.c, var3, this.c, var3 + 1, this.e - var3);
               System.arraycopy(this.d, var3, this.d, var3 + 1, this.e - var3);
            }

            this.c[var3] = var1;
            this.d[var3] = var2;
            this.e++;
         }
      }
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

   public void c(int var1) {
      this.b(var1);
   }

   public void c(int var1, E var2) {
      if (this.e != 0 && var1 <= this.c[this.e - 1]) {
         this.b(var1, (E)var2);
      } else {
         if (this.b && this.e >= this.c.length) {
            this.d();
         }

         int var3 = this.e;
         if (var3 >= this.c.length) {
            int var4 = ContainerHelpers.a(var3 + 1);
            int[] var5 = new int[var4];
            Object[] var6 = new Object[var4];
            System.arraycopy(this.c, 0, var5, 0, this.c.length);
            System.arraycopy(this.d, 0, var6, 0, this.d.length);
            this.c = var5;
            this.d = var6;
         }

         this.c[var3] = var1;
         this.d[var3] = var2;
         this.e = var3 + 1;
      }
   }

   public int d(int var1) {
      if (this.b) {
         this.d();
      }

      return this.c[var1];
   }

   public E e(int var1) {
      if (this.b) {
         this.d();
      }

      return (E)this.d[var1];
   }

   public int f(int var1) {
      if (this.b) {
         this.d();
      }

      return ContainerHelpers.a(this.c, this.e, var1);
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

            var4.append(this.d(var1));
            var4.append('=');
            Object var3 = this.e(var1);
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
