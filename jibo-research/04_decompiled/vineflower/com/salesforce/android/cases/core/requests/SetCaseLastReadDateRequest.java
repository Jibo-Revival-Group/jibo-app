package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.SaveRequestBuilder;
import java.util.Date;

public class SetCaseLastReadDateRequest extends SaveRequest {
   private final String a;
   private final Date b;

   public SetCaseLastReadDateRequest(SetCaseLastReadDateRequest.SetCaseLastReadDateRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
      this.b = var1.b;
   }

   public static SetCaseLastReadDateRequest a(String var0, Date var1) {
      return new SetCaseLastReadDateRequest.SetCaseLastReadDateRequestBuilder(var0, var1).a(true).b(false).e();
   }

   public String c() {
      return this.a;
   }

   public Date d() {
      return this.b;
   }

   public static class SetCaseLastReadDateRequestBuilder extends SaveRequestBuilder<SetCaseLastReadDateRequest.SetCaseLastReadDateRequestBuilder> {
      private final String a;
      private final Date b;

      public SetCaseLastReadDateRequestBuilder(String var1, Date var2) {
         this.a = var1;
         this.b = var2;
      }

      protected SetCaseLastReadDateRequest.SetCaseLastReadDateRequestBuilder d() {
         return this;
      }

      public SetCaseLastReadDateRequest e() {
         return new SetCaseLastReadDateRequest(this);
      }
   }
}
