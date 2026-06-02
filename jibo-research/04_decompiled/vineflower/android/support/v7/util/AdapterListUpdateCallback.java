package android.support.v7.util;

import android.support.v7.widget.RecyclerView;

public final class AdapterListUpdateCallback implements ListUpdateCallback {
   private final RecyclerView.Adapter a;

   public AdapterListUpdateCallback(RecyclerView.Adapter var1) {
      this.a = var1;
   }

   @Override
   public void a(int var1, int var2) {
      this.a.notifyItemRangeInserted(var1, var2);
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      this.a.notifyItemRangeChanged(var1, var2, var3);
   }

   @Override
   public void b(int var1, int var2) {
      this.a.notifyItemRangeRemoved(var1, var2);
   }

   @Override
   public void c(int var1, int var2) {
      this.a.notifyItemMoved(var1, var2);
   }
}
