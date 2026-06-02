package com.salesforce.android.cases.ui.internal.features.casefeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel.HorizontalRuleModel;

class HorizontalRuleViewHolder extends RecyclerView.ViewHolder {
   private TextView a;

   HorizontalRuleViewHolder(View var1) {
      super(var1);
      this.a = (TextView)var1.findViewById(R.id.salesforce_horizontal_rule_text);
   }

   public void a(HorizontalRuleModel var1) {
      this.a.setText(var1.a());
   }
}
