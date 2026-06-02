package com.bignerdranch.expandablerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.model.ExpandableWrapper;
import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class ExpandableRecyclerAdapter<P extends Parent<C>, C, PVH extends ParentViewHolder, CVH extends ChildViewHolder>
   extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   protected List<ExpandableWrapper<P, C>> a;
   private List<P> b;
   private ExpandableRecyclerAdapter.ExpandCollapseListener c;
   private List<RecyclerView> d;
   private Map<P, Boolean> e;
   private ParentViewHolder.ParentViewHolderExpandCollapseListener f = new ParentViewHolder.ParentViewHolderExpandCollapseListener(this) {
      final ExpandableRecyclerAdapter a;

      {
         this.a = var1;
      }

      @Override
      public void a(int var1) {
         this.a.c(var1);
      }

      @Override
      public void b(int var1) {
         this.a.d(var1);
      }
   };

   public ExpandableRecyclerAdapter(List<P> var1) {
      this.b = var1;
      this.a = this.a(var1);
      this.d = new ArrayList<>();
      this.e = new HashMap<>(this.b.size());
   }

   private List<ExpandableWrapper<P, C>> a(List<P> var1) {
      ArrayList var4 = new ArrayList();
      int var3 = var1.size();

      for (int var2 = 0; var2 < var3; var2++) {
         Parent var5 = (Parent)var1.get(var2);
         this.a(var4, (P)var5, var5.b());
      }

      return var4;
   }

   private void a(ExpandableWrapper<P, C> var1, int var2) {
      Iterator var4 = this.d.iterator();

      while (var4.hasNext()) {
         ParentViewHolder var3 = (ParentViewHolder)((RecyclerView)var4.next()).findViewHolderForAdapterPosition(var2);
         if (var3 != null && var3.b()) {
            var3.a(false);
            var3.b(true);
         }
      }

      this.b(var1, var2, false);
   }

   private void a(ExpandableWrapper<P, C> var1, int var2, boolean var3) {
      if (!var1.c()) {
         var1.a(true);
         this.e.put((P)var1.a(), true);
         List var6 = var1.e();
         if (var6 != null) {
            int var5 = var6.size();

            for (int var4 = 0; var4 < var5; var4++) {
               this.a.add(var2 + var4 + 1, (ExpandableWrapper<P, C>)var6.get(var4));
            }

            this.notifyItemRangeInserted(var2 + 1, var5);
         }

         if (var3 && this.c != null) {
            this.c.a(this.f(var2));
         }
      }
   }

   private void a(List<ExpandableWrapper<P, C>> var1, ExpandableWrapper<P, C> var2) {
      var2.a(true);
      List var5 = var2.e();
      int var4 = var5.size();

      for (int var3 = 0; var3 < var4; var3++) {
         var1.add((ExpandableWrapper)var5.get(var3));
      }
   }

   private void a(List<ExpandableWrapper<P, C>> var1, P var2, boolean var3) {
      ExpandableWrapper var4 = new ExpandableWrapper((P)var2);
      var1.add(var4);
      if (var3) {
         this.a(var1, var4);
      }
   }

   private void b(ExpandableWrapper<P, C> var1, int var2, boolean var3) {
      if (var1.c()) {
         var1.a(false);
         this.e.put((P)var1.a(), false);
         List var6 = var1.e();
         if (var6 != null) {
            int var5 = var6.size();

            for (int var4 = var5 - 1; var4 >= 0; var4--) {
               this.a.remove(var2 + var4 + 1);
            }

            this.notifyItemRangeRemoved(var2 + 1, var5);
         }

         if (var3 && this.c != null) {
            this.c.b(this.f(var2));
         }
      }
   }

   public int a(int var1) {
      return 0;
   }

   public int a(int var1, int var2) {
      return 1;
   }

   public abstract PVH a(ViewGroup var1, int var2);

   public List<P> a() {
      return this.b;
   }

   public abstract void a(CVH var1, int var2, int var3, C var4);

   public abstract void a(PVH var1, int var2, P var3);

   public void a(P var1) {
      ExpandableWrapper var3 = new ExpandableWrapper((P)var1);
      int var2 = this.a.indexOf(var3);
      if (var2 != -1) {
         this.a(this.a.get(var2), var2);
      }
   }

   public abstract CVH b(ViewGroup var1, int var2);

   public void b() {
      Iterator var1 = this.b.iterator();

      while (var1.hasNext()) {
         this.a((P)var1.next());
      }
   }

   public boolean b(int var1) {
      boolean var2;
      if (var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   protected void c(int var1) {
      this.a(this.a.get(var1), var1, true);
   }

   protected void d(int var1) {
      this.b(this.a.get(var1), var1, true);
   }

   public void e(int var1) {
      this.a(this.b.get(var1));
   }

   int f(int var1) {
      int var4 = 0;
      if (var1 != 0) {
         int var3 = 0;
         int var2 = -1;

         while (true) {
            var4 = var2;
            if (var3 > var1) {
               break;
            }

            if (this.a.get(var3).d()) {
               var2++;
            }

            var3++;
         }
      }

      return var4;
   }

   int g(int var1) {
      int var2 = 0;
      if (var1 == 0) {
         var1 = var2;
      } else {
         int var3 = 0;
         var2 = 0;

         while (var3 < var1) {
            if (this.a.get(var3).d()) {
               var2 = 0;
            } else {
               var2++;
            }

            var3++;
         }

         var1 = var2;
      }

      return var1;
   }

   @Override
   public int getItemCount() {
      return this.a.size();
   }

   @Override
   public int getItemViewType(int var1) {
      if (this.a.get(var1).d()) {
         var1 = this.a(this.f(var1));
      } else {
         var1 = this.a(this.f(var1), this.g(var1));
      }

      return var1;
   }

   @Override
   public void onAttachedToRecyclerView(RecyclerView var1) {
      super.onAttachedToRecyclerView(var1);
      this.d.add(var1);
   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      if (var2 > this.a.size()) {
         throw new IllegalStateException(
            "Trying to bind item out of bounds, size " + this.a.size() + " flatPosition " + var2 + ". Was the data changed without a call to notify...()?"
         );
      }

      ExpandableWrapper var3 = this.a.get(var2);
      if (var3.d()) {
         ParentViewHolder var4 = (ParentViewHolder)var1;
         if (var4.c()) {
            var4.a();
         }

         var4.a(var3.c());
         var4.a = (P)var3.a();
         this.a((PVH)var4, this.f(var2), (P)var3.a());
      } else {
         ChildViewHolder var5 = (ChildViewHolder)var1;
         var5.a = (C)var3.b();
         this.a((CVH)var5, this.f(var2), this.g(var2), (C)var3.b());
      }
   }

   @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      RecyclerView.ViewHolder var3;
      if (this.b(var2)) {
         var3 = this.a(var1, var2);
         var3.a(this.f);
         var3.b = this;
      } else {
         var3 = this.b(var1, var2);
         var3.b = this;
      }

      return var3;
   }

   @Override
   public void onDetachedFromRecyclerView(RecyclerView var1) {
      super.onDetachedFromRecyclerView(var1);
      this.d.remove(var1);
   }

   public interface ExpandCollapseListener {
      void a(int var1);

      void b(int var1);
   }
}
