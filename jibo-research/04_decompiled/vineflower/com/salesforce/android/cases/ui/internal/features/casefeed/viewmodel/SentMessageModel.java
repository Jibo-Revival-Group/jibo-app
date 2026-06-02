package com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel;

import com.salesforce.android.service.common.ui.internal.messaging.Message;
import java.util.Date;

public class SentMessageModel implements Message {
   private final String a;
   private final Date b;

   public SentMessageModel(String var1, Date var2) {
      this.a = var1;
      this.b = var2;
   }

   public String a() {
      return this.a;
   }

   @Override
   public Date d() {
      return this.b;
   }
}
