package com.salesforce.android.knowledge.ui.internal.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.models.DataCategoryInfo;

class CategoryHeaderViewHolder extends RecyclerView.ViewHolder {
   final HomePresenter a;
   final TextView b;
   final ImageView c;
   final ImageView d;

   private CategoryHeaderViewHolder(View var1, HomePresenter var2) {
      super(var1);
      this.a = var2;
      this.b = (TextView)this.itemView.findViewById(R.id.knowledge_category_name);
      this.c = (ImageView)this.itemView.findViewById(R.id.knowledge_category_image);
      this.d = (ImageView)this.itemView.findViewById(R.id.knowledge_icon_dropdown);
      this.d.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
         final CategoryHeaderViewHolder a;

         {
            this.a = var1;
         }

         public void onLayoutChange(View var1, int var2x, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
            this.a.d.setPivotX((var4 - var2x) / 2);
            this.a.d.setPivotX((var5 - var3) / 2);
         }
      });
   }

   public static CategoryHeaderViewHolder a(View var0, HomePresenter var1) {
      return new CategoryHeaderViewHolder(var0, var1);
   }

   public Context a() {
      return this.itemView.getContext();
   }

   public void a(Context var1, DataCategoryInfo var2) {
      this.b.setText(var2.b());
      this.c.setImageDrawable(var2.a(var1));
      boolean var4 = this.a.c(var2);
      ImageView var5 = this.d;
      float var3;
      if (var4) {
         var3 = 180.0F;
      } else {
         var3 = 0.0F;
      }

      var5.setRotation(var3);
      this.itemView.setBackgroundColor(var2.d());
      this.itemView.setOnClickListener(new OnClickListener(this, var2) {
         final DataCategoryInfo a;
         final CategoryHeaderViewHolder b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void onClick(View var1) {
            this.b.a.a(this.a);
         }
      });
   }

   public void a(boolean var1) {
      ImageView var3 = this.d;
      float var2;
      if (var1) {
         var2 = 180.0F;
      } else {
         var2 = 0.0F;
      }

      RotateAnimation.a(var3, var2);
   }
}
