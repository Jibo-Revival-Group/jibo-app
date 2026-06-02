package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
   private ArrayList<Transition> g = new ArrayList<>();
   private boolean h = true;
   private int i;
   private boolean j = false;

   public TransitionSet() {
   }

   public TransitionSet(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, Styleable.i);
      this.a(TypedArrayUtils.a(var3, (XmlResourceParser)var2, "transitionOrdering", 0, 0));
      var3.recycle();
   }

   private void q() {
      TransitionSet.TransitionSetListener var1 = new TransitionSet.TransitionSetListener(this);
      Iterator var2 = this.g.iterator();

      while (var2.hasNext()) {
         ((Transition)var2.next()).a(var1);
      }

      this.i = this.g.size();
   }

   public TransitionSet a(int var1) {
      switch (var1) {
         case 0:
            this.h = true;
            break;
         case 1:
            this.h = false;
            break;
         default:
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + var1);
      }

      return this;
   }

   public TransitionSet a(View var1) {
      for (int var2 = 0; var2 < this.g.size(); var2++) {
         this.g.get(var2).c(var1);
      }

      return (TransitionSet)super.c(var1);
   }

   @Override
   String a(String var1) {
      String var3 = super.a(var1);

      for (int var2 = 0; var2 < this.g.size(); var2++) {
         var3 = var3 + "\n" + this.g.get(var2).a(var1 + "  ");
      }

      return var3;
   }

   @Override
   public void a(Transition.EpicenterCallback var1) {
      super.a(var1);
      int var3 = this.g.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.g.get(var2).a(var1);
      }
   }

   @Override
   public void a(TransitionPropagation var1) {
      super.a(var1);
      int var3 = this.g.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.g.get(var2).a(var1);
      }
   }

   @Override
   public void a(TransitionValues var1) {
      if (this.b(var1.b)) {
         for (Transition var2 : this.g) {
            if (var2.b(var1.b)) {
               var2.a(var1);
               var1.c.add(var2);
            }
         }
      }
   }

   @Override
   protected void a(ViewGroup var1, TransitionValuesMaps var2, TransitionValuesMaps var3, ArrayList<TransitionValues> var4, ArrayList<TransitionValues> var5) {
      long var10 = this.c();
      int var7 = this.g.size();

      for (int var6 = 0; var6 < var7; var6++) {
         Transition var12 = this.g.get(var6);
         if (var10 > 0L && (this.h || var6 == 0)) {
            long var8 = var12.c();
            if (var8 > 0L) {
               var12.b(var8 + var10);
            } else {
               var12.b(var10);
            }
         }

         var12.a(var1, var2, var3, var4, var5);
      }
   }

   public Transition b(int var1) {
      Transition var2;
      if (var1 >= 0 && var1 < this.g.size()) {
         var2 = this.g.get(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   public TransitionSet b(TimeInterpolator var1) {
      return (TransitionSet)super.a(var1);
   }

   public TransitionSet b(Transition var1) {
      this.g.add(var1);
      var1.d = this;
      if (this.a >= 0L) {
         var1.a(this.a);
      }

      return this;
   }

   @Override
   public void b(TransitionValues var1) {
      if (this.b(var1.b)) {
         for (Transition var2 : this.g) {
            if (var2.b(var1.b)) {
               var2.b(var1);
               var1.c.add(var2);
            }
         }
      }
   }

   public TransitionSet c(long var1) {
      super.a(var1);
      if (this.a >= 0L) {
         int var4 = this.g.size();

         for (int var3 = 0; var3 < var4; var3++) {
            this.g.get(var3).a(var1);
         }
      }

      return this;
   }

   public TransitionSet c(Transition.TransitionListener var1) {
      return (TransitionSet)super.a(var1);
   }

   @Override
   void c(TransitionValues var1) {
      super.c(var1);
      int var3 = this.g.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.g.get(var2).c(var1);
      }
   }

   public TransitionSet d(long var1) {
      return (TransitionSet)super.b(var1);
   }

   public TransitionSet d(Transition.TransitionListener var1) {
      return (TransitionSet)super.b(var1);
   }

   @Override
   protected void e() {
      if (this.g.isEmpty()) {
         this.j();
         this.k();
      } else {
         this.q();
         if (!this.h) {
            for (int var1 = 1; var1 < this.g.size(); var1++) {
               this.g.get(var1 - 1).a(new TransitionListenerAdapter(this, this.g.get(var1)) {
                  final Transition a;
                  final TransitionSet b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  @Override
                  public void a(Transition var1) {
                     this.a.e();
                     var1.b(this);
                  }
               });
            }

            Transition var2 = this.g.get(0);
            if (var2 != null) {
               var2.e();
            }
         } else {
            Iterator var3 = this.g.iterator();

            while (var3.hasNext()) {
               ((Transition)var3.next()).e();
            }
         }
      }
   }

   @Override
   public void e(View var1) {
      super.e(var1);
      int var3 = this.g.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.g.get(var2).e(var1);
      }
   }

   @Override
   public void f(View var1) {
      super.f(var1);
      int var3 = this.g.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.g.get(var2).f(var1);
      }
   }

   public TransitionSet g(View var1) {
      for (int var2 = 0; var2 < this.g.size(); var2++) {
         this.g.get(var2).d(var1);
      }

      return (TransitionSet)super.d(var1);
   }

   @Override
   public Transition n() {
      TransitionSet var3 = (TransitionSet)super.n();
      var3.g = new ArrayList<>();
      int var2 = this.g.size();

      for (int var1 = 0; var1 < var2; var1++) {
         var3.b(this.g.get(var1).n());
      }

      return var3;
   }

   public int p() {
      return this.g.size();
   }

   static class TransitionSetListener extends TransitionListenerAdapter {
      TransitionSet a;

      TransitionSetListener(TransitionSet var1) {
         this.a = var1;
      }

      @Override
      public void a(Transition var1) {
         TransitionSet.b(this.a);
         if (this.a.i == 0) {
            this.a.j = false;
            this.a.k();
         }

         var1.b(this);
      }

      @Override
      public void d(Transition var1) {
         if (!this.a.j) {
            this.a.j();
            this.a.j = true;
         }
      }
   }
}
