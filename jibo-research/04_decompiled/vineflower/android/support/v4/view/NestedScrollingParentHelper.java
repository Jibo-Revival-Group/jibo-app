package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {
   private final ViewGroup a;
   private int b;

   public NestedScrollingParentHelper(ViewGroup var1) {
      this.a = var1;
   }

   public int a() {
      return this.b;
   }

   public void a(View var1) {
      this.a(var1, 0);
   }

   public void a(View var1, int var2) {
      this.b = 0;
   }

   public void a(View var1, View var2, int var3) {
      this.a(var1, var2, var3, 0);
   }

   public void a(View var1, View var2, int var3, int var4) {
      this.b = var3;
   }
}
