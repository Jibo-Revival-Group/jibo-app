package com.salesforce.android.cases.ui.internal.features.casefeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel.ReceivedMessageModel;
import com.salesforce.android.service.common.ui.internal.messaging.GroupableView;

class ReceivedMessageViewHolder extends RecyclerView.ViewHolder implements GroupableView {
   private TextView a;
   private TextView b;
   private TextView c;
   private View d;
   private View e;

   ReceivedMessageViewHolder(View var1) {
      super(var1);
      this.a = (TextView)var1.findViewById(R.id.salesforce_received_message_text);
      this.b = (TextView)var1.findViewById(R.id.salesforce_received_message_agent_name);
      this.c = (TextView)var1.findViewById(R.id.salesforce_received_message_timestamp);
      this.d = var1.findViewById(R.id.salesforce_agent_avatar_container);
      this.e = var1.findViewById(R.id.salesforce_received_message_footer);
   }

   @Override
   public void a() {
      this.e.setVisibility(8);
      this.d.setVisibility(4);
   }

   public void a(ReceivedMessageModel var1) {
      this.a.setText(var1.a());
      this.b.setText(var1.b());
      if (var1.d() != null) {
         this.c.setText(DateFormat.getTimeFormat(this.itemView.getContext()).format(var1.d()));
      }
   }

   @Override
   public void b() {
      this.e.setVisibility(0);
      this.d.setVisibility(0);
   }
}
