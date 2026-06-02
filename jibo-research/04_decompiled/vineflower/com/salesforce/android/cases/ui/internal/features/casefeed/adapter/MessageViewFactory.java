package com.salesforce.android.cases.ui.internal.features.casefeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel.HorizontalRuleModel;
import com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel.ReceivedMessageModel;
import com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel.SentMessageModel;
import com.salesforce.android.service.common.ui.internal.messaging.ViewHolderFactory;

public class MessageViewFactory implements ViewHolderFactory {
   private final int a = 1;
   private final int b = 2;
   private final int c = 3;

   @Override
   public int a(Object var1) {
      byte var2;
      if (var1 instanceof ReceivedMessageModel) {
         var2 = 1;
      } else if (var1 instanceof SentMessageModel) {
         var2 = 2;
      } else {
         if (!(var1 instanceof HorizontalRuleModel)) {
            throw new IllegalStateException("Unknown message item type: " + var1.getClass().getCanonicalName());
         }

         var2 = 3;
      }

      return var2;
   }

   @Override
   public RecyclerView.ViewHolder a(ViewGroup var1, int var2, LayoutInflater var3) {
      RecyclerView.ViewHolder var4;
      if (var2 == 1) {
         var4 = new ReceivedMessageViewHolder(var3.inflate(R.layout.salesforce_message_received, var1, false));
      } else if (var2 == 2) {
         var4 = new SentMessageViewHolder(var3.inflate(R.layout.salesforce_message_sent, var1, false));
      } else {
         if (var2 != 3) {
            throw new IllegalArgumentException("Unknown viewType: " + var2);
         }

         var4 = new HorizontalRuleViewHolder(var3.inflate(R.layout.salesforce_message_horizontal_rule, var1, false));
      }

      return var4;
   }

   @Override
   public void a(RecyclerView.ViewHolder var1, int var2, Object var3) {
      if (var2 == 1) {
         ReceivedMessageModel var4 = (ReceivedMessageModel)var3;
         ((ReceivedMessageViewHolder)var1).a(var4);
      } else if (var2 == 2) {
         SentMessageModel var5 = (SentMessageModel)var3;
         ((SentMessageViewHolder)var1).a(var5);
      } else if (var2 == 3) {
         HorizontalRuleModel var6 = (HorizontalRuleModel)var3;
         ((HorizontalRuleViewHolder)var1).a(var6);
      }
   }
}
