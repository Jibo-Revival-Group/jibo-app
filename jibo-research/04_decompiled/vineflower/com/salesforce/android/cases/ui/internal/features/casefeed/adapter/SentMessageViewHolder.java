package com.salesforce.android.cases.ui.internal.features.casefeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel.SentMessageModel;
import com.salesforce.android.service.common.ui.internal.messaging.GroupableView;

class SentMessageViewHolder extends RecyclerView.ViewHolder implements GroupableView {
   private TextView a;
   private TextView b;

   SentMessageViewHolder(View var1) {
      super(var1);
      this.a = (TextView)var1.findViewById(R.id.salesforce_sent_message_text);
      this.b = (TextView)var1.findViewById(R.id.salesforce_sent_message_timestamp);
   }

   @Override
   public void a() {
      this.b.setVisibility(8);
   }

   public void a(SentMessageModel var1) {
      this.a.setText(var1.a());
      if (var1.d() != null) {
         this.b.setText(DateFormat.getTimeFormat(this.itemView.getContext()).format(var1.d()));
      }
   }

   @Override
   public void b() {
      this.b.setVisibility(0);
   }
}
