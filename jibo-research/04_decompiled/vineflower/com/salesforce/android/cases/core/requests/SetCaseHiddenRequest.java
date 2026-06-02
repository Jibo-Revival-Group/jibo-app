package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.SaveRequestBuilder;

public class SetCaseHiddenRequest extends SaveRequest {
   private final String a;
   private final boolean b;

   public SetCaseHiddenRequest(SetCaseHiddenRequest.SetCaseHiddenRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
      this.b = var1.b;
   }

   public static SetCaseHiddenRequest a(String var0, boolean var1) {
      return new SetCaseHiddenRequest.SetCaseHiddenRequestBuilder(var0, var1).a(true).b(false).e();
   }

   public String c() {
      return this.a;
   }

   public boolean d() {
      return this.b;
   }

   public static class SetCaseHiddenRequestBuilder extends SaveRequestBuilder<SetCaseHiddenRequest.SetCaseHiddenRequestBuilder> {
      private final String a;
      private final boolean b;

      public SetCaseHiddenRequestBuilder(String var1, boolean var2) {
         this.a = var1;
         this.b = var2;
      }

      protected SetCaseHiddenRequest.SetCaseHiddenRequestBuilder d() {
         return this;
      }

      public SetCaseHiddenRequest e() {
         return new SetCaseHiddenRequest(this);
      }
   }
}
