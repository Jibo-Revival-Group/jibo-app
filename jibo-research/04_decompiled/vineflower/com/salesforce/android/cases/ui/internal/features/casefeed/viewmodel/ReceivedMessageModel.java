package com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel;

import com.salesforce.android.service.common.ui.internal.messaging.MultiActorMessage;
import java.util.Date;

public class ReceivedMessageModel implements MultiActorMessage {
   private final String a;
   private final String b;
   private final String c;
   private final Date d;

   ReceivedMessageModel(String var1, String var2, String var3, Date var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   @Override
   public Date d() {
      return this.d;
   }

   @Override
   public String e() {
      return this.c();
   }
}
