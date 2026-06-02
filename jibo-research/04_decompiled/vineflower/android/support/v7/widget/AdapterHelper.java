package android.support.v7.widget;

import android.support.v4.util.Pools;
import java.util.ArrayList;
import java.util.List;

class AdapterHelper implements OpReorderer.Callback {
   final ArrayList<AdapterHelper.UpdateOp> a;
   final ArrayList<AdapterHelper.UpdateOp> b;
   final AdapterHelper.Callback c;
   Runnable d;
   final boolean e;
   final OpReorderer f;
   private Pools.Pool<AdapterHelper.UpdateOp> g = new Pools.SimplePool<>(30);
   private int h;

   AdapterHelper(AdapterHelper.Callback var1) {
      this(var1, false);
   }

   AdapterHelper(AdapterHelper.Callback var1, boolean var2) {
      this.a = new ArrayList<>();
      this.b = new ArrayList<>();
      this.h = 0;
      this.c = var1;
      this.e = var2;
      this.f = new OpReorderer(this);
   }

   private void b(AdapterHelper.UpdateOp var1) {
      this.g(var1);
   }

   private void c(AdapterHelper.UpdateOp var1) {
      int var8 = var1.b;
      int var4 = var1.b + var1.d;
      byte var3 = -1;
      int var2 = var1.b;
      int var6 = 0;

      while (var2 < var4) {
         boolean var5;
         if (this.c.a(var2) == null && !this.d(var2)) {
            boolean var11;
            if (var3 == 1) {
               this.g(this.a(2, var8, var6, null));
               var11 = true;
            } else {
               var11 = false;
            }

            byte var7 = 0;
            var5 = var11;
            var3 = var7;
         } else {
            if (var3 == 0) {
               this.e(this.a(2, var8, var6, null));
               var5 = 1;
            } else {
               var5 = 0;
            }

            var3 = 1;
         }

         if (var5) {
            var5 = var2 - var6;
            var2 = var4 - var6;
            var4 = 1;
         } else {
            var6++;
            var5 = var2;
            var2 = var4;
            var4 = var6;
         }

         var6 = var4;
         var4 = var2;
         var2 = var5 + 1;
      }

      AdapterHelper.UpdateOp var9 = var1;
      if (var6 != var1.d) {
         this.a(var1);
         var9 = this.a(2, var8, var6, null);
      }

      if (var3 == 0) {
         this.e(var9);
      } else {
         this.g(var9);
      }
   }

   private int d(int var1, int var2) {
      int var4 = this.b.size() - 1;

      while (var4 >= 0) {
         AdapterHelper.UpdateOp var6 = this.b.get(var4);
         int var8;
         if (var6.a == 8) {
            int var5;
            if (var6.b < var6.d) {
               var8 = var6.b;
               var5 = var6.d;
            } else {
               var8 = var6.d;
               var5 = var6.b;
            }

            if (var1 >= var8 && var1 <= var5) {
               if (var8 == var6.b) {
                  if (var2 == 1) {
                     var6.d++;
                  } else if (var2 == 2) {
                     var6.d--;
                  }

                  var1++;
               } else {
                  if (var2 == 1) {
                     var6.b++;
                  } else if (var2 == 2) {
                     var6.b--;
                  }

                  var1--;
               }
            } else if (var1 < var6.b) {
               if (var2 == 1) {
                  var6.b++;
                  var6.d++;
               } else if (var2 == 2) {
                  var6.b--;
                  var6.d--;
               }
            }

            var8 = var1;
         } else if (var6.b <= var1) {
            if (var6.a == 1) {
               var8 = var1 - var6.d;
            } else {
               var8 = var1;
               if (var6.a == 2) {
                  var8 = var1 + var6.d;
               }
            }
         } else if (var2 == 1) {
            var6.b++;
            var8 = var1;
         } else {
            var8 = var1;
            if (var2 == 2) {
               var6.b--;
               var8 = var1;
            }
         }

         var4--;
         var1 = var8;
      }

      for (int var7 = this.b.size() - 1; var7 >= 0; var7--) {
         AdapterHelper.UpdateOp var9 = this.b.get(var7);
         if (var9.a == 8) {
            if (var9.d == var9.b || var9.d < 0) {
               this.b.remove(var7);
               this.a(var9);
            }
         } else if (var9.d <= 0) {
            this.b.remove(var7);
            this.a(var9);
         }
      }

      return var1;
   }

   private void d(AdapterHelper.UpdateOp var1) {
      int var4 = var1.b;
      int var8 = var1.b;
      int var9 = var1.d;
      int var2 = var1.b;
      byte var7 = -1;
      int var3 = 0;

      while (var2 < var8 + var9) {
         int var5;
         byte var11;
         if (this.c.a(var2) == null && !this.d(var2)) {
            int var14 = var3;
            var5 = var4;
            if (var7 == 1) {
               this.g(this.a(4, var4, var3, var1.c));
               var14 = 0;
               var5 = var2;
            }

            var4 = var5;
            var5 = var14;
            var11 = 0;
         } else {
            var5 = var3;
            int var6 = var4;
            if (var7 == 0) {
               this.e(this.a(4, var4, var3, var1.c));
               var5 = 0;
               var6 = var2;
            }

            var4 = var6;
            var11 = 1;
         }

         var2++;
         var5++;
         var7 = var11;
         var3 = var5;
      }

      AdapterHelper.UpdateOp var10 = var1;
      if (var3 != var1.d) {
         Object var15 = var1.c;
         this.a(var1);
         var10 = this.a(4, var4, var3, var15);
      }

      if (var7 == 0) {
         this.e(var10);
      } else {
         this.g(var10);
      }
   }

   private boolean d(int var1) {
      int var4 = this.b.size();
      int var2 = 0;

      boolean var7;
      while (true) {
         if (var2 >= var4) {
            var7 = false;
            break;
         }

         AdapterHelper.UpdateOp var8 = this.b.get(var2);
         if (var8.a == 8) {
            if (this.a(var8.d, var2 + 1) == var1) {
               var7 = true;
               break;
            }
         } else if (var8.a == 1) {
            int var6 = var8.b;
            int var5 = var8.d;

            for (int var3 = var8.b; var3 < var6 + var5; var3++) {
               if (this.a(var3, var2 + 1) == var1) {
                  var7 = true;
                  return var7;
               }
            }
         }

         var2++;
      }

      return var7;
   }

   private void e(AdapterHelper.UpdateOp var1) {
      if (var1.a != 1 && var1.a != 8) {
         int var6 = this.d(var1.b, var1.a);
         int var3 = var1.b;
         byte var4;
         switch (var1.a) {
            case 2:
               var4 = 0;
               break;
            case 3:
            default:
               throw new IllegalArgumentException("op should be remove or update." + var1);
            case 4:
               var4 = 1;
         }

         int var7 = 1;
         int var5 = 1;

         while (var5 < var1.d) {
            int var8 = this.d(var1.b + var4 * var5, var1.a);
            boolean var2;
            switch (var1.a) {
               case 2:
                  if (var8 == var6) {
                     var2 = 1;
                  } else {
                     var2 = 0;
                  }
                  break;
               case 3:
               default:
                  var2 = 0;
                  break;
               case 4:
                  if (var8 == var6 + 1) {
                     var2 = 1;
                  } else {
                     var2 = 0;
                  }
            }

            if (var2) {
               var2 = var7 + 1;
            } else {
               AdapterHelper.UpdateOp var9 = this.a(var1.a, var6, var7, var1.c);
               this.a(var9, var3);
               this.a(var9);
               var2 = var3;
               if (var1.a == 4) {
                  var2 = var3 + var7;
               }

               byte var13 = 1;
               var6 = var8;
               var3 = var2;
               var2 = var13;
            }

            var5++;
            var7 = var2;
         }

         Object var14 = var1.c;
         this.a(var1);
         if (var7 > 0) {
            var1 = this.a(var1.a, var6, var7, var14);
            this.a(var1, var3);
            this.a(var1);
         }
      } else {
         throw new IllegalArgumentException("should not dispatch add or move for pre layout");
      }
   }

   private void f(AdapterHelper.UpdateOp var1) {
      this.g(var1);
   }

   private void g(AdapterHelper.UpdateOp var1) {
      this.b.add(var1);
      switch (var1.a) {
         case 1:
            this.c.c(var1.b, var1.d);
            break;
         case 2:
            this.c.b(var1.b, var1.d);
            break;
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            throw new IllegalArgumentException("Unknown update op type for " + var1);
         case 4:
            this.c.a(var1.b, var1.d, var1.c);
            break;
         case 8:
            this.c.d(var1.b, var1.d);
      }
   }

   int a(int var1, int var2) {
      int var5 = this.b.size();
      int var4 = var2;
      var2 = var1;

      while (true) {
         var1 = var2;
         if (var4 >= var5) {
            break;
         }

         AdapterHelper.UpdateOp var6 = this.b.get(var4);
         if (var6.a == 8) {
            if (var6.b == var2) {
               var1 = var6.d;
            } else {
               int var3 = var2;
               if (var6.b < var2) {
                  var3 = var2 - 1;
               }

               var1 = var3;
               if (var6.d <= var3) {
                  var1 = var3 + 1;
               }
            }
         } else {
            var1 = var2;
            if (var6.b <= var2) {
               if (var6.a == 2) {
                  if (var2 < var6.b + var6.d) {
                     var1 = -1;
                     break;
                  }

                  var1 = var2 - var6.d;
               } else {
                  var1 = var2;
                  if (var6.a == 1) {
                     var1 = var2 + var6.d;
                  }
               }
            }
         }

         var4++;
         var2 = var1;
      }

      return var1;
   }

   @Override
   public AdapterHelper.UpdateOp a(int var1, int var2, int var3, Object var4) {
      AdapterHelper.UpdateOp var5 = this.g.a();
      if (var5 == null) {
         var4 = new AdapterHelper.UpdateOp(var1, var2, var3, var4);
      } else {
         var5.a = var1;
         var5.b = var2;
         var5.d = var3;
         var5.c = var4;
         var4 = var5;
      }

      return var4;
   }

   void a() {
      this.a(this.a);
      this.a(this.b);
      this.h = 0;
   }

   @Override
   public void a(AdapterHelper.UpdateOp var1) {
      if (!this.e) {
         var1.c = null;
         this.g.a(var1);
      }
   }

   void a(AdapterHelper.UpdateOp var1, int var2) {
      this.c.a(var1);
      switch (var1.a) {
         case 2:
            this.c.a(var2, var1.d);
            break;
         case 3:
         default:
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
         case 4:
            this.c.a(var2, var1.d, var1.c);
      }
   }

   void a(List<AdapterHelper.UpdateOp> var1) {
      int var3 = var1.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.a((AdapterHelper.UpdateOp)var1.get(var2));
      }

      var1.clear();
   }

   boolean a(int var1) {
      boolean var2;
      if ((this.h & var1) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   boolean a(int var1, int var2, int var3) {
      boolean var4 = false;
      boolean var5 = true;
      if (var1 != var2) {
         if (var3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
         }

         this.a.add(this.a(8, var1, var2, null));
         this.h |= 8;
         if (this.a.size() == 1) {
            var4 = var5;
         } else {
            var4 = false;
         }
      }

      return var4;
   }

   boolean a(int var1, int var2, Object var3) {
      boolean var5 = false;
      boolean var4 = true;
      if (var2 < 1) {
         var4 = var5;
      } else {
         this.a.add(this.a(4, var1, var2, var3));
         this.h |= 4;
         if (this.a.size() != 1) {
            var4 = false;
         }
      }

      return var4;
   }

   int b(int var1) {
      return this.a(var1, 0);
   }

   void b() {
      this.f.a(this.a);
      int var2 = this.a.size();

      for (int var1 = 0; var1 < var2; var1++) {
         AdapterHelper.UpdateOp var3 = this.a.get(var1);
         switch (var3.a) {
            case 1:
               this.f(var3);
               break;
            case 2:
               this.c(var3);
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               break;
            case 4:
               this.d(var3);
               break;
            case 8:
               this.b(var3);
         }

         if (this.d != null) {
            this.d.run();
         }
      }

      this.a.clear();
   }

   boolean b(int var1, int var2) {
      boolean var3 = false;
      boolean var4 = true;
      if (var2 >= 1) {
         this.a.add(this.a(1, var1, var2, null));
         this.h |= 1;
         if (this.a.size() == 1) {
            var3 = var4;
         } else {
            var3 = false;
         }
      }

      return var3;
   }

   public int c(int var1) {
      int var5 = this.a.size();
      int var4 = 0;
      int var2 = var1;

      while (true) {
         var1 = var2;
         if (var4 >= var5) {
            return var1;
         }

         AdapterHelper.UpdateOp var6 = this.a.get(var4);
         switch (var6.a) {
            case 1:
               var1 = var2;
               if (var6.b <= var2) {
                  var1 = var2 + var6.d;
               }
               break;
            case 2:
               var1 = var2;
               if (var6.b <= var2) {
                  if (var6.b + var6.d > var2) {
                     byte var9 = -1;
                     return var9;
                  }

                  var1 = var2 - var6.d;
               }
               break;
            case 8:
               if (var6.b == var2) {
                  var1 = var6.d;
               } else {
                  int var3 = var2;
                  if (var6.b < var2) {
                     var3 = var2 - 1;
                  }

                  var1 = var3;
                  if (var6.d <= var3) {
                     var1 = var3 + 1;
                  }
               }
               break;
            default:
               var1 = var2;
         }

         var4++;
         var2 = var1;
      }
   }

   void c() {
      int var2 = this.b.size();

      for (int var1 = 0; var1 < var2; var1++) {
         this.c.b(this.b.get(var1));
      }

      this.a(this.b);
      this.h = 0;
   }

   boolean c(int var1, int var2) {
      boolean var3 = false;
      boolean var4 = true;
      if (var2 >= 1) {
         this.a.add(this.a(2, var1, var2, null));
         this.h |= 2;
         if (this.a.size() == 1) {
            var3 = var4;
         } else {
            var3 = false;
         }
      }

      return var3;
   }

   boolean d() {
      boolean var1;
      if (this.a.size() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   void e() {
      this.c();
      int var2 = this.a.size();

      for (int var1 = 0; var1 < var2; var1++) {
         AdapterHelper.UpdateOp var3 = this.a.get(var1);
         switch (var3.a) {
            case 1:
               this.c.b(var3);
               this.c.c(var3.b, var3.d);
               break;
            case 2:
               this.c.b(var3);
               this.c.a(var3.b, var3.d);
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               break;
            case 4:
               this.c.b(var3);
               this.c.a(var3.b, var3.d, var3.c);
               break;
            case 8:
               this.c.b(var3);
               this.c.d(var3.b, var3.d);
         }

         if (this.d != null) {
            this.d.run();
         }
      }

      this.a(this.a);
      this.h = 0;
   }

   boolean f() {
      boolean var1;
      if (!this.b.isEmpty() && !this.a.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   interface Callback {
      RecyclerView.ViewHolder a(int var1);

      void a(int var1, int var2);

      void a(int var1, int var2, Object var3);

      void a(AdapterHelper.UpdateOp var1);

      void b(int var1, int var2);

      void b(AdapterHelper.UpdateOp var1);

      void c(int var1, int var2);

      void d(int var1, int var2);
   }

   static class UpdateOp {
      int a;
      int b;
      Object c;
      int d;

      UpdateOp(int var1, int var2, int var3, Object var4) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
         this.c = var4;
      }

      String a() {
         String var1;
         switch (this.a) {
            case 1:
               var1 = "add";
               break;
            case 2:
               var1 = "rm";
               break;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               var1 = "??";
               break;
            case 4:
               var1 = "up";
               break;
            case 8:
               var1 = "mv";
         }

         return var1;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = true;
         boolean var2;
         if (this == var1) {
            var2 = var3;
         } else if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.a != var1.a) {
               var2 = false;
            } else {
               if (this.a == 8 && Math.abs(this.d - this.b) == 1 && this.d == var1.b) {
                  var2 = var3;
                  if (this.b == var1.d) {
                     return var2;
                  }
               }

               if (this.d != var1.d) {
                  var2 = false;
               } else if (this.b != var1.b) {
                  var2 = false;
               } else if (this.c != null) {
                  var2 = var3;
                  if (!this.c.equals(var1.c)) {
                     var2 = false;
                  }
               } else {
                  var2 = var3;
                  if (var1.c != null) {
                     var2 = false;
                  }
               }
            }
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return (this.a * 31 + this.b) * 31 + this.d;
      }

      @Override
      public String toString() {
         return Integer.toHexString(System.identityHashCode(this)) + "[" + this.a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
      }
   }
}
