package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
   private int j;
   private int k;
   private LayoutInflater l;

   @Deprecated
   public ResourceCursorAdapter(Context var1, int var2, Cursor var3, boolean var4) {
      super(var1, var3, var4);
      this.k = var2;
      this.j = var2;
      this.l = (LayoutInflater)var1.getSystemService("layout_inflater");
   }

   @Override
   public View a(Context var1, Cursor var2, ViewGroup var3) {
      return this.l.inflate(this.j, var3, false);
   }

   @Override
   public View b(Context var1, Cursor var2, ViewGroup var3) {
      return this.l.inflate(this.k, var3, false);
   }
}
