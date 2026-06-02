package com.jibo.ui.fragment.avatar;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jibo.utils.ImageUtils;

public class AvatarViewHolder extends RecyclerView.ViewHolder {
   @BindView
   public ImageView avatar;

   public AvatarViewHolder(View var1) {
      super(var1);
      ButterKnife.a(this, var1);
   }

   public void a(int var1, boolean var2) {
      this.avatar.setImageLevel(var1);
      if (var2) {
         Drawable var3 = ImageUtils.a(this.itemView.getContext(), 2131231008, new int[]{2131099771, 2131099807, 2131099873, 2131099768}[var1 % 4]);
         this.itemView.setBackground(var3);
      } else {
         this.itemView.setBackgroundResource(0);
      }

      this.itemView.setTag(var1);
   }
}
