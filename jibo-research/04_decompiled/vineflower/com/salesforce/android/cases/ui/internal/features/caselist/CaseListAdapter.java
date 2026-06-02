package com.salesforce.android.cases.ui.internal.features.caselist;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import java.util.ArrayList;
import java.util.List;

abstract class CaseListAdapter extends RecyclerView.Adapter<CaseListAdapter.ViewHolder> {
   private LayoutInflater a;
   private List<CaseListItemViewModel> b;

   CaseListAdapter(Context var1) {
      this.a = LayoutInflater.from(var1);
      this.b = new ArrayList<>();
   }

   public CaseListAdapter.ViewHolder a(ViewGroup var1, int var2) {
      CaseListAdapter.ViewHolder var3 = new CaseListAdapter.ViewHolder(this, this.a.inflate(R.layout.case_list_item, var1, false));
      var3.itemView.setOnClickListener(new OnClickListener(this, var3) {
         final CaseListAdapter.ViewHolder a;
         final CaseListAdapter b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void onClick(View var1) {
            int var2x = this.a.getAdapterPosition();
            if (var2x != -1) {
               this.b.a(this.b.b.get(var2x));
            }
         }
      });
      return var3;
   }

   CaseListItemViewModel a(int var1) {
      CaseListItemViewModel var2;
      if (var1 < this.b.size() && var1 >= 0) {
         var2 = this.b.get(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   public void a(CaseListAdapter.ViewHolder var1, int var2) {
      var1.a(this.b.get(var2));
   }

   abstract void a(CaseListItemViewModel var1);

   void a(CaseListItemViewModel var1, int var2) {
      this.b.add(var2, var1);
      this.notifyItemInserted(var2);
   }

   void a(List<CaseListItemViewModel> var1) {
      DiffUtil.a(new CaseListDiffCallback(this.b, var1)).a(this);
      this.b = new ArrayList<>(var1);
   }

   void b(CaseListItemViewModel var1) {
      int var2 = this.b.indexOf(var1);
      if (var2 >= 0) {
         this.b.set(var2, var1);
         this.notifyItemChanged(var2);
      }
   }

   void c(CaseListItemViewModel var1) {
      int var2 = this.b.indexOf(var1);
      if (var2 >= 0) {
         this.b.remove(var2);
         this.notifyItemRemoved(var2);
      }
   }

   @Override
   public int getItemCount() {
      return this.b.size();
   }

   class ViewHolder extends RecyclerView.ViewHolder {
      TextView a;
      TextView b;
      TextView c;
      ImageView d;
      final CaseListAdapter e;

      ViewHolder(CaseListAdapter var1, View var2) {
         super(var2);
         this.e = var1;
         this.a = (TextView)var2.findViewById(R.id.case_time);
         this.b = (TextView)var2.findViewById(R.id.case_subject);
         this.c = (TextView)var2.findViewById(R.id.case_message);
         this.d = (ImageView)var2.findViewById(R.id.unread_indicator);
      }

      void a(CaseListItemViewModel var1) {
         byte var2 = 0;
         this.a.setText(var1.d());
         this.b.setText(var1.e());
         if (StringUtils.b(var1.f())) {
            this.c.setText(StringUtils.d(var1.f()));
            this.c.setVisibility(0);
         } else {
            this.c.setVisibility(8);
         }

         ImageView var3 = this.d;
         if (!var1.b()) {
            var2 = 4;
         }

         var3.setVisibility(var2);
      }
   }
}
