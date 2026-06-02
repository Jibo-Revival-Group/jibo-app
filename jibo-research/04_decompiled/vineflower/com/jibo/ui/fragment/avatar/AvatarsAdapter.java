package com.jibo.ui.fragment.avatar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class AvatarsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private int a = 0;
   private OnClickListener b;
   private int c;

   public AvatarsAdapter(int var1, int var2, OnClickListener var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void a(int var1) {
      this.a = var1;
   }

   @Override
   public int getItemCount() {
      return 12;
   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      var1 = var1;
      boolean var3;
      if (var2 == this.a) {
         var3 = true;
      } else {
         var3 = false;
      }

      var1.a(var2, var3);
   }

   @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      View var4 = LayoutInflater.from(var1.getContext()).inflate(this.c, var1, false);
      AvatarViewHolder var3 = new AvatarViewHolder(var4);
      var4.setOnClickListener(this.b);
      return var3;
   }
}
