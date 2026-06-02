package com.jibo.ui.fragment.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.ViewHolders;
import java.util.ArrayList;
import java.util.List;

public class OptionsBottomSheetDialog extends BottomSheetDialog {
   private String b;
   private int[] c;
   private String[] d;
   private OnClickListener e;

   public OptionsBottomSheetDialog(Context var1) {
      super(var1);
   }

   private void a(DialogInterface var1, int var2) {
      if (this.e != null) {
         this.e.onClick(var1, var2);
      }
   }

   private void a(View var1) {
      if (!TextUtils.isEmpty(this.b)) {
         ((TextView)var1.findViewById(2131297037)).setText(this.b);
      } else {
         var1.findViewById(2131297037).setVisibility(8);
      }
   }

   private void b(View var1) {
      ArrayList var4 = new ArrayList();

      for (int var2 = 0; var2 < this.c.length; var2++) {
         var4.add(new Items.IconTextItem(Items.ItemType.dialog_bottom_sheet_item, new android.view.View.OnClickListener(this, var2) {
            final int a;
            final OptionsBottomSheetDialog b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onClick(View var1) {
               this.b.a(this.b, this.a);
            }
         }, this.c[var2], this.d[var2]));
      }

      OptionsBottomSheetDialog.BottomSheetAdapter var3 = new OptionsBottomSheetDialog.BottomSheetAdapter();
      var3.a(var4);
      RecyclerView var5 = (RecyclerView)var1.findViewById(2131296834);
      var5.setHasFixedSize(true);
      var5.setItemAnimator(new DefaultItemAnimator());
      var5.setLayoutManager(new LinearLayoutManager(this.getContext()));
      var5.setAdapter(var3);
   }

   public void a(OnClickListener var1) {
      this.e = var1;
   }

   public void a(String var1) {
      this.b = var1;
   }

   public void a(int[] var1) {
      this.c = var1;
   }

   public void a(String[] var1) {
      this.d = var1;
   }

   public void c() {
      ConstraintLayout var1 = (ConstraintLayout)LayoutInflater.from(this.getContext()).inflate(2131427400, null);
      this.a(var1);
      this.b(var1);
      this.setContentView(var1);
   }

   static class BottomSheetAdapter extends RecyclerView.Adapter<ViewHolders.AbstractViewHolder> {
      private List<Items.Item> a = new ArrayList<>();

      public ViewHolders.AbstractViewHolder a(ViewGroup var1, int var2) {
         Items.ItemType var3 = Items.ItemType.values()[var2];
         return new ViewHolders.OptionsBottomSheetDialogViewHolder(LayoutInflater.from(var1.getContext()).inflate(var3.getLayoutId(), var1, false));
      }

      public void a(ViewHolders.AbstractViewHolder var1, int var2) {
         var1.setData(this.a.get(var2));
      }

      public void a(List<Items.Item> var1) {
         this.a.clear();
         this.a.addAll(var1);
         this.notifyDataSetChanged();
      }

      @Override
      public int getItemCount() {
         int var1;
         if (this.a == null) {
            var1 = 0;
         } else {
            var1 = this.a.size();
         }

         return var1;
      }

      @Override
      public int getItemViewType(int var1) {
         return this.a.get(var1).getItemType().ordinal();
      }
   }
}
