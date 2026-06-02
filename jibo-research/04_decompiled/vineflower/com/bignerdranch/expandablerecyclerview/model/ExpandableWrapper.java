package com.bignerdranch.expandablerecyclerview.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExpandableWrapper<P extends Parent<C>, C> {
   private P a;
   private C b;
   private boolean c;
   private boolean d;
   private List<ExpandableWrapper<P, C>> e;

   public ExpandableWrapper(P var1) {
      this.a = (P)var1;
      this.c = true;
      this.d = false;
      this.e = this.a((P)var1);
   }

   public ExpandableWrapper(C var1) {
      this.b = (C)var1;
      this.c = false;
      this.d = false;
   }

   private List<ExpandableWrapper<P, C>> a(P var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.a().iterator();

      while (var3.hasNext()) {
         var2.add(new ExpandableWrapper<>(var3.next()));
      }

      return var2;
   }

   public P a() {
      return this.a;
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   public C b() {
      return this.b;
   }

   public boolean c() {
      return this.d;
   }

   public boolean d() {
      return this.c;
   }

   public List<ExpandableWrapper<P, C>> e() {
      if (!this.c) {
         throw new IllegalStateException("Parent not wrapped");
      } else {
         return this.e;
      }
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.a != null ? this.a.equals(var1.a) : var1.a == null) {
               if (this.b != null) {
                  var2 = this.b.equals(var1.b);
               } else if (var1.b != null) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.a != null) {
         var1 = this.a.hashCode();
      } else {
         var1 = 0;
      }

      if (this.b != null) {
         var2 = this.b.hashCode();
      }

      return var1 * 31 + var2;
   }
}
