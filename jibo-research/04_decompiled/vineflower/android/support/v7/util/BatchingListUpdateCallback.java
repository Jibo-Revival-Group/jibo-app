package android.support.v7.util;

public class BatchingListUpdateCallback implements ListUpdateCallback {
   final ListUpdateCallback a;
   int b = 0;
   int c = -1;
   int d = -1;
   Object e = null;

   public BatchingListUpdateCallback(ListUpdateCallback var1) {
      this.a = var1;
   }

   public void a() {
      if (this.b != 0) {
         switch (this.b) {
            case 1:
               this.a.a(this.c, this.d);
               break;
            case 2:
               this.a.b(this.c, this.d);
               break;
            case 3:
               this.a.a(this.c, this.d, this.e);
         }

         this.e = null;
         this.b = 0;
      }
   }

   @Override
   public void a(int var1, int var2) {
      if (this.b == 1 && var1 >= this.c && var1 <= this.c + this.d) {
         this.d += var2;
         this.c = Math.min(var1, this.c);
      } else {
         this.a();
         this.c = var1;
         this.d = var2;
         this.b = 1;
      }
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      if (this.b == 3 && var1 <= this.c + this.d && var1 + var2 >= this.c && this.e == var3) {
         int var5 = this.c;
         int var4 = this.d;
         this.c = Math.min(var1, this.c);
         this.d = Math.max(var5 + var4, var1 + var2) - this.c;
      } else {
         this.a();
         this.c = var1;
         this.d = var2;
         this.e = var3;
         this.b = 3;
      }
   }

   @Override
   public void b(int var1, int var2) {
      if (this.b == 2 && this.c >= var1 && this.c <= var1 + var2) {
         this.d += var2;
         this.c = var1;
      } else {
         this.a();
         this.c = var1;
         this.d = var2;
         this.b = 2;
      }
   }

   @Override
   public void c(int var1, int var2) {
      this.a();
      this.a.c(var1, var2);
   }
}
