package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
   private static TimeInterpolator i;
   ArrayList<ArrayList<RecyclerView.ViewHolder>> a;
   ArrayList<ArrayList<DefaultItemAnimator.MoveInfo>> b;
   ArrayList<ArrayList<DefaultItemAnimator.ChangeInfo>> c;
   ArrayList<RecyclerView.ViewHolder> d;
   ArrayList<RecyclerView.ViewHolder> e;
   ArrayList<RecyclerView.ViewHolder> f;
   ArrayList<RecyclerView.ViewHolder> g;
   private ArrayList<RecyclerView.ViewHolder> j = new ArrayList<>();
   private ArrayList<RecyclerView.ViewHolder> k = new ArrayList<>();
   private ArrayList<DefaultItemAnimator.MoveInfo> l = new ArrayList<>();
   private ArrayList<DefaultItemAnimator.ChangeInfo> m = new ArrayList<>();

   public DefaultItemAnimator() {
      this.a = new ArrayList<>();
      this.b = new ArrayList<>();
      this.c = new ArrayList<>();
      this.d = new ArrayList<>();
      this.e = new ArrayList<>();
      this.f = new ArrayList<>();
      this.g = new ArrayList<>();
   }

   private void a(List<DefaultItemAnimator.ChangeInfo> var1, RecyclerView.ViewHolder var2) {
      for (int var3 = var1.size() - 1; var3 >= 0; var3--) {
         DefaultItemAnimator.ChangeInfo var4 = (DefaultItemAnimator.ChangeInfo)var1.get(var3);
         if (this.a(var4, var2) && var4.a == null && var4.b == null) {
            var1.remove(var4);
         }
      }
   }

   private boolean a(DefaultItemAnimator.ChangeInfo var1, RecyclerView.ViewHolder var2) {
      boolean var4 = false;
      boolean var3 = false;
      if (var1.b == var2) {
         var1.b = null;
      } else {
         var3 = var4;
         if (var1.a != var2) {
            return var3;
         }

         var1.a = null;
         var3 = true;
      }

      var2.itemView.setAlpha(1.0F);
      var2.itemView.setTranslationX(0.0F);
      var2.itemView.setTranslationY(0.0F);
      this.a(var2, var3);
      return true;
   }

   private void b(DefaultItemAnimator.ChangeInfo var1) {
      if (var1.a != null) {
         this.a(var1, var1.a);
      }

      if (var1.b != null) {
         this.a(var1, var1.b);
      }
   }

   private void u(RecyclerView.ViewHolder var1) {
      View var2 = var1.itemView;
      ViewPropertyAnimator var3 = var2.animate();
      this.f.add(var1);
      var3.setDuration(this.g()).alpha(0.0F).setListener(new AnimatorListenerAdapter(this, var1, var3, var2) {
         final RecyclerView.ViewHolder a;
         final ViewPropertyAnimator b;
         final View c;
         final DefaultItemAnimator d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public void onAnimationEnd(Animator var1) {
            this.b.setListener(null);
            this.c.setAlpha(1.0F);
            this.d.i(this.a);
            this.d.f.remove(this.a);
            this.d.c();
         }

         public void onAnimationStart(Animator var1) {
            this.d.l(this.a);
         }
      }).start();
   }

   private void v(RecyclerView.ViewHolder var1) {
      if (i == null) {
         i = new ValueAnimator().getInterpolator();
      }

      var1.itemView.animate().setInterpolator(i);
      this.d(var1);
   }

   @Override
   public void a() {
      boolean var1;
      if (!this.j.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var2;
      if (!this.l.isEmpty()) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if (!this.m.isEmpty()) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4;
      if (!this.k.isEmpty()) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var1 || var2 || var4 || var3) {
         Iterator var11 = this.j.iterator();

         while (var11.hasNext()) {
            this.u((RecyclerView.ViewHolder)var11.next());
         }

         this.j.clear();
         if (var2) {
            ArrayList var12 = new ArrayList();
            var12.addAll(this.l);
            this.b.add(var12);
            this.l.clear();
            Runnable var14 = new Runnable(this, var12) {
               final ArrayList a;
               final DefaultItemAnimator b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  for (DefaultItemAnimator.MoveInfo var1x : this.a) {
                     this.b.b(var1x.a, var1x.b, var1x.c, var1x.d, var1x.e);
                  }

                  this.a.clear();
                  this.b.b.remove(this.a);
               }
            };
            if (var1) {
               ViewCompat.a(((DefaultItemAnimator.MoveInfo)var12.get(0)).a.itemView, var14, this.g());
            } else {
               var14.run();
            }
         }

         if (var3) {
            ArrayList var17 = new ArrayList();
            var17.addAll(this.m);
            this.c.add(var17);
            this.m.clear();
            Runnable var15 = new Runnable(this, var17) {
               final ArrayList a;
               final DefaultItemAnimator b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  for (DefaultItemAnimator.ChangeInfo var1 : this.a) {
                     this.b.a(var1);
                  }

                  this.a.clear();
                  this.b.c.remove(this.a);
               }
            };
            if (var1) {
               ViewCompat.a(((DefaultItemAnimator.ChangeInfo)var17.get(0)).a.itemView, var15, this.g());
            } else {
               var15.run();
            }
         }

         if (var4) {
            ArrayList var16 = new ArrayList();
            var16.addAll(this.k);
            this.a.add(var16);
            this.k.clear();
            Runnable var18 = new Runnable(this, var16) {
               final ArrayList a;
               final DefaultItemAnimator b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  for (RecyclerView.ViewHolder var2 : this.a) {
                     this.b.c(var2);
                  }

                  this.a.clear();
                  this.b.a.remove(this.a);
               }
            };
            if (!var1 && !var2 && !var3) {
               var18.run();
            } else {
               long var5;
               if (var1) {
                  var5 = this.g();
               } else {
                  var5 = 0L;
               }

               long var7;
               if (var2) {
                  var7 = this.e();
               } else {
                  var7 = 0L;
               }

               long var9;
               if (var3) {
                  var9 = this.h();
               } else {
                  var9 = 0L;
               }

               var7 = Math.max(var7, var9);
               ViewCompat.a(((RecyclerView.ViewHolder)var16.get(0)).itemView, var18, var5 + var7);
            }
         }
      }
   }

   void a(DefaultItemAnimator.ChangeInfo var1) {
      View var3 = null;
      RecyclerView.ViewHolder var2 = var1.a;
      View var5;
      if (var2 == null) {
         var5 = null;
      } else {
         var5 = var2.itemView;
      }

      RecyclerView.ViewHolder var4 = var1.b;
      if (var4 != null) {
         var3 = var4.itemView;
      }

      if (var5 != null) {
         ViewPropertyAnimator var7 = var5.animate().setDuration(this.h());
         this.g.add(var1.a);
         var7.translationX(var1.e - var1.c);
         var7.translationY(var1.f - var1.d);
         var7.alpha(0.0F).setListener(new AnimatorListenerAdapter(this, var1, var7, var5) {
            final DefaultItemAnimator.ChangeInfo a;
            final ViewPropertyAnimator b;
            final View c;
            final DefaultItemAnimator d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
            }

            public void onAnimationEnd(Animator var1) {
               this.b.setListener(null);
               this.c.setAlpha(1.0F);
               this.c.setTranslationX(0.0F);
               this.c.setTranslationY(0.0F);
               this.d.a(this.a.a, true);
               this.d.g.remove(this.a.a);
               this.d.c();
            }

            public void onAnimationStart(Animator var1) {
               this.d.b(this.a.a, true);
            }
         }).start();
      }

      if (var3 != null) {
         ViewPropertyAnimator var6 = var3.animate();
         this.g.add(var1.b);
         var6.translationX(0.0F).translationY(0.0F).setDuration(this.h()).alpha(1.0F).setListener(new AnimatorListenerAdapter(this, var1, var6, var3) {
            final DefaultItemAnimator.ChangeInfo a;
            final ViewPropertyAnimator b;
            final View c;
            final DefaultItemAnimator d;

            {
               this.d = var1;
               this.a = var2;
               this.b = var3;
               this.c = var4;
            }

            public void onAnimationEnd(Animator var1) {
               this.b.setListener(null);
               this.c.setAlpha(1.0F);
               this.c.setTranslationX(0.0F);
               this.c.setTranslationY(0.0F);
               this.d.a(this.a.b, false);
               this.d.g.remove(this.a.b);
               this.d.c();
            }

            public void onAnimationStart(Animator var1) {
               this.d.b(this.a.b, false);
            }
         }).start();
      }
   }

   void a(List<RecyclerView.ViewHolder> var1) {
      for (int var2 = var1.size() - 1; var2 >= 0; var2--) {
         ((RecyclerView.ViewHolder)var1.get(var2)).itemView.animate().cancel();
      }
   }

   @Override
   public boolean a(RecyclerView.ViewHolder var1) {
      this.v(var1);
      this.j.add(var1);
      return true;
   }

   @Override
   public boolean a(RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5) {
      View var9 = var1.itemView;
      var2 += (int)var1.itemView.getTranslationX();
      var3 += (int)var1.itemView.getTranslationY();
      this.v(var1);
      int var6 = var4 - var2;
      int var7 = var5 - var3;
      boolean var8;
      if (var6 == 0 && var7 == 0) {
         this.j(var1);
         var8 = false;
      } else {
         if (var6 != 0) {
            var9.setTranslationX(-var6);
         }

         if (var7 != 0) {
            var9.setTranslationY(-var7);
         }

         this.l.add(new DefaultItemAnimator.MoveInfo(var1, var2, var3, var4, var5));
         var8 = true;
      }

      return var8;
   }

   @Override
   public boolean a(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, int var3, int var4, int var5, int var6) {
      boolean var12;
      if (var1 == var2) {
         var12 = this.a(var1, var3, var4, var5, var6);
      } else {
         float var8 = var1.itemView.getTranslationX();
         float var9 = var1.itemView.getTranslationY();
         float var7 = var1.itemView.getAlpha();
         this.v(var1);
         int var11 = (int)(var5 - var3 - var8);
         int var10 = (int)(var6 - var4 - var9);
         var1.itemView.setTranslationX(var8);
         var1.itemView.setTranslationY(var9);
         var1.itemView.setAlpha(var7);
         if (var2 != null) {
            this.v(var2);
            var2.itemView.setTranslationX(-var11);
            var2.itemView.setTranslationY(-var10);
            var2.itemView.setAlpha(0.0F);
         }

         this.m.add(new DefaultItemAnimator.ChangeInfo(var1, var2, var3, var4, var5, var6));
         var12 = true;
      }

      return var12;
   }

   @Override
   public boolean a(RecyclerView.ViewHolder var1, List<Object> var2) {
      boolean var3;
      if (var2.isEmpty() && !super.a(var1, var2)) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   void b(RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5) {
      View var6 = var1.itemView;
      var2 = var4 - var2;
      var3 = var5 - var3;
      if (var2 != 0) {
         var6.animate().translationX(0.0F);
      }

      if (var3 != 0) {
         var6.animate().translationY(0.0F);
      }

      ViewPropertyAnimator var7 = var6.animate();
      this.e.add(var1);
      var7.setDuration(this.e()).setListener(new AnimatorListenerAdapter(this, var1, var2, var6, var3, var7) {
         final RecyclerView.ViewHolder a;
         final int b;
         final View c;
         final int d;
         final ViewPropertyAnimator e;
         final DefaultItemAnimator f;

         {
            this.f = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6x;
         }

         public void onAnimationCancel(Animator var1) {
            if (this.b != 0) {
               this.c.setTranslationX(0.0F);
            }

            if (this.d != 0) {
               this.c.setTranslationY(0.0F);
            }
         }

         public void onAnimationEnd(Animator var1) {
            this.e.setListener(null);
            this.f.j(this.a);
            this.f.e.remove(this.a);
            this.f.c();
         }

         public void onAnimationStart(Animator var1) {
            this.f.m(this.a);
         }
      }).start();
   }

   @Override
   public boolean b() {
      boolean var1;
      if (this.k.isEmpty()
         && this.m.isEmpty()
         && this.l.isEmpty()
         && this.j.isEmpty()
         && this.e.isEmpty()
         && this.f.isEmpty()
         && this.d.isEmpty()
         && this.g.isEmpty()
         && this.b.isEmpty()
         && this.a.isEmpty()
         && this.c.isEmpty()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   @Override
   public boolean b(RecyclerView.ViewHolder var1) {
      this.v(var1);
      var1.itemView.setAlpha(0.0F);
      this.k.add(var1);
      return true;
   }

   void c() {
      if (!this.b()) {
         this.i();
      }
   }

   void c(RecyclerView.ViewHolder var1) {
      View var3 = var1.itemView;
      ViewPropertyAnimator var2 = var3.animate();
      this.d.add(var1);
      var2.alpha(1.0F).setDuration(this.f()).setListener(new AnimatorListenerAdapter(this, var1, var3, var2) {
         final RecyclerView.ViewHolder a;
         final View b;
         final ViewPropertyAnimator c;
         final DefaultItemAnimator d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public void onAnimationCancel(Animator var1) {
            this.b.setAlpha(1.0F);
         }

         public void onAnimationEnd(Animator var1) {
            this.c.setListener(null);
            this.d.k(this.a);
            this.d.d.remove(this.a);
            this.d.c();
         }

         public void onAnimationStart(Animator var1) {
            this.d.n(this.a);
         }
      }).start();
   }

   @Override
   public void d() {
      for (int var1 = this.l.size() - 1; var1 >= 0; var1--) {
         DefaultItemAnimator.MoveInfo var4 = this.l.get(var1);
         View var3 = var4.a.itemView;
         var3.setTranslationY(0.0F);
         var3.setTranslationX(0.0F);
         this.j(var4.a);
         this.l.remove(var1);
      }

      for (int var6 = this.j.size() - 1; var6 >= 0; var6--) {
         this.i(this.j.get(var6));
         this.j.remove(var6);
      }

      for (int var7 = this.k.size() - 1; var7 >= 0; var7--) {
         RecyclerView.ViewHolder var14 = this.k.get(var7);
         var14.itemView.setAlpha(1.0F);
         this.k(var14);
         this.k.remove(var7);
      }

      for (int var8 = this.m.size() - 1; var8 >= 0; var8--) {
         this.b(this.m.get(var8));
      }

      this.m.clear();
      if (this.b()) {
         for (int var9 = this.b.size() - 1; var9 >= 0; var9--) {
            ArrayList var18 = this.b.get(var9);

            for (int var2 = var18.size() - 1; var2 >= 0; var2--) {
               DefaultItemAnimator.MoveInfo var5 = (DefaultItemAnimator.MoveInfo)var18.get(var2);
               View var15 = var5.a.itemView;
               var15.setTranslationY(0.0F);
               var15.setTranslationX(0.0F);
               this.j(var5.a);
               var18.remove(var2);
               if (var18.isEmpty()) {
                  this.b.remove(var18);
               }
            }
         }

         for (int var10 = this.a.size() - 1; var10 >= 0; var10--) {
            ArrayList var16 = this.a.get(var10);

            for (int var12 = var16.size() - 1; var12 >= 0; var12--) {
               RecyclerView.ViewHolder var19 = (RecyclerView.ViewHolder)var16.get(var12);
               var19.itemView.setAlpha(1.0F);
               this.k(var19);
               var16.remove(var12);
               if (var16.isEmpty()) {
                  this.a.remove(var16);
               }
            }
         }

         for (int var11 = this.c.size() - 1; var11 >= 0; var11--) {
            ArrayList var17 = this.c.get(var11);

            for (int var13 = var17.size() - 1; var13 >= 0; var13--) {
               this.b((DefaultItemAnimator.ChangeInfo)var17.get(var13));
               if (var17.isEmpty()) {
                  this.c.remove(var17);
               }
            }
         }

         this.a(this.f);
         this.a(this.e);
         this.a(this.d);
         this.a(this.g);
         this.i();
      }
   }

   @Override
   public void d(RecyclerView.ViewHolder var1) {
      View var4 = var1.itemView;
      var4.animate().cancel();

      for (int var2 = this.l.size() - 1; var2 >= 0; var2--) {
         if (this.l.get(var2).a == var1) {
            var4.setTranslationY(0.0F);
            var4.setTranslationX(0.0F);
            this.j(var1);
            this.l.remove(var2);
         }
      }

      this.a(this.m, var1);
      if (this.j.remove(var1)) {
         var4.setAlpha(1.0F);
         this.i(var1);
      }

      if (this.k.remove(var1)) {
         var4.setAlpha(1.0F);
         this.k(var1);
      }

      for (int var6 = this.c.size() - 1; var6 >= 0; var6--) {
         ArrayList var5 = this.c.get(var6);
         this.a(var5, var1);
         if (var5.isEmpty()) {
            this.c.remove(var6);
         }
      }

      for (int var7 = this.b.size() - 1; var7 >= 0; var7--) {
         ArrayList var9 = this.b.get(var7);

         for (int var3 = var9.size() - 1; var3 >= 0; var3--) {
            if (((DefaultItemAnimator.MoveInfo)var9.get(var3)).a == var1) {
               var4.setTranslationY(0.0F);
               var4.setTranslationX(0.0F);
               this.j(var1);
               var9.remove(var3);
               if (var9.isEmpty()) {
                  this.b.remove(var7);
               }
               break;
            }
         }
      }

      for (int var8 = this.a.size() - 1; var8 >= 0; var8--) {
         ArrayList var10 = this.a.get(var8);
         if (var10.remove(var1)) {
            var4.setAlpha(1.0F);
            this.k(var1);
            if (var10.isEmpty()) {
               this.a.remove(var8);
            }
         }
      }

      if (this.f.remove(var1)) {
      }

      if (this.d.remove(var1)) {
      }

      if (this.g.remove(var1)) {
      }

      if (this.e.remove(var1)) {
      }

      this.c();
   }

   private static class ChangeInfo {
      public RecyclerView.ViewHolder a;
      public RecyclerView.ViewHolder b;
      public int c;
      public int d;
      public int e;
      public int f;

      private ChangeInfo(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2) {
         this.a = var1;
         this.b = var2;
      }

      ChangeInfo(RecyclerView.ViewHolder var1, RecyclerView.ViewHolder var2, int var3, int var4, int var5, int var6) {
         this(var1, var2);
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
      }

      @Override
      public String toString() {
         return "ChangeInfo{oldHolder="
            + this.a
            + ", newHolder="
            + this.b
            + ", fromX="
            + this.c
            + ", fromY="
            + this.d
            + ", toX="
            + this.e
            + ", toY="
            + this.f
            + '}';
      }
   }

   private static class MoveInfo {
      public RecyclerView.ViewHolder a;
      public int b;
      public int c;
      public int d;
      public int e;

      MoveInfo(RecyclerView.ViewHolder var1, int var2, int var3, int var4, int var5) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
      }
   }
}
