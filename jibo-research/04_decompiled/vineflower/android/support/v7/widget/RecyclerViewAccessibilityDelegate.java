package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
   final RecyclerView a;
   final AccessibilityDelegateCompat c;

   public RecyclerViewAccessibilityDelegate(RecyclerView var1) {
      this.a = var1;
      this.c = new RecyclerViewAccessibilityDelegate.ItemDelegate(this);
   }

   @Override
   public void a(View var1, AccessibilityNodeInfoCompat var2) {
      super.a(var1, var2);
      var2.b(RecyclerView.class.getName());
      if (!this.b() && this.a.getLayoutManager() != null) {
         this.a.getLayoutManager().a(var2);
      }
   }

   @Override
   public void a(View var1, AccessibilityEvent var2) {
      super.a(var1, var2);
      var2.setClassName(RecyclerView.class.getName());
      if (var1 instanceof RecyclerView && !this.b()) {
         RecyclerView var3 = (RecyclerView)var1;
         if (var3.getLayoutManager() != null) {
            var3.getLayoutManager().a(var2);
         }
      }
   }

   @Override
   public boolean a(View var1, int var2, Bundle var3) {
      boolean var4;
      if (super.a(var1, var2, var3)) {
         var4 = true;
      } else if (!this.b() && this.a.getLayoutManager() != null) {
         var4 = this.a.getLayoutManager().a(var2, var3);
      } else {
         var4 = false;
      }

      return var4;
   }

   boolean b() {
      return this.a.hasPendingAdapterUpdates();
   }

   public AccessibilityDelegateCompat c() {
      return this.c;
   }

   public static class ItemDelegate extends AccessibilityDelegateCompat {
      final RecyclerViewAccessibilityDelegate a;

      public ItemDelegate(RecyclerViewAccessibilityDelegate var1) {
         this.a = var1;
      }

      @Override
      public void a(View var1, AccessibilityNodeInfoCompat var2) {
         super.a(var1, var2);
         if (!this.a.b() && this.a.a.getLayoutManager() != null) {
            this.a.a.getLayoutManager().a(var1, var2);
         }
      }

      @Override
      public boolean a(View var1, int var2, Bundle var3) {
         boolean var4;
         if (super.a(var1, var2, var3)) {
            var4 = true;
         } else if (!this.a.b() && this.a.a.getLayoutManager() != null) {
            var4 = this.a.a.getLayoutManager().a(var1, var2, var3);
         } else {
            var4 = false;
         }

         return var4;
      }
   }
}
